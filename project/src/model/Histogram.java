package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Represents a histogram that displays a bar chart based on a given dataset.
 *
 * <p>This class extends {@link JPanel} and overrides the {@link JPanel#paintComponent(Graphics)} method 
 * to draw a histogram on the panel. It takes an array of data and corresponding categories to display 
 * the bars and labels in the chart.</p>
 *
 */
public class Histogram extends JPanel {
	
	/**
     * Array of data values to display in the histogram.
     */
	private int[] data;
	
	/**
     * Array of category names corresponding to each bar in the histogram.
     */
	private String[] categories;

	 /**
     * Constructs a new {@link Histogram} with the specified data and categories.
     *
     * <p>This constructor initializes the histogram with the given data and category labels.</p>
     *
     * @param data the array of integer values to represent in the histogram (e.g., number of occurrences).
     * @param categories the array of category labels corresponding to each data point.
     */
	public Histogram(int[] data, String[] categories) {
		this.data = data;
		this.categories = categories;
	}

	/**
     * Paints the histogram onto the panel.
     *
     * <p>This method is overridden from {@link JPanel#paintComponent(Graphics)} to render the histogram 
     * on the screen. It calculates the height of each bar relative to the maximum value in the data 
     * and displays both the category names and the values above each bar.</p>
     * 
     * @param g the {@link Graphics} object used to draw on the panel
     */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// General settings
		int barWidth = getWidth() / data.length; // Width for each bar
		int maxHeight = getHeight(); // Maximum panel height

		// Find the maximum value in the data to scale the bar heights
		int maxValue = 0;
		for (int value : data) {
			if (value > maxValue)
				maxValue = value;
		}

		// Draw each bar
		for (int i = 0; i < data.length; i++) {
			int barHeight = (int) ((double) data[i] / maxValue * maxHeight);
			int x = i * barWidth;
			int y = maxHeight - barHeight;

			// Draw the bar
			g.setColor(Color.BLUE);
			g.fillRect(x, y, barWidth - 10, barHeight); // Space between bars

			// Draw the value above the bar
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(data[i]), x + (barWidth / 4), y + 15);

			// Draw the category name below the bar
			g.setColor(Color.WHITE);
			g.drawString(categories[i], x + (barWidth / 4), maxHeight - 5);
		}
	} 
}
