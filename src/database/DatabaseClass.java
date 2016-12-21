package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import guiPackage.GUIClass;

/**
 * @author Nicklas Connecting to the database and search,save,load,update,delete
 *         in database;
 */
public class DatabaseClass {
	private Connection myConn;
	private final String user = "root", password = "root";
	private final String dbName = "characterbuilder";

	/**
	 * Connects to the database
	 */
	public DatabaseClass() {

		try {

			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", user,
					password);
			JOptionPane.showMessageDialog(null, "You are connected to the database named " + dbName);

		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Somthing went wrong withe the connectetion to the database named "
					+ dbName + " " + exc.getMessage());

		}

	}

	/**
	 * Search all the characters
	 * @return all the characters
	 * @throws Exception
	 */
	public List<AllValues> searchAllCharacters() throws Exception {
		List<AllValues> list = new ArrayList<>();

		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(
					"select c.*,cc.classname,s.Toughness,s.Vitality,s.Luck,s.Strenght,s.Dexterity from characters c "
							+ "join characterClass cc on c.id = cc.id " + "join stats s on c.id = s.id");

			while (myRs.next()) {

				AllValues tempCharacters = convertRowToCharacters(myRs);
				list.add(tempCharacters);

			}
			return list;
		}

		finally {
			close(myStmt, myRs);
		}
	}

	/**
	 * Search for a character by name
	 * @param name of the character 
	 * @return a list of all the characters by the name
	 * @throws Exception
	 */
	public List<AllValues> searchCharacters(String name) throws Exception {

		List<AllValues> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			name = "%"+name+"%";

			myStmt = myConn.prepareStatement(
					"select c.*,cc.classname,s.Toughness,s.Vitality,s.Luck,s.Strenght,s.Dexterity from characters c "
							+ "join characterClass cc on c.id = cc.id "
							+ "join stats s on c.id = s.id where name like ? group by c.id");
			myStmt.setString(1, name);

			myRs = myStmt.executeQuery();

			while (myRs.next()) {
				AllValues tempCharacters = convertRowToCharacters(myRs);
				list.add(tempCharacters);
			}

			return list;

		} finally {
			close(myStmt, myRs);
		}

	}

	/**
	 * This method saves or update a character
	 * 
	 * @param all
	 *            id,name,race values from Character
	 * @param updateMode
	 *            true = Update character, false save character
	 */

	public void saveAndEditCharacter(AllValues all, boolean updateMode) throws Exception {
		String mode = null;
		try {
			if (updateMode) {

				mode = "Update";
				PreparedStatement myStmt = myConn
						.prepareStatement("update characters set name = ? ,race= ? where id = ?");

				myStmt.setInt(1, all.getId());
				myStmt.setString(2, all.getName());
				myStmt.setString(3, all.getRace());

				myStmt.executeUpdate();

				PreparedStatement myStmt1 = myConn
						.prepareStatement("update characterClass set Classname = ? where id = ?");

				myStmt1.setString(1, all.getCharacterClass());
				myStmt1.setInt(2, all.getId());
				myStmt1.executeUpdate();

				PreparedStatement myStmt2 = myConn.prepareStatement(
						"Update stats set toughness = ?,vitality = ?,strenght = ?, luck = ?, dexterity = ? where id = ?");

				myStmt2.setInt(1, all.getToughness());
				myStmt2.setInt(2, all.getVitality());
				myStmt2.setInt(3, all.getStrength());
				myStmt2.setInt(4, all.getLuck());
				myStmt2.setInt(5, all.getDexterity());
				myStmt2.setInt(6, all.getId());

				myStmt2.executeUpdate();
			} else {

				PreparedStatement myStmt = myConn
						.prepareStatement("insert into characters(id,name,race) values (?,?,?)");
				mode = "Saved";

				myStmt.setInt(1, all.getId());
				myStmt.setString(2, all.getName());
				myStmt.setString(3, all.getRace());

				myStmt.executeUpdate();

				PreparedStatement myStmt1 = myConn
						.prepareStatement("insert into characterClass(Classname,id) values (?,?)");

				myStmt1.setString(1, all.getCharacterClass());
				myStmt1.setInt(2, all.getId());
				myStmt1.executeUpdate();

				PreparedStatement myStmt2 = myConn.prepareStatement(
						"insert into stats(toughness,vitality,strenght, luck, dexterity,id) values (?,?,?,?,?,?)");

				myStmt2.setInt(1, all.getToughness());
				myStmt2.setInt(2, all.getVitality());
				myStmt2.setInt(3, all.getStrength());
				myStmt2.setInt(4, all.getLuck());
				myStmt2.setInt(5, all.getDexterity());
				myStmt2.setInt(6, all.getId());

				myStmt2.executeUpdate();

			}

			JOptionPane.showMessageDialog(null, mode + " complete");
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage());
		}

	}

	/**
	 *  Loading a character by the id
	 * @param id of the character that will be loaded
	 */
	public void loadCharacter(int id) throws Exception {

		String name = "", classname = "", race = "";
		int strength = 0, vitality = 0, toughness = 0, luck = 0, dexterity = 0;

		try {

			Statement myStmt = myConn.createStatement();
			ResultSet myRs = myStmt.executeQuery("select * from characters where id=" + id);

			while (myRs.next()) {

				id = myRs.getInt("id");
				name = myRs.getString("Name");
				race = myRs.getString("Race");

			}

			Statement myStmt1 = myConn.createStatement();
			ResultSet myRs1 = myStmt1.executeQuery("select classname from characterClass where id=" + id);

			while (myRs1.next()) {

				classname = myRs1.getString("classname");

			}
			Statement myStmt2 = myConn.createStatement();
			ResultSet myRs2 = myStmt1
					.executeQuery("select strenght, vitality, toughness, luck, dexterity from stats where id=" + id);

			while (myRs2.next()) {
				strength = myRs2.getInt("strenght");
				vitality = myRs2.getInt("vitality");
				toughness = myRs2.getInt("toughness");
				luck = myRs2.getInt("luck");
				dexterity = myRs2.getInt("dexterity");

			}
			GUIClass.setTheValue(id, name, race, classname, strength, vitality, toughness, luck, dexterity);

			JOptionPane.showMessageDialog(null, "Loading complete");
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage());
		}
		// } finally {
		// close(myStmt, myRs);
		// }

	}

	/**
	 * Delete a character by the id
	 * @param id of the character that will be deleted
	 */
	public void deleteCharacter(int id) throws Exception {

		try {

			PreparedStatement myStmt1 = myConn.prepareStatement("Delete from characterClass where id = ?");

			myStmt1.setInt(1, id);
			myStmt1.executeUpdate();

			PreparedStatement myStmt2 = myConn.prepareStatement("Delete from stats where id = ?");

			myStmt2.setInt(1, id);

			myStmt2.executeUpdate();

			PreparedStatement myStmt = myConn.prepareStatement("Delete from characters where id = ?");

			myStmt.setInt(1, id);

			myStmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Delete complete");
		} catch (SQLException exc) {
			JOptionPane.showMessageDialog(null, exc.getMessage());

		}

	}

	private AllValues convertRowToCharacters(ResultSet myRs) throws SQLException {

		int id = myRs.getInt("Id");
		String name = myRs.getString("Name");
		String race = myRs.getString("Race");
		String classname = myRs.getString("ClassName");
		int strength = myRs.getInt("Strenght");
		int vitality = myRs.getInt("Vitality");
		int toughness = myRs.getInt("Toughness");
		int luck = myRs.getInt("Luck");
		int dexterity = myRs.getInt("Dexterity");

		AllValues tempCharacters = new AllValues(id, name, race, classname, strength, vitality, toughness, luck,
				dexterity);

		return tempCharacters;
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs, PreparedStatement myPreStmt)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {

		}

		if (myConn != null) {
			myConn.close();
		}
		if (myPreStmt != null) {

		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs, null);
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null, null);
	}

	private void close(PreparedStatement myPreStmt) throws SQLException {
		close(null, null, null, myPreStmt);
	}

}
