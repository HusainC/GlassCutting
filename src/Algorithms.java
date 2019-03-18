
/**
 * @Purpose: The Algorithms class contains the two algorithms you have to implement  
 * Do NOT modify the names and signatures of the two algorithm methods
 * 
 * @author  RYK
 * @since   30/10/2018
 * extended by @author 
 *
 *extended @author Husain Chopdawala
 **/

import java.util.ArrayList;

import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 * 
	 * @param shapes:a
	 *            list of shapes representing customer requests(shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used.
	 **/

	public List<Sheet> nextFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */
		if ((shapes == null)) {// Checks if List of Shapes passed is not NULL
			throw new IllegalArgumentException("No shapes");
		} else {
			
			int sheetCounter = -1; // A sheet Counter to keep a count on shapes
			List<Sheet> usedSheets = new ArrayList<Sheet>();// A list of sheets used during the runtime
			usedSheets.add(new Sheet());// Adds a new Sheet to add the first element
			sheetCounter++;// Sheet counter increased by 1
			int newWidth = usedSheets.get(sheetCounter).getWidth();//Setting width for later checks
			int newHeight = usedSheets.get(sheetCounter).getHeight();//Setting height for later checks
			int shelfCount = 0;//Setting a shelf counter to count the number of shelves
			usedSheets.get(sheetCounter).addShelf(new Shelf());//Adds a new Shelf too the first sheet
			usedSheets.get(sheetCounter).getShelf(shelfCount).place((shapes.get(0)));//Adds a shape to the first shelf of the first sheet
			newWidth -=shapes.get(0).getWidth();//modifying width of the sheet with respect to the shape added
			newHeight -= shapes.get(0).getHeight();//modifying width of the sheet with respect to the shape added
			for (int i = 1; i < shapes.size(); i++) {//Loop to go through the list of shapes
				/**
				 * This if statement checks if the shelf height is less, if the width is 
				 * less than the newWidth and if the number of shapes is less than 20 in the 
				 * sheet.Adds the shape to the shelf if conditions are met.
				 */
				if ((shapes.get(i).getHeight() <= usedSheets.get(sheetCounter).getShelf(shelfCount).getHeight())
						&& (shapes.get(i).getWidth() <= newWidth)&&(usedSheets.get(sheetCounter).allShapes()) ) {
					newWidth -= shapes.get(i).getWidth();
					usedSheets.get(sheetCounter).getShelf(shelfCount).place((shapes.get(i)));
					usedSheets.get(sheetCounter).getShelf(shelfCount).getHeight();
				} 
				/**
				 * This if Statement checks if there is enough space in the sheet to create a
				 * new shelf by checking the height and width of the new shape.
				 */
				else if ((shapes.get(i).getHeight() > usedSheets.get(sheetCounter).getShelf(shelfCount).getHeight()
						|| shapes.get(i).getWidth() > newWidth) && (shapes.get(i).getHeight() <= newHeight)&&(usedSheets.get(sheetCounter).allShapes())) {
					newHeight -= shapes.get(i).getHeight();
					newWidth = usedSheets.get(sheetCounter).getWidth();
					usedSheets.get(sheetCounter).addShelf(new Shelf());
					shelfCount++;
					usedSheets.get(sheetCounter).getShelf(shelfCount).place((shapes.get(i)));
					usedSheets.get(sheetCounter).getShelf(shelfCount).getHeight();
				}
				/**
				 * If none of the above conditions are met the algorithm creates a new sheet
				 * to accommodate a new shape. This part resets all values to use the new shape.
				 */
				else {
					usedSheets.add(new Sheet());
					sheetCounter++;
					newWidth = usedSheets.get(sheetCounter).getWidth();//reset width
					newHeight = usedSheets.get(sheetCounter).getHeight();//reset height 
					shelfCount = 0;
					usedSheets.get(sheetCounter).addShelf(new Shelf());//new shelf
					usedSheets.get(sheetCounter).getShelf(shelfCount).place((shapes.get(i)));
					usedSheets.get(sheetCounter).getShelf(shelfCount).getHeight();
					newWidth -= shapes.get(i).getWidth();
					newHeight -= shapes.get(i).getHeight();
				}
			}
			/*
			 * Add in your own code so that the method will place all the shapes
			 * according to FirstFit under the assumptions mentioned in the spec
			 */

			return usedSheets;

		}

		/*
		 * Add in your own code so that the method will place all the shapes
		 * according to NextFit under ALL the assumptions mentioned in the
		 * specification
		 */

	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a
	 *            list of shapes representing customer requests (shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {

		/*
		 * Start with an empty list of sheets (remember each sheet has a width
		 * of 300 and a height of 250 as specified in the Sheet class)
		 */

		int sheetCounter = 0;
		List<Sheet> usedSheets = new ArrayList<Sheet>();
		usedSheets.add(new Sheet());//Creates a new Sheet and adds it to the list of new Sheets
		usedSheets.get(sheetCounter).addShelf(new Shelf());//new Shelf added in the new sheet
		int shelfCounter = 0;
		usedSheets.get(sheetCounter).getShelf(shelfCounter).place((shapes.get(0)));//places first shape in the sheet
		int k;//loop initialization to keep it in scope 
		boolean flag = false;// A flag to check if shape has been placed
		boolean flag1 = false;// A flag to check if the shape has been placed

		for (int i = 1; i < shapes.size(); i++) {//loop to go over all the shapes

			for (int j = 0; j < usedSheets.size(); j++) {//loop to go over all the sheets 

				for (k = 0; k < usedSheets.get(j).getShelves().size(); k++) {//loop to go over all the shelves in the sheet
					/**
					 * the if statement checks if the height is correct to place the shelf in the sheet
					 * and set the flag to shape placed 
					 */
					if ((shapes.get(i).getHeight() <= usedSheets.get(j).getShelf(k).getHeight())&&(usedSheets.get(j).allShapes()) && (shapes.get(i)
							.getWidth() <= (usedSheets.get(0).getWidth() - usedSheets.get(j).getShelf(k).getWidth()))) {
						usedSheets.get(j).getShelf(k).place(shapes.get(i));
						flag = true;
						break;//loop breaks to move on to the next shape
					}
				}
				/**
				 * checks if shape has already been placed if not then it checks the height and width of the shape
				 * to add a new shelf if possible
				 */
				if ((usedSheets.get(j).allShapes()) &&(flag == false) && (shapes.get(i)
						.getHeight() <= (usedSheets.get(j).getHeight() - usedSheets.get(j).allShelvesHeight()))) {
					usedSheets.get(j).addShelf(new Shelf());
					shelfCounter++;
					usedSheets.get(j).getShelf(k).place(shapes.get(i));
					usedSheets.get(j).getShelf(k).getHeight();					
					flag1 = true;
					break;
				}
				if (flag == true || flag1 == true) {//checks if shape has been placed if yes then loop is broken else it moves onto the next sheet
					break;
				}
			}

			if ((flag1 == false) && (flag == false)) {// checks if the shape has been placed else adds a new sheet and places the shape
				usedSheets.add(new Sheet());
				sheetCounter++;
				shelfCounter = 0;
				usedSheets.get(sheetCounter).addShelf(new Shelf());
				usedSheets.get(sheetCounter).getShelf(shelfCounter).place(shapes.get(i));
				usedSheets.get(sheetCounter).getShelf(shelfCounter).getHeight();
			}
			flag = false;//sets flag back to shape not placed 
			flag1 = false;//sets the flag back to shapes not placed

		}
		/*
		 * Add in your own code so that the method will place all the shapes
		 * according to FirstFit under the assumptions mentioned in the spec
		 */

		return usedSheets;

	}

}
