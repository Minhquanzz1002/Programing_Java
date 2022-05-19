package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class LuanChuyen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaCTCu;
	private JTextField txtMaNSLuanChuyen;
	private JTextField txtMaCVCu;
	private JTextField txtTimCT_LC;
	private JTable tblCT_LC;
	private JTable tblCV_LC;
	private JTextField txtTimNSLuanChuyen;
	private JTable tblNhanSuLuanChuyen;
	private JButton btnLuanChuyen;
	private JButton btnHuyLuanChuyen;
	private JComboBox<String> cboCongViec_LC;
	private JComboBox<String> cboNhanSuLuanChuyen;
	@SuppressWarnings("unused")
	private DefaultTableModel dftNS_LC;
	@SuppressWarnings("unused")
	private DefaultTableModel dftCV_LC;
	@SuppressWarnings("unused")
	private DefaultTableModel dftCT_LC;

	
	public LuanChuyen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(tabLuanChuyen());
		
	}
	public Component tabLuanChuyen() {
		JPanel pnLC = new JPanel();
		pnLC.setBounds(0, 0, 979, 554);
		pnLC.setLayout(null);
		
		JPanel pnCenterLuanChuyen = new JPanel();
		pnCenterLuanChuyen.setBounds(0, 35, 979, 519);
		pnLC.add(pnCenterLuanChuyen);
		pnCenterLuanChuyen.setLayout(null);
		
		JPanel pnNhanSuTrongCT_LC = new JPanel();
		pnNhanSuTrongCT_LC.setBackground(new Color(238, 232, 170));
		pnNhanSuTrongCT_LC.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Chọn nhân sự trong công trình"));
		pnNhanSuTrongCT_LC.setBounds(5, 0, 969, 60);
		pnCenterLuanChuyen.add(pnNhanSuTrongCT_LC);
		pnNhanSuTrongCT_LC.setLayout(null);
		
		JLabel lblMaCTCu = new JLabel("Mã công trình cũ:");
		lblMaCTCu.setBounds(10, 22, 115, 20);
		pnNhanSuTrongCT_LC.add(lblMaCTCu);
		lblMaCTCu.setFont(new Font("Arial", Font.BOLD, 13));
		
		txtMaCTCu = new JTextField();
		txtMaCTCu.setBounds(135, 22, 100, 20);
		pnNhanSuTrongCT_LC.add(txtMaCTCu);
		txtMaCTCu.setColumns(10);
		
		JLabel lblMaNSLuanChuyen = new JLabel("Mã nhân sự:");
		lblMaNSLuanChuyen.setBounds(477, 22, 78, 20);
		pnNhanSuTrongCT_LC.add(lblMaNSLuanChuyen);
		lblMaNSLuanChuyen.setFont(new Font("Arial", Font.BOLD, 13));
		
		txtMaNSLuanChuyen = new JTextField();
		txtMaNSLuanChuyen.setBounds(565, 22, 100, 20);
		pnNhanSuTrongCT_LC.add(txtMaNSLuanChuyen);
		txtMaNSLuanChuyen.setText("");
		txtMaNSLuanChuyen.setColumns(10);
		
		JLabel lblMaCVCu = new JLabel("Mã công việc cũ:");
		lblMaCVCu.setBounds(250, 22, 107, 20);
		pnNhanSuTrongCT_LC.add(lblMaCVCu);
		lblMaCVCu.setFont(new Font("Arial", Font.BOLD, 13));
		
		txtMaCVCu = new JTextField();
		txtMaCVCu.setBounds(367, 22, 100, 20);
		pnNhanSuTrongCT_LC.add(txtMaCVCu);
		txtMaCVCu.setColumns(10);
		
		btnLuanChuyen = new JButton("Luân chuyển");
		btnLuanChuyen.setBounds(680, 17, 135, 30);
		pnNhanSuTrongCT_LC.add(btnLuanChuyen);
		btnLuanChuyen.setFont(new Font("Arial", Font.BOLD, 13));
		
		btnHuyLuanChuyen = new JButton("Hủy");
		btnHuyLuanChuyen.setBounds(824, 17, 135, 30);
		pnNhanSuTrongCT_LC.add(btnHuyLuanChuyen);
		btnHuyLuanChuyen.setFont(new Font("Arial", Font.BOLD, 13));
		
		JPanel pnCT_LC = new JPanel();
		pnCT_LC.setBackground(SystemColor.info);
		pnCT_LC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnCT_LC.setBounds(5, 60, 480, 225);
		pnCenterLuanChuyen.add(pnCT_LC);
		pnCT_LC.setLayout(null);
		
		JLabel lblTimKiemCT_LC = new JLabel("Tìm kiếm công trình:");
		lblTimKiemCT_LC.setBounds(10, 10, 131, 20);
		pnCT_LC.add(lblTimKiemCT_LC);
		lblTimKiemCT_LC.setFont(new Font("Arial", Font.BOLD, 13));
		
		txtTimCT_LC = new JTextField();
		txtTimCT_LC.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTimCT_LC.setBounds(10, 35, 130, 20);
		pnCT_LC.add(txtTimCT_LC);
		txtTimCT_LC.setColumns(10);
		
		JPanel pnDSCT_LC = new JPanel();
		pnDSCT_LC.setBackground(SystemColor.info);
		pnDSCT_LC.setBounds(5, 60, 470, 160);
		pnCT_LC.add(pnDSCT_LC);
		pnDSCT_LC.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách công trình"));
		pnDSCT_LC.setLayout(null);
		
		JScrollPane scrCT_LC = new JScrollPane();
		scrCT_LC.setBounds(10, 20, 450, 130);
		pnDSCT_LC.add(scrCT_LC);
		
		tblCT_LC = new JTable();
		((DefaultTableCellRenderer)tblCT_LC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		tblCT_LC.getTableHeader().setBackground(Color.CYAN);
		tblCT_LC.setFont(new Font("Agency FB", Font.PLAIN, 13));
		tblCT_LC.setModel(dftCT_LC=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 d\u1EF1 \u00E1n", "T\u00EAn d\u1EF1 \u00E1n", "Ng\u00E0y b\u1EAFt \u0111\u1EA7u", "S\u1ED1 nh\u00E2n s\u1EF1", "Tr\u1EA1ng th\u00E1i"
			}
		));
		scrCT_LC.setViewportView(tblCT_LC);
		
		JPanel pnCV_LC = new JPanel();
		pnCV_LC.setBackground(SystemColor.info);
		pnCV_LC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnCV_LC.setBounds(494, 60, 480, 225);
		pnCenterLuanChuyen.add(pnCV_LC);
		pnCV_LC.setLayout(null);
		
		JLabel lblTimKiemCV_LC = new JLabel("Tìm kiếm công việc:");
		lblTimKiemCV_LC.setBounds(10, 10, 135, 20);
		pnCV_LC.add(lblTimKiemCV_LC);
		lblTimKiemCV_LC.setFont(new Font("Arial", Font.BOLD, 13));
		
		JPanel pnDSCV_LC = new JPanel();
		pnDSCV_LC.setBackground(SystemColor.info);
		pnDSCV_LC.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Danh sách công việc trong công trình"));
		pnDSCV_LC.setBounds(5, 60, 470, 160);
		pnCV_LC.add(pnDSCV_LC);
		pnDSCV_LC.setLayout(null);
		
		JScrollPane scrCV_LC = new JScrollPane();
		scrCV_LC.setBounds(10, 20, 450, 130);
		pnDSCV_LC.add(scrCV_LC);
		
		tblCV_LC = new JTable();
		((DefaultTableCellRenderer)tblCV_LC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		tblCV_LC.getTableHeader().setBackground(Color.CYAN);
		tblCT_LC.getTableHeader().setBackground(Color.CYAN);
		tblCV_LC.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 c\u00F4ng vi\u1EC7c", "T\u00EAn c\u00F4ng vi\u1EC7c", "S\u1ED1 NS t\u1ED1i \u0111a", "S\u1ED1 NS hi\u1EC7n t\u1EA1i"
			}
		));
		tblCV_LC.setFont(new Font("Arial", Font.PLAIN, 13));
		scrCV_LC.setViewportView(tblCV_LC);
		
		cboCongViec_LC = new JComboBox<String>();
		cboCongViec_LC.setBounds(10, 35, 130, 20);
		pnCV_LC.add(cboCongViec_LC);
		
		JPanel pnNS_LC = new JPanel();
		pnNS_LC.setBackground(SystemColor.info);
		pnNS_LC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnNS_LC.setBounds(5, 290, 969, 218);
		pnCenterLuanChuyen.add(pnNS_LC);
		pnNS_LC.setLayout(null);
		
		JLabel lblTimKiemNSLuanChuyen = new JLabel("Tìm kiếm nhân sự:");
		lblTimKiemNSLuanChuyen.setBounds(10, 10, 125, 20);
		pnNS_LC.add(lblTimKiemNSLuanChuyen);
		lblTimKiemNSLuanChuyen.setFont(new Font("Arial", Font.BOLD, 13));
		
		txtTimNSLuanChuyen = new JTextField();
		txtTimNSLuanChuyen.setBounds(141, 10, 130, 20);
		pnNS_LC.add(txtTimNSLuanChuyen);
		txtTimNSLuanChuyen.setColumns(10);
		
		JPanel pnDSNS_LC = new JPanel();
		pnDSNS_LC.setBackground(SystemColor.info);
		pnDSNS_LC.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Danh sách nhân sự trong công trình"));
		pnDSNS_LC.setBounds(5, 35, 959, 172);
		pnNS_LC.add(pnDSNS_LC);
		pnDSNS_LC.setLayout(null);
		
		JScrollPane scrNSLuanChuyen = new JScrollPane();
		scrNSLuanChuyen.setBounds(10, 20, 939, 141);
		pnDSNS_LC.add(scrNSLuanChuyen);
		
		tblNhanSuLuanChuyen = new JTable();
		((DefaultTableCellRenderer)tblNhanSuLuanChuyen.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		tblNhanSuLuanChuyen.getTableHeader().setBackground(Color.CYAN);
		tblNhanSuLuanChuyen.setModel(dftNS_LC=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E2n s\u1EF1", "H\u1ECD \u0111\u1EC7m", "T\u00EAn", "Ng\u00E0y tham gia", "Chuy\u00EAn m\u00F4n", "S\u1ED1 ng\u00E0y c\u00F4ng", "M\u00E3 c\u00F4ng tr\u00ECnh", "M\u00E3 c\u00F4ng vi\u1EC7c"
			}
		));
		scrNSLuanChuyen.setViewportView(tblNhanSuLuanChuyen);
		
		JLabel lblHienThiTheoNSLuanChuyen = new JLabel("Hiển thị theo:");
		lblHienThiTheoNSLuanChuyen.setBounds(281, 10, 86, 20);
		pnNS_LC.add(lblHienThiTheoNSLuanChuyen);
		lblHienThiTheoNSLuanChuyen.setFont(new Font("Arial", Font.BOLD, 13));
		
		cboNhanSuLuanChuyen = new JComboBox<String>();
		cboNhanSuLuanChuyen.setBounds(377, 10, 125, 20);
		pnNS_LC.add(cboNhanSuLuanChuyen);
		
		JPanel pnNorthLuanChuyen = new JPanel();
		pnNorthLuanChuyen.setBounds(0, 0, 979, 35);
		pnLC.add(pnNorthLuanChuyen);
		pnNorthLuanChuyen.setBackground(Color.CYAN);
		
		JLabel lblLuanChuyenNhanSu = new JLabel("LUÂN CHUYỂN NHÂN SỰ");
		lblLuanChuyenNhanSu.setForeground(Color.BLUE);
		lblLuanChuyenNhanSu.setFont(new Font("Arial", Font.BOLD, 25));
		pnNorthLuanChuyen.add(lblLuanChuyenNhanSu);
		
		return pnLC;
	}
}
