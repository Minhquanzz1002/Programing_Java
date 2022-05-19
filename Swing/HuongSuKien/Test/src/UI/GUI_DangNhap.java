package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI_DangNhap extends JFrame implements ActionListener{
	private static GUI_DangNhap dn;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JCheckBox jcbShow;
	private JButton jbtThoat;
	private JButton jbtDangNhap;
	public GUI_DangNhap() {
		setTitle("Đăng Nhập");
		setSize(800, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setResizable(false);
		login();
		setVisible(true);
	}
	
	public void login() {
		JPanel pnLogin = new JPanel();
		pnLogin.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		pnLogin.setBackground(new Color(255, 255, 204));
		pnLogin.setLayout(new BorderLayout());
		JPanel pnTieuDe = new JPanel();
		pnTieuDe.setLayout(new BoxLayout(pnTieuDe, BoxLayout.Y_AXIS));
		pnTieuDe.setBackground(Color.CYAN);
		JPanel pnTd = new JPanel();
		pnTd.setBackground(new Color(255, 255, 204));
		JPanel pnTd1 = new JPanel();
		pnTd1.setBackground(new Color(255, 255, 204));
		JLabel lblTieuDe =new JLabel("Chào Mừng Đến Với Phần Mềm");
		JLabel lblTieuDe1 =new JLabel(" Quản Lý Lao Động Của Công Ty TNHH FourMan");
		Font ft = new Font(getName(), Font.BOLD, 20);
		lblTieuDe.setFont(ft);
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe1.setForeground(Color.BLUE);
		lblTieuDe1.setFont(ft);
		pnTd.add(lblTieuDe);
		pnTd1.add(lblTieuDe1);
		pnTieuDe.add(pnTd);
		pnTieuDe.add(pnTd1);
		pnLogin.add(pnTieuDe,BorderLayout.NORTH);
		
		JPanel pnNhap = new JPanel();
		pnNhap.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 204) , 10));
		pnNhap.setLayout(new GridLayout(1, 2));
		pnNhap.setBackground(new Color(225, 255, 255));
		ImageIcon img = new ImageIcon("img\\logo2.png");
		Image image = img.getImage(); 
		Image newimg = image.getScaledInstance(400, 350,  java.awt.Image.SCALE_SMOOTH); 
		img = new ImageIcon(newimg);
		JLabel lblAnh = new JLabel(img);		
		pnNhap.add(lblAnh);
		pnNhap.add(dangNhap());
		pnLogin.add(pnNhap,BorderLayout.CENTER);
		add(pnLogin);
		jcbShow.addActionListener(this);
		jbtThoat.addActionListener(this);
		jbtDangNhap.addActionListener(this);
		
	}
	public Component dangNhap() {
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BoxLayout(pnDangNhap, BoxLayout.Y_AXIS));
		pnDangNhap.setBackground(new Color(225, 255, 255));
		JPanel pnUser = new JPanel();
		pnUser.setBackground(new Color(225, 255, 255));
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Cambria", Font.BOLD, 20));
		txtUser = new JTextField(20);
		txtUser.setToolTipText("Mời Nhập Tài khoản");
		txtUser.setFont(new Font(getName(), Font.BOLD, 15));
		txtUser.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		txtUser.setPreferredSize(new Dimension(25, 30));
		pnUser.add(lblUser);
		pnUser.add(txtUser);
		
		JPanel pnPass = new JPanel();
		pnPass.setBackground(new Color(225, 255, 255));
		JLabel lblPass = new JLabel("Password:");
		lblPass.setFont(new Font("Cambria", Font.BOLD, 20));
		txtPass = new JPasswordField(20);
		txtPass.setEchoChar('*');
		txtPass.setToolTipText("Mời Nhập Mật Khẩu.");
		txtPass.setFont(new Font(getName(), Font.BOLD, 15));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		txtPass.setPreferredSize(new Dimension(25, 30));
		pnPass.add(lblPass);
		pnPass.add(txtPass);
		
		JPanel pnShow =new JPanel();
		pnShow.setBackground(new Color(225, 255, 255));
		jcbShow =new JCheckBox("Hiển thị mật khẩu.");
		jcbShow.setBackground(new Color(225, 255, 255));
		pnShow.setAlignmentX(SwingConstants.RIGHT);
		pnShow.add(Box.createHorizontalStrut(100));
		pnShow.add(jcbShow);
		
		JPanel pnClick = new JPanel();
		pnClick.setBackground(new Color(225, 255, 255));
		jbtDangNhap = new JButton("Đăng Nhập");
		jbtDangNhap.setPreferredSize(new Dimension(100, 30));
		jbtThoat = new JButton("Thoát");
		jbtThoat.setPreferredSize(new Dimension(100, 30));
		pnClick.add(Box.createHorizontalStrut(60));
		pnClick.add(jbtDangNhap);
		pnClick.add(jbtThoat);
		
		pnDangNhap.add(Box.createVerticalStrut(100));
		pnDangNhap.add(pnUser);
		pnDangNhap.add(Box.createVerticalStrut(10));
		pnDangNhap.add(pnPass);
		pnDangNhap.add(pnShow);
		pnDangNhap.add(pnClick);
		pnDangNhap.add(Box.createVerticalStrut(200));
		lblUser.setPreferredSize(lblPass.getPreferredSize());
		return pnDangNhap;
		
	}
//	public static void main(String[] args) {
//		 dn= new GUI_DangNhap();
//		 dn.setVisible(true);
//	}
	
	//kiem tra pass
	public boolean kiemTraPass( char[] pass) {
		char[] mk = {'1','2','3'};
		return Arrays.equals(pass, mk);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jcbShow)) {
			if (jcbShow.isSelected()) {
				txtPass.setEchoChar((char)0);
			}
			else {
				txtPass.setEchoChar('*');
			}
		}
		if (e.getSource().equals(jbtDangNhap)) {
			if (txtUser.getText().equals("admin") && kiemTraPass(txtPass.getPassword())) {
				dn.setVisible(false);
				new GUI_UNGDUNG().setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Thông Tin Đăng Nhập Không Chính Xác!!!","Cảnh Báo Đăng Nhập!!!", JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource().equals(jbtThoat)) {
			if (JOptionPane.showConfirmDialog(null,"Bạn Chắc Chắn Muốn Thoát?","Thoát",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(this.EXIT_ON_CLOSE);
			}
			
		}
	}
}
