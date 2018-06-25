package view.responsabilenazionale;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.ResponsabileEventoNazionale;
import model.ResponsabilitàEventoNazionale;
import model.ViewUsersEN;
import view.DateLabelFormatter;

public class ViewEventdByDate extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8835226786280861286L;

	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel title = new JLabel("Visualizza eventi per data");
	private JLabel dataInizio = new JLabel("Data di inizio:");
	private JLabel title2 = new JLabel("Visualizza iscritti ad evento");
	private JLabel codice = new JLabel("Codice evento: ");
	private JTextField codiceEvento = new JTextField(16);
	private Properties p;
	private JDatePickerImpl datePicker;
	private JButton btn = new JButton("VISUALIZZA");
	private JButton btn2 = new JButton("VISUALIZZA");
	
	public ViewEventdByDate(ResponsabileEventoNazionale res, ConsoleArea log) {
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setLayout(new GridBagLayout());
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		setTitle();
		this.build();
		this.btn.addActionListener(e -> {
			ResponsabilitàEventoNazionale r = new ResponsabilitàEventoNazionale(null, res.getCodiceResponsabile());
			String msg = r.viewEvbyDateQuery((Date) datePicker.getModel().getValue());
			log.insert(msg);
		});
		this.btn2.addActionListener(e->{
		    log.insert(ViewUsersEN.iscrittiAdEvento(codiceEvento.getText()));
		});
	}

	private void setTitle() {
		GridBagConstraints gbcMain = new GridBagConstraints();
		gbcMain.fill = GridBagConstraints.NONE;
		gbcMain.gridx = 0;
		gbcMain.gridy = 0;

		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.insets = new Insets(1, 0, 1, 0);
		gbcMain.insets = new Insets(1, 0, 1, 0);
		title.setForeground(Color.RED);
		title2.setForeground(Color.RED);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		gbcMain.gridwidth = GridBagConstraints.REMAINDER;
		this.add(title, gbcMain);
	}

	private void build() {
		gbc.insets = new Insets(1, 1, 1, 1);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;

		datePicker = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());

		add(dataInizio, gbc);

		gbc.gridy = 2;
		gbc.gridx = 0;

		add(datePicker, gbc);

		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(btn, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.NONE;
		add(title2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(codice, gbc);
		
		gbc.gridy = 5;
		gbc.gridx = 1;
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		add(codiceEvento, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = GridBagConstraints.REMAINDER;
		
		add(btn2, gbc);
	}

}
