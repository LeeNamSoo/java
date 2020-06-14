package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import uTill.ReturnListFromDBUtil;

public class DataBase {
	private static DataBase db;
	private String id = "root"; // ����� ����
	private String pw = "dlskatn147"; // ����� ������ �н�����
	private Connection conn = null; // null�� �ʱ�ȭ
	private PreparedStatement pstmt = null;
	private String url = "jdbc:mysql://localhost:3306/guitar?useSSL=false";
	// ����Ϸ��� �����ͺ��̽����� ���

	private DataBase() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver" Ŭ������ �޸𸮿� �ε�ȴ�.JDBC Driver �ڵ�����
			conn = (Connection) DriverManager.getConnection(url, id, pw); // DriverManager
			// ��ü�κ��� Connection ��ü�� ���´�.
			System.out.println("����� ����Ǿ����ϴ�."); // Ŀ�ؼ��� ����� ����Ǹ� ����ȴ�.

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("����ȵǾ����ϴ�.");
		}
	}

	// TODO ���ڵ� �߰� �޼ҵ�
	public static DataBase getInstance() {
		if (db == null) {// �ִ��� üũ ������
			db = new DataBase(); // �����ѵ�
		}
		return db;// ������ ��ü�� �ѱ��.
	}

	public List guitarSelectRecord(Map property) {
		List returnRecord = null;
		try {
			// sql ���� : �˻�
			String sql = "SELECT * FROM instrument.guitar where " + "numstring = ? " + "AND model = ? "
					+ "AND type = ? " + "And builder = ? " + "AND backwood = ? " + "AND topwood = ?";
			// prepareStatement���� �ش� sql�� �̸� �������Ͽ� Ʋ�� �̸� �����س��� ���� ���߿� ����.
			pstmt = (PreparedStatement) conn.prepareStatement(sql); //preparedStatement ����

			pstmt.setString(1, (String) property.get("numstring")); //�ʿ��� �� ����
			pstmt.setString(2, (String) property.get("model"));
			pstmt.setString(3, (String) property.get("type"));
			pstmt.setString(4, (String) property.get("builder"));
			pstmt.setString(5, (String) property.get("backwood"));
			pstmt.setString(6, (String) property.get("topwood"));

			ResultSet rs = pstmt.executeQuery(); // ������ �����Ѵ�.

			returnRecord = ReturnListFromDBUtil.getList(rs);

			System.out.println("Guitar ���̺��� �˻��� �Ϸ� �߽��ϴ�."); // ������ �޽���

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("Guitar ���̺��� �˻��� ���� �߽��ϴ�.");
		}


		return returnRecord;
	}

	public void guitarInsertRecord(Map property) {
		try {
			// sql ����
			String sql = "INSERT INTO guitar (numstring, model, type, builder, backwood, topwood, serialnum, price)"
					+ "value (?, ? , ?, ?, ?, ?, ?, ?)";
			// prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("numstring"));
			pstmt.setString(2, (String) property.get("model"));
			pstmt.setString(3, (String) property.get("type"));
			pstmt.setString(4, (String) property.get("builder"));
			pstmt.setString(5, (String) property.get("backwood"));
			pstmt.setString(6, (String) property.get("topwood"));
			pstmt.setString(7, (String) property.get("serialnum"));
			pstmt.setString(8, (String) property.get("price"));

			pstmt.executeUpdate(); // ������ �����Ѵ�.

			System.out.println("guitar ���̺� ���ο� ���ڵ带 �߰��߽��ϴ�."); // ������ �޽���

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("guitar ���̺� ���ο� ���ڵ� �߰��� �����߽��ϴ�.");
		}

	}

	public void guitarDeleteRecord(Map property) {
		try {
			// sql ����
			String sql = "DELETE FROM guitar where " + "serialnum = ?";

			// prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("serialnum"));

			pstmt.executeUpdate(); // ������ �����Ѵ�.

			System.out.println("guitar ���̺� ���� ��ȣ : " + (String) property.get("serialnum") + " �� ��Ÿ�� ���� �߽��ϴ�."); // ������
																													// �޽���

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("guitar ���̺� ���� ��ȣ : " + (String) property.get("serialnum") + " �� ��Ÿ�� �������� �� �߽��ϴ�.");
		}

	}

	public List mandolinSelectRecord(Map property) {
		List returnRecord = null;
		try {
			// sql ����
			String sql = "SELECT * FROM mandolin where "  + " model = ? "
					+ "AND style = ? " + "And builder = ? " + "AND backwood = ? " + "AND topwood = ?";
			// prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("model"));
			pstmt.setString(2, (String) property.get("style"));
			pstmt.setString(3, (String) property.get("builder"));
			pstmt.setString(4, (String) property.get("backwood"));
			pstmt.setString(5, (String) property.get("topwood"));

			ResultSet rs = pstmt.executeQuery(); // ������ �����Ѵ�.

			returnRecord = ReturnListFromDBUtil.getList(rs);

			System.out.println("mandolin ���̺��� �˻��� �Ϸ� �߽��ϴ�."); // ������ �޽���

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("mandolin ���̺��� �˻��� ���� �߽��ϴ�.");
		}


		return returnRecord;
	}

	public void mandolinInsertRecord(Map property) {
		try {
			// sql ����
			String sql = "INSERT INTO mandolin (model, style, builder, backwood, topwood, serialnum, price)"
					+ "value (?, ? , ?, ?, ?, ?, ?)";
			// prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("model"));
			pstmt.setString(2, (String) property.get("style"));
			pstmt.setString(3, (String) property.get("builder"));
			pstmt.setString(4, (String) property.get("backwood"));
			pstmt.setString(5, (String) property.get("topwood"));
			pstmt.setString(6, (String) property.get("serialnum"));
			pstmt.setString(7, (String) property.get("price"));

			pstmt.executeUpdate(); // ������ �����Ѵ�.

			System.out.println("mandolin ���̺� ���ο� ���ڵ带 �߰��߽��ϴ�."); // ������ �޽���

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("mandolin ���̺� ���ο� ���ڵ� �߰��� �����߽��ϴ�.");
		}
	
	}

	public void mandolinDeleteRecord(Map property) {
		try {
			// sql ����
			String sql = "DELETE FROM mandolin where " + "serialnum = ?";

			// prepareStatement���� �ش� sql�� �̸� �������Ѵ�.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("serialnum"));

			pstmt.executeUpdate(); // ������ �����Ѵ�.

			System.out.println("mandolin ���̺� ���� ��ȣ : " + (String) property.get("serialnum") + " �� ��Ÿ�� ���� �߽��ϴ�."); // ������
																													// �޽���

		} catch (Exception e) { // ���ܰ� �߻��ϸ� ���� ��Ȳ�� ó���Ѵ�.
			e.printStackTrace();
			System.out.println("mandolin ���̺� ���� ��ȣ : " + (String) property.get("serialnum") + " �� ��Ÿ�� �������� �� �߽��ϴ�.");
		}

	}
}






