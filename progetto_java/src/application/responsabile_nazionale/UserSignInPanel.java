package application.responsabile_nazionale;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class UserSignInPanel extends JPanel{
    private GridBagConstraints gbc= new GridBagConstraints();
    private JLabel title = new JLabel("Registra Iscritto ad Evento Nazionale");
    
    private JLabel codIscritto = new JLabel("Codice Iscritto");
    private JLabel codRegistrazione = new JLabel("Codice Registrazione");
    private JLabel codEvento = new JLabel("Codice Evento");
    
    private JTextField txtCodIsc = new JTextField(5);
    private JTextField txtCodEv = new JTextField(5);
    private JTextField txtCodReg = new JTextField(5);
    private JButton regbtn = new JButton("Regitra iscritto ad evento");
    /**
     * 
     */
    private static final long serialVersionUID = 995155670126020353L;

    public UserSignInPanel() {
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.setLayout(new GridBagLayout());
        setTitle();
        buildInterface();
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
        this.add(txtCodIsc, gbc);
        gbc.gridx = 1;
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
