package UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CongViec extends JFrame {
	private JTextField txtMaCV;
	private JTable tblCV;
	private JTextField txtTimCV;
	private JTextField txtTenCV;

	// Công Việc
	public CongViec() {
		setSize(820, 512);
		getContentPane().add(xemCongViec());
	}
public static void main(String[] args) {
	new CongViec().setVisible(true);
}
	public Component xemCongViec() {
		JPanel pnCV = new JPanel();
		pnCV.setPreferredSize(new Dimension(790, 454));
		pnCV.setLayout(null);

		JPanel pnThemCV = new JPanel();
		pnThemCV.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thêm công việc"));
		pnThemCV.setBackground(new Color(238,232,170));
		pnThemCV.setBounds(5, 45, 780, 155);
		pnCV.add(pnThemCV);
		pnThemCV.setLayout(null);

		JLabel lblMaCV = new JLabel("Mã công việc:");
		lblMaCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblMaCV.setBounds(10, 22, 93, 20);
		pnThemCV.add(lblMaCV);

		txtMaCV = new JTextField();
		txtMaCV.setBounds(110, 22, 100, 20);
		txtMaCV.setColumns(10);
		pnThemCV.add(txtMaCV);

		JLabel lblChuyenMonCV = new JLabel("Chuyên môn:");
		lblChuyenMonCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblChuyenMonCV.setBounds(10, 54, 86, 20);
		pnThemCV.add(lblChuyenMonCV);

		JComboBox<String> cboChuyenMonCV = new JComboBox<String>();
		cboChuyenMonCV.setBounds(110, 54, 100, 20);
		pnThemCV.add(cboChuyenMonCV);

		JLabel lblTenCV = new JLabel("Tên công việc:");
		lblTenCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblTenCV.setBounds(10, 86, 93, 20);
		pnThemCV.add(lblTenCV);

		txtTenCV = new JTextField();
		txtTenCV.setBounds(110, 86, 100, 20);
		txtTenCV.setColumns(10);
		pnThemCV.add(txtTenCV);

		JLabel lblMoTaCV = new JLabel("Mô tả công việc:");
		lblMoTaCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblMoTaCV.setBounds(240, 54, 113, 20);
		pnThemCV.add(lblMoTaCV);

		JTextArea txtMoTa = new JTextArea();
		txtMoTa.setBounds(240, 76, 233, 30);
		pnThemCV.add(txtMoTa);

		JLabel lblNSToiDaCV = new JLabel("Số nhân sự tối đa:");
		lblNSToiDaCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblNSToiDaCV.setBounds(10, 118, 123, 20);
		pnThemCV.add(lblNSToiDaCV);

		JLabel lblNSHienTai = new JLabel("Số nhân sự hiện tại:");
		lblNSHienTai.setFont(new Font("Arial", Font.BOLD, 13));
		lblNSHienTai.setBounds(240, 22, 136, 20);
		pnThemCV.add(lblNSHienTai);

		JPanel pnButCV = new JPanel();
		pnButCV.setBackground(new Color(238, 232, 170));
		pnButCV.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Chọn tác vụ"));
		pnButCV.setBounds(490, 17, 276, 123);
		pnThemCV.add(pnButCV);
		pnButCV.setLayout(null);

		JButton btnLuuCV = new JButton("Lưu Công Việc");
		btnLuuCV.setFont(new Font("Arial", Font.BOLD, 12));
		btnLuuCV.setBounds(15, 25, 120, 30);
		pnButCV.add(btnLuuCV);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
		btnNewButton.setBounds(145, 25, 120, 30);
		pnButCV.add(btnNewButton);

		JButton btnXoaTrangCV = new JButton("Xóa Trắng");
		btnXoaTrangCV.setFont(new Font("Arial", Font.BOLD, 12));
		btnXoaTrangCV.setBounds(15, 72, 120, 30);
		pnButCV.add(btnXoaTrangCV);

		JButton btnXoaCV = new JButton("Xóa");
		btnXoaCV.setFont(new Font("Arial", Font.BOLD, 12));
		btnXoaCV.setBounds(145, 72, 120, 30);
		pnButCV.add(btnXoaCV);

		JSpinner txtSLnsMax = new JSpinner();
		txtSLnsMax.setBounds(133, 117, 77, 20);
		pnThemCV.add(txtSLnsMax);

		JSpinner txtSLnsPresent = new JSpinner();
		txtSLnsPresent.setBounds(373, 22, 100, 20);
		pnThemCV.add(txtSLnsPresent);
		
		JLabel lblHeSoLuong = new JLabel("Hệ Số Lương:");
		lblHeSoLuong.setBounds(240, 117, 97, 20);
		pnThemCV.add(lblHeSoLuong);
		lblHeSoLuong.setFont(new Font("Arial", Font.BOLD, 13));
		
		JComboBox cboHeSoLuong = new JComboBox();
		cboHeSoLuong.setBounds(345, 117, 128, 22);
		pnThemCV.add(cboHeSoLuong);

		JPanel pnTblCV = new JPanel();
		pnTblCV.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Danh sách công việc"));
		pnTblCV.setBounds(5, 239, 780, 215);
		pnCV.add(pnTblCV);
		pnTblCV.setLayout(null);

		JScrollPane scrCV = new JScrollPane();
		scrCV.setBounds(10, 18, 760, 186);
		pnTblCV.add(scrCV);

		tblCV = new JTable();
		tblCV.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 C\u00F4ng Vi\u1EC7c", "T\u00EAn C\u00F4ng Vi\u1EC7c", "Chuy\u00EAn M\u00F4n", "S\u1ED1 Nh\u00E2n S\u1EF1 T\u1ED1i \u0110a", "S\u1ED1 Nh\u00E2n S\u1EF1 Hi\u1EC7n T\u1EA1i", "H\u1EC7 S\u1ED1 L\u01B0\u01A1ng", "M\u00F4 T\u1EA3"
			}
		));
		((DefaultTableCellRenderer) tblCV.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		scrCV.setViewportView(tblCV);
		tblCV.getTableHeader().setBackground(Color.CYAN);
		JLabel lblCT_CV = new JLabel("Mã Công Trình:");
		lblCT_CV.setFont(new Font("Arial", Font.BOLD, 13));
		lblCT_CV.setBounds(10, 14, 102, 20);
		pnCV.add(lblCT_CV);

		JComboBox<String> cboCT_CV = new JComboBox<String>();
		cboCT_CV.setBounds(110, 14, 100, 22);
		pnCV.add(cboCT_CV);

		JLabel lblTimCV = new JLabel("Tìm kiếm công việc:");
		lblTimCV.setBounds(500, 14, 135, 20);
		pnCV.add(lblTimCV);
		lblTimCV.setFont(new Font("Arial", Font.BOLD, 13));

		txtTimCV = new JTextField();
		txtTimCV.setBounds(630, 14, 75, 20);
		pnCV.add(txtTimCV);
		txtTimCV.setColumns(10);

		JButton btnTimCV = new JButton("Tìm");
		btnTimCV.setBounds(710, 14, 70, 20);
		pnCV.add(btnTimCV);

		JLabel lblHienThiCV = new JLabel("Hiển thị theo:");
		lblHienThiCV.setFont(new Font("Arial", Font.BOLD, 13));
		lblHienThiCV.setBounds(15, 211, 92, 20);
		pnCV.add(lblHienThiCV);

		JComboBox<String> cboHienThiCV = new JComboBox<String>();
		cboHienThiCV.setBounds(108, 211, 135, 22);
		pnCV.add(cboHienThiCV);
		return pnCV;
	}
}
