package tuan10.qlsinhvien_lop.entity;

public class SinhVien {
	private String maSV, hoTen, email, diaChi, maLop;
	

	public SinhVien(String maSV, String hoTen, String email, String diaChi, String maLop) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.email = email;
		this.diaChi = diaChi;
		this.maLop = maLop;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
