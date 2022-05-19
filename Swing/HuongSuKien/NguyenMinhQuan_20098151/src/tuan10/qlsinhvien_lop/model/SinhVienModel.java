package tuan10.qlsinhvien_lop.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tuan10.qlsinhvien_lop.entity.SinhVien;

public class SinhVienModel extends AbstractTableModel {
	private String[] headers = { "Mã số sinh viên", "Họ và tên", "Email liên hệ", "Địa chỉ" };
	private List<SinhVien> dssv;
	
	public SinhVienModel(List<SinhVien> dssv) {
		this.dssv = dssv;
	}

	@Override
	public int getRowCount() {
		return dssv.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return headers[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		SinhVien sinhVien = dssv.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return sinhVien.getMaSV();
		case 1:
			return sinhVien.getHoTen();
		case 2:
			return sinhVien.getEmail();
		case 3:
			return sinhVien.getDiaChi();
		}
		return sinhVien;
	}

}
