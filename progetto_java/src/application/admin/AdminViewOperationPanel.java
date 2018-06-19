package application.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminViewOperationPanel extends JPanel {
	 
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 2907987461933376055L;
	// parr per citta
	private JLabel parrocchiePerCitta = new JLabel("Parrocchie per citta");
	private JLabel nomeCitta = new JLabel("citta: ");
	private JTextField citta = new JTextField(16);
	private JButton b1 = new JButton("visualizza parrocchie per citta");
	
	// parr per resp
	private JLabel parrocchiePerResp = new JLabel("Parrocchia per responsabile");
	private JLabel codiceResp = new JLabel("codice responsabile: ");
	private JTextField codResponsabile = new JTextField(16);
	private JButton b2 = new JButton("visualizza parrocchie per responsabile");
	
	// evento nazionale per resp
	private JLabel eventoPerResp = new JLabel("Evento nazionale per responsabile");
	private JLabel codiceRespEN = new JLabel("codice responsabile: ");
	private JTextField codResponsabileEN = new JTextField(16);
	private JButton b3 = new JButton("visualizza evento nazionale per responsabile");
	
	// Evento Parr per data 
	private JLabel eventoParrPerData = new JLabel("Evento Parrocchia per data");
	private JLabel dataInizio = new JLabel("data inizio evento: ");
	private JTextField data = new JTextField(16);
	private JButton b4 = new JButton("visualizza evento di parrocchia per data");
	
	// evento nazionale per data
	private JLabel eventoNazPerData = new JLabel("Evento nazionale per data");
	private JLabel dataInizioN = new JLabel("data inizio evento: ");
	private JTextField dataN = new JTextField(16);
	private JButton b5 = new JButton("visualizza evento nazionale per data");
	
	
	public AdminViewOperationPanel() {
		this.setLayout(new GridBagLayout());
		this.parrPercitta();
		this.parrPerResponsabile();
	}
	
	private void parrPercitta() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(this.parrocchiePerCitta, c);
		c.gridy = 1;
		this.add(this.nomeCitta, c);
		c.gridx = 1;
		this.add(this.citta, c);
		c.gridy = 2;
		this.add(this.b1, c);
	}
	
	private void parrPerResponsabile() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 10, 10, 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		this.add(this.parrocchiePerResp, c);
		c.gridy = 1;
		this.add(this.codiceResp);
		c.gridx = 4;
		this.add(this.codResponsabile, c);
		c.gridx = 4;
		c.gridy = 2;
		this.add(this.b2, c);
	}
}
