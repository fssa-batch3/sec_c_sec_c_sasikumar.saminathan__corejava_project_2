package com.fssa.shopnow.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fssa.shopnow.dao.DAOException;

import io.github.cdimascio.dotenv.Dotenv;

//public class ConnectionUtil {
//
//	static Logger logger = new Logger();
//
//	public static Connection getConnection() throws ClassNotFoundException {
//
//		String url;
//		String userName;
//		String passWord;
//
//		if (System.getenv("CI") != null) {
//			url = System.getenv("DATABASE_HOST");
//			userName = System.getenv("DATABASE_USERNAME");
//			passWord = System.getenv("DATABASE_PASSWORD");
//		} else {
//			Dotenv env = Dotenv.load();
//			url = env.get("DATABASE_HOST");
//			userName = env.get("DATABASE_USERNAME");
//			passWord = env.get("DATABASE_PASSWORD");
//		}
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url, userName, passWord);
//			logger.info("connection successful");
//			return con;
//
//		} catch (Exception e) {
//			throw new ClassNotFoundException("Unable to connect to the database");
//		}
//
//	}
//
//	public static void main(String[] args) throws ClassNotFoundException {
//		getConnection();
//	}
//
//}

public class ConnectionUtil {
	private ConnectionUtil() {
//	private constructor
	}

	/**
	 * Get a connection to the database.
	 * 
	 * @return The database connection.
	 * @throws DAOException
	 * @throws RuntimeException if unable to connect to the database.
	 */
	public static Connection getConnection() throws DAOException {
		Connection con = null;

		String url;
		String userName;
		String passWord;

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);

		} catch (Exception e) {
			throw new DAOException("Unable to connect to the database");
		}
		return con;
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		Logger logger = new Logger();
		try {
			if (rs != null) { 
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
	}

}
