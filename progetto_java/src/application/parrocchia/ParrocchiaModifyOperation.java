package application.parrocchia;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.app.DBConnection;
import table.Acquisizione;
import table.CCAnno;
import table.EGAnno;
import table.EventoParrocchiaEG;
import table.EventoParrocchiaLC;
import table.EventoParrocchiaRS;
import table.EventoParrocchiaTutti;
import table.FormazioneParrocchialeEG;
import table.FormazioneParrocchialeRS;
import table.Iscritto;
import table.LCAnno;
import table.RSAnno;
import table.RegistrazioneEventoParrocchiaEG;
import table.RegistrazioneEventoParrocchiaLC;
import table.RegistrazioneEventoParrocchiaRS;
import table.RegistrazioneEventoParrocchiaTutti;
import table.ResponsabileParrocchia;
import table.RicreazioneEG;
import table.RicreazioneLC;
import table.RicreazioneTutti;

public class ParrocchiaModifyOperation extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 656762902576451100L;
	private ResponsabileParrocchia responsabile;
	private String codiceLC;
	private String codiceRS;
	private String codiceEG;
	private String codiceCC;
	
	//inserimento iscritti
	private static String codiceParrocchia;
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
	private JComboBox<String> codIscB = new JComboBox<>();
	private JLabel brancaI = new JLabel("Branca: ");
	private JComboBox<String> brancheI = new JComboBox<>();
	private JLabel anno = new JLabel("Anno :");
	private JComboBox<String> year = new JComboBox<>();
	private JButton iscrivi = new JButton("Iscrivi");
	
	//assegnamento competenza
	private JLabel assegamento = new JLabel("Assegnamento competenza");
	private JLabel nomeCompetenza = new JLabel("Nome competenza: ");
	private JComboBox<String> nomeComp = new JComboBox<>();
	private JLabel areaCompetenza = new JLabel("Area competenza: ");
	private JComboBox<String> areaComp = new JComboBox<>();
	private JLabel codiceIscritto = new JLabel("Codice iscritto: ");
	private JComboBox<String> codIsc = new JComboBox<>();
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
	private JComboBox<String> codEventoL = new JComboBox<>();
	private JLabel attL= new JLabel("Attività ludica: ");
	private JLabel brancaL= new JLabel("Attività ludica: ");
	private JComboBox<String> brancheL = new JComboBox<>();
	private JButton assegnaAttL = new JButton("Assegna attività ludica");
	
	//attività formativa
	private JLabel attivitàFormativa = new JLabel("Assegnamento attività formativa");
	private JLabel codiceEventoF= new JLabel("Codice evento: ");
	private JComboBox<String> codEventoF = new JComboBox<>();
	private JLabel attF= new JLabel("Attività formativa: ");
	private JLabel brancaF= new JLabel("Attività formativa: ");
	private JComboBox<String> brancheF = new JComboBox<>();
	private JButton assegnaAttF = new JButton("Assegna attività formativa");
	
	//cancellazione evento
	private JLabel cancellaEvento = new JLabel("Cancellazione evento");
	private JLabel codEventoParrocchia = new JLabel("Evento: ");
	private JComboBox<String> codE = new JComboBox<>();
	private JButton cancella = new JButton("Cancella");
	
	//registrazione iscritto ad evento
	private JLabel registrazioneIscritto = new JLabel("Registrazione iscritto ad evento");
	private JLabel codEventoParr = new JLabel("Codice evento: ");
	private JComboBox<String> codiceEP = new JComboBox<>();
	private JLabel codIscr = new JLabel("Codice Iscritto: ");
	private JComboBox<String> cIscr= new JComboBox<>();
	private JLabel codiceRegistrazione = new JLabel("Codice registrazione: ");
	private JTextField codReg = new JTextField(16);
	private JLabel brancaE = new JLabel("Branca: ");
	private JComboBox<String> brancheE = new JComboBox<>();
	private JButton iscriviEvento = new JButton("Iscrivi a evento");
	
	public ParrocchiaModifyOperation(DBConnection con, ResponsabileParrocchia responsabileParrocchia) {
		this.responsabile = responsabileParrocchia;
		GridBagLayout grid = new GridBagLayout();
		this.setLayout(grid);
		brancheF.addItem("RS");
		brancheF.addItem("EG");
		brancheL.addItem("EG");
		brancheL.addItem("LC");
		brancheL.addItem("Tutti");
		branca.addItem("LC");
		branca.addItem("EG");
		branca.addItem("RS");
		branca.addItem("Tutti");
		brancheI.addItem("LC");
		brancheI.addItem("EG");
		brancheI.addItem("RS");
		brancheI.addItem("CC");
		brancheE.addItem("LC");
		brancheE.addItem("EG");
		brancheE.addItem("RS");
		brancheE.addItem("Tutti");
		this.attLudicaE.setEnabled(true);
		this.attFormativaE.setEnabled(false);
		year.addItem("2018");
		this.attLudicaE.addItem(" ");
		this.attLudicaE.setSelectedIndex(0);
		this.attFormativaE.addItem(" ");
		this.attFormativaE.setSelectedIndex(0);
		this.nomeComp.addActionListener(e -> {
			this.areaComp.removeAllItems();
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select areaCompetenza from COMPETENZE where nomeCompetenza = ?");
				st.setString(1, String.valueOf(this.nomeComp.getSelectedItem()));
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					this.areaComp.addItem(rs.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		this.inserimentoEvento();
		this.registrazioneIscrittoBranca();
		this.registrazioneIscritto();
		this.assegnamentoCompetenza();
		this.inserimentoEvento();
		this.assegnamentoAttività();
		this.registrazioneIscrittoEvento();
		this.cancellazioneEvento();
		this.brancheF.addActionListener(e -> {
			if(String.valueOf(this.brancheF.getSelectedItem()).equals("EG")){
				try {
					PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
					st.setString(1, codiceParrocchia);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						this.codEventoF.addItem(rs.getString(1));
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			else if(String.valueOf(this.brancheF.getSelectedItem()).equals("RS")){
				try {
					PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_RS where codiceParrocchia = ?");
					st.setString(1, codiceParrocchia);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						this.codEventoF.addItem(rs.getString(1));
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		this.brancheL.addActionListener(e -> {
			if(String.valueOf(this.brancheL.getSelectedItem()).equals("EG")) {
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_EG where codiceParrocchia = ?");
				st.setString(1, codiceParrocchia);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					this.codEventoL.addItem(rs.getString(1));
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
			else if(String.valueOf(this.brancheL.getSelectedItem()).equals("LC")) {
				try {
					PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC where codiceParrocchia = ?");
					st.setString(1, codiceParrocchia);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						this.codEventoL.addItem(rs.getString(1));
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			else if(String.valueOf(this.brancheL.getSelectedItem()).equals("Tutti")) {
				try {
					PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_TUTTI where codiceParrocchia = ?");
					st.setString(1, codiceParrocchia);
					ResultSet rs = st.executeQuery();
					while (rs.next()) {
						this.codEventoL.addItem(rs.getString(1));
						
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceParrocchia from Responsabilità_parrocchia where codiceResponsabile = ?");
			st.setString(1, this.responsabile.getCodiceResponsabile());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				codiceParrocchia = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceLC from Contiene_LC where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				this.codiceLC = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_TUTTI");
			while (rs.next()) {
				this.codiceEP.addItem(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_RS");
			while (rs.next()) {
				this.codiceEP.addItem(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_EG");
			while (rs.next()) {
				this.codiceEP.addItem(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_LC");
			while (rs.next()) {
				this.codiceEP.addItem(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEG from Contiene_EG where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				this.codiceEG = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceRS from Contiene_RS where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				this.codiceRS = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceIscritto from Iscritto");
			while (rs.next()) {
				this.cIscr.addItem(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceCC from Contiene_CC where codiceParrocchia = ?");
			st.setString(1, codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				this.codiceCC = rs.getString(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceAttività from ATT_FORMATIVA");
			while (rs.next()) {
				this.attFormativa.addItem(rs.getString(1));
				this.attFormativaE.addItem(rs.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceAttività from ATT_LUDICA");
			while (rs.next()) {
				this.attLudica.addItem(rs.getString(1));
				this.attLudicaE.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select nomeCompetenza from COMPETENZE");
			while (rs.next()) {
				this.nomeComp.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceIscritto from ISCRITTO");
			while (rs.next()) {
				this.codIsc.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_LC");
			while (rs.next()) {
				this.codE.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_EG");
			while (rs.next()) {
				this.codE.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_RS");
			while (rs.next()) {
				this.codE.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceEvento from E_P_TUTTI");
			while (rs.next()) {
				this.codE.addItem(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*try {
			PreparedStatement st = con.getMsSQLConnection().prepareStatement("select codiceEvento from E_P_LC, E_P_EG, E_P_RS, E_P_TUTTI where codiceParrocchia = ?");
			st.setString(1, this.codiceParrocchia);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int i = 1;
				this.codE.addItem(rs.getString(i));	
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		
		
		
		
		try {
			Statement st = con.getMsSQLConnection().createStatement();
			ResultSet rs = st.executeQuery("select codiceIscritto from ISCRITTO");
			while (rs.next()) {
				this.codIscB.addItem(rs.getString(1)); 				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.assegnaAttL.addActionListener(e -> {
			if(String.valueOf(this.brancheL.getSelectedItem()).equals("LC")) {
				RicreazioneLC rLC = new RicreazioneLC(String.valueOf(this.codEventoL.getSelectedItem()), 
						String.valueOf(this.attLudica.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(rLC.assegnamentoAttivitàRicreativaLC());
			}
			else if(String.valueOf(this.brancheL.getSelectedItem()).equals("EG")) {
				RicreazioneEG rEG = new RicreazioneEG(String.valueOf(this.codEventoL.getSelectedItem()), 
						String.valueOf(this.attLudica.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(rEG.assegnamentoAttivitàRicreativaEG());
			}
			else if(String.valueOf(this.brancheL.getSelectedItem()).equals("Tutti")) {
				RicreazioneTutti rT = new RicreazioneTutti(String.valueOf(this.codEventoL.getSelectedItem()), 
						String.valueOf(this.attLudica.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(rT.assegnamentoAttivitàRicreativaTutti());
			}
			
		});
		this.assegnaAttF.addActionListener(e -> {
			if(String.valueOf(this.brancheF.getSelectedItem()).equals("RS")) {
				FormazioneParrocchialeRS fpRS = new FormazioneParrocchialeRS(String.valueOf(this.codEventoF.getSelectedItem()), 
						String.valueOf(this.attFormativa.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(fpRS.assegnamentoAttivitàFormativaRS());
			}
			else if(String.valueOf(this.brancheF.getSelectedItem()).equals("EG")) {
				FormazioneParrocchialeEG fpEG = new FormazioneParrocchialeEG(String.valueOf(this.codEventoF.getSelectedItem()), 
						String.valueOf(this.attFormativa.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(fpEG.assegnamentoAttivitàFormativaEG());
			}
		});
		
		this.branca.addActionListener(e -> {
			if(String.valueOf(branca.getSelectedItem()).equals("LC")) {
				this.attFormativaE.setEnabled(false);
				this.attLudicaE.setEnabled(true);
			}
			else if(String.valueOf(branca.getSelectedItem()).equals("EG")) {
				this.attFormativaE.setEnabled(true);
				this.attLudicaE.setEnabled(true);
			}
			else if(String.valueOf(branca.getSelectedItem()).equals("RS")) {
				this.attFormativaE.setEnabled(true);
				this.attLudicaE.setEnabled(false);
			}
			else if(String.valueOf(branca.getSelectedItem()).equals("Tutti")) {
				this.attFormativaE.setEnabled(false);
				this.attLudicaE.setEnabled(true);
			}
		});
		
		this.inserisciEvento.addActionListener(e -> {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				java.util.Date parsedInizio;
				parsedInizio = sdf.parse(this.dInizio.getText());
				Date dateInizio = new java.sql.Date(parsedInizio.getTime());
				java.util.Date parsedFine;
				parsedFine = sdf.parse(this.dFine.getText());
				Date dateFine = new java.sql.Date(parsedFine.getTime());
				if(String.valueOf(branca.getSelectedItem()).equals("LC")) {
					EventoParrocchiaLC eventoLC = new EventoParrocchiaLC(codiceParrocchia, codEvento.getText(), tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					checkCorrect(eventoLC.inserimentoEvento());
				}
				else if(String.valueOf(branca.getSelectedItem()).equals("EG")) {
					EventoParrocchiaEG eventoEG = new EventoParrocchiaEG(codiceParrocchia, codEvento.getText(), tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					checkCorrect(eventoEG.inserimentoEvento());
				}
				else if(String.valueOf(branca.getSelectedItem()).equals("RS")) {
					this.attLudicaE.setEnabled(false);
					EventoParrocchiaRS eventoRS = new EventoParrocchiaRS(codiceParrocchia, codEvento.getText(), tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					checkCorrect(eventoRS.inserimentoEvento());
				}
				else if(String.valueOf(branca.getSelectedItem()).equals("Tutti")) {
					this.attFormativaE.setEnabled(false);
					EventoParrocchiaTutti eventoTutti = new EventoParrocchiaTutti(codiceParrocchia, codEvento.getText(), tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					checkCorrect(eventoTutti.inserimentoEvento());
				}
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		});
		
		this.registraIscritto.addActionListener(e -> {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				java.util.Date parsed;
				parsed = sdf.parse(this.iscDataN.getText());
				Date datesql = new java.sql.Date(parsed.getTime());
				Iscritto is = new Iscritto(this.iscCodice.getText(), this.iscCF.getText(), this.iscNome.getText(), this.iscCognome.getText(), datesql, this.iscLuogoN.getText(), this.iscNTelefono.getText());
				checkCorrect(is.registrazioneIscritto());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		});
		
		this.iscrivi.addActionListener(e -> {
			if(String.valueOf(brancheI.getSelectedItem()).equals("LC")) {
				LCAnno lc = new LCAnno(this.codiceLC, String.valueOf(this.codIscB.getSelectedItem()), Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
				checkCorrect(lc.iscrizioneLC());
			}
			else if(String.valueOf(brancheI.getSelectedItem()).equals("EG")) {
				EGAnno eg = new EGAnno(this.codiceEG, String.valueOf(this.codIscB.getSelectedItem()), Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
				checkCorrect(eg.iscrizioneEG());
			}
			else if(String.valueOf(brancheI.getSelectedItem()).equals("RS")) {
				RSAnno rs = new RSAnno(this.codiceRS, String.valueOf(this.codIscB.getSelectedItem()), Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
				checkCorrect(rs.iscrizioneRS());
			}
			else if(String.valueOf(brancheI.getSelectedItem()).equals("CC")) {
				CCAnno cc = new CCAnno(this.codiceCC, String.valueOf(this.codIscB.getSelectedItem()), Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
				checkCorrect(cc.iscrizioneCC());
			}
		});
		
		this.iscriviEvento.addActionListener(e -> {
			if(String.valueOf(brancheE.getSelectedItem()).equals("LC")) {
				RegistrazioneEventoParrocchiaLC regLC = new RegistrazioneEventoParrocchiaLC(String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()), codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regLC.registrazioneEventoLC());
			}
			else if(String.valueOf(brancheE.getSelectedItem()).equals("EG")) {
				RegistrazioneEventoParrocchiaEG regEG = new RegistrazioneEventoParrocchiaEG(String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()), codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regEG.registrazioneEventoEG());
			}
			else if(String.valueOf(brancheE.getSelectedItem()).equals("RS")) {
				RegistrazioneEventoParrocchiaRS regRS = new RegistrazioneEventoParrocchiaRS(String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()), codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regRS.registrazioneEventoRS());
			}
			else if(String.valueOf(brancheE.getSelectedItem()).equals("Tutti")) {
				RegistrazioneEventoParrocchiaTutti regTutti = new RegistrazioneEventoParrocchiaTutti(String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()), codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regTutti.registrazioneEventoTutti());
			}
		});
		
		this.assegnaCompetenza.addActionListener(e -> {
			Acquisizione ac = new Acquisizione(String.valueOf(this.nomeComp.getSelectedItem()), String.valueOf(this.areaComp.getSelectedItem()), String.valueOf(this.codIsc.getSelectedItem()));
			this.checkCorrect(ac.acquisizione());
		});

		this.cancella.addActionListener(e -> {
			/*
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_TUTTI where codiceEvento = ?");
				st.setString(1, String.valueOf(this.codE.getSelectedItem()));
				ResultSet rs = st.executeQuery();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_RS where codiceEvento = ?");
				st.setString(1, String.valueOf(this.codE.getSelectedItem()));
				ResultSet rs = st.executeQuery();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_EG where codiceEvento = ?");
				st.setString(1, String.valueOf(this.codE.getSelectedItem()));
				ResultSet rs = st.executeQuery();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PreparedStatement st = con.getMsSQLConnection().prepareStatement("delete from E_P_LC where codiceEvento = ?");
				st.setString(1, String.valueOf(this.codE.getSelectedItem()));
				ResultSet rs = st.executeQuery();
				st.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			*/		
		});
	}
	
	private void assegnamentoAttività() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 4, 4, 10);
		c.gridx = 0;
		c.gridy = 22;
		this.add(this.attivitàLudica, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 23;
		this.add(this.brancaL, c);
		c.gridy = 24;
		this.add(this.brancheL, c);
		c.gridy = 25;
		this.add(this.codiceEventoL, c);
		c.gridy = 26;
		this.add(this.codEventoL, c);
		c.gridy = 27;
		this.add(this.attL, c);
		c.gridy = 28;
		this.add(this.attLudica, c);
		c.gridy = 29;
		this.add(this.assegnaAttL, c);
		c.gridx = 1;
		c.gridy = 22;
		this.add(this.attivitàFormativa, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy = 23;
		this.add(this.brancaF, c);
		c.gridy = 24;
		this.add(this.brancheF, c);
		c.gridy = 25;
		this.add(this.codiceEventoF, c);
		c.gridy = 26;
		this.add(this.codEventoF, c);
		c.gridy = 27;
		this.add(this.attF, c);
		c.gridy = 28;
		this.add(this.attFormativa, c);
		c.gridy = 29;
		this.add(this.assegnaAttF, c);
		
		
	}
	
	private void inserimentoEvento() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(0, 10, 10, 10);
		c.gridx = 6;
		c.gridy = 0;
		this.add(this.evento, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 6;
		c.gridy = 1;
		this.add(this.codiceEvento, c);
		c.gridx = 7;
		this.add(this.codEvento, c);
		c.gridx = 6;
		c.gridy = 2;
		this.add(this.dataInizio, c);
		c.gridx = 7;
		this.add(this.dInizio, c);
		c.gridx = 6;
		c.gridy = 3;
		this.add(this.dataFine, c);
		c.gridx = 7;
		this.add(this.dFine, c);
		c.gridx = 6;
		c.gridy = 4;
		this.add(this.tipologia, c);
		c.gridx = 7;
		this.add(this.tipo, c);
		c.gridx = 6;
		c.gridy = 5;
		this.add(this.località, c);
		c.gridx = 7;
		this.add(this.loc, c);
		c.gridx = 6;
		c.gridy = 6;
		this.add(this.branche, c);
		c.gridx = 7;
		this.add(this.branca, c);
		c.gridx = 6;
		c.gridy = 7;
		this.add(attLE, c);
		c.gridx = 7;
		this.add(this.attLudicaE, c);
		c.gridx = 6;
		c.gridy = 8;
		this.add(attFE, c);
		c.gridx = 7;
		this.add(this.attFormativaE, c);
		c.gridx = 6;
		c.gridy = 9;
		this.add(this.descrizione, c);
		c.gridx = 7;
		this.add(this.desc, c);
		c.gridx = 6;
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
		
	}
	
	private void registrazioneIscritto() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 2;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.registrazioneIscritti, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.iscrittoCodice, c);
		c.gridx = 3;
		this.add(this.iscCodice, c);
		c.gridx = 2;
		c.gridy = 2;
		this.add(this.iscrittoCF, c);
		c.gridx = 3;
		this.add(this.iscCF, c);
		c.gridx = 2;
		c.gridy = 3;
		this.add(this.iscrittoNome, c);
		c.gridx = 3;
		this.add(this.iscNome, c);
		c.gridx = 2;
		c.gridy = 4;
		this.add(this.iscrittoCognome, c);
		c.gridx = 3;
		this.add(this.iscCognome, c);
		c.gridx = 2;
		c.gridy = 5;
		this.add(this.iscrittoDataN, c);
		c.gridx = 3;
		this.add(this.iscDataN, c);
		c.gridx = 2;
		c.gridy = 6;
		this.add(this.iscrittoLuogoN, c);
		c.gridx = 3;
		this.add(this.iscLuogoN, c);
		c.gridx = 2;
		c.gridy = 7;
		this.add(this.iscrittoNTelefono, c);
		c.gridx = 3;
		this.add(this.iscNTelefono, c);
		c.gridx = 2;
		c.gridy = 8;
		this.add(this.registraIscritto, c);
		
	}
	
	private void registrazioneIscrittoBranca() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 4;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.iscrizione, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 4;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codIscritto, c);
		c.gridx = 5;
		this.add(this.codIscB, c);
		c.gridx = 4;
		c.gridy = 2;
		this.add(this.brancaI, c);
		c.gridx = 5;
		this.add(this.brancheI, c);
		c.gridx = 4;
		c.gridy = 3;
		this.add(this.anno, c);
		c.gridx = 5;
		this.add(this.year, c);
		c.gridx = 4;
		c.gridy = 8;
		this.add(this.iscrivi, c);
		
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
		c.gridy = 4;
		this.add(this.brancaE, c);
		c.gridx = 9;
		this.add(this.brancheE, c);
		c.gridx = 8;
		c.gridy = 8;
		this.add(this.iscriviEvento, c);
		
	}
	
	private void cancellazioneEvento() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 4;
		c.gridy = 22;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.cancellaEvento, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 4;
		c.gridy = 23;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codEventoParrocchia, c);
		c.gridx = 5;
		this.add(this.codE, c);
		c.gridx = 4;
		c.gridy = 27;
		this.add(this.cancella, c);
	}
	
	private void checkCorrect(int number) {
		if (number != 0) {
			JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
		} else {
			JOptionPane.showMessageDialog(this, "Qualcosa è andato storto, verifica la correttezza dei campi.");
		}
	}
	
	public static String getCodiceParrocchia() {
		return codiceParrocchia;
	}

}
