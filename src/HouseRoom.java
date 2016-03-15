import java.util.ArrayList;

public class HouseRoom extends Room {

	private Inventory things;

	private ArrayList<HouseRoom> connectedRooms;
	private ArrayList<Enemy> enemies;

	// Constructors
	public HouseRoom() {

	}

	public HouseRoom(String name) {
		super(name);
		things = new Inventory();
		this.setVisited(false);
		connectedRooms = new ArrayList<HouseRoom>();
		enemies = new ArrayList<Enemy>();
	}

	public HouseRoom(String name, Inventory stuff, boolean seen) {
		super(name, seen);
		things = stuff;
		connectedRooms = new ArrayList<HouseRoom>();
		enemies = new ArrayList<Enemy>();
	}
	// end Constructors

	// Getters

	public Inventory getThings() {
		return things;
	}

	public ArrayList<HouseRoom> getConnectedRooms() {
		return connectedRooms;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public Enemy getEnemyByName(String enemyName)
	{
		Enemy namedEnemy = new Enemy(enemyName);
		for(Enemy enemy: enemies)
		{
			if(enemy.getID().equalsIgnoreCase(enemyName))
			{
				namedEnemy = enemy;
			}
		}
		return namedEnemy;
	}
	// end Getters

	// Setters

	public void setThings(Inventory stuff) {
		things = stuff;
	}
	// end Setters

	// Other methods
	public void addConnection(HouseRoom otherRoom) {
		boolean alreadyConnected = false;
		for (HouseRoom aRoom : connectedRooms) {
			if (aRoom.equals(otherRoom)) {
				alreadyConnected = true;
			}
		}
		if (!alreadyConnected) {
			connectedRooms.add(otherRoom);
			otherRoom.getConnectedRooms().add(this);
		}
	}

	public void addConnection(HouseRoom room1, HouseRoom room2) {
		addConnection(room1);
		addConnection(room2);
	}

	public void addConnection(HouseRoom room1, HouseRoom room2, HouseRoom room3) {
		addConnection(room1);
		addConnection(room2);
		addConnection(room3);
	}

	public boolean equals(HouseRoom otherRoom) {
		boolean same = false;
		if (this.getRoomName().equals(otherRoom.getRoomName())) {
			same = true;
		}
		return same;
	}

	public boolean isConnected(HouseRoom otherRoom) {
		boolean connected = false;
		for (HouseRoom aRoom : connectedRooms) {
			if (aRoom.equals(otherRoom)) {
				connected = true;
			}
		}
		return connected;
	}

	public void addItem(Item item) {
		things.addItem(item);
	}

	public void addMoney(double cash) {
		things.addMoney(cash);
	}
	
	public void addEnemy(Enemy enemy)
	{
		enemies.add(enemy);
	}
	
	public String displayEnemies()
	{
		String enemyString = "Enemies: ";
		for(Enemy enemy: enemies)
		{
			enemyString += "\n\t" + enemy.getID();
		}
		return enemyString;
	}
	
	public boolean hasEnemy(String enemyName)
	{
		boolean enemyExists = false;
		for(Enemy enemy: enemies)
		{
			if(enemy.getID().equalsIgnoreCase(enemyName))
			{
				enemyExists = true;
			}
		}
		return enemyExists;
	}

	@Override
	public String toString() {
		String returnString = "Room Name: " + this.getRoomName() + "\n";
		returnString += things.toString();
		if(!enemies.isEmpty())
		{
			returnString += "\n" + displayEnemies();
		}
		returnString += "\nConnected to: ";
		for (HouseRoom aRoom : connectedRooms) {
			returnString += "\n\t" + aRoom.getRoomName();
		}
		return returnString;
	}
}
