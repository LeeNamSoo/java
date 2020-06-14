package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.User;

public class DBUtils {

	public static User findUser(Connection conn, String id, String password) throws SQLException {

		String sql = "Select * from user a " + " where a.id = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String name = rs.getString("name");
			Date birth = rs.getDate("birth");
			String gender = rs.getString("gender");
			int contact = rs.getInt("contact");
			String email = rs.getString("email");
			String address = rs.getString("address");

			User user = new User();
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setContact(contact);
			user.setEmail(email);

			return user;
		}
		return null;
	}

	public static User findUser(Connection conn, String id) throws SQLException {

		String sql = "Select * from user a "//
				+ " where a.id = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String name = rs.getString("name");
			Date birth = rs.getDate("birth");
			String gender = rs.getString("gender");
			int contact = rs.getInt("contact");
			String email = rs.getString("email");
			String address = rs.getString("address");
			System.out.println("¼¼¹øÂ°" + address);

			User user = new User();

			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setContact(contact);
			user.setEmail(email);
			user.setAddress(address);

			return user;
		}
		return null;
	}

	public static void insertUser(Connection conn, User user) throws SQLException {
		String sql = "Insert into user(id, password, name, birth, gender, contact, email, address) values (?,?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getId());
		pstm.setString(2, user.getPassword());
		pstm.setString(3, user.getName());
		pstm.setDate(4, user.getBirth());
		pstm.setString(5, user.getGender());
		pstm.setInt(6, user.getContact());
		pstm.setString(7, user.getEmail());
		pstm.setString(8, user.getAddress());

		pstm.executeUpdate();
	}

	public static void updateUser(Connection conn, User user, String id) throws SQLException {
		String sql = "Update user set password= ?, contact= ?, address= ?, email= ? where id= '" + id + "'";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getPassword());
		pstm.setInt(2, user.getContact());
		pstm.setString(3, user.getAddress());
		pstm.setString(4, user.getEmail());

		pstm.executeUpdate();
	}

	public static List<User> queryUser(Connection conn) throws SQLException {
		String sql = "Select * from user a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<User> list = new ArrayList<User>();
		while (rs.next()) {
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			Date birth = rs.getDate("birth");
			String gender = rs.getString("gender");
			int contact = rs.getInt("contact");
			String email = rs.getString("email");
			String address = rs.getString("address");

			User user = new User();

			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setContact(contact);
			user.setEmail(email);
			user.setAddress(address);

			list.add(user);
		}
		return list;
	}

	public static void insertBook(Connection conn, Book book) throws SQLException {
		System.out.println("insertbook");
		String sql = "Insert into book(b_code, b_name, b_author, b_img, rental_date, return_date, b_publisher, b_location)"
				+ " values (?,?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, book.getcode());
		pstm.setString(2, book.getTitle());
		pstm.setString(3, book.getAuthor());
		pstm.setString(4, book.getAuthor());
		pstm.setDate(5, book.getRentaled_date());
		pstm.setDate(6, book.getReturned_date());
		pstm.setString(7, book.getPublisher());
		pstm.setString(8, book.getLocation());

		pstm.executeUpdate();
	}

	public static ArrayList<Book> queryBook(Connection conn, String searchingbook) throws SQLException {

		String SQL = "Select * from book where b_author like '%" + searchingbook + "%'";

		PreparedStatement pstm = conn.prepareStatement(SQL);
		ArrayList<Book> list = new ArrayList<Book>();
		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			int code = rs.getInt("b_code");
			String title = rs.getString("b_name");
			String img = rs.getString("b_img");
			String author = rs.getString("b_author");
			Date rentaled_date = rs.getDate("rental_date");
			Date returned_date = rs.getDate("return_date");
			String publisher = rs.getString("b_publisher");
			String location = rs.getString("b_location");

			Book book = new Book();
			book.setcode(code);
			book.setTitle(title);
			book.setAuthor(author);
			book.setImg(img);
			book.setRentaled_date(rentaled_date);
			book.setReturned_date(returned_date);
			book.setPublisher(publisher);
			book.setLocation(location);

			list.add(book);
		}
		return list;
	}

	public static void deleteBook(Connection conn, int code) throws SQLException {
		System.out.println("deletebook");
		String sql = "Delete From book where b_code = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setInt(1, code);

		pstm.executeUpdate();

	}

}