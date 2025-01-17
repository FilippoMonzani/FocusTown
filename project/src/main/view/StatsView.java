package main.view;

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

/**
 * The {@link StatsView} class represents the user interface for displaying statistics related to a session or activity.
 * It allows users to select different data views such as "Number of buildings" or "Study hours", and filter them by
 * month and year. The selected data is visualized through a histogram panel.
 * 
 * <p>The user can select the data type, month, and year, and view the corresponding histogram for the selected data.</p>
 * 
 * <p>Key Features:
 * <ul>
 *     <li>Data selection through a combo box</li>
 *     <li>Month and year selection via combo boxes</li>
 *     <li>Histogram visualization panel for the selected data</li>
 *     <li>Back button for navigating back to the previous screen</li>
 * </ul>
 * </p>
 */
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
     * Creates the frame for the statistics view, including all components and layout.
     * The frame is maximized and contains a top panel for selections and a center panel for displaying the histogram.
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

		yearSelect = new JComboBox<>();
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
		backButton.setFont(font);
		bottomPanel.add(backButton);

		histogram = new HistogramPanel();
		centerPanel.add(histogram);
	}

	/**
     * Retrieves the back button for navigating to the previous screen.
     * 
     * @return the back button
     */
	public JButton getBackBtn() {
		return this.backButton;
	}

	/**
     * Retrieves the combo box for selecting the month.
     * 
     * @return the month selection combo box
     */
	public JComboBox<String> getMonthSelect() {
		return this.monthSelect;
	}

	/**
     * Retrieves the combo box for selecting the year.
     * 
     * @return the year selection combo box
     */
	public JComboBox<String> getYearSelect() {
		return this.yearSelect;
	}

	/**
     * Retrieves the combo box for selecting the type of data (e.g., "Number of buildings" or "Study hours").
     * 
     * @return the data selection combo box
     */
	public JComboBox<String> getDataSelect() {
		return dataSelect;
	}

	/**
     * Retrieves the histogram panel for displaying the selected data visualization.
     * 
     * @return the histogram panel
     */
	public HistogramPanel getHistogram() {
		return this.histogram;
	}

	/**
     * Retrieves the selected month (1-based index).
     * 
     * @return the selected month as an integer (1 for January, 12 for December)
     */
	public int getSelectedMonth() {
		return monthSelect.getSelectedIndex() + 1;
	}

	/**
     * Retrieves the selected year from the combo box.
     * 
     * @return the selected year as an integer
     */
	public int getSelectedYear() {
		return Integer.parseInt((String) yearSelect.getSelectedItem());
	}

	/**
     * Retrieves the selected data type (index of the selection).
     * 
     * @return the selected data type as an integer (0 for "Number of buildings", 1 for "Study hours")
     */
	public int getSelectedData() {
		return dataSelect.getSelectedIndex();
	}
	
	/**
     * Adds a year to the year selection combo box.
     * 
     * @param year the year to add
     */
	public void addYear(int year) {
		this.yearSelect.addItem(String.valueOf(year));
	}
}
