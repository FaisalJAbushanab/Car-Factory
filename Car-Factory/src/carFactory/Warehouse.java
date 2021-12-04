package carFactory;

public class Warehouse extends Building{

    private int[] materialQuantity;
    private Material material;

    public Warehouse(int[] buildingCapacity, String location,
                     int workingHours, Material material) {
        super(buildingCapacity, location, workingHours);
        this.material = material;
    }

    public int[] getMaterialQuantity() {
        return null;
    }

    public Material getMaterial() {
        return material;
    }
}
