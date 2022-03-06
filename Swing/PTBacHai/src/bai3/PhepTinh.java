package bai3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class PhepTinh extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField nhapB;
	private JTextField nhapA;
	private JButton nutXoa;
	private JButton nutThoat;
	private JButton nutGiai;
	private JRadioButton nutCong;
	private JRadioButton nutTru;
	private JRadioButton nutNhan;
	private JRadioButton nutChia;
	private JLabel labelKetQua;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhepTinh frame = new PhepTinh();
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
	public PhepTinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 436);
		setTitle("Máy tính cơ bản");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tieuDe = new JLabel("Cộng Trừ Nhân Chia");
		tieuDe.setFont(new Font(null, Font.BOLD, 25));
		tieuDe.setForeground(Color.BLUE);
		tieuDe.setHorizontalAlignment(JTextField.CENTER);
		tieuDe.setBounds(0, 0, 551, 57);
		contentPane.add(tieuDe);
		
		JPanel panelChonTacVu = new JPanel();
		panelChonTacVu.setBounds(10, 59, 112, 279);
		panelChonTacVu.setBorder(new TitledBorder(null, "Chọn tác vụ", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panelChonTacVu);
		panelChonTacVu.setLayout(new GridLayout(0, 1, 0, 10));
		
		nutGiai = new JButton("Giải");
		nutGiai.setFocusable(false);
		nutGiai.addActionListener(this);
		panelChonTacVu.add(nutGiai);
		
		nutXoa = new JButton("Xóa");
		nutXoa.setFocusable(false);
		nutXoa.addActionListener(this);
		panelChonTacVu.add(nutXoa);
		
		nutThoat = new JButton("Thoát");
		nutThoat.setFocusable(false);
		nutThoat.addActionListener(this);
		panelChonTacVu.add(nutThoat);
		
		JLabel label = new JLabel("");
		panelChonTacVu.add(label);
		
		JPanel panelTinhToan = new JPanel();
		panelTinhToan.setBounds(125, 59, 416, 279);
		panelTinhToan.setBorder(new TitledBorder(null, "Tính toán", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		contentPane.add(panelTinhToan);
		panelTinhToan.setLayout(null);
		
		nhapA = new JTextField();
		nhapA.setBounds(85, 28, 236, 20);
		panelTinhToan.add(nhapA);
		nhapA.setColumns(10);
		
		nhapB = new JTextField();
		nhapB.setBounds(85, 59, 236, 20);
		panelTinhToan.add(nhapB);
		nhapB.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập a");
		lblNewLabel_2.setBounds(29, 31, 46, 14);
		panelTinhToan.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập b");
		lblNewLabel_1.setBounds(29, 62, 46, 14);
		panelTinhToan.add(lblNewLabel_1);
		
		labelKetQua = new JLabel("");
		labelKetQua.setBounds(85, 226, 236, 25);
		labelKetQua.setBorder(BorderFactory.createLineBorder(Color.gray));
		labelKetQua.setFocusable(false);
		panelTinhToan.add(labelKetQua);
		
		JLabel lblNewLabel_3 = new JLabel("Kết quả");
		lblNewLabel_3.setBounds(29, 237, 46, 14);
		panelTinhToan.add(lblNewLabel_3);
		
		JPanel panelPhepToan = new JPanel();
		panelPhepToan.setBounds(85, 104, 236, 97);
		panelPhepToan.setBorder(new TitledBorder(null, "Phép toán", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panelTinhToan.add(panelPhepToan);
		panelPhepToan.setLayout(new GridLayout(0, 2, 0, 0));
		
		nutCong = new JRadioButton("Cộng");
		nutCong.setSelected(true);
		panelPhepToan.add(nutCong);
		
		nutTru = new JRadioButton("Trừ");
		panelPhepToan.add(nutTru);
		
		nutChia = new JRadioButton("Chia");
		panelPhepToan.add(nutChia);
		
		nutNhan = new JRadioButton("Nhân");
		panelPhepToan.add(nutNhan);
		
		ButtonGroup nhomPhepTinh = new ButtonGroup();
		nhomPhepTinh.add(nutCong);
		nhomPhepTinh.add(nutTru);
		nhomPhepTinh.add(nutNhan);
		nhomPhepTinh.add(nutChia);
		
		JLabel labelMauXanh = new JLabel("");
		labelMauXanh.setBounds(211, 349, 24, 21);
		labelMauXanh.setOpaque(true);
		labelMauXanh.setBackground(Color.blue);
		contentPane.add(labelMauXanh);
		
		JLabel labelMauDo = new JLabel("");
		labelMauDo.setBounds(254, 349, 24, 21);
		labelMauDo.setOpaque(true);
		labelMauDo.setBackground(Color.red);
		contentPane.add(labelMauDo);
		
		JLabel labelMauVang = new JLabel("");
		labelMauVang.setBounds(299, 349, 24, 21);
		labelMauVang.setOpaque(true);
		labelMauVang.setBackground(Color.yellow);
		contentPane.add(labelMauVang);
		
		JLabel labelMauHong = new JLabel("");
		labelMauHong.setBounds(10, 338, 531, 57);
		labelMauHong.setOpaque(true);
		labelMauHong.setBackground(Color.PINK);
		contentPane.add(labelMauHong);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nutXoa) {
			nhapA.setText("");
			nhapB.setText("");
			labelKetQua.setText("");
		}
		if (e.getSource() == nutThoat) {
			System.exit(0);
		}
		if (e.getSource() == nutGiai) {
			float a = 0, b = 0;
			try {
				a = Float.valueOf(nhapA.getText());
				b = Float.valueOf(nhapB.getText());
			}catch(Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Đã có lỗi nhập dữ liệu", "Thông báo", JOptionPane.ERROR_MESSAGE);
			}
			if (nutCong.isSelected()) {
				labelKetQua.setText(String.valueOf((float) (a + b)));
			}else if (nutTru.isSelected()) {
				labelKetQua.setText(String.valueOf((float) (a - b)));
			}else if (nutNhan.isSelected()) {
				labelKetQua.setText(String.valueOf((float) (a * b)));
			}else {
				labelKetQua.setText(String.valueOf((float) (a / b)));
			}
		}
	}
}
