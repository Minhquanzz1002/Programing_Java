package tuan05.quanlynhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GUIManagementEmployee extends JFrame implements ActionListener, MouseListener {
	private ListEmployee lstEmp;
	private JTextField txtEmpID, txtLastName, txtFirstName, txtSalary, txtAge, txtSearch;
	private JRadioButton radMale, radFemale;
	private ButtonGroup grpSex;
	private JButton btnSearch, btnAdd, btnDel, btnClear, btnSave, btnLoad, btnUpdate;
	private DefaultTableModel tblModel;
	private JTable tblEmp;
	private String[] col = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
	private FlowLayout fl;
	private Border loweredBevel;
	private JComboBox<String> cboSex;

	public GUIManagementEmployee(String title) {
		setTitle(title);
	}

	public void doShow() {
		lstEmp = new ListEmployee();
		setSize(600, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addControl();
		setVisible(true);
		pack();
	}

	public void addControl() {
		/* Phần title */
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN", JLabel.CENTER);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 24));

		fl = new FlowLayout(FlowLayout.LEFT);

		/* Phần input mã nhân viên */
		JLabel lblEmpID = new JLabel("Mã nhân viên:");
		txtEmpID = new JTextField(60);
		JPanel pnEmpID = new JPanel(fl);
		pnEmpID.add(lblEmpID);
		pnEmpID.add(txtEmpID);

		/* Phần input họ và tên */
		JLabel lblFirstName = new JLabel("Họ:", JLabel.LEFT);
		txtFirstName = new JTextField(25);
		JLabel lblLastName = new JLabel("Tên:", JLabel.CENTER);
		txtLastName = new JTextField(25);
		JPanel pnName = new JPanel(fl);
		pnName.add(lblFirstName);
		pnName.add(txtFirstName);
		pnName.add(lblLastName);
		pnName.add(txtLastName);

		/* Phần input tuổi và giới tính */
		JPanel pnAge_Sex = new JPanel(fl);
		JLabel lblAge = new JLabel("Tuổi:");
		txtAge = new JTextField(42);
		JLabel lblSex = new JLabel("Phái:");
		radFemale = new JRadioButton("Nữ");
		radFemale.setFocusable(false);
		radFemale.setActionCommand("Nữ");
		radMale = new JRadioButton("Nam");
		radMale.setFocusable(false);
		radMale.setActionCommand("Nam");
		grpSex = new ButtonGroup();
		grpSex.add(radMale);
		grpSex.add(radFemale);
		pnAge_Sex.add(lblAge);
		pnAge_Sex.add(txtAge);
		pnAge_Sex.add(lblSex);
		pnAge_Sex.add(radMale);
		pnAge_Sex.add(radFemale);

		/* Phần input lương */
		JPanel pnSalary = new JPanel(fl);
		JLabel lblSalary = new JLabel("Tiền lương:");
		txtSalary = new JTextField(60);
		pnSalary.add(lblSalary);
		pnSalary.add(txtSalary);

		/* Table */
		tblModel = new DefaultTableModel(col, 0);

		cboSex = new JComboBox<>();
		cboSex.addItem("Nam");
		cboSex.addItem("Nữ");

		/* Load data from file */
		StoredData stData = new StoredData();
		try {
			lstEmp = (ListEmployee) stData.loadFile("data\\EmployeeData.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

		loadDataToTable(lstEmp.getLstEmployee(), tblModel); // load data vao table
		tblEmp = new JTable(tblModel);
		tblEmp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);		//set kieu chon trong table
		
		DefaultCellEditor de = new DefaultCellEditor(cboSex);
		tblEmp.getColumnModel().getColumn(3).setCellEditor(de);

		JScrollPane scrTable = new JScrollPane(tblEmp);

		JPanel pnTable = new JPanel();
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		pnTable.add(scrTable);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.add(pnEmpID);
		pnCenter.add(pnName);
		pnCenter.add(pnAge_Sex);
		pnCenter.add(pnSalary);
		pnCenter.add(pnTable);

		/* Chỉnh độ rộng label */
		lblFirstName.setPreferredSize(lblEmpID.getPreferredSize());
		lblAge.setPreferredSize(lblEmpID.getPreferredSize());
		lblSalary.setPreferredSize(lblEmpID.getPreferredSize());

		/* Phần Search */
		JLabel lblSearch = new JLabel("Nhập mã số cần tìm:");

		txtSearch = new JTextField(15);

		btnSearch = new JButton("Tìm");
		btnSearch.setFocusable(false);

		loweredBevel = BorderFactory.createLoweredBevelBorder();
		JPanel pnSearch = new JPanel();
		pnSearch.setBorder(loweredBevel);
		pnSearch.add(lblSearch);
		pnSearch.add(txtSearch);
		pnSearch.add(btnSearch);

		/* Phần Control */

		btnAdd = new JButton("Thêm");
		btnAdd.setFocusable(false);
		btnClear = new JButton("Xóa trắng");
		btnClear.setFocusable(false);
		btnDel = new JButton("Xóa");
		btnDel.setFocusable(false);
		btnSave = new JButton("Lưu");
		btnSave.setFocusable(false);
		btnUpdate = new JButton("Sửa");
		btnUpdate.setFocusable(false);

		JPanel pnControl = new JPanel();
		pnControl.setBorder(loweredBevel);
		pnControl.add(btnAdd);
		pnControl.add(btnClear);
		pnControl.add(btnDel);
		pnControl.add(btnSave);
		pnControl.add(btnUpdate);

		JPanel pnSouth = new JPanel(new BorderLayout());
		pnSouth.add(pnSearch, BorderLayout.WEST);
		pnSouth.add(pnControl, BorderLayout.CENTER);

		JPanel pnBorderCha = new JPanel();
		pnBorderCha.setBorder(BorderFactory.createLoweredBevelBorder());
		pnBorderCha.setLayout(new BorderLayout());
		pnBorderCha.add(lblTitle, BorderLayout.NORTH);
		pnBorderCha.add(pnCenter, BorderLayout.CENTER);
		pnBorderCha.add(pnSouth, BorderLayout.SOUTH);
		add(pnBorderCha);

		/* Phần các sự kiện */
		btnClear.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnSave.addActionListener(this);
		btnSearch.addActionListener(this);
		btnUpdate.addActionListener(this);
		tblEmp.addMouseListener(this);

		/* Sữa size label */
		lblLastName.setPreferredSize(
				new Dimension(txtEmpID.getPreferredSize().width - txtFirstName.getPreferredSize().width
						- txtLastName.getPreferredSize().width - 10, lblEmpID.getPreferredSize().height));
		radMale.setPreferredSize(
				new Dimension((txtEmpID.getPreferredSize().width - txtAge.getPreferredSize().width - 15) / 3,
						lblEmpID.getPreferredSize().height));
		radFemale.setPreferredSize(
				new Dimension((txtEmpID.getPreferredSize().width - txtAge.getPreferredSize().width - 15) / 3,
						lblEmpID.getPreferredSize().height));
		lblSex.setPreferredSize(
				new Dimension((txtEmpID.getPreferredSize().width - txtAge.getPreferredSize().width - 15) / 3,
						lblEmpID.getPreferredSize().height));

		/* Phần dữ liệu test */
		txtEmpID.setText("5555");
		txtFirstName.setText("Nguyen Minh");
		txtLastName.setText("Quan");
		txtAge.setText("20");
		txtSalary.setText("100000");
		txtSearch.setText("5555");
		radMale.setSelected(true);
	}

	public void loadDataToTable(ArrayList<Employee> lst, DefaultTableModel tblModel) {
		for (Employee emp : lst) {
			Object[] obj = { emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(), emp.getSex(), emp.getAge(),
					emp.getSalary() };
			tblModel.addRow(obj);
		}
	}

	public void clearItem() {
		txtEmpID.setText("");
		txtLastName.setText("");
		txtFirstName.setText("");
		txtSalary.setText("");
		txtAge.setText("");
		txtSearch.setText("");
		grpSex.clearSelection();
		txtEmpID.requestFocus();
	}

	public Employee createNewEmployee() {
		if (checkTextFiledIsEmpty()) {
			return null;
		}
		Employee item;
		String empID, firstname, lastname, sex;
		double salary;
		int age;
		empID = txtEmpID.getText().trim();
		firstname = txtFirstName.getText().trim();
		lastname = txtLastName.getText().trim();
		sex = grpSex.getSelection().getActionCommand();
		salary = Double.parseDouble(txtSalary.getText().trim());
		age = Integer.parseInt(txtAge.getText().trim());
		item = new Employee(empID, firstname, lastname, sex, age, salary);
		return item;
	}

	public void loadDataToText(Employee e) {
		txtEmpID.setText(e.getEmployeeID());
		txtFirstName.setText(e.getFirstName());
		txtLastName.setText(e.getLastName());
		if (e.getSex().equals("Nam")) {
			radMale.setSelected(true);
		} else {
			radFemale.setSelected(true);
		}
		txtSalary.setText(String.valueOf(e.getSalary()));
		txtAge.setText(String.valueOf(e.getAge()));
	}
	
	public boolean checkTextFiledIsEmpty(){
		if (txtEmpID.getText().trim().isEmpty() || txtFirstName.getText().trim().isEmpty()
				|| txtLastName.getText().trim().isEmpty() || txtAge.getText().trim().isEmpty()
				|| txtSalary.getText().trim().isEmpty() || grpSex.getSelection() == null) {
			return true;
		}
		return false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblEmp.getSelectedRow();
		if (row != -1) {
			Employee emp = lstEmp.getLstEmployee().get(row);
			loadDataToText(emp);
		}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if (action == btnClear) {
			clearItem();
		}
		if (action == btnAdd) {
			if (checkTextFiledIsEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đẩy đủ thông tin!");
			} else {
				Employee emp = createNewEmployee();
				if (emp == null) {
					JOptionPane.showMessageDialog(null, "Thông tin nhập không hợp lệ");
				} else {
					if (lstEmp.addEmployee(emp)) {
						Object[] obj = { emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(), emp.getSex(),
								emp.getAge(), emp.getSalary() };
						tblModel.addRow(obj);
						JOptionPane.showMessageDialog(null, "Thêm thành công!!");
						clearItem();
					}else {
						JOptionPane.showMessageDialog(this, "Nhân viên đã tài tại");
					}
				}
			}
		}
		if (action == btnDel) {
			int selectRow = tblEmp.getSelectedRow();
			if (selectRow == -1) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên bạn muốn xóa!!!");
			} else {
				Employee item = lstEmp.getLstEmployee().get(selectRow);
				if (JOptionPane.showConfirmDialog(this,
						"Bạn có chắc chắn muốn xóa nhân viên này không?" + item.getEmployeeID() + " "
								+ item.getLastName(),
						"Lựa chọn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if (lstEmp.deleteEmployee(item)) {
						tblModel.removeRow(selectRow);
//						tblEmp.setModel(tblModel = new DefaultTableModel(col, 0));
//						loadDataToTable(lstEmp.getLstEmployee(), tblModel);
						JOptionPane.showMessageDialog(this, "Xóa thành công!!!");
					}

				}
			}
		}
		if (action == btnSave) {
			try {
				StoredData stData = new StoredData();
				if (stData.saveFile(lstEmp, "data\\EmployeeData.txt")) {
					JOptionPane.showMessageDialog(null, "Lưu thông tin nhân viên thành công!!!");
				} else {
					JOptionPane.showMessageDialog(null, "Lưu thông tin nhân viên thất bại!!!");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if (action == btnSearch) {
			String item =  txtSearch.getText().trim();
			int row = lstEmp.searchEmployee(item);
			if (row != -1) {
				tblEmp.setRowSelectionInterval(row, row);
			}else {
				JOptionPane.showMessageDialog(this, "Không tìm thấy");
			}
		}
		if (action == btnUpdate) {
			int selectRow = tblEmp.getSelectedRow();
			if (selectRow < 0) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên bạn muốn sửa!!!");
			} else {
				Employee item = lstEmp.getLstEmployee().get(selectRow);
				Employee itemNew = createNewEmployee();
				if (itemNew == null) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin trước!");
				} else {
					if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa", "Xác nhận",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (lstEmp.updateEmployee(item, itemNew)) {
							tblEmp.setModel(tblModel = new DefaultTableModel(col, 0));
							loadDataToTable(lstEmp.getLstEmployee(), tblModel);
							JOptionPane.showMessageDialog(this, "Cập nhật thành công!!!");
						} else {
							JOptionPane.showMessageDialog(this, "Cập nhật không thành công!!!");
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		new GUIManagementEmployee("Quản lý nhân viên").doShow();
	}
}
