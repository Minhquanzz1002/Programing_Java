package table;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    JFrame frame;
    JTable table;
    MyFrame(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());



        String[] columnNames = {"Name","Color-Eye","Age"};
        String[][] data = {{"Link","Blue","19"}, {"Lina","Black","23"},{"Anna","While","21"}};
        table = new JTable(data, columnNames);
        String[] data1 = {"Lisa","While","20"};
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        table.setBounds(0,25,300,200);
        table.setFillsViewportHeight(false);
        table.setAutoCreateRowSorter(true);       // nhap vao dau cot de sap xep

        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new MyFrame();
    }
    
}
