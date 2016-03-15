import java.text.NumberFormat;
import java.util.Random;

public abstract class Character {

	private String identity;
	private int maxHP;
	private int currentHP;
	private int power;
	private int armor;
	private Inventory inventory;
	private HouseRoom location;

	// Constructors
	public Character(String name) {
		identity = name;
		inventory = new Inventory();
	}

	public Character(String name, HouseRoom room) {
		identity = name;
		location = room;
		inventory = new Inventory();
	}
	
	public Character(String name, HouseRoom room, int hp, int atk, int def) {
		identity = name;
		location = room;
		maxHP = hp;
		currentHP = maxHP;
		power = atk;
		armor = def;
		inventory = new Inventory();
	}

	// Getters
	public String getID() {
		return identity;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public int getPower() {
		return power;
	}

	public int getArmor() {
		return armor;
	}

	public HouseRoom getLocation() {
		return location;
	}

	public Inventory getInventory() {
		return inventory;
	}

	// Setters
	public void setMaxHP(int newMax) {
		maxHP = newMax;
	}

	public void setCurrentHP(int current) {
		currentHP = current;
	}

	public void setPower(int pow) {
		power = pow;
	}

	public void setArmor(int arm) {
		armor = arm;
	}

	public void setLocation(HouseRoom room) {
		location = room;
	}

	// Other methods
	
	public String takeDamage(int damage)
	{
		this.setCurrentHP(this.getCurrentHP() - damage);
		String damageString = this.getID() + " takes " + damage + " damage! ";
		if(this.getCurrentHP() <= 0)
		{
			damageString += "\n" + this.getID() + " has died. ";
			damageString += this.dropLoot();
		}
		return damageString;
	}
	
	public String attack(Character other) {
		int damage;
		Random rnd = new Random();
		String attackString = this.getID() + " attacks " + other.getID() + "! ";
		//rolling a d20 for accuracy
		if (1 + rnd.nextInt(20) > other.getArmor()) {
			damage = rnd.nextInt(1 + this.getPower());//deal between 0 and power damage
			attackString += other.takeDamage(damage);;
		} else {
			attackString += this.getID() + " misses.";
		}
		return attackString;
	}
	
	public String dropLoot()
	{
		String loot = "Dropped into room: ";
		loot += "\n\t" + NumberFormat.getCurrencyInstance().format(this.getInventory().getMoney());
		this.getLocation().addMoney(this.getInventory().getMoney());
		this.getInventory().setMoney(0.00);
		
		for(Item item: this.getInventory().getItems())
		{
			this.getLocation().addItem(item);
			loot += "\n\t" + item.getID();
		}
		this.getInventory().getItems().clear();
		return loot;
	}
	
	@Override
	public String toString()
	{
		String returnString = this.getID();
		returnString += "\nHP:\t " + this.getCurrentHP() + "/" + this.getMaxHP();
		returnString += "\nATK: " + this.getPower() + "\tDEF: " + this.getArmor();
		return returnString;
	}

}
