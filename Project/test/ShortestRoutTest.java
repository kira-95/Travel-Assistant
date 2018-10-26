import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ShortestRoutTest extends ShortestRout{

	@Test
	void test() {
		SpotsCollection spots = new SpotsCollection();
		spots.size = 5;
		spots.names.add("Columbia University");
		spots.names.add("MOMA");
		spots.names.add("Centrual Park");
		spots.names.add("Empire State Building");
		spots.names.add("SOHO");
		System.out.println(spots.names);
		spots.distances = new int[][] {
			{0,10,8,7,2},
			{10,0,9,11,19},
			{8,9,0,4,18},
			{7,11,4,0,27},
			{2,19,18,27,0}
		};
		ArrayList<String> test = new ArrayList<String>();
		test = FindShortest(spots);
		System.out.println(test);
		
		
	}

}
