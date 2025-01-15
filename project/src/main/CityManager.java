package main;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import model.Building;
import model.City;
import view.CityView;

/**
 * The {@code BuildingImageManager} class is responsible for managing the
 * mapping between {@code Building} objects and their corresponding image
 * representations in the form of {@code ImageIcon}.
 * <p>
 * This class provides methods to determine the appropriate image for a building
 * based on its duration, load images with specified dimensions, and store
 * mappings of buildings to their images.
 * </p>
 */

public class CityManager {
	private City city;
	private CityView cityView;
	private int selectedBuilding;
	private final ImageIcon emptyIcon;

	public CityManager() {
		selectedBuilding = 0;
		emptyIcon = new ImageIcon(new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB));
	}

	/**
	 * Determines the image file name corresponding to a building based on the
	 * duration if its study session.
	 *
	 * @param building the {@code Building} object whose image needs to be
	 *                 determined
	 * @return a {@code String} representing the image file name for the building
	 */
	public String selectPath(Building building) {
		String path = "";

		long duration = building.getDuration().toHours();
		if (duration < 1L) {
			path = "Edificio0.jpg";
		} else if (duration >= 1L && duration < 2L) {
			path = "Edificio1.jpg";
		} else if (duration >= 2L && duration < 3L) {
			path = "Edificio2.jpg";
		} else if (duration >= 3L && duration < 4L) {
			path = "Edificio3.jpg";
		} else if (duration >= 4L && duration < 5L) {
			path = "Edificio4.jpg";
		} else {
			path = "Edificio5.jpg";
		}

		return "src/resources/" + path;
	}

	/**
	 * Returns the icon representing a building based on the duration of its study
	 * session.
	 * 
	 * @param building the {@code Building} object whose icon needs to be determined
	 * @param size     a {@code Dimension} in pixels for the icon.
	 * @return an {@code ImageIcon} representing the building
	 */
	private ImageIcon getBuildingIcon(Building building, Dimension size) {
		return ImageUtils.loadImageAsIcon(size, selectPath(building));
	}

	/**
	 * Returns an icon with size 200x200 px representing a building based on the
	 * duration of its study session.
	 * 
	 * @param building the {@code Building} object whose icon needs to be determined
	 * @return an {@code ImageIcon} representing the building
	 */
	private ImageIcon getBuildingIcon(Building building) {
		return getBuildingIcon(building, new Dimension(200, 200));
	}

	public ImageIcon getLeftIcon() {
		return getIcon(selectedBuilding + 1);
	}

	public ImageIcon getCenterIcon() {
		return getIcon(selectedBuilding);
	}

	public ImageIcon getRightIcon() {
		return getIcon(selectedBuilding - 1);
	}

	/**
	 * Determines the icon of the image at index {@code index} in the current city's
	 * List. Returns an empty icon if {@code Index} is out of bounds
	 * 
	 * @param index
	 * @return
	 */
	public ImageIcon getIcon(int index) {
		try {
			return getBuildingIcon(city.getBuildings().get(index));
		} catch (IndexOutOfBoundsException e) {
			return emptyIcon;
		}
	}

	/**
	 * Selects the building to the right
	 */
	public void swipeRight() {
		selectedBuilding = Math.min(city.getBuildings().size() - 1, selectedBuilding + 1);
	}

	/**
	 * Selects the building to the left
	 */
	public void swipeLeft() {
		selectedBuilding = Math.max(0, selectedBuilding - 1);
	}

	public void setCity(City city, CityView cityView) {
		this.city = city;
		this.cityView = cityView;
	}

	/**
	 * Get the description of the selected building
	 * @return A string containing the HTML-formatted description for the selected building
	 */
	public String getDescription() {
		Building current = city.getBuildings().get(selectedBuilding);
		return String.format("<html>Subject: %s<br>Duration: %d hours %d minutes<br>Creation date: %s</html>",
				current.getSubject(), current.getDuration().toHours(), current.getDuration().toMinutesPart(),
				current.getTimeStamp().toLocalDate().toString());
	}
	
	/**
	 * Update building icons on the {@link CityView}
	 */
	public void updateIcons() {
		cityView.getLeftImage().setIcon(getLeftIcon());
		cityView.getCenterImage().setIcon(getCenterIcon());
		cityView.getRightImage().setIcon(getRightIcon());
		cityView.setBuildingDescription(getDescription());
	}
}
