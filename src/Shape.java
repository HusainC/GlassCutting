/**
 * @Purpose: The shape class represents a single shape. DO NOT MODIFY THE
 *           SIGNITURE OF EXISTING METHODS, You may add additional methods if
 *           you wish
 * 
 * @author RYK
 * @since 30/10/2018 
 * extended by @author
 * 
 * extended @author Husain Chopdawala
 * 
 **/

public class Shape implements Comparable<Shape> {

	@Override
	public String toString() {
		return "Shape [sWidth=" + sWidth + ", sHeight=" + sHeight + "]";
	}

	private int sWidth;   // width of the shape
	private int sHeight;  // height of the shape
	private int surfaceArea = sWidth * sHeight;

	/**
	 * A Shape constructor to set the width and height of a shape. 
	 * @param width of a shape
	 * @param height of a shape
	 **/
	public Shape(int width, int height) {

		// Shape width and height should not be greater than the sheet width and height
		if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
			throw new IllegalArgumentException("Shape width or height is not valid");
		}

		this.sWidth = width;
		this.sHeight = height;
		this.surfaceArea = sWidth * sHeight;
	}

	/**
	 * @return height of a shape
	 **/
	public int getHeight() {
		return sHeight;
	}

	/**
	 * @return width of a shape
	 */
	public int getWidth() {
		return sWidth;
	}

	@Override
	public int compareTo(Shape o) {
		// You may want to implement this method
		if( (this.surfaceArea - o.surfaceArea)>0) 
		{
			return 1;
		}
		else if((this.surfaceArea - o.surfaceArea)==0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

//	public int getSurfaceArea() {
//		return sWidth*sHeight;
//	}

	
}
