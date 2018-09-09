package Client;

import java.awt.List;
import java.util.Scanner;

import Server.RetrieveData;

public class Test {
	public static void main(String[] args) {
		new Test();

	}

	public Test() {

		Scanner input = new Scanner(System.in);
		while (true) {
			//each cmd line option 
			System.out.println("1: Load All Items");
			System.out.println("2: Search Item");
			System.out.println("3: Remove Item");
			System.out.println("4: Display Items");
			System.out.println("5: Sort Items");
			System.out.println("6: Exit Program");
			int choice = input.nextInt();
			input.nextLine();
			switch (choice) {
			case 1:
				RetrieveData.addItems();
				break;
			case 2:
				RetrieveData.searchItem();
				break;
			case 3:
				RetrieveData.removeItem();
				break;
			case 4:
				RetrieveData.displayItems();
				break;
			case 5:
				RetrieveData.sortItems();
				break;
			case 6:
				input.close();
				System.exit(0);
			}

		}

	}

}
