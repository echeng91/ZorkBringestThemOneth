
public abstract class Room {

	private String roomName;
	private boolean visited;
	
	//Constructor
	public Room()
	{
		
	}
	
	public Room(String name)
	{
		roomName = name;
	}
	
	public Room(String name, boolean seen)
	{
		roomName = name;
		visited = seen;
	}
	
	//Getters
	public String getRoomName()
	{
		return roomName;
	}
	
	public boolean getVisited()
	{
		return visited;
	}
	
	//Setters
	public void setRoomName(String name)
	{
		roomName = name;
	}
	
	public void setVisited(boolean seen)
	{
		visited = seen;
	}
	
	//other methods
	public boolean nameIs(String name)
	{
		return roomName.equalsIgnoreCase(name);
	}
}
