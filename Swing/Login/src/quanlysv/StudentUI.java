package quanlysv;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentUI extends JFrame implements ActionListener {
    private JPanel inputPanel, panel1, panel2;
    private JLabel nameLabel, genderLabel, ageLabel, emailLabel, phoneLabel;
    private JButton saveButton, resetButton, delButton, findButton;
    private JTextField nameTextField, ageTextField, emailTextField, phoneTextField;
    private JComboBox<String> genderComboBox;
    private JTable table;
    private DefaultTableModel defaultTableModel;
    JScrollPane scrollPane;
    StudentUI(){
        initComponents();
    }
    public void initComponents(){
        inputPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        nameLabel = new JLabel();
        nameTextField = new JTextField();
        genderLabel = new JLabel();
        genderComboBox = new JComboBox<>();
        ageLabel = new JLabel();
        ageTextField = new JTextField();
        emailLabel = new JLabel();
        emailTextField = new JTextField();
        phoneLabel = new JLabel();
        phoneTextField = new JTextField();
        saveButton = new JButton();
        resetButton = new JButton();
        delButton = new JButton();
        findButton = new JButton();
        defaultTableModel = new DefaultTableModel();


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder(null, "Input Student's Detail Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.PLAIN, 11), new Color(51, 255, 51)));
        inputPanel.setPreferredSize(new Dimension(500, 270));
        inputPanel.setMaximumSize(new Dimension(500, 300));
        inputPanel.setLayout(new BorderLayout());

        panel1.setLayout(null);
        panel1.setPreferredSize(new Dimension(500, 300));

        panel2.setLayout(new GridLayout(1, 4, 10, 0));

        nameLabel.setText("Full name");
        nameLabel.setBounds(10, 10, 100, 20);
        nameTextField.setBounds(120, 10, 300, 20);

        genderLabel.setText("Gender");
        genderLabel.setBounds(10, 50, 100, 20);

        genderComboBox.addItem("Nam");
        genderComboBox.addItem("Nu");
        genderComboBox.setSelectedIndex(0);
        genderComboBox.setBounds(120, 50, 100, 20);

        ageLabel.setText("Age");
        ageLabel.setBounds(10, 90, 100, 20);

        ageTextField.setBounds(120, 90, 300, 20);

        emailLabel.setText("Email");
        emailLabel.setBounds(10, 130, 100, 20);

        emailTextField.setBounds(120, 130, 300, 20);

        phoneLabel.setText("Phone Number");
        phoneLabel.setBounds(10, 170, 100, 20);

        phoneTextField.setBounds(120, 170, 300, 20);

        saveButton.setText("Save");
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);

        delButton.setText("Delete");
        delButton.setFocusable(false);

        resetButton.setText("Reset");
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        findButton.setText("Find");
        findButton.setFocusable(false);

        table = new JTable();
        table.setModel(defaultTableModel);
        defaultTableModel.addColumn("Full name");
        defaultTableModel.addColumn("Gender");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("Phone Number");
        defaultTableModel.addRow(new Object[] {"Minh Quan", "Nam", "19", "quan.iuh", "0983933"});
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 200));

        panel1.add(nameLabel);
        panel1.add(genderLabel);
        panel1.add(ageLabel);
        panel1.add(emailLabel);
        panel1.add(phoneLabel);
        panel1.add(nameTextField);
        panel1.add(genderComboBox);
        panel1.add(ageTextField);
        panel1.add(emailTextField);
        panel1.add(phoneTextField);
        panel2.add(saveButton);
        panel2.add(resetButton);
        panel2.add(delButton);
        panel2.add(findButton);
        inputPanel.add(panel1, BorderLayout.NORTH);
        inputPanel.add(panel2, BorderLayout.SOUTH);
        this.setPreferredSize(new Dimension(600, 410));
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * set gia tri mac dinh cho cac nut nhap lieu
     */
    public void setDefaultFieldInput(){
        nameTextField.setText("");
        ageTextField.setText("");
        emailTextField.setText("");
        phoneTextField.setText("");
        genderComboBox.setSelectedIndex(0);
    }
    public static void main(String[] args) {
        new StudentUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton){
            setDefaultFieldInput();
        }
        if (e.getSource() == saveButton){
            String name, gender, email, phone, age;
            name = nameTextField.getText();
            gender = String.valueOf(genderComboBox.getSelectedItem());
            email = emailTextField.getText();
            phone = phoneTextField.getText();
            age = ageTextField.getText();
            defaultTableModel.addRow(new Object[] {name, gender, age, email, phone});
            setDefaultFieldInput();
        }
    }
}
