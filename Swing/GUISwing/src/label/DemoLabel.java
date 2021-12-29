package label;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class DemoLabel {
    public static void main(String[] args) {
        Border border = BorderFactory.createLineBorder(Color.green, 3);
        ImageIcon icon = new ImageIcon("F:\\Programing_Java\\Swing\\GUI\\src\\icon_x.png");
        ImageIcon logo = new ImageIcon("F:\\Programing_Java\\Swing\\GUI\\src\\icon_main.png");
        JLabel label = new JLabel();
        label.setText("Hello bro");
        label.setIcon(icon);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text o dau so vs anh LEFT, RIGHT, CENTER
        label.setVerticalTextPosition(JLabel.TOP);  // set text o dau so vs anh TOP, CENTER, BOTTOM
        label.setForeground(new Color(0, 0, 150));  // set mau cho chu
        label.setFont(new Font("MV Boli", Font.PLAIN, 20)); // set font, size font
        label.setIconTextGap(1);   // khoang cach icon va text
        label.setBackground(Color.black);   // mau background
        label.setOpaque(true);  // hien thi mau background
        label.setBorder(border);    // vien bao quanh app
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);    // set cho text va icon
//        label.setBounds(0,0,700,700);

        JFrame frame = new JFrame();
        frame.setTitle("Demo Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1800, 800);
//        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(label);
        frame.setIconImage(logo.getImage());
        frame.pack();
    }
}
