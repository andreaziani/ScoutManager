package view.responsabileparrocchia;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.DBConnection;
import model.ResponsabileParrocchia;

public class ParrocchiaViewOperationPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4773835530627131778L;
	
	//visualizzazione iscritti
	private JLabel visualizzazioneIscritti = new JLabel("Visualizza iscritti branca per anno");
	private JLabel anno = new JLabel("Anno :");
	private JComboBox<String> year = new JComboBox<>();
	private JLabel branca = new JLabel("Branca :");
	private JComboBox<String> branche = new JComboBox<>();
	private JButton visualizzaIscritti = new JButton("Visualizza iscritti");
	
	//visualizzazione iscritti ad evento parrocchiale
	private JLabel visualizzazioneIscrittiEvento = new JLabel("Visualizza iscritti ad evento");
	private JLabel codiceEvento = new JLabel("Codice evento :");
	private JTextField codEvento = new JTextField(16);
	private JButton visualizzaIscrittiEvento = new JButton("Visualizza iscritti a evento");
	
	//visualizzazione evento per data
		private JLabel visualizzazioneEventoData = new JLabel("Visualizza eventi per data");
		private JLabel data = new JLabel("Data inizio:");
		private JTextField date = new JTextField(16);
		private JButton visualizzaEventoData = new JButton("Visualizza eventi");

	public ParrocchiaViewOperationPanel(DBConnection con, JTextArea view, ResponsabileParrocchia responsabileParrocchia) {
		GridBagLayout grid = new GridBagLayout();
		this.setLayout(grid);
		this.visualizzaIscritti();
		this.visualizzaIscrittiEvento();
		this.visualizzaEventoPerData();
		UpdateComboBoxParrocchia.branche().forEach(b -> branche.addItem(b));
		UpdateComboBoxParrocchia.anno().forEach(a -> year.addItem(a));
		this.visualizzaEventoData.addActionListener(e -> {
			view.setText(ParrocchiaViewOperation.eventoDiParrocchiaPerData(this.date.getText()));
		});
		this.visualizzaIscrittiEvento.addActionListener(e -> {
			view.setText(ParrocchiaViewOperation.iscrittiEvento(this.codEvento.getText(), QueryParrocchia.calculateCodiceParrocchia(con, responsabileParrocchia)));
			view.revalidate();
			view.repaint();
		});
		
		this.visualizzaIscritti.addActionListener(e -> {
			view.setText(ParrocchiaViewOperation.iscrittiBranca(String.valueOf(branche.getSelectedItem()), QueryParrocchia.calculateCodiceParrocchia(con, responsabileParrocchia), Integer.parseInt(String.valueOf(year.getSelectedItem()))));
			view.revalidate();
			view.repaint();
		});
	}
	
	private void visualizzaIscritti() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.visualizzazioneIscritti, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.anno, c);
		c.gridx = 1;
		this.add(this.year, c);
		c.gridx = 0;
		c.gridy = 2;
		this.add(this.branca, c);
		c.gridx = 1;
		this.add(this.branche, c);
		c.gridx = 0;
		c.gridy = 5;
		this.add(this.visualizzaIscritti, c);
		
	}
	
	private void visualizzaIscrittiEvento() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 2;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.visualizzazioneIscrittiEvento, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.codiceEvento, c);
		c.gridx = 3;
		this.add(this.codEvento, c);
		c.gridx = 2;
		c.gridy = 5;
		this.add(this.visualizzaIscrittiEvento, c);		
	}
	
	private void visualizzaEventoPerData() {
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 4;
		c.insets = new Insets(0, 10, 10, 10);
		this.add(this.visualizzazioneEventoData, c);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 4;
		c.gridy = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(this.data, c);
		c.gridx = 5;
		this.add(this.date, c);
		c.gridx = 4;
		c.gridy = 5;
		this.add(this.visualizzaEventoData, c);	
	}

}
