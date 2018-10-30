/**
 * @author Haoran Geng, Xijie Guo
 */

import java.util.*;


class ShortestRoutTest {

	public void test() {
		SpotsCollection spots = new SpotsCollection();
		spots.setSize(5);
		spots.addSpots("Columbia University");
		spots.addSpots("MOMA");
		spots.addSpots("Centrual Park");
		spots.addSpots("Empire State Building");
		spots.addSpots("SOHO");
		System.out.println(spots.getNames());
		int[][] distances = {
			{0,10,8,7,2},
			{10,0,9,11,19},
			{8,9,0,4,18},
			{7,11,4,0,27},
			{2,19,18,27,0}
		};

		spots.setDistances(distances);
		List<String> test = ShortestRout.findShortest(spots);
		System.out.println(test);
	}

}
