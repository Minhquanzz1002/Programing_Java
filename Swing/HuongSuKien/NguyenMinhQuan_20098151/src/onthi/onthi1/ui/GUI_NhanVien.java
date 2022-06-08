package onthi.onthi1.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import onthi.onthi1.dao.DAO_NhanVien;
import onthi.onthi1.dao.DAO_PhongBan;
import onthi.onthi1.entity.NhanVien;
import onthi.onthi1.entity.PhongBan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
//import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.Component;

@SuppressWarnings("serial")
public class GUI_NhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tblNhanVien;
	private JButton btnAdd, btnUpdate, btnDelete, btnSave, btnSearch;
	private DefaultTableModel dtm;
	private String[] headers = { "Mã NV", "Họ tên", "Tuổi", "Lương", "Mã PB" };
	private DAO_NhanVien daoNhanVien;
	private DAO_PhongBan daoPhongBan;
	private JComboBox<String> cboMaPB;
	private JTextField txtMaNV, txtHoNV, txtTuoi, txtLuong, txtTimMaNV;
//	private TableRowSorter<TableModel> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_NhanVien frame = new GUI_NhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnTitle = new JPanel();
		contentPane.add(pnTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
		pnTitle.add(lblTitle);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		panel_1.add(splitPane, BorderLayout.SOUTH);

		JPanel pnTimMaNV = new JPanel();
		splitPane.setLeftComponent(pnTimMaNV);

		JLabel lblTimMaNV = new JLabel("Nhập mã số cần tìm: ");
		lblTimMaNV.setDisplayedMnemonic('N');
		pnTimMaNV.add(lblTimMaNV);

		txtTimMaNV = new JTextField();
		lblTimMaNV.setLabelFor(txtTimMaNV);
		pnTimMaNV.add(txtTimMaNV);
		txtTimMaNV.setColumns(10);

		btnSearch = new JButton("Tìm");
		btnSearch.setFocusable(false);
		pnTimMaNV.add(btnSearch);

		JPanel pnButton = new JPanel();
		splitPane.setRightComponent(pnButton);

		btnAdd = new JButton("Thêm");
		btnAdd.setFocusable(false);
		pnButton.add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setFocusable(false);
		pnButton.add(btnUpdate);

		btnDelete = new JButton("Xóa");
		btnDelete.setFocusable(false);
		pnButton.add(btnDelete);

		btnSave = new JButton("Lưu");
		btnSave.setFocusable(false);
		pnButton.add(btnSave);

		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox, BorderLayout.NORTH);

		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);

		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		lblMaNV.setPreferredSize(new Dimension(75, 14));
		horizontalBox.add(lblMaNV);

		txtMaNV = new JTextField();
		horizontalBox.add(txtMaNV);
		txtMaNV.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut);

		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);

		JLabel lblHoNV = new JLabel("Họ tên:");
		lblHoNV.setPreferredSize(new Dimension(75, 14));
		horizontalBox_1.add(lblHoNV);

		txtHoNV = new JTextField();
		txtHoNV.setColumns(10);
		horizontalBox_1.add(txtHoNV);

		Component verticalStrut_1 = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut_1);

		Box horizontalBox_2 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_2);

		JLabel lblTuoi = new JLabel("Tuổi: ");
		lblTuoi.setPreferredSize(new Dimension(75, 14));
		horizontalBox_2.add(lblTuoi);

		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		horizontalBox_2.add(txtTuoi);

		Component verticalStrut_2 = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut_2);

		Box horizontalBox_3 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_3);

		JLabel lblMaPB = new JLabel("Mã phòng ban: ");
		horizontalBox_3.add(lblMaPB);

		cboMaPB = new JComboBox<String>();
		cboMaPB.setFocusable(false);
		cboMaPB.setPreferredSize(new Dimension(100, 22));
		cboMaPB.setMinimumSize(new Dimension(75, 22));
		horizontalBox_3.add(cboMaPB);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox_3.add(horizontalStrut);

		JLabel lblTienLuong = new JLabel("Tiền lương: ");
		lblTienLuong.setPreferredSize(new Dimension(75, 14));
		horizontalBox_3.add(lblTienLuong);

		txtLuong = new JTextField();
		horizontalBox_3.add(txtLuong);
		txtLuong.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(10);
		verticalBox.add(verticalStrut_3);

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		tblNhanVien = new JTable();
		scrollPane.setViewportView(tblNhanVien);

		daoNhanVien = new DAO_NhanVien();
		daoPhongBan = new DAO_PhongBan();
		loadDataToTable();
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSearch.addActionListener(this);

		tblNhanVien.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex = tblNhanVien.getSelectedRow();
				if (rowIndex >= 0) {
					loadDataToField(rowIndex);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				int rowIndex = tblNhanVien.getSelectedRow();
				if (rowIndex >= 0) {
					loadDataToField(rowIndex);
				}
			}

		});

		lblMaNV.setPreferredSize(lblMaPB.getPreferredSize());
		lblHoNV.setPreferredSize(lblMaPB.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaPB.getPreferredSize());
		lblTienLuong.setPreferredSize(lblMaPB.getPreferredSize());

//		rowSorter = new TableRowSorter<TableModel>(dtm);
//		tblNhanVien.setRowSorter(rowSorter);
	}

	public void loadDataToField(int index) {
		NhanVien nhanVien = daoNhanVien.getDanhSachNhanVien().get(index);
		txtMaNV.setText(nhanVien.getMaNV());
		txtHoNV.setText(nhanVien.getHoTen());
		txtTuoi.setText(String.valueOf(nhanVien.getTuoi()));
		cboMaPB.setSelectedItem(nhanVien.getMaPB());
		txtLuong.setText(String.valueOf(nhanVien.getLuong()));
	}

	public void loadDataToTable() {
		dtm = new DefaultTableModel(headers, 0);
		List<NhanVien> dsnv = daoNhanVien.getDanhSachNhanVien();
		for (NhanVien nhanVien : dsnv) {
			dtm.addRow(nhanVien.toRowTable());
		}
		tblNhanVien.setModel(dtm);
		loadDataToComboBox();
	}
	
	public void loadDataToTable(String maNV) {
		dtm = new DefaultTableModel(headers, 0);
		tblNhanVien.setModel(dtm);
		List<NhanVien> dsnv = daoNhanVien.getDSNhanVien(maNV);
		for (NhanVien nhanVien : dsnv) {
			dtm.addRow(nhanVien.toRowTable());
		}
	}
	
	public void loadDataToComboBox() {
		List<PhongBan> dspb = daoPhongBan.getAllPhongBan();
		for (PhongBan phongBan : dspb) {
			cboMaPB.addItem(phongBan.getMaPB());
		}
	}

	public NhanVien loadDataFromField() {
		String maNV = txtMaNV.getText();
		String hoTen = txtHoNV.getText();
		int tuoi = Integer.valueOf(txtTuoi.getText());
		float luong = Float.valueOf(txtLuong.getText());
		String maPB = cboMaPB.getSelectedItem().toString();
		return new NhanVien(maNV, hoTen, maPB, tuoi, luong);
	}

	public boolean valid() {
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnAdd) {
			if (valid()) {
				NhanVien nhanVien = loadDataFromField();
				if (daoNhanVien.themNhanVien(nhanVien)) {
					JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
					dtm.addRow(nhanVien.toRowTable());
				} else {
					JOptionPane.showMessageDialog(this, "Thêm nhân viên không thành công");
				}
			}
		}
		if (action == btnDelete) {
			int rowIndex = tblNhanVien.getSelectedRow();
			if (rowIndex >= 0) {
				if (valid()) {
					NhanVien nhanVien = daoNhanVien.getDanhSachNhanVien().get(rowIndex);
					if (daoNhanVien.xoaNhanVien(nhanVien)) {
						JOptionPane.showMessageDialog(this, "Xóa nhân viên thành công");
						dtm.removeRow(rowIndex);
					} else {
						JOptionPane.showMessageDialog(this, "Xóa nhân viên không thành công");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chọn nhân viên muốn xóa trước");
			}
		}
		if (action == btnUpdate) {
			int rowIndex = tblNhanVien.getSelectedRow();
			if (rowIndex >= 0) {
				if (valid()) {
					NhanVien nhanVien = loadDataFromField();
					if (daoNhanVien.suaNhanVien(nhanVien)) {
						JOptionPane.showMessageDialog(this, "Sửa nhân viên thành công");
						dtm.setValueAt(nhanVien.getMaNV(), rowIndex, 0);
						dtm.setValueAt(nhanVien.getHoTen(), rowIndex, 1);
						dtm.setValueAt(nhanVien.getTuoi(), rowIndex, 2);
						dtm.setValueAt(nhanVien.getLuong(), rowIndex, 3);
						dtm.setValueAt(nhanVien.getMaPB(), rowIndex, 4);
					} else {
						JOptionPane.showMessageDialog(this, "Sửa nhân viên không thành công");
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chọn nhân viên muốn sửa trước");
			}
		}
		if (action == btnSearch) {
			String text = txtTimMaNV.getText();
//			if (text.trim().length() == 0) {
//				rowSorter.setRowFilter(null);
//			} else {
//				rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
//			}
			loadDataToTable(text);
		}
	}

}
