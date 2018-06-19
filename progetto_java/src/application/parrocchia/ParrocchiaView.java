package application.parrocchia;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import application.admin.InsertPanel;

public class ParrocchiaView extends JFrame{
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height * 5/6;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width * 5/6;
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 8177523068486028650L;
	
	public ParrocchiaView() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		InsertPanel insertPanel = new InsertPanel();
		this.setTitle("Responasbile di Parrocchia");
		panel.add(insertPanel, BorderLayout.NORTH);
		this.add(panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
