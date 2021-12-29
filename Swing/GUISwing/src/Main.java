import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ImageIcon image = new ImageIcon("icon_lich.png");
        frame.setTitle("Demo JFrame");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Bam X de tat
        frame.setResizable(true);  // cho phep chinh sua size
        frame.setIconImage(image.getImage());   //set icon app
        frame.getContentPane().setBackground(new Color(0, 0, 250));
        frame.setVisible(true); // hien thi
    }
}
