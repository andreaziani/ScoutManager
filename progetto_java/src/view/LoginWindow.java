package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.DBConnection;
import model.LoginControl;
import view.admin.AdminView;
import view.responsabilenazionale.ResponsabileView;
import view.responsabileparrocchia.ParrocchiaView;

/**
 * Login window.
 *
 */
public class LoginWindow extends JFrame {
	/**
	 * Automatically generated.
	 */
	private static final long serialVersionUID = 6801537677416988762L;
	private JPanel panel;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	public LoginWindow(DBConnection con) {
		Dimension pref = new Dimension(250, 20);
		this.setResizable(false);
		panel = new JPanel();
		panel.setBounds(0, 0, 450, 250);
		JPanel AreaLogin = new JPanel();
		this.setBounds(0, 0, 450, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		panel.setLayout(new BorderLayout());
		this.getContentPane().add(panel);
		panel.add(AreaLogin, BorderLayout.CENTER);

		// Title

		JLabel title = new JLabel("SCOUT MANAGER");
		title.setFont(new Font("SansSerif", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.RED);
		panel.add(title, BorderLayout.NORTH);

		// Text Area
		AreaLogin.setLayout(new BoxLayout(AreaLogin, BoxLayout.Y_AXIS));
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setAlignmentX(Component.CENTER_ALIGNMENT);
		AreaLogin.add(lblUsername);

		// UserName
		txtUsername = new JTextField();
		txtUsername.setPreferredSize(pref);
		txtUsername.setMaximumSize(pref);
		AreaLogin.add(txtUsername);
		txtUsername.setColumns(10);

		// Password
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		AreaLogin.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setPreferredSize(pref);
		passwordField.setMaximumSize(pref);
		AreaLogin.add(passwordField);

		// Login
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(e -> {
		    if (txtUsername.getText().equals("admin") && String.valueOf(passwordField.getPassword()).equals("admin")) {
				this.dispose();
				new AdminView(con);
			} else if (LoginControl.checkNazID(txtUsername.getText(), String.valueOf(this.passwordField.getPassword()))) {
				this.dispose();
				new ResponsabileView(LoginControl.getResponsabileNazionale(this.txtUsername.getText()));
			} else if (LoginControl.checkParrID(txtUsername.getText(), String.valueOf(this.passwordField.getPassword()))) {
				this.dispose();
				new ParrocchiaView(LoginControl.getResponsabileParrocchia(this.txtUsername.getText()), con);
			} else {
				JOptionPane.showMessageDialog(this, "Nome utente o password errati.");
			}
		});
		btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		AreaLogin.add(btnLogin);
		this.setVisible(true);
	}
}
