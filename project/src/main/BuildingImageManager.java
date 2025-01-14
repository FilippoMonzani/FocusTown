package main;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import model.Building;
import model.City;

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

public class BuildingImageManager {
	private City city;
	private int selectedBuilding;
	private final ImageIcon emptyIcon;

	public BuildingImageManager() {
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
			path = "Edificio0.jpg"; //TODO: change this to return an empty image
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
		return loadImageAsIcon(size, selectPath(building));
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

	/**
	 * Loads an image from the specified path and returns it as a scaled
	 * {@code ImageIcon}.
	 *
	 * @param size      the desired {@code Dimension} for scaling the image
	 * @param imagePath the path to the image file
	 * @return a {@code ImageIcon} representing the scaled image
	 * @throws NullPointerException if {@code size} is {@code null}
	 */
	private static ImageIcon loadImageAsIcon(Dimension size, String imagePath) {
		if (size == null) {
			throw new NullPointerException(
					"size cannot be set to null when calling ImageUtils.loadImageAsIcon() method!");
		}
		ImageIcon icon = new ImageIcon(imagePath);
		Image tmpImage = icon.getImage();
		tmpImage = tmpImage.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(tmpImage);
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

	public void setCity(City city) {
		this.city = city;
	}
	
	public String getDescription() {
		Building current = city.getBuildings().get(selectedBuilding); 
		return String.format("<html>Subject: %s<br>Duration: %d hours %d minutes</html>", current.getSubject(), current.getDuration().toHours(), current.getDuration().toMinutesPart());
	}
}
