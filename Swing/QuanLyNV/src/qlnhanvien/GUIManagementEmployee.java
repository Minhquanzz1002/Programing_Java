package qlnhanvien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GUIManagementEmployee extends JFrame implements ActionListener, MouseListener {
    private FlowLayout fl;
    private JTextField txtEmpID, txtFirstName, txtLastName, txtAge, txtSalary, txtSearch;
    private JRadioButton radMale, radFemale;
    private ButtonGroup grpSex;
    private JTable tblEmp;
    private DefaultTableModel tblModel;
    private String[] col = {"MÃ£ NV", "Há»�", "TÃªn", "PhÃ¡i", "Tuá»•i", "Tiá»�n lÆ°Æ¡ng"};
    private JButton btnSearch, btnAdd, btnClear, btnDel, btnSave;
    private ListEmployee lstEmp;
    private JComboBox<String> cboSex;

    public GUIManagementEmployee(String title) {
        setTitle(title);
    }

    public void doShow() {
        lstEmp = new ListEmployee();
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addControl();
        setVisible(true);
        pack();
    }

    public void addControl() {
        fl = new FlowLayout(FlowLayout.LEFT);
        /*Pháº§n tiÃªu Ä‘Ã¨*/
        JLabel lblTitle = new JLabel("THÃ”NG TIN NHÃ‚N VIÃŠN", JLabel.CENTER);
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

        /*Pháº§n input mÃ£ nhÃ¢n viÃªn*/
        JLabel lblEmpID = new JLabel("MÃ£ nhÃ¢n viÃªn:");
        txtEmpID = new JTextField(60);
        JPanel pnEmpID = new JPanel(fl);
        pnEmpID.add(lblEmpID);
        pnEmpID.add(txtEmpID);

        /*Pháº§n input há»� vÃ  tÃªn*/
        JLabel lblFirstName = new JLabel("Há»�:");
        txtFirstName = new JTextField(25);
        JLabel lblLastName = new JLabel("TÃªn:", JLabel.CENTER);
        txtLastName = new JTextField(25);
        JPanel pnName = new JPanel(fl);
        pnName.add(lblFirstName);
        pnName.add(txtFirstName);
        pnName.add(lblLastName);
        pnName.add(txtLastName);

        /*Pháº§n input tuá»•i vÃ  phÃ¡i*/
        JLabel lblAge = new JLabel("Tuá»•i:");
        txtAge = new JTextField(40);
        JLabel lblSex = new JLabel("PhÃ¡i:", JLabel.RIGHT);
        radMale = new JRadioButton("Nam");
        radMale.setActionCommand("Nam");
        radMale.setFocusable(false);
        radFemale = new JRadioButton("Ná»¯");
        radFemale.setActionCommand("Ná»¯");
        radFemale.setFocusable(false);
        JPanel pnAge_Sex = new JPanel(fl);
        pnAge_Sex.add(lblAge);
        pnAge_Sex.add(txtAge);
        pnAge_Sex.add(lblSex);
        pnAge_Sex.add(radMale);
        pnAge_Sex.add(radFemale);
        grpSex = new ButtonGroup();
        grpSex.add(radMale);
        grpSex.add(radFemale);

        /*Pháº§n input lÆ°Æ¡ng*/
        JLabel lblSalary = new JLabel("Tiá»�n lÆ°Æ¡ng:");
        txtSalary = new JTextField(60);
        JPanel pnSalary = new JPanel(fl);
        pnSalary.add(lblSalary);
        pnSalary.add(txtSalary);

        /*Pháº§n báº£ng*/
        tblModel = new DefaultTableModel(col, 0){

            /*Cho phep sua du lieu cot hay khong.*/
            @Override
            public boolean isCellEditable(int row, int column) {
                switch (column){
                    case 0:
                        return false;
                    default:
                        return true;
                }
            }
        };
        tblEmp = new JTable(tblModel);
        JScrollPane scrTable = new JScrollPane(tblEmp);
        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BoxLayout(pnTable, BoxLayout.X_AXIS));
        pnTable.add(scrTable);
        cboSex = new JComboBox<>();
        cboSex.addItem("Nam");
        cboSex.addItem("Ná»¯");
        DefaultCellEditor dce = new DefaultCellEditor(cboSex);
        tblEmp.getColumnModel().getColumn(3).setCellEditor(dce);
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
        pnCenter.add(pnEmpID);
        pnCenter.add(pnName);
        pnCenter.add(pnAge_Sex);
        pnCenter.add(pnSalary);
        pnCenter.add(pnTable);

        /*Pháº§n tÃ¬m kiáº¿m*/
        JLabel lblSearch = new JLabel("Nháº­p mÃ£ sá»‘ cáº§n tÃ¬m:");
        txtSearch = new JTextField(15);
        btnSearch = new JButton("TÃ¬m");
        JPanel pnSearch = new JPanel(fl);
        pnSearch.add(lblSearch);
        pnSearch.add(txtSearch);
        pnSearch.add(btnSearch);

        /*Pháº§n cÃ¡c nÃºt chá»©c nÄƒng*/
        btnAdd = new JButton("ThÃªm");
        btnClear = new JButton("XÃ³a tráº¯ng");
        btnDel = new JButton("XÃ³a");
        btnSave = new JButton("LÆ°u");
        JPanel pnControl = new JPanel();
        pnControl.add(btnAdd);
        pnControl.add(btnClear);
        pnControl.add(btnDel);
        pnControl.add(btnSave);

        JPanel pnSouth = new JPanel(new BorderLayout());
        pnSouth.add(pnSearch, BorderLayout.WEST);
        pnSouth.add(pnControl, BorderLayout.CENTER);

        JPanel pnBorderCha = new JPanel(new BorderLayout());
        pnBorderCha.add(lblTitle, BorderLayout.NORTH);
        pnBorderCha.add(pnCenter, BorderLayout.CENTER);
        pnBorderCha.add(pnSouth, BorderLayout.SOUTH);


        add(pnBorderCha);
        lblFirstName.setPreferredSize(lblEmpID.getPreferredSize());
        lblAge.setPreferredSize(lblEmpID.getPreferredSize());
        lblSalary.setPreferredSize(lblEmpID.getPreferredSize());
        lblLastName.setPreferredSize(new Dimension(txtEmpID.getPreferredSize().width - txtFirstName.getPreferredSize().width - txtLastName.getPreferredSize().width - 10, lblEmpID.getPreferredSize().height));
        radMale.setPreferredSize(new Dimension((txtEmpID.getPreferredSize().width - txtAge.getPreferredSize().width - 15)/3, lblEmpID.getPreferredSize().height));
        radFemale.setPreferredSize(new Dimension((txtEmpID.getPreferredSize().width - txtAge.getPreferredSize().width - 15)/3, lblEmpID.getPreferredSize().height));
        lblSex.setPreferredSize(new Dimension((txtEmpID.getPreferredSize().width - txtAge.getPreferredSize().width - 15)/3, lblEmpID.getPreferredSize().height));
        scrTable.setPreferredSize(new Dimension(0, 100));

        /*CÃ¡c sá»± kiá»‡n*/
        btnSave.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        btnClear.addActionListener(this);
        btnSearch.addActionListener(this);
        tblEmp.addMouseListener(this);

        /*Load data from file*/
        StoredData stData = new StoredData();
        try {
            lstEmp = (ListEmployee) stData.loadFile("data\\EmployeeData.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loadDataToTable(lstEmp.getLstEmp(), tblModel);

        /* Pháº§n dá»¯ liá»‡u test */
        txtEmpID.setText("5555");
        txtFirstName.setText("Nguyen Minh");
        txtLastName.setText("Quan");
        txtAge.setText("20");
        txtSalary.setText("100000");
        txtSearch.setText("5555");
        radMale.setSelected(true);
    }

    public void clearItem() {
        txtEmpID.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        txtSalary.setText("");
        txtSearch.setText("");
        grpSex.clearSelection();
        txtEmpID.requestFocus();
    }

    public String getSexRadio() {
        if (radMale.isSelected()) {
            return "Nam";
        } else if (radFemale.isSelected()) {
            return "Ná»¯";
        } else {
            return null;
        }
    }

    public void loadDataToTable(ArrayList<Employee> lst, DefaultTableModel tblModel) {
        for (Employee emp : lst) {
            Object[] obj = {emp.getEmpID(), emp.getFirstname(), emp.getLastname(), emp.getSex(), emp.getAge(), emp.getSalary()};
            tblModel.addRow(obj);
        }
    }

    public void loadDataToText(Employee emp) {
        txtEmpID.setText(emp.getEmpID());
        txtFirstName.setText(emp.getFirstname());
        txtLastName.setText(emp.getLastname());
        txtAge.setText(String.valueOf(emp.getAge()));
        txtSalary.setText(String.valueOf(emp.getSalary()));
        if (emp.getSex().equals("Nam")) {
            radMale.setSelected(true);
        } else {
            radFemale.setSelected(true);
        }
    }

    public Employee createNewEmployee() {
        String empID, firstname, lastname, sex;
        int age;
        double salary;
        Employee item;
        empID = txtEmpID.getText().trim();
        firstname = txtFirstName.getText().trim();
        lastname = txtLastName.getText().trim();
        age = Integer.parseInt(txtAge.getText().trim());
        salary = Double.parseDouble(txtSalary.getText().trim());
        sex = getSexRadio();
        item = new Employee(empID, firstname, lastname, sex, age, salary);
        return item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();
        if (action == btnAdd) {
            if (txtEmpID.getText().trim().isEmpty() || txtFirstName.getText().trim().isEmpty() || txtLastName.getText().trim().isEmpty() || txtAge.getText().trim().isEmpty() || txtSalary.getText().trim().isEmpty() || grpSex.getSelection() == null) {
                JOptionPane.showMessageDialog(this, "HÃ£y nháº­p Ä‘áº§y Ä‘á»§ dá»¯ liá»‡u trÆ°á»›c!!!");
            } else {
                Employee emp = createNewEmployee();
                if (emp == null) {
                    JOptionPane.showMessageDialog(this, "ThÃ´ng tin nháº­p khÃ´ng há»£p lá»‡!!!");
                } else {
                    lstEmp.addEmployee(emp);
                    Object[] obj = {emp.getEmpID(), emp.getFirstname(), emp.getLastname(), emp.getSex(), emp.getAge(), emp.getSalary()};
                    tblModel.addRow(obj);
                    JOptionPane.showMessageDialog(this, "ThÃªm thÃ nh cÃ´ng.");
                    clearItem();
                }
            }
        }
        if (action == btnClear) {
            clearItem();
        }
        if (action == btnSave) {
            try {
                StoredData stData = new StoredData();
                if (stData.saveFile(lstEmp, "data\\EmployeeData.txt")) {
                    JOptionPane.showMessageDialog(this, "LÆ°u thÃ nh cÃ´ng!!!");
                } else {
                    JOptionPane.showMessageDialog(this, "LÆ°u thÃ´ng tin tháº¥t báº¡i");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (action == btnDel){
            int row = tblEmp.getSelectedRow();
            if (row < 0){
                JOptionPane.showMessageDialog(this, "HÃ£y chá»�n nhÃ¢n viÃªn muá»‘n xÃ³a trÆ°á»›c");
            }else{
                Employee emp = lstEmp.getLstEmp().get(row);
                if (JOptionPane.showConfirmDialog(this, "Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n xÃ³a nhÃ¢n viÃªn " + emp.getEmpID(), "XÃ¡c nháº­n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    lstEmp.deleteEmployee(emp);
                    DefaultTableModel model = (DefaultTableModel) tblEmp.getModel();
                    model.setRowCount(0);
                    loadDataToTable(lstEmp.getLstEmp(), model);
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = tblEmp.getSelectedRow();
        if (row != -1) {
            Employee emp = lstEmp.getLstEmp().get(row);
            loadDataToText(emp);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new GUIManagementEmployee("Quáº£n lÃ½ nhÃ¢n viÃªn").doShow();
    }

}
