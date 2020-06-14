package uTill;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReturnListFromDBUtil {
//�ڹٿ��� DB���� ���ϰ� �������� ���� Ŭ����
//Statement ��ü�� ResultSet ��ü�� ������ �ѱ�� ����Ʈ�� �ϳ��� �� ������(HashMap), Ȥ�� �̱۰�(���ڿ�, ����) �� �ҷ��� �� �ִ�.

	//���ڿ��� �Ѱ� ��������
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

	//���� ��������
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

	//����Ʈ ��������
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
				System.out.println("���� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}



