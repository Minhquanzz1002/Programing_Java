package bai1;

public class PhuongTrinhBacHai {
	private double a;
	private double b;
	private double c;
	public PhuongTrinhBacHai(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getC() {
		return c;
	}
	public void setC(double c) {
		this.c = c;
	}
	
	@Override
	public String toString() {
		return "PhuongTrinhBacHai [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
	
	public String giaiPhuongTrinhBacHai() {
		double delta = b*b - 4*a*c;
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					return "Phương trình vô số nghiệm!";
				}
				else {
					return "Phương trình vô nghiệm";
				}
			}
			else {
				return String.valueOf(-c/b);
			}
		}
		else {
			if (delta == 0) {
				return String.valueOf(-b/(2*a));
			}else if (delta > 0) {
				double x1 = (-b + Math.sqrt(delta))/(2*a);
				double x2 = (-b-Math.sqrt(delta))/(2*a);
				return String.valueOf(x1) + ", " + String.valueOf(x2);
			}else {
				return "Phương trình vô nghiệm";
			}
		}
	}
}
