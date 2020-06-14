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
	private String id = "root"; // 사용자 계정
	private String pw = "dlskatn147"; // 사용자 계정의 패스워드
	private Connection conn = null; // null로 초기화
	private PreparedStatement pstmt = null;
	private String url = "jdbc:mysql://localhost:3306/guitar?useSSL=false";
	// 사용하려는 데이터베이스명을 기술

	private DataBase() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.jdbc.Driver");//com.mysql.jdbc.Driver" 클래스가 메모리에 로드된다.JDBC Driver 자동연결
			conn = (Connection) DriverManager.getConnection(url, id, pw); // DriverManager
			// 객체로부터 Connection 객체를 얻어온다.
			System.out.println("제대로 연결되었습니다."); // 커넥션이 제대로 연결되면 수행된다.

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("연결안되었습니다.");
		}
	}

	// TODO 레코드 추가 메소드
	public static DataBase getInstance() {
		if (db == null) {// 있는지 체크 없으면
			db = new DataBase(); // 생성한뒤
		}
		return db;// 생성한 객체를 넘긴다.
	}

	public List guitarSelectRecord(Map property) {
		List returnRecord = null;
		try {
			// sql 쿼리 : 검색
			String sql = "SELECT * FROM instrument.guitar where " + "numstring = ? " + "AND model = ? "
					+ "AND type = ? " + "And builder = ? " + "AND backwood = ? " + "AND topwood = ?";
			// prepareStatement에서 해당 sql을 미리 컴파일하여 틀을 미리 생성해놓고 값은 나중에 지정.
			pstmt = (PreparedStatement) conn.prepareStatement(sql); //preparedStatement 생성

			pstmt.setString(1, (String) property.get("numstring")); //필요한 값 지정
			pstmt.setString(2, (String) property.get("model"));
			pstmt.setString(3, (String) property.get("type"));
			pstmt.setString(4, (String) property.get("builder"));
			pstmt.setString(5, (String) property.get("backwood"));
			pstmt.setString(6, (String) property.get("topwood"));

			ResultSet rs = pstmt.executeQuery(); // 쿼리를 실행한다.

			returnRecord = ReturnListFromDBUtil.getList(rs);

			System.out.println("Guitar 테이블에서 검색을 완료 했습니다."); // 성공시 메시지

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("Guitar 테이블에서 검색을 실패 했습니다.");
		}


		return returnRecord;
	}

	public void guitarInsertRecord(Map property) {
		try {
			// sql 쿼리
			String sql = "INSERT INTO guitar (numstring, model, type, builder, backwood, topwood, serialnum, price)"
					+ "value (?, ? , ?, ?, ?, ?, ?, ?)";
			// prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("numstring"));
			pstmt.setString(2, (String) property.get("model"));
			pstmt.setString(3, (String) property.get("type"));
			pstmt.setString(4, (String) property.get("builder"));
			pstmt.setString(5, (String) property.get("backwood"));
			pstmt.setString(6, (String) property.get("topwood"));
			pstmt.setString(7, (String) property.get("serialnum"));
			pstmt.setString(8, (String) property.get("price"));

			pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("guitar 테이블에 새로운 레코드를 추가했습니다."); // 성공시 메시지

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("guitar 테이블에 새로운 레코드 추가에 실패했습니다.");
		}

	}

	public void guitarDeleteRecord(Map property) {
		try {
			// sql 쿼리
			String sql = "DELETE FROM guitar where " + "serialnum = ?";

			// prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("serialnum"));

			pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("guitar 테이블에 고유 번호 : " + (String) property.get("serialnum") + " 인 기타를 삭제 했습니다."); // 성공시
																													// 메시지

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("guitar 테이블에 고유 번호 : " + (String) property.get("serialnum") + " 인 기타를 삭제하지 못 했습니다.");
		}

	}

	public List mandolinSelectRecord(Map property) {
		List returnRecord = null;
		try {
			// sql 쿼리
			String sql = "SELECT * FROM mandolin where "  + " model = ? "
					+ "AND style = ? " + "And builder = ? " + "AND backwood = ? " + "AND topwood = ?";
			// prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("model"));
			pstmt.setString(2, (String) property.get("style"));
			pstmt.setString(3, (String) property.get("builder"));
			pstmt.setString(4, (String) property.get("backwood"));
			pstmt.setString(5, (String) property.get("topwood"));

			ResultSet rs = pstmt.executeQuery(); // 쿼리를 실행한다.

			returnRecord = ReturnListFromDBUtil.getList(rs);

			System.out.println("mandolin 테이블에서 검색을 완료 했습니다."); // 성공시 메시지

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("mandolin 테이블에서 검색을 실패 했습니다.");
		}


		return returnRecord;
	}

	public void mandolinInsertRecord(Map property) {
		try {
			// sql 쿼리
			String sql = "INSERT INTO mandolin (model, style, builder, backwood, topwood, serialnum, price)"
					+ "value (?, ? , ?, ?, ?, ?, ?)";
			// prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("model"));
			pstmt.setString(2, (String) property.get("style"));
			pstmt.setString(3, (String) property.get("builder"));
			pstmt.setString(4, (String) property.get("backwood"));
			pstmt.setString(5, (String) property.get("topwood"));
			pstmt.setString(6, (String) property.get("serialnum"));
			pstmt.setString(7, (String) property.get("price"));

			pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("mandolin 테이블에 새로운 레코드를 추가했습니다."); // 성공시 메시지

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("mandolin 테이블에 새로운 레코드 추가에 실패했습니다.");
		}
	
	}

	public void mandolinDeleteRecord(Map property) {
		try {
			// sql 쿼리
			String sql = "DELETE FROM mandolin where " + "serialnum = ?";

			// prepareStatement에서 해당 sql을 미리 컴파일한다.
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			pstmt.setString(1, (String) property.get("serialnum"));

			pstmt.executeUpdate(); // 쿼리를 실행한다.

			System.out.println("mandolin 테이블에 고유 번호 : " + (String) property.get("serialnum") + " 인 기타를 삭제 했습니다."); // 성공시
																													// 메시지

		} catch (Exception e) { // 예외가 발생하면 예외 상황을 처리한다.
			e.printStackTrace();
			System.out.println("mandolin 테이블에 고유 번호 : " + (String) property.get("serialnum") + " 인 기타를 삭제하지 못 했습니다.");
		}

	}
}






