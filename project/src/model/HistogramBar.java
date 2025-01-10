package model;

import java.awt.Color;

/**
 * Represents a single bar in a histogram.
 * Each bar is defined by its label, display value, relative height, and visual properties.
 * 
 * @author LC
 */
public class HistogramBar {
	private String label;
	private String displayValue;
	private float height;
	private Color barColor;
	private Color textColor;
	
	/**
	 * Constructs a histogram bar with the specified properties.
	 * 
	 * @param label        The label displayed on the X-axis.
	 * @param displayValue The numerical value displayed on the Y-axis.
	 * @param height       The height of the bar relative to other bars.
	 * @param barColor     The color of the bar in the GUI.
	 * @param textColor    The color of the text in the GUI.
	 */
	public HistogramBar(String label, String displayValue, float height, Color barColor, Color textColor) {
		this.label = label;
		this.displayValue = displayValue;
		this.height = height;
		this.barColor = barColor;
		this.textColor = textColor;
	}
	
	/**
	 * Constructs a histogram bar with default colors (blue for the bar, white for the text).
	 * 
	 * @param label        The label displayed on the X-axis.
	 * @param displayValue The numerical value displayed on the Y-axis.
	 * @param height       The height of the bar relative to other bars.
	 */
	public HistogramBar(String label, String displayValue, float height) {
		this(label, displayValue, height, Color.BLUE, Color.WHITE);
	}

	/**
	 * Gets the relative height of the bar.
	 * 
	 * @return The height of the bar.
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Gets the label displayed on the X-axis.
	 * 
	 * @return The label of the bar.
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * Gets the numerical value displayed on the Y-axis.
	 * 
	 * @return The display value of the bar.
	 */
	public String getDisplayValue() {
		return displayValue;
	}
	
	/**
	 * Gets the color of the text in the GUI.
	 * 
	 * @return The text color.
	 */
	public Color getTextColor() {
		return textColor;
	}
	
	/**
	 * Gets the color of the bar in the GUI.
	 * 
	 * @return The bar color.
	 */
	public Color getBarColor() {
		return barColor;
	}
}
