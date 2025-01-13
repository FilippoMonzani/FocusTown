package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField; // Importato per nascondere la password
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class LoginView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel appNameLabel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel regLabel;
	private JButton btnReg;
	private JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		appNameLabel = new JLabel("FocusTown");
		appNameLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 10));
		panel.add(appNameLabel);

		JPanel panel1 = new JPanel();
		contentPane.add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new GridBagLayout());

		usernameLabel = new JLabel("Username");
		GridBagConstraints gbcUsernameLabel = new GridBagConstraints();
		gbcUsernameLabel.insets = new Insets(0, 0, 5, 0);
		gbcUsernameLabel.gridx = 0;
		gbcUsernameLabel.gridy = 0;
		panel1.add(usernameLabel, gbcUsernameLabel);

		usernameField = new JTextField(15);
		GridBagConstraints gbcUsernameField = new GridBagConstraints();
		gbcUsernameField.gridx = 0;
		gbcUsernameField.gridy = 1;
		gbcUsernameField.insets = new Insets(10, 10, 10, 10);
		gbcUsernameField.anchor = GridBagConstraints.CENTER;
		panel1.add(usernameField, gbcUsernameField);

		passwordLabel = new JLabel("Password");
		GridBagConstraints gbcPasswordLabel = new GridBagConstraints();
		gbcPasswordLabel.anchor = GridBagConstraints.NORTH;
		gbcPasswordLabel.insets = new Insets(0, 0, 5, 0);
		gbcPasswordLabel.gridx = 0;
		gbcPasswordLabel.gridy = 2;
		panel1.add(passwordLabel, gbcPasswordLabel);

		passwordField = new JPasswordField(15); // JPassword hides sensitive text
		GridBagConstraints gbcPasswordField = new GridBagConstraints();
		gbcPasswordField.gridx = 0;
		gbcPasswordField.gridy = 3;
		gbcPasswordField.insets = new Insets(10, 10, 10, 10);
		gbcPasswordField.anchor = GridBagConstraints.CENTER;
		panel1.add(passwordField, gbcPasswordField);

		btnLogin = new JButton("Login");
		GridBagConstraints gbcLogin = new GridBagConstraints();
		gbcLogin.gridx = 0;
		gbcLogin.gridy = 4;
		gbcLogin.insets = new Insets(10, 10, 10, 10);
		gbcLogin.anchor = GridBagConstraints.CENTER;
		panel1.add(btnLogin, gbcLogin);

		regLabel = new JLabel("New to FocusTown?");
		GridBagConstraints gbcRegLabel = new GridBagConstraints();
		gbcRegLabel.insets = new Insets(0, 0, 5, 0);
		gbcRegLabel.gridx = 0;
		gbcRegLabel.gridy = 5;
		panel1.add(regLabel, gbcRegLabel);

		btnReg = new JButton("Sign up");
		GridBagConstraints gbcRegBtn = new GridBagConstraints();
		gbcRegBtn.gridx = 0;
		gbcRegBtn.gridy = 6;
		panel1.add(btnReg, gbcRegBtn);
	}

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return new String(passwordField.getPassword());
	}

	public JButton getBtnReg() {
		return btnReg;
	}

	public JButton getLoginBtn() {
		return btnLogin;
	}

	public void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(LoginView.this, String.format(
				"<html><p>C'è stato un <span style=\"color: red\">errore</span> durante il login:</p><br><div style=\"text-align: center; font-size:1.2em\">%s</div></html>",
				msg));
	}
}