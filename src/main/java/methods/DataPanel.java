package methods;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

@SuppressWarnings("serial")
public class DataPanel extends JPanel{
	
	JPanel headPanel, dataPanel, midPanel, namePanel, surnamePanel, sexPanel, datePanel, townPanel, resultPanel, buttonPanel;
	JTextField nameField, surnameField, yearField, townField, resultField;
	JRadioButton f, m;
	JComboBox<String> dayMenu, monthMenu;
	JLabel head, sub, nameLabel, surnameLabel, sexLabel, dayLabel, monthLabel, yearLabel, townLabel, spec, resultLabel;
	JButton calc;
	
	public DataPanel() {
		
		dataPanel = new JPanel();
		dataPanel.setPreferredSize(new Dimension(450,600));
		
		headPanel = new JPanel();
		headPanel.setPreferredSize(new Dimension(450, 90));
		headPanel.setBackground(Color.WHITE);
		head = new JLabel("Italian Fiscal Code Calculator");
		head.setFont(new Font("Arial", 32, 32));
		sub = new JLabel("Insert your data:");
		sub.setFont(new Font("Arial", 20, 20));
		headPanel.add(head);
		headPanel.add(sub);
		
		midPanel = new JPanel();
		midPanel.setPreferredSize(new Dimension (400,330));
		midPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4));
		
		namePanel = new JPanel();
		namePanel.setPreferredSize(new Dimension(380, 30));
		nameLabel = new JLabel("Name: ");
		nameField = new JTextField(10);		
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		surnamePanel = new JPanel();
		surnamePanel.setPreferredSize(new Dimension(380, 40));
		surnameLabel = new JLabel("Surname: ");
		surnameField = new JTextField(10);
		surnamePanel.add(surnameLabel);
		surnamePanel.add(surnameField);
		
		sexPanel = new JPanel();
		sexPanel.setPreferredSize(new Dimension(380, 40));
		sexLabel = new JLabel("Sex: ");
		f = new JRadioButton("Female");
		m = new JRadioButton("Male");
		ButtonGroup bg = new ButtonGroup();
		bg.add(f);
		bg.add(m);
		sexPanel.add(sexLabel);
		sexPanel.add(f);
		sexPanel.add(m);
		
		datePanel = new JPanel();
		datePanel.setPreferredSize(new Dimension(180,110));
		dayLabel = new JLabel ("Birthday:");
		String[] days = new String[31];
		for (int i = 0; i<31; i++)
			days[i] = (i+1) + "";
		dayMenu = new JComboBox<String>(days);
		monthLabel = new JLabel ("Month");
		String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		monthMenu = new JComboBox<String>(months);
		yearLabel = new JLabel("Year: ");
		yearField = new JTextField(3);
		datePanel.add(dayLabel);
		datePanel.add(dayMenu);
		datePanel.add(monthLabel);
		datePanel.add(monthMenu);
		datePanel.add(yearLabel);
		datePanel.add(yearField);
		
		townPanel = new JPanel();
		townPanel.setPreferredSize(new Dimension (380,70));
		townLabel = new JLabel("Place of birth*: ");
		townField = new JTextField(10);
		spec = new JLabel("*Italian town, or foreign country");
		spec.setFont(new Font("Arial", 12,12));
		townPanel.add(townLabel);
		townPanel.add(townField);
		townPanel.add(spec);
		
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(380, 80));
		calc = new JButton ("Calculate");
		calc.setFont(new Font("Arial", 18,18));
		calc.setPreferredSize(new Dimension(150,50));
		calc.addActionListener(new calcListener());
		buttonPanel.add(calc);
		
		resultPanel = new JPanel();
		resultPanel.setPreferredSize(new Dimension(400,50));
		resultLabel = new JLabel("Your fiscal code is: ");
		resultLabel.setFont(new Font("Arial", 18,18));
		resultPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		resultField = new JTextField(15);
		resultField.setEditable(false);
		resultField.setFont(new Font("Arial", 16,16));
		resultPanel.add(resultLabel);
		resultPanel.add (resultField);
		
		dataPanel.add(headPanel);
		midPanel.add(namePanel);
		midPanel.add(surnamePanel);
		midPanel.add(sexPanel);
		midPanel.add(datePanel);
		midPanel.add(townPanel);
		dataPanel.add(midPanel);
		dataPanel.add(buttonPanel);
		dataPanel.add(resultPanel);
		
		add (dataPanel);		
	}
	
	public class calcListener implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			
			resultField.setText("");
			String name = nameField.getText();
			String surname = surnameField.getText();
			String fm = "0";
			if (f.isSelected()) fm = "f";
				else if (m.isSelected()) fm = "m";
					 else JOptionPane.showMessageDialog(null, "Please select a value \"Sex\" Field", "Error", JOptionPane.WARNING_MESSAGE);
			String birthday = (dayMenu.getSelectedIndex() + 1) + "";
			String month = (monthMenu.getSelectedIndex() + 1) + "";
			String year = yearField.getText();
			String town = townField.getText();	
			
			String fiscalCode = FCCalculations.surnameCalc(surname);
			fiscalCode += FCCalculations.nameCalc(name);
			fiscalCode += FCCalculations.dateCalc(birthday, month, year, fm);
			try {
				fiscalCode += FCCalculations.townCalc(town);
			} catch (IOException e) {
				System.out.println("Town codes file not found");
			}
			
			try {
				fiscalCode += FCCalculations.controlCalc(fiscalCode);
			} catch (InterruptedException e) {System.out.println("Error in calcListener");}
			if (fiscalCode.length() == 16)
				resultField.setText("  " + fiscalCode);
		}
	}
}
