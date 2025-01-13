package main;

import java.awt.Dimension;
import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;

import model.Building;

public class BuildingImageManager {
	
	private Map<Building, ImageIcon> buildingImages;
	
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
	
	public void addBuilding(Building building, Dimension size) {
		ImageIcon img = loadImageAsIcon(size, buildingToImage(building));
		buildingImages.put(building, img);
	}
	
	public Map<Building, ImageIcon> getImages() {
		return buildingImages;
	}
	
	/**
	 * The method {@code loadImageAsIcon} returns an ImageIcon loaded from the specified path
	 * @param size
	 * @param imagePath
	 * @return ImageIcon
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
