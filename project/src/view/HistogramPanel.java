package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.HistogramBar;


/**
 * A panel for rendering a histogram of bars.
 * The histogram is created using a list of {@link HistogramBar} objects, 
 * each representing a bar with its label, value, height, and colors.
 */
public class HistogramPanel extends JPanel implements View{

	private List<HistogramBar> bars = null;

	/**
	 * Constructs a histogram panel with the given list of bars.
	 * 
	 * @param bars A list of {@link HistogramBar} objects to render.
	 */
	public HistogramPanel(List<HistogramBar> bars) {
		this.bars = bars;
	}

	public HistogramPanel() {

	}

	/**
	 * Paints the histogram on the panel.
	 * If no data is available, displays "NO DATA" at the center of the panel.
	 * 
	 * @param g The {@link Graphics} object used for drawing.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (bars == null || bars.isEmpty()) {
			g.setColor(Color.BLACK);
			g.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 30)); 
			g.drawString("NO DATA", this.getWidth() / 2, this.getHeight() / 2);
			return;
		}

		int barWidth = this.getWidth() / bars.size();
		int maxHeight = this.getHeight();

		
		for (int i = 0; i < bars.size(); i++) {
			HistogramBar bar = bars.get(i);
			int barHeight = (int) (bar.getHeight() * maxHeight + 5);

			int x = i * barWidth;
			int y = maxHeight - barHeight;

			g.setColor(bar.getBarColor());
			g.fillRect(x, y, barWidth - 10, barHeight); // Draw bars (-10 to add padding)

			g.setFont(new Font(ViewSettings.fontFamily, Font.PLAIN, 16));

			// Draw value above bar
			g.setColor(bar.getTextColor());
			g.drawString(bar.getDisplayValue(), x + (barWidth / 2 - 12), y + 24);

			// Draw label below bar
			if (bar.getHeight() == 0) {
				g.setColor(Color.BLACK);
			} else {				
				g.setColor(bar.getTextColor());
			}
			g.drawString(bar.getLabel(), x + (barWidth / 2 - 12), maxHeight - 10);
		}

	}

	/**
	 * Sets the list of bars to render in the histogram.
	 * 
	 * @param bars A list of {@link HistogramBar} objects.
	 */
	public void setBars(List<HistogramBar> bars) {
		this.bars = bars;
	}
}
