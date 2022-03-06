import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Demo extends JFrame implements ActionListener {
    JButton button;
    public Demo(){
        createAndShow();
    }

    public void createAndShow(){
        button = new JButton("Ok");
//        frame = new JFrame("Demo");
        setSize(400, 500);
        this.setLocationRelativeTo(null);  // Hien thi giua man hinh
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(button);  // add nhu ArrayList

        button.setActionCommand("Ok");
        button.addActionListener(this);
        button.setMnemonic(KeyEvent.VK_0);  // set phim tat
        button.setToolTipText("Click Ok");
        this.setLayout(new FlowLayout());
        setVisible(true);     // show
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if ("Ok".equals(e.getActionCommand())){
            JOptionPane.showMessageDialog(rootPane, "Ban vua nhan nut Ok");
        }
    }
    public static void main(String[] args) {
        Demo demo = new Demo();

    }
}
