package tuan10.qlsinhvien_lop.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import tuan10.qlsinhvien_lop.dao.LopHocDAO;
import tuan10.qlsinhvien_lop.entity.LopHoc;
import tuan10.qlsinhvien_lop.model.LopHocModel;

public class GuiThongTinLopHoc extends JFrame implements ActionListener {
	JButton btnThem, btnLuu, btnSua, btnXoa, btnXemDSLH, btnTien, btnLui, btnVeDau, btnVeCuoi;
	JTable tblLopHoc;
	private JTextField txtMaLop, txtTenLop, txtGiaoVien;
	private LopHocDAO lopHocDAO;
	private JLabel lblTenTrang;
	private Icon iconTien, iconLui, iconVeDau, iconVeCuoi;
	private LopHoc lopHoc;
	private LopHocModel model;
	private int loai;

	public GuiThongTinLopHoc(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		JLabel lblTieuDe = new JLabel("THÔNG TIN LỚP HỌC", JLabel.CENTER);
		lblTieuDe.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

		JLabel lblMalop = new JLabel("Mã lớp: ", JLabel.RIGHT);
		txtMaLop = new JTextField(20);
		Box b1 = Box.createHorizontalBox();
		b1.add(lblMalop);
		b1.add(txtMaLop);

		JLabel lblTenlop = new JLabel("Tên lớp: ", JLabel.RIGHT);
		txtTenLop = new JTextField(20);
		Box b2 = Box.createHorizontalBox();
		b2.add(lblTenlop);
		b2.add(txtTenLop);

		JLabel lblGiaoVien = new JLabel("Giáo viên chủ nhiệm: ", JLabel.RIGHT);
		txtGiaoVien = new JTextField(20);
		Box b3 = Box.createHorizontalBox();
		b3.add(lblGiaoVien);
		b3.add(txtGiaoVien);

		Box b = Box.createVerticalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnLuu = new JButton("Lưu");
		btnLuu.setFocusable(false);
		btnLuu.setEnabled(false);
		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);
		JPanel pnNutBam = new JPanel();
		pnNutBam.add(btnThem);
		pnNutBam.add(btnLuu);
		pnNutBam.add(btnSua);
		pnNutBam.add(btnXoa);

		iconTien = new ImageIcon("img/Tien.png");
		btnTien = new JButton(iconTien);
		btnTien.setFocusable(false);
		iconLui = new ImageIcon("img/Lui.png");
		btnLui = new JButton(iconLui);
		btnLui.setFocusable(false);
		lblTenTrang = new JLabel();
		iconVeDau = new ImageIcon("img/VeDau.png");
		btnVeDau = new JButton(iconVeDau);
		btnVeDau.setFocusable(false);
		iconVeCuoi = new ImageIcon("img/VeCuoi.png");
		btnVeCuoi = new JButton(iconVeCuoi);
		btnVeCuoi.setFocusable(false);
		JPanel pnChuyenTrang = new JPanel();

		pnChuyenTrang.add(btnVeDau);
		pnChuyenTrang.add(btnLui);
		pnChuyenTrang.add(lblTenTrang);
		pnChuyenTrang.add(btnTien);
		pnChuyenTrang.add(btnVeCuoi);

		JPanel pnThaoTac = new JPanel();
		pnThaoTac.setLayout(new GridLayout(1, 2));
		pnThaoTac.add(pnChuyenTrang);
		pnThaoTac.add(pnNutBam);

		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.add(lblTieuDe, BorderLayout.NORTH);
		pnNorth.add(b, BorderLayout.CENTER);
		pnNorth.add(pnThaoTac, BorderLayout.SOUTH);

		lopHocDAO = new LopHocDAO();
		model = new LopHocModel(lopHocDAO.getDSLopHoc());
		tblLopHoc = new JTable(model);
		tblLopHoc.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrTable = new JScrollPane(tblLopHoc);
		scrTable.setBorder(BorderFactory.createTitledBorder("Danh sách lớp học"));

		btnXemDSLH = new JButton("Xem danh sách sinh viên của lớp học");
		btnXemDSLH.setForeground(Color.RED);
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnSouth.add(btnXemDSLH);

		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setLayout(new BorderLayout());
		pnBorderCha.add(pnNorth, BorderLayout.NORTH);
		pnBorderCha.add(scrTable);
		pnBorderCha.add(pnSouth, BorderLayout.SOUTH);
		add(pnBorderCha);

		lblMalop.setPreferredSize(lblGiaoVien.getPreferredSize());
		lblTenlop.setPreferredSize(lblGiaoVien.getPreferredSize());

		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTien.addActionListener(this);
		btnVeCuoi.addActionListener(this);
		btnLui.addActionListener(this);
		btnVeDau.addActionListener(this);
		btnXemDSLH.addActionListener(this);
		tblLopHoc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				loadViTriChon();
				int row = tblLopHoc.getSelectedRow();
				loadDataToTextField(row);
			}
		});

		loadViTriChon();
	}

	public LopHoc taoLopHoc() {
		String maLop, tenLop, giaoVien;
		maLop = txtMaLop.getText();
		tenLop = txtTenLop.getText();
		giaoVien = txtGiaoVien.getText();
		if (maLop.trim().isEmpty()) {
			showMessenger(txtMaLop, "Hãy nhập đầy đủ thông tin trước");
			return null;
		}
		if (tenLop.trim().isEmpty()) {
			showMessenger(txtTenLop, "Hãy nhập đầy đủ thông tin trước");
			return null;
		}
		if (giaoVien.trim().isEmpty()) {
			showMessenger(txtGiaoVien, "Hãy nhập đầy đủ thông tin trước");
			return null;
		}
		if (!maLop.matches("^(DHTH)[0-9]{2}[A-Z]{1}$")) {
			showMessenger(txtMaLop, "Mã lớp không hợp lệ");
			return null;
		}

		return new LopHoc(maLop, tenLop, giaoVien);
	}

	public void clearTextFields() {
		txtMaLop.setText("");
		txtTenLop.setText("");
		txtGiaoVien.setText("");
	}
	
	public void showMessenger(JTextField txtField, String messenger) {
		txtField.selectAll();
		txtField.requestFocus();
		JOptionPane.showMessageDialog(this, messenger);
	}

	public void loadViTriChon() {
		int rowIndex = tblLopHoc.getSelectedRow() + 1;
		int lengthColumn = tblLopHoc.getRowCount();
		lblTenTrang.setText(rowIndex + "/" + lengthColumn);
	}

	/**
	 * 
	 * @param row
	 */
	public void loadDataToTextField(int row) {
		LopHoc lopHoc = lopHocDAO.getDSLopHoc().get(row);
		txtMaLop.setText(lopHoc.getMaLop());
		txtTenLop.setText(lopHoc.getTenLop());
		txtGiaoVien.setText(lopHoc.getGiaoVien());
	}
	
	public void batChuyenTrang(boolean bat) {
		btnLui.setEnabled(bat);
		btnTien.setEnabled(bat);
		btnVeDau.setEnabled(bat);
		btnVeCuoi.setEnabled(bat);
	}
	
	public void loadDataToTable() {
		LopHocModel model = new LopHocModel(lopHocDAO.getDSLopHoc());
		tblLopHoc.setModel(model);
		loadViTriChon();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnThem) {
			if (btnThem.getText().equals("Thêm")) {
				lopHoc = taoLopHoc();
				if (lopHoc != null) {
					btnThem.setText("Hủy");
					btnLuu.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					batChuyenTrang(false);
					loai = 1;
				}
			} else {
				lopHoc = null;
				btnThem.setText("Thêm");
				btnLuu.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				batChuyenTrang(true);
			}
		}
		if (action == btnLuu) {
			if (loai == 1) {
				if (lopHocDAO.themLopHoc(lopHoc)) {
					loadDataToTable();
					clearTextFields();
					btnThem.setText("Thêm");
					btnLuu.setEnabled(false);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
					batChuyenTrang(true);
					JOptionPane.showMessageDialog(this, "Thêm lớp học thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm lớp học không thành công");
				}
			}
			if (loai == 2) {
				if (lopHocDAO.suaLopHoc(lopHoc)) {
					loadDataToTable();
					clearTextFields();
					JOptionPane.showMessageDialog(this, "Sửa lớp học thành công");
				}else {
					JOptionPane.showMessageDialog(this, "Sửa lớp học không thành công");
				}
			}
		}
		if (action == btnSua) {
			if (btnSua.getText().equals("Sửa")) {
				lopHoc = taoLopHoc();
				if (lopHoc != null) {
					btnSua.setText("Hủy");
					btnLuu.setEnabled(true);
					loai = 2;
				}
			}else {
				lopHoc = null;
				btnSua.setText("Sửa");
				btnLuu.setEnabled(false);
			}
		}
		if (action == btnXoa) {
			int row = tblLopHoc.getSelectedRow();
			if (row != -1) {
				LopHoc lopHoc = lopHocDAO.getDSLopHoc().get(row);
				if (JOptionPane.showConfirmDialog(this, "Nếu xóa lớp " + lopHoc.getTenLop() + " thì toàn bộ sinh viên trong lớp sẽ bị xóa", "Xác nhận xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (lopHocDAO.xoaLopHoc(lopHoc)) {
						loadDataToTable();
						clearTextFields();
						JOptionPane.showMessageDialog(this, "Xóa lớp học thành công");
					}else {
						JOptionPane.showMessageDialog(this, "Xóa lớp học không thành công");
					}
				}
			}else {
				JOptionPane.showMessageDialog(this, "Hãy chọn lớp học muốn xóa trước");
			}
		}
		if (action == btnTien) {
			int row = tblLopHoc.getSelectedRow();
			if (row != -1 && row != (tblLopHoc.getRowCount() - 1)) {
				tblLopHoc.setRowSelectionInterval(row + 1, row + 1);
				loadViTriChon();
				loadDataToTextField(row + 1);
			}
		}
		if (action == btnVeCuoi) {
			int row = tblLopHoc.getRowCount() - 1;
			tblLopHoc.setRowSelectionInterval(row, row);
			loadViTriChon();
			loadDataToTextField(row);
		}
		if (action == btnLui) {
			int row = tblLopHoc.getSelectedRow();
			if (row > 0) {
				tblLopHoc.setRowSelectionInterval(row - 1, row - 1);
				loadViTriChon();
				loadDataToTextField(row - 1);
			}
		}
		if (action == btnVeDau) {
			tblLopHoc.setRowSelectionInterval(0, 0);
			loadViTriChon();
			loadDataToTextField(0);
		}
		if (action == btnXemDSLH) {
			int row = tblLopHoc.getSelectedRow();
			if (row != -1) {
				new GuiThongTinSinhVien(lopHocDAO.getDSLopHoc().get(row)).doShow();
			} else {
				JOptionPane.showMessageDialog(this, "Chọn lớp cần xem trước");
			}

		}
	}

}
