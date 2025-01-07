package model;

import java.util.Arrays;

import org.apache.logging.log4j.Level;

import main.FocusApp;

/**
 * This class aggregates data into an array of HisogramBar[] for the HistogramPanel to render with Swing.
 * It actsa as an adapter between the raw data and HistogramPanel
 * 
 * @author LorenzoCorbellini
 */
public class HistogramAdapter {
	private int[] data;
	private String[] categories;

	public HistogramAdapter(int[] data, String[] categories) {
		this.data = data;
		this.categories = categories;
	}
	
	public HistogramAdapter() {
		
	}
	
	/**
	 * Compute histogram bars from the data that the adapter received.
	 * @return
	 */
	public HistogramBar[] getHistogramBars() {
		
		if(categories.length == 0 || data.length == 0) {
			throw new IllegalArgumentException("Categories and data cannot be empty!");
		}
		
		if(categories.length != data.length) {
			throw new IllegalArgumentException("Lenght of categories and data do not match!");
		}
		
		HistogramBar[] bars = new HistogramBar[categories.length];
		float maxValue = Arrays.stream(data).max().orElse(1);
		
		for(int i = 0; i < data.length; i++) {
			float height = data[i] / maxValue;
			FocusApp.getLogger().log(Level.DEBUG, "Bar " + categories[i] + " height: " + height);
			bars[i] = new HistogramBar(categories[i], height);
		}
		
		return bars;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
	}
}
