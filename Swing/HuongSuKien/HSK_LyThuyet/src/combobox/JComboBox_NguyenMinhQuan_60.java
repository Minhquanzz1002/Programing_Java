package combobox;
/**
 * Tên: Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboBox_NguyenMinhQuan_60 extends JFrame{
	public JComboBox_NguyenMinhQuan_60(String title) {
		setTitle(title);
	}
	public void doShow() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(450, 100);
		addControl();
		setVisible(true);
	}
	public void addControl() {
		JLabel label = new JLabel("Lập Trình Hướng Sự Kiện Với Công Nghệ JAVA");
		label.setFont(new Font("Arial", Font.PLAIN, 17));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		JComboBox cboNameFont = new JComboBox();
		cboNameFont.addItem("Arial");
		cboNameFont.addItem("Serif");
		cboNameFont.addItem("Monospaced");
		cboNameFont.addItem("Sans Serif");
		cboNameFont.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Font font = label.getFont();
				label.setFont(new Font((String)cboNameFont.getSelectedItem(), font.getStyle(), font.getSize()));
			}
		});
		
		getContentPane().add(cboNameFont, BorderLayout.SOUTH);
		getContentPane().add(label);
		
	}
	public static void main(String[] args) {
		new JComboBox_NguyenMinhQuan_60("JCombox").doShow();
	}
}
