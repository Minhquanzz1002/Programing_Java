package jlayeredpane;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.add(layeredPane);

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setBounds(50,50,200,200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.black);
        label2.setBounds(100,100,200,200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.white);
        label3.setBounds(150,150,200,200);

        // default
        // palette
        // modal
        // pop up
        // drag
//        layeredPane.add(label3, JLayeredPane.MODAL_LAYER);
//        layeredPane.add(label2, JLayeredPane.DRAG_LAYER);
//        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);

        // dung value de xac dinh cai nao dung trc cai nao dung sau
        layeredPane.add(label3, Integer.valueOf(1));
        layeredPane.add(label2, Integer.valueOf(3));
        layeredPane.add(label1, Integer.valueOf(2));
    }
}
