package dao;

import java.sql.Connection;

import connectDB.MyConnection;

public class DAO_NguoiDung {
	private Connection connection;
	public DAO_NguoiDung() {
		connection = MyConnection.getInstance().getConnection();
	}
	
	public void getNguoiDung() {
		
	}
}
