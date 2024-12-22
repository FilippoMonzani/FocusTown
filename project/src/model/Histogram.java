package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Histogram extends JPanel {
	// Array of data to display
	private int[] data;
	private String[] categories;

	// Constructor: initializes data and categories
	public Histogram(int[] data, String[] categories) {
		this.data = data;
		this.categories = categories;
	}

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
