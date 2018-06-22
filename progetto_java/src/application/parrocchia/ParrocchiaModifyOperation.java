package application.parrocchia;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import application.app.DBConnection;
import table.EventoParrocchiaLC;

public class ParrocchiaModifyOperation extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 656762902576451100L;
	
	//inserimento iscritti
	private String codiceParrocchia;
	private JLabel registrazioneIscritti = new JLabel("Registrazione iscritti");
	private JLabel iscrittoCodice = new JLabel("Codice iscrizione :");
	private JTextField iscCodice = new JTextField(16);
	private JLabel iscrittoCF = new JLabel("Codice fiscale: ");
	private JTextField iscCF = new JTextField(16);
	private JLabel iscrittoNome = new JLabel("Nome iscritto: ");
	private JTextField iscNome = new JTextField(16);
	private JLabel iscrittoCognome = new JLabel("Cognome iscritto: ");
	private JTextField iscCognome = new JTextField(16);
	private JLabel iscrittoDataN = new JLabel("Data nascita iscritto: ");
	private JTextField iscDataN = new JTextField(16);
	private JLabel iscrittoLuogoN = new JLabel("Luogo nascita iscritto: ");
	private JTextField iscLuogoN = new JTextField(16);
	private JLabel iscrittoNTelefono = new JLabel("Numero telefono iscritto: ");
	private JTextField iscNTelefono = new JTextField(16);
	private JButton registraIscritto = new JButton("Registra iscritto");
	
	// registrazioni iscritti alle branche
	private JLabel iscrizione = new JLabel("Registrazione iscritto alla branca");
	private JLabel codIscritto = new JLabel("Codice iscritto: ");
	private JTextField codIscB = new JTextField(16);
	private JLabel codNazionale = new JLabel("Codice branca: ");
	private JTextField codN = new JTextField(16);
	private JLabel anno = new JLabel("Anno :");
	private JTextField year = new JTextField(16);
	private JButton iscrivi = new JButton("Iscrivi");
	
	//assegnamento competenza
	private JLabel assegamento = new JLabel("Assegnamento competenza");
	private JLabel nomeCompetenza = new JLabel("Nome competenza: ");
	private JTextField nomeComp = new JTextField(16);
	private JLabel areaCompetenza = new JLabel("Area competenza: ");
	private JTextField areaComp = new JTextField(16);
	private JLabel codiceIscritto = new JLabel("Codice iscritto: ");
	private JTextField codIsc = new JTextField(16);
	private JButton assegnaCompetenza = new JButton("Assegna competenza");
	
	//inserimento evento
	private JLabel evento = new JLabel("Inserimento evento di parrocchia");
	private JLabel codiceEvento= new JLabel("Codice evento: ");
	private JTextField codEvento = new JTextField(16);
	private JLabel dataInizio = new JLabel("Data inizio: ");
	private JTextField dInizio = new JTextField(16);
	private JLabel dataFine= new JLabel("Data fine: ");
	private JTextField dFine = new JTextField(16);
	private JLabel tipologia = new JLabel("Tipo: ");
	private JTextField tipo = new JTextField(16);
	private JLabel località = new JLabel("Località: ");
	private JTextField loc = new JTextField(16);
	private JLabel descrizione = new JLabel("Descrizione: ");
	private JTextField desc = new JTextField(16);
	private JLabel branche = new JLabel("Branca: ");
	private JLabel attLE= new JLabel("Attività ludica: ");
	private JLabel attFE= new JLabel("Attività formativa: ");
	private JComboBox<String> attLudicaE = new JComboBox<>();
	private JComboBox<String> attFormativaE = new JComboBox<>();
	private JComboBox<String> attLudica = new JComboBox<>();
	private JComboBox<String> attFormativa = new JComboBox<>();
	private JComboBox<String> branca = new JComboBox<>();
	private JButton inserisciEvento = new JButton("Inserisci evento");
	
	//assegnamento attività ludica
	private JLabel attivitàLudica = new JLabel("Assegnamento attività ludica");
	private JLabel codiceEventoL= new JLabel("Codice evento: ");
	private JTextField codEventoL = new JTextField(16);
	private JLabel attL= new JLabel("Attività ludica: ");
	private JButton assegnaAttL = new JButton("Assegna attività ludica");
	
	//attività formativa
	private JLabel attivitàFormativa = new JLabel("Assegnamento attività formativa");
	private JLabel codiceEventoF= new JLabel("Codice evento: ");
	private JTextField codEventoF = new JTextField(16);
	private JLabel attF= new JLabel("Attività formativa: ");
	private JButton assegnaAttF = new JButton("Assegna attività formativa");
	
	//cancellazione evento
	private JLabel cancellaEvento = new JLabel("Cancellazione evento");
	private JLabel codEventoParrocchia = new JLabel("Codice evento: ");
	private JTextField codEP= new JTextField(16);
	private JButton cancella = new JButton("Cancella");
	
	//registrazione iscritto ad evento
	private JLabel registrazioneIscritto = new JLabel("Registrazione iscritto ad evento");
	private JLabel codEventoParr = new JLabel("Codice evento: ");
	private JTextField codiceEP = new JTextField(16);
	private JLabel codIscr = new JLabel("Codice Iscritto: ");
	private JTextField cIscr= new JTextField(16);
	private JLabel codiceRegistrazione = new JLabel("Codice registrazione: ");
	private JTextField codReg = new JTextField(16);
	private JButton iscriviEvento = new JButton("Iscrivi a evento");
	
	public ParrocchiaModifyOperation(DBConnection con) {
		GridBagLayout grid = new GridBagLayout();
		this.setLayout(grid);
		branca.addItem("LC");
		branca.addItem("EG");
		branca.addItem("RS");
		this.inserimentoEvento();
		this.registrazioneIscrittoBranca();
		this.registrazioneIscritto();
		this.assegnamentoCompetenza();
		this.inserimentoEvento();
		this.assegnamentoAttività();
		this.registrazioneIscrittoEvento();
		this.cancellazioneEvento();
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from ATT_FORMATIVA");
			while (rs.next()) {
				int i = 1;
				this.attFormativa.addItem(rs.getString(i));
				i++;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceParrocchia from PARROCCHIA, RESPONSABILE_P where username = 'parrocchia'");
			while (rs.next()) {
				this.codiceParrocchia = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.assegnaAttL.addActionListener(e -> {
			
		});
		this.assegnaAttF.addActionListener(e -> {
			
		});
		this.inserisciEvento.addActionListener(e -> {
			if(branca.getSelectedItem().equals("LC")) {
				EventoParrocchiaLC eventoLC = new EventoParrocchiaLC(this.codiceParrocchia, codEvento.getText(), tipo.getText(), dInizio.getText(), dFine.getText(), loc.getText(), desc.getText());
				checkCorrect(eventoLC.inserimentoEvento());
			}
			
		});
	}
	
	private void assegnamentoAttività() {
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(0, 4, 4, 10);
		c.gridx = 0;
		c.gridy = 22;
		this.add(this.attivitàLudica, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 23;
		this.add(this.codiceEventoL, c);
		c.gridy = 24;
		this.add(this.codEventoL, c);
		c.gridy = 25;
		this.add(this.attL, c);
		c.gridy = 26;
		this.add(this.attLudica, c);
		c.gridy = 28;
		this.add(this.assegnaAttL, c);
		c.gridx = 1;
		c.gridy = 22;
		this.add(this.attivitàFormativa, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 23;
		this.add(this.codiceEventoF, c);
		c.gridy = 24;
		this.add(this.codEventoF, c);
		c.gridy = 25;
		this.add(this.attF, c);
		c.gridy = 26;
		this.add(this.attFormativa, c);
		c.gridy = 28;
		this.add(this.assegnaAttF, c);
		
		
	}
	
	private void inserimentoEvento() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 4;
		c.gridy = 0;
		this.add(this.evento, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 4;
		c.gridy = 1;
		this.add(this.codiceEvento, c);
		c.gridx = 5;
		this.add(this.codEvento, c);
		c.gridx = 4;
		c.gridy = 2;
		this.add(this.dataInizio, c);
		c.gridx = 5;
		this.add(this.dInizio, c);
		c.gridx = 4;
		c.gridy = 3;
		this.add(this.dataFine, c);
		c.gridx = 5;
		this.add(this.dFine, c);
		c.gridx = 4;
		c.gridy = 4;
		this.add(this.tipologia, c);
		c.gridx = 5;
		this.add(this.tipo, c);
		c.gridx = 4;
		c.gridy = 5;
		this.add(this.località, c);
		c.gridx = 5;
		this.add(this.loc, c);
		c.gridx = 4;
		c.gridy = 6;
		this.add(this.branche, c);
		c.gridx = 5;
		this.add(this.branca, c);
		c.gridx = 4;
		c.gridy = 7;
		this.add(attLE, c);
		c.gridx = 5;
		this.add(this.attLudicaE, c);
		c.gridx = 4;
		c.gridy = 8;
		this.add(attFE, c);
		c.gridx = 5;
		this.add(this.attFormativaE, c);
		c.gridx = 4;
		c.gridy = 9;
		this.add(this.descrizione, c);
		c.gridx = 5;
		this.add(this.desc, c);
		c.gridx = 4;
		c.gridy = 20;
		this.add(this.inserisciEvento, c);
		
	}
	
	private void assegnamentoCompetenza() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 2;
		c.gridy = 22;
		this.add(this.assegamento, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridy = 23;
		this.add(this.nomeCompetenza, c);
		c.gridx = 3;
		this.add(this.nomeComp, c);
		c.gridx = 2;
		c.gridy = 24;
		this.add(this.areaCompetenza, c);
		c.gridx = 3;
		this.add(this.areaComp, c);
		c.gridx = 2;
		c.gridy = 25;
		this.add(this.codiceIscritto, c);
		c.gridx = 3;
		this.add(this.codIsc, c);
		c.gridx = 2;
		c.gridy = 27;
		this.add(this.assegnaCompetenza, c);
		this.assegnaCompetenza.addActionListener(e -> {
			
		});
	}
	
	private void registrazioneIscritto() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.registrazioneIscritti, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.iscrittoCodice, c);
		c.gridx = 1;
		this.add(this.iscCodice, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(this.iscrittoCF, c);
		c.gridx = 1;
		this.add(this.iscCF, c);
		c.gridx = 0;
		c.gridy = 3;
		this.add(this.iscrittoNome, c);
		c.gridx = 1;
		this.add(this.iscNome, c);
		c.gridx = 0;
		c.gridy = 4;
		this.add(this.iscrittoCognome, c);
		c.gridx = 1;
		this.add(this.iscCognome, c);
		c.gridx = 0;
		c.gridy = 5;
		this.add(this.iscrittoDataN, c);
		c.gridx = 1;
		this.add(this.iscDataN, c);
		c.gridx = 0;
		c.gridy = 6;
		this.add(this.iscrittoLuogoN, c);
		c.gridx = 1;
		this.add(this.iscLuogoN, c);
		c.gridx = 0;
		c.gridy = 7;
		this.add(this.iscrittoNTelefono, c);
		c.gridx = 1;
		this.add(this.iscNTelefono, c);
		c.gridx = 0;
		c.gridy = 8;
		this.add(this.registraIscritto, c);
		this.registraIscritto.addActionListener(e -> {
			
		});
	}
	
	private void registrazioneIscrittoBranca() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 2;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.iscrizione, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codIscritto, c);
		c.gridx = 3;
		this.add(this.codIscB, c);
		c.gridx = 2;
		c.gridy = 2;
		this.add(this.codNazionale, c);
		c.gridx = 3;
		this.add(this.codN, c);
		c.gridx = 2;
		c.gridy = 3;
		this.add(this.anno, c);
		c.gridx = 3;
		this.add(this.year, c);
		c.gridx = 2;
		c.gridy = 8;
		this.add(this.iscrivi, c);
		this.iscrivi.addActionListener(e -> {
			
		});
	}
	
	private void registrazioneIscrittoEvento() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 8;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.registrazioneIscritto, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 8;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codEventoParr, c);
		c.gridx = 9;
		this.add(this.codiceEP, c);
		c.gridx = 8;
		c.gridy = 2;
		this.add(this.codIscr, c);
		c.gridx = 9;
		this.add(this.cIscr, c);
		c.gridx = 8;
		c.gridy = 3;
		this.add(this.codiceRegistrazione, c);
		c.gridx = 9;
		this.add(this.codReg, c);
		c.gridx = 8;
		c.gridy = 8;
		this.add(this.iscriviEvento, c);
		this.iscriviEvento.addActionListener(e -> {
			
		});
	}
	
	private void cancellazioneEvento() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 6;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.cancellaEvento, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 6;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codEventoParrocchia, c);
		c.gridx = 7;
		this.add(this.codEP, c);
		c.gridx = 6;
		c.gridy = 8;
		this.add(this.cancella, c);
		this.cancella.addActionListener(e -> {
			
		});
	}
	
	private void checkCorrect(int number) {
		if (number != 0) {
			JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
		} else {
			JOptionPane.showMessageDialog(this, "Qualcosa è andato storto, verifica la correttezza dei campi.");
		}
	}

}
