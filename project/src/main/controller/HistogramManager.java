package main.controller;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.model.Building;
import main.model.City;
import main.model.DataGroupByStrategy;
import main.model.GroupByNumberOfBuildings;
import main.model.HistogramAdapter;
import main.view.HistogramPanel;

/**
 * Manages the generation and display of histograms based on a data aggregation strategy.
 * <p>
 * This class is responsible for updating the histogram displayed in a {@link HistogramPanel}.
 * It allows switching between different data aggregation strategies (e.g., aggregating by number of buildings or study hours).
 * The histogram is updated for a specific month and year based on the provided strategy.
 * </p>
 */
public class HistogramManager {

	private final HistogramPanel panel;
	private City city;
	private DataGroupByStrategy strategy;

	  /**
     * Constructs a HistogramManager with a default strategy of grouping by the number of buildings.
     * 
     * @param panel The {@link HistogramPanel} to display the histogram.
     */
	public HistogramManager(HistogramPanel panel) {
		this(panel, new GroupByNumberOfBuildings());
	}

	  /**
     * Constructs a HistogramManager with a custom data aggregation strategy.
     * 
     * @param panel   The {@link HistogramPanel} to display the histogram.
     * @param strategy The strategy for aggregating data (e.g., grouping by number of buildings or study hours).
     */
	public HistogramManager(HistogramPanel panel, DataGroupByStrategy strategy) {
		this.panel = panel;
		this.strategy = strategy;
	}

	/**
     * Updates the histogram for the specified year and month using the current data aggregation strategy.
     * 
     * @param year  The year for which to generate the histogram.
     * @param month The month for which to generate the histogram.
     */
	public void updateHistogram(int year, int month) {
		List<Building> buildings = city.getBuildings();

		HistogramAdapter ha = new HistogramAdapter();

		ha.setData(getBuildingsMap(year, month, buildings));

		panel.setBars(ha.getHistogramBars());
		panel.repaint();
	}

	 /**
     * Generates a map of building data aggregated by day for a specified year and month.
     * 
     * @param year      The year for the aggregation.
     * @param month     The month for the aggregation.
     * @param buildings The list of buildings to aggregate.
     * @return A map where the key is the day of the month, and the value is the aggregated data (e.g., count of buildings).
     */
	public Map<Integer, Long> getBuildingsMap(int year, int month, List<Building> buildings) {
		int days = YearMonth.of(year, month).lengthOfMonth();
		Map<Integer, Long> histogram = new HashMap<>();
		for (int i = 0; i < days; i++) {
			histogram.put(i + 1, 0L);
		}
		
		Map<Integer, Long> buildingsPerDay = strategy.aggregate(year, month, buildings);
		buildingsPerDay.forEach(histogram::put);
		return histogram;
	}
	
	/**
	 * Determines the range of years to display
	 * @return A list containing the range of years in order
	 */
	public List<Integer> getYearRange(List<Building> buildings) {
		Set<Integer> uniqueYears = new HashSet<>();
		buildings.stream()
			.map(b -> b.getTimeStamp().getYear())
			.forEach(y -> uniqueYears.add(y));
		List<Integer> result = new ArrayList<>(uniqueYears);
		result.sort(Integer::compareTo);
		return result;
	}
	
	public List<Integer> getYearRange() {
		return getYearRange(this.city.getBuildings());
	}

	  /**
     * Sets a new data aggregation strategy to be used when generating the histogram.
     * 
     * @param strategy The new data aggregation strategy.
     */
	public void setStrategy(DataGroupByStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * Set the {@code City} used by this manager
	 * @param city
	 */
	public void setCity(City city) {
		this.city = city;
	}
}
