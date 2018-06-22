package application.responsabile_nazionale;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import table.ResponsabileEventoNazionale;

public class ModifyEv extends InsertNationalEvent{
    private JCheckBox codice = new JCheckBox("Codice Evento");
    
    /**
     * 
     */
    private static final long serialVersionUID = 6219942009947696587L;

    public ModifyEv(ResponsabileEventoNazionale res) {
        super(res);
        GridBagConstraints gbc = new GridBagConstraints();
        for(Component p : super.getComponents()) {
            if(p instanceof JLabel) {
                JLabel j = (JLabel) p;
                if(j.getText()=="Codice Evento:") {
                    this.remove(j);
                }
            }
        }
        this.title.setText("Modifica Evento");
        this.btn.setText("Modifica Evento");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(codice, gbc);
    }

}
