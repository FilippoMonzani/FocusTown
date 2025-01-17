package main.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

/**
 * The {@link LoginView} class represents a graphical user interface (GUI) for logging into the application.
 * This view is responsible for handling user input, including their username and password, and provides buttons
 * for the user to either log in or navigate to a registration screen.
 * 
 * <p>The view is built using a grid layout, with fields for entering credentials, a login button, and a 
 * sign-up button for new users.</p>
 * 
 * <p>Key features of the {@link LoginView} class include:
 * <ul>
 *     <li>Username and password input fields using {@link JTextField} and {@link JPasswordField}.</li>
 *     <li>Login and sign-up buttons for user authentication and registration.</li>
 *     <li>Error message display using {@link JOptionPane} to alert the user of failed login attempts.</li>
 * </ul>
 * </p>
 */
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
     * Constructs the {@link LoginView} frame with its components and layout.
     * Initializes the content pane, input fields for username and password, 
     * and adds buttons for login and registration.
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
		appNameLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 24));
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

	/**
     * Returns the entered username from the username input field.
     * 
     * @return the username as a {@link String}
     */
	public String getUsername() {
		return usernameField.getText();
	}

	/**
     * Returns the entered password from the password input field.
     * 
     * @return the password as a {@link String}
     */
	public String getPassword() {
		return new String(passwordField.getPassword());
	}

	/**
     * Returns the registration button used for signing up new users.
     * 
     * @return the registration {@link JButton}
     */
	public JButton getBtnReg() {
		return btnReg;
	}

	/**
     * Returns the login button used for submitting the login form.
     * 
     * @return the login {@link JButton}
     */
	public JButton getLoginBtn() {
		return btnLogin;
	}

	/**
     * Displays an error message to the user in case of a failed login attempt.
     * The error message is displayed in a dialog with a red-colored text for emphasis.
     * 
     * @param msg the error message to be displayed
     */
	public void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(LoginView.this, String.format(
				"<html><p>An <span style=\"color: red\">error</span> occurred during login:</p><br><div style=\"text-align: center; font-size:1.2em\">%s</div></html>",
				msg));
	}
}