package tuan05.edittable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 * */
public class EditTable_NguyenMinhQuan_60 extends JFrame implements ActionListener, MouseListener {
	JButton btnThem, btnXoa, btnThoat, btnSua;
	JTextField txtTen, txtHo;
	DefaultTableModel modelDSTen;
	JTable tableDSTen;

	public EditTable_NguyenMinhQuan_60(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		/* Phần nhập họ */
		JLabel lblHo = new JLabel("Họ");
		lblHo.setLabelFor(txtHo);

		txtHo = new JTextField(21);

		JPanel pnHo = new JPanel();
		pnHo.add(lblHo);
		pnHo.add(txtHo);

		/* Phần nhập tên */
		JLabel lblTen = new JLabel("Tên");
		lblTen.setLabelFor(txtTen);

		txtTen = new JTextField(21);

		JPanel pnTen = new JPanel();
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		
		
		lblHo.setPreferredSize(lblTen.getPreferredSize());

		/* Phần nút bấm */
		btnThem = new JButton("Thêm");
		btnThem.setFocusable(false);

		btnXoa = new JButton("Xóa");
		btnXoa.setFocusable(false);

		btnThoat = new JButton("Thoát");
		btnThoat.setFocusable(false);

		btnSua = new JButton("Sửa");
		btnSua.setFocusable(false);

		JPanel pnNutBam = new JPanel();
		pnNutBam.add(btnThem);
		pnNutBam.add(btnXoa);
		pnNutBam.add(btnThoat);
		pnNutBam.add(btnSua);

		/* Phần bảng */
		String[] colsDSTen = { "Họ", "Tên" };
		modelDSTen = new DefaultTableModel(colsDSTen, 0);
		tableDSTen = new JTable(modelDSTen);
		JScrollPane paneDSTen = new JScrollPane(tableDSTen);

		/* Các sự kiện */
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		btnSua.addActionListener(this);
		tableDSTen.addMouseListener(this);

		JPanel pnNourth = new JPanel();
		pnNourth.setLayout(new BoxLayout(pnNourth, BoxLayout.Y_AXIS));
		pnNourth.add(pnHo);
		pnNourth.add(pnTen);
		pnNourth.add(pnNutBam);

		JPanel pnCha = new JPanel();
		pnCha.setLayout(new BorderLayout());
		pnCha.add(pnNourth, BorderLayout.NORTH);
		pnCha.add(paneDSTen, BorderLayout.CENTER);
		add(pnCha);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (txtHo.getText().equals("") || txtTen.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Phải nhập dữ liệu trước.");
			else {
				Object[] obj = new Object[2];
				obj[0] = txtHo.getText();
				obj[1] = txtTen.getText();
				modelDSTen.addRow(obj);
			}
		} else if (o.equals(btnXoa)) {
			if (tableDSTen.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phai chon dong can xoa.");
			else {
				if (JOptionPane.showConfirmDialog(this, "Ban co muon xoa dong nay khong?", "Canh bao",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					modelDSTen.removeRow(tableDSTen.getSelectedRow());
			}
		} else if (o.equals(btnSua)) {
			if (tableDSTen.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Phai chon dong can sua.");
			else {
				int row = tableDSTen.getSelectedRow();
				modelDSTen.setValueAt(txtHo.getText(), row, 0);
				modelDSTen.setValueAt(txtTen.getText(), row, 1);
			}
		} else {
			int exit = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", "Xác nhận thoát",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableDSTen.getSelectedRow();
		txtHo.setText(tableDSTen.getValueAt(row, 0).toString());
		txtTen.setText(tableDSTen.getValueAt(row, 1).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public static void main(String[] args) {
		new EditTable_NguyenMinhQuan_60("Edit Table").doShow();
	}

}
