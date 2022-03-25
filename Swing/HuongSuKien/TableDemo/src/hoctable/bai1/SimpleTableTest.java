package hoctable.bai1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTableTest extends JFrame{
	protected JTable table;
	public SimpleTableTest() {
		Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        TableValues tv = new TableValues();
        table = new JTable(tv);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);		// cac cot ben phai se thay doi kich thuoc
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);	// cot cuoi cung bi thay doi
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane jsp = new JScrollPane(table);	
        
        pane.add(jsp, BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		SimpleTableTest stt = new SimpleTableTest();
        stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stt.setSize(400, 200);
        stt.setVisible(true);
	}
}
