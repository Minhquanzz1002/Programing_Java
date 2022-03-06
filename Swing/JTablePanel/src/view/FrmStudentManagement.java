package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;

public class FrmStudentManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textName;
	private JTextField textAddress;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStudentManagement frame = new FrmStudentManagement();
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
	public FrmStudentManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(45, 54, 40, 14);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("T\u00EAn SV");
		lblName.setBounds(45, 101, 40, 14);
		contentPane.add(lblName);
		
		JLabel lblCourse = new JLabel("Kh\u00F3a");
		lblCourse.setBounds(423, 101, 46, 14);
		contentPane.add(lblCourse);
		
		JLabel lblGender = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGender.setBounds(423, 54, 70, 14);
		contentPane.add(lblGender);
		
		JLabel lblAddress = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblAddress.setBounds(45, 154, 40, 14);
		contentPane.add(lblAddress);
		
		textId = new JTextField();
		lblId.setLabelFor(textId);
		textId.setBounds(118, 51, 200, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textName = new JTextField();
		lblName.setLabelFor(textName);
		textName.setBounds(118, 101, 200, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JComboBox comboBoxCourse = new JComboBox();
		lblCourse.setLabelFor(comboBoxCourse);
		comboBoxCourse.setModel(new DefaultComboBoxModel(new String[] {"K14", "K15", "K16", "K17"}));
		comboBoxCourse.setBounds(499, 97, 56, 22);
		contentPane.add(comboBoxCourse);
		
		JRadioButton rdbtnMale = new JRadioButton("Nam\r\n");
		lblGender.setLabelFor(rdbtnMale);
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(499, 50, 56, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("N\u1EEF");
		rdbtnFemale.setBounds(568, 50, 56, 23);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup grGender = new ButtonGroup();
		grGender.add(rdbtnMale);
		grGender.add(rdbtnFemale);
		
		textAddress = new JTextField();
		lblAddress.setLabelFor(textAddress);
		textAddress.setBounds(118, 151, 200, 20);
		contentPane.add(textAddress);
		textAddress.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 245, 650, 150);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblTitle = new JLabel("<html>\r\n<B>QU\u1EA2N L\u00DD SINH VI\u00CAN</B>");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(271, 11, 206, 30);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitle);
		
		JButton btnAdd = new JButton("Th\u00EAm");
		btnAdd.setBounds(120, 195, 89, 23);
		btnAdd.setFocusable(false);
		contentPane.add(btnAdd);
		
		JButton btnEdit = new JButton("S\u1EEDa");
		btnEdit.setBounds(329, 195, 89, 23);
		btnEdit.setFocusable(false);
		contentPane.add(btnEdit);
		
		JButton btnDel = new JButton("X\u00F3a");
		btnDel.setBounds(538, 195, 89, 23);
		btnDel.setFocusable(false);
		contentPane.add(btnDel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(373, 54, 2, 124);
		contentPane.add(separator);
	}
}
