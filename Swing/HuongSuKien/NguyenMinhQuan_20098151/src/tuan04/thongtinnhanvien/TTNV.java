package tuan04.thongtinnhanvien;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TTNV extends JFrame implements ActionListener {
    JButton btnThem,btnLuu,btnXoaTrang,btnXoa,btnTim;
    JTextField txtHo,txtTenNV,txtTuoi,txtTienLuong,txtManv,txtTim;
    DefaultTableModel model;
    JTable table;
    JRadioButton radNam,radNu;
    int row;
    public TTNV(String title){
        setTitle(title);
    }
    public void doShow(){
        setSize(800,550);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addControl();
        setVisible(true);
    }
    public void addControl(){
        JPanel pnBorderCha = new JPanel();
        pnBorderCha.setLayout(new BorderLayout());
        JPanel pnNorth = new JPanel();
        JLabel lbTitle = new JLabel("Thông Tin Nhân Viên");
        Font ft = new Font("arial",Font.BOLD,25);
        lbTitle.setFont(ft);
        lbTitle.setForeground(Color.BLUE);
        pnNorth.add(lbTitle);
        pnBorderCha.add(pnNorth,BorderLayout.NORTH);

        //Center
        JPanel pnCenter = new JPanel();
        JLabel lbManv = new JLabel("Mã nhân viên: ");
        JLabel lbHo = new JLabel("Họ: ");
        JLabel lbTen = new JLabel("Tên nhân viên: ");
        JLabel lbTuoi = new JLabel("Tuổi: ");
        JLabel lbPhai = new JLabel("Phái: ");
        JLabel lbTienLuong = new JLabel("Tiền lương: ");
        txtManv = new JTextField(10);
        txtHo = new JTextField();
        txtTenNV = new JTextField();
        txtTuoi = new JTextField();
        radNam = new JRadioButton("Nam");
        radNu = new JRadioButton("Nữ");
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radNam);
        btnGroup.add(radNu);
        txtTienLuong = new JTextField();

        pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
        JPanel pnNhap = new JPanel();
        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        txtManv = new JTextField(65);
        pnNhap.add(lbManv);
        pnNhap.add(txtManv);

        txtHo = new JTextField(30);
        txtTenNV = new JTextField(25);
        pnNhap.add(lbHo);
        pnNhap.add(txtHo);
        pnNhap.add(lbTen);
        pnNhap.add(txtTenNV);
        lbHo.setPreferredSize(lbManv.getPreferredSize());

        txtTuoi = new JTextField(46);
        txtTienLuong = new JTextField(65);
        radNam = new JRadioButton("Nam");
        radNu = new JRadioButton("Nữ");
        ButtonGroup group = new ButtonGroup();
        group.add(radNam); group.add(radNu);
        pnNhap.add(lbTuoi);
        pnNhap.add(txtTuoi);
        pnNhap.add(lbPhai);
        pnNhap.add(radNam);
        pnNhap.add(radNu);
        pnNhap.add(lbTienLuong);
        pnNhap.add(txtTienLuong);
        lbTuoi.setPreferredSize(lbManv.getPreferredSize());
        lbPhai.setPreferredSize(lbManv.getPreferredSize());
        lbTienLuong.setPreferredSize(lbManv.getPreferredSize());
        b1.add(pnNhap);
        Box b2 = Box.createHorizontalBox();
        b.add(b1);
        b.add(Box.createVerticalStrut(10));
        b.add(b2);
        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Mã NV");
        model.addColumn("Họ");
        model.addColumn("Tên");
        model.addColumn("Phái");
        model.addColumn("Tuổi");
        model.addColumn("Tiền lương");
        table.setPreferredSize(new Dimension(800,300));
        TableColumn phaicolumn = table.getColumnModel().getColumn(3);
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Nam");
        comboBox.addItem("Nữ");
        phaicolumn.setCellEditor(new DefaultCellEditor(comboBox));
        DefaultTableCellRenderer rightRendere = new DefaultTableCellRenderer();
        rightRendere.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
        table.getColumnModel().getColumn(3).setCellRenderer(rightRendere);
        table.getColumnModel().getColumn(4).setCellRenderer(rightRendere);
        table.getColumnModel().getColumn(5).setCellRenderer(rightRendere);
        TableColumn column = new TableColumn();
        column.setPreferredWidth(100);
        JScrollPane sc = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sc.setPreferredSize(new Dimension(750,250));
        b2.add(sc);
        pnCenter.add(b);
        pnBorderCha.add(pnCenter,BorderLayout.CENTER);
        //Chức năng
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new GridLayout(1,2,10,10));
        JPanel pnTimKiem = new JPanel();
        JLabel lbTim = new JLabel("Nhập mã số cần tìm: ");
        txtTim = new JTextField(10);
        btnTim = new JButton("Tìm");
        pnTimKiem.add(lbTim);
        pnTimKiem.add(txtTim);
        pnTimKiem.add(btnTim);
        pnSouth.add(pnTimKiem);

        JPanel pnChucNang = new JPanel();
        btnThem = new JButton("Thêm");
        btnXoaTrang = new JButton("Xóa Trắng");
        btnXoa = new JButton("Xóa");
        btnLuu = new JButton("Lưu");
        pnChucNang.add(btnThem);
        pnChucNang.add(btnXoaTrang);
        pnChucNang.add(btnXoa);
        pnChucNang.add(btnLuu);
        pnSouth.add(pnChucNang);
        Border cnBorder = BorderFactory.createLineBorder(Color.GRAY);
        pnTimKiem.setBorder(cnBorder);
        pnChucNang.setBorder(cnBorder);

        pnBorderCha.add(pnSouth,BorderLayout.SOUTH);
        btnThem.addActionListener(this);
        btnLuu.addActionListener(this);
        btnXoaTrang.addActionListener(this);
        btnXoa.addActionListener(this);
        btnTim.addActionListener(this);

        ListSelectionModel listSelectionModel = table.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                row = table.getSelectedRow();
                txtManv.setText(model.getValueAt(row,0).toString());
                txtHo.setText(model.getValueAt(row,1).toString());
                txtTenNV.setText(model.getValueAt(row,2).toString());
                if(model.getValueAt(row,3).toString().equals("Nam"))
                    radNam.setSelected(true);
                if(model.getValueAt(row,3).toString().equals("Nữ"))
                    radNu.setSelected(true);
                txtTuoi.setText(model.getValueAt(row,4).toString());
                txtTienLuong.setText(model.getValueAt(row,5).toString());
            }
        });
        add(pnBorderCha);
    }
    public static void main(String[] args) {
        TTNV ttnv = new TTNV("Thông Tin");
        ttnv.doShow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj.equals(btnThem)){
            if(btnThem.getText().equals("Thêm"))
            {
                txtManv.setEnabled(true);
                txtHo.setEnabled(true);
                txtTenNV.setEnabled(true);
                txtTuoi.setEnabled(true);
                txtTienLuong.setEnabled(true);
                radNam.setSelected(false);
                radNu.setSelected(false);
                txtManv.requestFocus();
                btnXoa.setEnabled(false);
                btnThem.setText("Hủy");
            }
            else
            {
                btnXoa.setEnabled(true);
                btnThem.setText("Thêm");
            }

        }
        else if(obj.equals(btnLuu)){
            if(txtManv.getText().equals("") || txtHo.getText().equals("") || txtTenNV.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Bạn chưa nhập thông tin! ");
            }
            else
            {
                String gt = "";
                String ma = txtManv.getText();
                String ho = txtHo.getText();
                String ten = txtTenNV.getText();
                if(radNam.isSelected())
                    gt = radNam.getText();
                if(radNu.isSelected())
                    gt = radNu.getText();
                String tuoi = txtTuoi.getText();
                String luong = txtTienLuong.getText();

                String [] row = {ma,ho,ten,gt,tuoi,luong};
                model.addRow(row);
            }
            txtManv.setText("");
            txtHo.setText("");
            txtTenNV.setText("");
            txtTuoi.setText("");
            txtTienLuong.setText("");
            radNam.setSelected(false);
            radNu.setSelected(false);
            txtManv.requestFocus();

        }
        else if(obj.equals(btnXoaTrang)){
            txtManv.setText("");
            txtHo.setText("");
            txtTenNV.setText("");
            radNam.setSelected(false);
            radNu.setSelected(false);
            txtTuoi.setText("");
            txtTienLuong.setText("");
            txtManv.requestFocus();
        }
        else if(obj.equals(btnXoa)){

            for( int i = model.getRowCount() - 1; i >= 0; i-- )
            {
                model.removeRow(i);
            }
            /*
                int removeIndex = table.getSelectedRow();
                try {
                    if (removeIndex == -1) {
                        JOptionPane.showMessageDialog(null, "Hãy chọn 1 dòng rồi ấn nút xóa!");
                    } else {
                        model.removeRow(removeIndex);
                    }
                }catch (Exception ed){
                    ed.printStackTrace();
                }
             */
            System.out.println(row);
        }
        else if(obj.equals(btnTim)){

        }
    }
}