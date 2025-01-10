package view;

import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;
import javax.swing.text.JTextComponent;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.attribute.AttributeSet;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Color;
import java.awt.Font;

public class SessionSettingView extends JFrame implements View{

	private JPanel contentPane;
	private JTextField hourField;
	private JTextField minuteField;
	private JButton cancelButton;
	private JButton startButton;
	private JLabel errorLabel;

	/**
	 * Create the frame.
	 */
	public SessionSettingView() {
		setFont(new Font("Arial Nova Light", Font.PLAIN, 40));
		setResizable(false);
		setExtendedState(JFrame.MAXIMIZED_BOTH);;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel centerPane = new JPanel();
		contentPane.add(centerPane, BorderLayout.CENTER);
		centerPane.setLayout(new BoxLayout(centerPane, BoxLayout.X_AXIS));
		centerPane.add(Box.createHorizontalGlue());
		
		hourField = new JTextField("");
		hourField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		hourField.setHorizontalAlignment(SwingConstants.CENTER);
		hourField.setMaximumSize(new Dimension(150, 100));
		centerPane.add(hourField);
		hourField.setColumns(2);
		
		JLabel label1 = new JLabel(":");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setMaximumSize(new Dimension(150, 100));
		centerPane.add(label1);
		
		minuteField = new JTextField("");
		minuteField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		minuteField.setHorizontalAlignment(SwingConstants.CENTER);
		minuteField.setMaximumSize(new Dimension(150, 100));
		centerPane.add(minuteField);
		minuteField.setColumns(2);
		
		JPanel southPane = new JPanel();
		contentPane.add(southPane, BorderLayout.SOUTH);
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(new Color(169, 169, 169));
		southPane.add(cancelButton);
		cancelButton.setForeground(new Color(220, 20, 60));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		
		JLabel blankLabel = new JLabel("        ");
		blankLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		southPane.add(blankLabel);
		
		startButton = new JButton("START");
		startButton.setBackground(new Color(169, 169, 169));
		southPane.add(startButton);
		startButton.setForeground(new Color(0, 255, 0));
		startButton.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		
		centerPane.add(Box.createHorizontalGlue());
		
		JPanel northPane = new JPanel();
		contentPane.add(northPane, BorderLayout.NORTH);
		northPane.setLayout(new BorderLayout(0, 0));
		
		JLabel mainLabel = new JLabel("Session Settings");
		mainLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPane.add(mainLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		errorLabel.setForeground(Color.RED);
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		northPane.add(errorLabel, BorderLayout.SOUTH);
	
	}
	
	public JLabel getErrorLabel() {
		return errorLabel;
	}
	public void setErrorLabel(JLabel errorLabel) {
		this.errorLabel = errorLabel;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	public JButton getStartButton() {
		return startButton;
	}
	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}
	
	public JTextField getHourField() {
		return hourField;
	}
	public void setHourField(JTextField hourField) {
		this.hourField = hourField;
	}
	public JTextField getMinuteField() {
		return minuteField;
	}
	public void setMinuteField(JTextField minuteField) {
		this.minuteField = minuteField;
	}

}
