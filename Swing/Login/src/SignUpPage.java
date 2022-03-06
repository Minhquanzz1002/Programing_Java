import javax.swing.*;
import java.awt.*;

public class SignUpPage {
    public static ImageIcon iconSignUp = new ImageIcon("D:\\quann\\Pictures\\Sign Up Button.png");
    JFrame frame;
    JButton signUpButton;
    JLabel createAccount;

    SignUpPage(){
        initPage();
    }
    public void initPage(){
        frame = new JFrame();
        signUpButton = new JButton();
        createAccount = new JLabel();
        frame.setTitle("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1440, 810);
        frame.setLayout(null);

        signUpButton.setBounds(971, 612, 217, 72);
        signUpButton.setIcon(iconSignUp);

        createAccount.setText("Create Account");
        createAccount.setBounds(1269, 150, 342, 56);
        createAccount.setOpaque(false);
        createAccount.setForeground(Color.black);
        createAccount.setFont(new Font("Arial", Font.PLAIN, 50));

        frame.add(createAccount);
        frame.add(signUpButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SignUpPage signUpPage = new SignUpPage();
    }
}
