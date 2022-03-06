package bai2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;

public class SoNguyenTo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField labelInput;
	private JButton generateButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoNguyenTo frame = new SoNguyenTo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SoNguyenTo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		labelInput = new JTextField();
		labelInput.setBounds(25, 31, 147, 25);
		contentPane.add(labelInput);
		labelInput.setColumns(10);
		
		generateButton = new JButton("Generate");
		generateButton.setBounds(182, 28, 89, 30);
		contentPane.add(generateButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(25, 67, 246, 116);
		contentPane.add(textArea);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == generateButton) {
			int n;
			n = Integer.valueOf(labelInput.getText());
			
		}
	}
}
