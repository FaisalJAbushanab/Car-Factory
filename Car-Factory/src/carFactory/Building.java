package carFactory;

public class Building {
	private Capacity buildingCapacity;
    private String location;
    private int workingHours;
    private String phoneNumber;

    public Building(Capacity buildingCapacity, String location,
                    int workingHours, String phoneNumber) {
        this.buildingCapacity = buildingCapacity;
        this.location = location;
        this.workingHours = workingHours;
        this.phoneNumber = phoneNumber;
    }

    public Capacity getCapacity() {
        return buildingCapacity;
    }

    public String getLocation() {
        return location;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
