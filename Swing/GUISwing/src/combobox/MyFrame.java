package combobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JComboBox comboBox;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        String[] animals = {"dog", "cat", "bird"};
        comboBox = new JComboBox(animals);
        comboBox.addItem("Fox");    // them item cho combo box
        comboBox.insertItemAt("Lion",0);    // them item vao vi tri so 0
        comboBox.setSelectedIndex(0);   // set vi tri mac dinh cho combo box

//        comboBox.removeItem("Lion");    // xoa item
//        comboBox.removeItemAt(0);   // xoa item tai vi tri
//        comboBox.removeAllItems();  // xoa het item
        comboBox.addActionListener(this);
//        System.out.println(comboBox.getItemCount());    // dem so item cua combo box
        this.add(comboBox);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comboBox){
            System.out.println(comboBox.getSelectedItem());
//            System.out.println(comboBox.getSelectedIndex()); // vi tri cua item. vi tri dau la 0
        }
    }
}
