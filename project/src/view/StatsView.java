package view;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import model.HistogramAdapter;

public class StatsView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton backButton;
	private JComboBox<String> monthSelect;
	private HistogramPanel histogram;

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
		
		// Programmatically changes gap between labels
		SwingUtilities.invokeLater(() -> {
			((FlowLayout) topPanel.getLayout()).setHgap(topPanel.getWidth()/4);
			topPanel.revalidate();
		});
		
		monthSelect = new JComboBox();
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

		backButton = new JButton("Back");
		bottomPanel.add(backButton);
		
		// Example
		histogram = new HistogramPanel();
		centerPanel.add(histogram);
	}
	
	public JButton getBackBtn() {
		return this.backButton;
	}
	
	public JComboBox<String> getMonthsSelect() {
		return this.monthSelect;
	}
	
	public HistogramPanel getHistogram() {
		return this.histogram;
	}
}
