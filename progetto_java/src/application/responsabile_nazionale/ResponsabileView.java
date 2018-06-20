package application.responsabile_nazionale;

import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.GridLayout;

public class ResponsabileView extends JFrame{
    
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private InsertNationalEvent ne = new InsertNationalEvent();
    
    /**
     * Automatically generated
     */
    private static final long serialVersionUID = -8618024398073504613L;
    
    
    public ResponsabileView() {
        this.setTitle("Responsabile Nazionale");
        this.setSize(this.height, this.width);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        getContentPane().setLayout(new GridLayout(2, 3, 0, 0));
        this.add(ne);
        
    }
}
