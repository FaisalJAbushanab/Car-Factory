package CarFactory;

import java.util.ArrayList;

public class Factory extends Building {

    private ArrayList<Warehouse> warehouseAccess;

    public Factory(Capacity buildingCapacity, String location,
                   int workingHours, String phoneNumber) {
        super(buildingCapacity, location, workingHours, phoneNumber);
    }

    public void setWarehousAccess(ArrayList<Warehouse> warehouses) {

    }

    public int[] getAllWarehouseMaterials(){
        return null;
    }
}
