package checkboxdoifont;
/**
 * Tên: Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JCheckBox_NguyenMinhQuan_60 extends JFrame implements ItemListener{
	JTextField txtField;
	JCheckBox chkBold;
	JCheckBox chkItalic;
	public JCheckBox_NguyenMinhQuan_60(String title) {
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
		/*Phần nhập liệu*/
		txtField = new JTextField(20);
		txtField.setText("Lập Trình JAVA");
		txtField.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JPanel pnNourth = new JPanel();
		pnNourth.add(txtField);
		
		/*Phần CheckBox của Bold*/
		chkBold = new JCheckBox("<html><u>B</u>old</html>old");
		chkBold.setFocusable(false);
		
		chkItalic = new JCheckBox("Italic");
		chkItalic.setFocusable(false);
		
		JPanel pnCenter = new JPanel();
		pnCenter.add(chkBold);
		pnCenter.add(chkItalic);
		
		JPanel pnRoot = new JPanel();
		pnRoot.setLayout(new BorderLayout());
		pnRoot.add(pnNourth, BorderLayout.NORTH);
		pnRoot.add(pnCenter, BorderLayout.CENTER);
		
		getContentPane().add(pnRoot);
		
		/*add sự kiện*/
		chkItalic.addItemListener(this);
		chkBold.addItemListener(this);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Font font = txtField.getFont();
		if (e.getItem() == chkBold) {
			txtField.setFont(new Font(font.getName(), font.getStyle() ^ Font.BOLD, font.getSize()));
		}
		if (e.getItem() == chkItalic) {
			txtField.setFont(new Font(font.getName(), font.getStyle() ^ Font.ITALIC, font.getSize()));
		}
	}
	public static void main(String[] args) {
		new JCheckBox_NguyenMinhQuan_60("JCheckBox Test").doShow();
	}
}
