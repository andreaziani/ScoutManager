package application.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertPanel extends JPanel{
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 1451766951844875659L;
	// inserimento responsabile parrocchia
	private JLabel insertResponsabile = new JLabel("Inserimento Responsabile Parrocchia");
	private JLabel codiceResponsabile = new JLabel("Codice Responsabile: ");
	private JTextField codResponsabile = new JTextField(16);
	private JLabel codiceFiscale = new JLabel("CF: ");
	private JTextField cf = new JTextField(16);
	private JLabel nomeResponsabileP = new JLabel("nome: ");
	private JTextField nameResponsabileP = new JTextField(16);
	private JLabel cognome = new JLabel("cognome: ");
	private JTextField surname = new JTextField(16);
	private JLabel dataNascita = new JLabel("data nascita: ");
	private JTextField date = new JTextField(16);
	private JLabel luogoNascita = new JLabel("luogo nascita: ");
	private JTextField luogo = new JTextField(16);
	private JLabel numTelefono = new JLabel("numero telefono: ");
	private JTextField numeroTelefono = new JTextField(16);
	private JLabel nomeUtente = new JLabel("nome utente: ");
	private JTextField username = new JTextField(16);
	private JLabel passwordAssegnata = new JLabel("password: ");
	private JTextField password = new JTextField(16);
	private JButton registraRespEParr = new JButton("Registra responsabile e parrocchia");
	
	//inserimento parrocchia 
	private JLabel insertParrocchia = new JLabel("Inserimento Parrocchia");
	private JLabel codiceParrocchia = new JLabel("Codice Parrocchia: ");
	private JTextField codParrocchia = new JTextField(16);
	private JLabel nomeParrocchia = new JLabel("nome: ");
	private JTextField nameParrocchia = new JTextField(16);
	private JLabel viaParrocchia = new JLabel("via: ");
	private JTextField viaP = new JTextField(16);
	private JLabel numCivicoParrocchia = new JLabel("numero civico: ");
	private JTextField numCivicoP = new JTextField(16);
	
	//residenza
	private JLabel residenza = new JLabel("Inserisci Residenza");
	private JLabel cPar = new JLabel("codice parrocchia: ");
	private JTextField cParrocchia = new JTextField(16);
	private JLabel cities = new JLabel("città: ");
	private JComboBox<String> città = new JComboBox<>();
	
	public InsertPanel() {
		GridBagLayout grid = new GridBagLayout();
		this.setLayout(grid);
		this.inserimentoResponsabileParrocchia();
		this.inserimentoParrocchia();
		this.inserimentoResidenza();
	}
	
	private void inserimentoResidenza() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 5;
		c.gridy = 0;
		this.add(this.residenza, c);
		c.gridx = 4;
		c.gridy = 1;
		this.add(this.cPar, c);
		c.gridx = 5;
		this.add(this.cParrocchia, c);
		c.gridx = 4;
		c.gridy = 2;
		this.add(this.cities, c);
		c.gridx = 5;
		this.add(this.città, c);
	}
	
	private void inserimentoParrocchia() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 3;
		c.gridy = 0;
		this.add(this.insertParrocchia, c);
		c.gridx = 2;
		c.gridy = 1;
		this.add(this.codiceParrocchia, c);
		c.gridx = 3;
		this.add(this.codParrocchia, c);
		c.gridx = 2;
		c.gridy = 2;
		this.add(this.nomeParrocchia, c);
		c.gridx = 3;
		this.add(this.nameParrocchia, c);
		c.gridx = 2;
		c.gridy = 3;
		this.add(this.viaParrocchia, c);
		c.gridx = 3;
		this.add(this.viaP, c);
		c.gridx = 2;
		c.gridy = 4;
		this.add(this.numCivicoParrocchia, c);
		c.gridx = 3;
		this.add(this.numCivicoP, c);
		c.gridx = 3;
		c.gridy = 5;
	}
	
	private void inserimentoResponsabileParrocchia() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 1;
		this.add(this.insertResponsabile, c);
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codiceResponsabile, c);
		c.gridx = 1;
		this.add(this.codResponsabile, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(this.codiceFiscale, c);
		c.gridx = 1;
		this.add(this.cf, c);
		c.gridx = 0;
		c.gridy = 3;
		this.add(this.nomeResponsabileP, c);
		c.gridx = 1;
		this.add(this.nameResponsabileP, c);
		c.gridx = 0;
		c.gridy = 4;
		this.add(this.cognome, c);
		c.gridx = 1;
		this.add(this.surname, c);
		c.gridx = 0;
		c.gridy = 5;
		this.add(this.dataNascita, c);
		c.gridx = 1;
		this.add(this.date, c);
		c.gridx = 0;
		c.gridy = 6;
		this.add(this.luogoNascita, c);
		c.gridx = 1;
		this.add(this.luogo, c);
		c.gridx = 0;
		c.gridy = 7;
		this.add(this.numTelefono, c);
		c.gridx = 1;
		this.add(this.numeroTelefono, c);
		c.gridx = 0;
		c.gridy = 8;
		this.add(this.nomeUtente, c);
		c.gridx = 1;
		this.add(this.username, c);
		c.gridx = 0;
		c.gridy = 9;
		this.add(this.passwordAssegnata, c);
		c.gridx = 1;
		this.add(this.password, c);
		c.gridx = 1;
		c.gridy = 10;
		this.add(this.registraRespEParr, c);
	}
}
