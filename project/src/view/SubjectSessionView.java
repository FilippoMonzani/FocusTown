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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

/**
 * The {@link SubjectSessionView} class represents the user interface for a session where the user 
 * can input the subject of study for a specific session.
 * 
 * <p>This view includes a text field for entering the subject name, a "Confirm" button, and 
 * an image to indicate the successful creation of a building (as an example image).</p>
 * 
 * <p>Key Features:
 * <ul>
 *     <li>A text field for entering the subject of study.</li>
 *     <li>A "Confirm" button to submit the subject of study.</li>
 *     <li>A success message displayed at the top.</li>
 *     <li>An image representing a building or success displayed at the bottom.</li>
 * </ul>
 * </p>
 */
public class SubjectSessionView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField subjectField;
    private JButton confirmButton;
   

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
     * Creates the frame for the SubjectSessionView, including all components and layout.
     * This view allows the user to input the subject of study for a session.
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

        JLabel lblNewLabel = new JLabel("You nailed it!");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
        
        subjectField = new JTextField();
        panel.add(subjectField);
        subjectField.setColumns(10);

        // Bottom panel for additional message and building image
        JPanel bottomPanel = new JPanel();
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        JLabel lblBuildingImage = new JLabel();
        lblBuildingImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuildingImage.setIcon(new ImageIcon("path/to/your/building/image.jpg")); // Placeholder for the image
        bottomPanel.add(lblBuildingImage);
        
        Component horizontalGlue_1 = Box.createHorizontalGlue();
        bottomPanel.add(horizontalGlue_1);
        
        confirmButton = new JButton("Confirm");
        confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        bottomPanel.add(confirmButton);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        bottomPanel.add(horizontalGlue);
    }
    

    /**
     * Retrieves the confirm button.
     * 
     * @return the confirm button
     */
    public JButton getConfirmButton() {
		return confirmButton;
	}

    /**
     * Sets the confirm button.
     * 
     * @param confirmButton the confirm button to set
     */
	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}
	
	/**
     * Retrieves the text field where the subject of study is entered.
     * 
     * @return the subject text field
     */
	public JTextField getSubjectField() {
		return subjectField;
	}

	 /**
     * Sets the subject text field.
     * 
     * @param subjectField the subject text field to set
     */ 
	public void setSubjectField(JTextField subjectField) {
		this.subjectField = subjectField;
	}
}
