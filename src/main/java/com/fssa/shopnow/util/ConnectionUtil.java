package com.fssa.shopnow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionUtil {

	static Logger logger = new Logger();

	public static Connection getConnection() throws ClassNotFoundException {

		String url;
		String userName;
		String passWord;

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
			Connection con = DriverManager.getConnection(url, userName, passWord);
			logger.info("connection successful");
			return con;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ClassNotFoundException("Unable to connect to the database");
		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		getConnection();
	}

}
