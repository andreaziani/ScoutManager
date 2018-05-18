package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;

public class Application {

    private JFrame frame;
    private JPanel panel;    
    private JTextField txtUsername;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        Application window = new Application();
        window.frame.setVisible(true);
    }

    /**
     * Create the application.
     */
    public Application() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        Dimension pref = new Dimension(250, 20);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame();
        frame.setResizable(false);
        panel = new JPanel();
        panel.setBounds(0, 0, 450, 250);
        JPanel AreaLogin = new JPanel();
        frame.setBounds(0, 0, 450, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        panel.setLayout(new BorderLayout());
        frame.getContentPane().add(panel);
        panel.add(AreaLogin, BorderLayout.CENTER);
        
        //Title
        
        JLabel title = new JLabel("SCOUT MANAGER");
        title.setFont(new Font("SansSerif", Font.PLAIN, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.RED);
        panel.add(title, BorderLayout.NORTH);
        
        
        //Text Area
        
        AreaLogin.setLayout(new BoxLayout(AreaLogin, BoxLayout.Y_AXIS));
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
        AreaLogin.add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setPreferredSize(pref);
        txtUsername.setMaximumSize(pref);
        AreaLogin.add(txtUsername);
        txtUsername.setColumns(10);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        AreaLogin.add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(pref);
        passwordField.setMaximumSize(pref);
        AreaLogin.add(passwordField);
        
        //MenuBar
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        JButton btnFile = new JButton("Exit");
        btnFile.addActionListener(e->System.exit(0));
        mnNewMenu.add(btnFile);
        
        //Action
        
        JButton btnCredits = new JButton("Credits");
        btnCredits.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(frame, "Caldara Mariano\nScucchia Matteo\nAndrea Ziani", "Credits", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        mnNewMenu.add(btnCredits);
        
        //Login
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //Add to db text area
            }
        });
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        AreaLogin.add(btnLogin);
        
    }
}
