package checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JButton button;
    JCheckBox checkBox;
    ImageIcon icon;
    ImageIcon xIcon;
    MyFrame(){
        button = new JButton();
        button.setText("Submit");
        button.addActionListener(this);

        icon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\check_mark1.png");
        xIcon = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\x_check_mark1.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        checkBox = new JCheckBox();
        checkBox.setText("Dong y khong?");
        checkBox.setFont(new Font("Consolas",Font.BOLD, 35));
        checkBox.setForeground(Color.blue);
        checkBox.setIcon(xIcon);
        checkBox.setSelectedIcon(icon);
        this.add(checkBox);
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println(checkBox.isSelected());  // lay gia tri torng checkbox
        }
    }
}
