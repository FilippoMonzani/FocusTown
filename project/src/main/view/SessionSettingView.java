package main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

/**
 * The {@link SessionSettingView} class represents the user interface for configuring session settings.
 * It allows the user to input the duration of a session in hours and minutes, with buttons to start or cancel the session.
 * The layout includes input fields for hours and minutes, and a section for navigation options such as start and cancel buttons.
 * It uses a {@link JFrame} to create the main window and arranges components with {@link BoxLayout}, {@link FlowLayout}, and {@link BorderLayout}.
 * 
 * <p>This class also displays error messages if the user attempts to enter invalid session times.</p>
 * 
 * <p>Key Features:
 * <ul>
 *     <li>Input fields for hours and minutes</li>
 *     <li>Start button to begin the session</li>
 *     <li>Cancel button to stop or reset the session</li>
 *     <li>Error label for displaying error messages</li>
 * </ul>
 * </p>
 */
public class SessionSettingView extends JFrame implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField hourField;
	private JTextField minuteField;
	private JButton cancelButton;
	private JButton startButton;
	private JLabel errorLabel;
	
	/**
     * Creates the frame for the session settings view, including all components and layout.
     */
	public SessionSettingView() {
		setFont(new Font("Arial Nova Light", Font.PLAIN, 40));

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel centerPane = new JPanel();
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.X_AXIS));
		centerPane.add(Box.createHorizontalGlue());

		hourField = new JTextField("");
		((AbstractDocument)hourField.getDocument()).setDocumentFilter(new NumberDocumentFilter());
		hourField.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 45));
		hourField.setHorizontalAlignment(SwingConstants.CENTER);
		hourField.setMaximumSize(new Dimension(150, 100));
		centerPane.add(hourField);
		hourField.setColumns(2);

		JLabel label1 = new JLabel(":");
		label1.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 45));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setMaximumSize(new Dimension(150, 100));
		centerPane.add(label1);

		minuteField = new JTextField("");
		((AbstractDocument)minuteField.getDocument()).setDocumentFilter(new NumberDocumentFilter());
		minuteField.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 45));
		minuteField.setHorizontalAlignment(SwingConstants.CENTER);
		minuteField.setMaximumSize(new Dimension(150, 100));
		centerPane.add(minuteField);
		minuteField.setColumns(2);

		JPanel southPane = new JPanel();
		contentPane.add(southPane, BorderLayout.SOUTH);
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(new Color(255, 255, 255));
		southPane.add(cancelButton);
		cancelButton.setForeground(new Color(0, 0, 0));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 24));

		JLabel blankLabel = new JLabel("        ");
		blankLabel.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 40));
		southPane.add(blankLabel);

		startButton = new JButton("START");
		startButton.setBackground(new Color(255, 255, 255));
		southPane.add(startButton);
		startButton.setForeground(new Color(0, 0, 0));
		startButton.setFont(new Font("Tahoma", Font.BOLD, 24));

		centerPane.add(Box.createHorizontalGlue());

		JPanel northPane = new JPanel();
		contentPane.add(northPane, BorderLayout.NORTH);
		northPane.setLayout(new BorderLayout(0, 0));

		JLabel mainLabel = new JLabel("Session Settings");
		mainLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPane.add(mainLabel);

		errorLabel = new JLabel("");
		errorLabel.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 30));
		errorLabel.setForeground(Color.RED);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPane.add(errorLabel, BorderLayout.SOUTH);

	}

	/**
     * Retrieves the error label used to display error messages.
     * 
     * @return the error label
     */
	public JLabel getErrorLabel() {
		return errorLabel;
	}

	/**
     * Sets the error label for displaying error messages.
     * 
     * @param errorLabel the error label to set
     */
	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}

	/**
     * Retrieves the cancel button used to cancel the session configuration.
     * 
     * @return the cancel button
     */
	public JButton getCancelButton() {
		return cancelButton;
	}

	/**
     * Sets the cancel button for the session configuration screen.
     * 
     * @param cancelButton the cancel button to set
     */
	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	/**
     * Retrieves the start button used to initiate the session.
     * 
     * @return the start button
     */
	public JButton getStartButton() {
		return startButton;
	}

	 /**
     * Sets the start button for the session configuration screen.
     * 
     * @param startButton the start button to set
     */
	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}

	/**
     * Retrieves the text field for entering the hour value.
     * 
     * @return the hour text field
     */
	public JTextField getHourField() {
		return hourField;
	}

	/**
     * Sets the hour text field.
     * 
     * @param hourField the hour text field to set
     */
	public void setHourField(JTextField hourField) {
		this.hourField = hourField;
	}

	/**
     * Retrieves the text field for entering the minute value.
     * 
     * @return the minute text field
     */
	public JTextField getMinuteField() {
		return minuteField;
	}

	/**
     * Sets the minute text field.
     * 
     * @param minuteField the minute text field to set
     */
	public void setMinuteField(JTextField minuteField) {
		this.minuteField = minuteField;
	}

}