package tuan09.qlsinhvien_lop.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tuan09.qlsinhvien_lop.entity.SinhVien;

public class SinhVienModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] headers = {"Mã sinh viên", "Họ", "Tên", "Phái", "Email", "Địa chỉ", "Mã lớp"};
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
			return sinhVien.getHo();
		case 2:
			return sinhVien.getTen();
		case 3:
			return sinhVien.getPhai();
		case 4:
			return sinhVien.getEmail();
		case 5:
			return sinhVien.getDiaChi();
		case 6:
			return sinhVien.getMaLop();
		}
		return dssv;
	}
	
}
