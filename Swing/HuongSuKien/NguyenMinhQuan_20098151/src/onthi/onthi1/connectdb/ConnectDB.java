package onthi.onthi1.connectdb;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	private Connection connection;
	private static ConnectDB instance;

	public ConnectDB() {
		String user = "sa";
		String password = "sa";
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QLNV";
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public synchronized static ConnectDB getInstatce() {
		if (instance == null) {
			instance = new ConnectDB();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
	
}
