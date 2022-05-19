package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class GUI_NhanSu {
	// Nhân Sự
	
	private JTextField txtMaNS;
	private JTextField txtHoDem;
	private JTextField txtTenNs;
	private JTextField txtTim;
	
	@SuppressWarnings("unused")
	private DefaultTableModel dtmNhanSu;
	
	private JTable tblDsNhanSu;
	private JDateChooser txtNgaySinh;
	private JComboBox<String> cboPhongBan;
	private JComboBox<String> cboChuyenMon;
	private JSpinField txtTuoi;
	private JButton btnLuuNS;
	private JButton btnXoaTextNS;
	private JButton btnSuaTTNS;
	private JButton btnXoaNS;
	private JComboBox<String> cboHienThiDS;
	private JButton btnTim;
	private JTextField txtSdt;

	// Nhân Sự
	public GUI_NhanSu() {
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Component tabNhanSu() {
		JPanel pnNhanSu = new JPanel();
		pnNhanSu.setLayout(null);

		JPanel pnNhapThongTin = new JPanel();
		pnNhapThongTin.setBackground(new Color(238, 232, 170));
		pnNhapThongTin.setBounds(0, 35, 979, 113);
		pnNhanSu.add(pnNhapThongTin);
		pnNhapThongTin.setLayout(null);

		JLabel lblPhongBan = new JLabel("Phòng Ban:");
		lblPhongBan.setFont(new Font("Arial", Font.BOLD, 13));
		lblPhongBan.setBounds(10, 53, 90, 20);
		pnNhapThongTin.add(lblPhongBan);

		JLabel lblMaNS = new JLabel("Mã Nhân Sự:");
		lblMaNS.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaNS.setBounds(10, 22, 90, 20);
		pnNhapThongTin.add(lblMaNS);

		txtMaNS = new JTextField();
		txtMaNS.setColumns(10);
		txtMaNS.setBounds(100, 22, 130, 20);
		pnNhapThongTin.add(txtMaNS);

		JLabel lblHoDem = new JLabel("Họ và Đệm:");
		lblHoDem.setFont(new Font("Arial", Font.BOLD, 13));
		lblHoDem.setBounds(263, 22, 90, 20);
		pnNhapThongTin.add(lblHoDem);

		txtHoDem = new JTextField();
		txtHoDem.setColumns(10);
		txtHoDem.setBounds(353, 22, 130, 20);
		pnNhapThongTin.add(txtHoDem);

		JLabel lblGioiTinh = new JLabel("Giới Tính:");
		lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 13));
		lblGioiTinh.setBounds(779, 22, 70, 20);
		pnNhapThongTin.add(lblGioiTinh);

		JRadioButton rdNam = new JRadioButton("Nam");
		rdNam.setBackground(new Color(238,232,170));
		rdNam.setFont(new Font("Arial", Font.BOLD, 13));
		rdNam.setBounds(849, 22, 60, 20);
		pnNhapThongTin.add(rdNam);

		JRadioButton rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Arial", Font.BOLD, 13));
		rdNu.setBackground(new Color(238,232,170));
		rdNu.setBounds(909, 22, 60, 20);
		pnNhapThongTin.add(rdNu);

		ButtonGroup bGGioiTinh = new ButtonGroup();
		bGGioiTinh.add(rdNam);
		bGGioiTinh.add(rdNu);
		JLabel lblTen = new JLabel("Tên Nhân Sự:");
		lblTen.setFont(new Font("Arial", Font.BOLD, 13));
		lblTen.setBounds(516, 22, 90, 20);
		pnNhapThongTin.add(lblTen);

		txtTenNs = new JTextField();
		txtTenNs.setColumns(10);
		txtTenNs.setBounds(610, 22, 130, 20);
		pnNhapThongTin.add(txtTenNs);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh:");
		lblNgaySinh.setFont(new Font("Arial", Font.BOLD, 13));
		lblNgaySinh.setBounds(516, 53, 70, 20);
		pnNhapThongTin.add(lblNgaySinh);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(610, 53, 130, 20);
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		((JTextField) (txtNgaySinh.getDateEditor().getUiComponent())).setEditable(false);
		pnNhapThongTin.add(txtNgaySinh);

		cboPhongBan = new JComboBox<String>();
		cboPhongBan.setBounds(100, 53, 130, 20);
		pnNhapThongTin.add(cboPhongBan);

		JLabel lblChuyenMon = new JLabel("Chuyên Môn:");
		lblChuyenMon.setFont(new Font("Arial", Font.BOLD, 13));
		lblChuyenMon.setBounds(263, 53, 90, 20);
		pnNhapThongTin.add(lblChuyenMon);

		cboChuyenMon = new JComboBox<String>();
		cboChuyenMon.setBounds(353, 53, 130, 20);
		pnNhapThongTin.add(cboChuyenMon);

		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(Color.CYAN);
		pnTieuDe.setBounds(0, 0, 979, 35);
		pnNhanSu.add(pnTieuDe);
		pnTieuDe.setLayout(null);

		JLabel lblTieuDe = new JLabel("Thêm Nhân Sự Mới");
		lblTieuDe.setBounds(392, 5, 190, 25);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.BLUE);
		pnTieuDe.add(lblTieuDe);
		pnNhapThongTin
				.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Điền Thông Tin Nhân Viên."));

		JLabel lblTui = new JLabel("Tuổi:");
		lblTui.setFont(new Font("Arial", Font.BOLD, 13));
		lblTui.setBounds(779, 53, 83, 20);
		pnNhapThongTin.add(lblTui);

		txtTuoi = new JSpinField();
		txtTuoi.setMinimum(18);
		txtTuoi.setMaximum(100);
		txtTuoi.setBounds(849, 53, 93, 20);
		pnNhapThongTin.add(txtTuoi);

		JLabel lblNewLabel = new JLabel("Số Điện Thoại:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 83, 101, 20);
		pnNhapThongTin.add(lblNewLabel);

		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(110, 83, 120, 20);
		pnNhapThongTin.add(txtSdt);

		JPanel pnTacVu = new JPanel();
		pnTacVu.setBackground(SystemColor.info);
		pnTacVu.setBounds(0, 150, 979, 71);
		pnNhanSu.add(pnTacVu);
		pnTacVu.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chọn Tác Vụ.",
				TitledBorder.LEFT, TitledBorder.TOP, null, Color.BLACK));
		pnTacVu.setLayout(null);

		btnLuuNS = new JButton("Lưu Thông Tin");
		btnLuuNS.setFont(new Font("Arial", Font.BOLD, 13));
		btnLuuNS.setBounds(100, 24, 135, 30);
		pnTacVu.add(btnLuuNS);

		btnXoaTextNS = new JButton("Xóa Trắng");
		btnXoaTextNS.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaTextNS.setBounds(353, 24, 135, 30);
		pnTacVu.add(btnXoaTextNS);

		btnSuaTTNS = new JButton("Sửa Thông Tin");
		btnSuaTTNS.setFont(new Font("Arial", Font.BOLD, 13));
		btnSuaTTNS.setBounds(610, 24, 135, 30);
		pnTacVu.add(btnSuaTTNS);

		btnXoaNS = new JButton("Xóa Nhân Sự");
		btnXoaNS.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaNS.setBounds(826, 24, 135, 30);
		pnTacVu.add(btnXoaNS);

		JLabel lblTim = new JLabel("Tìm Nhân Sự Theo Mã:");
		lblTim.setFont(new Font("Arial", Font.BOLD, 13));
		lblTim.setBounds(10, 236, 156, 25);
		pnNhanSu.add(lblTim);

		txtTim = new JTextField();
		txtTim.setBounds(166, 236, 260, 25);
		pnNhanSu.add(txtTim);
		txtTim.setColumns(10);

		JLabel lblhienThiDS = new JLabel("Hiển Thị Theo:");
		lblhienThiDS.setFont(new Font("Arial", Font.BOLD, 13));
		lblhienThiDS.setBounds(550, 236, 102, 25);
		pnNhanSu.add(lblhienThiDS);

		cboHienThiDS = new JComboBox<String>();
		cboHienThiDS.setBounds(662, 236, 280, 22);
		pnNhanSu.add(cboHienThiDS);

		String[] tieuDe = { "Mã Nhân Sự", "Mã Phòng Ban", "Họ Đêm", "Tên Nhân Sự", "Ngày Sinh", "Tuổi", "Giới Tính",
				"Chuyên Môn" };
		dtmNhanSu = new DefaultTableModel(tieuDe, 0);
		tblDsNhanSu = new JTable(
				new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, },
						new String[] { "M\u00E3 Nh\u00E2n S\u1EF1", "M\u00E3 Ph\u00F2ng Ban", "H\u1ECD \u0110\u00EAm",
								"T\u00EAn Nh\u00E2n S\u1EF1", "Ng\u00E0y Sinh", "Tu\u1ED5i", "Gi\u1EDBi T\u00EDnh",
								"Chuy\u00EAn M\u00F4n", "D\u1EF1 \u00E1n Tham Gia" }));
		JScrollPane scrDsNhanSu = new JScrollPane(tblDsNhanSu);
		tblDsNhanSu.getTableHeader().setBackground(Color.CYAN);
		scrDsNhanSu.setBounds(10, 18, 959, 235);
		JPanel pnDsNhanSu = new JPanel();
		pnDsNhanSu.setBackground(SystemColor.info);
		((DefaultTableCellRenderer) tblDsNhanSu.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(SwingConstants.CENTER);
		pnDsNhanSu.setLayout(null);
		pnDsNhanSu.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh Sách Nhân Sự"));
		pnDsNhanSu.setBounds(0, 272, 979, 265);
		pnDsNhanSu.add(scrDsNhanSu);
		pnNhanSu.add(pnDsNhanSu);

		btnTim = new JButton( new ImageIcon("img\\icon\\search.png"));
		btnTim.setBounds(426, 236, 55, 25);
		pnNhanSu.add(btnTim);
		
		return pnNhanSu;
	}

	public boolean kiemTraNhap(String input, String patternStr) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher macth = pattern.matcher(input);
		return macth.matches();
	}

	public String regexNhanSu() {
		String regexMaNs = "^NS\\d{4}$";
		String regexHoTen = "^([A-Z]([a-z]*[\\s.]?))+(\\S)$";
		String regexSdt = "^0[0-9]{9}";
		String thongBao = "";
		if (!kiemTraNhap(txtMaNS.getText(), regexMaNs)) {
			thongBao += "Mã Nhân sự phải bắt đầu bằng kí tự NS và 4 kí số tiếp theo\n";
		}
		if (!kiemTraNhap(txtHoDem.getText(), regexHoTen)) {
			thongBao += "Họ và đệm phải là kí tự chữ cái cách nhau bởi khoảng trắng hoặc dấu . \n";
		}
		if (!kiemTraNhap(txtSdt.getText(), regexSdt)) {
			thongBao += "Số điện thoại phải bắt đầu là số 0 và có tất cả 10 chữ số";
		}
		return thongBao;
	}
}
