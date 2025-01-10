package view;

import java.awt.EventQueue;
import javax.swing.*; 
import javax.swing.border.EmptyBorder;
import java.io.File;

public class CityView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    
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

  
    public CityView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400); 

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); 

        setContentPane(contentPane);

        JLabel buildingLabel = new JLabel(); 
        try {
            String imagePath = "src/resources/th10.jpg"; // 
            ImageIcon buildingIcon = new ImageIcon(new File(imagePath).getAbsolutePath());
            buildingLabel.setIcon(buildingIcon);
        } catch (Exception e) {
            System.out.println("error during the image uploading");
            e.printStackTrace();
        }

        buildingLabel.setBounds(50, 50, 200, 200);
        contentPane.add(buildingLabel); 
    }
}
