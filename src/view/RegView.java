package view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegView extends JFrame {																																																									//commento segreto

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField; // Campo per nome utente
    private JPasswordField passwordField; // Campo per la password (mascherata)
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel regLabel;
    private JButton btnReg;
    private JLabel lblNewLabel_3;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegView frame = new RegView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RegView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());
        
        // Username Label
        lblNewLabel = new JLabel("Username:");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        // Username TextField
        usernameField = new JTextField();
        GridBagConstraints gbc_usernameField = new GridBagConstraints();
        gbc_usernameField.insets = new Insets(0, 0, 5, 0);
        gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_usernameField.gridx = 2;
        gbc_usernameField.gridy = 0;
        contentPane.add(usernameField, gbc_usernameField);
        usernameField.setColumns(10);
        
        // Password Label
        lblNewLabel_1 = new JLabel("Password:");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 1;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        // Password Field
        passwordField = new JPasswordField();
        GridBagConstraints gbc_passwordField = new GridBagConstraints();
        gbc_passwordField.insets = new Insets(0, 0, 5, 0);
        gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
        gbc_passwordField.gridx = 2;
        gbc_passwordField.gridy = 1;
        contentPane.add(passwordField, gbc_passwordField);
        
        // Registration Button
        btnReg = new JButton("Registrati");
        btnReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = usernameField.getText();
            	String password = passwordField.getText();
            	
                // Mostra un messaggio di conferma della registrazione
                JOptionPane.showMessageDialog(RegView.this, "Registrazione avvenuta con successo!");
                // Puoi aggiungere logica per gestire la registrazione effettiva qui
                openLoginView();
            }
        });
        
        // Add the registration button to the layout
        GridBagConstraints gbc_btnReg = new GridBagConstraints();
        gbc_btnReg.insets = new Insets(0, 0, 5, 0);
        gbc_btnReg.gridx = 2;
        gbc_btnReg.gridy = 2;
        contentPane.add(btnReg, gbc_btnReg);
        
        lblNewLabel_3 = new JLabel("Hai già un account?");
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 4;
        contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        btnNewButton = new JButton("Login");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 5;
        contentPane.add(btnNewButton, gbc_btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    openLoginView();
            }
        });
    }

    /**
     * Metodo per passare alla schermata principale.
     */
    private void openMainView() {
        // Chiude la schermata di registrazione
        this.dispose();

        // Mostra la schermata principale
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppView mainView = new AppView();
                    mainView.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}
        
        private void openLoginView() {
            // Chiude la schermata di registrazione
            this.dispose();

            // Mostra la schermata principale
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        LoginView loginView = new LoginView();
                        loginView.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            
    }
}

