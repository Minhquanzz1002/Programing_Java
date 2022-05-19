package entity;

import java.sql.Date;

public class Sinhvien {
	private String maSV;
	private String hoten;
	private String gioitinh;
	private Date ngaysinh;
	private String diachi;
	private String email;
	
	private Lophoc lophoc;

	public Sinhvien(String maSV, String hoten, String gioitinh, Date ngaysinh, String diachi, String email) {
		super();
		this.maSV = maSV;
		this.hoten = hoten;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.email = email;
	}

	public Sinhvien() {
		super();
	}

	public Sinhvien(String maSV) {
		super();
		this.maSV = maSV;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Lophoc getLophoc() {
		return lophoc;
	}

	public void setLophoc(Lophoc lophoc) {
		this.lophoc = lophoc;
	}

	@Override
	public String toString() {
		return "Sinhvien [maSV=" + maSV + ", hoten=" + hoten + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh
				+ ", diachi=" + diachi + ", email=" + email + ", lophoc=" + lophoc + "]";
	}
	
}
