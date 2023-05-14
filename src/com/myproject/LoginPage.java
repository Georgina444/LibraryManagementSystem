package com.myproject;

import java.awt.CardLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

	JFrame frame;
	JPanel loginPanel, guiPanel;
	JLabel userLabel, passLabel;
	JTextField textUserField;
	JPasswordField textPassField;
	JPasswordField password;
	JButton loginButton;
	CardLayout cardLayout;

	// constructor method(initializes an object of the class when it is created)
	// an object of this class represent an instance of a this GUI
	public LoginPage() {

		frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 150),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 100), 300, 200);

		// frame.pack();

		// login panel
		loginPanel = new JPanel(); // 1. Initialize
		loginPanel.setLayout(null); // 1.1 no layout manager will be used, components manually positioned and frame is centered.
		frame.add(loginPanel); // 2. Add

		userLabel = new JLabel("Username");
		userLabel.setBounds(25, 20, 80, 25);
		loginPanel.add(userLabel);

		textUserField = new JTextField(20);
		textUserField.setBounds(100, 20, 165, 25);
		loginPanel.add(textUserField);

		passLabel = new JLabel("Password");
		passLabel.setBounds(25, 50, 80, 25);
		loginPanel.add(passLabel);

		textPassField = new JPasswordField(20);
		textPassField.setBounds(100, 50, 165, 25);
		loginPanel.add(textPassField);

		loginButton = new JButton("Login");
		loginButton.setBounds(100, 90, 100, 30);
		loginButton.addActionListener(this);
		loginPanel.add(loginButton);

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (textUserField.getText().equals("user") && textPassField.getText().equals("pass")) {
			// Create a new instance of the GUI class
			GUI gui = new GUI();

			// change frame size, and content pane
			// gui.frame.setTitle("GUI");
			gui.frame.setSize(900, 600);
			gui.frame.setContentPane(gui.panel); // the primary(base) container for other components that will be added
													// to the frame

			// position the new frame at the center of the screen
			gui.frame.setLocationRelativeTo(null);

			// Show the GUI frame
			gui.frame.setVisible(true);

			// Dispose the login frame
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(frame, "Invalid login");
		}
	}

}
