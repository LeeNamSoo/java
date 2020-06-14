package uTill;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReturnListFromDBUtil {
//자바에서 DB값을 편하게 가져오기 위한 클래스
//Statement 객체와 ResultSet 객체와 쿼리를 넘기면 리스트나 하나의 행 데이터(HashMap), 혹은 싱글값(문자열, 숫자) 를 불러올 수 있다.

	//문자열값 한개 가져오기
	public static int getInt(String sql, Statement stmt, ResultSet rs) throws Exception {
		int result = 0; 

		try {
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					result = rs.getInt(1);

					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	public static String getVal(String sql, Statement stmt, ResultSet rs) throws Exception {
		String result = "";

		try {
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				while (rs.next()) {
					result = rs.getString(1);

					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	//한행 가져오기
	public static HashMap<String, String> getRow(String sql, Statement stmt, ResultSet rs) throws Exception {
		HashMap<String, String> result = null;

		try {
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				ResultSetMetaData rsm = rs.getMetaData();

				while (rs.next()) {
					result = new HashMap<String, String>();

					for (int i = 0; i < rsm.getColumnCount(); i++) {
						String key = rsm.getColumnName(i + 1);
						String val = rs.getString(key);

						result.put(key.toLowerCase(), val);
					}

					break;
				}
			}
		} catch (Exception e) {
			throw e;
		}

		return result;
	}

	//리스트 가져오기
	public static List<HashMap<String, String>> getList(ResultSet rs) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		try {
			if (rs != null) {
				ResultSetMetaData rsm = rs.getMetaData();

				while (rs.next()) {
					HashMap<String, String> row = new HashMap<String, String>();

					for (int i = 0; i < rsm.getColumnCount(); i++) {
						String key = rsm.getColumnName(i + 1);
						// String key = ""+i;
						String val = rs.getString(key);

						row.put(key.trim().toLowerCase(), val);
					}
					list.add(row);
				}
			} else {
				System.out.println("쿼리 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}



