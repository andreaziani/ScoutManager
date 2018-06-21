package application.responsabile_nazionale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;

public class InsertNationalEvent extends JPanel{
    protected JLabel title = new JLabel("Eventi Nazionali");
    
    //EVENTO NAZIONALE
    private JPanel evNazionale = new JPanel();
    private JLabel codEvento = new JLabel("Codice Evento:");
    private JTextField txtCod = new JTextField(16);
    private JLabel tipo = new JLabel("Tipo:");
    private JTextField txttipo = new JTextField(16);
    private JLabel data = new JLabel("Data Inizio:");
    private JTextField txtdata = new JTextField(16);
    private JLabel datafine = new JLabel("Data fine:");
    private JTextField txtdatafine = new JTextField(16);
    private JLabel località = new JLabel("Località:");
    private JTextField txtLocalità = new JTextField(16);
    private JTextArea txtdescrizione = new JTextArea("Inserire qui la descrizione dell'evento", 100, 250);
    /**
     * 
     */
    private static final long serialVersionUID = 1129165456568949369L;

    public InsertNationalEvent() {
        this.buildEv_Nazionale();
        this.build();
    }
    
    private void build() {
        this.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(2, 2, 2, 2);
        evNazionale.setLayout(new GridBagLayout());
        
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
        evNazionale.add(txtdata, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        evNazionale.add(datafine, gbc);
        
        gbc.gridx = 1;
        evNazionale.add(txtdatafine, gbc);
        
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
    }
        
}
