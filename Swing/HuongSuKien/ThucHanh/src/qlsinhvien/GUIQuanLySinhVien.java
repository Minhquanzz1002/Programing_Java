package qlsinhvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class GUIQuanLySinhVien extends JFrame implements ActionListener{
	private JButton btnThem, btnLuu, btnSua, btnXoa, btnXemTTSV, btnTiepTheo, btnLuiLai, btnVeCuoi, btnVeDau;
	private JTable tblLop;
	private DefaultTableModel tblModel;
	private String[] cols = {"Mã lớp", "Tên lớp", "Sĩ số"};
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
		JLabel lblTieuDe = new JLabel("THÔNG TIN LỚP HỌC", JLabel.CENTER);
		lblTieuDe.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
		
		tblModel = new DefaultTableModel(cols, 0);
		tblLop = new JTable(tblModel);
		JScrollPane scrTable = new JScrollPane(tblLop);
		
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
		JTextField txtMaLop = new JTextField(20);
		JPanel pnMaLop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnMaLop.add(lblMaLop);
		pnMaLop.add(txtMaLop);
		
		JLabel lblTenLop = new JLabel("Tên lớp");
		JTextField txtTenLop = new JTextField(47);
		JPanel pnTenLop = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnTenLop.add(lblTenLop);
		pnTenLop.add(txtTenLop);
		
		JLabel lblSiSo = new JLabel("Sĩ số");
		JTextField txtSiSo = new JTextField(3);
		txtSiSo.setEditable(false);
		JPanel pnSiSo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnSiSo.add(lblSiSo);
		pnSiSo.add(txtSiSo);
		
		JPanel pnNhapLieu = new JPanel();
		pnNhapLieu.setLayout(new BoxLayout(pnNhapLieu, BoxLayout.Y_AXIS));
		pnNhapLieu.add(pnMaLop);
		pnNhapLieu.add(pnTenLop);
		pnNhapLieu.add(pnSiSo);
		
		lblMaLop.setPreferredSize(new Dimension(lblTenLop.getPreferredSize().width, lblTenLop.getPreferredSize().height));
		lblSiSo.setPreferredSize(new Dimension(lblTenLop.getPreferredSize().width, lblTenLop.getPreferredSize().height));
		
		// Phan cac nut bam
		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);
		btnLuu = new JButton("Lưu");
		btnLuu.setFocusable(false);
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
	}
	
	public void loadDataFromSQL() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new GUIQuanLySinhVien("Sinh Viên").doShow();
	}
}
