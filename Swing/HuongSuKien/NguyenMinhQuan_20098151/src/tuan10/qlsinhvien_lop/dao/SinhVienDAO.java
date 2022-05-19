package tuan10.qlsinhvien_lop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tuan10.qlsinhvien_lop.entity.LopHoc;
import tuan10.qlsinhvien_lop.entity.SinhVien;

public class SinhVienDAO {
	private Connection connection;
	public SinhVienDAO() {
		connection = MyConnection.getInstance().getConnection();
	}
	
	public List<SinhVien> getDSSV() {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<SinhVien> dssv = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM SinhVien");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SinhVien sinhVien = new SinhVien(resultSet.getString("MaSV"), resultSet.getString("HoTen"), resultSet.getString("Email"), resultSet.getString("DiaChi"), resultSet.getString("MaLop"));
				dssv.add(sinhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssv;
	}
	
	/**
	 * lay ds sinh vien theo ma lop
	 * @param lopHoc 
	 * @return danh sach sinh vien
	 */
	public List<SinhVien> getDSSV(LopHoc lopHoc) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<SinhVien> dssv = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM SinhVien WHERE MaLop = ?");
			preparedStatement.setString(1, lopHoc.getMaLop());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SinhVien sinhVien = new SinhVien(resultSet.getString("MaSV"), resultSet.getString("HoTen"), resultSet.getString("Email"), resultSet.getString("DiaChi"), resultSet.getString("MaLop"));
				dssv.add(sinhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssv;
	}
	
	
	public boolean themSinhVien(SinhVien sinhVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO SinhVien VALUES(?, ?, ?, ?, ?)");
			preparedStatement.setString(1, sinhVien.getMaSV());
			preparedStatement.setString(2, sinhVien.getHoTen());
			preparedStatement.setString(3, sinhVien.getDiaChi());
			preparedStatement.setString(4, sinhVien.getEmail());
			preparedStatement.setString(5, sinhVien.getMaLop());
			int resultInsert = preparedStatement.executeUpdate();
			if (resultInsert > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean suaSinhVien(SinhVien sinhVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE SinhVien SET HoTen = ?, DiaChi = ?, Email = ?, MaLop = ?");
			preparedStatement.setString(1, sinhVien.getHoTen());
			preparedStatement.setString(2, sinhVien.getDiaChi());
			preparedStatement.setString(3, sinhVien.getEmail());
			preparedStatement.setString(3, sinhVien.getMaLop());
			int resultExecute = preparedStatement.executeUpdate();
			if (resultExecute > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaSinhVien(SinhVien sinhVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?");
			preparedStatement.setString(1, sinhVien.getMaSV());
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
