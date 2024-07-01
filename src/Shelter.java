class Shelter {
	private String name;
	private String location;
	private int capacity;
	private int availableBeds;
	private String contactInfo;

	public Shelter(String name, String location, int capacity, int availableBeds, String contactInfo) {
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.availableBeds = availableBeds;
		this.contactInfo = contactInfo;
	}

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

	// Method to update available beds
	public void updateAvailableBeds(int newAvailableBeds) {
		if (newAvailableBeds <= capacity) {
			availableBeds = newAvailableBeds;
			System.out.println("Available beds updated successfully!");
		} else {
			System.out.println("Error: Available beds cannot exceed the shelter capacity.");
		}
	}

	@Override
	public String toString() {
		return "Shelter: " + name + ", Location: " + location + ", Capacity: " + capacity + ", Available Beds: "
				+ availableBeds + ", Contact Info: " + contactInfo;
	}
}