package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * The {@link RegView} class represents the registration view for the user interface. It is a graphical window
 * where users can input their username and password to register for the application. The class uses a {@link JFrame}
 * to create the window and employs a {@link GridBagLayout} to arrange the components in a grid format.
 * 
 * <p>This class includes fields for the username and password input, a registration button, and a prompt for users
 * to navigate to the login page if they already have an account.</p>
 * 
 * <p>Key Features:
 * <ul>
 *     <li>Username and password input fields</li>
 *     <li>Registration button to submit the registration form</li>
 *     <li>Option to go back to the login screen if the user already has an account</li>
 *     <li>Success and error messages displayed using {@link JOptionPane}</li>
 * </ul>
 * </p>
 */
public class RegView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JButton btnReg;
	private JLabel loginPromptLabel;
	private JButton backToLoginBtn;

	/**
     * Creates the frame for the registration view, including the layout and all components (username, password fields, 
     * buttons, and labels).
     */
	public RegView() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridBagLayout());

		usernameLabel = new JLabel("Username:");
		GridBagConstraints gbcUsernameLabel = new GridBagConstraints();
		gbcUsernameLabel.insets = new Insets(0, 0, 5, 5);
		gbcUsernameLabel.gridx = 1;
		gbcUsernameLabel.gridy = 0;
		contentPane.add(usernameLabel, gbcUsernameLabel);

		usernameField = new JTextField();
		GridBagConstraints gbcUsernameField = new GridBagConstraints();
		gbcUsernameField.insets = new Insets(0, 0, 5, 0);
		gbcUsernameField.fill = GridBagConstraints.HORIZONTAL;
		gbcUsernameField.gridx = 2;
		gbcUsernameField.gridy = 0;
		contentPane.add(usernameField, gbcUsernameField);
		usernameField.setColumns(10);

		passwordLabel = new JLabel("Password:");
		GridBagConstraints gbcPasswordLabel = new GridBagConstraints();
		gbcPasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbcPasswordLabel.gridx = 1;
		gbcPasswordLabel.gridy = 1;
		contentPane.add(passwordLabel, gbcPasswordLabel);

		passwordField = new JPasswordField();
		GridBagConstraints gbcPasswordField = new GridBagConstraints();
		gbcPasswordField.insets = new Insets(0, 0, 5, 0);
		gbcPasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbcPasswordField.gridx = 2;
		gbcPasswordField.gridy = 1;
		contentPane.add(passwordField, gbcPasswordField);

		// Registration Button
		btnReg = new JButton("Sign up");

		// Add the registration button to the layout
		GridBagConstraints gbcBtnReg = new GridBagConstraints();
		gbcBtnReg.insets = new Insets(0, 0, 5, 0);
		gbcBtnReg.gridx = 2;
		gbcBtnReg.gridy = 2;
		contentPane.add(btnReg, gbcBtnReg);

		loginPromptLabel = new JLabel("Already signed up?");
		GridBagConstraints gbcLoginPromptLabel = new GridBagConstraints();
		gbcLoginPromptLabel.insets = new Insets(0, 0, 5, 5);
		gbcLoginPromptLabel.gridx = 0;
		gbcLoginPromptLabel.gridy = 4;
		contentPane.add(loginPromptLabel, gbcLoginPromptLabel);

		backToLoginBtn = new JButton("Login");
		GridBagConstraints gbcLoginBtn = new GridBagConstraints();
		gbcLoginBtn.insets = new Insets(0, 0, 0, 5);
		gbcLoginBtn.gridx = 0;
		gbcLoginBtn.gridy = 5;
		contentPane.add(backToLoginBtn, gbcLoginBtn);
	}

	/**
     * Gets the button used to navigate back to the login screen.
     * 
     * @return the button that triggers navigating back to the login view
     */
	public JButton getBackToLoginBtn() {
		return backToLoginBtn;
	}

	/**
     * Retrieves the entered username from the username field.
     * 
     * @return the username entered by the user
     */
	public String getUsername() {
		return usernameField.getText();
	}

	/**
     * Retrieves the entered password from the password field.
     * 
     * @return the password entered by the user
     */
	public String getPassword() {
		return new String(passwordField.getPassword());
	}

	 /**
     * Displays a success message to the user after successful registration.
     */
	public void showSuccessMessage() {
		JOptionPane.showMessageDialog(RegView.this, "Succesfully signed up!");
	}

	/**
     * Displays an error message to the user when the registration process encounters an error.
     * 
     * @param msg the error message to display
     */
	public void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(RegView.this, String.format(
				"<html><p>An <span style=\"color: red\">error</span> occured during signing up:</p><br><div style=\"text-align: center; font-size:1.2em\">%s</div></html>",
				msg));
	}

	/**
     * Retrieves the registration button used to submit the registration form.
     * 
     * @return the registration button
     */
	public JButton getBtnReg() {
		return btnReg;
	}
}
