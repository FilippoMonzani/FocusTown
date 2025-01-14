package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Aggregates data by calculating the total study hours spent on each day of the month
 * for a specified year and month.
 *
 * <p>This class implements the {@link DataGroupByStrategy} interface and provides a 
 * specific implementation for aggregating data by summing the total study hours for 
 * each day in a given month and year.</p>
 *
 * <p>The method filters the list of buildings to include only those whose timestamps
 * match the specified year and month. It then groups the filtered buildings by the 
 * day of the month extracted from their timestamps and sums the duration (in hours) 
 * of all buildings for each day.</p>
 *
 * @param year      the year for which data should be aggregated
 * @param month     the month (1-based) for which data should be aggregated
 * @param buildings the list of {@link Building} objects to process
 * @return a {@link Map} where the keys represent the day of the month (1-based),
 *         and the values represent the total hours of study time for that day
 */
public class GroupByStudyHours implements DataGroupByStrategy {

	/**
	 * Aggregates the buildings by calculating the total study hours for each day in a 
	 * specified year and month.
	 * 
	 * <p>This method filters the buildings by the given year and month, then groups 
	 * them by the day of the month and sums the duration (in hours) for each respective day.</p>
	 * 
	 * @param year the year for which data should be aggregated
	 * @param month the month (1-based) for which data should be aggregated
	 * @param buildings the list of {@link Building} objects to process
	 * @return a {@link Map} where the keys are the day of the month (1-based), and the values 
	 *         are the total study hours for each respective day
	 */
	@Override
	public Map<Integer, Long> aggregate(int year, int month, List<Building> buildings) {
		return buildings.stream()
		.filter(b -> b.getTimeStamp().getYear() == year && b.getTimeStamp().getMonthValue() == month)
		.collect(Collectors.groupingBy(b -> b.getTimeStamp().getDayOfMonth(),
				Collectors.summingLong(b -> b.getDuration().toHours())));
	}

}
