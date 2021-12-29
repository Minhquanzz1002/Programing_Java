package textfields;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    TextField textField;
    JButton button;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        button = new JButton("Submit");
        button.addActionListener(this);
        textField = new TextField();
        textField.setPreferredSize(new Dimension(250,50));
        textField.setFont(new Font("Consolas",Font.PLAIN,35));  // set font cho textfield
        textField.setForeground(Color.cyan);    // set mau cho chu
        textField.setBackground(Color.black);
        textField.setText("Hay nhap ten");
        this.add(textField);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println(textField.getText());
        }
    }
}
