package tuan04.thongtinnhanvien;

public class ThongTinNhanVien {
	private String maNV, hoNV, tenNV, phai, tuoi;
	private long tienLuong;

	

	public ThongTinNhanVien(String maNV, String hoNV, String tenNV, String phai, String tuoi, long tienLuong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getPhai() {
		return phai;
	}

	public void setPhai(String phai) {
		this.phai = phai;
	}

	public String getTuoi() {
		return tuoi;
	}

	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}

	public long getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(long tienLuong) {
		this.tienLuong = tienLuong;
	}

	
}
