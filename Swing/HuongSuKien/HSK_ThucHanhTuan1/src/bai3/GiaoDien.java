package bai3;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class GiaoDien extends JFrame{
	private JLabel titleLbl;
	private JLabel lblA;
	private JLabel lblB;
	
	private JLabel resultLbl;
	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField resultTextField;
	private JButton solveBtn;
	private JButton delBtn;
	private JButton exitBtn;
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel operationGrPanel = new JPanel();
	private JPanel groupPanel1 = new JPanel();
	private JPanel groupPanel2 = new JPanel();
	private JPanel groupPanel3 = new JPanel();
	private JPanel groupPanel4 = new JPanel();
	private JPanel groupPanel5 = new JPanel();
	private JPanel groupPanel6 = new JPanel();
	private JRadioButton rdbtnPlus;
	private JRadioButton rdbtnMinus;
	private JRadioButton rdbtnProduct;
	private JRadioButton rdbtnDivide;
	private ButtonGroup btnGroup;
	private JLabel llblBue;
	private JLabel lblRed;
	private JLabel lblYellow;
	GiaoDien(){
		doShow();
		addControl();
		setVisible(true);
	}
	public void doShow() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addControl() {
		/* Xu ly phan NORTH */
		titleLbl = new JLabel("Cộng Trừa Nhân Chia");
		titleLbl.setForeground(new Color(0, 0, 255));
		titleLbl.setFont(new Font("Arial", Font.BOLD, 25));
		
		northPanel.add(titleLbl);
		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		/* Xu ly phan CENTER */
		groupPanel1.setLayout(new GridLayout(3, 1, 0, 10));
		groupPanel1.setBackground(new Color(192, 192, 192));
	
		solveBtn = new JButton("Giải");
		solveBtn.setFocusable(false);
		groupPanel1.add(solveBtn);
		
		delBtn = new JButton("Xóa");
		delBtn.setFocusable(false);
		groupPanel1.add(delBtn);

		exitBtn = new JButton("Thoát");
		exitBtn.setFocusable(false);
		groupPanel1.add(exitBtn);
		
		westPanel.setBackground(new Color(192, 192, 192));
		westPanel.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		westPanel.add(groupPanel1, BorderLayout.NORTH);
		
		getContentPane().add(westPanel, BorderLayout.WEST);
		
		lblA = new JLabel("Nhập a:");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblA.setLabelFor(aTextField);
		
		lblB = new JLabel("Nhập b:");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblB.setLabelFor(bTextField);
		
		resultLbl = new JLabel("Kết quả: ");
		resultLbl.setLabelFor(resultTextField);
		
		aTextField = new JTextField(20);
		aTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		bTextField = new JTextField(20);
		bTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		groupPanel3.add(lblA);
		groupPanel3.add(aTextField);
		
		groupPanel4.add(lblB);
		groupPanel4.add(bTextField);
		
		groupPanel5.add(groupPanel3);
		groupPanel5.add(groupPanel4);
		groupPanel5.setLayout(new GridLayout(2, 1, 0, 0));
		
		centerPanel.add(groupPanel5, BorderLayout.NORTH);
		
		resultTextField = new JTextField(19);
		resultTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		resultTextField.setFocusable(false);
		resultTextField.setBackground(new Color(237, 237, 237));
		
		groupPanel6.add(resultLbl);
		groupPanel6.add(resultTextField);
		
		
		
		rdbtnPlus = new JRadioButton("Cộng");
		rdbtnPlus.setFocusable(false);
		rdbtnPlus.setSelected(true);
		
		rdbtnMinus = new JRadioButton("Trừ");
		rdbtnMinus.setFocusable(false);
		
		rdbtnProduct = new JRadioButton("Nhân");
		rdbtnProduct.setFocusable(false);
		
		rdbtnDivide = new JRadioButton("Chia");
		rdbtnDivide.setFocusable(false);
		
		operationGrPanel.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		operationGrPanel.setLayout(new GridLayout(2, 2, 100, 30));
		operationGrPanel.add(rdbtnPlus);
		operationGrPanel.add(rdbtnMinus);
		operationGrPanel.add(rdbtnProduct);
		operationGrPanel.add(rdbtnDivide);
		
		centerPanel.add(operationGrPanel, BorderLayout.CENTER);
		centerPanel.add(groupPanel6, BorderLayout.SOUTH);
		
		btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnPlus);
		btnGroup.add(rdbtnMinus);
		btnGroup.add(rdbtnProduct);
		btnGroup.add(rdbtnDivide);
		
		centerPanel.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		/* Xu ly phan SOUTH*/
		groupPanel2.setBackground(Color.PINK);
		
		southPanel.setBackground(Color.PINK);
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
		southPanel.add(groupPanel2, BorderLayout.CENTER);
		
		llblBue = new JLabel("     ");
		llblBue.setFont(new Font("Tahoma", Font.PLAIN, 17));
		llblBue.setBackground(Color.BLUE);
		llblBue.setOpaque(true);
		groupPanel2.add(llblBue);
		
		lblRed = new JLabel("     ");
		lblRed.setOpaque(true);
		lblRed.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRed.setBackground(Color.RED);
		groupPanel2.add(lblRed);
		
		lblYellow = new JLabel("     ");
		lblYellow.setOpaque(true);
		lblYellow.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYellow.setBackground(Color.YELLOW);	
		groupPanel2.add(lblYellow);
		
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		new GiaoDien();
	}
}
