package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connectDB.MyConnection;
import entity.TaiKhoan;

public class DAO_TaiKhoan {
	private Connection connection;
	public DAO_TaiKhoan() {
		connection = MyConnection.getInstance().getConnection();
	}
	
	/**
	 * Cặp nhật mật khẩu của tài khoản trong SQL
	 * @param taiKhoan tài khoản
	 * @return kết quả cập nhật
	 */
	public boolean suaTaiKhoan(TaiKhoan taiKhoan) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement("UPDATE TAIKHOAN SET MatKhau = ? WHERE TenTK = ?");
			preparedStatement.setString(1, taiKhoan.getMatKhau());
			preparedStatement.setString(2, taiKhoan.getTenTK());
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
