// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package main;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.formdev.flatlaf.FlatLightLaf;

import model.AuthenticationService;
import model.Building;
import model.City;
import model.DataGroupByStrategy;
import model.GroupByNumberOfBuildings;
import model.GroupByStudyHours;
import model.User;
import view.AppView;
import view.CityView;
import view.LoginView;
import view.RegView;
import view.SessionSettingView;
import view.StatsView;
import view.SubjectSessionView;
import view.SessionTimerView;
import view.View;

/************************************************************/
/**
 * The {@code FocusApp} class serves as the entry point and main controller for 
 * the application. It initializes the views, manages interactions between them, 
 * and handles user actions.
 * <p>
 * The class sets up the graphical user interface (GUI) components, handles 
 * button destinations, defines functionalities for user actions, and manages 
 * the application's state during runtime.
 * </p>
 */
public class FocusApp {

	// GUI components
	private static LoginView loginView = null;
	private static RegView regView = null;
	private static AppView appView = null;
	private static StatsView statsView = null;
	private static SessionSettingView sessionSettingView = null;
	private static SessionTimerView sessionTimerView = null;
	private static SubjectSessionView subjectSessionView = null;
	private static CityView cityView = null;

	// Application state
	private static User currentUser = null;
	private static City currentCity = null;
	private static Timer timer;
	private static TimeManager time;

	private static final Logger logger = LogManager.getLogger(FocusApp.class);
	private static boolean sessionInterrupted = false;
	private static boolean sessionSuspended = false;

	private static HistogramManager histogramManager;
	private static CityManager cityManager;
	
	 /**
     * The main entry point of the application. Initializes views and their interactions.
     *
     * @param args command-line arguments (not used)
     */
	public static void main(String[] args) {
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	                // Initialize views
					loginView = new LoginView();
					regView = new RegView();
					appView = new AppView();
					statsView = new StatsView();
					sessionSettingView = new SessionSettingView();
					sessionTimerView = new SessionTimerView();
					subjectSessionView = new SubjectSessionView();
					cityView = new CityView();
					
					time = new TimeManager();
	                // Show login view by default
					loginView.setVisible(true);
					// Initialize application state
					currentCity = new City();
					histogramManager = new HistogramManager(statsView.getHistogram());
					cityManager = new CityManager();
	                // Set up button destinations and functionalities
					setDestinations();
					setFunctionalities();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
     * Defines the destinations of each button to transition between views.
     */
	private static void setDestinations() {
		setBtnDestination(loginView.getBtnReg(), loginView, regView);
		setBtnDestination(regView.getBackToLoginBtn(), regView, loginView);
		setBtnDestination(statsView.getBackBtn(), statsView, appView);
		setBtnDestination(appView.getStatsButton(), appView, statsView);
		setBtnDestination(appView.getStartBtn(), appView, sessionSettingView);
		setBtnDestination(appView.getUserBtn(), appView, loginView);
		setBtnDestination(sessionSettingView.getCancelButton(), sessionSettingView, appView);
		setBtnDestination(cityView.getBackButton(), cityView, appView);
	}

	 /**
     * Defines the functionalities and actions for each button in the application.
     */
	private static void setFunctionalities() {
        // Registration functionality
		regView.getBtnReg().addActionListener(a -> {
			try {
				addUser();
				regView.showSuccessMessage();
				loginView.setVisible(true);
				regView.setVisible(false);
			} catch (DuplicateUserException e) {
				regView.showErrorMessage("This username is already taken.");
			}
		});
		
        // Login functionality
		loginView.getLoginBtn().addActionListener(a -> {
			String usernameLogin = loginView.getUsername();
			String passwordLogin = loginView.getPassword();

			AuthenticationService authService = new AuthenticationService();
			User u = new User(usernameLogin, passwordLogin);

			try {
				FocusApp.currentUser = authService.login(u, passwordLogin);
				logger.info("Utente <" + currentUser.getUsername() + "> ha effettuato il login.");
				initBuilding();
				setCities();
				// after succesful authentication, appView is shown
				appView.setVisible(true);
				appView.getWelcomeLabel().setText("Welcome, " + u.getUsername() +"!");
				loginView.setVisible(false);
			} catch (UserNotFoundException e) {
				loginView.showErrorMessage("This username does not exist.");
			} catch (WrongPasswordException e) {
				loginView.showErrorMessage("Wrong password.");
			}
		});
		
        // Timer session start functionality
		sessionSettingView.getStartButton().addActionListener(a -> {
			if (!sessionSettingView.getHourField().getText().matches("\\d+")) {
				sessionSettingView.getHourField().setText("0");
			}
			if (!sessionSettingView.getMinuteField().getText().matches("\\d+")) {
				sessionSettingView.getMinuteField().setText("0");
			}
			//TimeManager time = new TimeManager();
			time.ofHours(Integer.parseInt(sessionSettingView.getHourField().getText()));
			time.ofMinutes(Integer.parseInt(sessionSettingView.getMinuteField().getText()));
			sessionTimerView.setVisible(true);
			sessionSettingView.setVisible(false);
			startTimer(time);

		});

        // Stop button functionality
		sessionTimerView.getStopButton().addActionListener(a -> {
			sessionTimerView.setAlwaysOnTop(false);
			setSessionSuspended(true);
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to stop the timer?", "Confirm Stop", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
            	setSessionInterrupted(true);
            }
            setSessionSuspended(false);
		});
        
        // Confirmation of session subject
		subjectSessionView.getConfirmButton().addActionListener(a -> {
			createNewBuilding(subjectSessionView.getSubjectField().getText());
			appView.setVisible(true);
			subjectSessionView.setVisible(false);
		});

        // Statistics update functionality
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

		appView.getCityBtn().addActionListener(a -> {
			List<Building> buildings = currentCity.getBuildings();
			
			buildings.forEach(b -> {
				logger.log(Level.DEBUG, String.format("Building subject: %s, Study hours: %d, Icon path: %s", b.getSubject(), b.getDuration().toHours(), cityManager.selectPath(b)));
			});
			
			cityManager.updateIcons();
			cityView.setVisible(true);
			appView.setVisible(false);
		});
		
		cityView.getRightArrowBtn().addActionListener(a -> {
			cityManager.swipeRight();
			cityManager.updateIcons();
		});
		
		cityView.getLeftArrowBtn().addActionListener(a -> {
			cityManager.swipeLeft();
			cityManager.updateIcons();
		});
		
		cityView.getScreenshotButton().addActionListener(a -> { 
                try {
                	Rectangle windowBounds = cityView.getContentPane().getBounds();
                    Point locationOnScreen = cityView.getContentPane().getLocationOnScreen();
                    windowBounds.setLocation(locationOnScreen);
                    Robot robot = new Robot();
                    BufferedImage windowCapture = robot.createScreenCapture(windowBounds);
                    String path = System.getenv("APPDATA");
                    File outputFile = new File(path + File.separator + "screenshot.png");
                    ImageIO.write(windowCapture, "png", outputFile);

                    JOptionPane.showMessageDialog(cityView.getContentPane(), "Saved screenshot at " + path + ".");
                } catch (AWTException | IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(cityView.getContentPane(), "There was an error during screenshot acquisition.");
                }
        });
	}

	 /**
     * Sets the destination view for a button action.
     *
     * @param btn    the button that triggers the action
     * @param source the source view containing the button
     * @param dest   the destination view to display
     */
	private static void setBtnDestination(JButton btn, View source, View dest) {
		btn.addActionListener(a -> {
			source.setVisible(false);
			dest.setVisible(true);
		});
	}

	/**
     * Starts a countdown timer for the study session.
     *
     * @param time the {@code TimeManager} object representing the session duration
     */
	public static void startTimer(TimeManager time) {
		timer = new Timer(1000,new ActionListener() {
			TimeManager countingTime = new TimeManager(time.toSeconds());
			@Override
			public void actionPerformed(ActionEvent e) { 
				if(!isSessionSuspended())
				{
					countingTime.tick();
				}
				
				sessionTimerView.getTimerLabel().setText(countingTime.toString());
				if(isSessionInterrupted()) {
					setSessionInterrupted(false);
					timer.stop();
					time.setToZero();
	                sessionSettingView.setVisible(true);
	                sessionTimerView.setVisible(false);
				}
				else if(countingTime.isZero()) {
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
//	public static void endTimer(String subject, int seconds) {
//		Duration duration =  Duration.ofSeconds(seconds);
//		currentCity.addBuilding(duration, subject, currentUser);
//	}

	 /**
     * Adds a new user to the application. If the username is already taken, 
     * throws a {@link DuplicateUserException}.
     *
     * @throws DuplicateUserException if the username is already taken
     */
	private static void addUser() {
		User user = new User(regView.getUsername(), regView.getPassword());
		if (user.read() != null) {
			throw new DuplicateUserException();
		} else {
			user.save();
		}
	}

	 /**
     * Returns the logger instance for this application.
     *
     * @return the {@link Logger} instance
     */
	public static Logger getLogger() {
		return FocusApp.logger;
	}

	/**
     * Updates the histogram displayed in the statistics view based on the selected year 
     * and month. Logs the selected filters for debugging purposes.
     */
	private static void updateStatsHistogram() {
		int year = statsView.getSelectedYear();
		int month = statsView.getSelectedMonth();
		logger.log(Level.DEBUG, String.format("Looking at buildings from %d, %d", year, month));
		histogramManager.updateHistogram(year, month);
	}

	 /**
     * Initializes the buildings for the current user in the application by loading 
     * data from persistent storage through the {@link City} class.
     */
	private static void initBuilding() {
		currentCity.loadBuildings(currentUser);
	}
	
	private static void setCities() {
		histogramManager.setCity(currentCity);
		cityManager.setCity(currentCity, cityView);
		
		histogramManager.getYearRange().forEach(y -> {
			statsView.addYear(y);
		});

	}
	
	 /**
     * Creates a new building in the current city, associated with the current user, 
     * and based on the provided subject. Resets the timer duration to zero after creation.
     *
     * @param subject the name or description of the subject associated with the building
     */
	private static void createNewBuilding(String subject) {
		currentCity.addBuilding(time, subject, currentUser);
		time.setToZero();
	}

	/**
     * Checks if the current session has been interrupted.
     *
     * @return {@code true} if the session has been interrupted, {@code false} otherwise
     */
	public static boolean isSessionInterrupted() {
		return sessionInterrupted;
	}

	 /**
     * Sets the interruption status of the current session. If set to {@code true}, 
     * the session timer will stop.
     *
     * @param sessionInterrupted {@code true} to mark the session as interrupted, {@code false} otherwise
     */
	public static void setSessionInterrupted(boolean sessionInterrupted) {
		FocusApp.sessionInterrupted = sessionInterrupted;
	}

	public static boolean isSessionSuspended() {
		return sessionSuspended;
	}

	public static void setSessionSuspended(boolean sessionSuspended) {
		FocusApp.sessionSuspended = sessionSuspended;
	}


}
