import org.junit.* ;
import static org.junit.Assert.* ;

public class HouseRoomTest {

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
	public void testGetEnemyByName()
	{
		HouseRoom r1 = new HouseRoom("room");
		Enemy en = new Enemy("enemy", r1);
		Enemy found = r1.getEnemyByName("enemy");
		System.out.println("Test find enemy by name.");
		assertEquals(en, found);
	}
	
	@Test
	public void testIsConnected()
	{
		HouseRoom r1 = new HouseRoom("r1");
		HouseRoom r2 = new HouseRoom("r2");
		System.out.println("Test disconnected rooms");
		assertFalse(r1.isConnected(r2));
	}
	
	@Test
	public void testAddConnection()
	{
		HouseRoom r1 = new HouseRoom("r1");
		HouseRoom r2 = new HouseRoom("r2");
		r1.addConnection(r2);
		System.out.println("Test connecting rooms.");
		assertTrue(r1.isConnected(r2));
	}
	
	@Test
	public void testAddMoney()
	{
		HouseRoom r1 = new HouseRoom("room");
		r1.addMoney(5.55);
		System.out.println("Test add money.");
		assertTrue(r1.getThings().getMoney() == 5.55);
	}
	
	@Test
	public void testAddMoney2()
	{
		HouseRoom r1 = new HouseRoom("room");
		r1.addMoney(5.55);
		r1.addMoney(4.44);
		System.out.println("Test add money twice.");
		assertTrue(r1.getThings().getMoney() == 9.99);
	}
	
	@Test
	public void testHasEnemy()
	{
		HouseRoom r1 = new HouseRoom("room");
		Enemy en = new Enemy("enemy", r1);
		System.out.println("Test has enemy.");
		assertTrue(r1.hasEnemy("enemy"));
	}
	
	@Test
	public void testHasEnemy2()
	{
		HouseRoom r1 = new HouseRoom("room");
		Enemy en = new Enemy("enemy");
		r1.addEnemy(en);
		System.out.println("Test has add enemy.");
		assertTrue(r1.hasEnemy("enemy"));
	}
	
	@Test
	public void testNotHasEnemy()
	{
		HouseRoom r1 = new HouseRoom("room");
		System.out.println("Test not has enemy.");
		assertFalse(r1.hasEnemy("enemy"));
	}
}
