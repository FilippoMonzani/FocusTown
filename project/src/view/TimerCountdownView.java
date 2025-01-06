package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

public class TimerCountdownView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel timerLabel;
    private int countdownTime = 60; // Countdown start time in seconds
    private Timer timer;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TimerCountdownView frame = new TimerCountdownView();
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
    public TimerCountdownView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        // Set the frame to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Timer label at the top
        timerLabel = new JLabel("Time remaining: " + countdownTime + " seconds");
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(timerLabel, BorderLayout.NORTH);

        // Start the countdown timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (countdownTime > 0) {
                    countdownTime--;
                    timerLabel.setText("Time remaining: " + countdownTime + " seconds");
                } else {
                    timerLabel.setText("Time's up!");
                    timer.stop();
                }
            }
        });
        timer.start();

        // Button to stop the timer
        JButton stopButton = new JButton("Stop Timer");
        stopButton.setPreferredSize(new Dimension(120, 25)); // Adjust button size
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to stop the timer?", "Confirm Stop", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (confirm == JOptionPane.YES_OPTION) {
                    timer.stop();
                    timerLabel.setText("Timer stopped at: " + countdownTime + " seconds");
                }
            }
        });
        contentPane.add(stopButton, BorderLayout.SOUTH);
    }
}
