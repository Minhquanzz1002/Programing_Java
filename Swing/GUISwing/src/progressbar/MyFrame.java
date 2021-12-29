package progressbar;

import javax.swing.*;
import java.awt.*;

public class MyFrame {
    JFrame frame;
    JProgressBar bar;
    int counter = 500;
    MyFrame(){
        frame = new JFrame();
        bar = new JProgressBar(0, 500);
        bar.setValue(0);
        bar.setBounds(0,0,420,50);
        bar.setStringPainted(true); // hien thi muc phan tram
        bar.setFont(new Font("MV Boli", Font.PLAIN, 25));
        bar.setForeground(Color.red);
        bar.setBackground(Color.white);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.add(bar);
        frame.setVisible(true);

        fill();
    }

    public void fill(){
        while(counter >= 0){
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter -= 1;
        }
        bar.setString("Done...");
    }
}
