package UI;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class PhanCong extends JFrame implements ActionListener{

	
	private JTextField txtMaNS;
	private JTextField txtMaCV;
	private JTextField txtMaCT;
	private JTextField textField;
	private JTable tblDsDaPC;
	private JTable tblDsCvPC;
	private JTextField txtTimNSPC;
	private JTable tblDsNsDaTG;
	private JTextField txtTimNsChuaTG;
	private JTable tblDsNsChuaTG;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDsCvPC;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDsNsChuaTG;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDsNsDaTG;
	@SuppressWarnings("unused")
	private DefaultTableModel dtmDsDaPC;
	private JButton btnPhanThuCong;

	public PhanCong() {	getContentPane().add(addControl());}
	public Component addControl() {
		JPanel pnPhanCong = new JPanel();
		pnPhanCong.setBounds(0, 0, 979, 554);
		
		pnPhanCong.setLayout(null);
		
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setBackground(Color.CYAN);
		pnTieuDe.setBounds(0, 0, 979, 35);
		pnPhanCong.add(pnTieuDe);
		
		JLabel lblNewLabel_1 = new JLabel("Phân Công");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		pnTieuDe.add(lblNewLabel_1);
		
		JPanel pnTacVu = new JPanel();
		pnTacVu.setBackground(new Color(238, 232, 170));
		pnTacVu.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "\u0110i\u1EC1n Th\u00F4ng Tin Ph\u00E2n C\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTacVu.setBounds(0, 37, 979, 86);
		pnPhanCong.add(pnTacVu);
		pnTacVu.setLayout(null);
		
		JLabel lblMaNS = new JLabel("Mã Nhân Sự:");
		lblMaNS.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaNS.setBounds(10, 22, 100, 20);
		pnTacVu.add(lblMaNS);
		
		txtMaNS = new JTextField();
		txtMaNS.setEditable(false);
		txtMaNS.setColumns(10);
		txtMaNS.setBounds(110, 22, 150, 20);
		pnTacVu.add(txtMaNS);
		
		txtMaCV = new JTextField();
		txtMaCV.setEditable(false);
		txtMaCV.setColumns(10);
		txtMaCV.setBounds(400, 22, 150, 20);
		pnTacVu.add(txtMaCV);
		
		JLabel lblMaCV = new JLabel("Mã Công Việc:");
		lblMaCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaCV.setBounds(300, 22, 100, 20);
		pnTacVu.add(lblMaCV);
		
		txtMaCT = new JTextField();
		txtMaCT.setEditable(false);
		txtMaCT.setColumns(10);
		txtMaCT.setBounds(110, 53, 150, 20);
		pnTacVu.add(txtMaCT);
		
		JLabel lblMaCT = new JLabel("Mã Công Trình:");
		lblMaCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaCT.setBounds(10, 53, 100, 20);
		pnTacVu.add(lblMaCT);
		
		JLabel lblNgayTG = new JLabel("Ngày Tham Gia:");
		lblNgayTG.setFont(new Font("Arial", Font.BOLD, 13));
		lblNgayTG.setBounds(300, 53, 105, 20);
		pnTacVu.add(lblNgayTG);
		
		JDateChooser txtNgatTG = new JDateChooser();
		txtNgatTG.setBounds(405, 53, 145, 20);
		pnTacVu.add(txtNgatTG);
		
		 btnPhanThuCong = new JButton("Phân Công Thủ Công");
		btnPhanThuCong.setFont(new Font("Arial", Font.BOLD, 13));
		btnPhanThuCong.setBounds(622, 53, 200, 25);
		pnTacVu.add(btnPhanThuCong);
		
		JButton btnPhanCongTD = new JButton("Phân Công Tự Động");
		btnPhanCongTD.setFont(new Font("Arial", Font.BOLD, 13));
		btnPhanCongTD.setBounds(622, 22, 200, 25);
		pnTacVu.add(btnPhanCongTD);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaTrang.setBounds(832, 22, 106, 54);
		pnTacVu.add(btnXoaTrang);
		
		JPanel pndanhSach = new JPanel();
		pndanhSach.setBounds(0, 122, 979, 432);
		pnPhanCong.add(pndanhSach);
		pndanhSach.setLayout(null);
		
		JPanel pnDaPc = new JPanel();
		pnDaPc.setBackground(SystemColor.info);
		pnDaPc.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "D\u1EF1 \u00C1n", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		pnDaPc.setBounds(5, 0, 475, 200);
		pndanhSach.add(pnDaPc);
		pnDaPc.setLayout(null);
		
		JLabel lblTimCT = new JLabel("Tìm Kiếm Công Trình:");
		lblTimCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblTimCT.setBounds(10, 20, 150, 20);
		pnDaPc.add(lblTimCT);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 20, 150, 20);
		pnDaPc.add(textField);
		
		JScrollPane scrDaPc = new JScrollPane();
		scrDaPc.setBounds(10, 50, 460, 140);
		pnDaPc.add(scrDaPc);
		
		tblDsDaPC = new JTable();
		tblDsDaPC.setModel(dtmDsDaPC=new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 D\u1EF1 \u00C1n", "T\u00EAn D\u1EF1 \u00C1n", "Ng\u00E0y B\u1EAFt \u0110\u1EA7u", "S\u1ED1 L\u01B0\u1EE3ng ", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrDaPc.setViewportView(tblDsDaPC);
		 ((DefaultTableCellRenderer) tblDsDaPC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		 tblDsDaPC.getTableHeader().setBackground(Color.CYAN);
		 
		JPanel pnCvPC = new JPanel();
		pnCvPC.setBackground(SystemColor.info);
		pnCvPC.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "C\u00F4ng Vi\u1EC7c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnCvPC.setBounds(490, 0, 480, 200);
		pndanhSach.add(pnCvPC);
		pnCvPC.setLayout(null);
		
		JLabel lblTimCVPC = new JLabel("Hiển Thị Công Việc:");
		lblTimCVPC.setFont(new Font("Arial", Font.BOLD, 13));
		lblTimCVPC.setBounds(10, 20, 150, 20);
		pnCvPC.add(lblTimCVPC);
		
		JComboBox cboHienThiCVPC = new JComboBox();
		cboHienThiCVPC.setBounds(160, 20, 150, 20);
		pnCvPC.add(cboHienThiCVPC);
		
		JScrollPane scrCvPC = new JScrollPane();
		scrCvPC.setBounds(10, 50, 460, 140);
		pnCvPC.add(scrCvPC);
		
		tblDsCvPC = new JTable();
		tblDsCvPC.setModel( dtmDsCvPC =new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 C\u00F4ng Vi\u1EC7c", "T\u00EAn C\u00F4ng Vi\u1EC7c", "S\u1ED1 L\u01B0\u1EE3ng Hi\u1EC7n T\u1EA1i", "S\u1ED1 L\u01B0\u1EE3ng T\u1ED1i \u0110a"
			}
		));
		scrCvPC.setViewportView(tblDsCvPC);
		((DefaultTableCellRenderer) tblDsCvPC.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		tblDsCvPC.getTableHeader().setBackground(Color.CYAN);
		
		JPanel pnNSDaTG = new JPanel();
		pnNSDaTG.setBackground(SystemColor.info);
		pnNSDaTG.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh Nh\u00E2n S\u1EF1 C\u1EE7a D\u1EF1 \u00C1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnNSDaTG.setBounds(5, 210, 480, 200);
		pndanhSach.add(pnNSDaTG);
		pnNSDaTG.setLayout(null);
		
		JLabel lblTmNSPC = new JLabel("Tìm Kiếm Nhân Sự:");
		lblTmNSPC.setFont(new Font("Arial", Font.BOLD, 13));
		lblTmNSPC.setBounds(10, 20, 150, 20);
		pnNSDaTG.add(lblTmNSPC);
		
		txtTimNSPC = new JTextField();
		txtTimNSPC.setColumns(10);
		txtTimNSPC.setBounds(160, 20, 150, 20);
		pnNSDaTG.add(txtTimNSPC);
		
		JScrollPane scrNSDATG = new JScrollPane();
		scrNSDATG.setBounds(10, 50, 460, 140);
		pnNSDaTG.add(scrNSDATG);
		
		tblDsNsDaTG = new JTable();
		tblDsNsDaTG.setModel(dtmDsNsDaTG =new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n S\u1EF1", "H\u1ECD T\u00EAn", "Chuy\u00EAn M\u00F4n", "Ph\u00F2ng Ban", "Ng\u00E0y Tham Gia"
			}
		));
		scrNSDATG.setViewportView(tblDsNsDaTG);
		((DefaultTableCellRenderer) tblDsNsDaTG.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		tblDsNsDaTG.getTableHeader().setBackground(Color.CYAN);
		
		JPanel pnNSChuaTG = new JPanel();
		pnNSChuaTG.setBackground(SystemColor.info);
		pnNSChuaTG.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh S\u00E1ch Nh\u00E2n S\u1EF1 Ch\u01B0a \u0110\u01B0\u1EE3c Ph\u00E2n C\u00F4ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnNSChuaTG.setBounds(490, 210, 480, 200);
		pndanhSach.add(pnNSChuaTG);
		pnNSChuaTG.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm Nhân Sự:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 20, 150, 20);
		pnNSChuaTG.add(lblNewLabel);
		
		txtTimNsChuaTG = new JTextField();
		txtTimNsChuaTG.setColumns(10);
		txtTimNsChuaTG.setBounds(160, 20, 150, 20);
		pnNSChuaTG.add(txtTimNsChuaTG);
		
		JScrollPane scrNSChuaTG = new JScrollPane();
		scrNSChuaTG.setBounds(10, 50, 460, 140);
		pnNSChuaTG.add(scrNSChuaTG);
		
		tblDsNsChuaTG = new JTable();
		tblDsNsChuaTG.setModel(dtmDsNsChuaTG=new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 Nh\u00E2n S\u1EF1", "H\u1ECD T\u00EAn", "Chuy\u00EAn M\u00F4n", "Ph\u00F2ng ban"
			}
		));
		scrNSChuaTG.setViewportView(tblDsNsChuaTG);
		((DefaultTableCellRenderer) tblDsNsChuaTG.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		tblDsNsChuaTG.getTableHeader().setBackground(Color.CYAN);
		btnPhanThuCong.addActionListener(this);
		return pnPhanCong;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnPhanThuCong)) {
			JOptionPane.showMessageDialog(null, "hihih");
		}
		
	}
	
}
