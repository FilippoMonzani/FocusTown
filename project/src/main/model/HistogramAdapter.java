package main.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Adapter for generating histogram bars from a data map. The map associates
 * each label on the X-axis (of type Integer) with a value on the Y-axis (of type
 * Long). The class calculates the height of each bar based on the relative
 * values in the map.
 * 
 */
public class HistogramAdapter {
	// Map associating X-axis labels with Y-axis values
	private Map<Integer, Long> data;

	/**
	 * Constructs an adapter with the provided data.
	 * 
	 * @param data The data map for the histogram, associating labels with values.
	 */
	public HistogramAdapter(Map<Integer, Long> data) {
		this.data = data;
	}

	public HistogramAdapter() {

	}

	/**
	 * Computes the histogram bars from the data provided to the adapter.
	 * 
	 * @return A list of HistogramBar objects representing the bars for the
	 *         histogram. An empty list if the map is empty.
	 */
	public List<HistogramBar> getHistogramBars(Map<Integer, Long> data) {

		if (data.isEmpty()) {
			return Collections.emptyList();
		}

		List<HistogramBar> bars = new LinkedList<>();
		
		// if max is 0, then 1 is returned as fallback value
		float maxValue = data.values().stream()
				.max(Long::compare)
				.filter(value -> value != 0)
				.orElse(1L);

		data.forEach((label, value) -> {
			float height = value / maxValue;

			bars.add(new HistogramBar(label.toString(), String.valueOf(value), height));
		});

		return bars;
	}
	
	public List<HistogramBar> getHistogramBars() {
		return getHistogramBars(this.data);
	}

	/**
	 * Sets the data for the histogram.
	 * 
	 * @param data The data map to associate labels with values.
	 */
	public void setData(Map<Integer, Long> data) {
		this.data = data;
	}

	/**
	 * Retrieves the set of categories (labels) for the X-axis.
	 * 
	 * @return A set of the labels for the X-axis.
	 */
	public Set<Integer> getCategories() {
		return data.keySet();
	}
}
