package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Aggregates data by calculating the total study hours spent on each day of the month
 * for a specified year and month.
 *
 * <p>This method filters the list of buildings to include only those whose timestamps
 * match the specified year and month. It then groups the filtered buildings by the day
 * of the month extracted from their timestamps and sums the duration (in hours) of all
 * buildings for each day.</p>
 *
 * @param year      the year for which data should be aggregated
 * @param month     the month (1-based) for which data should be aggregated
 * @param buildings the list of {@link Building} objects to process
 * @return a {@link Map} where the keys represent the day of the month (1-based),
 *         and the values represent the total hours of study time for that day
 *
 */
public class GroupByStudyHours implements DataGroupByStrategy {

	@Override
	public Map<Integer, Long> aggregate(int year, int month, List<Building> buildings) {
		return buildings.stream()
		.filter(b -> b.getTimeStamp().getYear() == year && b.getTimeStamp().getMonthValue() == month)
		.collect(Collectors.groupingBy(b -> b.getTimeStamp().getDayOfMonth(),
				Collectors.summingLong(b -> b.getDuration().toHours())));
	}

}
