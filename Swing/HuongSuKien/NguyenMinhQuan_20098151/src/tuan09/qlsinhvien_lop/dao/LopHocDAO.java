package tuan09.qlsinhvien_lop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tuan09.qlsinhvien_lop.entity.LopHoc;

public class LopHocDAO {
	private Connection connection;
	
	public LopHocDAO() {
		connection = MyConnection.getInstance().getConnection();
	}
	
	public List<LopHoc> getDSLopHoc() {
		List<LopHoc> dslh = new ArrayList<LopHoc>();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement("SELECT MaLop, TenLop, SiSo = (SELECT COUNT(*) FROM SinhVien WHERE SinhVien.MaLop = LopHoc.MaLop) FROM LopHoc");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LopHoc lopHoc = new LopHoc(resultSet.getString("MaLop"), resultSet.getString("TenLop"), resultSet.getInt("SiSo"));
				dslh.add(lopHoc);
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
		return dslh;
	}
	
	public boolean themLopHoc(LopHoc lopHoc) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("INSERT INTO LopHoc VALUES(?, ?)");
			preparedStatement.setString(1, lopHoc.getMaLop());
			preparedStatement.setString(2, lopHoc.getTenLop());
			int resultExcute = preparedStatement.executeUpdate();
			if (resultExcute > 0) {
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
	
	public boolean xoaLopHoc(LopHoc lopHoc) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("DELETE FROM LopHoc WHERE MaLop = ?");
			preparedStatement.setString(1, lopHoc.getMaLop());
			int resultExcute = preparedStatement.executeUpdate();
			if (resultExcute > 0) {
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
	
	public boolean suaLopHoc(LopHoc lopHoc) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE LopHoc SET TenLop = ? WHERE MaLop = ?");
			preparedStatement.setString(1, lopHoc.getTenLop());
			preparedStatement.setString(2, lopHoc.getMaLop());
			int resultExcute = preparedStatement.executeUpdate();
			if (resultExcute > 0) {
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
}
