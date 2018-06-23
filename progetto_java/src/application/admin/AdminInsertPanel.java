package application.admin;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import application.app.DBConnection;
import model.AttivitàFormativa;
import model.AttivitàLudica;
import model.CC;
import model.ContieneCC;
import model.ContieneEG;
import model.ContieneLC;
import model.ContieneRS;
import model.EG;
import model.LC;
import model.Parrocchia;
import model.RS;
import model.Residenza;
import model.ResponsabileEventoNazionale;
import model.ResponsabileParrocchia;
import model.ResponsabilitàParrocchia;

import java.sql.*;

public class AdminInsertPanel extends JPanel {
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

	// inserimento parrocchia
	private JLabel insertParrocchia = new JLabel("Inserimento Parrocchia");
	private JLabel codiceParrocchia = new JLabel("Codice Parrocchia: ");
	private JTextField codParrocchia = new JTextField(16);
	private JLabel nomeParrocchia = new JLabel("nome: ");
	private JTextField nameParrocchia = new JTextField(16);
	private JLabel viaParrocchia = new JLabel("via: ");
	private JTextField viaP = new JTextField(16);
	private JLabel numCivicoParrocchia = new JLabel("numero civico: ");
	private JTextField numCivicoP = new JTextField(16);
	private JLabel codiceCCLabel = new JLabel("codice comunità capi: ");
	private JTextField codiceCC = new JTextField(16);
	private JLabel codiceRSLabel = new JLabel("codice RS: ");
	private JTextField codiceRS = new JTextField(16);
	private JLabel codiceEGLabel = new JLabel("codice EG: ");
	private JTextField codiceEG = new JTextField(16);
	private JLabel codiceLCLabel = new JLabel("codice LC: ");
	private JTextField codiceLC = new JTextField(16);

	// residenza
	private JLabel residenza = new JLabel("Inserisci Residenza");
	private JLabel cPar = new JLabel("codice parrocchia: ");
	private JTextField cParrocchia = new JTextField(16);
	private JLabel cities = new JLabel("citta: ");
	private JComboBox<String> citta = new JComboBox<>();

	// attivit� ludica
	private JLabel attL = new JLabel("Inserimento attivita ludica");
	private JLabel codiceAttL = new JLabel("Codice attivita: ");
	private JTextField codiceAttivitaLudica = new JTextField(16);
	private JLabel descAttL = new JLabel("Descrizione attivita: ");
	private JTextArea descrizioneAttivitaLudica = new JTextArea(1, 30);
	private JButton inserisciAttL = new JButton("Inserisci attivita ludica");

	// attivit� formativa
	private JLabel attF = new JLabel("Inserimento attivita formativa");
	private JLabel codiceAttF = new JLabel("Codice attivita: ");
	private JTextField codiceAttivitaFormativa = new JTextField(16);
	private JLabel descAttF = new JLabel("Descrizione attivita: ");
	private JTextArea descrizioneAttivitaFormativa = new JTextArea(1, 30);
	private JButton inserisciAttF = new JButton("Inserisci attivita formativa");

	// responsabile nazionale
	private JLabel insertResponsabileN = new JLabel("Inserimento Responsabile Nazionale");
	private JLabel codiceResponsabileN = new JLabel("Codice Responsabile: ");
	private JTextField codResponsabileN = new JTextField(16);
	private JLabel codiceFiscaleN = new JLabel("CF: ");
	private JTextField cfN = new JTextField(16);
	private JLabel nomeResponsabileN = new JLabel("nome: ");
	private JTextField nameResponsabileN = new JTextField(16);
	private JLabel cognomeN = new JLabel("cognome: ");
	private JTextField surnameN = new JTextField(16);
	private JLabel dataNascitaN = new JLabel("data nascita: ");
	private JTextField dateN = new JTextField(16);
	private JLabel luogoNascitaN = new JLabel("luogo nascita: ");
	private JTextField luogoN = new JTextField(16);
	private JLabel numTelefonoN = new JLabel("numero telefono: ");
	private JTextField numeroTelefonoN = new JTextField(16);
	private JLabel nomeUtenteN = new JLabel("nome utente: ");
	private JTextField usernameN = new JTextField(16);
	private JLabel passwordAssegnataN = new JLabel("password: ");
	private JTextField passwordN = new JTextField(16);
	private JButton registraRespN = new JButton("Registra responsabile nazionale");

	public AdminInsertPanel(DBConnection con) {
		GridBagLayout grid = new GridBagLayout();
		insertResponsabile.setForeground(Color.red);
		insertParrocchia.setForeground(Color.RED);
		residenza.setForeground(Color.RED);
		attL.setForeground(Color.RED);
		attF.setForeground(Color.RED);
		insertResponsabileN.setForeground(Color.RED);
		
		this.registraRespN.addActionListener(e -> {
			ResponsabileEventoNazionale res = new ResponsabileEventoNazionale(
					this.cfN.getText(), this.nameResponsabileN.getText(), this.surnameN.getText(), this.dateN.getText(),
					this.luogoN.getText(), this.numeroTelefonoN.getText(), this.codResponsabileN.getText(), this.usernameN.getText(),
					this.passwordN.getText());
			checkCorrect(res.inserimentoResponsabile());
		});

		this.inserisciAttL.addActionListener(e -> {
			AttivitàLudica attL = new AttivitàLudica(this.codiceAttivitaLudica.getText(),
					this.descrizioneAttivitaLudica.getText());
			checkCorrect(attL.inserimentoAttività());
		});

		this.inserisciAttF.addActionListener(e -> {
			AttivitàFormativa attF = new AttivitàFormativa(this.codiceAttivitaFormativa.getText(),
					this.descrizioneAttivitaFormativa.getText());
			checkCorrect(attF.inserimentoAttività());
		});

		this.registraRespEParr.addActionListener(e -> {
			ResponsabileParrocchia rp = new ResponsabileParrocchia(this.codResponsabile.getText(), this.cf.getText(),
					this.nameResponsabileP.getText(), this.surname.getText(), this.date.getText(), this.luogo.getText(),
					this.numeroTelefono.getText(), this.username.getText(), this.password.getText());
			Parrocchia p = new Parrocchia(this.codParrocchia.getText(), this.nameParrocchia.getText(),
					this.viaP.getText(), this.numCivicoP.getText());
			Residenza res = new Residenza(this.codParrocchia.getText(), this.citta.getSelectedItem().toString());
			ResponsabilitàParrocchia rParrocchia = new ResponsabilitàParrocchia(this.codParrocchia.getText(),
					this.codResponsabile.getText());
			CC comCapi = new CC(this.codiceCC.getText());
			RS roverScolte = new RS(this.codiceRS.getText());
			EG espGuide = new EG(this.codiceEG.getText());
			LC lCoccinelle = new LC(this.codiceLC.getText());
			ContieneCC cc = new ContieneCC(this.codiceCC.getText(), this.codParrocchia.getText());
			ContieneRS rs = new ContieneRS(this.codiceRS.getText(), this.codParrocchia.getText());
			ContieneEG eg = new ContieneEG(this.codiceEG.getText(), this.codParrocchia.getText());
			ContieneLC lc = new ContieneLC(this.codiceLC.getText(), this.codParrocchia.getText());
			if ((rp.registrazioneResponsabile() != 0) && (p.inserisciParrocchia() != 0) && (res.inserisciResidenza() != 0)
					&& (rParrocchia.inserisciResponsabilitàParrocchia() != 0) && (comCapi.inserisciCC() != 0)
					&& (roverScolte.inserisciRS() != 0) && (espGuide.inserisciEG() != 0) && (lCoccinelle.inserisciLC() != 0)
					&& (cc.inserisciContieneCC() != 0) && (rs.inserisciContieneRS() != 0) && (eg.inserisciContieneEG() != 0)
					&& (lc.inserisciContieneLC() != 0)) {
				JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
			} else {
				JOptionPane.showMessageDialog(this, "Si è verificato un errore, ricontrollare la correttezza dei campi.");
			}
		});
		
		this.setLayout(grid);
		this.inserimentoResponsabileParrocchia();
		this.inserimentoParrocchia();
		this.inserimentoResidenza();
		this.inserimentoAttivita();
		this.inserimentoResponsabileNazionale();
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from LUOGO");
			while (rs.next()) {
				this.citta.addItem(rs.getString(1));
			}
			st.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Qualcosa è andato storto con la connessione alla base dati");
		}
	}

	private void inserimentoResponsabileNazionale() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 3;
		c.gridy = 20;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.insertResponsabileN, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 3;
		c.gridy = 21;
		this.add(this.codiceResponsabileN, c);
		c.gridx = 4;
		this.add(this.codResponsabileN, c);
		c.gridx = 3;
		c.gridy = 22;
		this.add(this.codiceFiscaleN, c);
		c.gridx = 4;
		this.add(this.cfN, c);
		c.gridx = 3;
		c.gridy = 23;
		this.add(this.nomeResponsabileN, c);
		c.gridx = 4;
		this.add(this.nameResponsabileN, c);
		c.gridx = 3;
		c.gridy = 24;
		this.add(this.cognomeN, c);
		c.gridx = 4;
		this.add(this.surnameN, c);
		c.gridx = 3;
		c.gridy = 25;
		this.add(this.dataNascitaN, c);
		c.gridx = 4;
		this.add(this.dateN, c);
		c.gridx = 3;
		c.gridy = 26;
		this.add(this.luogoNascitaN, c);
		c.gridx = 4;
		this.add(this.luogoN, c);
		c.gridx = 3;
		c.gridy = 27;
		this.add(this.numTelefonoN, c);
		c.gridx = 4;
		this.add(this.numeroTelefonoN, c);
		c.gridx = 3;
		c.gridy = 28;
		this.add(this.nomeUtenteN, c);
		c.gridx = 4;
		this.add(this.usernameN, c);
		c.gridx = 3;
		c.gridy = 29;
		this.add(this.passwordAssegnataN, c);
		c.gridx = 4;
		this.add(this.passwordN, c);
		c.gridx = 4;
		c.gridy = 30;
		this.add(this.registraRespN, c);

	}

	private void inserimentoAttivita() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 4, 4, 10);
		c.gridx = 0;
		c.gridy = 20;
		this.add(this.attL, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 21;
		this.add(this.codiceAttL, c);
		c.gridy = 22;
		this.add(this.codiceAttivitaLudica, c);
		c.gridy = 23;
		this.add(this.descAttL, c);
		c.fill = UNDEFINED_CONDITION;
		c.gridy = 24;
		this.add(this.descrizioneAttivitaLudica, c);
		c.gridy = 25;
		this.add(this.inserisciAttL, c);
		c.gridx = 0;
		c.gridy = 26;
		this.add(this.attF, c);
		c.gridy = 27;
		this.add(this.codiceAttF, c);
		c.gridy = 28;
		this.add(this.codiceAttivitaFormativa, c);
		c.gridy = 29;
		this.add(this.descAttF, c);
		c.fill = UNDEFINED_CONDITION;
		c.gridy = 30;
		this.add(this.descrizioneAttivitaFormativa, c);
		c.gridy = 31;
		this.add(this.inserisciAttF, c);
	}

	private void inserimentoResidenza() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 4;
		c.gridy = 0;
		this.add(this.residenza, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 4;
		c.gridy = 1;
		this.add(this.cPar, c);
		c.gridx = 5;
		this.add(this.cParrocchia, c);
		c.gridx = 4;
		c.gridy = 2;
		this.add(this.cities, c);
		c.gridx = 5;
		this.add(this.citta, c);
	}

	private void inserimentoParrocchia() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 0;
		this.add(this.insertParrocchia, c);
		c.insets = new Insets(0, 0, 0, 0);
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
		c.gridx = 2;
		c.gridy = 5;
		this.add(this.codiceCCLabel, c);
		c.gridx = 3;
		this.add(this.codiceCC, c);
		c.gridx = 2;
		c.gridy = 6;
		this.add(this.codiceRSLabel, c);
		c.gridx = 3;
		this.add(this.codiceRS, c);
		c.gridx = 2;
		c.gridy = 7;
		this.add(this.codiceEGLabel, c);
		c.gridx = 3;
		this.add(this.codiceEG, c);
		c.gridx = 2;
		c.gridy = 8;
		this.add(this.codiceLCLabel, c);
		c.gridx = 3;
		this.add(this.codiceLC, c);
	}

	private void inserimentoResponsabileParrocchia() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.insertResponsabile, c);
		c.insets = new Insets(0, 0, 0, 0);
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
		c.gridx = 5;
		c.gridy = 10;
		this.add(this.registraRespEParr, c);
	}

	private void checkCorrect(int number) {
		if (number != 0) {
			JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
		} else {
			JOptionPane.showMessageDialog(this, "Qualcosa è andato storto, verifica la correttezza dei campi.");
		}
	}
}