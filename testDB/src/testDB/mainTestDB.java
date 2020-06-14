package testDB;

import java.sql.*;

public class mainTestDB {

	public static void main(String[] args) {
		try {
			// jdbc:mysql://<database server
			// ip>:3306/databaseName?allowPublicKeyRetrieval=true
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 연결 성공!");

			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/guitar" + "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					"root", "dlskatn147");
			System.out.println("데이터베이스 연결 성공");
			Statement stmt = conn.createStatement();
			ResultSet rset = null;
			while (rset.next()) {
//				System.out.println(rset.getInt(1)+" "+ rset.getString(2)+" "+rset.getString(6));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





//update user set Password=Password('05ghcjfl') where User='smadeco' and Host='%';