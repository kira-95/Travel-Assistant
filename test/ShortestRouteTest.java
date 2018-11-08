import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Junit test for back end
 * @Author: Xijie Guo
 */
public class ShortestRouteTest {

    private SpotsCollection spots = new SpotsCollection();
    private List<Spot> spotList = spots.getSpots();

    @Before
    public void setUp() throws Exception {
        spots.setNumSpots(5);
        spots.addSpot("Columbia University");
        spots.addSpot("MOMA");
        spots.addSpot("Central Park");
        spots.addSpot("Empire State Building");
        spots.addSpot("SOHO");

        double[][] distanceMatrix = {
                {0.0, 10.0, 8.0, 7.0, 2.0},
                {10.0, 0.0, 9.0, 11.0, 19.0},
                {8.0, 9.0, 0.0, 4.0, 18.0},
                {7.0, 11.0, 4.0, 0.0, 27.0},
                {2.0, 19.0, 18.0, 27.0, 0.0}
        };

        spots.setDistanceMatrix(distanceMatrix);
    }


    /**
     * Test if the algorithm can find the shortest path
     */
    @Test
    public void testShortestRoute() {
        List<String> res = ShortestRoute.findNearestNeighbor(spots);
        assertEquals(res.get(0), "Columbia University");
        assertEquals(res.get(1), "SOHO");
        assertEquals(res.get(2), "Central Park");
        assertEquals(res.get(3), "Empire State Building");
        assertEquals(res.get(4), "MOMA");
    }
}
