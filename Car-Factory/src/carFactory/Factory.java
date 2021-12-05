package carFactory;

import java.util.ArrayList;

public class Factory extends Building {

    private ArrayList<Warehouse> warehouseAccess = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();

    public Factory(int[] workerCapacity, String location, int workingHours) {
        super(workerCapacity, location, workingHours);
        
        setWarehouseAccess(warehouseAccess);
        
        int numOfEmployees = (int)Math.floor(Math.random()*(500-100+1)+100);
        for(int i=0; i < numOfEmployees; i++) {
        	int rand = (int)Math.floor(Math.random()*(3-1+1)+1);
        	if(rand == 1) {
        		Employee employee = new Engineer();
        		employees.add(employee);
        	}else if(rand == 2) {
        		Employee employee = new Technician();
        		employees.add(employee);
        	}else {
        		Employee employee = new Worker();
        		employees.add(employee);
        	}
        }
    }

    public void setWarehouseAccess(ArrayList<Warehouse> warehouses) {
    	for(Warehouse warehouse: warehouses) {
    		if(warehouse.getLocation().equals(this.getLocation())) {
    			warehouseAccess.add(warehouse);
    		}
    	}
    }

    public int calculateSuitabilty(Request request, int time) {
    	int calculatedCost = 0;
        if(checkMaterial(request.computers)) {
        	calculatedCost = calculateCostMats(getComputerTotalMaterial(request.computers));
        }else{
        	calculatedCost = 0;
        }

    }
    
    private boolean checkMaterial(ArrayList<Computer> computers) {

        boolean materialSuffecient= true;
        for(int i = 0; i < getWarehouseTotalMaterial().length; i++) {
        	if( getComputerTotalMaterial(computers)[i] > getWarehouseTotalMaterial()[i]) {
        		materialSuffecient = false;
        		break;
        	}
        }
        return materialSuffecient;

    }
    private int[] getWarehouseTotalMaterial() {
    	int[] wareHouseAccessTotalMaterials = new int[9];
        for (Warehouse access : warehouseAccess) {
            int[] warehouseMaterial = access.getMaterialQuantity();
            for(int i = 0; 0 < wareHouseAccessTotalMaterials.length; i++) {
            	wareHouseAccessTotalMaterials[i] += warehouseMaterial[i];
            }
        }
        return wareHouseAccessTotalMaterials;
    }
    
    private int[] getComputerTotalMaterial(ArrayList<Computer> computers) {
    	
    	int[] computerSumMaterials = new int[9];
        for (Computer comps : computers) {
            int[] compsMaterial = comps.getConstructMaterial();
            for(int i = 0; 0 < compsMaterial.length; i++) {
            	computerSumMaterials[i] += compsMaterial[i];
            }
        }
        return computerSumMaterials;
    }
    
    private int calculateCostMats(int[] computerSumMaterials) {
    	int totalCost = 0; 
        for (Warehouse access : warehouseAccess) {
            int[] materialPrice = access.getMaterial().getMaterialPrice();
            for(int i = 0; i < materialPrice.length; i++) {
            	totalCost += materialPrice[i]*computerSumMaterials[i];
            }
        }
        return totalCost;
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
        for (Computer comps : computers) {
            comps.getNumberOfEmployees();
            time++;
        }
        return time;
    }

}