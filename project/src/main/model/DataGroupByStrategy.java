package main.model;

import java.util.List;
import java.util.Map;

/**
 * Represents a strategy for aggregating building data for a specific year and month.
 * <p>
 * This functional interface is used to define various ways of grouping and aggregating
 * data from a list of buildings, such as by the number of buildings per day, study hours,
 * or any other metric defined by the implementing strategy.
 * </p>
 */
@FunctionalInterface
public interface DataGroupByStrategy {
	
	/**
	 * Aggregates the data for a specific year and month, returning a map where the key 
	 * is the day of the month and the value is the aggregated result for that day (e.g., 
	 * the number of buildings or total study hours).
	 * 
	 * @param year The year for which the aggregation is performed.
	 * @param month The month for which the aggregation is performed.
	 * @param buildings The list of buildings to aggregate.
	 * @return A map where the key is the day of the month and the value is the aggregated data for that day.
	 */
	Map<Integer, Long> aggregate(int year, int month, List<Building> buildings);
}
