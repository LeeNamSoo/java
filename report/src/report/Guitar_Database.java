package report;

import java.sql.*;

import report.GuitarSpec;

public class Guitar_Database {

	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt;
	ResultSet rset;
	int i = 0;

	public Guitar_Database() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 연결 성공!");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/guitar" + "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					"root", "dlskatn147");


			System.out.println("데이터베이스 연결 성공");
			stmt = conn.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void creatDatabase(String serialNumber, double price, GuitarSpec spec) {
		try {

//			String sql = "INSERT INTO guitarspec (serialNumber, price, builder, model, type, stringnum, backwood, topwood) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			String sql = "INSERT INTO guitarspec" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setDouble(2, price);
			pstmt.setString(3, spec.getBuilder());
			pstmt.setString(4, spec.getModel());
			pstmt.setString(5, spec.getType());
			pstmt.setInt(6, spec.getNumStrings());
			pstmt.setString(7, spec.getBackWood());
			pstmt.setString(8, spec.getTopWood());
			System.out.println("여기까지");
			pstmt.execute();
			System.out.println(i);
			pstmt.close();
//			stmt.close();
			conn.close();
			System.out.println("자료추가성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("자료추가실패");
		}
	}

	public void readDatabase() {

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * from guitarspec";
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				// 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
				// 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
				String serialNumber = rset.getString(1);
				String price = rset.getString(2);
				String builder = rset.getString(3);
				String model = rset.getString(4);
				String type = rset.getString(5);
				String stringnum = rset.getString(6);
				String backwood = rset.getString(7);
				String topwood = rset.getString(8);

				
			}
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rset != null && !rset.isClosed()) {
					rset.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateDatabase() {

	}

	public void deleteDatabase() {

	}

}

//String sql = "insert into guitarspec values(" + serialNumber + "," + price + "," + spec.getBuilder() + ","
//+ spec.getModel() + "," + spec.getType() + "," + spec.getNumStrings() + "," + spec.getBackWood()
//+ "," + spec.getTopWood() + ")"; // sql 쿼리

//stmt = conn.createStatement();
//rset = stmt.executeQuery("select * from user");

//int count = pstmt.executeUpdate();
//if( count == 0 ){
//    System.out.println("데이터 입력 실패");
//}
//else{
//    System.out.println("데이터 입력 성공");
//}
