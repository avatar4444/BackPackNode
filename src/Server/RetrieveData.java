package Server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Shared.MainHand;
import Shared.Node;
import Shared.Body;
import Shared.Item;
import Shared.OffHand;
import Shared.Pots;

public class RetrieveData {
	private static final double MAX_WEIGHT = 25.0;
	private static double currentWeight;
	RetrieveData list = new RetrieveData();
	static Node start;
	static Node tail;
	static Node next;
	static Object data = null;
	static int size = 0;

	//this function add the items form a text file, 
	//the DB connection can be used to get data from a SQL server
	public static void addItems() {
		final int WEAPON = 1;
		final int ARMOR = 2;

		// start = null;
		tail = null;

		try {
			BufferedReader br = new BufferedReader(

			new FileReader("C:\\Users\\avtar\\Desktop\\Item.txt"));
			String line;
			System.out.println("Items added to backpack: ");
			//while there is a next line, keep adding items to the backpack
			while ((line = br.readLine()) != null) {

				String temp[] = line.split("\t");
				String name = temp[0];
				double weight = Double.parseDouble(temp[1]);

				int value = Integer.parseInt(temp[2]);
				int durability = Integer.parseInt(temp[3]);
				int ID = Integer.parseInt(temp[4]);
				if ((currentWeight + weight) < MAX_WEIGHT) {
					size++;
					if (ID < 1000) {
						String material = temp[5];
						boolean repairable = Boolean.parseBoolean(temp[6]);
						if ((ID % 10) == WEAPON) {

							double damage = Double.parseDouble(temp[7]);
							double range = Double.parseDouble(temp[8]);
							double accuracy = Double.parseDouble(temp[9]);
							int critStrikeChance = Integer.parseInt(temp[10]);
							int speed = Integer.parseInt(temp[11]);
							boolean ammoRequired = Boolean.parseBoolean(temp[12]);
							String weaponName = temp[13];
							String specAtt = temp[14];
							if (start == null) {
								start = new Node(new MainHand(name, weight, value, durability, ID, material, repairable,
										damage, range, accuracy, critStrikeChance, speed, ammoRequired, weaponName,
										specAtt), null);
								tail = start;
							} else {
								next = new Node(new MainHand(name, weight, value, durability, ID, material, repairable,
										damage, range, accuracy, critStrikeChance, speed, ammoRequired, weaponName,
										specAtt), null);
								tail.setNext(next);
								tail = next;
							}

						} else if ((ID % 10) == ARMOR) {
							int defence = Integer.parseInt(temp[7]);
							int magicResist = Integer.parseInt(temp[8]);
							int deflect = Integer.parseInt(temp[9]);
							int dodge = Integer.parseInt(temp[10]);
							String ArmorN = temp[11];
							String ArmorSpec = temp[12];
							if (name.equalsIgnoreCase("shield")) {
								if (start == null) {
									start = new Node(new OffHand(name, weight, value, durability, ID, material,
											repairable, defence, magicResist, deflect, dodge, ArmorN, ArmorSpec), null);
									tail = start;
								} else {
									next = new Node(new OffHand(name, weight, value, durability, ID, material,
											repairable, defence, magicResist, deflect, dodge, ArmorN, ArmorSpec), null);
									tail.setNext(next);
									tail = next;
								}

							} else {
								if (start == null) {
									start = new Node(new Body(name, weight, value, durability, ID, material, repairable,
											defence, magicResist, deflect, dodge, ArmorN, ArmorSpec), null);
									tail = start;
								} else {
									next = new Node(new Body(name, weight, value, durability, ID, material, repairable,
											defence, magicResist, deflect, dodge, ArmorN, ArmorSpec), null);
									tail.setNext(next);
									tail = next;
								}
							}
						}
					} else if (ID > 1000) {
						int health = Integer.parseInt(temp[5]);
						double duration = Double.parseDouble(temp[6]);
						int doses = Integer.parseInt(temp[7]);
						boolean buff = Boolean.parseBoolean(temp[8]);
						String potSpec = temp[9];
						if (start == null) {
							start = new Node(new Pots(name, weight, value, durability, ID, health, duration, doses,
									buff, potSpec), null);
							tail = start;
						} else {
							next = new Node(new Pots(name, weight, value, durability, ID, health, duration, doses, buff,
									potSpec), null);
							tail.setNext(next);
							tail = next;
						}
						data = new Pots(name, weight, value, durability, ID, health, duration, doses, buff, potSpec);

					}
					currentWeight += weight;

				} else {
					System.out.println("Backpack weight at: " + (currentWeight ) + " , total items: " + size);
					break;
				}

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//function to seach for given item in the backpack
	public static void searchItem() {
		Node p;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the name for the item: ");
		String searchName = scanner.next();
		p = start;
		while (p != null) {
			String name = p.getItem().getName();
			if (name.equalsIgnoreCase(searchName)) {
				break;
			}
			p = p.getNext();
		}
		if (p != null) {
			System.out.println("****** " + searchName + " found ******");
			System.out.println(p.getItem().toString());

		}
		if (p == null) {
			System.out.println("No items " + searchName + " in the backpack");

		}
	}

	//function that displays item that in the backpack
	public static void displayItems() {
		System.out.println("Back pack has the following items: ");
		Node next, check;
		Node p = start;

		while (p != null) {
			int count = 1;
			boolean diffrentItem = true;
			next = p.getNext();
			check = start;
			while (check != p) {
				if (check.getItem().getName().equalsIgnoreCase(p.getItem().getName())) {
					diffrentItem = false;
					p = p.getNext();
					break;
					
				}
				check = check.getNext();
			}
			if (diffrentItem) {
				while (next != null) {
					if (p.getItem().getName().equalsIgnoreCase(next.getItem().getName())) {
						count++;
					}
					next = next.getNext();
				}

				System.out.println("Total " + count + ": " + p.getItem().toString());

				count = 0;
				p = p.getNext();
			}
		}
		System.out.println("Total items: " + size + " Total Weight: " + currentWeight);
		
	}

	public static void sortItems() {
		if (size > 1) {
			for (int i = 0; i < size; i++) {
				Node currentNode = start;
				Node next = start.getNext();
				while (next != null) {
					int z = currentNode.getItem().getName().compareToIgnoreCase(next.getItem().getName());
					if (z > 0) {
						Item temp = currentNode.getItem();
						currentNode.setItem(next.getItem());
						next.setItem(temp);
					}
					currentNode = next;
					next = next.getNext();
				}
			}
		}
	}

	public static void removeItem() {
		Scanner scanner = new Scanner(System.in);
		Node prev, del;
		System.out.print("Enter item name that you'd like to remove: ");
		String searchName = scanner.next();
		del = start;
		prev = null;
		while (del != null) {
			if (del.getItem().getName().equalsIgnoreCase(searchName))
				break;
			prev = del;
			del = del.getNext();
		}
		if (del == null) {
			System.out.println("Delete node not found");
		} else {
			if (del == start) {
				currentWeight -= del.getItem().getWeight();
				size--;
				start = start.getNext();
				
				System.out.print("Item romoved: " + del.getItem().toString());
			} else {
				currentWeight -= prev.getItem().getWeight();
				size--;
				prev.setNext(del.getNext());
				System.out.print("Item romoved: " + del.getItem().toString());
			}
		}
	}
}
