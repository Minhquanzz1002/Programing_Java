package buttons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Button extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    Button(){
        ImageIcon icon = new ImageIcon("D:\\quann\\Pictures\\icon_tim2.png");
        ImageIcon icon2 = new ImageIcon("D:\\quann\\Pictures\\thuctinh.gif");
        button = new JButton();
        label = new JLabel();
        button.addActionListener(this);
//        button.addActionListener(e -> System.out.println("poo"));   // them su kien cho button
        button.setText("Thức tỉnh");
        button.setIcon(icon);
        button.setFocusable(false);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(5);   // khoang cach icon va text
        button.setForeground(Color.cyan); // set mau chu
        button.setBackground(Color.white);
        button.setEnabled(true);    // cho nhan hay khong
        button.setBorder(BorderFactory.createEtchedBorder());

        label.setIcon(icon2);
        label.setVisible(false);

        label.setBounds(350, 300, 371, 209);
        button.setBounds(390, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 900);
        this.setLayout(null);
        this.setVisible(true);
        this.add(button);
        this.add(label);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println("Da nhan");
            label.setVisible(true);
        }
    }
}
