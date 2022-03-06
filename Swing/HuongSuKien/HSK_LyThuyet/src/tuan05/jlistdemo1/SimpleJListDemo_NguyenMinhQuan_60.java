package tuan05.jlistdemo1;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Nguyễn Minh Quân MSSV: 20098151 STT: 60
 */
public class SimpleJListDemo_NguyenMinhQuan_60 extends JFrame implements ListSelectionListener {
	JTextField txtLastSelection;
	JList lstEntry;

	public SimpleJListDemo_NguyenMinhQuan_60(String tieuDeCuaSo) {
		setTitle(tieuDeCuaSo);
	}

	public void doShow() {
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addControl();
		setVisible(true);
	}

	public void addControl() {
		/* Phần SOUTH */
		JLabel lblLastSelection = new JLabel("Last selection");
		lblLastSelection.setLabelFor(txtLastSelection);

		txtLastSelection = new JTextField(20);
		txtLastSelection.setEditable(false);

		JPanel pnSouth = new JPanel();
		pnSouth.setBorder(BorderFactory.createTitledBorder("List Selection"));
		pnSouth.add(lblLastSelection);
		pnSouth.add(txtLastSelection);

		/* Phần CENTER */
		String[] entries = { "Entry 1", "Entry 2", "Entry 3", "Entry 4", "Entry 5", "Entry 6" };

		lstEntry = new JList(entries);
		lstEntry.setVisibleRowCount(4);

		JScrollPane paneEntry = new JScrollPane(lstEntry);

		JPanel pnCenter = new JPanel();
		pnCenter.setBorder(BorderFactory.createTitledBorder("Simple JList"));
		pnCenter.add(paneEntry);

		JPanel pnRoot = new JPanel();
		pnRoot.setLayout(new BorderLayout());
		pnRoot.add(pnSouth, BorderLayout.SOUTH);
		pnRoot.add(pnCenter, BorderLayout.CENTER);

		/* Các sự kiện */
		lstEntry.addListSelectionListener(this);

		add(pnRoot);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		txtLastSelection.setText(lstEntry.getSelectedValue() + "");
	}

	public static void main(String[] args) {
		new SimpleJListDemo_NguyenMinhQuan_60("Creating a Simple JList").doShow();
	}
}
