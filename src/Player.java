import java.text.NumberFormat;
import java.util.ArrayList;

public class Player extends Character {

	private int roomsVisited;
	private ArrayList<String> itemsSeen;

	// Constructor
	public Player(String name) {
		super(name);
		roomsVisited = 0;
		itemsSeen = new ArrayList<String>();
	}

	public Player(String name, HouseRoom room) {
		super(name, room);
		itemsSeen = new ArrayList<String>();
		room.setVisited(true);
		roomsVisited = 1;
		for (Item item : room.getThings().getItems()) {
			itemsSeen.add(item.getID());
		}
	}
	
	public Player(String name, HouseRoom room, int hp, int atk, int def) {
		super(name, room, hp, atk, def);
		itemsSeen = new ArrayList<String>();
		room.setVisited(true);
		roomsVisited = 1;
		for (Item item : room.getThings().getItems()) {
			itemsSeen.add(item.getID());
		}
	}

	// Getter
	public int getRoomsVisited() {
		return roomsVisited;
	}

	// Setter
	public void setRoomsVisited(int count) {
		roomsVisited = count;
	}

	// other methods
	public String moveTo(HouseRoom aRoom) {
		String movement;
		if (this.getLocation().isConnected(aRoom) || aRoom.getVisited()) {
			this.setLocation(aRoom);
			movement = "Moved to " + this.getLocation().getRoomName();
			if (this.getLocation().getVisited() == false) {
				roomsVisited++;
				this.getLocation().setVisited(true);
				for (Item item : this.getLocation().getThings().getItems()) {
					itemsSeen.add(item.getID());
				}
			}
		} else {
			movement = "Cannot go there. Remain in " + this.getLocation().getRoomName();
		}
		return movement;
	}

	public String takeAllFromRoom() {
		String loot = "Looted:";
		for (Item item : this.getLocation().getThings().getItems()) {
			this.getInventory().addItem(item);
			loot += "\n\t" + item.getID();
		}
		this.getLocation().getThings().removeAllItems();
		this.getInventory().addMoney(this.getLocation().getThings().getMoney());
		loot += "\n\t" + NumberFormat.getCurrencyInstance().format(this.getLocation().getThings().getMoney());
		this.getLocation().getThings().setMoney(0.00);
		return loot;
	}

	public String takeMoney() {
		String loot = "Looted:";
		this.getInventory().addMoney(this.getLocation().getThings().getMoney());
		loot += "\n\t" + NumberFormat.getCurrencyInstance().format(this.getLocation().getThings().getMoney());
		this.getLocation().getThings().setMoney(0.00);
		return loot;
	}

	public String viewReport() {
		String status = "";
		status += "Name: " + this.getID();
		status += "\nRooms visited: " + this.getRoomsVisited();
		status += "\nThings seen:";
		for (String saw : itemsSeen) {
			status += "\n\t" + saw;
		}
		status += "\nInventory " + this.getInventory().toString();
		return status;
	}

	public String getLocationInformation() {
		return this.getLocation().toString();
	}

}
