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
			System.out.println("����̹� ���� ����!");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/guitar" + "?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
					"root", "dlskatn147");


			System.out.println("�����ͺ��̽� ���� ����");
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
			System.out.println("�������");
			pstmt.execute();
			System.out.println(i);
			pstmt.close();
//			stmt.close();
			conn.close();
			System.out.println("�ڷ��߰�����");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ڷ��߰�����");
		}
	}

	public void readDatabase() {

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * from guitarspec";
			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				// ���ڵ��� Į���� �迭�� �޸� 0���� �������� �ʰ� 1���� �����Ѵ�.
				// �����ͺ��̽����� �������� �������� Ÿ�Կ� �°� getString �Ǵ� getInt ���� ȣ���Ѵ�.
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
			System.out.println("���� " + e);
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
//+ "," + spec.getTopWood() + ")"; // sql ����

//stmt = conn.createStatement();
//rset = stmt.executeQuery("select * from user");

//int count = pstmt.executeUpdate();
//if( count == 0 ){
//    System.out.println("������ �Է� ����");
//}
//else{
//    System.out.println("������ �Է� ����");
//}
