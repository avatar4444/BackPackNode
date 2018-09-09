package Shared;

public class Weapon extends Equipable {
	private double damage;
	private double range;
	private double accuracy;
	private int critStrikeChance;
	private int speed;
	private boolean ammoRequired;

	public Weapon(String name2, double weight2, double value2, int durability2, int iD2, String material,
			boolean repairable, double damage, double range, double accuracy, int critStrikeChance, int speed,
			boolean ammoRequired) {
		super(name2, weight2, value2, durability2, iD2, material, repairable);
		this.damage = damage;
		this.range = range;
		this.accuracy = accuracy;
		this.critStrikeChance = critStrikeChance;
		this.speed = speed;
		this.ammoRequired = ammoRequired;
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public int getCritStrikeChance() {
		return critStrikeChance;
	}

	public void setCritStrikeChance(int critStrikeChance) {
		this.critStrikeChance = critStrikeChance;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isAmmoRequired() {
		return ammoRequired;
	}

	public void setAmmoRequired(boolean ammoRequired) {
		this.ammoRequired = ammoRequired;
	}
	

}
