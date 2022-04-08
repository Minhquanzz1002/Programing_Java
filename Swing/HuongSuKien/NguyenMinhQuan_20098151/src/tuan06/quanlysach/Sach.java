package tuan06.quanlysach;

import java.io.Serializable;

public class Sach implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maSach, tuaSach, tacGia, nhaXB, isbn;
	private int namXB, soTrang;
	private double donGia;

	public Sach() {

	}

	public Sach(String maSach, String tuaSach, String tacGia, int namXB, String nhaXB, int soTrang,
			double donGia, String isbn) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.nhaXB = nhaXB;
		this.isbn = isbn;
		this.namXB = namXB;
		this.soTrang = soTrang;
		this.donGia = donGia;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) throws Exception {
		if (maSach.trim().isEmpty()) {
			throw new Exception("Ma sach khong duoc de trong");
		}
		this.maSach = maSach;
	}

	public String getTuaSach() {
		return tuaSach;
	}

	public void setTuaSach(String tuaSach) throws Exception {
		if (tuaSach.trim().isEmpty()) {
			throw new Exception("Tua sach khong duoc de trong");
		}
		this.tuaSach = tuaSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) throws Exception {
		if (tacGia.trim().isEmpty()) {
			throw new Exception("Tac gia khong duoc de trong");
		}
		this.tacGia = tacGia;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) throws Exception {
		if (nhaXB.trim().isEmpty()) {
			throw new Exception("Nha xuat ban khong duoc de trong");
		}
		this.nhaXB = nhaXB;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) throws Exception {
		if (isbn.trim().isEmpty()) {
			throw new Exception("ISBN khong duoc de trong");
		}
		this.isbn = isbn;
	}

	public int getNamXB() {
		return namXB;
	}

	public void setNamXB(int namXB) throws Exception {
		if (namXB <= 0 || namXB > 2022) {
			throw new Exception("Nam xuat ban phai lon hon khong va nho hon nam hien tai");
		}
		this.namXB = namXB;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) throws Exception {
		if (soTrang <= 0) {
			throw new Exception("So trang phai lon hon khong");
		}
		this.soTrang = soTrang;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) throws Exception {
		if (donGia < 0) {
			throw new Exception("Don gia phai lon hon khong");
		}
		this.donGia = donGia;
	}

	@Override
	public String toString() {
		return maSach + ";" + tuaSach + ";" + tacGia + ";" + namXB + ";" + nhaXB + ";" + soTrang + ";" + donGia + ";" + isbn;
	}

}
