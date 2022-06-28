package app;

import java.util.Locale;
import java.util.Scanner;

import util.List;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<String> list = new List<>();

		int op;
		do {

			String value;
			int index;

			showMenu();
			op = sc.nextInt();

			switch (op) {
			case 1:
				System.out.print("Insert a value:");
				value = sc.next();
				list.addFirst(value);
				break;

			case 2:
				System.out.print("Insert a value:");
				value = sc.next();
				list.addLast(value);
				break;

			case 3:
				System.out.print("Insert a value:");
				value = sc.next();
				System.out.print("Insert a index:");
				index = sc.nextInt();
				list.addIndex(index, value);
				break;

			case 4:
				System.out.println("Element removed: [" + list.removeFirst() + "]");
				break;

			case 5:
				System.out.println("Element removed: [" + list.removeLast() + "]");
				break;

			case 6:
				System.out.print("Insert a index:");
				index = sc.nextInt();
				System.out.println("Element removed: [" + list.removeIndex(index) + "]");
				break;

			case 7:
				list.sort();
				break;

			case 8:
				System.out.println(list.toString());
				break;

			case 9:
				System.out.println("End of program");
				break;

			default:
				System.out.println("Invalid option");
				break;
			}

			System.out.println("");
			System.out.println("");
			System.out.println("");
			
		} while (op != 9);

		sc.close();

	}

	public static void showMenu() {
		System.out.println("================================================================");
		System.out.println("Insert: [1-Beginning] [2-Last] [3-Index]");
		System.out.println("Remove: [4-Beginning] [5-Last] [6-Index]");
		System.out.println("......: [7-Sort list] [8-Show] [9-Exit]");
	}

}
