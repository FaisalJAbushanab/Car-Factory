package carFactory;
//sdf;

import java.util.ArrayList;

public class Factory extends Building {

    private ArrayList<Warehouse> warehouseAccess = new ArrayList<>();

    public Factory(int[] workerCapacity, String location, int workingHours) {
        super(workerCapacity, location, workingHours);
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

    public int calculateSuitabilty(Request request) {
        //calculateCost(request.computers);
        //calculateTime(request.computers);
        return 0;
    }

    private void calculateTime(ArrayList<Computer> computers) {
        int[] computerSumEmployee = new int[9];
        for (Computer comps : computers) {
            comps.getNumberOfEmployees();
        }
//        if (!(computerSumEmployee < super.buildingCapacity)) {
//            //
//        }
//        else {
//
//        }

    }

    private void calculateCost(ArrayList<Computer> computers) {
        int[] wareHouseAccessSumMaterials = new int[9];
        for (Warehouse access : warehouseAccess) {
            access.getMaterialQuantity();
        }

        int[] computerSumMaterials = new int[9];
        for (Computer comps : computers) {
            comps.getConstructMaterial();
        }



    }
}
