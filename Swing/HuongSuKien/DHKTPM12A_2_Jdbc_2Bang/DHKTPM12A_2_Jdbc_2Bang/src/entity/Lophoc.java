package entity;

public class Lophoc {
	private String malop;
	private String tenlop;
	private int siso;
	private String giaovienCN;
	
	public Lophoc(String malop, String tenlop, int siso, String giaovienCN) {
		super();
		this.malop = malop;
		this.tenlop = tenlop;
		this.siso = siso;
		this.giaovienCN = giaovienCN;
	}

	public Lophoc(String malop) {
		super();
		this.malop = malop;
	}

	public Lophoc() {
		super();
	}

	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public String getTenlop() {
		return tenlop;
	}
	public void setTenlop(String tenlop) {
		this.tenlop = tenlop;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	public String getGiaovienCN() {
		return giaovienCN;
	}
	public void setGiaovienCN(String giaovienCN) {
		this.giaovienCN = giaovienCN;
	}
	@Override
	public String toString() {
		return "Lophoc [malop=" + malop + ", tenlop=" + tenlop + ", siso=" + siso + ", giaovienCN=" + giaovienCN + "]";
	}


}
//
//create table Lophoc(
//		malop varchar(30) primary key,
//		tenlop nvarchar(100) unique not null,
//		siso int,
//		giaovienCN nvarchar(100)
//	)
//	go
