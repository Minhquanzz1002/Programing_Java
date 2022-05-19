package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class CongTrinh extends JFrame implements ActionListener{
	private JTextField txtTimKiemCT;
	private JTable tblCT;
	private JTextField txtMaCT;
	private JTextField txtTenCT;
	private JTextField txtDiaDiemCT;
	private JTextField txtSoLuongNhanSuCT;
	private JButton btnXemCV;
	private JButton btnLuuCT;
	private JButton btnXoaTrong;
	private JButton btnThoat;
	private JTextField txtGhiChuCT;
	
	@SuppressWarnings("unused")
	private DefaultTableModel dtmCongTrinh;
	
	public CongTrinh() {	}
	public Component tabCongTrinh() {
		JPanel pnCha = new JPanel();
		pnCha.setBounds(0, 0, 979, 554);
		pnCha.setLayout(new BorderLayout(0, 0));
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.CYAN);
		pnCha.add(pnNorth, BorderLayout.NORTH);
		
		JLabel lblThemCT = new JLabel("Thêm Công Trình");
		lblThemCT.setForeground(Color.BLUE);
		lblThemCT.setFont(new Font("Arial", Font.BOLD, 20));
		pnNorth.add(lblThemCT);
		
		JPanel pnCenTer = new JPanel();
		pnCha.add(pnCenTer, BorderLayout.CENTER);
		pnCenTer.setLayout(null);
		
		JPanel pnNhapCT = new JPanel();
		pnNhapCT.setBackground(new Color(238, 232, 170));
		pnNhapCT.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thêm công trình"));
		pnNhapCT.setBounds(0, 0, 979, 152);
		pnNhapCT.setLayout(null);
		
		JLabel lblMaDCT = new JLabel("Mã công trình:");
		lblMaDCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaDCT.setBounds(10, 22, 95, 20);
		pnNhapCT.add(lblMaDCT);
		
		txtMaCT = new JTextField();
		txtMaCT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtMaCT.setColumns(10);
		txtMaCT.setBounds(116, 22, 103, 20);
		pnNhapCT.add(txtMaCT);
		
		JLabel lblTenCT = new JLabel("Tên công trình:");
		lblTenCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblTenCT.setBounds(233, 22, 100, 20);
		pnNhapCT.add(lblTenCT);
		
		txtTenCT = new JTextField();
		txtTenCT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTenCT.setColumns(10);
		txtTenCT.setBounds(337, 22, 135, 20);
		pnNhapCT.add(txtTenCT);
		
		JLabel lblDiaDiemCT = new JLabel("Địa điểm thi công:");
		lblDiaDiemCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblDiaDiemCT.setBounds(493, 22, 116, 20);
		pnNhapCT.add(lblDiaDiemCT);
		
		JLabel lblNgayCapPhep = new JLabel("Ngày cấp phép:");
		lblNgayCapPhep.setFont(new Font("Arial", Font.BOLD, 13));
		lblNgayCapPhep.setBounds(10, 50, 99, 20);
		pnNhapCT.add(lblNgayCapPhep);
		
		JDateChooser dCNgayCapPhep = new JDateChooser();
		dCNgayCapPhep.setDateFormatString("dd/MM/yyyy");
		((JTextField)dCNgayCapPhep.getDateEditor().getUiComponent()).setEditable(false);
		dCNgayCapPhep.setBounds(116, 50, 103, 20);
		pnNhapCT.add(dCNgayCapPhep);
		
		txtDiaDiemCT = new JTextField();
		txtDiaDiemCT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtDiaDiemCT.setColumns(10);
		txtDiaDiemCT.setBounds(618, 22, 135, 20);
		pnNhapCT.add(txtDiaDiemCT);
		
		JLabel lblNgayKhoiCong = new JLabel("Ngày khởi công:");
		lblNgayKhoiCong.setFont(new Font("Arial", Font.BOLD, 13));
		lblNgayKhoiCong.setBounds(228, 50, 105, 20);
		pnNhapCT.add(lblNgayKhoiCong);
		
		JDateChooser dCNgayKhoiCong = new JDateChooser();
		dCNgayKhoiCong.setDateFormatString("dd/MM/yyyy");
		((JTextField)dCNgayKhoiCong.getDateEditor().getUiComponent()).setEditable(false);
		dCNgayKhoiCong.setBounds(337, 50, 103, 20);
		pnNhapCT.add(dCNgayKhoiCong);
		
		JLabel lblNgayHoanThanh = new JLabel("Ngày hoàn thành dự kiến:");
		lblNgayHoanThanh.setFont(new Font("Arial", Font.BOLD, 13));
		lblNgayHoanThanh.setBounds(448, 50, 169, 20);
		pnNhapCT.add(lblNgayHoanThanh);
		
		JDateChooser dcNgayHoanThanh = new JDateChooser();
		dcNgayHoanThanh.setDateFormatString("dd/MM/yyyy");
		((JTextField)dcNgayHoanThanh.getDateEditor().getUiComponent()).setEditable(false);
		dcNgayHoanThanh.setBounds(618, 50, 103, 20);
		pnNhapCT.add(dcNgayHoanThanh);
		
		JLabel lblTrangThaiCT = new JLabel("Trạng thái:");
		lblTrangThaiCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblTrangThaiCT.setBounds(774, 22, 74, 20);
		pnNhapCT.add(lblTrangThaiCT);
		
		JLabel lblSLNhanSuCT = new JLabel("Số lượng nhân sự:");
		lblSLNhanSuCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblSLNhanSuCT.setBounds(725, 50, 123, 20);
		pnNhapCT.add(lblSLNhanSuCT);
		
		JComboBox<String> cboTrangThai = new JComboBox<String>();
		cboTrangThai.setFont(new Font("Arial", Font.PLAIN, 13));
		cboTrangThai.setBounds(849, 22, 110, 20);
		pnNhapCT.add(cboTrangThai);
		
		txtSoLuongNhanSuCT = new JTextField();
		txtSoLuongNhanSuCT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtSoLuongNhanSuCT.setEnabled(false);
		txtSoLuongNhanSuCT.setColumns(10);
		txtSoLuongNhanSuCT.setBounds(849, 50, 110, 20);
		pnNhapCT.add(txtSoLuongNhanSuCT);
		
		btnXemCV = new JButton("Xem Công Việc");
		btnXemCV.setFont(new Font("Arial", Font.BOLD, 13));
		btnXemCV.setBounds(116, 106, 135, 30);
		pnNhapCT.add(btnXemCV);
		
		btnLuuCT = new JButton("Lưu");
		btnLuuCT.setFont(new Font("Arial", Font.BOLD, 13));
		btnLuuCT.setBounds(320, 106, 135, 30);
		pnNhapCT.add(btnLuuCT);
		
		btnXoaTrong = new JButton("Xóa Trống");
		btnXoaTrong.setFont(new Font("Arial", Font.BOLD, 13));
		btnXoaTrong.setBounds(524, 106, 135, 30);
		pnNhapCT.add(btnXoaTrong);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Arial", Font.BOLD, 13));
		btnThoat.setBounds(728, 106, 135, 30);
		pnNhapCT.add(btnThoat);
		
		JLabel lblGhiChuCT = new JLabel("Ghi Chú:");
		lblGhiChuCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblGhiChuCT.setBounds(10, 78, 74, 20);
		pnNhapCT.add(lblGhiChuCT);
		
		txtGhiChuCT = new JTextField();
		txtGhiChuCT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtGhiChuCT.setColumns(10);
		txtGhiChuCT.setBounds(116, 78, 844, 20);
		pnNhapCT.add(txtGhiChuCT);
		pnCenTer.add(pnNhapCT);
		JPanel pnTableCT = new JPanel();
		pnTableCT.setBackground(SystemColor.info);
		pnTableCT.setBounds(0, 193, 976, 305);
		pnTableCT.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK),"Danh sách công trình"));
		pnCenTer.add(pnTableCT);
		pnTableCT.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 20, 956, 274);
		pnTableCT.add(scrollPane);
		
		tblCT = new JTable();
		tblCT.setModel( dtmCongTrinh = new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 C\u00F4ng Tr\u00ECnh", "T\u00EAn C\u00F4ng Tr\u00ECnh", "\u0110\u1ECBa \u0110i\u1EC3m Thi C\u00F4ng", "Ng\u00E0y C\u1EA5p Ph\u00E9p", "Ng\u00E0y Kh\u1EDFi C\u00F4ng", "Ng\u00E0y Ho\u00E0n Th\u00E0nh D\u1EF1 Ki\u1EBFn", "Tr\u1EA1ng Th\u00E1i", "S\u1ED1 L\u01B0\u1EE3ng Nh\u00E2n S\u1EF1", "Ghi Ch\u00FA"
			}
		)
				{
			/**
					 * 
					 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
				
			};
				}
				);
		tblCT.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblCT.getColumnModel().getColumn(2).setPreferredWidth(80);
		tblCT.getColumnModel().getColumn(7).setPreferredWidth(84);
		tblCT.getColumnModel().getColumn(8).setPreferredWidth(66);
		scrollPane.setViewportView(tblCT);
		tblCT.getTableHeader().setBackground(Color.CYAN);
		JPanel pnTim = new JPanel();
		pnTim.setBounds(0, 145, 976, 40);
		pnCenTer.add(pnTim);
		pnTim.setLayout(null);
		
		JLabel lblTimCT = new JLabel("Tìm công trình theo mã:");
		lblTimCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblTimCT.setBounds(116, 14, 160, 25);
		pnTim.add(lblTimCT);
		
		txtTimKiemCT = new JTextField();
		txtTimKiemCT.setFont(new Font("Arial", Font.PLAIN, 13));
		txtTimKiemCT.setBounds(280, 14, 170, 25);
		pnTim.add(txtTimKiemCT);
		txtTimKiemCT.setColumns(10);
		
		JLabel lblHienThiCT = new JLabel("Hiển thị theo:");
		lblHienThiCT.setFont(new Font("Arial", Font.BOLD, 13));
		lblHienThiCT.setBounds(558, 14, 90, 25);
		pnTim.add(lblHienThiCT);
		
		JComboBox<String> cboHienThiCT = new JComboBox<String>();
		cboHienThiCT.addItem("Tất Cả");
		cboHienThiCT.addItem("Trạng thái đang thi công");
		cboHienThiCT.addItem("Trạng thái đã hoàn thành");
		cboHienThiCT.setBounds(653, 14, 210, 25);
		pnTim.add(cboHienThiCT);
		
		JButton btnTimCT = new JButton(new ImageIcon("img\\icon\\search.png"));
		btnTimCT.setBounds(450, 14, 55, 25);
		pnTim.add(btnTimCT);
		btnXemCV.addActionListener(this);
		return pnCha;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnXemCV)) {
			JOptionPane.showConfirmDialog(null, new CongViec().xemCongViec(),"Công Việc",JOptionPane.OK_CANCEL_OPTION,JOptionPane.DEFAULT_OPTION);
		}
		
	}
}
