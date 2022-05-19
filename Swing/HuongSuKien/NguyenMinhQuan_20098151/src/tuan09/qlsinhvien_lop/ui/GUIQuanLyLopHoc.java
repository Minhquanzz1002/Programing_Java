package tuan09.qlsinhvien_lop.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

import tuan09.qlsinhvien_lop.dao.LopHocDAO;
import tuan09.qlsinhvien_lop.entity.LopHoc;
import tuan09.qlsinhvien_lop.model.LopHocModel;

public class GUIQuanLyLopHoc extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnThem, btnLuu, btnSua, btnXoa, btnXemTTSV, btnTiepTheo, btnLuiLai, btnVeCuoi, btnVeDau;
	private JTable tblLop;
	private LopHocDAO lopHocDAO;
	private JTextField txtMaLop, txtTenLop, txtSiSo;

	public GUIQuanLyLopHoc(String tieuDeCuaSo) {
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
		JLabel lblTieuDe = new JLabel("THÔNG TIN LỚP HỌC", JLabel.CENTER);
		lblTieuDe.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

		// Phan bang
		lopHocDAO = new LopHocDAO();
		tblLop = new JTable();
		tblLop.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrTable = new JScrollPane(tblLop);
		try {
			LopHocModel lopHocModel = new LopHocModel(lopHocDAO.getDSLopHoc());
			tblLop.setModel(lopHocModel);
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
		JLabel lblMaLop = new JLabel("Mã lớp");
		txtMaLop = new JTextField(20);
		JPanel pnMaLop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnMaLop.add(lblMaLop);
		pnMaLop.add(txtMaLop);

		JLabel lblTenLop = new JLabel("Tên lớp");
		txtTenLop = new JTextField(47);
		JPanel pnTenLop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnTenLop.add(lblTenLop);
		pnTenLop.add(txtTenLop);

		JLabel lblSiSo = new JLabel("Sĩ số");
		txtSiSo = new JTextField(3);
		txtSiSo.setEditable(false);
		JPanel pnSiSo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSiSo.add(lblSiSo);
		pnSiSo.add(txtSiSo);

		JPanel pnNhapLieu = new JPanel();
		pnNhapLieu.setLayout(new BoxLayout(pnNhapLieu, BoxLayout.Y_AXIS));
		pnNhapLieu.add(pnMaLop);
		pnNhapLieu.add(pnTenLop);
		pnNhapLieu.add(pnSiSo);

		lblMaLop.setPreferredSize(lblTenLop.getPreferredSize());
		lblSiSo.setPreferredSize(lblTenLop.getPreferredSize());

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
		btnXemTTSV = new JButton("Xem thông tin sinh viên");
		btnXemTTSV.setFocusable(false);
		JPanel pnNutBam = new JPanel();
		pnNutBam.add(btnThem);
		pnNutBam.add(btnLuu);
		pnNutBam.add(btnSua);
		pnNutBam.add(btnXoa);
		pnNutBam.add(btnXemTTSV);

		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BorderLayout());
		pnSouth.add(pnChuyenDoi, BorderLayout.NORTH);
		pnSouth.add(pnNhapLieu);
		pnSouth.add(pnNutBam, BorderLayout.SOUTH);

		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setLayout(new BorderLayout());
		pnBorderCha.add(lblTieuDe, BorderLayout.NORTH);
		pnBorderCha.add(scrTable);
		pnBorderCha.add(pnSouth, BorderLayout.SOUTH);
		add(pnBorderCha);

		// Cac su kien
		tblLop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					List<LopHoc> dslh = lopHocDAO.getDSLopHoc();
					int rowIndex = tblLop.getSelectedRow();
					if (rowIndex >= 0 && rowIndex <= dslh.size()) {
						LopHoc lopHoc = dslh.get(rowIndex);
						txtMaLop.setText(lopHoc.getMaLop());
						txtTenLop.setText(lopHoc.getTenLop());
						txtSiSo.setText(String.valueOf(lopHoc.getSiSo()));
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXemTTSV.addActionListener(this);
	}

	public LopHoc taoLopHoc() {
		if (valid()) {
			String maLop = txtMaLop.getText();
			String tenLop = txtTenLop.getText();
			LopHoc lopHoc = new LopHoc(maLop, tenLop);
			return lopHoc;
		}
		return null;
	}
	
	private boolean valid() {
		String maLop = txtMaLop.getText();
		if (!maLop.matches("^(DH)[A-Z]{2,}[0-9]{2}[A-Z]{1}(TT)?")) {
			showMessage(txtMaLop, "Mã lớp dạng DHXY");
			return false;
		}
		return true;
	}
	
	private void showMessage(JTextField txtField, String message) {
		JOptionPane.showMessageDialog(this, message);
		txtField.selectAll();	// Chon toan bo text cua field
		txtField.requestFocus();
	}
	
	public void loadDataToTable() {
		LopHocModel lopHocModel = new LopHocModel(lopHocDAO.getDSLopHoc());
		tblLop.setModel(lopHocModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnThem) {
			LopHoc lopHoc = taoLopHoc();
			if (lopHoc != null) {
				if (!lopHocDAO.themLopHoc(lopHoc)) {
					JOptionPane.showMessageDialog(null, "Thêm không thành công");
				}else {
					loadDataToTable();
				}
			}
		}
		if (action == btnXoa) {
			LopHoc lopHoc = taoLopHoc();
			if (lopHoc != null) {
				if (!lopHocDAO.xoaLopHoc(lopHoc)) {
					JOptionPane.showMessageDialog(null, "Xóa không thành công");
				} else {
					loadDataToTable();
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				}
			}
		}
		if (action == btnSua) {
			LopHoc lopHoc = taoLopHoc();
			if (lopHoc != null) {
				if (!lopHocDAO.suaLopHoc(lopHoc)) {
					JOptionPane.showMessageDialog(null, "Sửa không thành công");
				} else {
					loadDataToTable();
					JOptionPane.showMessageDialog(null, "Sửa thành công");
				}
			}
		}
		if (action == btnXemTTSV) {
			setVisible(false);
			new GUIQuanLySinhVien("Sinh viên").doShow();
		}
	}

}
