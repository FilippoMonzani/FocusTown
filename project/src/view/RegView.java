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
	 * Create the frame.
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

	public JButton getBackToLoginBtn() {
		return backToLoginBtn;
	}

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return new String(passwordField.getPassword());
	}

	public void showSuccessMessage() {
		JOptionPane.showMessageDialog(RegView.this, "Registrazione avvenuta con successo!");
	}

	public void showErrorMessage(String msg) {
		JOptionPane.showMessageDialog(RegView.this, String.format(
				"<html><p>C'è stato un <span style=\"color: red\">errore</span> durante la registrazione:</p><br><div style=\"text-align: center; font-size:1.2em\">%s</div></html>",
				msg));
	}

	public JButton getBtnReg() {
		return btnReg;
	}
}
