package tuan10.qlsinhvien_lop.entity;

public class LopHoc {
	String maLop, tenLop, giaoVien;

	public LopHoc(String maLop, String tenLop, String giaoVien) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.giaoVien = giaoVien;
	}

	public String getMaLop() {
		return maLop;
	}

	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public String getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(String giaoVien) {
		this.giaoVien = giaoVien;
	}

}
