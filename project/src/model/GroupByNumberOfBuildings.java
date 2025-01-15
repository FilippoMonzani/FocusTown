package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Aggregates data by grouping buildings based on the day of the month they belong to
 * for a specified year and month.
 *
 * <p>This class implements the {@link DataGroupByStrategy} interface and provides a 
 * specific implementation for aggregating data by counting the number of buildings 
 * for each day in a given month and year.</p>
 *
 * <p>The method filters the list of buildings to include only those whose timestamps
 * match the specified year and month. It then groups the filtered buildings by the
 * day of the month extracted from their timestamps and counts the number of buildings
 * for each day.</p>
 *
 * @param year      the year for which data should be aggregated
 * @param month     the month (1-based) for which data should be aggregated
 * @param buildings the list of {@link Building} objects to process
 * @return a {@link Map} where the keys represent the day of the month (1-based),
 *         and the values represent the count of buildings for that day
 */
public class GroupByNumberOfBuildings implements DataGroupByStrategy{

	/**
	 * Aggregates the buildings by counting the number of buildings for each day in a 
	 * specified year and month.
	 * 
	 * <p>This method filters the buildings by the given year and month, then groups 
	 * them by the day of the month and counts the total number of buildings for each day.</p>
	 * 
	 * @param year the year for which data should be aggregated
	 * @param month the month (1-based) for which data should be aggregated
	 * @param buildings the list of {@link Building} objects to process
	 * @return a {@link Map} where the keys are the day of the month (1-based), and the values 
	 *         are the count of buildings for each respective day
	 */
	@Override
	public Map<Integer, Long> aggregate(int year, int month, List<Building> buildings) {
		return buildings.stream()
		.filter(b -> b.getTimeStamp().getYear() == year && b.getTimeStamp().getMonthValue() == month)
		.collect(Collectors.groupingBy(b -> b.getTimeStamp().getDayOfMonth(), Collectors.counting()));
	}

}
