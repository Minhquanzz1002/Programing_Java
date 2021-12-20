package MyJFrame;

import javax.swing.*;
import java.awt.*;

public class MyClass extends JFrame {
    MyClass(){
        ImageIcon image = new ImageIcon("icon_lich.png");
        this.setTitle("Demo JFrame");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Bam X de tat
        this.setResizable(true);  // cho phep chinh sua size
        this.setIconImage(image.getImage());   //set icon app
        this.getContentPane().setBackground(new Color(0, 0, 250));
        this.setVisible(true); // hien thi
    }
}
