import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class House {

	static File file = new File("zork");
	static PrintWriter pw;
	static {
		try
		{
			pw = new PrintWriter(file);
		}
		catch (IOException e)
		{
			System.out.println("Error writing to file.");
		}
	}
	
	public static void main(String[] args)
	{

		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);

		HouseRoom foyer = new HouseRoom("Foyer");
		HouseRoom frontRoom = new HouseRoom("Front Room");
		HouseRoom library = new HouseRoom("Library");
		HouseRoom kitchen = new HouseRoom("Kitchen");
		HouseRoom diningRoom = new HouseRoom("Dining Room");
		HouseRoom vault = new HouseRoom("Vault");
		HouseRoom parlor = new HouseRoom("Parlor");
		SecretRoom secret = new SecretRoom("Secret Room");

		//connect rooms
		foyer.addConnection(frontRoom);
		frontRoom.addConnection(library, kitchen);
		library.addConnection(diningRoom);
		kitchen.addConnection(parlor);
		parlor.addConnection(vault);
		//normal rooms connected

		//add items to rooms
		foyer.addItem(new Item("a dead scorpion"));
		frontRoom.addItem(new Item("a piano"));
		library.addItem(new Item("spiders"));
		kitchen.addItem(new Item("bats"));
		diningRoom.addItem(new Item("dust"));
		diningRoom.addItem(new Item("empty box"));
		vault.addItem(new Item("3 walking skeletons"));
		parlor.addItem(new Item("treasure chest"));
		secret.addItem(new Item("piles of gold"));
		//items added to rooms

		//populates rooms with money
		foyer.addMoney((double)rnd.nextInt(100000)/100.0);
		frontRoom.addMoney((double)rnd.nextInt(100000)/100.0);
		library.addMoney((double)rnd.nextInt(100000)/100.0);
		kitchen.addMoney((double)rnd.nextInt(100000)/100.0);
		diningRoom.addMoney((double)rnd.nextInt(100000)/100.0);
		vault.addMoney((double)rnd.nextInt(100000)/100.0);
		parlor.addMoney((double)rnd.nextInt(100000)/100.0);
		secret.addMoney((double)rnd.nextInt(100000)/100.0);
		//rooms populated with money
		
		//add all rooms to ArrayList to more easily search through them
		ArrayList<HouseRoom> rooms = new ArrayList<HouseRoom>();
		rooms.add(foyer);
		rooms.add(frontRoom);
		rooms.add(library);
		rooms.add(kitchen);
		rooms.add(diningRoom);
		rooms.add(vault);
		rooms.add(parlor);
		rooms.add(secret);

		System.out.print("Input name: ");
		Player p1 = new Player(sc.nextLine(), foyer);
		
		pw.println("Name: " + p1.getID());
		
		String choice = "";
		while(!choice.equals("exit"))
		{
			if(p1.getLocation().equals(vault))
			{
				if(rnd.nextInt(4) == 0 && !secret.getDiscovered())
				{
					System.out.println(secret.discover());
					secret.addConnection(vault);
				}
			}
			System.out.println(p1.getLocationInformation());
			System.out.println("Options: \'take all\', \'take money\', \'exit\', \'view report\', \'move\', \'history\'.");
			System.out.print("What will you do? ");
			choice = sc.nextLine();
			
			pw.println("User Input: " + choice);
			
			System.out.println();
			if(choice.equalsIgnoreCase("take all"))
			{
				System.out.println(p1.takeAllFromRoom());
				pw.println("Took all items from room.");
			}
			else if(choice.equalsIgnoreCase("take money"))
			{
				System.out.println(p1.takeMoney());
				pw.println("Took money from room.");
			}
			else if(choice.equalsIgnoreCase("view report"))
			{
				System.out.println(p1.viewReport());
				pw.println("Viewed player report.");
			}
			else if(choice.equalsIgnoreCase("exit"))
			{
				System.out.println("Coward");
				if(rnd.nextInt(4) == 0)
				{
					System.out.println("The spirit of Zork has followed you out.");
				}
				else
				{
					System.out.println("You were not followed");
				}
				System.out.println(p1.viewReport());
			}
			else if(choice.equalsIgnoreCase("move"))
			{
				System.out.print("\tWhere will you move to? ");
				String roomChoice = sc.nextLine();
				pw.print("Move to " + roomChoice + "...");
				boolean roomFound = false;
				for(HouseRoom room: rooms)
				{
					if(room.nameIs(roomChoice))
					{
						roomFound = true;
						System.out.println(p1.moveTo(room));
						pw.println("Success");
					}
				}
				if(!roomFound)
				{
					System.out.println("No such room.");
					pw.println("Failure");
				}
			}
			else if(choice.equalsIgnoreCase("history"))
			{
				displayHistory();
				pw.println("Viewed history");
			}
			else
			{
				System.out.println("Now is not the time for that!");
			}

			System.out.println();
		}
		sc.close();
		pw.flush();
		pw.close();
	}
	
	public static void displayHistory()
	{
		pw.flush();
		String line;
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			System.out.println();
			while ( (line = br.readLine())!= null)
			{
				System.out.println(line);
			}
			System.out.println();
			br.close();
		}
		catch (IOException e)
		{
			System.out.println("Error reading history.");
		}
	}
	
}
