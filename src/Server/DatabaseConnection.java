package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection conn = null;
	private static String url = "jdbc:mysql://127.0.0.1/CSC275";
	private static String user = "***"; //root
	private static String password = "***";

	public DatabaseConnection() {

	}

	public static Connection connect() {
		try {
			if (conn == null || conn.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			System.out.println("Exception happened connecting to database: " + e.getMessage());
		}
		return conn;
	}

	public static boolean disconnect(Connection connectionToDisconnect) {
		try {
			if (connectionToDisconnect != null) {
				connectionToDisconnect.close();
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Error closing database connection");
			return false;
		}
	}
}

