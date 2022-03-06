import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField screenCal;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton[] funcButton = new JButton[9];
    JPanel panel1, panel2;
    Image image;
    char operator; // phep tinh
    double num1 = 0, num2 = 0, result = 0;
    Font font = new Font("Global",Font.PLAIN, 20);
    Calculator(){
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLayout(new FlowLayout());
        frame.setSize(290,430);
        frame.setLayout(null);
        image = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Calculator.png").getImage();
        frame.setIconImage(image);
        /***
         * Cac nut tinh toan
         */
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");

        funcButton[0] = addButton;
        funcButton[1] = subButton;
        funcButton[2] = mulButton;
        funcButton[3] = divButton;
        funcButton[4] = decButton;
        funcButton[5] = equButton;
        funcButton[6] = delButton;
        funcButton[7] = clrButton;
        funcButton[8] = negButton;

        for (int i = 0; i < 9; i++) {
            funcButton[i].addActionListener(this);
            funcButton[i].setFont(font);
            funcButton[i].setFocusable(false);
            funcButton[i].setBackground(new Color(204,204,204));
        }

        /***
         * Cac so 0-9
         */
        for (int i = 0; i < 10; i++) {
            String number = Integer.toString(i);
            numberButtons[i] = new JButton();
            numberButtons[i].setText(number);
            numberButtons[i].setFont(font);
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(204,204,204));
        }

        /***
         * Phan giao dien
         */
        screenCal = new JTextField();
        screenCal.setBounds(20,20,230,50);
        screenCal.setFont(font);

        panel1 = new JPanel();
        panel1.setBounds(20,80,230,230);
        panel1.setLayout(new GridLayout(4, 4,10,10));
        panel1.add(numberButtons[1]);
        panel1.add(numberButtons[2]);
        panel1.add(numberButtons[3]);
        panel1.add(addButton);
        panel1.add(numberButtons[4]);
        panel1.add(numberButtons[5]);
        panel1.add(numberButtons[6]);
        panel1.add(subButton);
        panel1.add(numberButtons[7]);
        panel1.add(numberButtons[8]);
        panel1.add(numberButtons[9]);
        panel1.add(mulButton);
        panel1.add(decButton);
        panel1.add(numberButtons[0]);
        panel1.add(equButton);
        panel1.add(divButton);

        panel2 = new JPanel();
        panel2.setBounds(20, 320, 230, 50);
        panel2.setLayout(new GridLayout(1,3,10, 10));
        panel2.add(negButton);
        panel2.add(delButton);
        panel2.add(clrButton);

        frame.add(screenCal);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]){
                screenCal.setText(screenCal.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            screenCal.setText(screenCal.getText().concat("."));
        }
        if (e.getSource() == clrButton){
            screenCal.setText("");
        }
        if (e.getSource() == delButton){
            String string = screenCal.getText();
            screenCal.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                screenCal.setText(screenCal.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(screenCal.getText());
            operator = '+';
            screenCal.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(screenCal.getText());
            operator = '-';
            screenCal.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(screenCal.getText());
            operator = '*';
            screenCal.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(screenCal.getText());
            operator = '/';
            screenCal.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(screenCal.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            num1 = result;
            screenCal.setText(String.valueOf(result));
        }
        if (e.getSource() == negButton){
            if (screenCal.getText().isEmpty()){
                screenCal.setText("-");
            }else{
                double temp = Double.parseDouble(screenCal.getText());
                temp *= -1;
                screenCal.setText(String.valueOf(temp));
            }
        }
    }
}
