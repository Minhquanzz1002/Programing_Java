package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import connectDB.MyConnection;
import entity.NhanSu;
import entity.TaiKhoan;

public class DAO_NhanSu {
	private Connection con;

	public DAO_NhanSu() {
		con = MyConnection.getInstance().getConnection();
	}

	public List<NhanSu> getListNhanSu() {
		List<NhanSu> dsNs = new ArrayList<NhanSu>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT NHANVIEN.MaNV, NHANVIEN.MaPB, NHANVIEN.HoNV, NHANVIEN.TenNV, NHANVIEN.NgaySinh,tuoi=YEAR(GETDATE())- YEAR( NHANVIEN.NgaySinh), NHANVIEN.LuongTheoNgay, NHANVIEN.GioiTinh, NHANVIEN.DiaChi, NHANVIEN.SDT,chuyenMon = (select CHUYENMON.TenCM from CHUYENMON where CHUYENMON.MaCM = NHANVIEN.MaCM)FROM  NHANVIEN ");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maNhanSu = rs.getString("MaNV");
				String maPB = rs.getString("MaPB");
				String hoDem = rs.getString("HoNV");
				String tenNhanSu = rs.getString("TenNV");
				String chuyenMon = rs.getString("chuyenMon");
				String sdt = rs.getString("SDT");
				int tuoi = rs.getInt("tuoi");
				Double luongTheoNgay = rs.getDouble("LuongTheoNgay");
				Date ngaySinh = rs.getDate("NgaySinh");
				Boolean gioiTinh = rs.getBoolean("GioiTinh");
				String diaChi = rs.getString("DiaChi");
				NhanSu nhanSu = new NhanSu(maNhanSu, maPB, hoDem, tenNhanSu, ngaySinh, tuoi, luongTheoNgay, gioiTinh,
						diaChi, sdt, chuyenMon);
				dsNs.add(nhanSu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNs;
	}

	public boolean insertNS(NhanSu i) {
		try {
			PreparedStatement stmt = con.prepareStatement("insert into NHANVIEN values (?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, i.getMaNhanSu());
			stmt.setString(2, i.getMaPB());
			stmt.setString(3, i.getChuyenMon());
			stmt.setString(4, i.getHoDem());
			stmt.setString(5, i.getTenNhanSu());
			stmt.setBoolean(6, i.isGioiTinh());
			stmt.setDate(7, new java.sql.Date(i.getNgaySinh().getTime()));
			stmt.setString(8, i.getDiaChi());
			stmt.setString(9, i.getSdt());
			stmt.setDouble(10, i.getLuongTheoNgay());
			stmt.setDate(11, new java.sql.Date(System.currentTimeMillis()));
			int n = stmt.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<NhanSu> getNStheoPB(String PB) throws SQLException {
		List<NhanSu> daNS = new ArrayList<NhanSu>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select MaNV,MaPB,MaCM,HoNV,TenNV,GioiTinh,NgaySinh,DiaChi,SDT,LuongTheoNgay,tuoi=YEAR(GETDATE())-YEAR(NgaySinh) from NHANVIEN where MaPB =?");
			stmt.setString(1, PB);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String maNhanSu = rs.getString("MaNV");
				String maPB = rs.getString("MaPB");
				String hoDem = rs.getString("HoNV");
				String tenNhanSu = rs.getString("TenNV");
				String chuyenMon = rs.getString("MaCM");
				String sdt = rs.getString("SDT");
				int tuoi = rs.getInt("tuoi");
				Double luongTheoNgay = rs.getDouble("LuongTheoNgay");
				Date ngaySinh = rs.getDate("NgaySinh");
				Boolean gioiTinh = rs.getBoolean("GioiTinh");
				String diaChi = rs.getString("DiaChi");
				NhanSu nhanSu = new NhanSu(maNhanSu, maPB, hoDem, tenNhanSu, ngaySinh, tuoi, luongTheoNgay, gioiTinh,
						diaChi, sdt, chuyenMon);
				daNS.add(nhanSu);
			}
		} catch (Exception e) {
			throw new SQLException(e);
		}
		return daNS;
	}

	public List<NhanSu> getNsCT(String ct) {
		List<NhanSu> ds = new ArrayList<NhanSu>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"SELECT  NHANVIEN.*,chuyenMon =(select CHUYENMON.TenCM from CHUYENMON where CHUYENMON.MaCM = NHANVIEN.MaCM),PHANCONG.NgayThamGia FROM NHANVIEN INNER JOIN PHANCONG ON NHANVIEN.MaNV = PHANCONG.MaNV where PHANCONG.MaCT = ?");
			stmt.setString(1, ct);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanSu ns = new NhanSu(rs.getString("MaNV"), rs.getString("MaPB"), rs.getString("HoNV"),
						rs.getString("TenNV"), rs.getString("chuyenMon"), rs.getDate("NgayThamGia"));
				ds.add(ns);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ds;
	}

	public List<NhanSu> getNSChuaCT() {
		List<NhanSu> ds = new ArrayList<NhanSu>();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select NHANVIEN.*,chuyenMon =(select CHUYENMON.TenCM from CHUYENMON where CHUYENMON.MaCM = NHANVIEN.MaCM) from NHANVIEN where MaNV not in (select MaNV from PHANCONG)");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NhanSu ns = new NhanSu(rs.getString("MaNV"), rs.getString("MaPB"), rs.getString("HoNV"),
						rs.getString("TenNV"), rs.getString("chuyenMon"), null);
				ds.add(ns);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean deleteNS(String mans) {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from NHANVIEN where MaNV = ?");
			stmt.setString(1, mans);
			int n = stmt.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Lấy thông tin nhân viên dựa theo mã nhân viên
	 * @param taiKhoan
	 * @return thông tin của nhân viên/null
	 */
	public NhanSu getNhanSu(TaiKhoan taiKhoan) {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			preparedStatement = con.prepareStatement("SELECT * FROM View_NhanVien WHERE MaNV = ?");
			preparedStatement.setString(1, taiKhoan.getTenTK());
			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return new NhanSu(rs.getString("MaNV"), rs.getString("MaPB"), rs.getString("HoNV"),
						rs.getString("TenNV"), rs.getDate("NgaySinh"), rs.getInt("Tuoi"), rs.getDouble("LuongTheoNgay"),
						rs.getBoolean("GioiTinh"), rs.getString("DiaChi"), rs.getString("SDT"),
						rs.getString("MaCM"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean suaNhanSuTuNguoiDung(NhanSu nhanSu) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = con.prepareStatement("UPDATE NHANVIEN SET HoNV = ?, TenNV = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, SDT = ? WHERE MaNV = ?");
			preparedStatement.setString(1, nhanSu.getHoDem());
			preparedStatement.setString(2, nhanSu.getTenNhanSu());
			preparedStatement.setBoolean(3, nhanSu.isGioiTinh());
			preparedStatement.setDate(4, new java.sql.Date(nhanSu.getNgaySinh().getTime()));
			preparedStatement.setString(5, nhanSu.getDiaChi());
			preparedStatement.setString(6, nhanSu.getSdt());
			preparedStatement.setString(7, nhanSu.getMaNhanSu());
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
