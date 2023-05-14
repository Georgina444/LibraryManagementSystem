package com.myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

	public JFrame frame;
	public JButton booksButton, membersButton, loansButton;
	public JPanel panel, buttonPanel;

	// constructor(basically a method, and we'll set up a frame, layout..)
	public GUI() {

		frame = new JFrame("Library Management System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);

		// main panel
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		frame.getContentPane().add(panel); // set the panel as the content pane

		// button panel
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(150, 0, 0, 0));
		panel.add(buttonPanel, BorderLayout.CENTER);

		// add buttons to the panel
		booksButton = new JButton("Books");
		booksButton.setPreferredSize(new Dimension(200, 100));
		booksButton.setFont(new Font("Arial", Font.PLAIN, 24));
		booksButton.setBackground(Color.WHITE);
		booksButton.addActionListener(this);
		buttonPanel.add(booksButton);

		membersButton = new JButton("Members");
		membersButton.setPreferredSize(new Dimension(200, 100));
		membersButton.setFont(new Font("Arial", Font.PLAIN, 24));
		membersButton.setBackground(Color.BLUE);
		membersButton.setForeground(Color.BLACK);
		membersButton.addActionListener(this);
		buttonPanel.add(membersButton);

		loansButton = new JButton("Loans");
		loansButton.setPreferredSize(new Dimension(200, 100));
		loansButton.setFont(new Font("Arial", Font.PLAIN, 24));
		loansButton.setBackground(Color.WHITE);
		loansButton.addActionListener(this);
		buttonPanel.add(loansButton);

		// add a title label
		JLabel titleLabel = new JLabel("Library Management System");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setVerticalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 48));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
		panel.add(titleLabel, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == booksButton) {
			openBooksFrame();
		} else if (e.getSource() == membersButton) {
			openMembersFrame();
		} else if (e.getSource() == loansButton) {
			openLoansFrame();
		}
	}

	private void openBooksFrame() {
		// create the new BooksPanel
		BooksPanel booksPanel = new BooksPanel();

		// get the current content pane
		Container contentPane = frame.getContentPane();

		// remove the current panel
		contentPane.removeAll();

		// add the new BooksPanel to the content pane
		contentPane.add(booksPanel.getBookPanel(), BorderLayout.CENTER);

		// Revalidates the content pane to update the GUI
		contentPane.revalidate(); // notifies the container that its layout manager needs to be updated based on
									// any changes made to its components
		contentPane.repaint(); // Ensures that changes are immediately visible to the user
	}

	private void openMembersFrame() {
		MembersPanel membersPanel = new MembersPanel();

		// get the current content pane
		Container contentPane = frame.getContentPane();

		// remove current panel
		contentPane.removeAll();

		// add membersPanel
		contentPane.add(membersPanel.getMemberPanel());

		// revalidate the content pane to update the GUI
		contentPane.revalidate();
		contentPane.repaint();

	}

	private void openLoansFrame() {
		LoansPanel loansPanel = new LoansPanel();

		Container contentPane = frame.getContentPane();

		contentPane.removeAll();

		contentPane.add(loansPanel.getLoanPanel(), BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}
}
