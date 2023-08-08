package com.fssa.shopnow.Util;

import java.sql.Connection; 
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {
	
	static Logger logger = new Logger();
	
	public static Connection getConnection() throws ClassNotFoundException {
		
		
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
		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassNotFoundException("Unable to connect to the database");
		}
		return con;
	}

	public static void main(String[] args) {
		try {
			getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
