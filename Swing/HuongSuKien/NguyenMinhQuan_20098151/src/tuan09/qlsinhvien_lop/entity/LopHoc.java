package tuan09.qlsinhvien_lop.entity;

public class LopHoc {
	private String maLop, tenLop;
	private int siSo;

	public LopHoc(String maLop, String tenLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.siSo = 0;
	}

	public LopHoc(String maLop, String tenLop, int siSo) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.siSo = siSo;
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

	public int getSiSo() {
		return siSo;
	}

	public void setSiSo(int siSo) {
		this.siSo = siSo;
	}

}
