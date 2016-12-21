package guiPackage;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import database.AllValues;
/**
 * 
 * @author Nicklas
 * Building a model on how the seachTable will look 
 */
class TableModel extends AbstractTableModel {

	private static final long serialVersionUID = 2782113533426985490L;
	private static final int ID_COL = 0;
	private static final int NAME_COL = 1;
	private static final int RACE_COL = 2;
	private static final int CLASS_COL = 3;
	private static final int STRENGHT_COL = 4;
	private static final int VITALITY_COL = 5;
	private static final int TOUGHNESS_COL = 6;
	private static final int LUCK_COL = 7;
	private static final int DEXTERITY_COL = 8;
	
	private String[] columnNames = { "Id", "Name", "Race", "Class" , "Toughness", "Vitality", "Strenght","Luck", "Dexterity" };
	private List<AllValues> values;

	
	/**
	 * 
	 * @param theList a list of all the values
	 */
	public TableModel(List<AllValues> theList) {
		values = theList;

	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return values.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		AllValues tempValues = values.get(row);

		switch (col) {
		case ID_COL:
			return tempValues.getId();
		case NAME_COL:
			return tempValues.getName();
		case RACE_COL:
			return tempValues.getRace();
		case CLASS_COL:
			return tempValues.getCharacterClass();
		case STRENGHT_COL:
			return tempValues.getStrength();
		case VITALITY_COL:
			return tempValues.getVitality();
		case TOUGHNESS_COL:
			return tempValues.getToughness();
		case LUCK_COL:
			return tempValues.getLuck();
		case DEXTERITY_COL:
			return tempValues.getDexterity();
		default:
			return tempValues.getName();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
