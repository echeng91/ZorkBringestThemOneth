import org.junit.* ;
import static org.junit.Assert.* ;

public class PlayerTest {

	@Test
	public void testPlayerVisitRoom()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1);
		System.out.println("Test room visited flag.");
		assertTrue(r1.getVisited());
	}
	
	@Test
	public void testPlayerVisitRoom2()
	{
		HouseRoom r1 = new HouseRoom("room");
		HouseRoom r2 = new HouseRoom("room2");
		Player p1 = new Player("p1", r1);
		r1.addConnection(r2);
		p1.moveTo(r2);
		System.out.println("Test move to room visited flag.");
		assertTrue(r2.getVisited());
	}
	
	@Test
	public void testRoomsVisitedCount()
	{
		Player p1 = new Player("p1");
		System.out.println("Test rooms visited counter.");
		assertTrue(p1.getRoomsVisited() == 0);
	}
	
	@Test
	public void testRoomsVisitedCount1()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1);
		System.out.println("Test rooms visited counter 1.");
		assertTrue(p1.getRoomsVisited() == 1);
	}
	
	@Test
	public void testRoomsVisitedCount2()
	{
		HouseRoom r1 = new HouseRoom("room");
		HouseRoom r2 = new HouseRoom("room2");
		Player p1 = new Player("p1", r1);
		r1.addConnection(r2);
		p1.moveTo(r2);
		System.out.println("Test rooms visited counter 2.");
		assertTrue(p1.getRoomsVisited() == 2);
	}
	
	@Test
	public void testMoveToNotConnected()
	{
		HouseRoom r1 = new HouseRoom("r1");
		HouseRoom r2 = new HouseRoom("r2");
		Player p1 = new Player("p1", r1);
		System.out.println("Test cannot move to room.");
		assertEquals(p1.moveTo(r2), "Cannot go there. Remain in r1");
	}
	
	@Test
	public void testMoveToConnected()
	{
		HouseRoom r1 = new HouseRoom("r1");
		HouseRoom r2 = new HouseRoom("r2");
		r1.addConnection(r2);
		Player p1 = new Player("p1", r1);
		System.out.println("Test move to room.");
		assertEquals(p1.moveTo(r2), "Moved to r2");
	}
	
	@Test
	public void testTakeMoney()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1);
		r1.addMoney(5.55);
		System.out.println("Test looting message.");
		assertEquals(p1.takeMoney(), "Looted:\n\t$5.55");
	}
	
	@Test
	public void testTakeMoney1()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1);
		r1.addMoney(5.55);
		p1.takeMoney();
		System.out.println("Test money added to player money.");
		assertTrue(p1.getInventory().getMoney() == 5.55);
	}
	
	@Test
	public void testTakeMoney2()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1);
		r1.addMoney(5.55);
		p1.takeMoney();
		System.out.println("Test money taken from room.");
		assertTrue(r1.getThings().getMoney() == 0);
	}
	
	@Test
	public void testTakeDamage()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1, 10, 5, 5);
		p1.takeDamage(5);
		System.out.println("Test take damage.");
		assertTrue(p1.getCurrentHP() == 5);
	}
	
	@Test
	public void testTakeDamage2()
	{
		HouseRoom r1 = new HouseRoom("room");
		Player p1 = new Player("p1", r1, 10, 5, 5);
		System.out.println("Test take damage message.");
		assertEquals(p1.takeDamage(5), "p1 takes 5 damage! ");
	}
}
