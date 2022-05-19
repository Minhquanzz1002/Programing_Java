package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class ChangePass extends JFrame {

	private JPanel pnBorderDad;
	private JPasswordField pwOldPass;
	private JPasswordField pwNewPass;
	private JPasswordField passwordField;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePass frame = new ChangePass();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangePass() {
		setLocationRelativeTo(null);
		setBounds(100, 100, 360, 210);
		pnBorderDad = new JPanel();
		pnBorderDad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnBorderDad);
		pnBorderDad.setLayout(null);
		
		JLabel lblOldPass = new JLabel("Mật khẩu cũ: ");
		lblOldPass.setFont(new Font("Arial", Font.BOLD, 13));
		lblOldPass.setBounds(52, 10, 89, 22);
		pnBorderDad.add(lblOldPass);
		
		pwOldPass = new JPasswordField();
		pwOldPass.setBounds(140, 12, 186, 19);
		pnBorderDad.add(pwOldPass);
		
		JLabel lblNewPass = new JLabel("Mật khẩu mới: ");
		lblNewPass.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewPass.setBounds(42, 59, 99, 22);
		pnBorderDad.add(lblNewPass);
		
		pwNewPass = new JPasswordField();
		pwNewPass.setBounds(140, 61, 186, 19);
		pnBorderDad.add(pwNewPass);
		
		JLabel lblConfirm = new JLabel("Xác nhận mật khẩu: ");
		lblConfirm.setFont(new Font("Arial", Font.BOLD, 13));
		lblConfirm.setBounds(6, 105, 135, 16);
		pnBorderDad.add(lblConfirm);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 104, 186, 19);
		pnBorderDad.add(passwordField);
		
		btnSubmit = new JButton("OK");
		btnSubmit.setFont(new Font("Arial", Font.BOLD, 13));
		btnSubmit.setBounds(123, 142, 85, 21);
		pnBorderDad.add(btnSubmit);
	}
}
