package onthi.onthi1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import onthi.onthi1.connectdb.ConnectDB;
import onthi.onthi1.entity.PhongBan;

public class DAO_PhongBan {
	private Connection connection;
	
	public DAO_PhongBan() {
		connection = ConnectDB.getInstatce().getConnection();
	}
	
	public List<PhongBan> getAllPhongBan(){
		List<PhongBan> dspb = new ArrayList<PhongBan>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM PhongBan");
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				PhongBan phongBan = new PhongBan(rs.getString("maPhong"), rs.getString("tenPhong"));
				dspb.add(phongBan);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dspb;
	}
}
