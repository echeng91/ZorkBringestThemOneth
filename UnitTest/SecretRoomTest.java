import org.junit.* ;
import static org.junit.Assert.* ;

import org.junit.Test;

public class SecretRoomTest {

	@Test
	public void testDiscoveredFlag()
	{
		SecretRoom r1 = new SecretRoom("room");
		System.out.println("Test secret room discovered flag.");
		assertFalse(r1.getDiscovered());
	}
	
	@Test
	public void testDiscovery()
	{
		SecretRoom r1 = new SecretRoom("room");
		r1.discover();
		System.out.println("Test secret room discovery.");
		assertTrue(r1.getDiscovered());
	}
}
