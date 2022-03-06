package pheptinh;

public class PhepTinh {
	Double a, b;
	String phepToan;

	public PhepTinh(Double a, Double b, String phepToan) {
		super();
		this.a = a;
		this.b = b;
		this.phepToan = phepToan;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public String getPhepToan() {
		return phepToan;
	}

	public void setPhepToan(String phepToan) {
		this.phepToan = phepToan;
	}
	
	public String tinhToan() {
		switch (phepToan) {
		case "Cộng":
			return (a + b) + "";
		case "Trừ":
			return (a-b) + "";
		case "Nhân":
			return (a*b) + "";
		case "Chia":
			return (a/b) + "";
		default:
			return "Lỗi";
		}
	}
}
