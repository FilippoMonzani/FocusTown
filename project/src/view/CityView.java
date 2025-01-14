package view;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
public class CityView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		contentPane.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		//panel.add(lblNewLabel_2);
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

		    

		    // Immagine di sinistra
		    lblNewLabel.setIcon(buildingIcon);
		    lblNewLabel.setBounds(startX, startY, imageWidth, imageHeight);
		    contentPane.add(lblNewLabel);

		    // Immagine centrale (abbassata di centralYOffset)
		    lblNewLabel_1.setIcon(buildingIcon);
		    lblNewLabel_1.setBounds(startX + (imageWidth + spacing), startY + centralYOffset, imageWidth, imageHeight);
		    contentPane.add(lblNewLabel_1);

		    // Immagine di destra
		    lblNewLabel_2.setIcon(buildingIcon);
		    lblNewLabel_2.setBounds(startX + 2 * (imageWidth + spacing), startY, imageWidth, imageHeight);
		    contentPane.add(lblNewLabel_2);

		} catch (Exception e) {
		    System.out.println("Error during the image uploading");
		    e.printStackTrace();
		}

	}

} 
