package application.admin;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminView extends JFrame {
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height * 3/4;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width * 3/4;
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 8177523068486028650L;
	
	public AdminView() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		InsertPanel insertPanel = new InsertPanel();
		this.setTitle("Admin");
		panel.add(insertPanel, BorderLayout.NORTH);
		this.add(panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
