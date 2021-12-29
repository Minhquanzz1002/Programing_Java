package panels;


import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        ImageIcon icon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\icon.png");
        JLabel label = new JLabel();
        label.setText("Hello");
        label.setIcon(icon);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel GreenPanel = new JPanel();
        GreenPanel.setBackground(Color.green);   // chon mau cho panel
        GreenPanel.setBounds(0,0,400,400);

        JPanel RedPanel = new JPanel();
        RedPanel.setBackground(Color.red);   // chon mau cho panel
        RedPanel.setBounds(0,400,400,400);
        RedPanel.setLayout(new BorderLayout());

        JPanel CyanPanel = new JPanel();
        CyanPanel.setBackground(Color.cyan);   // chon mau cho panel
        CyanPanel.setBounds(400,0,400,400);

        JPanel MagentaPanel = new JPanel();
        MagentaPanel.setBackground(Color.magenta);   // chon mau cho panel
        MagentaPanel.setBounds(400,400,400,400);

        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(GreenPanel);
        frame.add(RedPanel);
        frame.add(CyanPanel);
        frame.add(MagentaPanel);
        RedPanel.add(label);
        frame.setVisible(true);
    }
}
