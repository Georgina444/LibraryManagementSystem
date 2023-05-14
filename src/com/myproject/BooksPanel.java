package com.myproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BooksPanel extends JPanel {

	private JPanel booksPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;

	public BooksPanel() {
		booksPanel = new JPanel(new BorderLayout());

		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		panel5 = new JPanel();

		booksPanel.add(panel1, BorderLayout.NORTH);
		booksPanel.add(panel2, BorderLayout.WEST);
		booksPanel.add(panel3, BorderLayout.CENTER);
		booksPanel.add(panel4, BorderLayout.EAST);
		booksPanel.add(panel5, BorderLayout.SOUTH);

		panel1.setBackground(Color.red);
		panel1.setPreferredSize(new Dimension(0, 90));

		JLabel titleLabel = new JLabel("BOOKS");
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		Font font = new Font("Arial", Font.BOLD, 28); // create a new font with Arial, bold style, and size 24
		titleLabel.setFont(font);
		panel1.add(titleLabel, c);

		JButton goBackBtn = new JButton("<");
		goBackBtn.setPreferredSize(new Dimension(60, 60));
		panel1.add(goBackBtn);

		panel2.setBackground(Color.yellow);
		panel2.setPreferredSize(new Dimension(30, 20));

		// CENTRE - PANEL 3

		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS)); // set the layout to BoxLayout and stack components
																	// vertically
		JPanel searchPanel3 = new JPanel();
		searchPanel3.setBackground(Color.blue);
		searchPanel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // use FlowLayout with center alignment and
																			// 10
																			// pixels vertical and horizontal gap
		searchPanel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100)); // limit the maximum height of the search
																			// panel

		JLabel searchOption = new JLabel("Search by Title: ");
		searchOption.setFont(new Font("Arial", Font.PLAIN, 16));
		JTextField searchTextField = new JTextField(20); // set preferred width to 20 characters
		JButton searchButton = new JButton("Search");
		JComboBox comboBox1 = new JComboBox(new String[] { "Order By", "Category", "Author", "Publisher" });
		comboBox1.setPreferredSize(new Dimension(120, 50));

		searchPanel3.add(searchOption);
		searchPanel3.add(searchTextField);
		searchPanel3.add(searchButton);
		searchPanel3.add(Box.createHorizontalStrut(10)); // add some horizontal gap between the components
		searchPanel3.add(comboBox1);

		JPanel tablePanel3 = new JPanel();
		tablePanel3.setBackground(Color.gray);
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Title");
		model.addColumn("Author");
		model.addColumn("Publisher");
		model.addColumn("Category");

		table.setModel(model);
		tablePanel3.add(table);

		panel3.add(searchPanel3);
		panel3.add(tablePanel3);
		booksPanel.add(panel3);

//		// AddBooksPanel - when the add button is clicked, we will switch between these
//		// 2 panels
//
//		// initialize the addBookPanel with its components
//		JPanel addBookPanel = new JPanel();
//		addBookPanel.setLayout(new BoxLayout(addBookPanel, BoxLayout.Y_AXIS));
//		// ...
//		JButton testButton = new JButton("Test");
//		addBookPanel.add(testButton);
//		addBookPanel.setVisible(false); // hide the addBookPanel initially
//		panel3.setVisible(true);
//
//		// add the panel3 and the addBookPanel to this BooksPanel
//		add(panel3, BorderLayout.CENTER);
//		add(addBookPanel, BorderLayout.CENTER);

		panel4.setBackground(Color.yellow);
		panel4.setPreferredSize(new Dimension(150, 200));
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		Font buttonFont = new Font("Arial", Font.BOLD, 16);
		Dimension buttonSize = new Dimension(150, 60);
		JButton addButton = new JButton("Add");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.setPreferredSize(buttonSize);
		addButton.setFont(buttonFont);
		JButton editButton = new JButton("Edit");
		editButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		editButton.setPreferredSize(buttonSize);
		editButton.setFont(buttonFont);
		JButton deleteButton = new JButton("Delete");
		deleteButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteButton.setPreferredSize(buttonSize);
		deleteButton.setFont(buttonFont);

		panel4.add(Box.createVerticalGlue());
		panel4.add(addButton);
		panel4.add(Box.createVerticalStrut(10));
		panel4.add(editButton);
		panel4.add(Box.createVerticalStrut(10));
		panel4.add(deleteButton);
		panel4.add(Box.createVerticalGlue());

		panel5.setBackground(Color.red);
		panel5.setPreferredSize(new Dimension(0, 70));
		panel5.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setPreferredSize(new Dimension(80, 40));

		panel5.add(refreshButton);

		// add an ActionListener to the add button
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Add button clicked");
				openAddBookPanel();
			}
		});
	}

	private void openAddBookPanel() {
		// create the new BooksPanel for adding books
		BooksPanel addBookPanel = new BooksPanel();

		// set the bounds of the new panel
		addBookPanel.setBounds(0, 0, 600, 400); // adjust the size and location as needed

		// get the parent frame object
		JFrame parentFrame = (JFrame) this.getParent().getParent();

		// get the content pane of the parent frame
		Container contentPane = parentFrame.getContentPane();

		// remove the current BooksPanel object from the content pane
		contentPane.remove(this);

		// add the new BooksPanel object to the content pane
		contentPane.add(addBookPanel);

		// refresh the layout and update the UI
		contentPane.revalidate();
		contentPane.repaint();
	}

	private JPanel createLabelAndTextFieldPanel(JLabel label, JTextField textField) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.WEST);
		panel.add(textField, BorderLayout.CENTER);
		return panel;
	}

	public JPanel getBookPanel() {
		return booksPanel;
	}

}
