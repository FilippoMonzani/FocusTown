package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

import view.Histogram;

public class StatsView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsView frame = new StatsView();
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
	public StatsView() {
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		// Cambia programmaticamente il gap orizzontale tra i labels
		SwingUtilities.invokeLater(() -> {
			((FlowLayout) topPanel.getLayout()).setHgap(topPanel.getWidth()/4);
			topPanel.revalidate();
		});
		
		JComboBox monthSelect = new JComboBox(new String[] {"Gennaio", "Febbraio", "Marzo"}); // TODO: aggiorna i mesi in base ai dati dell'utente
		topPanel.add(monthSelect);
		
		JLabel yearLabel = new JLabel("2024");
		topPanel.add(yearLabel);
		
		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		JButton backButton = new JButton("Back");
		bottomPanel.add(backButton);
		
        int[] data = {10, 30, 20, 50, 40, 60};
        String[] categories = {"A", "B", "C", "D", "E", "F"};
		Histogram histogram = new Histogram(data, categories);
		centerPanel.add(histogram);
	}
}
