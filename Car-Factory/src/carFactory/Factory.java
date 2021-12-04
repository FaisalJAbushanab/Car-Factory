package carFactory;
//sdf;

import java.util.ArrayList;

public class Factory extends Building {

    private ArrayList<Warehouse> warehouseAccess = new ArrayList<>();

    public Factory(int buildingCapacity, String location,
                   int workingHours) {
        super(buildingCapacity, location, workingHours);
    }

    public void setWarehouseAccess(ArrayList<Warehouse> warehouses) {
    	for(Warehouse warehouse: warehouses) {
    		if(warehouse.getLocation().equals(this.getLocation())) {
    			warehouseAccess.add(warehouse);
    		}
    	}
    }

    public int[] getAllWarehouseMaterials(){
        return null;
    }
}
