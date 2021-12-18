package phase2;

/**
 * The bulding class is an abstract class that shows a number of variables,
 * and Methods talk about location, building capacity and working hours.
 */

public abstract class Building {
    private int[] buildingCapacity;
    private String location;
    private int workingHours;
    /**
     *
     * @param buildingCapacity
     * @param location
     * @param workingHours
     */
    public Building(int[] buildingCapacity, String location, int workingHours) {
        this.buildingCapacity = buildingCapacity;
        this.location = location;
        this.workingHours = workingHours;
    }

    public int[] getCapacity() {
        return buildingCapacity;
    }

    public String getLocation() {
        return location;
    }

    public int getWorkingHours() {
        return workingHours;
    }

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}
