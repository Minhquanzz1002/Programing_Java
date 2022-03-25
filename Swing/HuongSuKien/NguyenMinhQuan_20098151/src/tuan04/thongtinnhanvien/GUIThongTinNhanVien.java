package tuan04.thongtinnhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GUIThongTinNhanVien extends JFrame implements ActionListener {
	private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtLuong, txtTim;
	JButton btnTim, btnThem, btnXoaTrang, btnXoa, btnLuu;
	DefaultTableModel modelTableNV;
	JTable tableDSNV;
	JRadioButton radNam, radNu;
	ButtonGroup groupPhai;
	private TableRowSorter<TableModel> rowSorter;
	JComboBox<String> cboPhai;

	public GUIThongTinNhanVien(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(680, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		/* Phần nhập dữ liệu */
		JLabel lblThongTinNV = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblThongTinNV.setForeground(Color.BLUE);
		lblThongTinNV.setFont(new Font(null, Font.BOLD, 25));

		JPanel pnThongTinNhanVien = new JPanel();
		pnThongTinNhanVien.add(lblThongTinNV);
		pnThongTinNhanVien.setPreferredSize(new Dimension(700, 35));

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setLabelFor(txtMaNV);

		txtMaNV = new JTextField(50);

		JLabel lblHo = new JLabel("Họ:");
		lblHo.setLabelFor(txtHo);

		txtHo = new JTextField(21);

		JLabel lblTen = new JLabel("Tên nhân viên:");

		txtTen = new JTextField(21);

		JLabel lblTuoi = new JLabel("Tuổi:");
		lblTuoi.setLabelFor(txtTuoi);

		txtTuoi = new JTextField(37);

		JLabel lblPhai = new JLabel("Phái:");

		radNam = new JRadioButton("Nam");
		radNam.setActionCommand("Nam");
		radNam.setFocusable(false);

		radNu = new JRadioButton("Nữ");
		radNu.setActionCommand("Nữ");
		radNu.setFocusable(false);

		groupPhai = new ButtonGroup();
		groupPhai.add(radNam);
		groupPhai.add(radNu);

		JLabel lblLuong = new JLabel("Tiền lương:");

		txtLuong = new JTextField(50);

		JPanel pnNourth = new JPanel();
		pnNourth.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
		pnNourth.setPreferredSize(new Dimension(0, 150));
		pnNourth.add(pnThongTinNhanVien);
		pnNourth.add(lblMaNV);
		pnNourth.add(txtMaNV);
		pnNourth.add(lblHo);
		pnNourth.add(txtHo);
		pnNourth.add(lblTen);
		pnNourth.add(txtTen);
		pnNourth.add(lblTuoi);
		pnNourth.add(txtTuoi);
		pnNourth.add(lblPhai);
		pnNourth.add(radNam);
		pnNourth.add(radNu);
		pnNourth.add(lblLuong);
		pnNourth.add(txtLuong);

		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		lblLuong.setPreferredSize(lblMaNV.getPreferredSize());

		/* Phần bảng */
		String[] colsTableNV = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		modelTableNV = new DefaultTableModel(colsTableNV, 0);
		String[] row1 = {"1111", "Nguyễn", "Hoàng", "Nam", "26", "4500"};
		String[] row2 = {"2222", "Nguyễn", "Hoàng", "Nam", "26", "4500"};
		String[] row3 = {"3333", "Nguyễn", "Hoàng", "Nam", "26", "4500"};
		String[] row4 = {"4444", "Nguyễn", "Hoàng", "Nam", "26", "4500"};
		modelTableNV.addRow(row1);
		modelTableNV.addRow(row2);
		modelTableNV.addRow(row3);
		modelTableNV.addRow(row4);
		tableDSNV = new JTable(modelTableNV);
		tableDSNV.setEditingColumn(0);
		JScrollPane paneDSNV = new JScrollPane(tableDSNV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		rowSorter = new TableRowSorter<>(tableDSNV.getModel());
		tableDSNV.setRowSorter(rowSorter);

		TableColumn tableColumnPhai = tableDSNV.getColumnModel().getColumn(3);
		cboPhai = new JComboBox<>();
		cboPhai.addItem("Nam");
		cboPhai.addItem("Nữ");
		tableColumnPhai.setCellEditor(new DefaultCellEditor(cboPhai));

		DefaultTableCellRenderer rightRendere = new DefaultTableCellRenderer();
		rightRendere.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		tableDSNV.getColumnModel().getColumn(3).setCellRenderer(rightRendere);
		tableDSNV.getColumnModel().getColumn(4).setCellRenderer(rightRendere);
		tableDSNV.getColumnModel().getColumn(5).setCellRenderer(rightRendere);

		/* Các nút bấm */

		/* Phần tìm kiếm */
		JLabel lblTim = new JLabel("Nhập mã số cần tìm:");

		txtTim = new JTextField(10);

		btnTim = new JButton("Tìm");
		btnTim.setFocusable(false);

		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBorder(BorderFactory.createLoweredBevelBorder());
		pnTimKiem.add(lblTim);
		pnTimKiem.add(txtTim);
		pnTimKiem.add(btnTim);

		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);

		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFocusable(false);

		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);

		btnLuu = new JButton("Lưu");
		btnLuu.setFocusable(false);
		btnLuu.setEnabled(false);

		JPanel pnNutBam = new JPanel();
		pnNutBam.setBorder(BorderFactory.createLoweredBevelBorder());
		pnNutBam.add(btnThem);
		pnNutBam.add(btnXoaTrang);
		pnNutBam.add(btnXoa);
		pnNutBam.add(btnLuu);

		JPanel pnTacVu = new JPanel();
		pnTacVu.setLayout(new BorderLayout());
		pnTacVu.add(pnTimKiem, BorderLayout.WEST);
		pnTacVu.add(pnNutBam, BorderLayout.CENTER);

		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BorderLayout());
		pnSouth.add(pnTacVu, BorderLayout.SOUTH);

		/* Thêm vào Panel chính */
		JPanel pnCha = new JPanel();
		pnCha.setLayout(new BorderLayout());
		pnCha.add(pnNourth, BorderLayout.NORTH);
		pnCha.add(pnSouth, BorderLayout.SOUTH);
		pnCha.add(paneDSNV, BorderLayout.CENTER);
		add(pnCha);

		/* Các sự kiện */
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);

		/* Phần dữ liệu test */
		txtMaNV.setText("20098151");
		txtHo.setText("Nguyễn Minh");
		txtTen.setText("Quân");
		txtTuoi.setText("20");
		txtLuong.setText("100000000");
		radNam.setSelected(true);
	}

	public void xoaTrang() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTuoi.setText("");
		groupPhai.clearSelection();
		txtLuong.setText("");
		txtMaNV.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action.equals(btnThem)) {
			if (btnThem.getText().equals("Thêm")) {
				btnXoa.setEnabled(false);
				btnThem.setText("Hủy");
				btnLuu.setEnabled(true);
			} else {
				btnXoa.setEnabled(true);
				btnThem.setText("Thêm");
			}
		} else if (action.equals(btnLuu)) {
			String maNV, hoNV, tenNV, phai = "", tuoi, tienLuong;
			maNV = txtMaNV.getText().trim();
			hoNV = txtHo.getText().trim();
			tenNV = txtTen.getText().trim();
			phai = groupPhai.getSelection().getActionCommand();
			tuoi = txtTuoi.getText().trim();
			tienLuong = txtLuong.getText().trim();

			if (maNV.isEmpty() || hoNV.isEmpty() || tenNV.isEmpty() || phai.isEmpty() || tuoi.isEmpty()
					|| tienLuong.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin! ");
			} else {
				String[] row = { maNV, hoNV, tenNV, phai, tuoi, tienLuong + " VND" };
				modelTableNV.addRow(row);
				xoaTrang();
			}
		} else if (action.equals(btnXoa)) {
			if (tableDSNV.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phai chon dong can xoa.");
			else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng này không?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					modelTableNV.removeRow(tableDSNV.getSelectedRow());
			}
		} else if (action.equals(btnXoaTrang)) {
			xoaTrang();
		} else {
			String text = txtTim.getText();
			if (text.trim().length() == 0) {
				rowSorter.setRowFilter(null);
			} else {
				rowSorter.setRowFilter(RowFilter.regexFilter(text));
			}
		}
	}

	public static void main(String[] args) {
		new GUIThongTinNhanVien("Thông Tin Nhân Viên").doShow();
	}
}
