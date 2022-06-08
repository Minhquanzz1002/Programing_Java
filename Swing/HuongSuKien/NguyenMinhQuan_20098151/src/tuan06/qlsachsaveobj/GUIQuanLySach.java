package tuan06.qlsachsaveobj;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import tuan05.quanlynhanvien.StoredData;

@SuppressWarnings("serial")
public class GUIQuanLySach extends JFrame implements ActionListener, MouseListener {
	private DanhSachSach dsSach;
	private static final String col = "Ma sach;Tua sach;Tac gia;Nam xuat ban;Nha xuat ban;So trang;Don gia;ISBN";
	private static final String filepath = "data\\DanhMucSachObject.txt";
	private JTable tblSach;
	private DefaultTableModel tblModel;
	private JButton btnThem, btnXoaRong, btnSua, btnXoa, btnLuu;
	private JButton[] btnCtrl;
	private JTextField txtMaSach, txtTuaSach, txtTacGia, txtNamXB, txtNhaXB, txtSoTrang, txtDonGia, txtISBN;
	private FlowLayout fl;
	private JComboBox<String> cboMaSach;

	public GUIQuanLySach(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		dsSach = new DanhSachSach();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(765, 450);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		fl = new FlowLayout(FlowLayout.LEFT);

		/* nhap ma sach */
		JLabel lblMaSach = new JLabel("Ma sach:");
		txtMaSach = new JTextField(25);
		JPanel pnMaSach = new JPanel(fl);
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);

		/* nhap tua sach va tac gia */
		JLabel lblTuaSach = new JLabel("Tua sach:");
		txtTuaSach = new JTextField(25);
		JLabel lblTacGia = new JLabel("Tac gia:");
		txtTacGia = new JTextField(25);
		JPanel pnTua_TacGia = new JPanel(fl);
		pnTua_TacGia.add(lblTuaSach);
		pnTua_TacGia.add(txtTuaSach);
		pnTua_TacGia.add(lblTacGia);
		pnTua_TacGia.add(txtTacGia);

		/* Nhap nam va nha xuat ban */
		JLabel lblNamXB = new JLabel("Nam xuat ban:");
		txtNamXB = new JTextField(25);
		JLabel lblNhaXB = new JLabel("Nha xuat ban:");
		txtNhaXB = new JTextField(25);
		JPanel pnNam_NhaXB = new JPanel(fl);
		pnNam_NhaXB.add(lblNamXB);
		pnNam_NhaXB.add(txtNamXB);
		pnNam_NhaXB.add(lblNhaXB);
		pnNam_NhaXB.add(txtNhaXB);

		/* Nhap so trang va don gia */
		JLabel lblSoTrang = new JLabel("So trang:");
		txtSoTrang = new JTextField(25);
		JLabel lblDonGia = new JLabel("Don gia:");
		txtDonGia = new JTextField(25);
		JPanel pnSoTrang_DonGia = new JPanel(fl);
		pnSoTrang_DonGia.add(lblSoTrang);
		pnSoTrang_DonGia.add(txtSoTrang);
		pnSoTrang_DonGia.add(lblDonGia);
		pnSoTrang_DonGia.add(txtDonGia);

		/* Nhap ISBN */
		JLabel lblISBN = new JLabel("International Standard Book Number:");
		txtISBN = new JTextField(13);
		JPanel pnISBN = new JPanel(fl);
		pnISBN.add(lblISBN);
		pnISBN.add(txtISBN);

		JPanel pnNhapLieu = new JPanel();
		pnNhapLieu.setLayout(new BoxLayout(pnNhapLieu, BoxLayout.Y_AXIS));
		pnNhapLieu.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnNhapLieu.add(pnMaSach);
		pnNhapLieu.add(pnTua_TacGia);
		pnNhapLieu.add(pnNam_NhaXB);
		pnNhapLieu.add(pnSoTrang_DonGia);
		pnNhapLieu.add(pnISBN);

		btnThem = new JButton("Them");
		btnXoaRong = new JButton("Xoa rong");
		btnSua = new JButton("Sua");
		btnXoa = new JButton("Xoa");
		btnLuu = new JButton("Luu");
		btnCtrl = new JButton[5];
		btnCtrl[0] = btnThem;
		btnCtrl[1] = btnXoaRong;
		btnCtrl[2] = btnSua;
		btnCtrl[3] = btnXoa;
		btnCtrl[4] = btnLuu;
		for (int i = 0; i < btnCtrl.length; i++) {
			btnCtrl[i].addActionListener(this);
			btnCtrl[i].setFocusable(false);
		}
		JLabel lblTimKiem = new JLabel("Tim theo ma sach:");
		cboMaSach = new JComboBox<String>();
		JPanel pnDieuKhien = new JPanel();
		pnDieuKhien.add(btnThem);
		pnDieuKhien.add(btnXoaRong);
		pnDieuKhien.add(btnXoa);
		pnDieuKhien.add(btnSua);
		pnDieuKhien.add(btnLuu);
		pnDieuKhien.add(lblTimKiem);
		pnDieuKhien.add(cboMaSach);

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(pnNhapLieu);
		pnNorth.add(pnDieuKhien, BorderLayout.SOUTH);

		/* phan bang */
		tblModel = new DefaultTableModel(col.split(";"), 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};

		StoredData stData = new StoredData();
		try {
			dsSach = (DanhSachSach) stData.loadFile(filepath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		loadDataToTable(dsSach.getDsSach(), tblModel);
		tblSach = new JTable(tblModel);
		tblSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrTable = new JScrollPane(tblSach);
		scrTable.setBorder(BorderFactory.createTitledBorder("Danh sach cac cuon sach"));

		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setLayout(new BorderLayout());
		pnBorderCha.add(scrTable);
		pnBorderCha.add(pnNorth, BorderLayout.NORTH);

		/* Canh chinh label */
		lblMaSach.setPreferredSize(lblNamXB.getPreferredSize());
		lblTuaSach.setPreferredSize(lblNamXB.getPreferredSize());
		lblSoTrang.setPreferredSize(lblNamXB.getPreferredSize());

		lblTacGia.setPreferredSize(lblNhaXB.getPreferredSize());
		lblDonGia.setPreferredSize(lblNhaXB.getPreferredSize());

		lblISBN.setPreferredSize(
				new Dimension((lblSoTrang.getPreferredSize().width + txtSoTrang.getPreferredSize().width)
						- txtISBN.getPreferredSize().width, lblSoTrang.getPreferredSize().height));

		add(pnBorderCha);

		/* Cac su kien */
		tblSach.addMouseListener(this);
		cboMaSach.addActionListener(this);

		/* Du lieu test */
		txtMaSach.setText("A001");
		txtTuaSach.setText("Annotations Reflection");
		txtTacGia.setText("Jakob Jenkov");
		txtNamXB.setText("2014");
		txtNhaXB.setText("Prentice Hall");
		txtSoTrang.setText("420");
		txtDonGia.setText("70000");
		txtISBN.setText("0-13-376131-1");
	}

	public void xoaRong() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.requestFocus();
	}

	public void loadDataToTable(ArrayList<Sach> dsSach, DefaultTableModel tblModel) {
		for (Sach s : dsSach) {
			Object[] obj = { s.getMaSach(), s.getTuaSach(), s.getTacGia(), s.getNamXB(), s.getNhaXB(), s.getSoTrang(),
					s.getDonGia(), s.getIsbn() };
			cboMaSach.addItem(s.getMaSach());
			tblModel.addRow(obj);
		}
	}

	public void loadDataToTextField(Sach s) {
		txtMaSach.setText(s.getMaSach());
		txtTuaSach.setText(s.getTuaSach());
		txtTacGia.setText(s.getTacGia());
		txtNamXB.setText(String.valueOf(s.getNamXB()));
		txtNhaXB.setText(s.getNhaXB());
		txtSoTrang.setText(String.valueOf(s.getSoTrang()));
		txtDonGia.setText(String.valueOf(s.getDonGia()));
		txtISBN.setText(s.getIsbn());
	}

	public Sach createNewBook() {
		String maSach = txtMaSach.getText();
		if (!kiemTraMaSach(maSach)) {
			JOptionPane.showMessageDialog(this, "Ma sach phai bat dau 1 chu va theo sau 3 so");
			txtMaSach.requestFocus();
			return null;
		}
		if (dsSach.kiemTraMaSachTonTai(maSach)) {
			JOptionPane.showMessageDialog(this, "Ma sach da ton tai");
			txtMaSach.requestFocus();
			return null;
		}
		String tuaSach = txtTuaSach.getText();
		if (!kiemTraTuaSach(tuaSach)) {
			txtTuaSach.requestFocus();
			JOptionPane.showMessageDialog(this, "Tua sach gom 1 hoac nhieu tu ngan cach boi khoang trang");
			return null;
		}
		String tacGia = txtTacGia.getText();
		if (!kiemTraTuaSach(tacGia)) {
			txtTacGia.requestFocus();
			JOptionPane.showMessageDialog(this, "Tac gia gom 1 hoac nhieu tu ngan cach boi khoang trang");
			return null;
		}
		String isbn = txtISBN.getText();
		if (!kiemTraISBN(isbn)) {
			JOptionPane.showMessageDialog(this, "ISBN co dang X-X-X-X hoac X-X-X-X-X");
			txtISBN.requestFocus();
			return null;
		}
		try {
			Sach s = new Sach();
			s.setMaSach(txtMaSach.getText());
			s.setTuaSach(txtTuaSach.getText());
			s.setTacGia(txtTacGia.getText());
			s.setNamXB(Integer.parseInt(txtNamXB.getText()));
			s.setNhaXB(txtNhaXB.getText());
			s.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
			s.setDonGia(Double.parseDouble(txtDonGia.getText()));
			s.setIsbn(txtISBN.getText());
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean kiemTraMaSach(String maSach) {
		String patternMaSach = "[A-Z]{1}[0-9]{3}";
		Pattern pattern = Pattern.compile(patternMaSach);
		Matcher matcher = pattern.matcher(maSach);
		return matcher.find();
	}

	public boolean kiemTraISBN(String isbn) {
		String patternISBN = "(^\\d+\\-\\d+\\-\\d+\\-\\d+$)|(^\\d+\\-\\d+\\-\\d+\\-\\d+\\-\\d+$)";
		Pattern pattern = Pattern.compile(patternISBN);
		Matcher matcher = pattern.matcher(isbn);
		return matcher.find();
	}

	public boolean kiemTraTuaSach(String tuaSach) {
		String patternTuaSach = "([a-zA-z\\']+\\s?)+";
		Pattern pattern = Pattern.compile(patternTuaSach);
		Matcher matcher = pattern.matcher(tuaSach);
		return matcher.find();
	}

	public boolean kiemTraTacGia(String tacGia) {
		String patternTacGia = "([a-zA-z\\']+\\s?)+";
		Pattern pattern = Pattern.compile(patternTacGia);
		Matcher matcher = pattern.matcher(tacGia);
		return matcher.find();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnXoaRong) {
			xoaRong();
		}
		if (action == btnThem) {
			Sach s = createNewBook();
			if (s != null) {
				dsSach.themSach(s);
				String[] dataRow = s.toString().split(";");
				tblModel.addRow(dataRow);
				cboMaSach.addItem(dataRow[0]);
				JOptionPane.showMessageDialog(this, "Them du lieu thanh cong!");
			}
		}
		if (action == btnLuu) {
			try {
				StoredData stData = new StoredData();
				if (stData.saveFile(dsSach, filepath)) {
					JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thành công!!!");
				} else {
					JOptionPane.showMessageDialog(this, "Lưu thông tin nhân viên thất bại!!!");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (action == btnXoa) {
			int row = tblSach.getSelectedRow();
			if (row != -1) {
				Sach s = dsSach.getDsSach().get(row);
				if (JOptionPane.showConfirmDialog(this, "Ban co chan chan muon xoa sach " + s.getMaSach(), "Xac nhan",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (dsSach.xoaSach(s)) {
						tblModel.removeRow(row);
						cboMaSach.removeItem(s.getMaSach());
						JOptionPane.showMessageDialog(this, "Xoa thanh cong");
					} else {
						JOptionPane.showMessageDialog(this, "Xoa khong thanh cong");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Hay chon sach muon xoa truoc");
			}
		}
		if (action == btnSua) {
			int selectRow = tblSach.getSelectedRow();
			if (selectRow < 0) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sách bạn muốn sửa!!!");
			} else {
				Sach item = dsSach.getDsSach().get(selectRow);
				Sach itemNew = new Sach();
				try {
					itemNew.setTuaSach(txtTuaSach.getText());
					itemNew.setMaSach(txtMaSach.getText());
					itemNew.setTacGia(txtTacGia.getText());
					itemNew.setNamXB(Integer.parseInt(txtNamXB.getText()));
					itemNew.setNhaXB(txtNhaXB.getText());
					itemNew.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
					itemNew.setDonGia(Double.parseDouble(txtDonGia.getText()));
					itemNew.setIsbn(txtISBN.getText());
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (dsSach.suaSach(item, itemNew)) {
						tblSach.setModel(tblModel = new DefaultTableModel(col.split(";"), 0));
						loadDataToTable(dsSach.getDsSach(), tblModel);
						JOptionPane.showMessageDialog(this, "Cập nhật thành công!!!");
					} else {
						JOptionPane.showMessageDialog(this, "Cập nhật không thành công!!!");
					}
				}
			}
		}
		if (action == cboMaSach) {
			int row = cboMaSach.getSelectedIndex();
			tblSach.setRowSelectionInterval(row, row);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblSach.getSelectedRow();
		Sach s = dsSach.getDsSach().get(row);
		loadDataToTextField(s);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {
		new GUIQuanLySach("Quan ly sach").doShow();
	}
}
