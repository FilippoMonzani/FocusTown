package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.HistogramBar;
/**
 * This class renders a histogram of bars from the data in HistogramBar[]
 * 
 * @author LorenzoCorbellini
 */
public class HistogramPanel extends JPanel {
	
	private HistogramBar[] bars = null;
	
	public HistogramPanel(HistogramBar[] bars) {
		this.bars = bars;
	}
	
	public HistogramPanel() {
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (bars == null) {
			//TODO: show "no data" message
			return;
		}
		
		int barWidth = this.getWidth() / bars.length;
		int maxHeight = this.getHeight();
		
		for(int i = 0; i < bars.length; i++) {
			int barHeight = (int) (bars[i].getHeight() * maxHeight);
			
			int x = i * barWidth;
			int y = maxHeight - barHeight;
			
			g.setColor(bars[i].getBarColor());
			g.fillRect(x, y, barWidth - 10, barHeight); // Draw bars (-10 to add padding)

			// Draw value above bar
			g.setColor(Color.WHITE);
			g.drawString(String.valueOf(bars[i].getHeight()), x + (barWidth / 4), y + 15);

			// Draw label below bar
			g.setColor(Color.WHITE);
			g.drawString(bars[i].getLabel(), x + (barWidth / 4), maxHeight - 5);
		}
		
	}
	
	public void setBars(HistogramBar[] bars) {
		this.bars = bars;
	}
}
