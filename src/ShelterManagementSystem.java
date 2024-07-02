import java.util.Hashtable;
import java.util.Scanner;

public class ShelterManagementSystem {
	// Initialize a Hashtable to keep track of shelters by their names
	private static Hashtable<String, Shelter> shelters = new Hashtable<>();
	// Scanner object for input handling
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Homeless Shelter Management System");
		System.out.println("--------------------------------------------------");

		int choice;
		// Loop until user decides to exit
		do {
			displayMenu();
			choice = scanner.nextInt();
			// Handling newline after number input
			scanner.nextLine();
			switch (choice) {
			// Adding a new shelter to the system
			case 1:
				addShelter();
				break;
				// Update the number of available beds in an existing shelter
			case 2:
				updateAvailableBeds();
				break;
				// Search for a shelter by name and display details
			case 3:
				searchShelter();
				break;
				// Exit message before terminating the program
			case 4:
				System.out.println("Goodbye!");
				break;
				// Handle invalid choice entry
			default:
				System.out.println("Invalid choice. Please select a valid option.");
			}
		} while (choice != 4); // Continue until the user selects 'Exit'
		// Closing the scanner resource
		scanner.close();
		// Method to display the main menu
	}

	private static void displayMenu() {
		System.out.println("1. Add Shelter");
		System.out.println("2. Update Available Beds");
		System.out.println("3. Search Shelter");
		System.out.println("4. Exit");
		System.out.print("Enter your choice: ");
	}
	// Method to add a new shelter to the system
	private static void addShelter() {
		System.out.print("Enter shelter name: ");
		String shelterName = scanner.nextLine();
		System.out.print("Enter location: ");
		String location = scanner.nextLine();
		System.out.print("Enter capacity: ");
		int capacity = scanner.nextInt();
		System.out.print("Enter available beds: ");
		int availableBeds = scanner.nextInt();
		scanner.nextLine(); 
		// Consuming the trailing newline
		System.out.print("Enter contact info: ");
		String contactInfo = scanner.nextLine();
		
		 // Create a new Shelter object and add it to the Hashtable
		Shelter newShelter = new Shelter(shelterName, location, capacity, availableBeds, contactInfo);
		shelters.put(shelterName, newShelter);
		System.out.println("Shelter added successfully!");
	}
	
	// Method to update the number of available beds for a specific shelter
	private static void updateAvailableBeds() {
		System.out.print("Enter shelter name: ");
		String shelterName = scanner.nextLine();
		Shelter shelter = shelters.get(shelterName);
		if (shelter != null) {
			System.out.print("Enter new available beds: ");
			int newBeds = scanner.nextInt();
			// Update the bed count
			shelter.updateAvailableBeds(newBeds); 
		} else {
			System.out.println("Shelter not found.");
		}
	}

	// Method to search for and display details of a specific shelter
	private static void searchShelter() {
		System.out.print("Enter shelter name: ");
		String shelterName = scanner.nextLine();
		Shelter shelter = shelters.get(shelterName);
		if (shelter != null) {
			System.out.println(shelter); // Displaying shelter details
		} else {
			System.out.println("Shelter not available.");
		}
	}
}