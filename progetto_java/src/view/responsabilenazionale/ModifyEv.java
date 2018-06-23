package view.responsabilenazionale;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.DBConnection;
import model.EventoNazionale;
import model.ResponsabileEventoNazionale;
import view.DateLabelFormatter;

public class ModifyEv extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6219942009947696587L;

	private JComboBox<String> codEvento = new JComboBox<>();
	private JLabel cod = new JLabel("Selezionare Codice Evento:");
	private JLabel tipo = new JLabel("Tipo:");
	private JTextField txttipo = new JTextField(16);
	private JLabel data = new JLabel("Data Inizio:");
	private JLabel datafine = new JLabel("Data fine:");
	private JLabel località = new JLabel("Località:");
	private JTextField txtLocalità = new JTextField(16);
	private JTextArea txtdescrizione = new JTextArea("Inserire qui la descrizione dell'evento", 100, 250);
	private JButton btn = new JButton("Registra Evento");

	private DBConnection con;

	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker2;

	GridBagConstraints gbcMain = new GridBagConstraints();
	private JLabel title = new JLabel("Modifica Evento");

	public ModifyEv(DBConnection con, ResponsabileEventoNazionale res) {
		this.con = con;
		addTitle();
		build();
		btn.addActionListener(e -> {
			EventoNazionale ev = new EventoNazionale(String.valueOf(codEvento.getSelectedItem()), txttipo.getText(),
					(java.util.Date) datePicker.getModel().getValue(),
					(java.util.Date) datePicker2.getModel().getValue(), txtLocalità.getText(),
					txtdescrizione.getText());
			if (ev.updateQuery() == 1) {
				JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
			} else {
				JOptionPane.showMessageDialog(this,
						"Si è verificato un errore, ricontrollare la correttezza dei campi.");
			}

		});
	}

	private void addTitle() {
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));

		gbcMain.gridx = 0;
		gbcMain.gridy = 0;

		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.insets = new Insets(2, 0, 3, 0);

		this.setLayout(new GridBagLayout());
		title.setForeground(Color.RED);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);

		this.add(title, gbcMain);
	}

	private void build() {
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(2, 2, 2, 2);

		datePicker = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());
		datePicker2 = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());

		UpdateBoxes.updateEventiNazionali(con).forEach(e -> codEvento.addItem(e));

		gbc.gridx = 1;
		gbc.gridy = 1;
		add(codEvento, gbc);

		gbc.gridx = 0;
		add(cod, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;
		add(tipo, gbc);

		gbc.gridx = 1;
		add(txttipo, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		add(data, gbc);

		gbc.gridx = 1;
		add(datePicker, gbc);

		gbc.gridy = 4;
		gbc.gridx = 0;
		add(datafine, gbc);

		gbc.gridx = 1;
		add(datePicker2, gbc);

		gbc.gridy = 5;
		gbc.gridx = 0;
		add(località, gbc);

		gbc.gridx = 1;
		add(txtLocalità, gbc);

		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.NONE;
		txtdescrizione.setColumns(5);
		txtdescrizione.setRows(3);
		add(txtdescrizione, gbc);

		gbc.gridy = 7;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(btn, gbc);
	}

	public void updateBox() {
		this.codEvento.removeAllItems();
		UpdateBoxes.updateEventiNazionali(con).forEach(e -> codEvento.addItem(e));
	}
}
