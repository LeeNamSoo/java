package connect;

import java.sql.Connection;
import java.sql.SQLException;

import db.DBConnection;

public class ConnectionUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		return DBConnection.getMySQLConnection();
	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
