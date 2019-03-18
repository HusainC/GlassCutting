import java.util.ArrayList;
import java.util.List;

/**
 * @Purpose: The PerformanceTest class is used to compare the implemented
 *           algorithms in term of time and the number of sheets used
 *
 *           You can add additional methods if you need to in this class
 * 
 * @author RYK
 * @since 30/10/2018 extended by @author
 * extended @author Husain Chopdawala
 */

public class PerformanceTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*********** Performance analysis **************");
		System.out.println("**********************************************");

		System.out.println();
		/*
		 * You must complete the Generator class in order to generate a random
		 * test values. You must complete the Algorithms class in order to call
		 * the two algorithms.
		 * 
		 * You can use any additional method you created in this class
		 */

		/*
		 * 
		 * NOTE: you are using an unsorted list of shapes
		 */

		/**
		 * Remember: You need to calculate the time and number of sheets used
		 * for each run of each algorithm.
		 * 
		 * You are expected to run several tests (e.g. noOfTests=5) of your
		 * programs for, 10000, 20000, 30000, 40000, 50000 shapes
		 * (noOfShapes=10000, increment=10000) so that one can see how the
		 * algorithms perform for large datasets.
		 * 
		 * You are expected to run the same test a number of times to ensure
		 * accurate result (noOfRep=4). In this case, you need to calculate the
		 * average time and sheets needed for each run
		 **/
		// total number of tests - you need to CHANGE this value
		int noOfTests = 5;

		// number of repetitions for each test - you need to CHANGE this value
		int noOfRep = 4;

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 10000;
		// the increment in the number of shapes - you need to CHANGE this value
		int increment=10000;
		Generator r = new Generator();
		Algorithms o = new Algorithms();
		double avg = 0;
		double avg1 = 0;
		int i = 1;
		int sheets1=0;
		int sheets2=0;
		System.out.format("|%5s|%14s|%12s|%13s|%15s|%16s|", "TESTS", "NO OF SHAPES", "AVG NEXT FIT", "AVG FIRST FIT","SHEETS NEXT FIT","SHEETS FIRST FIT");
		System.out.println();
		while (i != noOfTests) {// while loop to run different number of shapes
			List<Shape> similarShapes = new ArrayList<Shape>();//creating a duplicate list to run the two algorithms
			similarShapes.addAll(r.generateShapeList(noOfShapes));
			while (noOfRep != 0) {//loop that reps the number of Reps to calculate average 
				long start = System.currentTimeMillis();//to calculate time taken to run the algorithm
				o.nextFit(similarShapes);
				long end = System.currentTimeMillis();//stop time to calculate the time taken
				long elapsed = end - start;//total time taken to run the algorithm
				avg = avg + elapsed;//a counter to calculate avg
				sheets1+=o.nextFit(similarShapes).size();//counter to calculate number of sheets required
				start = System.currentTimeMillis();
				o.firstFit(similarShapes);
				end = System.currentTimeMillis();
				elapsed = end - start;
				avg1 = avg1 + elapsed;
				sheets2+=o.firstFit(similarShapes).size();
				noOfRep--;
			}
			noOfRep = 4;
			System.out.format("|%5d|%14s|%12.3f|%13.3f|%15d|%16d|", i, noOfShapes, avg / 4, avg1 / 4,sheets1/4,sheets2/4);//prints data in tabular form
			System.out.println();
			noOfShapes += increment;
			i++;
		}
	}
}
