package com.fssa.shopnow.Util;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;
import com.fssa.shopnow.dao.DAOException;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
	
	static Logger logger = new Logger();
	
	public static Connection getConnection() throws DAOException, ClassNotFoundException {
		
		
		Connection con = null;

		String url, userName, passWord;

		if (System.getenv("CI") != null) {
			url = System.getenv("DATABASE_HOST");
			userName = System.getenv("DATABASE_USERNAME");
			passWord = System.getenv("DATABASE_PASSWORD");
		} else {
			Dotenv env = Dotenv.load();
			url = env.get("DATABASE_HOST");
			userName = env.get("DATABASE_USERNAME");
			passWord = env.get("DATABASE_PASSWORD");
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			logger.info("connection successful");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Unable to connect to the database");
		}
		return con;
	}

	public static void main(String[] args) {
		try {
			getConnection();
		} catch (ClassNotFoundException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
