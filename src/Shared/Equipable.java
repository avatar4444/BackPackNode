package Shared;

public class Equipable extends Item{
	private String material;
	private boolean repairable;
	
	public Equipable(String name2, double weight2, double value2, int durability2, int iD2, String material,
			boolean repairable) {
		super(name2, weight2, value2, durability2, iD2);
		this.material = material;
		this.repairable = repairable;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public boolean isRepairable() {
		return repairable;
	}
	public void setRepairable(boolean repairable) {
		this.repairable = repairable;
	}
}

