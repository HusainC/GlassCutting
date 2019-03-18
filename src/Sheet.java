
/**
 * @Purpose: The Sheet class represents a sheet with a list of shelves.
 * DO NOT MODIFY THE EXISTING METHODS SIGNITURE, You may add additional methods if you wish
 * 
 * @author  RYK 
 * @since   30/10/2018
 * extended by @author 
 * 
 * extended @author Husain Chopdawala
 */
import java.util.ArrayList;
import java.util.List;

public class Sheet {

	@Override
	public String toString() {
		return "Sheet [shelves=" + shelves + "]";
	}

	public static final int SHEET_HEIGHT = 250; // sheet height

	public static final int SHEET_WIDTH = 300; // sheet width

	public static final int SHAPE_LIMIT = 20; // maximum number of shapes that
												// can be placed in each sheet

	private List<Shelf> shelves = new ArrayList<Shelf>(); // list of shelves

	/**
	 * empty constructor
	 */
	public Sheet() {
	}

	/**
	 * This method is used to add a shelf to a sheet
	 * 
	 * @param a
	 *            shelf
	 */
	public void addShelf(Shelf shelf) {
		shelves.add(shelf);
	}

	public boolean allShapes() {
		int shapes = 0;
		for (int j = 0; j < shelves.size(); j++) {
			shapes += shelves.get(j).shapes.size();
		}
		if (shapes < 20)
			
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	/**
	 * @return height of all shelves in a sheet
	 */
	public int allShelvesHeight() {

		int total = 0;

		for (Shelf shelf : this.shelves) {

			// has a shelf with at least 1 shape
			if (!shelf.getShapes().isEmpty()) {

				// add all shelf height to total
				total += shelf.getHeight();
			}
		}
		return total;
	}

	public Shelf getShelf(int i) {
		return this.shelves.get(i);
	}

	/**
	 * @return list of all shelves in a sheet
	 */
	public List<Shelf> getShelves() {
		return this.shelves;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return SHEET_HEIGHT;
	}

	/**
	 * @return width
	 */
	public int getWidth() {
		return SHEET_WIDTH;
	}

}
