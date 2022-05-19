package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PhongBan extends JFrame {
	// Phòng Ban
	private JPanel contentPane;
	private JTextField txtMPB;
	private JTextField txtTenPB;
	private JTable tblPB;
	private JTable tblNhanVienPB;
	private JTextField txtTimPB;

	// Phòng Ban
	public PhongBan() {
		getContentPane().add(tabPhongBan());
	}

	// tab Phòng Ban
	public Component tabPhongBan() {
		JPanel pnPB = new JPanel();
		pnPB.setLayout(null);

		JPanel pnNorth = new JPanel();
		pnNorth.setForeground(Color.BLACK);
		pnNorth.setBackground(Color.CYAN);
		pnNorth.setBounds(0, 0, 979, 35);
		pnPB.add(pnNorth);

		JLabel lblThemPhongBan = new JLabel("THÊM PHÒNG BAN");
		lblThemPhongBan.setForeground(Color.BLUE);
		pnNorth.add(lblThemPhongBan);
		lblThemPhongBan.setFont(new Font("Arial", Font.BOLD, 20));

		JPanel pnCenter = new JPanel();
		pnCenter.setBounds(0, 35, 979, 508);
		pnPB.add(pnCenter);
		pnCenter.setLayout(null);

		JPanel pnNhapPB = new JPanel();
		pnNhapPB.setBackground(new Color(238, 232, 170));
		pnNhapPB.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thêm Phòng Ban"));
		pnNhapPB.setBounds(0, 0, 977, 90);
		pnCenter.add(pnNhapPB);
		pnNhapPB.setLayout(null);

		JLabel lblMPB = new JLabel("Mã phòng ban : ");
		lblMPB.setBounds(10, 22, 123, 20);
		pnNhapPB.add(lblMPB);
		lblMPB.setFont(new Font("Arial", Font.BOLD, 13));

		txtMPB = new JTextField();
		txtMPB.setBounds(120, 22, 130, 20);
		pnNhapPB.add(txtMPB);
		txtMPB.setColumns(10);

		JLabel lblTenPB = new JLabel("Tên phòng ban : ");
		lblTenPB.setBounds(333, 22, 123, 20);
		pnNhapPB.add(lblTenPB);
		lblTenPB.setFont(new Font("Arial", Font.BOLD, 13));

		txtTenPB = new JTextField();
		txtTenPB.setBounds(456, 23, 130, 20);
		pnNhapPB.add(txtTenPB);
		txtTenPB.setColumns(10);

		JLabel lblSoLuong = new JLabel("Số lượng nhân sự : ");
		lblSoLuong.setBounds(674, 22, 139, 20);
		pnNhapPB.add(lblSoLuong);
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 13));

		JSpinner spnSoLuong = new JSpinner();
		spnSoLuong.setBounds(815, 23, 130, 20);
		pnNhapPB.add(spnSoLuong);

		JButton btnLuuPB = new JButton("Lưu");
		btnLuuPB.setBounds(211, 52, 100, 30);
		pnNhapPB.add(btnLuuPB);
		btnLuuPB.setFont(new Font("Arial", Font.BOLD, 13));

		JButton btnXoaTrangPB = new JButton("Xóa Trắng");
		btnXoaTrangPB.setBounds(333, 52, 100, 30);
		pnNhapPB.add(btnXoaTrangPB);
		btnXoaTrangPB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrangPB.setFont(new Font("Arial", Font.BOLD, 13));

		JButton btnXoaPB = new JButton("Xóa");
		btnXoaPB.setBounds(456, 52, 100, 30);
		pnNhapPB.add(btnXoaPB);
		btnXoaPB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaPB.setFont(new Font("Arial", Font.BOLD, 13));

		JButton btnThoatPB = new JButton("Thoát");
		btnThoatPB.setBounds(581, 52, 100, 30);
		pnNhapPB.add(btnThoatPB);
		btnThoatPB.setFont(new Font("Arial", Font.BOLD, 13));

		JPanel pnTblPhongBan = new JPanel();
		pnTblPhongBan.setBackground(SystemColor.info);
		pnTblPhongBan.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh Sách Phòng Ban"));
		pnTblPhongBan.setBounds(0, 136, 977, 152);
		pnCenter.add(pnTblPhongBan);
		pnTblPhongBan.setLayout(null);

		JScrollPane scrPhongBan = new JScrollPane();
		scrPhongBan.setBounds(10, 22, 957, 120);
		pnTblPhongBan.add(scrPhongBan);

		tblPB = new JTable();
		((DefaultTableCellRenderer) tblPB.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		;
		tblPB.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 Ph\u00F2ng Ban",
				"T\u00EAn Ph\u00F2ng Ban", "S\u1ED1 L\u01B0\u1EE3ng Nh\u00E2n S\u1EF1" }));
		tblPB.getColumnModel().getColumn(0).setPreferredWidth(80);
		tblPB.getColumnModel().getColumn(1).setPreferredWidth(89);
		tblPB.getColumnModel().getColumn(2).setPreferredWidth(105);
		scrPhongBan.setViewportView(tblPB);
		tblPB.getTableHeader().setBackground(Color.CYAN);
		JPanel pnTblNhanVienPB = new JPanel();
		pnTblNhanVienPB.setBackground(SystemColor.info);
		pnTblNhanVienPB.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh Sách Nhân Viên"));
		pnTblNhanVienPB.setBounds(0, 298, 977, 199);
		pnCenter.add(pnTblNhanVienPB);
		pnTblNhanVienPB.setLayout(null);

		JScrollPane scrNhanVienPB = new JScrollPane();
		scrNhanVienPB.setBounds(10, 25, 957, 163);
		pnTblNhanVienPB.add(scrNhanVienPB);

		tblNhanVienPB = new JTable();
		scrNhanVienPB.setViewportView(tblNhanVienPB);
		tblNhanVienPB.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 Nh\u00E2n Vi\u00EAn", "H\u1ECD V\u00E0 \u0110\u1EC7m", "T\u00EAn",
						"Gi\u1EDBi T\u00EDnh", "Chuy\u00EAn M\u00F4n", "Ng\u00E0y Sinh", "Tu\u1ED5i",
						"S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i" }));

		JLabel lblTimKiemPB = new JLabel("Tìm Kiếm : ");
		lblTimKiemPB.setFont(new Font("Arial", Font.BOLD, 13));
		lblTimKiemPB.setBounds(10, 100, 73, 25);
		pnCenter.add(lblTimKiemPB);

		txtTimPB = new JTextField();
		txtTimPB.setBounds(83, 100, 150, 25);
		pnCenter.add(txtTimPB);
		txtTimPB.setColumns(10);

		JButton btnTimPB = new JButton(new ImageIcon("img\\icon\\search.png"));
		btnTimPB.setBounds(233, 100, 59, 25);
		pnCenter.add(btnTimPB);
		return pnPB;
	}

	public static void main(String[] args) {
		new PhongBan().setVisible(true);
	}
}
