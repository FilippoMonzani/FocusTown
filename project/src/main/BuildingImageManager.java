package main;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;

import model.Building;

/**
 * The {@code BuildingImageManager} class is responsible for managing the mapping 
 * between {@code Building} objects and their corresponding image representations 
 * in the form of {@code ImageIcon}.
 * <p>
 * This class provides methods to determine the appropriate image for a building 
 * based on its duration, load images with specified dimensions, and store mappings 
 * of buildings to their images.
 * </p>
 */

public class BuildingImageManager {
	/**
     * A map that associates {@code Building} objects with their corresponding {@code ImageIcon}.
     */
	private Map<Building, ImageIcon> buildingImages;
	/**
     * Determines the image file name corresponding to a building based on its duration.
     *
     * @param building the {@code Building} object whose image needs to be determined
     * @return a {@code String} representing the image file name for the building
     */
	public String buildingToImage(Building building) {
		String path = "";
				
		long duration =building.getDuration().toHours(); 
		if(duration <= 1L) {
			path = "Edificio1.png";
		} else if(duration <= 2L && duration > 1L) {
			path = "Edificio2.png";
		} else if(duration <= 3L && duration > 2L) {
			path = "Edificio3.png";
		} else if(duration <= 4L && duration > 3L) {
			path = "Edificio4.png";
		} else {
			path = "Edificio5.png";
		}
		
		return path;
	}
	
	/**
     * Adds a {@code Building} object to the map along with its corresponding {@code ImageIcon},
     * scaled to the specified size.
     *
     * @param building the {@code Building} object to be added
     * @param size the desired {@code Dimension} of the image
     * @throws NullPointerException if {@code size} is {@code null}
     */
	
	public void addBuilding(Building building, Dimension size) {
		ImageIcon img = loadImageAsIcon(size, buildingToImage(building));
		buildingImages.put(building, img);
	}
	
	/**
     * Retrieves the map of {@code Building} objects and their corresponding {@code ImageIcon}.
     *
     * @return a {@code Map} containing the association between buildings and their images
     */
	public Map<Building, ImageIcon> getImages() {
		return buildingImages;
	}
	
	 /**
     * Loads an image from the specified path and returns it as a scaled {@code ImageIcon}.
     *
     * @param size the desired {@code Dimension} for scaling the image
     * @param imagePath the path to the image file
     * @return a {@code ImageIcon} representing the scaled image
     * @throws NullPointerException if {@code size} is {@code null}
     */
	public static ImageIcon loadImageAsIcon(Dimension size, String imagePath) {
		if(size == null) {
			throw new NullPointerException("size cannot be set to null when calling ImageUtils.loadImageAsIcon() method!");
		}
		ImageIcon icon = new ImageIcon(imagePath);
		Image tmpImage = icon.getImage();
		tmpImage = tmpImage.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(tmpImage);
	}
}
