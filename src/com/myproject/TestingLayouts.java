package com.myproject;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestingLayouts {

	JFrame frame;
	JPanel panel;

	public TestingLayouts() {

		frame = new JFrame("Testing");
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null); // center the JFrame on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// create a panel to hold the button
		panel = new JPanel();
		panel.setBackground(Color.WHITE);

		// add the panel to the content pane

		// specify the row and column of the component
		gbc.gridx = 0;
		gbc.gridy = 0;

		// the number of columns and rows the component should span
		gbc.gridwidth = 2;
		gbc.gridheight = 2;

		// specify how to distribute extra space among the columns and rows of the grid
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(10, 20, 10, 20);
		contentPane.add(panel, gbc);

		// add a button to the panel
		JButton button = new JButton("Button");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(button, gbc);
		gbc.insets = new Insets(50, 0, 0, 0);

		// set the size of the content pane to be the same as the frame size
		contentPane.setPreferredSize(frame.getSize());
		frame.pack();
		frame.setLocationRelativeTo(null); // center the JFrame on the screen
		frame.setVisible(true);

	}
}