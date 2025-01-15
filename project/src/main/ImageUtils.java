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
	
	/**
	 * Loads an image from the specified path, applies a hue shift, and returns it as a scaled
	 * {@code ImageIcon}.
	 *
	 * @param size      the desired {@code Dimension} for scaling the image
	 * @param imagePath the path to the image file
	 * @param hueShift  the amount of hue shift to apply, in the range [-1.0, 1.0]
	 * @return a {@code ImageIcon} representing the scaled and hue-shifted image
	 * @throws NullPointerException if {@code size} is {@code null}
	 */
	public static ImageIcon loadImageAsIcon(Dimension size, String imagePath, float hueShift) {
	    if (size == null) {
	        throw new NullPointerException(
	                "size cannot be set to null when calling ImageUtils.loadImageAsIcon() method!");
	    }

	    // Load the image
	    ImageIcon icon = new ImageIcon(imagePath);
	    Image tmpImage = icon.getImage();
	    BufferedImage bufferedImage = new BufferedImage(
	            tmpImage.getWidth(null),
	            tmpImage.getHeight(null),
	            BufferedImage.TYPE_INT_ARGB
	    );

	    Graphics2D g2d = bufferedImage.createGraphics();
	    g2d.drawImage(tmpImage, 0, 0, null);
	    g2d.dispose();

	    // Apply hue shift
	    for (int x = 0; x < bufferedImage.getWidth(); x++) {
	        for (int y = 0; y < bufferedImage.getHeight(); y++) {
	            int rgb = bufferedImage.getRGB(x, y);
	            Color color = new Color(rgb, true);
	            float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);

	            hsb[0] = (hsb[0] + hueShift) % 1.0f;
	            if (hsb[0] < 0) hsb[0] += 1.0f;

	            int newRgb = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
	            bufferedImage.setRGB(x, y, newRgb);
	        }
	    }

	    Image scaledImage = bufferedImage.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
	    BufferedImage finalImage = new BufferedImage(
	            size.width,
	            size.height,
	            BufferedImage.TYPE_INT_ARGB
	    );

	    g2d = finalImage.createGraphics();
	    g2d.drawImage(scaledImage, 0, 0, null);
	    g2d.dispose();

	    return new ImageIcon(finalImage);
	}
}
