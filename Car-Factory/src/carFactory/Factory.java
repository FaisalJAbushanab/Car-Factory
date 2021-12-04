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
        checkMaterial(request.computers);


        //calculateTime(request.computers);
        return -1;
    }

    private void checkTime(ArrayList<Computer> computers) {
        int[] computerSumEmployee = new int[9];
        for (Computer comps : computers) {
            comps.getNumberOfEmployees();
        }
//        if (!(computerSumEmployee < super.buildingCapacity)) {
//            //
            calculateTime(computerSumEmployee);
//        }
//        else {
//
//        }

    }

    private int calculateTime(int[] computerSumEmployee) {
        int time = 0;
//        for (Computer comps : computers) {
////            comps.getNumberOfEmployees();
////            time++;
////        }
        return time;
    }

    private void checkMaterial(ArrayList<Computer> computers) {
        int[] wareHouseAccessSumMaterials = new int[9];
        for (Warehouse access : warehouseAccess) {
            access.getMaterialQuantity();
        }

        int[] computerSumMaterials = new int[9];
        for (Computer comps : computers) {
            comps.getConstructMaterial();
        }


        //if
        calculateCostMats(computerSumMaterials);

    }

    private int calculateCostMats(int[] computerSumMaterials) {
        for (Warehouse access : warehouseAccess) {
            access.getMaterial().getMaterialPrice();
        }
        return 0;
    }
}
