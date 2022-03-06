package doimaunen;
/**
 * @author Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NguyenMinhQuan_20098151_DoiMauNen extends JFrame implements ActionListener{
	private JButton btnRed;
	private JButton btnYellow;
	private JPanel panel;
	NguyenMinhQuan_20098151_DoiMauNen(){
		doShow();
		addControl();
		setVisible(true);
	}
	public void doShow() {
		setTitle("Đổi màu nền");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	public void addControl() {
		btnRed = new JButton("RED");
		btnRed.setFocusable(false);
		btnRed.addActionListener(this);
		
		btnYellow = new JButton("YELLOW");
		btnYellow.setFocusable(false);
		btnYellow.addActionListener(this);
		
		panel = new JPanel();
		panel.add(btnRed);
		panel.add(btnYellow);
		
		getContentPane().add(panel, BorderLayout.NORTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRed) {
			getContentPane().setBackground(Color.RED);
			panel.setBackground(Color.RED);
		}
		if (e.getSource() == btnYellow) {
			getContentPane().setBackground(Color.YELLOW);
			panel.setBackground(Color.YELLOW);
		}
	}
	public static void main(String[] args) {
		new NguyenMinhQuan_20098151_DoiMauNen();
	}

}
