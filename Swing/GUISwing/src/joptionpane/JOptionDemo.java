package joptionpane;
import javax.swing.JOptionPane;
public class JOptionDemo {
    public static void main(String[] args) {
//        JOptionPane.showMessageDialog(null,"Da xay ra loi","Thong bao",JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null,"Da xay ra loi","Thong bao",JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null,"Da xay ra loi","Thong bao",JOptionPane.QUESTION_MESSAGE);
//        JOptionPane.showMessageDialog(null,"Da xay ra loi","Thong bao",JOptionPane.WARNING_MESSAGE);
//        JOptionPane.showMessageDialog(null,"Da xay ra loi","Thong bao",JOptionPane.ERROR_MESSAGE);

//        JOptionPane.showConfirmDialog(null,"Ban da san sang chua?","Tieu de",JOptionPane.YES_NO_CANCEL_OPTION);
//        int answer = JOptionPane.showConfirmDialog(null,"Ban da san sang chua?","Tieu de",JOptionPane.YES_NO_CANCEL_OPTION);
//        String name = JOptionPane.showInputDialog("Ten cua ban la gi?: ");
//        System.out.println(name);

        String[] chon = {"Dong y","Khong","Thoat"};
        JOptionPane.showOptionDialog(null,"Ban da san sang chua?","Tieu de",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,chon,0);
    }
}
