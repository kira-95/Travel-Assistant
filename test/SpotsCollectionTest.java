import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class SpotsCollectionTest {

    private SpotsCollection spots = new SpotsCollection();
    private List<Spot> spotList = spots.getSpots();;

    @Before
    public void setUp() throws Exception {
        spots.setNumSpots(5);
        spots.addSpot("Columbia University");
        spots.addSpot("MOMA");
        spots.addSpot("Central Park");
        spots.addSpot("Empire State Building");
        spots.addSpot("SOHO");
    }

    /**
     * Test if the spots can be added correctly
     */
    @Test
    public void testSpotAdd() {

        assertTrue(spotList.get(0).getName().equals("Columbia University"));
        assertTrue(spotList.get(1).getName().equals("MOMA"));
        assertTrue(spotList.get(2).getName().equals("Central Park"));
        assertTrue(spotList.get(3).getName().equals("Empire State Building"));
        assertTrue(spotList.get(4).getName().equals("SOHO"));
        assertEquals(spotList.size(), 5);
    }

    /**
     * Test if the spots can be deleted correctly
     */
    public void testSpotDelete() {
        spots.deleteSpot();
        assertTrue(spotList.get(spotList.size()-1).getName().equals("Empire State Building"));
        assertEquals(spotList.size(), 4);
    }

}
