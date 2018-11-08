import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GoogleMapsHandlerTest {

	
	@SuppressWarnings("deprecation")
	@Test
	public void testfunction() throws IOException {
		double test1 = GoogleMapsHandler.Distance("Metropolian Museum","Time Squre");
		double test2 = GoogleMapsHandler.Distance("MOMA","Columbia University");
		assertEquals(test1,3.6,3.6);
		assertEquals(test2,6.9,6.9);
		
	}

}
