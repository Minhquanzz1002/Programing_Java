package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.LophocDAO;
import dao.SinhvienDAO;
import entity.Lophoc;
import entity.Sinhvien;
import model.SinhvienModel;

public class FrmSinhVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1554680235689968471L;
	private JTextField txtMaSV, txtHoTen, txtEmail, txtDiaChi;
	private JButton btnThem;
	private JButton btnXoarong;
	private JButton btnSua;
	private JButton btnXoa;
	private JTable table;
	private JScrollPane scroll;
	private JButton btnTim;
	private JTextField txtNgaysinh;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JComboBox<String> cboMalop;
	private SinhvienDAO sinhvienDAO;
	private LophocDAO lophocDAO;
	private JButton btnThoat;

	public FrmSinhVien()  {
		setTitle("Thong tin sinh vien");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		Container cp = getContentPane();

		Box b, b1,b2,b3,b4,b5,b6, b7,b8;
		cp.add(b = Box.createVerticalBox());
		b.add(Box.createVerticalStrut(10));b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b7 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(10));b.add(b8 = Box.createHorizontalBox());

		b.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel lblTieuDe, lblMaSV, lblHoTen, lblEmail, lblDiaChi, lblGioitinh, lblNgaysinh, lblMalop;
		b1.add(lblTieuDe = new JLabel("THÔNG TIN SINH VIÊN", JLabel.CENTER));
		lblTieuDe.setFont(new Font("Arila", Font.BOLD, 26));

		b2.add(lblMaSV = new JLabel("Mã số sinh viên: ", JLabel.RIGHT));b2.add(txtMaSV = new JTextField());
		txtMaSV.setText("12345678");
		b3.add(lblHoTen = new JLabel("Họ tên: ", JLabel.RIGHT));b3.add(txtHoTen = new JTextField());
		b4.add(lblGioitinh = new JLabel("Gioitinh: ", JLabel.RIGHT));

		ButtonGroup group = new ButtonGroup();
		rdoNam = new JRadioButton("Nam", true);
		rdoNu = new JRadioButton("Nữ");
		group.add(rdoNam);
		group.add(rdoNu);
		b4.add(rdoNam);b4.add(rdoNu);

		b4.add(lblNgaysinh = new JLabel("Ngày sinh: ", JLabel.RIGHT));b4.add(txtNgaysinh = new JTextField()); txtNgaysinh.setToolTipText("yyyy-M-d");
		txtNgaysinh.setText("1998-3-2");
		b4.add(lblMalop = new JLabel("Mã lớp: ", JLabel.RIGHT));
		b4.add(cboMalop = new JComboBox<String>()); 
		cboMalop.setPreferredSize(new Dimension(100, 0));
		cboMalop.setEditable(false);
		b5.add(lblDiaChi = new JLabel("Địa chỉ: ", JLabel.RIGHT));b5.add(txtDiaChi = new JTextField());
		b6.add(lblEmail = new JLabel("Email: ", JLabel.RIGHT));b6.add(txtEmail = new JTextField());
		txtEmail.setText("a@gmail.com");

		lblHoTen.setPreferredSize(lblMaSV.getPreferredSize());
		lblEmail.setPreferredSize(lblMaSV.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMaSV.getPreferredSize());
		lblNgaysinh.setPreferredSize(lblMaSV.getPreferredSize());
		lblGioitinh.setPreferredSize(lblMaSV.getPreferredSize());
		lblMalop.setPreferredSize(lblMaSV.getPreferredSize());

		b7.add(Box.createHorizontalGlue());
		b7.add(btnThem = new JButton("Thêm"));
		b7.add(btnXoarong = new JButton("Xóa rỗng"));
		b7.add(btnSua = new JButton("Sửa"));
		b7.add(btnXoa = new JButton("Xóa"));
		b7.add(btnTim = new JButton("Tìm theo mã lớp"));
		b7.add(btnThoat = new JButton("Thoát"));


		b8.add(scroll = new JScrollPane(table = new JTable()));
		scroll.setBorder(BorderFactory.createTitledBorder("Danh sách sinh viên"));

		btnThem.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoarong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);

		
		this.lophocDAO = new LophocDAO();
		this.sinhvienDAO = new SinhvienDAO();

		napLophoc();

		try {
			SinhvienModel model = new SinhvienModel(sinhvienDAO.getSinhviens());
			table.setModel(model);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
		}


		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					List<Sinhvien> dssv = sinhvienDAO.getSinhviens();
					int row  = table.getSelectedRow();
					if(row >=0 && row < dssv.size()) {
						Sinhvien  sv = dssv.get(row);
						napSinhvien(sv);
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
			}
		});
	}

	private void napSinhvien(Sinhvien sv) {
		txtMaSV.setText(sv.getMaSV());
		txtHoTen.setText(sv.getHoten());
		String x = sv.getGioitinh();
		if(x.equals("Nam"))
			rdoNam.setSelected(true);
		else
			rdoNu.setSelected(true);
		cboMalop.setSelectedItem(sv.getLophoc().getMalop());
		txtNgaysinh.setText(sv.getNgaysinh().toString());
		txtEmail.setText(sv.getEmail());
		txtDiaChi.setText(sv.getDiachi());
	}

	private void napLophoc() {
		try {
			cboMalop.addItem("All");
			List<Lophoc> dslh = lophocDAO.getLophocs();
			for(Lophoc lh : dslh) {
				cboMalop.addItem(lh.getMalop());
			}
		}catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			return;
		}
	}


	private void xoaRongTextfields() {
		txtMaSV.setText("");
		txtHoTen.setText("");
		rdoNam.setSelected(true);
		txtNgaysinh.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		txtMaSV.requestFocus();
		cboMalop.setSelectedIndex(0);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {
			if(o.equals(btnThem)) {
				if(valid()) {
					String gioitinh = (rdoNam.isSelected() ? "Nam" : "Nữ");
					
					SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
					Date ngaysinh = df.parse(txtNgaysinh.getText().trim());
					
					Sinhvien sv = new Sinhvien(txtMaSV.getText().trim(),
							txtHoTen.getText().trim(), 
							gioitinh , 
							new java.sql.Date(ngaysinh.getTime()), 
							txtDiaChi.getText().trim(), 
							txtEmail.getText().trim());
					Lophoc lophoc = new Lophoc(cboMalop.getSelectedItem().toString());
					sv.setLophoc(lophoc );

					if(sinhvienDAO.themSinhvien(sv)) {
						SinhvienModel model = new SinhvienModel(sinhvienDAO.getSinhviens());
						table.setModel(model);
					}
				}
			}else if(o.equals(btnThoat)) {
				System.exit(0);
			}else if(o.equals(btnXoarong)) {
				xoaRongTextfields();
			}else if(o.equals(btnTim)) {
				String malop = cboMalop.getSelectedItem().toString();
				List<Sinhvien> dssv = null;
				if(malop.equalsIgnoreCase("All"))
					dssv= sinhvienDAO.getSinhviens();
				else
					dssv= sinhvienDAO.getSinhviens(malop);
				SinhvienModel model = new SinhvienModel(dssv);
				table.setModel(model);
			}else if(o.equals(btnXoa)) {
				List<Sinhvien> dssv = sinhvienDAO.getSinhviens();
				int row  = table.getSelectedRow();
				if(row >=0 && row < dssv.size()) {
					Sinhvien  sv = dssv.get(row);
					if(sinhvienDAO.xoaSinhvien(sv)) {
						table.setModel(new SinhvienModel(sinhvienDAO.getSinhviens()));
						xoaRongTextfields();
					}
				}
			}
			else if(o.equals(btnSua)) {
				int r = table.getSelectedRow();
				String gioitinh = (rdoNam.isSelected() ? "Nam" : "Nữ");
				SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
				Date ngaysinh = df.parse(txtNgaysinh.getText().trim());
				String ma = table.getValueAt(r, 0).toString();
				Sinhvien sv = new Sinhvien(ma,
						txtHoTen.getText().trim(), 
						gioitinh,
						new java.sql.Date(ngaysinh.getTime()), 
						txtDiaChi.getText().trim(), 
						txtEmail.getText().trim());
				Lophoc lophoc = new Lophoc(cboMalop.getSelectedItem().toString());
				sv.setLophoc(lophoc );
				System.out.println(sv);
				if(r != -1) {
					if(sinhvienDAO.updateSinhVien(ma, sv)){
						SinhvienModel model = new SinhvienModel(sinhvienDAO.getSinhviens());
						table.setModel(model);
					}
				}
			}
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}


	private boolean valid() {

		String masv = txtMaSV.getText().trim();
		String ngaysinh = txtNgaysinh.getText().trim();

		if(!masv.matches("[0-9]{8}")) {
			showMessage(txtMaSV, "Mã sinh viên không hợp lệ!");
			return false;
		}

		if(!ngaysinh.matches("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}")) {
			showMessage(txtNgaysinh, "Ngày sinh (yyyy-M-d)!");
			return false;
		}

		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-M-d");
			df.parse(txtNgaysinh.getText().trim());
		}catch (Exception e) {
			showMessage(txtNgaysinh, "Ngày sinh không hợp lệ!");
			return false;
		}

		return true;
	}

	private void showMessage(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes);
		tf.selectAll();
		tf.requestFocus();
	}


}
