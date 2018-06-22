package application.responsabile_nazionale;

import java.awt.Toolkit;

import javax.swing.JFrame;

import table.ResponsabileEventoNazionale;

import java.awt.GridLayout;

public class ResponsabileView extends JFrame{
    
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private InsertNationalEvent ne;
    private ActivityPanel ap;
    private ModifyEv me;
    private UserSignInPanel usp;
    private ViewEventdByDate vd;
    /**
     * Automatically generated
     */
    private static final long serialVersionUID = -8618024398073504613L;
    
    
    public ResponsabileView(ResponsabileEventoNazionale responsabile) {
        build();
        ne = new InsertNationalEvent(responsabile);
        ap = new ActivityPanel();
        me = new ModifyEv(responsabile);
        usp = new UserSignInPanel();
        vd = new ViewEventdByDate();
        
        
        this.add(ne);
        this.add(ap);
        this.add(me);
        this.add(usp);
        this.add(vd);
    }
    
    private void build() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new GridLayout(2, 3, 0, 0));
        this.setTitle("Responsabile Nazionale");
        this.setSize(this.height, this.width);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
