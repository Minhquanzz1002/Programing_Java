package demoketnoisql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost:1433;databasename=AdventureWorks2012";
		try {
			Connection connection = DriverManager.getConnection(url, "sa", "sa");
			System.out.println("Done!");
			
			Statement statement = connection.createStatement();
			String sql = "SELECT BusinessEntityID, FirstName, LastName FROM Person.Person";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int ma = resultSet.getInt(1);
				String ho = resultSet.getString(2);
				String ten = resultSet.getString(3);
				System.out.println(ma + "|" + ho + "|" + ten);
			}
		} catch (SQLException e) {
			System.err.println("Connect fail!");
			e.printStackTrace();
		}
	}
}
