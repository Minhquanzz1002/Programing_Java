package tuan02.giaiphuongtrinhbachai;

public class GiaiPhuongTrinhBacHai {
	float a, b, c;

	public GiaiPhuongTrinhBacHai(float a, float b, float c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}
	
	public String giaiPhuongTrinhBacHai() {
		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					return "Phương trình vô số nghiệm.";
				}else {
					return "Phương trình vô nghiệm";
				}
			}
			else {
				return String.valueOf(-c/ a);
			}
		}else {
			float delta = b*b - (4*a*c);
			float x1 =(float) (-b + Math.sqrt(delta))/(2*a);
			float x2 =(float) (-b - Math.sqrt(delta))/(2*a);
			if (delta > 0) {
				return String.valueOf(x1 + " " + x2);
			}else if (delta == 0){
				return String.valueOf(-b/(2*a));
			}else {
				return "Phương trình vô nghiệm.";
			}
		}
	}
}
