package database;

/**
 * 
 * @author Nicklas A class that sets and gets all the values for a character.
 */
public class AllValues {

	private String name, classname, race;
	private int id, strength, vitality, toughness, luck, dexterity;

	public AllValues(int id, String name, String race, String classname, int strength, int vitality, int toughness,
			int luck, int dexterity) {
		super();
		this.id = id;
		this.name = name;
		this.race = race;
		this.classname = classname;
		this.dexterity = dexterity;
		this.strength = strength;
		this.vitality = vitality;
		this.luck = luck;
		this.toughness = toughness;

	}

	/**
	 * gets the characters strength value
	 * 
	 * @return characters strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * sets the characters strength value
	 * 
	 * @param strength of the character
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * gets the characters vitality value
	 * 
	 * @return characters vitality
	 */
	public int getVitality() {
		return vitality;
	}

	/**
	 * sets the characters vitality value
	 * 
	 * @param vitality of the character
	 */
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	/**
	 * gets the characters toughness value
	 * 
	 * @return characters toughness
	 */
	public int getToughness() {
		return toughness;
	}

	/**
	 * sets the characters toughness value
	 * 
	 * @param toughness of the character
	 */
	public void setToughness(int toughness) {
		this.toughness = toughness;
	}

	/**
	 * gets the characters luck value
	 * 
	 * @return characters luck
	 */
	public int getLuck() {
		return luck;
	}

	/**
	 * sets the characters luck value
	 * 
	 * @param luck of the character
	 */
	public void setLuck(int luck) {
		this.luck = luck;
	}

	/**
	 * gets the characters dexterity value
	 * 
	 * @return characters dexterity
	 */
	public int getDexterity() {
		return dexterity;
	}

	/**
	 * sets the characters dexterity value
	 * 
	 * @param dexterity of the character
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	/**
	 * gets the characters id value
	 * 
	 * @return characters id
	 */
	public int getId() {
		return id;
	}

	/**
	 * sets the characters id
	 * 
	 * @param id of the character
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * gets the characters name
	 * 
	 * @return characters name
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the characters name
	 * 
	 * @param name of the character
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the characters race
	 * 
	 * @return characters race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * sets the character race
	 * 
	 * @param race of the character
	 */
	public void setRace(String race) {
		this.race = race;
	}

	/**
	 * gets the characters class
	 * 
	 * @return characters class
	 */
	public String getCharacterClass() {
		return classname;
	}

	/**
	 * sets the character Class
	 * 
	 * @param classname class of the character
	 */
	public void setCharacterClass(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return String.format(
				"Characters [id=%s, name=%s, race=%s, classname=%s, strength=%s, vitality=%s,toughness=%s, luck=%s, dexterity=%s]",
				id, name, race, classname, strength, vitality, toughness, luck, dexterity);
	}

}
