import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {
    Calendar cal;
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel timeLabel, dayLabel, dateLabel;
    String time, day, date;
    Image image;
    MyFrame(){
        image = new ImageIcon("D:\\quann\\Pictures\\PicturesOfQuan\\Notion\\Icon_XoaPhong\\Clock.png").getImage();
        this.setIconImage(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350, 200);
        this.setResizable(false);   // khong cho phep resize

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMMM dd, yyyy");

        timeLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.cyan);
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel.setText(day);
        dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));

        dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);
        setTime();
    }

    public void setTime(){
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
