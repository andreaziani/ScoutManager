package view.responsabileparrocchia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import model.DBConnection;
import model.ResponsabileParrocchia;


public class ParrocchiaView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1321661973309700382L;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private JTextArea view = new JTextArea(100, 400);
	private Border border = BorderFactory.createLineBorder(Color.BLACK);
	
	public ParrocchiaView(ResponsabileParrocchia responsabileParrocchia, DBConnection con) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.view.setEditable(false);
		ParrocchiaViewOperationPanel op = new ParrocchiaViewOperationPanel(con, view, responsabileParrocchia);
		ParrocchiaModifyOperation mod = new ParrocchiaModifyOperation(con, responsabileParrocchia);
		panel.add(mod, BorderLayout.NORTH);
		panel.add(op, BorderLayout.SOUTH);
		this.setTitle("Responsabile Parrocchia");
		this.view.setBorder(this.border);
		panel.add(this.view, BorderLayout.CENTER);
		this.add(panel);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

}
