import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Junit test for back-end
 * @Author: Xijie Guo
 */
public class ShortestRouteTest {

    private SpotsCollection spots = new SpotsCollection();
    private List<String> spotNameList = spots.getNames();

    @Before
    public void setUp() throws Exception {
        spots.setSize(5);
        spots.addSpot("Columbia University");
        spots.addSpot("MOMA");
        spots.addSpot("Central Park");
        spots.addSpot("Empire State Building");
        spots.addSpot("Metropolian Museum");
        int[][] distanceMatrix = {
                {0,10,8,7,2},
                {10,0,9,11,19},
                {8,9,0,4,18},
                {7,11,4,0,27},
                {2,19,18,27,0}
        };

        spots.setDistances();
        
    
    }

    /**
     * Test if the spots can be added correctly
     */
    @Test
    public void testSpotAdd() {
        assertTrue(spotNameList.get(0).equals("Columbia University"));
        assertTrue(spotNameList.get(1).equals("MOMA"));
        assertTrue(spotNameList.get(2).equals("Central Park"));
        assertTrue(spotNameList.get(3).equals("Empire State Building"));
        assertTrue(spotNameList.get(4).equals("SOHO"));
    }

    /**
     * Test if the algorithm can find the shortest path
     */
    @Test
    public void testShortestRoute() {
        List<String> res = ShortestRout.findShortest(spots);
        assertEquals(res.get(0), "Columbia University");
        assertEquals(res.get(1), "SOHO");
        assertEquals(res.get(2), "Central Park");
        assertEquals(res.get(3), "Empire State Building");
        assertEquals(res.get(4), "MOMA");
    }
}
