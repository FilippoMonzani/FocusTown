package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import main.controller.HistogramManager;
import main.model.Building;
import main.model.City;
import main.model.GroupByNumberOfBuildings;
import main.model.GroupByStudyHours;
import main.model.HistogramAdapter;
import main.model.HistogramBar;
import main.model.User;
import main.view.HistogramPanel;

public class HistogramTest {
	
	HistogramPanel panel;
	HistogramManager manager;
	HistogramAdapter adapter;
		
	public HistogramTest() {
		panel = new HistogramPanel();
		manager = new HistogramManager(panel);
		adapter = new HistogramAdapter();
	}
	
	public List<Building> getData() {
		User u = new User();
		List<Building> buildings = new ArrayList<>();
		buildings.add(new Building(Duration.ofHours(3), "Analisi 1", u, LocalDateTime.of(2025, 1, 20, 1, 1))); // 2025-1-20
		buildings.add(new Building(Duration.ofHours(2), "Analisi 2", u, LocalDateTime.of(2025, 1, 20, 1, 1)));
		buildings.add(new Building(Duration.ofHours(3), "Elettronica", u, LocalDateTime.of(2025, 1, 21, 1, 1)));
		buildings.add(new Building(Duration.ofHours(4), "Ingegneria del Software", u, LocalDateTime.of(2025, 1, 22, 1, 1)));
		buildings.add(new Building(Duration.ofHours(1), "Fisica 1", u, LocalDateTime.of(2025, 1, 23, 1, 1)));
		buildings.add(new Building(Duration.ofHours(2), "Fisica 2", u, LocalDateTime.of(2025, 1, 23, 1, 1)));
		buildings.add(new Building(Duration.ofHours(2), "Algebra lineare", u, LocalDateTime.of(2025, 1, 23, 1, 1)));
		
		buildings.add(new Building(Duration.ofHours(2), "Economia", u, LocalDateTime.of(2026, 1, 23, 1, 1)));
		buildings.add(new Building(Duration.ofHours(2), "Calcolatori elettronici", u, LocalDateTime.of(2027, 1, 23, 1, 1)));
		buildings.add(new Building(Duration.ofHours(2), "Sistemi operativi", u, LocalDateTime.of(2028, 1, 23, 1, 1)));
		buildings.add(new Building(Duration.ofHours(2), "Automatica", u, LocalDateTime.of(2030, 1, 23, 1, 1)));
		return buildings;
	}
	
	// Test methods from HistogramManager
	
	@Test
	public void getBuildingsMapTest() {
		List<Building> buildings = getData();
		
		manager.setStrategy(new GroupByNumberOfBuildings());
		
		// Integer: day of month, Long: number of buildings
		Map<Integer, Long> buildingsPerDay = manager.getBuildingsMap(2025, 1, buildings);
		
		for (int i = 1; i < 20; i++) {
			assertEquals(buildingsPerDay.get(i).longValue(), 0);
		}
		assertEquals(buildingsPerDay.get(20).longValue(), 2);
		assertEquals(buildingsPerDay.get(21).longValue(), 1);
		assertEquals(buildingsPerDay.get(22).longValue(), 1);
		assertEquals(buildingsPerDay.get(23).longValue(), 3);
		for (int i = 24; i < 32; i++) {
			assertEquals(buildingsPerDay.get(i).longValue(), 0);
		}
	}
	
	@Test
	public void testStudyHoursStrategy() {
		List<Building> buildings = getData();
		// Test other strategy
		manager.setStrategy(new GroupByStudyHours());
		// Integer: day of month, Long: number of buildings
		Map<Integer, Long> buildingsPerDay = manager.getBuildingsMap(2025, 1, buildings);
		for (int i = 1; i < 20; i++) {
			assertEquals(buildingsPerDay.get(i).longValue(), 0);
		}
		assertEquals(buildingsPerDay.get(20).longValue(), 5);
		assertEquals(buildingsPerDay.get(21).longValue(), 3);
		assertEquals(buildingsPerDay.get(22).longValue(), 4);
		assertEquals(buildingsPerDay.get(23).longValue(), 5);
		for (int i = 24; i < 32; i++) {
			assertEquals(buildingsPerDay.get(i).longValue(), 0);
		}
	}
	
	@Test
	public void getYearRangeTest() {
		List<Building> buildings = getData();
		
		List<Integer> yearRange = manager.getYearRange(buildings);
		assertEquals(yearRange.get(0).longValue(), 2025);
		assertEquals(yearRange.get(1).longValue(), 2026);
		assertEquals(yearRange.get(2).longValue(), 2027);
		assertEquals(yearRange.get(3).longValue(), 2028);
		assertEquals(yearRange.get(4).longValue(), 2030);
	}
	
	@Test
	public void setStrategyTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = manager.getClass().getDeclaredField("strategy");
		f.setAccessible(true);

		manager.setStrategy(new GroupByStudyHours());
		assertEquals(f.get(manager).getClass(), GroupByStudyHours.class);

		manager.setStrategy(new GroupByNumberOfBuildings());
		assertEquals(f.get(manager).getClass(), GroupByNumberOfBuildings.class);
	}
	
	@Test
	public void setCityTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = manager.getClass().getDeclaredField("city");
		f.setAccessible(true);
		
		City c = new City();
		manager.setCity(c);
		
		assertEquals(f.get(manager), c);
	}
	
	// Test methods from HistogramAdapter
	
	@Test
	public void getHistogramBarsTest() {
		List<Building> buildings = getData();
		manager.setStrategy(new GroupByNumberOfBuildings());
		Map<Integer, Long> buildingsPerDay = manager.getBuildingsMap(2025, 1, buildings);
		
		assertEquals(adapter.getHistogramBars(Collections.emptyMap()), Collections.emptyList());
		
		List<HistogramBar> bars = adapter.getHistogramBars(buildingsPerDay);
		
		for (int i = 0; i < bars.size(); i++) {
			HistogramBar b = bars.get(i);
			
			// Check labels (days of the month)
			assertEquals(b.getLabel(), String.valueOf(i+1));

			// Check that display value matches value in map
			assertEquals(b.getDisplayValue(), buildingsPerDay.get(i+1).toString());
		}
		
		// Check what happens to height of bars if max value in the map is zero
		buildingsPerDay = new HashMap<>();
		buildingsPerDay.put(Integer.valueOf(1), Long.valueOf(0));
		buildingsPerDay.put(Integer.valueOf(2), Long.valueOf(0));
		buildingsPerDay.put(Integer.valueOf(3), Long.valueOf(0));
		bars = adapter.getHistogramBars(buildingsPerDay);
		assertNotEquals(bars.get(0).getHeight(), 0);
	}
	
	@Test
	public void setDataTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field f = adapter.getClass().getDeclaredField("data");
		f.setAccessible(true);
		
		Map<Integer, Long> data = manager.getBuildingsMap(2025, 1, getData());
		adapter.setData(data);
		
		assertEquals(f.get(adapter), data);
	}
}
