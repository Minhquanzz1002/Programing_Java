package tuan09.qlsinhvien_lop.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import tuan09.qlsinhvien_lop.dao.SinhVienDAO;
import tuan09.qlsinhvien_lop.entity.SinhVien;
import tuan09.qlsinhvien_lop.model.SinhVienModel;

public class GUIQuanLySinhVien extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnThem, btnLuu, btnSua, btnXoa, btnXemTTLH, btnTiepTheo, btnLuiLai, btnVeCuoi, btnVeDau;
	private JTable tblSinhVien;
	private SinhVienDAO sinhVienDAO;
	private Box b, b1, b2, b3, b4_1, b4_2, b4, b5, b6;
	private JTextField txtMaSV, txtHo, txtTen, txtEmail, txtDiaChi;
	private JRadioButton radNam, radNu;
	private ButtonGroup btnGroupPhai;
	private JComboBox<String> cboMaLop;

	public GUIQuanLySinhVien(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		JLabel lblTieuDe = new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER);
		lblTieuDe.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

		// Phan bang
		sinhVienDAO = new SinhVienDAO();
		tblSinhVien = new JTable();
		tblSinhVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrTable = new JScrollPane(tblSinhVien);
		try {
			SinhVienModel sinhVienModel = new SinhVienModel(sinhVienDAO.getDSSinhVien());
			tblSinhVien.setModel(sinhVienModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Phan chuyen doi trang
		btnTiepTheo = new JButton(">");
		btnTiepTheo.setFocusable(false);
		btnLuiLai = new JButton("<");
		btnLuiLai.setFocusable(false);
		btnVeDau = new JButton("<<");
		btnVeDau.setFocusable(false);
		btnVeCuoi = new JButton(">>");
		btnVeCuoi.setFocusable(false);
		JPanel pnChuyenDoi = new JPanel();
		pnChuyenDoi.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		pnChuyenDoi.add(btnLuiLai);
		pnChuyenDoi.add(btnVeDau);
		pnChuyenDoi.add(btnVeCuoi);
		pnChuyenDoi.add(btnTiepTheo);

		// Phan nhap du lieu
		b = Box.createVerticalBox();
		b.add(Box.createHorizontalStrut(10));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b4 = Box.createHorizontalBox());
		b4.add(b4_1 = Box.createHorizontalBox());
		b4.add(b4_2 = Box.createHorizontalBox());

		b.add(Box.createHorizontalStrut(10));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b.add(b6 = Box.createHorizontalBox());

		JLabel lblMaSV = new JLabel("Mã sinh viên");
		txtMaSV = new JTextField(40);
		b1.add(lblMaSV);
		b1.add(txtMaSV);

		JLabel lblHo = new JLabel("Họ");
		txtHo = new JTextField(40);
		b2.add(lblHo);
		b2.add(txtHo);

		JLabel lblTen = new JLabel("Tên");
		txtTen = new JTextField(40);
		b3.add(lblTen);
		b3.add(txtTen);

		JLabel lblMaLop = new JLabel("Mã lớp");
		cboMaLop = new JComboBox<String>();
		loadMaLop();
		b4_1.add(lblMaLop);
		b4_1.add(cboMaLop);

		JLabel lblPhai = new JLabel("Phái");
		radNam = new JRadioButton("Nam");
		radNam.setActionCommand("Nam");
		radNam.setFocusable(false);
		radNam.setSelected(true);
		radNu = new JRadioButton("Nữ");
		radNu.setActionCommand("Nữ");
		radNu.setFocusable(false);
		btnGroupPhai = new ButtonGroup();
		btnGroupPhai.add(radNam);
		btnGroupPhai.add(radNu);
		b4_2.add(lblPhai);
		b4_2.add(radNam);
		b4_2.add(radNu);

		JLabel lblEmail = new JLabel("Email");
		txtEmail = new JTextField(40);
		b5.add(lblEmail);
		b5.add(txtEmail);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		txtDiaChi = new JTextField(40);
		b6.add(lblDiaChi);
		b6.add(txtDiaChi);

		lblHo.setPreferredSize(lblMaSV.getPreferredSize());
		lblTen.setPreferredSize(lblMaSV.getPreferredSize());
		lblMaLop.setPreferredSize(lblMaSV.getPreferredSize());
		lblEmail.setPreferredSize(lblMaSV.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaSV.getPreferredSize());

		// Phan cac nut bam
		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnLuu = new JButton("Lưu");
		btnLuu.setFocusable(false);
		btnLuu.setEnabled(false);
		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);
		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);
		btnXemTTLH = new JButton("Xem thông tin lớp học");
		btnXemTTLH.setFocusable(false);
		JPanel pnNutBam = new JPanel();
		pnNutBam.add(btnThem);
		pnNutBam.add(btnLuu);
		pnNutBam.add(btnSua);
		pnNutBam.add(btnXoa);
		pnNutBam.add(btnXemTTLH);

		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BorderLayout());
		pnSouth.add(pnChuyenDoi, BorderLayout.NORTH);
		pnSouth.add(b);
		pnSouth.add(pnNutBam, BorderLayout.SOUTH);

		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setLayout(new BorderLayout());
		pnBorderCha.add(lblTieuDe, BorderLayout.NORTH);
		pnBorderCha.add(scrTable);
		pnBorderCha.add(pnSouth, BorderLayout.SOUTH);
		add(pnBorderCha);

		// Cac su kien
		tblSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					List<SinhVien> dssv = sinhVienDAO.getDSSinhVien();
					int rowIndex = tblSinhVien.getSelectedRow();
					if (rowIndex >= 0 && rowIndex <= dssv.size()) {
						SinhVien sinhVien = dssv.get(rowIndex);
						txtMaSV.setText(sinhVien.getMaSV());
						txtHo.setText(sinhVien.getHo());
						txtTen.setText(sinhVien.getTen());
						String phai = sinhVien.getPhai();
						if (phai.equals("Nam")) {
							radNam.setSelected(true);
						} else {
							radNu.setSelected(true);
						}
						txtEmail.setText(sinhVien.getEmail());
						txtDiaChi.setText(sinhVien.getDiaChi());
						cboMaLop.setSelectedItem(sinhVien.getMaLop());
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemTTLH.addActionListener(this);

		// Du lieu test
		txtMaSV.setText("SV00000001");
		txtHo.setText("Nguyen");
		txtTen.setText("Quan");
		txtEmail.setText("20098151.quan@student.iuh.edu.vn");
		txtDiaChi.setText("Ben Tre");
	}

	public void loadMaLop() {
		List<String> dsMaLop = sinhVienDAO.getDSMaLop();
		for (String maLop : dsMaLop) {
			cboMaLop.addItem(maLop);
		}
	}

	public SinhVien taoSinhVienTuTextField() {
		String maSV = txtMaSV.getText();
		if (!maSV.matches("^(SV)[0-9]{8}")) {
			showMessage(txtMaSV, "Mã sinh viên bắt đầu bằng SV và theo sau bởi 8 số");
			return null;
		}
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		String phai = btnGroupPhai.getSelection().getActionCommand();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String maLop = (String) cboMaLop.getSelectedItem();
		return new SinhVien(maSV, ho, ten, phai, email, diaChi, maLop);
	}

	public void showMessage(JTextField txtFiled, String message) {
		JOptionPane.showMessageDialog(this, message);
		txtFiled.selectAll();
		txtFiled.requestFocus();
	}

	public void loadDataToTable() {
		SinhVienModel sinhVienModel = new SinhVienModel(sinhVienDAO.getDSSinhVien());
		tblSinhVien.setModel(sinhVienModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnThem) {
			SinhVien sinhVien = taoSinhVienTuTextField();
			if (sinhVien != null) {
				if (sinhVienDAO.themSinhVien(sinhVien)) {
					loadDataToTable();
					JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Thêm sinh viên không thành công");
				}
			}
		}
		if (action == btnXoa) {
			SinhVien sinhVien = taoSinhVienTuTextField();
			if (sinhVien != null) {
				if (sinhVienDAO.xoaSinhVien(sinhVien)) {
					loadDataToTable();
					JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Xóa sinh viên không thành công");
				}
			}

		}
		if (action == btnSua) {
			SinhVien sinhVien = taoSinhVienTuTextField();
			if (sinhVien != null) {
				if (sinhVienDAO.suaSinhVien(sinhVien)) {
					loadDataToTable();
					JOptionPane.showMessageDialog(null, "Sửa sinh viên thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Sửa sinh viên không thành công");
				}
			}
		}
		if (action == btnXemTTLH) {
			setVisible(false);
			new GUIQuanLyLopHoc("Lớp học").doShow();
		}

	}
}
