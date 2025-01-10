package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AppView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton statsBtn;
	private JButton startBtn;
	private JButton userBtn;


	/**
	 * Create the frame.
	 */
	public AppView() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		setResizable(false);  
		setExtendedState(JFrame.MAXIMIZED_BOTH);;
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
		centerPanel.setLayout(null);
		
		startBtn = new JButton("Start");
		int btnWidth = 83;
		int btnHeight = 21;
		startBtn.setBounds((int)(width / 2 - (double)btnWidth / 2), (int)(height / 2 - (double)btnHeight / 2), btnWidth, btnHeight);
		centerPanel.add(startBtn);
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		JButton cityBtn = new JButton("City");
		bottomPanel.add(cityBtn);
		
		JButton challengeBtn = new JButton("Challenges");
		bottomPanel.add(challengeBtn);
		
		statsBtn = new JButton("Stats");
		bottomPanel.add(statsBtn);	
		
	}
	
	public JButton getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(JButton startBtn) {
		this.startBtn = startBtn;
	}
	
	public JButton getStatsButton() {
		return this.statsBtn;
	}

	public JButton getUserBtn() {
		return userBtn;
	}

	public void setUserBtn(JButton userBtn) {
		this.userBtn = userBtn;
	}
	
}

