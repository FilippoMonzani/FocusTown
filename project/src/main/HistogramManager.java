package main;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Building;
import model.DataGroupByStrategy;
import model.GroupByNumberOfBuildings;
import model.HistogramAdapter;
import model.User;
import view.HistogramPanel;

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
		List<Building> buildings = getTestBuildings(); //TODO: change this to use buildings from a user's city

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
     * Sets a new data aggregation strategy to be used when generating the histogram.
     * 
     * @param strategy The new data aggregation strategy.
     */
	public void setStrategy(DataGroupByStrategy strategy) {
		this.strategy = strategy;
	}

	// TODO: remove this method (only used for testing the gui)
	public List<Building> getTestBuildings() {
		List<Building> testBuildings = new ArrayList<Building>(); // Y M D
		testBuildings
				.add(new Building(Duration.ofHours(1), "Analisi 1", new User(), LocalDateTime.of(2024, 2, 2, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(10), "Analisi 1", new User(), LocalDateTime.of(2024, 2, 3, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(1), "Analisi 1", new User(), LocalDateTime.of(2024, 2, 6, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(1), "Analisi 1", new User(), LocalDateTime.of(2024, 2, 6, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(5), "Analisi 1", new User(), LocalDateTime.of(2024, 2, 6, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(2), "Analisi 1", new User(), LocalDateTime.of(2025, 2, 3, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(3), "Analisi 1", new User(), LocalDateTime.of(2025, 2, 5, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(1), "Analisi 1", new User(), LocalDateTime.of(2025, 2, 10, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(1), "Analisi 1", new User(), LocalDateTime.of(2025, 2, 20, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(2), "Analisi 1", new User(), LocalDateTime.of(2025, 2, 20, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(2), "Analisi 4", new User(), LocalDateTime.of(2025, 2, 10, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(2), "Analisi 5", new User(), LocalDateTime.of(2025, 3, 10, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(2), "Analisi 5", new User(), LocalDateTime.of(2025, 3, 10, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(7), "Analisi 5", new User(), LocalDateTime.of(2025, 3, 12, 12, 2)));
		testBuildings
				.add(new Building(Duration.ofHours(5), "Analisi 5", new User(), LocalDateTime.of(2025, 2, 10, 12, 2)));
		return testBuildings;
	}
}
