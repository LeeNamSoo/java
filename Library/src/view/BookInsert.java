package view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

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
@WebServlet("/bookinsert")
public class BookInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookInsert() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/bookinsert.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);
		int code = -1;
		code = Integer.parseInt(request.getParameter("code"));
		String name = (String) request.getParameter("title");
		String author = (String) request.getParameter("author");
		String img = null;
		String publisher = (String) request.getParameter("publisher");
		String location = (String) request.getParameter("location");
//		String year = request.getParameter("year");
//		String day = request.getParameter("day");
//		String month = request.getParameter("month");

		Date rentaled_date = null;
		Date returned_date = null;
		int contact = 0;

//		contact = Integer.parseInt(contactStr);
//		birth = transformDate(year, month, day);

		Book book = new Book(code, name, author, img, publisher, location, rentaled_date, returned_date);
		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character
		String regex = "\\w+";

		if (code == -1) {
			errorString = "id invalid!";
		}

		if (errorString == null) {
			try {
				DBUtils.insertBook(conn, book);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("book", book);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/bookinsert.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/main");
		}
	}

	public Date transformDate(String year, String month, String day) {
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);
		return d;
	}

}
