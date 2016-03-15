import java.util.Random;

public class Enemy extends Character{

	private boolean hardMode;
	
	//Constructors
	public Enemy(String name)
	{
		super(name);
	}
	
	public Enemy(String name, HouseRoom room)
	{
		super(name, room);
		room.addEnemy(this);
	}
	
	public Enemy(String name, HouseRoom room, int hp, int atk, int def)
	{
		super(name, room, hp, atk, def);
		room.addEnemy(this);
	}
	
	public Enemy(String name, HouseRoom room, int hp, int atk, int def, boolean hard)
	{
		super(name, room, hp, atk, def);
		hardMode = hard;
		if(hardMode)
		{
			this.setMaxHP(hp * 3);
			this.setCurrentHP(hp * 3);
			this.setPower(atk * 3);
			this.setArmor(def * 3);
		}
		room.addEnemy(this);
	}
	
	//Getters
	
	//Setters
	
	//other methods
	public String enemyTurn(Player player)
	{
		String action;
		Random rnd = new Random();
		int possibleChoices = 3;
		if(hardMode)
		{
			possibleChoices *= 10;
		}
		int actionChoice = rnd.nextInt(possibleChoices);
		switch(actionChoice)
		{
		case 0: action = this.getID() + " stands idly." ;
		break;
		case 1: action = this.getID() + " glares at " + player.getID() + " menacingly.";
		break;
		default: action = this.attack(player);
		break;
		}
		
		return action;
	}
}
