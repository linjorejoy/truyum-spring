package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

	public static Connection connection = null;
	private static Properties props = new Properties();

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\877973\\Desktop\\Works\\GitHub\\truyum\\casestudy\\truYum\\src\\connection.properties");
			props.load(fis);

			Class.forName(props.getProperty("driver"));

			connection = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
					props.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
//location	C:\Users\877973\Desktop\Works\GitHub\truyum\casestudy\truYum\src\com\cognizant\truyum\dao\ConnectionHandler.java
//location	C:\Users\877973\Desktop\Works\GitHub\truyum\casestudy\truYum\src\connection.properties