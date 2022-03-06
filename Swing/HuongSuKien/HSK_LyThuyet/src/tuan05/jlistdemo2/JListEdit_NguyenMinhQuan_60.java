package tuan05.jlistdemo2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 * 
 * @author Nguyễn Minh Quân
 * MSSV: 20098151
 * STT: 60
 */
public class JListEdit_NguyenMinhQuan_60 extends JFrame implements ActionListener {
	JButton btnAddItem, btnRemoveItem, btnEditItem;
	JTextField txtInputName;
	JList lstName;
	DefaultListModel lstmodelName;
	public JListEdit_NguyenMinhQuan_60(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(600, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		/*Các nút bấm và input*/
		JLabel lblInputName = new JLabel("Input Name");
		lblInputName.setLabelFor(txtInputName);
		
		txtInputName = new JTextField(20);
		txtInputName.setText("Nguyen Minh Quan");		// dữ liệu test
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setFocusable(false);
		
		btnRemoveItem = new JButton("Remove Item");
		btnRemoveItem.setFocusable(false);
		
		btnEditItem = new JButton("Edit Item");
		btnEditItem.setFocusable(false);
		
		JPanel pnEast = new JPanel();
		pnEast.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		pnEast.add(lblInputName);
		pnEast.add(txtInputName);
		pnEast.add(btnAddItem);
		pnEast.add(btnRemoveItem);
		pnEast.add(btnEditItem);
		pnEast.setPreferredSize(new Dimension(320, 0));
		
		/*Phần list*/
		lstmodelName = new DefaultListModel();
		
		lstName = new JList(lstmodelName);
		
		JScrollPane paneListName = new JScrollPane(lstName);
		
		JPanel pnRoot = new JPanel();
		pnRoot.setLayout(new BorderLayout());
		pnRoot.add(paneListName, BorderLayout.CENTER);
		pnRoot.add(pnEast, BorderLayout.EAST);
		
		add(pnRoot);
		
		/*Các sự kiện*/
		btnAddItem.addActionListener(this);
		btnRemoveItem.addActionListener(this);
		btnEditItem.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object action = e.getSource();
		if(action.equals(btnAddItem) || action.equals(btnEditItem)) {
			String name = txtInputName.getText().trim();
			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Hãy nhập tên!");
			}
			else if (!name.matches("[A-Za-z\s]+")) {
				JOptionPane.showMessageDialog(this, "Tên chỉ được chứa chữ hoặc khoảng trắng!");
			}
			else {
				if (action.equals(btnAddItem)) {
					lstmodelName.addElement(name);
				}else {
					lstmodelName.setElementAt(name, lstName.getSelectedIndex());
				}
				txtInputName.setText("");
			}
		}else {
			lstmodelName.removeElement(lstName.getSelectedValue());
		}
	}

	public static void main(String[] args) {
		new JListEdit_NguyenMinhQuan_60("List Edit Demo").doShow();
	}
}
