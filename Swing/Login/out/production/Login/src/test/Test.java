package test;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("sa");
        ds.setServerName("DESKTOP-3QJUEEU\\SQLEXPRESS");
        ds.setPortNumber(1433); // cong TCP/IP
        ds.setDatabaseName("TEST");
        try(Connection connection = ds.getConnection()){
            System.out.println("Ket noi thanh cong");
            System.out.println(connection.getCatalog());
            System.out.println(connection.getMetaData());
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
