package view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.DBConnection;

public class AdminView extends JFrame {
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 8177523068486028650L;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private JTextArea view = new JTextArea(100, 400);
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	public AdminView(DBConnection con) {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//		this.setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		AdminInsertPanel insertPanel = new AdminInsertPanel(con);
		AdminViewOperationPanel op = new AdminViewOperationPanel(con, view);
		AdminModifyOperation mod = new AdminModifyOperation(con);
		panel.add(mod, BorderLayout.WEST);
		panel.add(op, BorderLayout.SOUTH);
		this.view.setEditable(false);
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
