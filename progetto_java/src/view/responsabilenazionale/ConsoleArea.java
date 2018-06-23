package application.responsabile_nazionale;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConsoleArea extends JPanel{

    /**
     * 
     */
    private static final long serialVersionUID = -1843899914907213811L;
    
    private JTextArea log = new JTextArea();
    public ConsoleArea() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        log.setRows(20);
        log.setSize(this.getWidth()-20, this.getHeight()-20);
        log.setEditable(true);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        this.add(log, gbc);
    }
    
    public void insert(String msg) {
        log.setText(msg);
        this.revalidate();
        this.repaint();
    }
}
