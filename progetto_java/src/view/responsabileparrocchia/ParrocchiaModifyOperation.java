package view.responsabileparrocchia;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Acquisizione;
import model.CCAnno;
import model.DBConnection;
import model.EGAnno;
import model.EventoParrocchiaEG;
import model.EventoParrocchiaLC;
import model.EventoParrocchiaRS;
import model.EventoParrocchiaTutti;
import model.FormazioneParrocchialeEG;
import model.FormazioneParrocchialeRS;
import model.Iscritto;
import model.LCAnno;
import model.ParrocchiaDeleteOperation;
import model.QueryParrocchia;
import model.RSAnno;
import model.RegistrazioneEventoParrocchiaEG;
import model.RegistrazioneEventoParrocchiaLC;
import model.RegistrazioneEventoParrocchiaRS;
import model.RegistrazioneEventoParrocchiaTutti;
import model.ResponsabileParrocchia;
import model.ResponsabilitàEventoParrocchiaEG;
import model.ResponsabilitàEventoParrocchiaLC;
import model.ResponsabilitàEventoParrocchiaRS;
import model.ResponsabilitàEventoParrocchiaTutti;
import model.RicreazioneEG;
import model.RicreazioneLC;
import model.RicreazioneTutti;
import model.UpdateComboBoxParrocchia;

public class ParrocchiaModifyOperation extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 656762902576451100L;
	private ResponsabileParrocchia responsabile;
	private String codiceLC;
	private String codiceRS;
	private String codiceEG;
	private String codiceCC;

	// inserimento iscritti
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
	private JComboBox<String> codIscB = new JComboBox<>();
	private JLabel brancaI = new JLabel("Branca: ");
	private JComboBox<String> brancheI = new JComboBox<>();
	private JLabel anno = new JLabel("Anno :");
	private JComboBox<String> year = new JComboBox<>();
	private JButton iscrivi = new JButton("Iscrivi");

	// assegnamento competenza
	private JLabel assegamento = new JLabel("Assegnamento competenza");
	private JLabel nomeCompetenza = new JLabel("Nome competenza: ");
	private JComboBox<String> nomeComp = new JComboBox<>();
	private JLabel areaCompetenza = new JLabel("Area competenza: ");
	private JComboBox<String> areaComp = new JComboBox<>();
	private JLabel codiceIscritto = new JLabel("Codice iscritto: ");
	private JComboBox<String> codIsc = new JComboBox<>();
	private JButton assegnaCompetenza = new JButton("Assegna competenza");

	// inserimento evento
	private JLabel evento = new JLabel("Inserimento evento di parrocchia");
	private JLabel codiceEvento = new JLabel("Codice evento: ");
	private JTextField codEvento = new JTextField(16);
	private JLabel dataInizio = new JLabel("Data inizio: ");
	private JTextField dInizio = new JTextField(16);
	private JLabel dataFine = new JLabel("Data fine: ");
	private JTextField dFine = new JTextField(16);
	private JLabel tipologia = new JLabel("Tipo: ");
	private JTextField tipo = new JTextField(16);
	private JLabel località = new JLabel("Località: ");
	private JTextField loc = new JTextField(16);
	private JLabel descrizione = new JLabel("Descrizione: ");
	private JTextField desc = new JTextField(16);
	private JLabel branche = new JLabel("Branca: ");
	private JLabel attLE = new JLabel("Attività ludica: ");
	private JLabel attFE = new JLabel("Attività formativa: ");
	private JComboBox<String> attLudicaE = new JComboBox<>();
	private JComboBox<String> attFormativaE = new JComboBox<>();
	private JComboBox<String> attLudica = new JComboBox<>();
	private JComboBox<String> attFormativa = new JComboBox<>();
	private JComboBox<String> branca = new JComboBox<>();
	private JButton inserisciEvento = new JButton("Inserisci evento");

	// assegnamento attività ludica
	private JLabel attivitàLudica = new JLabel("Assegnamento attività ludica");
	private JLabel codiceEventoL = new JLabel("Codice evento: ");
	private JComboBox<String> codEventoL = new JComboBox<>();
	private JLabel attL = new JLabel("Attività ludica: ");
	private JLabel brancaL = new JLabel("Branca: ");
	private JComboBox<String> brancheL = new JComboBox<>();
	private JButton assegnaAttL = new JButton("Assegna attività ludica");

	// attività formativa
	private JLabel attivitàFormativa = new JLabel("Assegnamento attività formativa");
	private JLabel codiceEventoF = new JLabel("Codice evento: ");
	private JComboBox<String> codEventoF = new JComboBox<>();
	private JLabel attF = new JLabel("Attività formativa: ");
	private JLabel brancaF = new JLabel("Branca: ");
	private JComboBox<String> brancheF = new JComboBox<>();
	private JButton assegnaAttF = new JButton("Assegna attività formativa");

	// cancellazione evento
	private JLabel cancellaEvento = new JLabel("Cancellazione evento");
	private JLabel codEventoParrocchia = new JLabel("Evento: ");
	private JComboBox<String> codE = new JComboBox<>();
	private JButton cancella = new JButton("Cancella");

	// registrazione iscritto ad evento
	private JLabel registrazioneIscritto = new JLabel("Registrazione iscritto ad evento");
	private JLabel codEventoParr = new JLabel("Codice evento: ");
	private JComboBox<String> codiceEP = new JComboBox<>();
	private JLabel codIscr = new JLabel("Codice Iscritto: ");
	private JComboBox<String> cIscr = new JComboBox<>();
	private JLabel codiceRegistrazione = new JLabel("Codice registrazione: ");
	private JTextField codReg = new JTextField(16);
	private JLabel brancaE = new JLabel("Branca: ");
	private JComboBox<String> brancheE = new JComboBox<>();
	private JButton iscriviEvento = new JButton("Iscrivi a evento");

	public ParrocchiaModifyOperation(DBConnection con, ResponsabileParrocchia responsabileParrocchia) {
		this.responsabile = responsabileParrocchia;
		codiceParrocchia = QueryParrocchia.calculateCodiceParrocchia(con, responsabileParrocchia);
		this.codiceLC = QueryParrocchia.calculateCodiceLC(con);
		this.codiceEG = QueryParrocchia.calculateCodiceEG(con);
		this.codiceRS = QueryParrocchia.calculateCodiceRS(con);
		this.codiceCC = QueryParrocchia.calculateCodiceCC(con);
		GridBagLayout grid = new GridBagLayout();
		this.setLayout(grid);
		iscDataN.setText("dd/mm/yyyy");
		dInizio.setText("dd/mm/yyyy");
		dFine.setText("dd/mm/yyyy");
		brancheF.addItem("");
		brancheF.setSelectedItem(0);
		brancheL.addItem("");
		brancheL.setSelectedItem(0);
		UpdateComboBoxParrocchia.branche().forEach(b -> brancheI.addItem(b));
		UpdateComboBoxParrocchia.tipoEventi().forEach(e -> branca.addItem(e));
		UpdateComboBoxParrocchia.tipoEventiF().forEach(f -> brancheF.addItem(f));
		UpdateComboBoxParrocchia.tipoEventiL().forEach(l -> brancheL.addItem(l));
		brancheE.addItem(" ");
		brancheE.setSelectedItem(0);
		UpdateComboBoxParrocchia.tipoEventi().forEach(e -> brancheE.addItem(e));
		UpdateComboBoxParrocchia.attivitàFormativa(con).forEach(a -> attFormativa.addItem(a));
		UpdateComboBoxParrocchia.attivitàFormativa(con).forEach(a -> attFormativaE.addItem(a));
		UpdateComboBoxParrocchia.attivitàLudica(con).forEach(a -> attLudica.addItem(a));
		UpdateComboBoxParrocchia.attivitàLudica(con).forEach(a -> attLudicaE.addItem(a));
		codiceEP.addItem(" ");
		codiceEP.setSelectedItem(0);
		cIscr.addItem(" ");
		cIscr.setSelectedItem(0);
		this.attLudicaE.setEnabled(true);
		this.attFormativaE.setEnabled(false);
		year.addItem(UpdateComboBoxParrocchia.anno());
		this.nomeComp.addActionListener(e -> {
			this.areaComp.removeAllItems();
			UpdateComboBoxParrocchia.areaCompetenza(con, String.valueOf(nomeComp.getSelectedItem()))
					.forEach(a -> areaComp.addItem(a));
		});
		this.brancheF.addActionListener(e -> {
			this.codEventoF.removeAllItems();
			UpdateComboBoxParrocchia
					.eventoAttivitàFormativa(con, String.valueOf(this.brancheF.getSelectedItem()), codiceParrocchia)
					.forEach(x -> codEventoF.addItem(x));
		});
		this.brancheL.addActionListener(e -> {
			this.codEventoL.removeAllItems();
			UpdateComboBoxParrocchia
					.eventoAttivitàLudica(con, String.valueOf(this.brancheL.getSelectedItem()), codiceParrocchia)
					.forEach(x -> codEventoL.addItem(x));
		});
		this.brancheE.addActionListener(e -> {
			codiceEP.removeAllItems();
			cIscr.removeAllItems();
			UpdateComboBoxParrocchia
					.codiceIscrittoRegistrazione(con, String.valueOf(this.brancheE.getSelectedItem()), String.valueOf(this.codiceEP.getSelectedItem()), codiceParrocchia)
					.forEach(c -> cIscr.addItem(c));
			UpdateComboBoxParrocchia
			.codiceEventoRegistrazione(con, String.valueOf(this.brancheE.getSelectedItem()), codiceParrocchia)
			.forEach(c -> codiceEP.addItem(c));
		});
		this.brancheI.addActionListener(e -> {
			codIscB.removeAllItems();
			UpdateComboBoxParrocchia.codiceIscritto(con, String.valueOf(brancheI.getSelectedItem()),
					Integer.parseInt(String.valueOf(year.getSelectedItem()))).forEach(x -> codIscB.addItem(x));
		});
		this.codiceEP.addActionListener(e -> {
			cIscr.removeAllItems();
			UpdateComboBoxParrocchia
			.codiceIscrittoRegistrazione(con, String.valueOf(this.brancheE.getSelectedItem()), String.valueOf(this.codiceEP.getSelectedItem()), codiceParrocchia)
			.forEach(c -> cIscr.addItem(c));
		});

		this.branca.addActionListener(e -> {
			if (String.valueOf(branca.getSelectedItem()).equals("LC")) {
				this.attFormativaE.setEnabled(false);
				this.attLudicaE.setEnabled(true);
			} else if (String.valueOf(branca.getSelectedItem()).equals("EG")) {
				this.attFormativaE.setEnabled(true);
				this.attLudicaE.setEnabled(true);
			} else if (String.valueOf(branca.getSelectedItem()).equals("RS")) {
				this.attFormativaE.setEnabled(true);
				this.attLudicaE.setEnabled(false);
			} else if (String.valueOf(branca.getSelectedItem()).equals("Tutti")) {
				this.attFormativaE.setEnabled(false);
				this.attLudicaE.setEnabled(true);
			}
		});
		UpdateComboBoxParrocchia.codiceEvento(con, codiceParrocchia).forEach(e -> codiceEP.addItem(e));
		UpdateComboBoxParrocchia.nomeCompetenza(con).forEach(n -> nomeComp.addItem(n));
		UpdateComboBoxParrocchia.codiceIscritto(con, String.valueOf(brancheI.getSelectedItem()),
				Integer.parseInt(String.valueOf(year.getSelectedItem()))).forEach(i -> codIscB.addItem(i));
		UpdateComboBoxParrocchia.iscrittoBranca(con, codiceParrocchia).forEach(i -> codIsc.addItem(i));
		UpdateComboBoxParrocchia.codiceEvento(con, codiceParrocchia).forEach(e -> codE.addItem(e));
		this.inserimentoEvento();
		this.registrazioneIscrittoBranca();
		this.registrazioneIscritto();
		this.assegnamentoCompetenza();
		this.inserimentoEvento();
		this.assegnamentoAttività();
		this.registrazioneIscrittoEvento();
		this.cancellazioneEvento();

		this.assegnaAttL.addActionListener(e -> {
			if (String.valueOf(this.brancheL.getSelectedItem()).equals("LC")) {
				RicreazioneLC rLC = new RicreazioneLC(String.valueOf(this.codEventoL.getSelectedItem()),
						String.valueOf(this.attLudica.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(rLC.assegnamentoAttivitàRicreativaLC());
			} else if (String.valueOf(this.brancheL.getSelectedItem()).equals("EG")) {
				RicreazioneEG rEG = new RicreazioneEG(String.valueOf(this.codEventoL.getSelectedItem()),
						String.valueOf(this.attLudica.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(rEG.assegnamentoAttivitàRicreativaEG());
			} else if (String.valueOf(this.brancheL.getSelectedItem()).equals("Tutti")) {
				RicreazioneTutti rT = new RicreazioneTutti(String.valueOf(this.codEventoL.getSelectedItem()),
						String.valueOf(this.attLudica.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(rT.assegnamentoAttivitàRicreativaTutti());
			}

		});

		this.assegnaAttF.addActionListener(e -> {
			if (String.valueOf(this.brancheF.getSelectedItem()).equals("RS")) {
				FormazioneParrocchialeRS fpRS = new FormazioneParrocchialeRS(
						String.valueOf(this.codEventoF.getSelectedItem()),
						String.valueOf(this.attFormativa.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(fpRS.assegnamentoAttivitàFormativaRS());
			} else if (String.valueOf(this.brancheF.getSelectedItem()).equals("EG")) {
				FormazioneParrocchialeEG fpEG = new FormazioneParrocchialeEG(
						String.valueOf(this.codEventoF.getSelectedItem()),
						String.valueOf(this.attFormativa.getSelectedItem()), codiceParrocchia);
				this.checkCorrect(fpEG.assegnamentoAttivitàFormativaEG());
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
				if (String.valueOf(branca.getSelectedItem()).equals("LC")) {
					EventoParrocchiaLC eventoLC = new EventoParrocchiaLC(codiceParrocchia, codEvento.getText(),
							tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					ResponsabilitàEventoParrocchiaLC respLC = new ResponsabilitàEventoParrocchiaLC(codEvento.getText(),
							codiceParrocchia, this.responsabile.getCodiceResponsabile());
					checkDoubleCorrect(eventoLC.inserimentoEvento(), respLC.responsabilità_E_P_LC());
				} else if (String.valueOf(branca.getSelectedItem()).equals("EG")) {
					EventoParrocchiaEG eventoEG = new EventoParrocchiaEG(codiceParrocchia, codEvento.getText(),
							tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					ResponsabilitàEventoParrocchiaEG respEG = new ResponsabilitàEventoParrocchiaEG(codEvento.getText(),
							codiceParrocchia, this.responsabile.getCodiceResponsabile());
					checkDoubleCorrect(eventoEG.inserimentoEvento(), respEG.responsabilità_E_P_EG());
				} else if (String.valueOf(branca.getSelectedItem()).equals("RS")) {
					EventoParrocchiaRS eventoRS = new EventoParrocchiaRS(codiceParrocchia, codEvento.getText(),
							tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					ResponsabilitàEventoParrocchiaRS respRS = new ResponsabilitàEventoParrocchiaRS(codEvento.getText(),
							codiceParrocchia, this.responsabile.getCodiceResponsabile());
					checkDoubleCorrect(eventoRS.inserimentoEvento(), respRS.responsabilità_E_P_RS());
				} else if (String.valueOf(branca.getSelectedItem()).equals("Tutti")) {
					EventoParrocchiaTutti eventoTutti = new EventoParrocchiaTutti(codiceParrocchia, codEvento.getText(),
							tipo.getText(), dateInizio, dateFine, loc.getText(), desc.getText());
					ResponsabilitàEventoParrocchiaTutti respTutti = new ResponsabilitàEventoParrocchiaTutti(
							codEvento.getText(), codiceParrocchia, this.responsabile.getCodiceResponsabile());
					checkDoubleCorrect(eventoTutti.inserimentoEvento(), respTutti.responsabilità_E_P_Tutti());
				}
				this.codiceEP.removeAllItems();
				UpdateComboBoxParrocchia.codiceEvento(con, codiceParrocchia).forEach(x -> codiceEP.addItem(x));
				this.codE.removeAllItems();
				UpdateComboBoxParrocchia.codiceEvento(con, codiceParrocchia).forEach(x -> codE.addItem(x));
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
				Iscritto is = new Iscritto(this.iscCodice.getText(), this.iscCF.getText(), this.iscNome.getText(),
						this.iscCognome.getText(), datesql, this.iscLuogoN.getText(), this.iscNTelefono.getText());
				checkCorrect(is.registrazioneIscritto());
				this.codIscB.removeAllItems();
				UpdateComboBoxParrocchia
						.codiceIscritto(con, String.valueOf(brancheI.getSelectedItem()),
								Integer.parseInt(String.valueOf(year.getSelectedItem())))
						.forEach(i -> codIscB.addItem(i));

			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		});

		this.iscrivi.addActionListener(e -> {
			if (String.valueOf(brancheI.getSelectedItem()).equals("LC")) {
				if (Integer.parseInt(String.valueOf(this.year.getSelectedItem()))
						- QueryParrocchia.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) > 7
						&& Integer.parseInt(String.valueOf(this.year.getSelectedItem())) - QueryParrocchia
								.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) < 11) {
					LCAnno lc = new LCAnno(codiceLC, String.valueOf(this.codIscB.getSelectedItem()),
							Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
					checkCorrect(lc.iscrizioneLC());
				}
				else {
					this.error();
				}
			} else if (String.valueOf(brancheI.getSelectedItem()).equals("EG")) {
				if (Integer.parseInt(String.valueOf(this.year.getSelectedItem()))
						- QueryParrocchia.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) > 10
						&& Integer.parseInt(String.valueOf(this.year.getSelectedItem())) - QueryParrocchia
								.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) < 16) {
					EGAnno eg = new EGAnno(codiceEG, String.valueOf(this.codIscB.getSelectedItem()),
							Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
					checkCorrect(eg.iscrizioneEG());
				}
				else {
					this.error();
				}
				
				
			} else if (String.valueOf(brancheI.getSelectedItem()).equals("RS")) {
				if (Integer.parseInt(String.valueOf(this.year.getSelectedItem()))
						- QueryParrocchia.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) > 15
						&& Integer.parseInt(String.valueOf(this.year.getSelectedItem())) - QueryParrocchia
								.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) < 21) {
					RSAnno rs = new RSAnno(codiceRS, String.valueOf(this.codIscB.getSelectedItem()),
							Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
					checkCorrect(rs.iscrizioneRS());
					
				}
				else {
					this.error();
				}
				
			} else if (String.valueOf(brancheI.getSelectedItem()).equals("CC")) {
				if (Integer.parseInt(String.valueOf(this.year.getSelectedItem()))
						- QueryParrocchia.calculateYear(con, String.valueOf(this.codIscB.getSelectedItem())) > 20) {
					CCAnno cc = new CCAnno(codiceCC, String.valueOf(this.codIscB.getSelectedItem()),
							Integer.parseInt(String.valueOf(this.year.getSelectedItem())));
					checkCorrect(cc.iscrizioneCC());
					
				}
				else {
					this.error();
				}
			}
			this.codIsc.removeAllItems();
			this.cIscr.removeAllItems();
			UpdateComboBoxParrocchia.iscrittoBranca(con, codiceParrocchia).forEach(i -> codIsc.addItem(i));
			UpdateComboBoxParrocchia
					.codiceIscrittoRegistrazione(con, String.valueOf(this.brancheE.getSelectedItem()), String.valueOf(this.codiceEP.getSelectedItem()), codiceParrocchia)
					.forEach(c -> cIscr.addItem(c));
		});

		this.iscriviEvento.addActionListener(e -> {
			if (String.valueOf(brancheE.getSelectedItem()).equals("LC")) {
				RegistrazioneEventoParrocchiaLC regLC = new RegistrazioneEventoParrocchiaLC(
						String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()),
						codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regLC.registrazioneEventoLC());
			} else if (String.valueOf(brancheE.getSelectedItem()).equals("EG")) {
				RegistrazioneEventoParrocchiaEG regEG = new RegistrazioneEventoParrocchiaEG(
						String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()),
						codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regEG.registrazioneEventoEG());
			} else if (String.valueOf(brancheE.getSelectedItem()).equals("RS")) {
				RegistrazioneEventoParrocchiaRS regRS = new RegistrazioneEventoParrocchiaRS(
						String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()),
						codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regRS.registrazioneEventoRS());
			} else if (String.valueOf(brancheE.getSelectedItem()).equals("Tutti")) {
				RegistrazioneEventoParrocchiaTutti regTutti = new RegistrazioneEventoParrocchiaTutti(
						String.valueOf(this.codiceEP.getSelectedItem()), String.valueOf(this.cIscr.getSelectedItem()),
						codiceParrocchia, this.codReg.getText());
				this.checkCorrect(regTutti.registrazioneEventoTutti());
			}
		});

		this.assegnaCompetenza.addActionListener(e -> {
			Acquisizione ac = new Acquisizione(String.valueOf(this.nomeComp.getSelectedItem()),
					String.valueOf(this.areaComp.getSelectedItem()), String.valueOf(this.codIsc.getSelectedItem()));
			this.checkCorrect(ac.acquisizione());
		});

		this.cancella.addActionListener(e -> {
			this.checkCancellazione(ParrocchiaDeleteOperation.cancellaEvento(con,
					String.valueOf(codE.getSelectedItem()), codiceParrocchia));
			this.codE.removeAllItems();
			UpdateComboBoxParrocchia.codiceEvento(con, codiceParrocchia).forEach(x -> codE.addItem(x));
			this.codiceEP.removeAllItems();
			UpdateComboBoxParrocchia.codiceEvento(con, codiceParrocchia).forEach(x -> codiceEP.addItem(x));
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

	private void error() {
		JOptionPane.showMessageDialog(this, "Qualcosa è andato storto, verifica la correttezza dei campi.");
	}

	private void checkCancellazione(int number) {
		if (number != 0) {
			JOptionPane.showMessageDialog(this, "Cancellazione andata a buon fine.");
		} else {
			JOptionPane.showMessageDialog(this, "Qualcosa è andato storto, verifica la correttezza dei campi.");
		}
	}

	private void checkDoubleCorrect(int number1, int number2) {
		if (number1 != 0 && number2 != 0) {
			JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
		} else {
			JOptionPane.showMessageDialog(this, "Qualcosa è andato storto, verifica la correttezza dei campi.");
		}
	}

}
