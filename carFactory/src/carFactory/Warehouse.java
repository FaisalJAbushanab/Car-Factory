package carFactory;

public class Warehouse extends Building{

    private int[] materialQuantity;

    public Warehouse(Capacity buildingCapacity, String location,
                     int workingHours, String phoneNumber /* ,Material material*/) {
        super(buildingCapacity, location, workingHours, phoneNumber);
    }

    public int[] getMaterialQuantity() {
        return null;
    }
}
