package application.admin;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminView extends JFrame {
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 8177523068486028650L;
	
	public AdminView() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		InsertPanel insertPanel = new InsertPanel();
		AdminViewOperationPanel op = new AdminViewOperationPanel();
		panel.add(op, BorderLayout.SOUTH);
		this.setTitle("Admin");
		panel.add(insertPanel, BorderLayout.NORTH);
		this.add(panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
