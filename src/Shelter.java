class Shelter {
	// Declaring private variables for shelter properties
	private String name;
	private String location;
	private int capacity;
	private int availableBeds;
	private String contactInfo;

	// Constructor to initialize a new shelter object
	public Shelter(String name, String location, int capacity, int availableBeds, String contactInfo) {
		this.name = name; // name of the shelter
		this.location = location; // location of the shelter
		this.capacity = capacity; // the total capacity of the shelter
		this.availableBeds = availableBeds; // the initial available beds
		this.contactInfo = contactInfo; // contact info for the shelter
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getAvailableBeds() {
		return availableBeds;
	}
	
	public String getContactInfo() {
		return contactInfo;
	}

	// Method to update the number of available beds in the shelter
	public void updateAvailableBeds(int newAvailableBeds) {
		if (newAvailableBeds <= capacity) { // Check if the new number of beds is within capacity
			availableBeds = newAvailableBeds; // Update available beds
			System.out.println("Available beds updated successfully!");
		} else {
			// Error handling if the new number of beds exceeds the shelter's capacity
			System.out.println("Error: Available beds cannot exceed the shelter capacity.");
		}
	}
	// Override the toString method to provide a custom string representation of a Shelter object
	@Override
	public String toString() {
		return "Shelter: " + name + ", Location: " + location + ", Capacity: " + capacity + ", Available Beds: "
				+ availableBeds + ", Contact Info: " + contactInfo;
	}
}