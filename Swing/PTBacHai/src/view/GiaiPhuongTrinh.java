package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class GiaiPhuongTrinh extends JFrame implements ActionListener{
	private JPanel contentPane;
	private JTextField nhapA;
	private JTextField nhapB;
	private JTextField nhapC;
	private JTextField ketQua;
	private JButton nutGiai;
	private JButton nutXoaRong;
	private JButton nutThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaiPhuongTrinh frame = new GiaiPhuongTrinh();
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
	public GiaiPhuongTrinh() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 408);
		setTitle("^-^");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp a");
		lblNewLabel.setBounds(72, 84, 53, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp b");
		lblNewLabel_1.setBounds(72, 130, 46, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp c");
		lblNewLabel_2.setBounds(72, 180, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("K\u1EBFt qu\u1EA3");
		lblNewLabel_3.setBounds(72, 223, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		nhapA = new JTextField();
		nhapA.setBounds(135, 84, 188, 20);
		contentPane.add(nhapA);
		nhapA.setColumns(10);
		
		nhapB = new JTextField();
		nhapB.setBounds(135, 128, 188, 20);
		contentPane.add(nhapB);
		nhapB.setColumns(10);
		
		nhapC = new JTextField();
		nhapC.setBounds(135, 177, 188, 20);
		contentPane.add(nhapC);
		nhapC.setColumns(10);
		
		ketQua = new JTextField();
		ketQua.setBounds(135, 220, 188, 20);
		contentPane.add(ketQua);
		ketQua.setColumns(10);
		ketQua.setFocusable(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(0, 299, 508, 66);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 5, 0));
		
		nutGiai = new JButton("Gi\u1EA3i");
		nutGiai.setFocusable(false);
		nutGiai.addActionListener(this);
		panel.add(nutGiai);
		
		nutXoaRong = new JButton("X\u00F3a r\u1ED7ng");
		nutXoaRong.setFocusable(false);
		nutXoaRong.addActionListener(this);
		panel.add(nutXoaRong);
		
		nutThoat = new JButton("Tho\u00E1t");
		nutThoat.setFocusable(false);
		nutThoat.addActionListener(this);
		panel.add(nutThoat);
		
		JLabel tieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		tieuDe.setBounds(0, 0, 508, 54);
		tieuDe.setOpaque(true);
		tieuDe.setBackground(Color.cyan);
		tieuDe.setHorizontalAlignment(JTextField.CENTER);
		tieuDe.setFont(new Font(null, Font.BOLD, 25));

		contentPane.add(tieuDe);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nutGiai) {
			float a, b, c, delta;
			String dapAn;
			a = Float.valueOf(nhapA.getText());
			b = Float.valueOf(nhapB.getText());
			c = Float.valueOf(nhapC.getText());
			delta = b*b - 4*a*c;
			if (delta > 0) {
				float x1, x2;
				x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
	            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
	            dapAn = String.valueOf(x1 + ", " + x2);
			}else if (delta == 0) {
				float x = -b / (2*a);
				dapAn = String.valueOf(x);
			}else {
				dapAn = "Phương trình vô nghiệm";
			}
			ketQua.setText(dapAn);
		}
		if (e.getSource() == nutXoaRong) {
			nhapA.setText("");
			nhapB.setText("");
			nhapC.setText("");
			ketQua.setText("");
		}
		if (e.getSource() == nutThoat) {
			System.exit(0);
		}
	}
}
