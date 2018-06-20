package application.responsabile_nazionale;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class InsertNationalEvent extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = 1129165456568949369L;

    public InsertNationalEvent() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel evNazionale = new JPanel();
        add(evNazionale, BorderLayout.NORTH);
        evNazionale.setLayout(new GridLayout(6, 2, 0, 0));
        evNazionale.add(new JLabel());
    }
    
}
