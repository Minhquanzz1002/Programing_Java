package onthi.onthi1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import onthi.onthi1.connectdb.ConnectDB;
import onthi.onthi1.entity.NhanVien;

public class DAO_NhanVien {
	private Connection connection;

	public DAO_NhanVien() {
		connection = ConnectDB.getInstatce().getConnection();
	}

	public List<NhanVien> getDanhSachNhanVien() {
		List<NhanVien> dsnv = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM NhanVien");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NhanVien nhanVien = new NhanVien(rs.getString("MaNV"), rs.getString("hoTen"), rs.getString("maPhong"),
						rs.getInt("tuoi"), rs.getFloat("tienluong"));
				dsnv.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public List<NhanVien> getDSNhanVien(String maNV) {
		List<NhanVien> dsnv = new ArrayList<>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM NhanVien WHERE MaNV LIKE ?");
			preparedStatement.setString(1, "%" + maNV + "%");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NhanVien nhanVien = new NhanVien(resultSet.getString("MaNV"), resultSet.getString("hoTen"),
						resultSet.getString("maPhong"), resultSet.getInt("tuoi"), resultSet.getFloat("tienluong"));
				dsnv.add(nhanVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsnv;
	}

	public boolean themNhanVien(NhanVien nhanVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO NhanVien VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, nhanVien.getMaNV());
			preparedStatement.setString(2, nhanVien.getHoTen());
			preparedStatement.setInt(3, nhanVien.getTuoi());
			preparedStatement.setString(4, nhanVien.getMaPB());
			preparedStatement.setFloat(5, nhanVien.getLuong());
			int resultExecute = preparedStatement.executeUpdate();
			if (resultExecute > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean xoaNhanVien(NhanVien nhanVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE NhanVien WHERE MaNV = ?");
			preparedStatement.setString(1, nhanVien.getMaNV());
			int resultExecute = preparedStatement.executeUpdate();
			if (resultExecute > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean suaNhanVien(NhanVien nhanVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(
					"UPDATE NhanVien SET hoTen = ?, maPhong = ?, tuoi = ?, tienLuong = ? WHERE MaNV = ?");
			preparedStatement.setString(1, nhanVien.getHoTen());
			preparedStatement.setInt(3, nhanVien.getTuoi());
			preparedStatement.setString(2, nhanVien.getMaPB());
			preparedStatement.setFloat(4, nhanVien.getLuong());
			preparedStatement.setString(5, nhanVien.getMaNV());
			int resultExecute = preparedStatement.executeUpdate();
			if (resultExecute > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
