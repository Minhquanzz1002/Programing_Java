package onthi.onthi1.entity;

public class NhanVien {
	private String maNV, hoTen, maPB;
	private int tuoi;
	private float luong;

	public NhanVien(String maNV, String hoTen, String maPB, int tuoi, float luong) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.maPB = maPB;
		this.tuoi = tuoi;
		this.luong = luong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMaPB() {
		return maPB;
	}

	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public float getLuong() {
		return luong;
	}

	public void setLuong(float luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTen=" + hoTen + ", maPB=" + maPB + ", tuoi=" + tuoi + ", luong=" + luong
				+ "]";
	}

	public String[] toRowTable() {
		return new String[] {maNV, hoTen, String.valueOf(tuoi), String.valueOf(luong), maPB};
	}
}
