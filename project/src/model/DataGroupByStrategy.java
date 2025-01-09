package model;

import java.util.List;
import java.util.Map;

@FunctionalInterface
public interface DataGroupByStrategy {
	Map<Integer, Long> aggregate(int year, int month, List<Building> buildings);
}
