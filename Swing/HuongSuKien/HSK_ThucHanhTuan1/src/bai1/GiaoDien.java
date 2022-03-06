package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class GiaoDien extends JFrame implements ActionListener{
	private JLabel titleLbl;
	private JLabel aLbl;
	private JLabel bLbl;
	private JLabel cLbl;
	private JLabel resultLbl;
	private JTextField aTextField;
	private JTextField bTextField;
	private JTextField cTextField;
	private JTextField resultTextField;
	private JButton solveBtn;
	private JButton clearBtn;
	private JButton exitBtn;
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel aPanel = new JPanel();
	private JPanel bPanel = new JPanel();
	private JPanel cPanel = new JPanel();
	private JPanel resultPanel = new JPanel();
	private double a, b, c;
	GiaoDien(){
		setSize(400,320);	// set size cho cua so
		setTitle("^-^");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 	// hien thi o giua man hinh
		setResizable(false);	// cho hay khong co resize
		doShow();
		setVisible(true);
	}
	public void doShow() {
		/* Xu ly phan NORTH */
		titleLbl = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		titleLbl.setOpaque(true); 	// cho phep thay doi bg
		titleLbl.setBackground(Color.CYAN);
		titleLbl.setFont(new Font("Arial", Font.BOLD, 20));		// BOLD: in dam
		titleLbl.setHorizontalAlignment(JLabel.CENTER);		// canh chu o giua
		titleLbl.setSize(600, 40);
		
		northPanel.setBackground(Color.CYAN);
		northPanel.add(titleLbl);
		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		
		/* Xu ly phan CENTER */
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		aLbl = new JLabel("Nhập a:");
		aLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		aLbl.setLabelFor(aTextField);
		aPanel.add(aLbl);
		
		aTextField = new JTextField(20);
		aTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		aPanel.add(aTextField);
		
		bLbl = new JLabel("Nhập b:");
		bLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bLbl.setLabelFor(cTextField);
		bPanel.add(bLbl);
		
		bTextField = new JTextField(20);
		bTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		bPanel.add(bTextField);
		
		cLbl = new JLabel("Nhập c:");
		cLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cLbl.setLabelFor(cTextField);
		cPanel.add(cLbl);
		
		cTextField = new JTextField(20);
		cTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cPanel.add(cTextField);
		
		resultLbl = new JLabel("Kết quả:");
		resultLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		resultLbl.setLabelFor(resultLbl);
		resultPanel.add(resultLbl);
		
		resultTextField = new JTextField(20);
		resultTextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		resultTextField.setFocusable(false);
		resultTextField.setBackground(new Color(237, 237, 237));
		resultPanel.add(resultTextField);
		
		centerPanel.add(aPanel);
		centerPanel.add(bPanel);
		centerPanel.add(cPanel);
		centerPanel.add(resultPanel);
		
		/* Xu ly phan SOUTH */
		
		solveBtn = new JButton("Giải");
		solveBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		solveBtn.setFocusable(false);
		solveBtn.addActionListener(this);
		southPanel.add(solveBtn);
		
		clearBtn = new JButton("Xóa rỗng");
		clearBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		clearBtn.setFocusable(false);
		clearBtn.addActionListener(this);
		southPanel.add(clearBtn);
		
		exitBtn = new JButton("Thoát");
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		exitBtn.setFocusable(false);
		exitBtn.addActionListener(this);
		southPanel.add(exitBtn);
		
		southPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.red) , "Chọn tác vụ"));	//border cho panel
		getContentPane().add(southPanel, BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		/* Xu ly su kien khi click "Giai" */
		if (e.getSource() == solveBtn) {
			a = Double.valueOf(aTextField.getText());
			b = Double.valueOf(bTextField.getText());
			c = Double.valueOf(cTextField.getText());
			resultTextField.setText(new PhuongTrinhBacHai(a, b, c).giaiPhuongTrinhBacHai());
		}
		/* Xu ly su kien khi click "Xoa rong" */
		if (e.getSource() == clearBtn) {
			aTextField.setText("");
			bTextField.setText("");
			cTextField.setText("");
			resultTextField.setText("");
		}
		/* Xu ly su kien khi click "Thoat" */
		if (e.getSource() == exitBtn) {
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new GiaoDien();
	}
}
