package Shared;

public class Body extends Armor {
	private String gearName;
	private String Special;

	public Body(String name2, double weight2, double value2, int durability2, int iD2, String material,
			boolean repairable, int defence, int magicResist, int deflect, int dodge, String gearName, String special) {
		super(name2, weight2, value2, durability2, iD2, material, repairable, defence, magicResist, deflect, dodge);
		this.gearName = gearName;
		Special = special;
	}

	public String getGearName() {
		return gearName;
	}

	public void setGearName(String gearName) {
		this.gearName = gearName;
	}

	public String getSpecial() {
		return Special;
	}

	public void setSpecial(String special) {
		Special = special;
	}
	@Override
	public String toString() {
		return "[Name: " + getName() + " (" + gearName+ ") Weight: " 
				+ getWeight() + ", Value: " + getValue() + ", ID: " 
				+ getID()+ ", Super Power: " + Special  + " ]";
	}
}
