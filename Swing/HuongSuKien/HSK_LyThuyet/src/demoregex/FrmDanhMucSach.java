package demoregex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FrmDanhMucSach extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboMaSach;
	private JTable table;
	private JTextField txtMess;
	private JButton btnXoaRong;
	private static final String[] headers = { "Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản",
			"Số trang", "Đơn giá", "ISBN" };

	// private SachTableModel tableModel;
	private DefaultTableModel tableModel;
	private JButton btnLoc;

	public FrmDanhMucSach() {
		setTitle("Quản lý sách");
		setSize(900, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildUI();
	}

	private void buildUI() {

		// BorderLayout: North
		JPanel pnlNorth;
		add(pnlNorth = new JPanel(), BorderLayout.NORTH);
		pnlNorth.setPreferredSize(new Dimension(0, 180));
		pnlNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		pnlNorth.setLayout(null); // Absolute layout

		JLabel lblMaSach, lblTuaSach, lblTacGia, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		pnlNorth.add(lblMaSach = new JLabel("Mã sách: "));
		pnlNorth.add(lblTuaSach = new JLabel("Tựa sách: "));
		pnlNorth.add(lblTacGia = new JLabel("Tác giả: "));
		pnlNorth.add(lblNamXB = new JLabel("Năm xuất bản: "));
		pnlNorth.add(lblNhaXB = new JLabel("Nhà xuất bản: "));
		pnlNorth.add(lblSoTrang = new JLabel("Số trang: "));
		pnlNorth.add(lblDonGia = new JLabel("Đơn giá: "));
		pnlNorth.add(lblISBN = new JLabel("International Standard Book Number: "));

		pnlNorth.add(txtMaSach = new JTextField());
		pnlNorth.add(txtTuaSach = new JTextField());
		pnlNorth.add(txtTacGia = new JTextField());
		pnlNorth.add(txtNamXB = new JTextField());
		pnlNorth.add(txtNhaXB = new JTextField());
		pnlNorth.add(txtSoTrang = new JTextField());
		pnlNorth.add(txtDonGia = new JTextField());
		pnlNorth.add(txtISBN = new JTextField());

		pnlNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 12));

		int w1 = 100, w2 = 300, h = 20;
		lblMaSach.setBounds(20, 20, w1, h);
		txtMaSach.setBounds(120, 20, 200, h);

		lblTuaSach.setBounds(20, 45, w1, h);
		txtTuaSach.setBounds(120, 45, w2, h);
		lblTacGia.setBounds(450, 45, w1, h);
		txtTacGia.setBounds(570, 45, w2, h);

		lblNamXB.setBounds(20, 70, w1, h);
		txtNamXB.setBounds(120, 70, w2, h);
		lblNhaXB.setBounds(450, 70, w1, h);
		txtNhaXB.setBounds(570, 70, w2, h);

		lblSoTrang.setBounds(20, 95, w1, h);
		txtSoTrang.setBounds(120, 95, w2, h);
		lblDonGia.setBounds(450, 95, w1, h);
		txtDonGia.setBounds(570, 95, w2, h);

		lblISBN.setBounds(20, 120, 220, h);
		txtISBN.setBounds(240, 120, 180, h);
		txtMess.setBounds(20, 145, 550, 20);

		// BorderLayout: Center
		JPanel pnlCenter;
		add(pnlCenter = new JPanel(), BorderLayout.CENTER);
		pnlCenter.add(btnThem = new JButton("Thêm"));
		pnlCenter.add(btnXoaRong = new JButton("Xóa trắng"));
		pnlCenter.add(btnXoa = new JButton("Xóa"));
		pnlCenter.add(btnSua = new JButton("Sửa"));
		pnlCenter.add(btnLuu = new JButton("Lưu"));
		pnlCenter.add(new JLabel("Tìm theo mã sách: "));
		pnlCenter.add(cboMaSach = new JComboBox<String>());
		cboMaSach.setPreferredSize(new Dimension(100, 25));
		pnlCenter.add(btnLoc = new JButton("Lọc theo mã sách"));

		// BorderLayout: South
		JScrollPane scroll;
//		String[] headers = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN".split(";");

		tableModel = new DefaultTableModel(headers, 0);
		add(scroll = new JScrollPane(table = new JTable(tableModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 350));

		cboMaSach.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLoc.addActionListener(this);

		/* Data test */
		txtMaSach.setText("B001");
		txtTuaSach.setText("Annotations Reflecton");
		txtTacGia.setText("Jakob Jenkov");
		txtNamXB.setText("2014");
		txtNhaXB.setText("Prentice hall");
		txtSoTrang.setText("300");
		txtDonGia.setText("70000");
		txtISBN.setText("0-13-376131-1");
	}

	public boolean kiemTraNhapRong() {
		if (txtMaSach.getText().isEmpty() || txtTuaSach.getText().isEmpty() || txtTacGia.getText().isEmpty()
				|| txtNamXB.getText().isEmpty() || txtNhaXB.getText().isEmpty() || txtSoTrang.getText().isEmpty()
				|| txtDonGia.getText().isEmpty() || txtISBN.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public Sach layThongTinSachTuForm() {
		String maSach, tuaSach, tacGia, nhaXB, isbn;
		int soTrang, namXB;
		double donGia;
		maSach = txtMaSach.getText().trim();
		tuaSach = txtTuaSach.getText().trim();
		tacGia = txtTacGia.getText().trim();
		namXB = Integer.parseInt(txtNamXB.getText().trim());
		nhaXB = txtNhaXB.getText().trim();
		soTrang = Integer.parseInt(txtSoTrang.getText().trim());
		donGia = Double.parseDouble(txtDonGia.getText().trim());
		isbn = txtISBN.getText().trim();
		return new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn);
	}
	
	public boolean kiemTraMaSach(String maSach) {
		String regexMaSach = "[A-Z][0-9]{3}";
		Pattern pattern = Pattern.compile(regexMaSach, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(maSach);
		return matcher.matches();
	}
	
	public boolean kiemTraTuaSach(String tuaSach) {
		String regexMaSach = "[A-Z][0-9]{3}";
		Pattern pattern = Pattern.compile(regexMaSach, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(tuaSach);
		return matcher.matches();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (!kiemTraNhapRong()) {
				JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin trước");
			} else {
				Sach s = layThongTinSachTuForm();
				if (s != null) {
					Object[] obj = { s.getMaSach(), s.getTuaSach(), s.getTacGia(), s.getNamXB(), s.getNhaXB(),
							s.getSoTrang(), s.getDonGia(), s.getIsbn() };
					if (kiemTraMaSach(String.valueOf(obj[0]))) {
						txtMaSach.requestFocus();
						JOptionPane.showMessageDialog(null, "Mã nhân viên không hợp lệ");
					} else {
						tableModel.addRow(obj);
					}

				}
			}
		}

		// if (o.equals(btnXoaRong))

	}

}
