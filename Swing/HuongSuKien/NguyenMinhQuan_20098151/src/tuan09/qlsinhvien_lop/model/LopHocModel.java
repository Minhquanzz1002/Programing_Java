package tuan09.qlsinhvien_lop.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import tuan09.qlsinhvien_lop.entity.LopHoc;

public class LopHocModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[] headers = { "Mã lớp", "Tên lớp", "Sĩ số" };
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
			return lopHoc.getSiSo();
		}
		return lopHoc;
	}

}
