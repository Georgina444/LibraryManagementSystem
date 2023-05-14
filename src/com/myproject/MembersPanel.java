package com.myproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MembersPanel extends JPanel {
	private JPanel membersPanel;
	private JPanel topPanel;
	private JPanel searchPanel;
	private JPanel middlePanel;
	private JPanel downPanel;

	public MembersPanel() {
		membersPanel = new JPanel(new GridLayout(4, 1));

		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(200, 50)); // set a smaller width for
		// the top panel
		topPanel.setBackground(Color.red);

		JLabel titleLabel = new JLabel("MEMBERS");
		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		Font font = new Font("Arial", Font.BOLD, 28);
		titleLabel.setFont(font);
		topPanel.add(titleLabel, c);

		searchPanel = new JPanel();
		// searchPanel.setPreferredSize(new Dimension(200, 100));
		searchPanel.setBackground(Color.gray);
		JLabel searchLabel = new JLabel("Search by Name: ");
		searchPanel.add(searchLabel);

		middlePanel = new JPanel();
		// middlePanel.setPreferredSize(new Dimension(200, 100));
		middlePanel.setBackground(Color.yellow);

		downPanel = new JPanel();
		downPanel.setPreferredSize(new Dimension(200, 100));
		downPanel.setBackground(Color.PINK);

		// Add the panels to the membersPanel in the desired order
		membersPanel.add(topPanel);
		membersPanel.add(searchPanel);
		membersPanel.add(middlePanel);
		membersPanel.add(downPanel);

		add(membersPanel);
	}

	public JPanel getMemberPanel() {
		return membersPanel;
	}
}
