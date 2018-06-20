package application.admin;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.app.DBConnection;

public class AdminModifyOperation extends JPanel {
	/**
	 * Automatically generated
	 */
	private static final long serialVersionUID = -7924528685503992288L;
	private JLabel modifyResp = new JLabel("Modifica responsabile parrocchia");
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
	private JButton modificaRespParrocchia = new JButton("Modifica responsabile e parrocchia");
	
	public AdminModifyOperation(DBConnection con) {
		this.setLayout(new GridBagLayout());
		this.modificaResp();
	}
	
	private void modificaResp() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.modifyResp, c);
		c.gridy = 1;
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
		c.gridx = 0;
		c.gridy = 10;
		this.add(this.modificaRespParrocchia, c);
	}
}
