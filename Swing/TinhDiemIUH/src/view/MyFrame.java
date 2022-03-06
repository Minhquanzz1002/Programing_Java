package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame implements ActionListener {
    JFrame frame;
    public static Image image = new ImageIcon("src\\image\\Logo.png").getImage();
    JMenuBar menuBar;
    JMenu fileMenu, helpMenu, viewMenu;
    JMenuItem aboutItem;
    JTable table;
    DefaultTableModel model;
    static Font font = new Font("MV Boli",Font.PLAIN, 10);
    JPanel panel1;
    JTextField[] mark = new JTextField[12];
    JTextField mark
    public MyFrame(){
        initFrame();
        initMenu();
        initTable();
        frame.setVisible(true);
    }

    public void initFrame(){
        frame = new JFrame("Tinh Diem");
        frame.setIconImage(image);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // full screen
        frame.setUndecorated(false);
        frame.setLayout(null);
    }

    public void initMenu(){
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        viewMenu = new JMenu("View");

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);

        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        helpMenu.add(aboutItem);
    }

    public void initTable(){

//        String[] columnNames = {"Ten mon hoc", "LT1","LT2","LT3","LT4","LT5","GK","TH1","TH2","TH3","TH4","TH5","CK","Diem tong ket","Thang diem 4","Diem chu","Xep loai"};
//        table = new JTable();
//        table.setBounds(50, 50, 500, 200);
//        model = (DefaultTableModel) table.getModel();
//
//        model.addColumn(null, columnNames);
//        JScrollPane scrollPane = new JScrollPane(table);
//        frame.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aboutItem){
            JOptionPane.showMessageDialog(null, "Tinh diem IUH\nVesion: 1.0\nBy: Nguyen Minh Quan", "Tinh diem IUH", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
