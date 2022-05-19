package model;

import java.sql.Connection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Sinhvien;

@SuppressWarnings("serial")
public class SinhvienModel extends AbstractTableModel{

	private String[] headers = {"Mã số", "Họ tên","Giới tính", "Ngày sinh", "Địa chỉ", "Email", "Mã lớp"};
	private List<Sinhvien> dssv;


	public SinhvienModel(List<Sinhvien> dssv) {
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
		Sinhvien sv = dssv.get(rowIndex);
		switch (columnIndex) {
		case 0: return sv.getMaSV();
		case 1: return sv.getHoten();
		case 2: return sv.getGioitinh();
		case 3: return sv.getNgaysinh();
		case 4: return sv.getDiachi();
		case 5: return sv.getEmail();
		case 6: return sv.getLophoc().getMalop();

		}

		return sv;
	}

}
