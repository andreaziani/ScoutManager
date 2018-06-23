package view.responsabilenazionale;

import java.awt.Toolkit;

import javax.swing.JFrame;

import model.ResponsabileEventoNazionale;

import java.awt.GridLayout;

public class ResponsabileView extends JFrame{
    
    private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    private InsertNationalEvent ne = new InsertNationalEvent();
    private ActivityPanel ap;
    private ModifyEv me = new ModifyEv();
    private UserSignInPanel usp = new UserSignInPanel();
    private ViewEventdByDate vd = new ViewEventdByDate();
    /**
     * Automatically generated
     */
    private static final long serialVersionUID = -8618024398073504613L;
    
    
    public ResponsabileView(ResponsabileEventoNazionale responsabile) {
        build();
        ap = new ActivityPanel();
        me = new ModifyEv();
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
