package application.admin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdminViewOperationPanel extends JPanel {
	 
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 2907987461933376055L;
	// parr per citt�
	private JLabel parrocchiePerCitta = new JLabel("Parrocchie per citt�");
	private JLabel nomeCitta = new JLabel("citt�: ");
	private JTextField citta = new JTextField(16);
	private JButton b1 = new JButton("visualizza parrocchie per citt�");
	
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
		
	}
}
