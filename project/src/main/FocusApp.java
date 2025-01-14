// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.formdev.flatlaf.FlatLightLaf;

import model.AuthenticationService;
import model.City;
import model.DataGroupByStrategy;
import model.GroupByNumberOfBuildings;
import model.GroupByStudyHours;
import model.User;
import view.AppView;
import view.LoginView;
import view.RegView;
import view.SessionSettingView;
import view.StatsView;
import view.SubjectSessionView;
import view.SessionTimerView;
import view.View;

/************************************************************/
/**
 * 
 */
public class FocusApp {

	private static LoginView loginView = null;
	private static RegView regView = null;
	private static AppView appView = null;
	private static StatsView statsView = null;
	private static SessionSettingView sessionSettingView = null;
	private static SessionTimerView sessionTimerView = null;
	private static SubjectSessionView subjectSessionView = null;

	private static User currentUser = null;
	private static City currentCity = null;
	private static Timer timer;


	private static final Logger logger = LogManager.getLogger(FocusApp.class);
	private static boolean sessionInterrupted = false;

	private static HistogramManager histogramManager;

	public static void main(String[] args) {
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginView = new LoginView();
					regView = new RegView();
					appView = new AppView();
					statsView = new StatsView();
					sessionSettingView = new SessionSettingView();
					sessionTimerView = new SessionTimerView();
					subjectSessionView = new SubjectSessionView();

					loginView.setVisible(true);

					currentCity = new City();
					histogramManager = new HistogramManager(statsView.getHistogram());

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
		setBtnDestination(regView.getBackToLoginBtn(), regView, loginView);
		setBtnDestination(statsView.getBackBtn(), statsView, appView);
		setBtnDestination(appView.getStatsButton(), appView, statsView);
		setBtnDestination(appView.getStartBtn(), appView, sessionSettingView);
		setBtnDestination(appView.getUserBtn(), appView, loginView);
		setBtnDestination(sessionSettingView.getCancelButton(), sessionSettingView, appView);
	}

	/**
	 * Define the action listener of every button here
	 */
	private static void setFunctionalities() {
		regView.getBtnReg().addActionListener(a -> {
			try {
				addUser();
				regView.showSuccessMessage();
				loginView.setVisible(true);
				regView.setVisible(false);
			} catch (DuplicateUserException e) {
				regView.showErrorMessage("Questo nome utente è già preso.");
			}
		});

		loginView.getLoginBtn().addActionListener(a -> {
			String usernameLogin = loginView.getUsername();
			String passwordLogin = loginView.getPassword();

			AuthenticationService authService = new AuthenticationService();
			User u = new User(usernameLogin, passwordLogin);

			try {
				FocusApp.currentUser = authService.login(u, passwordLogin);
				logger.info("Utente <" + currentUser.getUsername() + "> ha effettuato il login.");
				initBuilding();
				// after succesful authentication, appView is shown
				appView.setVisible(true);
				loginView.setVisible(false);
			} catch (UserNotFoundException e) {
				loginView.showErrorMessage("Questo nome utente non esiste.");
			} catch (WrongPasswordException e) {
				loginView.showErrorMessage("Password errata.");
			}
		});

		sessionSettingView.getStartButton().addActionListener(a -> {
			if (!sessionSettingView.getHourField().getText().matches("\\d+")) {
				sessionSettingView.getHourField().setText("0");
			}
			if (!sessionSettingView.getMinuteField().getText().matches("\\d+")) {
				sessionSettingView.getMinuteField().setText("0");
			}
			TimeManager time = new TimeManager();
			time.ofHours(Integer.parseInt(sessionSettingView.getHourField().getText()));
			time.ofMinutes(Integer.parseInt(sessionSettingView.getMinuteField().getText()));
			sessionTimerView.setVisible(true);
			sessionSettingView.setVisible(false);
			startTimer(time);

		});

		sessionTimerView.getStopButton().addActionListener(a -> {
			sessionTimerView.setAlwaysOnTop(false);
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to stop the timer?", "Confirm Stop", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
            	setSessionInterrupted(true);
            }
		});
            

		statsView.getDataSelect().addActionListener(a -> {
			DataGroupByStrategy strategy = switch (statsView.getSelectedData()) {
			case 0 -> new GroupByNumberOfBuildings();
			case 1 -> new GroupByStudyHours();
			default -> new GroupByNumberOfBuildings();
			};
			histogramManager.setStrategy(strategy);
			updateStatsHistogram();
		});

		statsView.getMonthSelect().addActionListener(a -> updateStatsHistogram());

		statsView.getYearSelect().addActionListener(a -> updateStatsHistogram());

		
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
	
	public static void startTimer(TimeManager time) {
		timer = new Timer(1000,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				time.tick();
				
				sessionTimerView.getTimerLabel().setText(time.toString());
				if(isSessionInterrupted()) {
					setSessionInterrupted(false);
					timer.stop();
	                sessionSettingView.setVisible(true);
	                sessionTimerView.setVisible(false);
				}
				else if(time.isZero()) {
					timer.stop();
					subjectSessionView.setVisible(true);
					sessionTimerView.setVisible(false);
				}
			}
		});
		
		timer.setInitialDelay(0);
		timer.start();
	}

	/**
	 * 
	 */
	public static void endTimer(String subject, int seconds) {
		Duration duration =  Duration.ofSeconds(seconds);
		currentCity.addBuilding(duration, subject, currentUser);
	}

	private static void addUser() {
		User user = new User(regView.getUsername(), regView.getPassword());
		if (user.read() != null) {
			throw new DuplicateUserException();
		} else {
			user.save();
		}
	}

	public static Logger getLogger() {
		return FocusApp.logger;
	}

	private static void updateStatsHistogram() {
		int year = statsView.getSelectedYear();
		int month = statsView.getSelectedMonth();
		logger.log(Level.DEBUG, String.format("Looking at buildings from %d, %d", year, month));
		histogramManager.updateHistogram(year, month);
	}

	/**
	 * 
	 * call loadBuilding method for the current city
	 * 
	 * @param user
	 * 
	 */
	private static void initBuilding() {
		currentCity.loadBuildings(currentUser);
	}

	public static boolean isSessionInterrupted() {
		return sessionInterrupted;
	}

	public static void setSessionInterrupted(boolean sessionInterrupted) {
		FocusApp.sessionInterrupted = sessionInterrupted;
	}


}
