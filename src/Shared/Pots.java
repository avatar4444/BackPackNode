package Shared;

public class Pots extends Consumable {
	private String potionType;

	public Pots(String name2, double weight2, int value2, int durability2, int iD2, int health, double duration,
			int doses, boolean buff, String potionType) {
		super(name2, weight2, value2, durability2, iD2, health, duration, doses, buff);
		this.potionType = potionType;
	}

	public String getPotionType() {
		return potionType;
	}

	public void setPotionType(String potionType) {
		this.potionType = potionType;
	}

	@Override
	public String toString() {
		return "[Name: " + getName() + " (" + potionType + ")  Weight: " + getWeight() + ", Value: " + getValue()
				+ ", ID: " + getID() + " ]";
	}
}


