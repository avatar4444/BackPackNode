package Shared;

public class Item {

	private String name;
	private double weight;
	private double value;
	private int durability;
	private int ID;

	public Item(String name2, double weight2, double value2, int durability2, int iD2) {
		this.name = name2;
		this.weight = weight2;
		this.value = value2;
		this.durability = durability2;
		this.ID = iD2;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(long newWeight) {
		this.weight = newWeight;
	}

	public double getValue() {
		return value;
	}

	public void setValue(long newValue) {
		this.value = newValue;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int newDurability) {
		this.durability = newDurability;
	}

	public int getID() {
		return ID;
	}

	public void setID(int newId) {
		ID = newId;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", weight=" + weight + ", value=" + value + "]";
	}

}
