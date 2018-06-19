package application.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class AdminView extends JFrame {
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 8177523068486028650L;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private JTextArea view = new JTextArea(100, 400);
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	public AdminView() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		InsertPanel insertPanel = new InsertPanel();
		AdminViewOperationPanel op = new AdminViewOperationPanel();
		AdminModifyOperation mod = new AdminModifyOperation();
		panel.add(mod, BorderLayout.WEST);
		panel.add(op, BorderLayout.SOUTH);
		this.setTitle("Admin");
		this.view.setBorder(this.border);
		panel.add(this.view, BorderLayout.CENTER);
		panel.add(insertPanel, BorderLayout.NORTH);
		this.add(panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
