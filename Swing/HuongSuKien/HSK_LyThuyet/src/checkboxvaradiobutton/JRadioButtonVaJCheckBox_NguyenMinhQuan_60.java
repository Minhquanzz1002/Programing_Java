package checkboxvaradiobutton;
/**
 * Tên: Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JRadioButtonVaJCheckBox_NguyenMinhQuan_60 extends JFrame{

	public JRadioButtonVaJCheckBox_NguyenMinhQuan_60(String title) {
		setTitle(title);
	}
	public void doShow() {
		setSize(400, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
		setVisible(true);
	}
	public void addControl() {
		JLabel lblHelloWord = new JLabel("Hello Word!");
		lblHelloWord.setFont(new Font("Arial", Font.PLAIN, 20));
		
		/*CheckBox Italic và xự kiện Italic*/
		JCheckBox chkItalic = new JCheckBox("Italic");
		chkItalic.setFocusable(false);
		chkItalic.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				Font font = lblHelloWord.getFont();
				lblHelloWord.setFont(new Font(font.getName(), font.getStyle() ^ Font.ITALIC, font.getSize()));
			}
		});
		
		/*Nút Left và xử lý sự kiện nút Left*/
		JRadioButton radLeft = new JRadioButton("Left", true);
		radLeft.setFocusable(false);
		radLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblHelloWord.setHorizontalAlignment(JLabel.LEFT);
			}
		});
		
		/*Nút Right và xử lý sự kiện nút Right*/
		JRadioButton radRight = new JRadioButton("Right");
		radRight.setFocusable(false);
		radRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblHelloWord.setHorizontalAlignment(JLabel.RIGHT);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		group.add(radLeft);
		group.add(radRight);
		
		JPanel pnNourth = new JPanel();
		pnNourth.add(chkItalic);
		pnNourth.add(radLeft);
		pnNourth.add(radRight);
		
		JPanel pnRoot = new JPanel();
		pnRoot.setLayout(new BorderLayout());
		pnRoot.add(pnNourth, BorderLayout.NORTH);
		pnRoot.add(lblHelloWord, BorderLayout.CENTER);
		add(pnRoot);
	}
	public static void main(String[] args) {
		new JRadioButtonVaJCheckBox_NguyenMinhQuan_60("JRadioButton & JCheckBox").doShow();
	}
}
