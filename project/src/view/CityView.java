package view;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.Level;

import main.FocusApp;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

/**
 * The {@link CityView} class represents a graphical user interface (GUI) for displaying
 * images of buildings. It extends {@link JFrame} and is used to visualize images 
 * in a centered layout on the screen.
 * 
 * <p>The class includes methods for setting up the frame, loading images, and displaying them
 * in a visually appealing arrangement. The view consists of a main panel with three images
 * displayed horizontally across the center of the window.</p>
 * 
 * <p>Key features of the {@link CityView} class include:
 * <ul>
 *     <li>Display of images using {@link JLabel} components.</li>
 *     <li>Dynamic centering of images on the screen.</li>
 *     <li>Error handling for loading images.</li>
 * </ul>
 * </p>
 */
public class CityView extends JFrame implements View {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JPanel centerPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CityView frame = new CityView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
			}
		}
		});
	}

	/**
     * Constructs the {@link CityView} frame with its components and layout.
     * Initializes the content pane, image labels, and sets up the frame with the
     * specified bounds. Attempts to load and display images from a specified 
     * file path.
     */
	public CityView() {
		
		
		try {
		    String imagePath = "src/resources/th10.jpg"; 
		    ImageIcon buildingIcon = new ImageIcon(new File(imagePath).getAbsolutePath());

		    int imageWidth = 200;
		    int imageHeight = 200;
		    int spacing = 100; // Spazio aumentato tra le immagini

		    int totalWidth = (imageWidth * 3) + (spacing * 2);
		    int screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		    int screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

		    int startX = (screenWidth - totalWidth) / 2; 
		    int startY = (screenHeight - imageHeight) / 2; // Per allineare orizzontalmente
		    int centralYOffset = 50; // Offset aggiuntivo per abbassare l'immagine centrale
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			contentPane.add(centerPanel);
			centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
			
			Component horizontalGlue = Box.createHorizontalGlue();
			centerPanel.add(horizontalGlue);
					    
					    JLabel rightImage = new JLabel("");
					    centerPanel.add(rightImage);
					    rightImage.setHorizontalAlignment(SwingConstants.CENTER);
					    
					    		    // Immagine di destra
					    		    rightImage.setIcon(buildingIcon);
					    		    rightImage.setBounds(startX + 2 * (imageWidth + spacing), startY, imageWidth, imageHeight);
			
			JLabel spaceLabel1 = new JLabel("                              ");
			centerPanel.add(spaceLabel1);
			
			JLabel centerImage = new JLabel("");
			centerPanel.add(centerImage);
			centerImage.setHorizontalAlignment(SwingConstants.CENTER);
			
					    // Immagine centrale (abbassata di centralYOffset)
					    centerImage.setIcon(buildingIcon);
					    centerImage.setBounds(startX + (imageWidth + spacing), startY + centralYOffset, imageWidth, imageHeight);
			
			JLabel spaceLabel2 = new JLabel("                              ");
			centerPanel.add(spaceLabel2);
			
			JLabel leftImage = new JLabel("");
			centerPanel.add(leftImage);
			leftImage.setHorizontalAlignment(SwingConstants.CENTER);
			
					    
			
					    // Immagine di sinistra
					    leftImage.setIcon(buildingIcon);
					    leftImage.setBounds(startX, startY, imageWidth, imageHeight);
					    
					    Component horizontalGlue_1 = Box.createHorizontalGlue();
					    centerPanel.add(horizontalGlue_1);
					    
					    JPanel northPanel = new JPanel();
					    FlowLayout flowLayout = (FlowLayout) northPanel.getLayout();
					    flowLayout.setAlignment(FlowLayout.RIGHT);
					    contentPane.add(northPanel, BorderLayout.NORTH);
					    
					    JLabel screenshotIcon = new JLabel("ScreenshotIcon");
					    screenshotIcon.setHorizontalAlignment(SwingConstants.LEFT);
					    northPanel.add(screenshotIcon);
					    
					    JLabel leftArrowIcon = new JLabel("left arr");
					    contentPane.add(leftArrowIcon, BorderLayout.WEST);
					    
					    JLabel rightArrowIcon = new JLabel("right arr");
					    contentPane.add(rightArrowIcon, BorderLayout.EAST);
					    
					    JPanel southPanel = new JPanel();
					    contentPane.add(southPanel, BorderLayout.SOUTH);
					    
					    JLabel lblNewLabel = new JLabel("Builidng Description");
					    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
					    southPanel.add(lblNewLabel);

		} catch (Exception e) {
			FocusApp.getLogger().log(Level.ERROR, "Error during the image uploading");
		    e.printStackTrace();
		}

	}

} 
