import java.util.Hashtable;
import java.util.Scanner;

public class ShelterManagementSystem {
	private static Hashtable<String, Shelter> shelters = new Hashtable<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Homeless Shelter Management System");
		System.out.println("--------------------------------------------------");

		int choice;
		do {
			displayMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				addShelter();
				break;
			case 2:
				updateAvailableBeds();
				break;
			case 3:
				searchShelter();
				break;
			case 4:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		} while (choice != 4);

		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("1. Add Shelter");
		System.out.println("2. Update Available Beds");
		System.out.println("3. Search Shelter");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
	}

	private static void addShelter() {
		System.out.print("Enter shelter name: ");
		String shelterName = scanner.nextLine();
		System.out.print("Enter location: ");
		String location = scanner.nextLine();
		System.out.print("Enter capacity: ");
		int capacity = scanner.nextInt();
		System.out.print("Enter available beds: ");
		int availableBeds = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter contact info: ");
		String contactInfo = scanner.nextLine();

		Shelter newShelter = new Shelter(shelterName, location, capacity, availableBeds, contactInfo);
		shelters.put(shelterName, newShelter);
		System.out.println("Shelter added successfully!");
	}

	private static void updateAvailableBeds() {
		System.out.print("Enter shelter name: ");
		String shelterName = scanner.nextLine();
		Shelter shelter = shelters.get(shelterName);
		if (shelter != null) {
			System.out.print("Enter new available beds: ");
			int newBeds = scanner.nextInt();
			shelter.updateAvailableBeds(newBeds);
		} else {
			System.out.println("Shelter not found.");
		}
	}

	private static void searchShelter() {
		System.out.print("Enter shelter name: ");
		String shelterName = scanner.nextLine();
		Shelter shelter = shelters.get(shelterName);
		if (shelter != null) {
			System.out.println(shelter);
		} else {
			System.out.println("Shelter not available.");
		}
	}
}