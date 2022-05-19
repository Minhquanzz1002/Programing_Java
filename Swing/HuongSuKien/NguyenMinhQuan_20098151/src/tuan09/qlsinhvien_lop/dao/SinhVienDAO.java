package tuan09.qlsinhvien_lop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tuan09.qlsinhvien_lop.entity.SinhVien;

public class SinhVienDAO {
	private Connection connection;

	public SinhVienDAO() {
		connection = MyConnection.getInstance().getConnection();
	}

	public List<SinhVien> getDSSinhVien() {
		List<SinhVien> dssv = new ArrayList<SinhVien>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM SinhVien");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				SinhVien sinhVien = new SinhVien(resultSet.getString("MaSV"), resultSet.getString("Ho"),
						resultSet.getString("Ten"), resultSet.getString("Phai"), resultSet.getString("Email"),
						resultSet.getString("DiaChi"), resultSet.getString("MaLop"));
				dssv.add(sinhVien);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return dssv;
	}
	
	public boolean themSinhVien(SinhVien sinhVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO SinhVien VALUES(?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, sinhVien.getMaSV());
			preparedStatement.setString(2, sinhVien.getHo());
			preparedStatement.setString(3, sinhVien.getTen());
			preparedStatement.setString(4, sinhVien.getPhai());
			preparedStatement.setString(5, sinhVien.getEmail());
			preparedStatement.setString(6, sinhVien.getDiaChi());
			preparedStatement.setString(7, sinhVien.getMaLop());
			int resultExecute = preparedStatement.executeUpdate();
			if (resultExecute > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
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
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean suaSinhVien(SinhVien sinhVien) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE SinhVien SET Ho = ?, Ten = ?, Phai = ?, Email = ?, DiaChi = ?, MaLop = ? WHERE MaSV = ?");
			preparedStatement.setString(1, sinhVien.getHo());
			preparedStatement.setString(2, sinhVien.getTen());
			preparedStatement.setString(3, sinhVien.getPhai());
			preparedStatement.setString(4, sinhVien.getEmail());
			preparedStatement.setString(5, sinhVien.getDiaChi());
			preparedStatement.setString(6, sinhVien.getMaLop());
			preparedStatement.setString(7, sinhVien.getMaSV());
			int resultExecute = preparedStatement.executeUpdate();
			if (resultExecute > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} 		
		}
		return false;
	}
	
	public List<String> getDSMaLop() {
		List<String> dsMaLop = new ArrayList<String>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT MaLop FROM LopHoc");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String maLop = resultSet.getString("MaLop");
				dsMaLop.add(maLop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return dsMaLop;
	}
}
