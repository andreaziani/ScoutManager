package application.parrocchia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class ParrocchiaView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1321661973309700382L;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private JTextArea view = new JTextArea(100, 400);
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	
	public ParrocchiaView() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		ParrocchiaViewOperation op = new ParrocchiaViewOperation();
		ParrocchiaModifyOperation mod = new ParrocchiaModifyOperation();
		panel.add(mod, BorderLayout.NORTH);
		panel.add(op, BorderLayout.SOUTH);
		this.setTitle("Admin");
		this.view.setBorder(this.border);
		panel.add(this.view, BorderLayout.CENTER);
		this.add(panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}
