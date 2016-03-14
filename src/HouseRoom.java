import java.util.ArrayList;

public class HouseRoom extends Room{

	
	private Inventory things;
	
	private ArrayList<HouseRoom> connectedRooms;
	private ArrayList<Character> nonPlayerCharacters;

	//Constructors
	public HouseRoom()
	{

	}
	public HouseRoom(String name)
	{
		super(name);
		things = new Inventory();
		this.setVisited(false);
		connectedRooms = new ArrayList<HouseRoom>();
		nonPlayerCharacters = new ArrayList<Character>();
	}
	public HouseRoom(String name, Inventory stuff, boolean seen)
	{
		super(name, seen);
		things = stuff;
		connectedRooms = new ArrayList<HouseRoom>();
		nonPlayerCharacters = new ArrayList<Character>();
	}
	//end Constructors

	//Getters
	
	public Inventory getThings()
	{
		return things;
	}
	public ArrayList<HouseRoom> getConnectedRooms()
	{
		return connectedRooms;
	}
	public ArrayList<Character> getNPCs()
	{
		return nonPlayerCharacters;
	}
	//end Getters

	//Setters
	
	public void setThings(Inventory stuff)
	{
		things = stuff;
	}
	//end Setters

	//Other methods
	public void addConnection(HouseRoom otherRoom)
	{
		boolean alreadyConnected = false;
		for(HouseRoom aRoom: connectedRooms)
		{
			if(aRoom.equals(otherRoom))
			{
				alreadyConnected = true;
			}
		}
		if(!alreadyConnected)
		{
			connectedRooms.add(otherRoom);
			otherRoom.getConnectedRooms().add(this);
		}
	}

	public void addConnection(HouseRoom room1, HouseRoom room2)
	{
		addConnection(room1);
		addConnection(room2);
	}

	public void addConnection(HouseRoom room1, HouseRoom room2, HouseRoom room3)
	{
		addConnection(room1);
		addConnection(room2);
		addConnection(room3);
	}

	public boolean equals(HouseRoom otherRoom)
	{
		boolean same = false;
		if(this.getRoomName().equals(otherRoom.getRoomName()))
		{
			same = true;
		}
		return same;
	}

	public boolean isConnected(HouseRoom otherRoom)
	{
		boolean connected = false;
		for(HouseRoom aRoom: connectedRooms)
		{
			if(aRoom.equals(otherRoom))
			{
				connected = true;
			}
		}
		return connected;
	}
	
	public void addItem(Item item)
	{
		things.addItem(item);
	}
	
	public void addMoney(double cash)
	{
		things.addMoney(cash);
	}
	
	@Override
	public String toString()
	{
		String returnString = "Room Name: " + this.getRoomName() + "\n";
		returnString += things.toString();
		returnString += "\nConnected to: ";
		for(HouseRoom aRoom: connectedRooms)
		{
			returnString += "\n\t" + aRoom.getRoomName();
		}
		return returnString;
	}
}
