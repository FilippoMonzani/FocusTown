package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SubjectSessionView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SubjectSessionView frame = new SubjectSessionView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public SubjectSessionView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Top panel for "Building created!" label
        JPanel topPanel = new JPanel();
        contentPane.add(topPanel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Building created!");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(lblNewLabel);

        // Center panel for subject input
        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout(0, 0));

        JLabel lblSubject = new JLabel("Insert the subject of study:");
        lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(lblSubject, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        centerPanel.add(panel, BorderLayout.CENTER);
        
        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);

        // Bottom panel for additional message and building image
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(0, 0));
        contentPane.add(bottomPanel, BorderLayout.SOUTH);

        JLabel lblUnlockedBuilding = new JLabel("Here is the unlocked building");
        lblUnlockedBuilding.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(lblUnlockedBuilding, BorderLayout.NORTH);

        JLabel lblBuildingImage = new JLabel();
        lblBuildingImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuildingImage.setIcon(new ImageIcon("path/to/your/building/image.jpg")); // Placeholder for the image
        bottomPanel.add(lblBuildingImage, BorderLayout.CENTER);
    }
}
