/**
 *  @Purpose: The Generator class generates a list of shapes of random width and height.
 * Do NOT modify the names and signatures of the generator method
 * 
 * @author  RYK
 * @since   30/10/2018
 * extended by @author 
 * extended @author Husain Chopdawala
 */
import java.util.ArrayList;
import java.util.List;

public class Generator {

	public static final int MAX_SIZE_HEIGHT = 250;
	public static final int MAX_SIZE_WIDTH = 300;

	/**
	 * This method will generate a list of shapes of random width and height
	 * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive.
	 * The random height is between 1 and MAX_SIZE_HEIGHT inclusive.
	 * 
	 * @param numberOfShapes: the number of shapes to generate
	 * @return a list of shapes of random sizes
	 */

	public List<Shape> generateShapeList(int numberOfShapes) {

		List<Shape> shapes = new ArrayList<Shape>();
		/**
		 *  While loop that generates the number of shapes passed as a parameter
		 */
		
		while(numberOfShapes!=0)
		{
			int width=(int )(Math.random() * MAX_SIZE_WIDTH + 1);//generates a random width within the boundaries
			int height=(int )(Math.random() *MAX_SIZE_HEIGHT + 1);//generates a random height within the boundaries
			shapes.add(new Shape(width,height));//creates a new shape using the random values and adds to the returning list
			numberOfShapes--;
		}
		/*
		 * THIS METHOD CURRENTLY RETURNS AN EMPTY LIST SO YOU WILL NEED TO ADD
		 * IN YOUR OWN CODE TO GENERATE A LIST OF SHAPES randomly
		 */
		return shapes;
	}

}