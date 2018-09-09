package Shared;

public class Consumable extends Item {
	private int health;
	private double duration;
	private int doses;
	private boolean buff;

	public Consumable(String name2, double weight2, double value2, int durability2, int iD2, int health,
			double duration, int doses, boolean buff) {
		super(name2, weight2, value2, durability2, iD2);
		this.health = health;
		this.duration = duration;
		this.doses = doses;
		this.buff = buff;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getDoses() {
		return doses;
	}

	public void setDoses(int doses) {
		this.doses = doses;
	}

	public boolean isBuff() {
		return buff;
	}

	public void setBuff(boolean buff) {
		this.buff = buff;
	}

}
