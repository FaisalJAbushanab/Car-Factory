package carFactory;

public class Warehouse extends Building{

    private int[] materialQuantity;

    public Warehouse(int buildingCapacity, String location,
                     int workingHours, Material material) {
        super(buildingCapacity, location, workingHours);
    }

    public int[] getMaterialQuantity() {
        return null;
    }
}
