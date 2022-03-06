package bai1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

public class ThongTinNhanVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JButton nutXoaTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinNhanVien frame = new ThongTinNhanVien();
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
	public ThongTinNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelMaNV = new JLabel("Mã nhân viên");
		labelMaNV.setBounds(10, 60, 73, 14);
		contentPane.add(labelMaNV);
		
		JLabel tieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
		tieuDe.setBounds(0, 0, 650, 36);
		tieuDe.setHorizontalAlignment(JLabel.CENTER);
		tieuDe.setFont(new Font(null, Font.BOLD, 25));
		tieuDe.setForeground(Color.blue);
		contentPane.add(tieuDe);
		
		JLabel labelHo = new JLabel("Họ");
		labelHo.setBounds(10, 97, 46, 14);
		contentPane.add(labelHo);
		
		JLabel labelTuoi = new JLabel("Tuổi");
		labelTuoi.setBounds(10, 141, 46, 14);
		contentPane.add(labelTuoi);
		
		JLabel labelTienLuong = new JLabel("Tiền lương");
		labelTienLuong.setBounds(10, 190, 73, 14);
		contentPane.add(labelTienLuong);
		
		JLabel labelTen = new JLabel("Tên nhân viên");
		labelTen.setBounds(282, 97, 79, 14);
		contentPane.add(labelTen);
		
		textField = new JTextField();
		textField.setBounds(88, 57, 460, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 94, 171, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(88, 138, 240, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(88, 187, 460, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(371, 94, 177, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 314, 412, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã số cần tìm:");
		lblNewLabel.setBounds(5, 9, 125, 14);
		panel.add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(140, 6, 136, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton nutTim = new JButton("Tìm");
		nutTim.setBounds(279, 5, 89, 23);
		nutTim.setFocusable(false);
		panel.add(nutTim);
		
		JLabel labelPhai = new JLabel("Phái");
		labelPhai.setBounds(350, 141, 46, 14);
		contentPane.add(labelPhai);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(422, 314, 312, 38);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton nutThem = new JButton("Thêm");
		nutThem.setFocusable(false);
		panel_1.add(nutThem);
		
		nutXoaTrang = new JButton("Xóa trắng");
		nutXoaTrang.setFocusable(false);
		panel_1.add(nutXoaTrang);
		
		JButton nutXoa = new JButton("Xóa");
		nutXoa.setFocusable(false);
		panel_1.add(nutXoa);
		
		JButton nutLuu = new JButton("Lưu");
		nutLuu.setFocusable(false);
		panel_1.add(nutLuu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 215, 703, 89);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 NV", "H\u1ECD", "T\u00EAn", "Ph\u00E1i", "Tu\u1ED5i", "Ti\u1EC1n l\u01B0\u01A1ng"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, JComboBox.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nutXoaTrang) {
			
		}
		
	}
}
