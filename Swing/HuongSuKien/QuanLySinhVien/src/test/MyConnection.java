package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	private static MyConnection instance;
	private Connection connection;
	public MyConnection() {
		try {
			String url = "jdbc:sqlserver://localhost:1433;databaseName=HSK_SV_LOP";
			String user = "sa";
			String password = "sa";
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static MyConnection getInstance() {
		if (instance == null) {
			instance = new MyConnection();
		}
		return instance;
	}
	public Connection getConnection() {
		return connection;
	}
}
