package keylistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements KeyListener {
    JLabel label;
    ImageIcon icon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\MayBay.png");
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.addKeyListener(this);
        this.setLayout(null);
        label = new JLabel();
        label.setBounds(0,0,200,200);
//        label.setBackground(Color.red);
//        label.setOpaque(true);
        label.setIcon(icon);
        this.getContentPane().setBackground(Color.white);
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        switch (e.getKeyChar()){
//            case 'a':
//                label.setLocation(label.getX() - 10, label.getY());
//                break;
//            case 'd':
//                label.setLocation(label.getX() + 10 , label.getY());
//                break;
//            case 's':
//                label.setLocation(label.getX(), label.getY() + 10);
//                break;
//            case 'w':
//                label.setLocation(label.getX(), label.getY() - 10);
//                break;
//        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()){
            case 'a':
                label.setLocation(label.getX() - 10, label.getY());
                break;
            case 'd':
                label.setLocation(label.getX() + 10 , label.getY());
                break;
            case 's':
                label.setLocation(label.getX(), label.getY() + 10);
                break;
            case 'w':
                label.setLocation(label.getX(), label.getY() - 10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Ban da nhan: " + e.getKeyChar());
//        System.out.println("Ban da nhan: " + e.getKeyCode());
    }
}
