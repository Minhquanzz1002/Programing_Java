package radiobutton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JRadioButton pizzaButton;
    JRadioButton hotdogButton;
    JRadioButton hamburgerButton;

    ImageIcon pizzaIcon;
    ImageIcon hotdogIcon;
    ImageIcon hamburgerIcon;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pizzaIcon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Pizza1.png");
        hotdogIcon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Hotdog1.png");
        hamburgerIcon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Hamburger1.png");

        pizzaButton = new JRadioButton();
        pizzaButton.setText("Pizza");
        pizzaButton.setIcon(pizzaIcon);
        pizzaButton.addActionListener(this);

        hotdogButton = new JRadioButton();
        hotdogButton.setText("Hotdog");
        hotdogButton.addActionListener(this);
        hotdogButton.setIcon(hotdogIcon);

        hamburgerButton = new JRadioButton();
        hamburgerButton.setText("Hamburger");
        hamburgerButton.addActionListener(this);
        hamburgerButton.setIcon(hamburgerIcon);

        ButtonGroup buttonGroup = new ButtonGroup();    // add cac nut vao 1 gr. de chi co the nhan 1 nut 1 thoi diem
        buttonGroup.add(pizzaButton);
        buttonGroup.add(hotdogButton);
        buttonGroup.add(hamburgerButton);

        this.add(pizzaButton);
        this.add(hotdogButton);
        this.add(hamburgerButton);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pizzaButton){
            System.out.println("Pizza");
        }
        if (e.getSource() == hotdogButton){
            System.out.println("Hotdog");
        }
        if (e.getSource() == hamburgerButton){
            System.out.println("Hamburger");
        }
    }
}
