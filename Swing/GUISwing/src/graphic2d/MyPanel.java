package graphic2d;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Image image;
    MyPanel(){
        image = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Sky.jpg").getImage();
        this.setPreferredSize(new Dimension(500, 500));
    }
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
//        g2D.setPaint(Color.cyan);
//        g2D.setStroke(new BasicStroke(5));  // set do rong cho net ve
//        g2D.drawLine(0, 0, 500, 500);       // ve ra 1 duong thang

//        g2D.drawRect(0,0,100,100);      // ve hinh chu nhat hoac hinh vuong
//        g2D.fillRect(0,0,100,100);

//        g2D.drawOval(0,0,100,100);
//        g2D.fillOval(0,0,100,100);

//        g2D.drawArc(0,0,100,100,180,180);
//        g2D.setPaint(Color.magenta);
//        g2D.fillArc(0,0,100,100,0,180);
//        g2D.setPaint(Color.white);
//        g2D.fillArc(0,0,100,100,180,180);

//        int[] xPoint = {150, 250, 350};
//        int[] yPoint = {300, 150, 300};
//        g2D.setPaint(Color.yellow);
//        g2D.drawPolygon(xPoint,yPoint,3);
//        g2D.fillPolygon(xPoint,yPoint,3);
        g2D.drawImage(image,0,0,null);

        g2D.setPaint(Color.green);
        g2D.setFont(new Font("MV Boli",Font.BOLD,35));
        g2D.drawString("Sky oi",50,50);

    }

}
