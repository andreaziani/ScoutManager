package view.responsabilenazionale;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import model.DBConnection;
import model.RegistrazioneEventoNazionale;

public class UserSignInPanel extends JPanel{
    private GridBagConstraints gbc= new GridBagConstraints();
    private JLabel title = new JLabel("Registra Iscritto ad Evento Nazionale");
    
    private JLabel codIscritto = new JLabel("Codice Iscritto");
    private JLabel codRegistrazione = new JLabel("Codice Registrazione");
    private JLabel codEvento = new JLabel("Codice Evento");
    
    private JComboBox<String> txtCodIsc = new JComboBox<>();
    private JComboBox<String> txtCodEv = new JComboBox<>();
    private JTextField txtCodReg = new JTextField(5);
    private JButton regbtn = new JButton("Regitra iscritto ad evento");
    private DBConnection con; 
    /**
     * 
     */
    private static final long serialVersionUID = 995155670126020353L;

    public UserSignInPanel(DBConnection con) {
        this.con = con;
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(new GridBagLayout());
        setTitle();
        buildInterface();
        regbtn.addActionListener(e->{
            RegistrazioneEventoNazionale r = new RegistrazioneEventoNazionale(String.valueOf(txtCodEv.getSelectedItem()), String.valueOf(txtCodIsc.getSelectedItem()), txtCodReg.getText());
            if(r.execQuery()==1) {
                JOptionPane.showMessageDialog(this, "Inserimento andato a buon fine.");
            } else {
                JOptionPane.showMessageDialog(this, "Si è verificato un errore, ricontrollare la correttezza dei campi.");
            }
        });
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
    
    private void buildInterface() {
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(codIscritto, gbc);
        gbc.gridx = 1;
        this.add(codEvento, gbc);
        gbc.gridx = 2;
        this.add(codRegistrazione, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        
        try {
            Statement st = con.getMsSQLConnection().createStatement();
            ResultSet rs = st.executeQuery("select codiceIscritto from ISCRITTO");
            if(rs.isBeforeFirst()) {
                while (rs.next()) {
                    this.txtCodIsc.addItem(rs.getString(1));
                }} else {
                    this.txtCodIsc.addItem("<Nessun Iscritto memorizzato>");
                }
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Qualcosa è andato storto con la connessione alla base dati");
        }
        
        this.add(txtCodIsc, gbc);
        gbc.gridx = 1;
        
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
        txtCodEv.setSize(5, 10);
        this.add(txtCodEv, gbc);
        gbc.gridx = 2;
        this.add(txtCodReg, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        this.add(regbtn, gbc);
    }
}
