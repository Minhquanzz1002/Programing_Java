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

import tuan10.qlsinhvien_lop.dao.SinhVienDAO;
import tuan10.qlsinhvien_lop.dao.LopHocDAO;
import tuan10.qlsinhvien_lop.entity.LopHoc;
import tuan10.qlsinhvien_lop.entity.SinhVien;
import tuan10.qlsinhvien_lop.model.LopHocModel;
import tuan10.qlsinhvien_lop.model.SinhVienModel;

public class GuiThongTinSinhVien extends JFrame implements ActionListener{
	JButton btnThem, btnLuu, btnSua, btnXoa, btnTien, btnLui, btnVeDau, btnVeCuoi;
	JTable tblSinhVien;
	private SinhVienDAO sinhVienDAO;
	private JLabel lblTenTrang;
	private Icon iconTien, iconLui, iconVeDau, iconVeCuoi;
	private LopHoc lopHoc;
	private SinhVienModel model;
	private JTextField txtMaSV, txtHoTen, txtEmail, txtDiaChi;
	private SinhVien sv;
	private int loai;
	public GuiThongTinSinhVien(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public void doShow() {
		setTitle("Thông tin sinh viên");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		/* Phan tieu de*/
		JLabel lblTieuDe = new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER);
		lblTieuDe.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		lblTieuDe.setForeground(Color.BLUE);

		/* Phan nhap du lieu*/
		JLabel lblMaSV = new JLabel("Mã số sinh viên: ", JLabel.RIGHT);
		txtMaSV = new JTextField(30);
		Box b1 = Box.createHorizontalBox();
		b1.add(lblMaSV);
		b1.add(txtMaSV);

		JLabel lblHoTen = new JLabel("Họ tên: ", JLabel.RIGHT);
		txtHoTen = new JTextField(30);
		Box b2 = Box.createHorizontalBox();
		b2.add(lblHoTen);
		b2.add(txtHoTen);

		JLabel lblEmail = new JLabel("Email: ", JLabel.RIGHT);
		txtEmail = new JTextField(30);
		Box b3 = Box.createHorizontalBox();
		b3.add(lblEmail);
		b3.add(txtEmail);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ", JLabel.RIGHT);
		txtDiaChi = new JTextField(30);
		Box b4 = Box.createHorizontalBox();
		b4.add(lblDiaChi);
		b4.add(txtDiaChi);		

		Box b = Box.createVerticalBox();
		b.add(b1);
		b.add(Box.createVerticalStrut(10));
		b.add(b2);
		b.add(Box.createVerticalStrut(10));
		b.add(b3);
		b.add(Box.createVerticalStrut(10));
		b.add(b4);

		/* Cac nut bam*/
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

		/* Cac nut chuyen trang*/
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

		/*Phan bang*/
		sinhVienDAO = new SinhVienDAO();
		model = new SinhVienModel(sinhVienDAO.getDSSV(lopHoc));
		tblSinhVien = new JTable(model);
		tblSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrTable = new JScrollPane(tblSinhVien);
		scrTable.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên của lớp: " + lopHoc.getTenLop()));


		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setLayout(new BorderLayout());
		pnBorderCha.add(pnNorth, BorderLayout.NORTH);
		pnBorderCha.add(scrTable);
		add(pnBorderCha);

		/*Chinh do dai label*/
		lblHoTen.setPreferredSize(lblMaSV.getPreferredSize());
		lblEmail.setPreferredSize(lblMaSV.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaSV.getPreferredSize());

		/*Cac su kien*/
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThem.addActionListener(this);
		btnTien.addActionListener(this);
		btnVeCuoi.addActionListener(this);
		btnLui.addActionListener(this);
		btnVeDau.addActionListener(this);
		tblSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				loadViTriChon();
				int row = tblSinhVien.getSelectedRow();
				loadDataToTextField(row);
			}
		});
		loadViTriChon();
	}
	
	public void loadViTriChon() {
		int rowIndex = tblSinhVien.getSelectedRow() + 1;
		int lengthColumn = tblSinhVien.getRowCount();
		lblTenTrang.setText(rowIndex + "/" + lengthColumn);
	}
	
	public void loadDataToTextField(int row) {
		SinhVien sinhVien = sinhVienDAO.getDSSV().get(row);
		txtMaSV.setText(sinhVien.getMaSV());
		txtHoTen.setText(sinhVien.getHoTen());
		txtEmail.setText(sinhVien.getEmail());
		txtDiaChi.setText(sinhVien.getDiaChi());
	}

	public SinhVien taoSinhVien() {
		try {
			String maSV, hoTen, diaChi, email;
			maSV = txtMaSV.getText();
			hoTen = txtHoTen.getText();
			diaChi = txtDiaChi.getText();
			email = txtEmail.getText();
			return new SinhVien(maSV, hoTen, email, diaChi, lopHoc.getMaLop());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void batChuyenTrang(boolean bat) {
		btnLui.setEnabled(bat);
		btnTien.setEnabled(bat);
		btnVeDau.setEnabled(bat);
		btnVeCuoi.setEnabled(bat);
	}
	
	public void loadDataToTable() {
		model = new SinhVienModel(sinhVienDAO.getDSSV(lopHoc));
		tblSinhVien.setModel(model);
		loadViTriChon();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnTien) {
			int row = tblSinhVien.getSelectedRow();
			if (row != -1 && row != (tblSinhVien.getRowCount() - 1)) {
				tblSinhVien.setRowSelectionInterval(row + 1, row + 1);
				loadViTriChon();
				loadDataToTextField(row + 1);
			}
		}
		if (action == btnVeCuoi) {
			int row = tblSinhVien.getRowCount() - 1;
			tblSinhVien.setRowSelectionInterval(row, row);
			loadViTriChon();
			loadDataToTextField(row);
		}
		if (action == btnLui) {
			int row = tblSinhVien.getSelectedRow();
			if (row > 0) {
				tblSinhVien.setRowSelectionInterval(row - 1, row - 1);
				loadViTriChon();
				loadDataToTextField(row-1);
			}
		}
		if (action == btnVeDau) {
			tblSinhVien.setRowSelectionInterval(0, 0);
			loadViTriChon();
			loadDataToTextField(0);
		}
		
		if (action == btnThem) {
			if (btnThem.getText().equals("Thêm")) {
				sv = taoSinhVien();
				if (sv != null) {
					btnThem.setText("Hủy");
					btnLuu.setEnabled(true);
					btnSua.setEnabled(false);
					btnXoa.setEnabled(false);
					batChuyenTrang(false);
					loai = 1;
				}
			} else {
				sv = null;
				btnThem.setText("Thêm");
				btnLuu.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);
				batChuyenTrang(true);
			}
		}
		if (action == btnLuu) {
			if (loai == 1) {
				if (sinhVienDAO.themSinhVien(sv)) {
					loadDataToTable();
//					clearTextFields();
					btnThem.setText("Thêm");
					btnLuu.setEnabled(false);
					btnSua.setEnabled(true);
					btnXoa.setEnabled(true);
					batChuyenTrang(true);
					JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm sinh viên không thành công");
				}
			}
//			if (loai == 2) {
//				if (lopHocDAO.suaLopHoc(lopHoc)) {
//					loadDataToTable();
//					clearTextFields();
//					JOptionPane.showMessageDialog(this, "Sửa lớp học thành công");
//				}else {
//					JOptionPane.showMessageDialog(this, "Sửa lớp học không thành công");
//				}
//			}
		}
		
		if (action == btnXoa) {
			int row = tblSinhVien.getSelectedRow();
			if (row != -1) {
				sv = sinhVienDAO.getDSSV(lopHoc).get(row);
				if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa sinh viên "+ sv.getMaSV() + " chứ?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (sinhVienDAO.xoaSinhVien(sv)) {
						loadDataToTable();
						JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công");
					}else {
						JOptionPane.showMessageDialog(this, "Xóa sinh viên không thành công");
					}
				}
			}else {
				JOptionPane.showMessageDialog(this, "Hãy chọn sinh viên muốn xóa trước");
			}
		}
	}
}
