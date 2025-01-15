package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ImageUtils {
	/**
	 * Loads an image from the specified path and returns it as a scaled
	 * {@code ImageIcon}.
	 *
	 * @param size      the desired {@code Dimension} for scaling the image
	 * @param imagePath the path to the image file
	 * @return a {@code ImageIcon} representing the scaled image
	 * @throws NullPointerException if {@code size} is {@code null}
	 */
	public static ImageIcon loadImageAsIcon(Dimension size, String imagePath) {
		if (size == null) {
			throw new NullPointerException(
					"size cannot be set to null when calling ImageUtils.loadImageAsIcon() method!");
		}
		ImageIcon icon = new ImageIcon(imagePath);
		Image tmpImage = icon.getImage();
		tmpImage = tmpImage.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(tmpImage);
	}
}
