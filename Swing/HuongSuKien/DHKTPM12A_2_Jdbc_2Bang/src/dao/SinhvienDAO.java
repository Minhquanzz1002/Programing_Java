package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Lophoc;
import entity.Sinhvien;

public class SinhvienDAO {
	private Connection con;
	
	public SinhvienDAO() {
		con = MyConnection.getInstance().getConnection();
	}
	
	public boolean themSinhvien(Sinhvien sv) throws SQLException {
		String sql = "insert into Sinhvien values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, sv.getMaSV());
			stmt.setString(2, sv.getHoten());
			stmt.setString(3, sv.getGioitinh());
			stmt.setDate(4, sv.getNgaysinh());
			stmt.setString(5, sv.getDiachi());
			stmt.setString(6, sv.getEmail());
			stmt.setString(7, sv.getLophoc().getMalop());
			
			int n = stmt.executeUpdate();
			if(n > 0)
				return true;
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		return false;
	}
	
	public List<Sinhvien> getSinhviens() throws SQLException {
		List<Sinhvien> dssv = new ArrayList<Sinhvien>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Sinhvien");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Sinhvien sv = new Sinhvien(rs.getString("masv"), rs.getString("hoten"), rs.getString("gioitinh"), rs.getDate("ngaysinh"), rs.getString("DaiChi"), rs.getString("email"));
				Lophoc lophoc = new Lophoc(rs.getString("malop"));
				sv.setLophoc(lophoc);
				dssv.add(sv);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		return dssv;
	}
	
	
	public List<Sinhvien> getSinhviens(String malop) throws SQLException {
		List<Sinhvien> dssv = new ArrayList<Sinhvien>();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Sinhvien where malop=?");
			stmt.setString(1, malop);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Sinhvien sv = new Sinhvien(rs.getString("masv"), rs.getString("hoten"), rs.getString("gioitinh"), rs.getDate("ngaysinh"), rs.getString("diachi"), rs.getString("email"));
				Lophoc lophoc = new Lophoc(rs.getString("malop"));
				sv.setLophoc(lophoc);
				dssv.add(sv);
			}
		} catch (SQLException e) {
			throw new SQLException(e);
		}
		
		return dssv;
	}
	
	public boolean xoaSinhvien(Sinhvien sv) throws SQLException {
		try {
			PreparedStatement stmt = con.prepareStatement("delete from Sinhvien where masv = ?");
			stmt.setString(1, sv.getMaSV());
			int n = stmt.executeUpdate();
			if(n > 0)
				return true;
		}catch (SQLException e) {
			throw new SQLException(e);
		}
		
		return false;
	}
	public boolean updateSinhVien(String MaSV, Sinhvien sv) {
        String sql = "update SinhVien set HoTen = ?, "
                + "GioiTinh = ?,NgaySinh = ? ,DaiChi = ?,Email = ?,MaLop=? where MaSV = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sv.getHoten());
            stmt.setString(2, sv.getGioitinh());
            stmt.setDate(3, sv.getNgaysinh());
            stmt.setString(4, sv.getDiachi());
            stmt.setString(5, sv.getEmail());
            stmt.setString(6, sv.getLophoc().getMalop());
            stmt.setString(7, MaSV);

            int n = stmt.executeUpdate();
            if(n > 0)
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
