package tuan10.qlsinhvien_lop.model;

import java.sql.Connection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import tuan10.qlsinhvien_lop.entity.LopHoc;

public class LopHocModel extends AbstractTableModel {
	private String[] headers = { "Mã số lớp", "Tên lớp", "Giáo viên chủ nhiệm" };
	private List<LopHoc> dslh;
	
	public LopHocModel(List<LopHoc> dslh) {
		this.dslh = dslh;
	}

	@Override
	public int getRowCount() {
		return dslh.size();
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
		LopHoc lopHoc = dslh.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return lopHoc.getMaLop();
		case 1:
			return lopHoc.getTenLop();
		case 2:
			return lopHoc.getGiaoVien();
		}
		return lopHoc;
	}

//	@Override
//	public void fireTableRowsInserted(int firstRow, int lastRow) {
//		// TODO Auto-generated method stub
//		super.fireTableRowsInserted(firstRow, lastRow);
//	}
}
