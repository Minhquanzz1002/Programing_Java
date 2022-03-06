package doinhietdo1;
/**
 * @author Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NguyenMinhQuan_20098151_ChuyenDoCSangDoFFlowLayout extends JFrame implements ActionListener {
	private JTextField textDoC;
	private JButton btnChuyenDoi;
	private JButton btnThoat;
	private JLabel lblKetQua;

	NguyenMinhQuan_20098151_ChuyenDoCSangDoFFlowLayout() {
		doShow();
		addControl();
		setVisible(true);
	}

	public void doShow() {
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("C sang F");
	}

	public void addControl() {
		JLabel lblDoC = new JLabel("Nhập độ C cần chuyển đổi:");
		lblDoC.setLabelFor(textDoC);

		textDoC = new JTextField(10);
		textDoC.addActionListener(this);

		lblKetQua = new JLabel(".....");

		JLabel lblDoF = new JLabel("Kết quả chuyển đổi sang độ F: ");
		lblDoF.setLabelFor(lblKetQua);

		Box box1 = Box.createHorizontalBox();
		box1.add(lblDoC);
		box1.add(textDoC);

		Box box2 = Box.createHorizontalBox();
		box2.add(lblDoF);
		box2.add(lblKetQua);

		btnChuyenDoi = new JButton("Chuyển đổi");
		btnChuyenDoi.setFocusable(false);
		btnChuyenDoi.addActionListener(this);

		btnThoat = new JButton("Thoát");
		btnThoat.setFocusable(false);
		btnThoat.addActionListener(this);

		Box box3 = Box.createHorizontalBox();
		box3.add(btnChuyenDoi);
		box3.add(btnThoat);

		getContentPane().setLayout(new FlowLayout());
		getContentPane().add(box1);
		getContentPane().add(box2);
		getContentPane().add(box3);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnThoat) {
			System.exit(0);
		} else {
			float doC = Float.parseFloat(textDoC.getText());
			float doF = (float) (1.8 * doC + 32.0);
			lblKetQua.setText(doF + "");
		}
	}

	public static void main(String[] args) {
		new NguyenMinhQuan_20098151_ChuyenDoCSangDoFFlowLayout();
	}
}
