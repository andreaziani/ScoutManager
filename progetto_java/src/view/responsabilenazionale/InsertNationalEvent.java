package view.responsabilenazionale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import model.EventoNazionale;
import model.ResponsabileEventoNazionale;
import model.ResponsabilitàEventoNazionale;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;

public class InsertNationalEvent extends JPanel {
    protected JLabel title = new JLabel("Eventi Nazionali");
    
    //EVENTO NAZIONALE
    private JPanel evNazionale = new JPanel();
    private JLabel codEvento = new JLabel("Codice Evento:");
    private JTextField txtCod = new JTextField(16);
    private JLabel tipo = new JLabel("Tipo:");
    private JTextField txttipo = new JTextField(16);
    private JLabel data = new JLabel("Data Inizio:");
    private JLabel datafine = new JLabel("Data fine:");
    private JLabel località = new JLabel("Località:");
    private JTextField txtLocalità = new JTextField(16);
    private JTextArea txtdescrizione = new JTextArea("Inserire qui la descrizione dell'evento", 100, 250);
    protected JButton btn = new JButton("Registra Evento");
    
    private Properties p;
    private JDatePickerImpl datePicker;
    private JDatePickerImpl datePicker2;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1129165456568949369L;

    public InsertNationalEvent(ResponsabileEventoNazionale res, ActivityPanel ap, ModifyEv me, UserSignInPanel usp) {

        this.buildEv_Nazionale();
        this.build();
        this.btn.addActionListener(e->{
            EventoNazionale ev = new EventoNazionale(txtCod.getText(), txttipo.getText(),(java.util.Date) datePicker.getModel().getValue(), (java.util.Date) datePicker2.getModel().getValue(), txtLocalità.getText(), txtdescrizione.getText());
            ResponsabilitàEventoNazionale re = new ResponsabilitàEventoNazionale(txtCod.getText(), res.getCodiceResponsabile());
            
            if(ev.execQuery()==1 && re.execQuery()==1) {
                JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
                ap.updateBox();
                me.updateBox();
                usp.updateBoxes();
            }else {
                JOptionPane.showMessageDialog(this, "Si è verificato un errore, ricontrollare la correttezza dei campi.");
            }
        });
    }
    
    private void build() {
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        
        gbcMain.anchor = GridBagConstraints.CENTER;
        gbcMain.insets = new Insets(2, 0, 3, 0);
        
        this.setLayout(new GridBagLayout());
        title.setForeground(Color.RED);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(title, gbcMain);
        gbcMain.gridy = 1;
        gbcMain.insets = new Insets(0, 0, 0, 0);
        this.add(evNazionale, gbcMain);        
    }
    
    private void buildEv_Nazionale() {
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 2, 2, 2);
        evNazionale.setLayout(new GridBagLayout());
        
        
        datePicker = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());
        datePicker2 = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        evNazionale.add(codEvento, gbc);
        
        gbc.gridx = 1;
        txtCod.setMinimumSize(new Dimension(800, 570));
        evNazionale.add(txtCod, gbc);
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        evNazionale.add(tipo, gbc);
        
        gbc.gridx = 1;
        evNazionale.add(txttipo, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        evNazionale.add(data, gbc);
        
        gbc.gridx = 1;
        evNazionale.add(datePicker, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        evNazionale.add(datafine, gbc);
        
        gbc.gridx = 1;
        evNazionale.add(datePicker2, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        evNazionale.add(località, gbc);
        
        gbc.gridx = 1;
        evNazionale.add(txtLocalità, gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        txtdescrizione.setColumns(5);
        txtdescrizione.setRows(3);
        evNazionale.add(txtdescrizione, gbc);
        
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        evNazionale.add(btn, gbc);
    }
        
}
