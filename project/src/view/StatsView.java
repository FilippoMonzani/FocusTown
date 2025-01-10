package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class StatsView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton backButton;
	private JComboBox<String> monthSelect;
	private JComboBox<String> yearSelect;
	private HistogramPanel histogram;
	private JComboBox<String> dataSelect;
	private Component horizontalStrut1;
	private Component horizontalStrut2;

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

		// Programmatically change gap between labels
		SwingUtilities.invokeLater(() -> {
			((FlowLayout) topPanel.getLayout()).setHgap(topPanel.getWidth() / 4);
			topPanel.revalidate();
		});

		Font font = new Font(ViewSettings.fontFamily, Font.PLAIN, 16);
		
		dataSelect = new JComboBox<>(new String[] { "Number of buildings", "Study hours" });
		dataSelect.setFont(font);
		topPanel.add(dataSelect);

		horizontalStrut1 = Box.createHorizontalStrut(30);
		topPanel.add(horizontalStrut1);

		monthSelect = new JComboBox<>(new String[] { "Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno",
				"Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre" });
		monthSelect.setFont(font);
		topPanel.add(monthSelect);

		horizontalStrut2 = Box.createHorizontalStrut(30);
		topPanel.add(horizontalStrut2);

		yearSelect = new JComboBox<>(new String[] { "2024", "2025", "2026" });
		yearSelect.setFont(font);
		topPanel.add(yearSelect);

		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));

		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		backButton = new JButton("Back");
		bottomPanel.add(backButton);

		histogram = new HistogramPanel();
		centerPanel.add(histogram);
	}

	public JButton getBackBtn() {
		return this.backButton;
	}

	public JComboBox<String> getMonthSelect() {
		return this.monthSelect;
	}

	public JComboBox<String> getYearSelect() {
		return this.yearSelect;
	}

	public JComboBox<String> getDataSelect() {
		return dataSelect;
	}

	public HistogramPanel getHistogram() {
		return this.histogram;
	}

	public int getSelectedMonth() {
		return monthSelect.getSelectedIndex() + 1;
	}

	public int getSelectedYear() {
		return Integer.parseInt((String) yearSelect.getSelectedItem());
	}

	public int getSelectedData() {
		return dataSelect.getSelectedIndex();
	}
}
