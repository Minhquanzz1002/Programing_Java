package tuan02.giaiphuongtrinhbachai;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUIGiaiPhuongTrinhBacHai extends JFrame {
	public GUIGiaiPhuongTrinhBacHai(String title) {
		setTitle(title);
	}

	public void doShow() {
		setSize(400, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		JPanel pnBorderRoot = new JPanel();
		pnBorderRoot.setLayout(new BorderLayout());

		/* NOURTH: phần tiêu đề */
		JLabel lblTitle = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font(null, Font.BOLD, 25));

		JPanel pnNourth = new JPanel();
		pnNourth.setBackground(Color.CYAN);
		pnNourth.add(lblTitle);

		/* CENTER: phần thân */
		/* Phần kết quả */
		JTextField txtResult = new JTextField(20);
		txtResult.setEditable(false);

		JLabel lblResult = new JLabel("Kết quả:");
		lblResult.setLabelFor(txtResult);

		JPanel pnResult = new JPanel();
		pnResult.add(lblResult);
		pnResult.add(txtResult);

		/* Phần nhập của A */
		JTextField txtA = new JTextField(20);

		JLabel lblA = new JLabel("Nhập a:");
		lblA.setLabelFor(txtA);
		lblA.setPreferredSize(lblResult.getPreferredSize());

		JPanel pnA = new JPanel();
		pnA.add(lblA);
		pnA.add(txtA);

		/* Phần nhập của B */
		JTextField txtB = new JTextField(20);

		JLabel lblB = new JLabel("Nhập b:");
		lblB.setLabelFor(txtB);
		lblB.setPreferredSize(lblResult.getPreferredSize());

		JPanel pnB = new JPanel();
		pnB.add(lblB);
		pnB.add(txtB);

		/* Phần nhập của C */
		JTextField txtC = new JTextField(20);

		JLabel lblC = new JLabel("Nhập c:");
		lblC.setLabelFor(txtC);
		lblC.setPreferredSize(lblResult.getPreferredSize());

		JPanel pnC = new JPanel();
		pnC.add(lblC);
		pnC.add(txtC);

		JPanel pnCenter = new JPanel();
		pnCenter.add(pnA);
		pnCenter.add(pnB);
		pnCenter.add(pnC);
		pnCenter.add(pnResult);

		/* SOUTH: phần các nút bấm */
		JButton btnSolve = new JButton("Giải");
		btnSolve.setFocusable(false);
		btnSolve.setMnemonic(KeyEvent.VK_G);
		btnSolve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float a = 0, b = 0, c = 0;
				while (true) {
					try {
						a = Float.parseFloat(txtA.getText().trim());
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Bạn phải nhập một số");
						txtA.requestFocus();
						break;
					}
					try {
						b = Float.parseFloat(txtB.getText());
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Bạn phải nhập một số");
						txtB.requestFocus();
						break;
					}
					try {
						c = Float.parseFloat(txtC.getText());
						break;
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Bạn phải nhập một số");
						txtC.requestFocus();
						break;
					}
				}
				txtResult.setText(new GiaiPhuongTrinhBacHai(a, b, c).giaiPhuongTrinhBacHai());
			}
		});

		JButton btnDel = new JButton("Xóa");
		btnDel.setFocusable(false);
		btnDel.setMnemonic(KeyEvent.VK_X);
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Hành động này sẽ xóa tất cả dữ liệu?", "Xác nhận xóa",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					txtA.setText("");
					txtA.requestFocus(); // sau khi xóa xong tự động focus con trỏ về text A
					txtB.setText("");
					txtC.setText("");
					txtResult.setText("");
				}
			}
		});

		JButton btnExit = new JButton("Thoát");
		btnExit.setFocusable(false);
		btnExit.setMnemonic(KeyEvent.VK_T);
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Bạn thật sự muốn thoát?", "Thoát chương trình",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JPanel pnSouth = new JPanel();
		pnSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pnSouth.add(btnSolve);
		pnSouth.add(btnDel);
		pnSouth.add(btnExit);

		/* add các panel vào panel gốc */
		add(pnBorderRoot);
		pnBorderRoot.add(pnNourth, BorderLayout.NORTH);
		pnBorderRoot.add(pnSouth, BorderLayout.SOUTH);
		pnBorderRoot.add(pnCenter, BorderLayout.CENTER);
		
		/*Các dữ liệu test*/
		txtA.setText("1");
		txtB.setText("-4");
		txtC.setText("4");
	}

	public static void main(String[] args) {
		new GUIGiaiPhuongTrinhBacHai("Giải Phương Trình Bậc Hai").doShow();
	}
}
