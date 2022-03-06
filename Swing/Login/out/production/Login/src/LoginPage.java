import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame{
    JPanel panel1;
    JLabel loginLabel = new JLabel();
    JSeparator separator1 = new JSeparator();
    JSeparator separator2 = new JSeparator();
    JSeparator separator3 = new JSeparator();
    JLabel usernameLabel;
    JLabel passwordLabel;
    JLabel emailLabel;

    LoginPage(){
        initForm();
    }
    public void initForm(){
        panel1 = new JPanel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        emailLabel = new JLabel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.cyan);
        this.setMaximumSize(new Dimension(900, 600));
        this.setPreferredSize(new Dimension(900, 650));
        this.getContentPane().setLayout(null);

        panel1.setBounds(0, 0, 500, 500);

        usernameLabel.setText("Username");
        usernameLabel.setForeground(Color.white);
        usernameLabel.setOpaque(true);
        usernameLabel.setBounds(0,50,30,30);

        passwordLabel.setText("Password");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setOpaque(true);
        passwordLabel.setBounds(0,100,30,30);

        emailLabel.setText("Email");
        emailLabel.setForeground(Color.white);
        emailLabel.setOpaque(true);
        emailLabel.setBounds(0,150,30,30);

        this.getContentPane().add(usernameLabel);
        this.getContentPane().add(passwordLabel);
        this.getContentPane().add(emailLabel);





        this.setVisible(true);
    }
}
