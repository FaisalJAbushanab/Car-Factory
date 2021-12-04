package carFactory;

public class Building {
	private int buildingCapacity;
    private String location;
    private int workingHours;

    public Building(int buildingCapacity, String location,
                    int workingHours) {
        this.buildingCapacity = buildingCapacity;
        this.location = location;
        this.workingHours = workingHours;
    }

    public int getCapacity() {
        return buildingCapacity;
    }

    public String getLocation() {
        return location;
    }

    public int getWorkingHours() {
        return workingHours;
    }

}
