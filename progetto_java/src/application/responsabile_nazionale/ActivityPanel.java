package application.responsabile_nazionale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.border.EtchedBorder;

import application.app.DBConnection;
import table.AttivitàFormativa;
import table.FormazioneNazionale;

public class ActivityPanel extends JPanel{
    private GridBagConstraints gbc= new GridBagConstraints();
    private JLabel title = new JLabel("Attività");
    
    private JLabel cod = new JLabel("Codice Attività:");
    private JTextField txtcod = new JTextField(10);
    private JTextArea descrizione = new JTextArea("Inserire qui la descrizione", 100, 250);
    
    private JLabel assegnamento = new JLabel("Assegnamento");
    private JLabel codEv = new JLabel("Codice Evento:");
    private JLabel codAtt = new JLabel("Codice Attività: ");
    private JComboBox<String> txtCodEv = new JComboBox<>();
    private JTextField txtCodAtt = new JTextField(5);
    private JButton btn = new JButton("Inserisci Attività");
    private JButton act = new JButton("Assegna attività");
    
    private DBConnection con;
    /**
     * 
     */
    private static final long serialVersionUID = 2872262581192016370L;
    
    public ActivityPanel(DBConnection con) {
        this.con = con;
        build();
        btn.addActionListener(e->{
            AttivitàFormativa a = new AttivitàFormativa(txtcod.getText(), descrizione.getText());
            txtCodAtt.setText(txtcod.getText());
            if(a.inserimentoAttività()==1) {
                JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
            } else {
                JOptionPane.showMessageDialog(this, "Si è verificato un errore, ricontrollare la correttezza dei campi.");
            }
        });
        act.addActionListener(e->{
            FormazioneNazionale fn = new FormazioneNazionale(String.valueOf(txtCodEv.getSelectedItem()), txtCodAtt.getText());
            if(fn.execQuery()==1) {
                JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
            } else {
                JOptionPane.showMessageDialog(this, "Si è verificato un errore, ricontrollare la correttezza dei campi.");
            }
        });
    }
    
    private void build() {
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(new GridBagLayout());
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
        
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(cod, gbc);
        
        gbc.gridx = 1;
        this.add(txtcod, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        descrizione.setMinimumSize(new Dimension(50, 80));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(descrizione, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(btn, gbc);
        
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        this.add(assegnamento, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 5, 2, 5);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        this.add(codEv, gbc);
        gbc.gridx = 1;
        this.add(codAtt, gbc);
        
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.gridy = 6;
        gbc.gridx = 0;
        txtCodEv.setMaximumSize(new Dimension(10, 20));
        
        try {
            Statement st = con.getMsSQLConnection().createStatement();
            ResultSet rs = st.executeQuery("select codiceEvento from E_NAZIONALE");
            if(rs.isBeforeFirst()) {
                while (rs.next()) {
                    this.txtCodEv.addItem(rs.getString(1));
                }} else {
                    this.txtCodEv.addItem("<Nessun Codice Evento memorizzato>");
                }
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Qualcosa è andato storto con la connessione alla base dati");
        }
        
        this.add(txtCodEv, gbc);
        
        txtCodAtt.setMaximumSize(new Dimension(10, 20));
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor= GridBagConstraints.WEST;
        this.add(txtCodAtt, gbc);
        
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        this.add(act, gbc);
    }

}
