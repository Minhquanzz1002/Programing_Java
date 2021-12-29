package mouselinsener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyFrame extends JFrame implements MouseListener {
    JLabel label;
    ImageIcon smile1 = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Smile1.png");
    ImageIcon smile2 = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Smile2.png");
    ImageIcon smile3 = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Smile3.png");
    ImageIcon smile4 = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Smile4.png");
    ImageIcon smile5 = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Smile5.png");
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        label = new JLabel();
        label.setBounds(0,0,512,512);
        label.setIcon(smile1);
        label.addMouseListener(this);
        this.add(label);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {    // click ngoai
        label.setIcon(smile1);
    }

    @Override
    public void mousePressed(MouseEvent e) {    // chi click
        label.setIcon(smile2);
    }

    @Override
    public void mouseReleased(MouseEvent e) {   // click va keo
        label.setIcon(smile3);
    }

    @Override
    public void mouseEntered(MouseEvent e) { // cham
        label.setIcon(smile4);
    }

    @Override
    public void mouseExited(MouseEvent e) {     // hk lam j het
        label.setIcon(smile5);
    }
}
