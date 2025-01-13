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

public class AppView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton statsBtn;
	private JButton userBtn;
	private JButton startBtn;


	/**
	 * Create the frame.
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

