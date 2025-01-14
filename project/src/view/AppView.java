package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import java.awt.Font;

/**
 * The main application window for the application. This class is responsible for
 * displaying the primary user interface, including buttons for various features.
 * It extends {@link JFrame} and implements the {@link View} interface.
 * 
 * <p>The {@link AppView} class organizes the layout of the frame with a top panel,
 * a central panel containing a start button, and a bottom panel for additional actions.</p>
 * 
 * <p>Key components in this view include:
 * <ul>
 *     <li>{@link #startBtn}: The button to initiate an action.</li>
 *     <li>{@link #statsBtn}: The button to view application statistics.</li>
 *     <li>{@link #userBtn}: The button for user logout.</li>
 * </ul>
 * </p>
 */
public class AppView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton statsBtn;
	private JButton userBtn;
	private JButton startBtn;


	 /**
     * Constructs the {@link AppView} window with its components and layout.
     * Initializes the panels and buttons and sets up basic actions.
     */
	public AppView() {
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		double width = screenSize.getWidth();
//		double height = screenSize.getHeight();

		setResizable(true);;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		topPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		userBtn = new JButton("Logout");
		topPanel.add(userBtn);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		
		startBtn = new JButton("Start");
		startBtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		centerPanel.add(horizontalGlue);
		startBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		centerPanel.add(startBtn);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		centerPanel.add(horizontalGlue_1);
//		int btnWidth = 83;
//		int btnHeight = 21;
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		JButton cityBtn = new JButton("City");
		bottomPanel.add(cityBtn);
		
		statsBtn = new JButton("Stats");
		bottomPanel.add(statsBtn);	
		
	}
	
	/**
     * Gets the {@link JButton} for the start button.
     * 
     * @return the start button
     */
	public JButton getStartBtn() {
		return startBtn;
	}

	/**
     * Sets the start button.
     * 
     * @param startBtn the start button to set
     */
	public void setStartBtn(JButton startBtn) {
		this.startBtn = startBtn;
	}
	
	/**
     * Gets the {@link JButton} for the statistics button.
     * 
     * @return the stats button
     */
	public JButton getStatsButton() {
		return this.statsBtn;
	}

	/**
     * Gets the {@link JButton} for the user logout button.
     * 
     * @return the user button
     */
	public JButton getUserBtn() {
		return userBtn;
	}

	/**
     * Sets the user button.
     * 
     * @param userBtn the user button to set
     */
	public void setUserBtn(JButton userBtn) {
		this.userBtn = userBtn;
	}
}

