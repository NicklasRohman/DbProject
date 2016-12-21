package guiPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import database.AllValues;
import database.DatabaseClass;

/**
 * 
 * @author Nicklas
 * The class thats making all the GUI components
 */
public class GUIClass extends JFrame {

	DatabaseClass dbc = new DatabaseClass();

	private JPanel panel;
//	private JComboBox searchBox;
	
	private JButton buttonSaveCharacter, buttonLoadCharacter, buttonSearch;
	private JButton buttonDeleteCharacter, buttonEditCharacter;

	private JLabel nameLabel, classLabel, searchLabel, idLabel;
	private JLabel raceLabel, strengthLabel, vitalityLabel;
	private JLabel toughnessLabel, dexterityLabel, luckLabel;
	private JLabel item1Label, item2Label, item3Label, item4Label;

	private JLabel nameColumLabel, classColumLabel, idColumLabel;
	private JLabel raceColumLabel, strengthColumLabel, vitalityColumLabel;
	private JLabel toughnessColumLabel, dexterityColumLabel, luckColumLabel;

	private static JTextField nameText, classText, idText, searchText;
	private static JTextField raceText, strengthText, vitalityText;
	private static JTextField toughnessText, dexterityText, luckText;
	private static JTextField item1Text, item2Text, item3Text, item4Text;

	private JTable searchTable;

	private String name, classname, race;

	private int id, strength, vitality, toughness, luck, dexterity;

	private static final long serialVersionUID = 1L;

	
	/**
	 * The method that makes the GUI
	 */
	public void makeGUI() {
		this.setTitle("Cheracter Builder");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1350, 720);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		createPanel();
		this.add(panel);

		createButtons();
		panel.add(buttonSaveCharacter);
		panel.add(buttonLoadCharacter);
		panel.add(buttonDeleteCharacter);
		panel.add(buttonEditCharacter);
		panel.add(buttonSearch);

		createLabels();
		panel.add(nameLabel);
		panel.add(raceLabel);
		panel.add(strengthLabel);
		panel.add(vitalityLabel);
		panel.add(toughnessLabel);
		panel.add(dexterityLabel);
		panel.add(luckLabel);
		panel.add(classLabel);
		panel.add(searchLabel);
		panel.add(idLabel);

		//later project
//		panel.add(item1Label);
//		panel.add(item2Label);
//		panel.add(item3Label);
//		panel.add(item4Label);

		panel.add(nameColumLabel);
		panel.add(raceColumLabel);
		panel.add(strengthColumLabel);
		panel.add(vitalityColumLabel);
		panel.add(toughnessColumLabel);
		panel.add(dexterityColumLabel);
		panel.add(luckColumLabel);
		panel.add(classColumLabel);
		panel.add(idColumLabel);

		createTextFields();
		panel.add(nameText);
		panel.add(raceText);
		panel.add(strengthText);
		panel.add(vitalityText);
		panel.add(toughnessText);
		panel.add(dexterityText);
		panel.add(luckText);
		panel.add(classText);
		panel.add(idText);
		panel.add(searchText);
		
//		later Project
//		panel.add(item1Text);
//		panel.add(item2Text);
//		panel.add(item3Text);
//		panel.add(item4Text);

		createTable();
		panel.add(searchTable);

//		createCombox();
//		panel.add(searchBox);
//		
		this.setVisible(true);

	}

	private void createTable() {

		searchTable = new JTable();
		searchTable.setBounds(50, 270, 600, 300);
		updateTable(name);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(null);
	}
	
	//This method is made for later functions, so you can search on different things then just name of character. 
//	private void createCombox(){
//		
//		String[] searchValues = {"id", "name", "race", "classname", "strength", "vitality", "toughness", "luck",
//				"dexterity"};
//		searchBox = new JComboBox(searchValues);
//		searchBox.setBounds(100, 100, 100, 30);
//		
//		searchBox.addActionListener(new ActionListener() {
//			 
//		    @Override
//		    public void actionPerformed(ActionEvent event) {
//		        JComboBox<String> combo = (JComboBox<String>) event.getSource();
//		        String selectedBook = (String) combo.getSelectedItem();
//		 
//		        if (selectedBook.equals("Effective Java")) {
//		            System.out.println("Good choice!");
//		        } else if (selectedBook.equals("Head First Java")) {
//		            System.out.println("Nice pick, too!");
//		        }
//		        combo.setBounds(100, 200, 100, 100);
//		        panel.add(combo);
//		    }
//		});
//	}

	private void createLabels() {
		int labelWidth = 70;
		int labelHeight = 30;
		int labelX = 1050;
		int labelY = 25;
		int extraX = 80;
		int extraY = 80;

		nameLabel = new JLabel("Name");
		raceLabel = new JLabel("Race");
		strengthLabel = new JLabel("Strength");
		vitalityLabel = new JLabel("Vitality");
		toughnessLabel = new JLabel("Toughness");
		dexterityLabel = new JLabel("Dexterity");
		luckLabel = new JLabel("Luck");
		classLabel = new JLabel("Class");
		searchLabel = new JLabel("Search character name");
		idLabel = new JLabel("Id");

		nameColumLabel = new JLabel("Name");
		classColumLabel = new JLabel("Class");
		idColumLabel = new JLabel("Id");
		raceColumLabel = new JLabel("Race");
		strengthColumLabel = new JLabel("Str");
		vitalityColumLabel = new JLabel("Vit");
		toughnessColumLabel = new JLabel("Tou");
		luckColumLabel = new JLabel("Luc");
		dexterityColumLabel = new JLabel("Dex");

		item1Label = new JLabel("Item 1");
		item2Label = new JLabel("Item 2");
		item3Label = new JLabel("Item 3");
		item4Label = new JLabel("Item 4");

		nameLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
		idLabel.setBounds(labelX - extraX, labelY, labelWidth, labelHeight);

		raceLabel.setBounds(labelX - extraX, labelY + extraY, labelWidth, labelHeight);
		luckLabel.setBounds(labelX + extraX, labelY + extraY, labelWidth, labelHeight);

		strengthLabel.setBounds(labelX - extraX, labelY + extraY * 2, labelWidth, labelHeight);
		vitalityLabel.setBounds(labelX + extraX, labelY + extraY * 2, labelWidth, labelHeight);

		dexterityLabel.setBounds(labelX + extraX, labelY + extraY * 3, labelWidth, labelHeight);
		toughnessLabel.setBounds(labelX - extraX, labelY + extraY * 3, labelWidth, labelHeight);

		classLabel.setBounds(labelX - 300, labelY, labelWidth, labelHeight);

		searchLabel.setBounds(labelX - 1000, labelY + 550, labelWidth + 100, labelHeight);

		idColumLabel.setBounds(labelX - 990, labelY + 220, labelWidth, labelHeight);
		nameColumLabel.setBounds(labelX - 930, labelY + 220, labelWidth, labelHeight);
		raceColumLabel.setBounds(labelX - 860, labelY + 220, labelWidth, labelHeight);
		classColumLabel.setBounds(labelX - 790, labelY + 220, labelWidth, labelHeight);
		strengthColumLabel.setBounds(labelX - 730, labelY + 220, labelWidth, labelHeight);
		vitalityColumLabel.setBounds(labelX - 660, labelY + 220, labelWidth, labelHeight);
		toughnessColumLabel.setBounds(labelX - 600, labelY + 220, labelWidth, labelHeight);
		luckColumLabel.setBounds(labelX - 530, labelY + 220, labelWidth, labelHeight);
		dexterityColumLabel.setBounds(labelX - 450, labelY + 220, labelWidth, labelHeight);

		item1Label.setBounds(labelX - extraX, labelY + extraY * 4, labelWidth, labelHeight);
		item2Label.setBounds(labelX + extraX, labelY + extraY * 4, labelWidth, labelHeight);
		item3Label.setBounds(labelX - extraX, labelY + extraY * 5, labelWidth, labelHeight);
		item4Label.setBounds(labelX + extraX, labelY + extraY * 5, labelWidth, labelHeight);

	}

	private void createTextFields() {
		int textWidth = 40;
		int textHeight = 30;
		int textX = 1050;
		int textY = 50;
		int extraX = 80;
		int extraY = 80;

		nameText = new JTextField("Name");
		raceText = new JTextField("Humen");
		strengthText = new JTextField("0");
		vitalityText = new JTextField("0");
		toughnessText = new JTextField("0");
		dexterityText = new JTextField("0");
		luckText = new JTextField("0");
		classText = new JTextField("Junior Programmer");
		idText = new JTextField("");
		searchText = new JTextField();

		item1Text = new JTextField();
		item2Text = new JTextField();
		item3Text = new JTextField();
		item4Text = new JTextField();

		nameText.setBounds(textX, textY, textWidth + 100, textHeight);
		idText.setBounds(textX - extraX, textY, textWidth, textHeight);

		raceText.setBounds(textX - extraX, textY + extraY, textWidth + 50, textHeight);
		luckText.setBounds(textX + extraX, textY + extraY, textWidth, textHeight);

		strengthText.setBounds(textX - extraX, textY + extraY * 2, textWidth, textHeight);
		vitalityText.setBounds(textX + extraX, textY + extraY * 2, textWidth, textHeight);

		toughnessText.setBounds(textX - extraX, textY + extraY * 3, textWidth, textHeight);
		dexterityText.setBounds(textX + extraX, textY + extraY * 3, textWidth, textHeight);

		classText.setBounds(textX - 340, textY, textWidth + 100, textHeight);

		searchText.setBounds(textX - 850, textY + 530, textWidth + 70, textHeight);

		item1Text.setBounds(textX - extraX, textY + extraY * 4, textWidth + 100, textHeight);
		item2Text.setBounds(textX + extraX, textY + extraY * 4, textWidth + 100, textHeight);
		item3Text.setBounds(textX - extraX, textY + extraY * 5, textWidth + 100, textHeight);
		item4Text.setBounds(textX + extraX, textY + extraY * 5, textWidth + 100, textHeight);

	}

	private void createButtons() {
		int buttonWidth = 130;
		int buttonHeight = 50;
		int buttonX = 900;
		int buttonY = 580;

		buttonSaveCharacter = new JButton("Save Character");
		buttonLoadCharacter = new JButton("Load Character");
		buttonDeleteCharacter = new JButton("Delete Character");
		buttonEditCharacter = new JButton("Edit Character");
		buttonSearch = new JButton("Search");

		LisenForButton lForSaveButton = new LisenForButton();
		buttonSaveCharacter.addActionListener(lForSaveButton);
		buttonLoadCharacter.addActionListener(lForSaveButton);
		buttonEditCharacter.addActionListener(lForSaveButton);
		buttonDeleteCharacter.addActionListener(lForSaveButton);
		buttonSearch.addActionListener(lForSaveButton);

		buttonSaveCharacter.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
		buttonLoadCharacter.setBounds(buttonX + 130, buttonY, buttonWidth, buttonHeight);
		buttonDeleteCharacter.setBounds(buttonX + 260, buttonY, buttonWidth, buttonHeight);
		buttonEditCharacter.setBounds(buttonX - 170, buttonY, buttonWidth, buttonHeight);
		buttonSearch.setBounds(buttonX - 550, buttonY, buttonWidth, buttonHeight - 20);

		buttonEditCharacter.setEnabled(false);
	
	}

	private void updateTable(String aName) {
		try {

			List<AllValues> character = null;

			if (aName != null && aName.trim().length() > 0) {
				character = dbc.searchCharacters(aName);
			} else {
				character = dbc.searchAllCharacters();
			}

			TableModel cModel = new TableModel(character);

			searchTable.setModel(cModel);

		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private class LisenForButton implements ActionListener {
		String searchName = null;

		public void actionPerformed(ActionEvent e) {

			// Saving Button
			if (e.getSource() == buttonSaveCharacter) {

				try {
					dbc.saveAndEditCharacter(allValues(), false);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				updateTable(searchName);

			}

			// Loading button
			else if (e.getSource() == buttonLoadCharacter) {

				try {
					id = Integer.parseInt(idText.getText());
				} catch (Exception exc) {
					idExceptionPrinter(exc);
				}

				try {
					dbc.loadCharacter(id);

				} catch (Exception e1) {
					e1.printStackTrace();
				}

				updateTable(searchName);
				buttonEditCharacter.setEnabled(true);
				buttonSaveCharacter.setEnabled(false);
				
				
			}
			// Delete Button
			else if (e.getSource() == buttonDeleteCharacter) {

				try {
					id = Integer.parseInt(idText.getText());
				} catch (Exception exc) {
					idExceptionPrinter(exc);
				}

				try {
					dbc.deleteCharacter(id);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				updateTable(searchName);

			}
			// Edit Button
			else if (e.getSource() == buttonEditCharacter) {

				try {
					dbc.saveAndEditCharacter(allValues(), true);
				} catch (Exception e1) {

					e1.printStackTrace();
				}

				updateTable(searchName);
				buttonEditCharacter.setEnabled(false);
				buttonSaveCharacter.setEnabled(true);
			}
			// Search Button
			else if (e.getSource() == buttonSearch) {

				String name = searchText.getText();
				updateTable(name);

			}
		}

		private void idExceptionPrinter(Exception exc) {
			JOptionPane.showMessageDialog(null, "Id not correct " + exc.getMessage());
		}

		private AllValues allValues() {
			classname = classText.getText();
			name = nameText.getText();
			race = raceText.getText();

			try {
				id = Integer.parseInt(idText.getText());
				strength = Integer.parseInt(strengthText.getText());
				vitality = Integer.parseInt(vitalityText.getText());
				toughness = Integer.parseInt(toughnessText.getText());
				luck = Integer.parseInt(luckText.getText());
				dexterity = Integer.parseInt(dexterityText.getText());

			} catch (Exception exc) {
				JOptionPane.showMessageDialog(null, exc.getMessage());
			}

			AllValues tempCharacterClass = new AllValues(id, name, race, classname, strength, vitality, toughness, luck,
					dexterity);

			return tempCharacterClass;
		}
	}
/**
 * Sets all the values in the represented text field when user push loading button 
 * @param id characters id
 * @param name characters name
 * @param race characters race
 * @param classname characters class
 * @param strength stats of characters strength 
 * @param vitality stats of characters vitality
 * @param toughness stats of characters toughness
 * @param luck stats of characters luck
 * @param dexterity stats of characters dexterity 
 */
	public static void setTheValue(int id, String name, String race, String classname, int strength, int vitality,
			int toughness, int luck, int dexterity) {

		idText.setText(id + "");
		nameText.setText(name);
		raceText.setText(race);
		classText.setText(classname);
		strengthText.setText(strength + "");
		vitalityText.setText(vitality + "");
		;
		toughnessText.setText(toughness + "");
		dexterityText.setText(dexterity + "");
		luckText.setText(luck + "");
		// item1Text.setText(id1+"");
		// item2Text.setText(id1+"");
		// item3Text.setText(id1+"");
		// item4Text.setText(id1+"");

	}

}
