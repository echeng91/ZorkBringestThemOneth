import org.junit.* ;
import static org.junit.Assert.* ;

public class ZorkUnitTest {

	@Test
	public void testRoomEqual()
	{
		HouseRoom r1 = new HouseRoom("room");
		HouseRoom r2 = r1;
		System.out.println("Test make two equal rooms.");
		assertEquals(r1, r2);
	}
	
	@Test
	public void testRoomSame()
	{
		HouseRoom r1 = new HouseRoom("room");
		HouseRoom r2 = r1;
		System.out.println("Test make two same rooms.");
		assertSame(r1, r2);
	}
	
	@Test
	public void testRoomNotNull()
	{
		HouseRoom r1 = new HouseRoom("room");
		System.out.println("Test room not null.");
		assertNotNull(r1);
	}
	
	@Test
	public void testVisitedFlag()
	{
		HouseRoom r1 = new HouseRoom("room");
		System.out.println("Test room visited flag.");
		assertFalse(r1.getVisited());
	}
	
	@Test
	public void testPlayerVisitRoom()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1);
		System.out.println("Test room visited flag.");
		assertTrue(r1.getVisited());
	}
	
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
	
	@Test
	public void testRoomsVisitedCount()
	{
		Player p1 = new Player("p1");
		System.out.println("Test rooms visited counter.");
		assertTrue(p1.getRoomsVisited() == 0);
	}
	
	@Test
	public void testMoveToNotConnected()
	{
		HouseRoom r1 = new HouseRoom("r1");
		HouseRoom r2 = new HouseRoom("r2");
		Player p1 = new Player("p1", r1);
		assertEquals(p1.moveTo(r2), "Cannot go there. Remain in r1");
	}
	
	@Test
	public void testMoveToConnected()
	{
		HouseRoom r1 = new HouseRoom("r1");
		HouseRoom r2 = new HouseRoom("r2");
		r1.addConnection(r2);
		Player p1 = new Player("p1", r1);
		assertEquals(p1.moveTo(r2), "Moved to r2");
	}
}
