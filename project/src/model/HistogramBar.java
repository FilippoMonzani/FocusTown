package model;

import java.awt.Color;

/**
 * This class represents a bar for the HistogramPanel class
 * 
 * @author LorenzoCorbellini
 */
public class HistogramBar {
	private float height;
	private Color barColor;
	private Color textColor;
	private String label;
	
	public HistogramBar(String label, float height, Color barColor, Color textColor) {
		this.label = label;
		this.height = height;
		this.barColor = barColor;
		this.textColor = textColor;
	}
	
	// Constructor with default colors
	public HistogramBar(String label, float height) {
		this(label, height, Color.BLUE, Color.WHITE);
	}

	public float getHeight() {
		return height;
	}

	public String getLabel() {
		return label;
	}
	
	public Color getTextColor() {
		return textColor;
	}
	
	public Color getBarColor() {
		return barColor;
	}
}
