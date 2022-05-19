package tuan06.qlsachsaveobj;

import java.io.Serializable;
import java.util.ArrayList;

public class DanhSachSach implements Serializable {
	private ArrayList<Sach> dsSach;

	public DanhSachSach() {
		dsSach = new ArrayList<>();
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	public boolean themSach(Sach s) {
		if (dsSach.contains(s)) {
			return false;
		}
		dsSach.add(s);
		return true;
	}

	public boolean xoaSach(Sach s) {
		if (dsSach.contains(s)) {
			dsSach.remove(s);
			return true;
		}
		return false;
	}
	
	/**
	 * Sua doi thong tin sach
	 * @param s1 la sach muon sua
	 * @param s2 la thong tin sach moi
	 * @return ket qua sua
	 */
	public boolean suaSach(Sach s1, Sach s2) {
		int index = dsSach.indexOf(s1);
		if (index != -1) {
			dsSach.set(index, s2);
			return true;
		}
		return false;
	}
	
	public boolean kiemTraMaSachTonTai(String maSach) {
		for (Sach s : dsSach) {
			if (maSach.equals(s.getMaSach())) {
				return true;
			}
		}
		return false;
	}
}
