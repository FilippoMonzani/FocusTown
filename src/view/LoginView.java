package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField; // Importato per nascondere la password
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField; // Campo per nome utente
	private JPasswordField passwordField; // Campo per la password (mascherata)
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel regLabel;
	private JButton btnReg;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("nomeApp");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridBagLayout());

		lblNewLabel_1 = new JLabel("nomeUtente");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		// Campo di testo per il nome utente
		usernameField = new JTextField(15);
		GridBagConstraints gbcUsername = new GridBagConstraints();
		gbcUsername.gridx = 0;
		gbcUsername.gridy = 1;
		gbcUsername.insets = new Insets(10, 10, 10, 10);
		gbcUsername.anchor = GridBagConstraints.CENTER;
		panel_1.add(usernameField, gbcUsername);

		lblNewLabel_2 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		// Campo di testo per la password
		passwordField = new JPasswordField(15); // Usa JPasswordField per nascondere i caratteri
		GridBagConstraints gbcPassword = new GridBagConstraints();
		gbcPassword.gridx = 0;
		gbcPassword.gridy = 3;
		gbcPassword.insets = new Insets(10, 10, 10, 10);
		gbcPassword.anchor = GridBagConstraints.CENTER;
		panel_1.add(passwordField, gbcPassword);

		// Pulsante di login
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbcLogin = new GridBagConstraints();
		gbcLogin.gridx = 0;
		gbcLogin.gridy = 4;
		gbcLogin.insets = new Insets(10, 10, 10, 10);
		gbcLogin.anchor = GridBagConstraints.CENTER;
		panel_1.add(btnLogin, gbcLogin);

		regLabel = new JLabel("Non sei registrato?");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		panel_1.add(regLabel, gbc_lblNewLabel_3);

		btnReg = new JButton("Sign up");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 6;
		panel_1.add(btnReg, gbc_btnNewButton);

		// Aggiunta della logica di login
//		btnLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String username = usernameField.getText();
//				String password = new String(passwordField.getPassword()); // Ottieni la password
//
//				// Logica di verifica (hard-coded)
//				if (username.equals("admin") && password.equals("password123")) {
//					JOptionPane.showMessageDialog(LoginView.this, "Login riuscito!", "Successo",
//							JOptionPane.INFORMATION_MESSAGE);
//					openMainView(); // Passa alla schermata principale
//				} else {
//					JOptionPane.showMessageDialog(LoginView.this, "Credenziali errate. Riprova.", "Errore",
//							JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});
	}

	public void addListenerToRegBtn(ActionListener listener) {
		btnReg.addActionListener(listener);
	}
}