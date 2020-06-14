package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.MyUtils;
import db.DBUtils;
import model.Book;

/**
 * Servlet implementation class Login
 */
@WebServlet("/booksearch")
public class BookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookSearch() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		String keyword = (String) request.getParameter("word");

		ArrayList<Book> list = new ArrayList<>();

		String errorString = null;

		if (errorString == null) {
			try {
				list = DBUtils.queryBook(conn, keyword);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("searchList", list);

		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/booksearch.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("bookdelete_post");
		Connection conn = MyUtils.getStoredConnection(request);
		int[] code;
		System.out.println("request.getParameter(\"subject\") : " + request.getParameter("subject"));
		String[] codestr = request.getParameterValues("subject");
		code = new int[codestr.length];
		for (int i = 0; i < codestr.length; i++) {
			code[i] = Integer.parseInt(codestr[i]);
		}

		int contact = 0;

		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character

		if (code == null) {
			errorString = "id invalid!";
		}

		if (errorString == null) {
			try {
				for (int i = 0; i < code.length; i++) {
					DBUtils.deleteBook(conn, code[i]);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
//		request.setAttribute("book", book);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/booksearch.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
//		-----------------------------------------
//		System.out.println("post 방식으로 요청");
//		
//		doGet(request, response);
//		response.sendRedirect(request.getContextPath() + "/bookdelete");
	}

}
