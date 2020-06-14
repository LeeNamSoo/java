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
import model.User;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/signin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MyUtils.getStoredConnection(request);

		String id = (String) request.getParameter("id");
		String password = (String) request.getParameter("password");
		String name = (String) request.getParameter("name");
		
		String gender = request.getParameter("gender");
		
		String contactStr = (String) request.getParameter("contact");		
		String email = (String) request.getParameter("email");
		String address = (String) request.getParameter("address");
		
		String year = request.getParameter("year");
		String day = request.getParameter("day");
		String month = request.getParameter("month");
		
		Date birth = null;
		int contact = 0;
		
		
		
		contact = Integer.parseInt(contactStr);
		birth = transformDate(year, month, day);
		
		User user = new User(id, password, name, birth, gender, contact, email, address);
		String errorString = null;

		// Product ID is the string literal [a-zA-Z_0-9]
		// with at least 1 character
		String regex = "\\w+";

		if (id == null || !id.matches(regex)) {
			errorString = "id invalid!";
		}

		if (errorString == null) {
			try {
				DBUtils.insertUser(conn, user);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		// Store infomation to request attribute, before forward to views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("user", user);

		// If error, forward to Edit page.
		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/main.jsp");
			dispatcher.forward(request, response);
		}
		// If everything nice.
		// Redirect to the product listing page.
		else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	public Date transformDate(String year, String month, String day) {
		String date = year + "-" + month + "-" + day;
		Date d = Date.valueOf(date);

		return d;
	
	}

}
