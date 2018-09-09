package Shared;

public class MainHand extends Weapon{
	private String mainHandName;
	private String specialAtt;
	
	public MainHand(String name2, double weight2, double value2, int durability2, int iD2, String material,
			boolean repairable, double damage, double range, double accuracy, int critStrikeChance, int speed,
			boolean ammoRequired, String mainHandName, String specialAtt) {
		super(name2, weight2, value2, durability2, iD2, material, repairable, damage, range, accuracy, critStrikeChance,
				speed, ammoRequired);
		this.mainHandName = mainHandName;
		this.specialAtt = specialAtt;
	}
	public String getMainHandName() {
		return mainHandName;
	}
	public void setMainHandName(String mainHandName) {
		this.mainHandName = mainHandName;
	}
	public String getSpecialAtt() {
		return specialAtt;
	}
	public void setSpecialAtt(String specialAtt) {
		this.specialAtt = specialAtt;
	}
	@Override
	public String toString() {
		return "[Name: " + getName() + " (" + mainHandName+ ")"  
				+ " Weight: " + getWeight() + ", Value: " + getValue() + ", ID: " 
				+ getID()+ ", special Attack: " + specialAtt  + " ]";
	}
	
	
}
