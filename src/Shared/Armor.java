package Shared;

public class Armor extends Equipable {
	private int defence;
	private int magicResist;
	private int deflect;
	private int dodge;

	public Armor(String name2, double weight2, double value2, int durability2, int iD2, String material,
			boolean repairable, int defence, int magicResist, int deflect, int dodge) {
		super(name2, weight2, value2, durability2, iD2, material, repairable);
		this.defence = defence;
		this.magicResist = magicResist;
		this.deflect = deflect;
		this.dodge = dodge;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getMagicResist() {
		return magicResist;
	}

	public void setMagicResist(int magicResist) {
		this.magicResist = magicResist;
	}

	public int getDeflect() {
		return deflect;
	}

	public void setDeflect(int deflect) {
		this.deflect = deflect;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodge) {
		this.dodge = dodge;
	}

}
