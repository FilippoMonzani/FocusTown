package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The {@link SessionTimerView} class represents the user interface for displaying a session timer.
 * It shows the elapsed time in a large format and provides a button to stop the session.
 * The window is designed to be fullscreen and undecorated to provide a clean view of the timer.
 * 
 * <p>This class allows the user to see the remaining time of a session and stop the session once it's done.</p>
 * 
 * <p>Key Features:
 * <ul>
 *     <li>Timer label that shows the elapsed time in a large font</li>
 *     <li>Stop button to stop the session</li>
 * </ul>
 * </p>
 */
public class SessionTimerView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel timerLabel;
	private JButton stopButton;
	private JButton resumeButton;
	private JButton cancelSessionButton;

	 /**
     * Creates the frame for the session timer view, including all components and layout.
     * The window is maximized and undecorated for a clean timer display.
     */
	public SessionTimerView() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		 setExtendedState(JFrame.MAXIMIZED_BOTH);
	        setUndecorated(true);
	        
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		timerLabel = new JLabel("");
		timerLabel.setFont(new Font("Tahoma", Font.PLAIN, 48));
		panel.add(timerLabel);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		resumeButton = new JButton("Resume");
		resumeButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		resumeButton.setVisible(false);
		panel_1.add(resumeButton);

		
		stopButton = new JButton("Stop");
		stopButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(stopButton);
		
		cancelSessionButton = new JButton("Cancel session");
		cancelSessionButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cancelSessionButton.setVisible(false);;
		panel_1.add(cancelSessionButton);
	}
	
	/**
     * Retrieves the label that displays the timer.
     * 
     * @return the timer label
     */
	public JLabel getTimerLabel() {
		return timerLabel;
	}

	/**
     * Sets the label that displays the timer.
     * 
     * @param timerLabel the timer label to set
     */
	public void setTimerLabel(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	/**
     * Retrieves the stop button used to stop the session.
     * 
     * @return the stop button
     */
	public JButton getStopButton() {
		return stopButton;
	}

	/**
     * Sets the stop button for the session.
     * 
     * @param stopButton the stop button to set
     */
	public void setStopButton(JButton stopButton) {
		this.stopButton = stopButton;
	}

	public JButton getResumeButton() {
		return resumeButton;
	}

	public void setResumeButton(JButton resumeButton) {
		this.resumeButton = resumeButton;
	}

	public JButton getCancelSessionButton() {
		return cancelSessionButton;
	}

	public void setCancelSessionButton(JButton cancelSessionButton) {
		this.cancelSessionButton = cancelSessionButton;
	}

}
