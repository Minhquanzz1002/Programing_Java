package tuan05.quanlynhanvien;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Thu extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmpID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtSalary;
	private JTextField txtAge;
	private JTextField textField;
	private JTable tblEmployee;
	DefaultTableModel tblModel;
	String[] col = {"Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thu frame = new Thu();
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
	public Thu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnBorderCha = new JPanel();
		contentPane.add(pnBorderCha, BorderLayout.CENTER);
		pnBorderCha.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("TH\u00D4NG TIN NH\u00C2N VI\u00CAN");
		lblTitle.setFont(new Font("Monospaced", Font.BOLD, 24));
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnBorderCha.add(lblTitle, BorderLayout.NORTH);
		
		JPanel pnSouth = new JPanel();
		pnBorderCha.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setLayout(new BorderLayout(5, 0));
		
		JPanel pbSearch = new JPanel();
		pbSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		FlowLayout fl_pbSearch = (FlowLayout) pbSearch.getLayout();
		pnSouth.add(pbSearch, BorderLayout.WEST);
		
		JLabel lblSearch = new JLabel("Nh\u1EADp m\u00E3 s\u1ED1 c\u1EA7n t\u00ECm:");
		pbSearch.add(lblSearch);
		
		textField = new JTextField();
		pbSearch.add(textField);
		textField.setColumns(20);
		
		JButton btnNewButton = new JButton("T\u00ECm");
		pbSearch.add(btnNewButton);
		
		JPanel pnControl = new JPanel();
		pnControl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnSouth.add(pnControl);
		pnControl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAdd = new JButton("Th\u00EAm");
		pnControl.add(btnAdd);
		
		JButton btnClear = new JButton("X\u00F3a tr\u1EAFng");
		pnControl.add(btnClear);
		
		JButton btnDel = new JButton("X\u00F3a");
		pnControl.add(btnDel);
		
		JButton btnSave = new JButton("L\u01B0u");
		pnControl.add(btnSave);
		
		JPanel pnCenter = new JPanel();
		pnBorderCha.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		
		JPanel pnEmpID = new JPanel();
		FlowLayout fl_pnEmpID = (FlowLayout) pnEmpID.getLayout();
		fl_pnEmpID.setAlignment(FlowLayout.LEFT);
		pnCenter.add(pnEmpID);
		
		JLabel lblEmpID = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn:");
		pnEmpID.add(lblEmpID);
		
		txtEmpID = new JTextField();
		pnEmpID.add(txtEmpID);
		txtEmpID.setColumns(60);
		
		JPanel pnName = new JPanel();
		FlowLayout fl_pnName = (FlowLayout) pnName.getLayout();
		fl_pnName.setAlignment(FlowLayout.LEFT);
		pnCenter.add(pnName);
		
		JLabel lblFirstName = new JLabel("H\u1ECD:");
		lblFirstName.setPreferredSize(lblEmpID.getPreferredSize());
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		pnName.add(lblFirstName);
		
		txtFirstName = new JTextField();
		pnName.add(txtFirstName);
		txtFirstName.setColumns(30);
		
		JLabel lblLastName = new JLabel("Tên:      ");
		pnName.add(lblLastName);
		
		txtLastName = new JTextField();
		pnName.add(txtLastName);
		txtLastName.setColumns(25);
		
		JPanel pnAge_Sex = new JPanel();
		FlowLayout fl_pnAge_Sex = (FlowLayout) pnAge_Sex.getLayout();
		fl_pnAge_Sex.setAlignment(FlowLayout.LEFT);
		pnCenter.add(pnAge_Sex);
		
		JLabel lblAge = new JLabel("Tu\u1ED5i");
		lblAge.setPreferredSize(lblEmpID.getPreferredSize());
		pnAge_Sex.add(lblAge);
		
		txtAge = new JTextField();
		pnAge_Sex.add(txtAge);
		txtAge.setColumns(45);
		
		JLabel lblSex = new JLabel("      Phái:   ");
		pnAge_Sex.add(lblSex);
		
		JRadioButton radMale = new JRadioButton("Nam");
		pnAge_Sex.add(radMale);
		
		JRadioButton radFemale = new JRadioButton("N\u1EEF");
		pnAge_Sex.add(radFemale);
		
		JPanel pnSalary = new JPanel();
		FlowLayout fl_pnSalary = (FlowLayout) pnSalary.getLayout();
		fl_pnSalary.setAlignment(FlowLayout.LEFT);
		pnCenter.add(pnSalary);
		
		JLabel lblNewLabel_4 = new JLabel("Ti\u1EC1n l\u01B0\u01A1ng:");
		lblNewLabel_4.setPreferredSize(lblEmpID.getPreferredSize());
		pnSalary.add(lblNewLabel_4);
		
		txtSalary = new JTextField();
		pnSalary.add(txtSalary);
		txtSalary.setColumns(60);
		
		JPanel pnTable = new JPanel();
		pnCenter.add(pnTable);
		pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
		
		
		
		tblModel = new DefaultTableModel(col, 0);
		
		
		tblEmployee = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 NV", "H\u1ECD", "T\u00EAn", "Ph\u00E1i", "Tu\u1ED5i", "Ti\u1EC1n l\u01B0\u01A1ng"
			}
		));
		JScrollPane scrTable = new JScrollPane(tblEmployee);
		pnTable.add(scrTable);
	}

}
