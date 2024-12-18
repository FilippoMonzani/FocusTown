package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;

public class AppView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppView frame = new AppView();
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
	public AppView() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

//        setUndecorated(true) 
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
		
		JButton userBtn = new JButton("Logout");
		topPanel.add(userBtn);
		
		userBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLoginView();
        }});
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(null);
		
		JButton startBtn = new JButton("Start");
		int btnWidth = 83; // Larghezza del bottone
		int btnHeight = 21; // Altezza del bottone
		startBtn.setBounds((int)(width / 2 - btnWidth / 2), (int)(height / 2 - btnHeight / 2), btnWidth, btnHeight);
		centerPanel.add(startBtn);
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		
		JButton cityBtn = new JButton("City");
		bottomPanel.add(cityBtn);
		
		JButton challengeBtn = new JButton("Challenges");
		bottomPanel.add(challengeBtn);
		
		JButton statsBtn = new JButton("Stats");
		bottomPanel.add(statsBtn);	
		
		startBtn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		openSessionSettingView();
        	}
        	
        });
	}
	
	public void openLoginView() {
		 this.dispose();
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
	public void openSessionSettingView() {
		 this.dispose();
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    SessionSettingView sessionSettingView = new SessionSettingView();
	                    sessionSettingView.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	}
}
