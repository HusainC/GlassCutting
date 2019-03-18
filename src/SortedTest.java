import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Purpose: The SortedTest class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of
 *           shapes is SORTED
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2018
 * extended by @author
 * 
 * extended @author Husain Chopdawala
 */

public class SortedTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("**************** Sorted Test ****************");
		System.out.println("*********************************************");
		System.out.println();
		
		
		
		
		Generator make=new Generator();
		Algorithms o = new Algorithms();
		int noOfShapes=10000;
		int sheets1 = 0,sheets2=0,sheets3=0,sheets4=0,sheets5=0,sheets6=0;
		int noOfTests=5;
		int i=1;
		System.out.format("|%5s|%14s|%26s|%26s|%26s|%26s|%26s|%26s|", "TESTS", "NO OF SHAPES", "UNSORTED SHEETS NEXT FIT", "UNSORTED SHEETS FIRST FIT", "ASCENDING SHEETS NEXT FIT", "ASCENDING SHEETS FIRST FIT","DESCENDING SHEETS NEXT FIT","DESCENDING SHEETS FIRST FIT");
		System.out.println();
		while (i != noOfTests+1) {
			List<Shape> shapes=new ArrayList<Shape>();
			List<Shape> ascending=new ArrayList<Shape>();
			List<Shape> descending=new ArrayList<Shape>();
			shapes.addAll(make.generateShapeList(noOfShapes));
			ascending.addAll(shapes);
			descending.addAll(shapes);
			Collections.sort(ascending);
			Collections.sort(descending, Collections.reverseOrder());
			o.nextFit(shapes);
			sheets1=o.nextFit(shapes).size();
			o.firstFit(shapes);
			sheets2=o.firstFit(shapes).size();
			o.nextFit(ascending);
			sheets3=o.nextFit(ascending).size();
			o.firstFit(ascending);
			sheets4=o.firstFit(ascending).size();
			o.nextFit(descending);
			sheets5=o.nextFit(descending).size();
			o.firstFit(descending);
			sheets6=o.firstFit(descending).size();
				
			
			
			System.out.format("|%5d|%14d|%26d|%26d|%26d|%26d|%26d|%27d|", i, noOfShapes, sheets1,sheets2,sheets3,sheets4,sheets5,sheets6);
			System.out.println();
			noOfShapes += 10000;
			i++;
		}
	}
		
		/*
		 * Generate a random shape list and then check the number of sheets used
		 * when
		 ** this shape list is passed un-sorted
		 ** the list is sorted in ascending surface size
		 ** the list is sorted in descending surface size
		 * 
		 * run several tests for different sizes of the "list of shapes" 
		 */

		/*
		 * HINT: you might want to implements the comparTo method in the Shape
		 * class or implement the Comparator Interface to do the sorting
		 */

		/* An example output could be:
		 * System.out.println("NoOfShapes    NextFitSheets(unSorted)     NextFitSheets(AscOrder)  NextFitSheets(DesOrder)" 
		 * + "    FirstFitSheets(unSorted)     FirstFitSheets(AscOrder)  FirstFitSheets(DesOrder)");
		 */
						

	}
	
			
		
	
	
	


