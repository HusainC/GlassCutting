import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @Purpose: The CorrectnessTest class is used to validate the correctness of
 *           the implemented algorithms You can add additional methods if you
 *           need
 * 
 * @author RYK
 * @since 30/10/2018 extended by @author
 * 
 * extended by @author husain chopdawala
 */

public class CorrectnessTest {
	
/**
 * next fit Test
 * Checks if a new Shelf is placed in a sheet
 */
	@Test
	public  void newShelfCheck()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		shapes.add(new Shape(120,50));
		shapes.add(new Shape(120,150));
		assertEquals(2,s.nextFit(shapes).get(0).getShelves().size());
	}
	
/**
 * next fit Test
 * Tests if a new sheet is added 
 */
	@Test
	public  void newSheetCheck()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		shapes.add(new Shape(120,200));
		shapes.add(new Shape(120,220));
		assertEquals(2,s.nextFit(shapes).size());
	}
	/**
	 * next fit Test
	 * Adds a new shelf if the width of the shelf is full
	 */
	@Test
	public  void firstShelfFull()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		shapes.add(new Shape(120,200));
		shapes.add(new Shape(120,100));
		shapes.add(new Shape(30,80));
		shapes.add(new Shape(30,80));
		shapes.add(new Shape(30,20));
		assertEquals(2,s.nextFit(shapes).get(0).getShelves().size());
	}
	/**
	 * next fit Test
	 * Adds a new shelf if the sheet has more than 20 shapes
	 * 
	 */
	@Test
	public  void shapeLimitTest()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		for(int i=0;i<=21;i++) {
			shapes.add(new Shape(1,1));
		}
		assertEquals(20,s.nextFit(shapes).get(0).getShelf(0).shapes.size());
	}
	/**
	 * First fit test
	 * Tests if the algorithm checks first sheet to add shelf
	 */
	@Test
	public void firstFitNewShelfTest()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		shapes.add(new Shape(100,220));
		shapes.add(new Shape(290,150));
		shapes.add(new Shape(190,22));
		shapes.add(new Shape(100,30));
		assertEquals(30,s.firstFit(shapes).get(0).getShelf(1).getHeight());
	}
	/**
	 * first fit test
	 * checks if the algorithm makes a new sheet
	 */
	@Test
	public void firstFitNewSheetTest()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		shapes.add(new Shape(100,220));
		shapes.add(new Shape(290,150));
		shapes.add(new Shape(190,22));
		shapes.add(new Shape(100,30));
		assertEquals(150,s.firstFit(shapes).get(1).getShelf(0).getHeight());
	}
	/**
	 * first fit Test
	 * Adds a new shelf if the sheet has more than 20 shapes
	 * 
	 */
	@Test
	public  void shapeLimitTest2()
	{
		List<Shape> shapes = new ArrayList<Shape>();
		Algorithms s=new Algorithms();
		for(int i=0;i<=21;i++) {
			shapes.add(new Shape(1,1));
		}
		assertEquals(20,s.firstFit(shapes).get(0).getShelf(0).shapes.size());
	}
}
