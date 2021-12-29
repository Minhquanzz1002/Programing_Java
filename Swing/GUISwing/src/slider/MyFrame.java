package slider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class MyFrame implements ChangeListener {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    MyFrame(){
        frame = new JFrame("JSlider demo");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0, 100, 50);
        slider.setPreferredSize(new Dimension(400,200));
        slider.setPaintTicks(true);     // phan biet phan chua chon vs phan da chon
        slider.setMinorTickSpacing(10);     // set gach danh dau giua cau khoang cach. tuong tu 1cm, 2cm tren thuoc ke


        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);    // hien thi chu giua cac khoang cach
        slider.setFont(new Font("MV Boli", Font.PLAIN, 10));    // set font chu cho khoang cach
        slider.setOrientation(SwingConstants.VERTICAL);     // lat ngang
        slider.addChangeListener(this);
        label.setText("°C = " + slider.getValue());
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));


        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("°C = " + slider.getValue());
    }
}
