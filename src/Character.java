
public abstract class Character {

	private String identity;
	private int maxHP;
	private int currentHP;
	private int power;
	private int armor;
	private Inventory inventory;
	private HouseRoom location;
	
	//Constructors
	public Character(String name)
	{
		identity = name;
		inventory = new Inventory();
	}
	public Character(String name, HouseRoom room)
	{
		identity = name;
		location = room;
		inventory = new Inventory();
	}
	
	//Getters
	public String getID()
	{
		return identity;
	}
	public int getMaxHP()
	{
		return maxHP;
	}
	public int getCurrentHP()
	{
		return currentHP;
	}
	public int getPower()
	{
		return power;
	}
	public int getArmor()
	{
		return armor;
	}
	public HouseRoom getLocation()
	{
		return location;
	}
	public Inventory getInventory()
	{
		return inventory;
	}
	
	//Setters
	public void setMaxHP(int newMax)
	{
		maxHP = newMax;
	}
	public void setCurrentHP(int current)
	{
		currentHP = current;
	}
	public void setPower(int pow)
	{
		power = pow;
	}
	public void setArmor(int arm)
	{
		armor = arm;
	}
	public void setLocation(HouseRoom room)
	{
		location = room;
	}
	
	//Other methods
	/*
	 * returns the amount of damage one character deals to another
	 */
	public int attack(Character other)
	{
		int damage;
		
		if(this.getPower() > other.getArmor())
		{
			damage = this.getPower() - other.getArmor();
		}
		else
		{
			damage = 0;;
		}
		return damage;
	}
	
}
