package pheptinh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUIPhepTinh extends JFrame implements ActionListener {
	JButton btnGiai, btnXoa, btnThoat;
	JTextField txtA, txtB, txtKQ;
	ButtonGroup grpPhepToan;

	public GUIPhepTinh(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		JPanel pnCha = new JPanel();
		pnCha.setLayout(new BorderLayout());

		/* NOURTH */
		JLabel lblTieuDe = new JLabel("Tính Cộng Trừ Nhân Chia");

		JPanel pnNourth = new JPanel();
		pnNourth.setBackground(Color.CYAN);
		pnNourth.add(lblTieuDe);

		/* WEST */
		btnGiai = new JButton("Giải");
		btnGiai.setFocusable(false);

		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);

		btnThoat = new JButton("Thoát");
		btnThoat.setFocusable(false);

		JPanel pnWest = new JPanel();
		pnWest.setBorder(BorderFactory.createTitledBorder("Chọn sự kiện"));
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.add(btnGiai);
		pnWest.add(Box.createVerticalStrut(10));
		pnWest.add(btnXoa);
		pnWest.add(Box.createVerticalStrut(10));
		pnWest.add(btnThoat);
		pnWest.setPreferredSize(new Dimension(100, 0));

		/* set Sự kiện */
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);

		/* SOUTH */
		JPanel pnRed = new JPanel();
		pnRed.setBackground(Color.RED);
		pnRed.setPreferredSize(new Dimension(30, 30));
		
		JPanel pnYellow = new JPanel();
		pnYellow.setBackground(Color.YELLOW);
		pnYellow.setPreferredSize(new Dimension(30, 30));
		
		JPanel pnBlue = new JPanel();
		pnBlue.setBackground(Color.BLUE);
		pnBlue.setPreferredSize(new Dimension(30, 30));
		
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.PINK);
		pnSouth.setPreferredSize(new Dimension(0, 50));
		pnSouth.add(pnRed);
		pnSouth.add(pnYellow);
		pnSouth.add(pnBlue);

		/* CENTER */
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		
		
		JLabel lblA = new JLabel("Nhập A:");

		txtA = new JTextField(20);
		txtA.setText("20");

		JPanel pnA = new JPanel();
		pnA.add(lblA);
		pnA.add(txtA);

		JLabel lblB = new JLabel("Nhập B:");

		txtB = new JTextField(20);
		txtB.setText("20");

		JPanel pnB = new JPanel();
		pnB.add(lblB);
		pnB.add(txtB);

		
		JRadioButton rdbCong = new JRadioButton("Cộng");
		rdbCong.setFocusable(false);
		
		JRadioButton rdbTru = new JRadioButton("Trừ");
		rdbTru.setFocusable(false);
		
		JRadioButton rdbNhan = new JRadioButton("Nhân");
		rdbNhan.setFocusable(false);
		
		JRadioButton rdbChia = new JRadioButton("Chia");
		rdbChia.setFocusable(false);
		
		grpPhepToan = new ButtonGroup();
		grpPhepToan.add(rdbCong);
		grpPhepToan.add(rdbTru);
		grpPhepToan.add(rdbNhan);
		grpPhepToan.add(rdbChia);
		
		JPanel pnPhepToan = new JPanel();
		pnPhepToan.setLayout(new GridLayout(2, 2));
		pnPhepToan.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		pnPhepToan.setPreferredSize(new Dimension(150, 100));
		pnPhepToan.add(rdbCong);
		pnPhepToan.add(rdbTru);
		pnPhepToan.add(rdbNhan);
		pnPhepToan.add(rdbChia);
		
		JLabel lblKQ = new JLabel("Kết quả:");

		txtKQ = new JTextField(20);
		txtKQ.setEditable(false);

		JPanel pnKQ = new JPanel();
		pnKQ.add(lblKQ);
		pnKQ.add(txtKQ);

		pnCenter.add(pnA);
		pnCenter.add(pnB);
		pnCenter.add(pnPhepToan);
		pnCenter.add(pnKQ);

		pnCha.add(pnNourth, BorderLayout.NORTH);
		pnCha.add(pnWest, BorderLayout.WEST);
		pnCha.add(pnCenter, BorderLayout.CENTER);
		pnCha.add(pnSouth, BorderLayout.SOUTH);

		add(pnCha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object suKien = e.getSource();
		if (suKien.equals(btnGiai)) {
			
		}
		else if(suKien.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		}else {
			int thoat = JOptionPane.showMessageDialog(null, "");
		}
	}

	public static void main(String[] args) {
		new GUIPhepTinh("Cộng Trừ Nhân Chia").doShow();
	}
}
