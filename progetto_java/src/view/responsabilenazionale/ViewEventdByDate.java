package view.responsabilenazionale;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class ViewEventdByDate extends JPanel{
    /**
     * 
     */
    private static final long serialVersionUID = 8835226786280861286L;
    
    private GridBagConstraints gbc= new GridBagConstraints();
    private JLabel title = new JLabel("Visualizza eventi per data");
    private JLabel dataInizio = new JLabel("Data di inizio:");
    private JLabel codiceRes = new JLabel("Codice Responsabile:");
    private Properties p;
    private JDatePickerImpl datePicker;
    private JTextField txtCod = new JTextField(16);
    private JButton btn = new JButton("VISUALIZZA");
    
    
    public ViewEventdByDate() {
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(new GridBagLayout());
        p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        setTitle();
        this.build();
    }
    
    private void setTitle() {
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.fill= GridBagConstraints.NONE;
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        
        gbcMain.anchor = GridBagConstraints.CENTER;
        gbcMain.insets = new Insets(2, 0, 3, 0);
        gbcMain.insets = new Insets(4, 0, 4, 0);
        title.setForeground(Color.RED);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        gbcMain.gridwidth = GridBagConstraints.REMAINDER;
        this.add(title, gbcMain);
    }
    
    private void build() {
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        
        datePicker = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel(), p), new DateLabelFormatter());
        
        add(dataInizio, gbc);
        gbc.gridx = 1;
        add(codiceRes, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        
        add(datePicker, gbc);
        
        gbc.gridx = 1;
        add(txtCod, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        add(btn, gbc);
    }
}
