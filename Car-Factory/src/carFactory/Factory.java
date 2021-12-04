package carFactory;

import java.util.ArrayList;

public class Factory extends Building {

    private ArrayList<Warehouse> warehouseAccess;

    public Factory(int buildingCapacity, String location,
                   int workingHours) {
        super(buildingCapacity, location, workingHours);
    }

    public void setWarehouseAccess(ArrayList<Warehouse> warehouses) {

    }

    public int[] getAllWarehouseMaterials(){
        return null;
    }
}
