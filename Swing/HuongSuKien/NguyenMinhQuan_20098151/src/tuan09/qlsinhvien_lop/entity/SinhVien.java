package tuan09.qlsinhvien_lop.entity;

public class SinhVien {
	private String maSV, ho, ten, phai, email, diaChi, maLop;

	public SinhVien(String maSV, String ho, String ten, String phai, String email, String diaChi, String maLop) {
		super();
		this.maSV = maSV;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
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

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
}
