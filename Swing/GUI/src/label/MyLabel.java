package label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyLabel {
	public static void main(String[] args) {
		JLabel label = new JLabel();
        ImageIcon icon = new ImageIcon("F:\\Programing_Java\\Swing\\GUI\\src\\icon_x.png");
        label.setText("Hello bro");
        label.setIcon(icon);
        JFrame frame = new JFrame();
        frame.setTitle("Demo Label");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 800);

        frame.setVisible(true);
        frame.add(label);
	}
}
