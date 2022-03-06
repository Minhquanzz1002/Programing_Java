package tableadddel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class TableAddDel {
	private static JTextField textName;
	private static JTextField textGender;
	private static JTextField textAddress;
	private static JTextField textPhone;
	private static ImageIcon logo = new ImageIcon("../Logo.png");
	public static void main(String[] args) {
		JTable table = new JTable();
		Object[] columns = {"Name", "Gender", "Address","Phone"};
		DefaultTableModel model = new DefaultTableModel();
		Object[] row = new Object[4];
		JFrame frame = new JFrame("Window");
		frame.getContentPane().setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 757, 610);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(logo.getImage());
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setSelectionBackground(Color.RED);
		table.setGridColor(Color.RED);
		table.setSelectionForeground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBackground(Color.WHITE);
		pane.setBounds(10, 10, 721, 262);
		frame.getContentPane().add(pane);
		
		textName = new JTextField();
		textName.setBounds(187, 335, 180, 20);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textGender = new JTextField();
		textGender.setBounds(187, 398, 180, 20);
		frame.getContentPane().add(textGender);
		textGender.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(468, 335, 180, 20);
		frame.getContentPane().add(textAddress);
		textAddress.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(468, 398, 180, 20);
		frame.getContentPane().add(textPhone);
		textPhone.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAddress.setBounds(401, 338, 46, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(112, 338, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(112, 401, 46, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPhone.setBounds(401, 401, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		JPanel panel = new JPanel();
		panel.setBounds(160, 460, 420, 50);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnAdd = new JButton("Add");
		panel.add(btnAdd);
		btnAdd.setFocusable(false);
		
		JButton btnDel = new JButton("Delete");
		panel.add(btnDel);
		btnDel.setFocusable(false);
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
				}else {
					JOptionPane.showMessageDialog(frame, "Delete Error");
				}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row[0] = textName.getText();
				row[1] = textGender.getText();
				row[2] = textAddress.getText();
				row[3] = textPhone.getText();
				model.addRow(row);
			}
		});
		
		
		
		frame.revalidate();
		frame.setVisible(true);
	}
}
