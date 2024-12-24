// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package main;

import java.awt.EventQueue;

import javax.swing.JButton;

import model.AuthenticationService;
import model.City;
import model.User;
import view.AppView;
import view.LoginView;
import view.RegView;
import view.StatsView;
import view.View;

/************************************************************/
/**
 * 
 */
public class FocusApp {
	/**
				 * 
				 */
	
	private static LoginView loginView = null;
	private static RegView regView = null;
	private static AppView appView = null;
	private static StatsView statsView = null;

	private static User currentUser = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView = new LoginView();
					regView = new RegView();
					appView = new AppView();
					statsView = new StatsView();

					loginView.setVisible(true);

					setDestinations();
					setFunctionalities();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Define the destination of every button here
	 */
	private static void setDestinations() {
		setBtnDestination(loginView.getBtnReg(), loginView, regView);
//		setBtnDestination(loginView.getLoginBtn(), loginView, appView);
		setBtnDestination(regView.getBackToLoginBtn(), regView, loginView);
		setBtnDestination(regView.getBtnReg(), regView, loginView);
	}

	/**
	 * Define the action listener of every button here
	 */
	private static void setFunctionalities() {
		regView.getBtnReg().addActionListener(a -> {
			try {
				addUser();
				regView.showSuccessMessage();
			} catch (DuplicateUserException e) {
				regView.showErrorMessage("Il nome utente è già preso.");
			}
		});

		loginView.getLoginBtn().addActionListener(a -> {
			String usernameLogin = loginView.getUsername();
			String passwordLogin = loginView.getPassword();
			
			AuthenticationService authService = new AuthenticationService();
			User u = new User(usernameLogin, passwordLogin);

			try {
					FocusApp.currentUser = authService.login(u, passwordLogin);
					// after succesful authentication, appView is shown
			} catch (UserNotFoundException e) {
				loginView.showErrorMessage("Questo nome utente non esiste.");
			} catch (WrongPasswordException e) {				
				loginView.showErrorMessage("Password errata.");
			}
		});
	}

	/***
	 * Set the destination view for a button
	 * 
	 * @param btn    Button that brings to view "dest" when clicked
	 * @param source View that contains the button
	 * @param dest   Destination view
	 */
	private static void setBtnDestination(JButton btn, View source, View dest) {
		btn.addActionListener(a -> {
			source.setVisible(false);
			dest.setVisible(true);
		});
	}

	/**
	 * 
	 * @param duration
	 * @return
	 * @return
	 */
	public void startTimer(int duration) {
	}

	/**
	 * 
	 */
	public void endTimer() {

	}

	private static void addUser() {
		User user = new User(regView.getUsername(), regView.getPassword());
		if (user.read() != null) {
			throw new DuplicateUserException();
		} else {
			user.save();
		}
	}
}
