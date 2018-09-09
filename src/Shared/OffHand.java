package Shared;

public class OffHand extends Armor{
	private String offHandName;
	private String specialDff;
	
	
	public OffHand(String name2, double weight2, double value2, int durability2, int iD2, String material,
			boolean repairable, int defence, int magicResist, int deflect, int dodge, String offHandName,
			String specialDff) {
		super(name2, weight2, value2, durability2, iD2, material, repairable, defence, magicResist, deflect, dodge);
		this.offHandName = offHandName;
		this.specialDff = specialDff;
	}
	public String getOffHandName() {
		return offHandName;
	}
	public void setOffHandName(String offHandName) {
		this.offHandName = offHandName;
	}
	public String getSpecialAttDff() {
		return specialDff;
	}
	public void setSpecialAttDff(String specialAttDff) {
		this.specialDff = specialAttDff;
	}
	@Override
	public String toString() {
		
		return "[Name: " + getName() + " (" + offHandName + ")  Weight: "
		+ getWeight() + ", Value: " + getValue() + ", ID: " 
		+ getID()+ ", It can : " + specialDff  + " ]";
	}
	
}
