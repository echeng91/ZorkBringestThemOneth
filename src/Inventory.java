import java.util.ArrayList;
import java.text.NumberFormat;

public class Inventory {

	private ArrayList<Item> items;
	private double money;
	
	public Inventory()
	{
		items = new ArrayList<Item>();
		money = 0.00;
	}
	
	public Inventory(ArrayList<Item> items_, double money_)
	{
		items = items_;
		money = money_;
	}
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	public double getMoney()
	{
		return money;
	}
	
	public void setMoney(double cash)
	{
		money = cash;
	}
	
	public void addItem(Item item)
	{
		items.add(item);
	}
	
	public void removeItem(Item item)
	{
		items.remove(item);
	}
	
	public void addMoney(double cash)
	{
		money += cash;
	}
	
	public void removeAllItems()
	{
		items.clear();
	}
	
	@Override
	public String toString()
	{
		String returnString = "Contents:\n";
		returnString += "\t" + NumberFormat.getCurrencyInstance().format(money);
		for(Item item: items)
		{
			returnString += "\n\t" + item.getID();
		}
		return returnString;
	}
}
