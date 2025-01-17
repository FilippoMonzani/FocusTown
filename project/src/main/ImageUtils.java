package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.apache.logging.log4j.Level;

/**
 * Class with static methods to operate and apply effects to images
 */
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

	/**
	 * Converts an {@link ImageIcon} to a {@link BufferedImage}
	 * @param icon
	 * @return
	 */
	public static BufferedImage toBufferedImage(ImageIcon icon) {
		BufferedImage bi = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.createGraphics();
		// paint the Icon to the BufferedImage.
		icon.paintIcon(null, g, 0, 0);
		g.dispose();
		return bi;
	}

	/**
	 * Applies a shift the hue value of this image
	 * 
	 * @param icon  {@code ImageIcon}
	 * @param shift shift to apply in range [-1.0, 1.0]
	 * @return an {@code ImageIcon} with shifted hue value
	 */
	public static ImageIcon shiftColor(ImageIcon icon, double shift) {
		BufferedImage bi = toBufferedImage(icon);

		for (int y = 0; y < bi.getHeight(); y++) {
			for (int x = 0; x < bi.getWidth(); x++) {

				// Convert RGB to HSB
				Color rgbColor = new Color(bi.getRGB(x, y), true);
				float[] hsbColor = Color.RGBtoHSB(rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue(), null);

				// Apply shift
				hsbColor[0] = (float) ((hsbColor[0] + shift) % 1.0);
				if (hsbColor[0] < 0) {
					hsbColor[0] += 1.0f;
				}

				// Convert HSB to RGB
				int newRgb = Color.HSBtoRGB(hsbColor[0], hsbColor[1], hsbColor[2]);
				
				// Set new color on the pixel
				bi.setRGB(x, y, newRgb);
			}
		}
		return new ImageIcon(bi);
	}
}
