package carFactory;

import java.util.ArrayList;

public class Factory extends Building {

    private ArrayList<Warehouse> warehouseAccess = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
<<<<<<< HEAD
    private int[] employeesList = new int[3];
    private int operatingCost;
    private boolean isOccupied = false;

    public Factory(int[] workerCapacity, String location, int workingHours) {
        super(workerCapacity, location, workingHours);
=======

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
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3

        setWarehouseAccess(warehouseAccess);
        setEmployees();
        setEmployeesList();
        setOperatingCost();
    }

<<<<<<< HEAD
    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied() {
        isOccupied = true;
    }
    public void setUnOccupied() {
        isOccupied = false;
    }

    private void setOperatingCost() {
        for (Employee employee : employees) {
            operatingCost += employee.getSalary();
        }
    }

    private void setEmployeesList() {
        for (Employee employee : employees) {
            if (employee instanceof Worker) {
                employeesList[0] += 1;
            } else if (employee instanceof Technician) {
                employeesList[1] += 1;
            } else {
                employeesList[2] += 1;;
            }
        }
=======
    public int calculateSuitabilty(Request request, int time) {
    	int calculatedCost = 0;
        if(checkMaterial(request.computers)) {
        	calculatedCost = calculateCostMats(getComputerTotalMaterial(request.computers));
        }else{
        	calculatedCost = 0;
        }

>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3
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

<<<<<<< HEAD
    private void setEmployees() {
        int numOfEmployees = (int)Math.floor(Math.random()*(9000-100+1)+4000);
        for(int i=0; i < numOfEmployees; i++) {
            int rand = (int)Math.floor(Math.random()*(12)+1);
            if(5 >= rand) {
                Employee employee = new Worker();
                employees.add(employee);
            }else if(9 <= rand) {
                Employee employee = new Technician();
                employees.add(employee);
            }else {
                Employee employee = new Engineer();
                employees.add(employee);
            }
=======
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
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3
        }
    }

    public void setWarehouseAccess(ArrayList<Warehouse> warehouses) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getLocation().equals(super.getLocation())) {
                warehouseAccess.add(warehouse);
            }
        }
    }

<<<<<<< HEAD
    public int[] getRequirments(Request request) {
        int calculatedCost = -1;
        int calculatedTime = -1;
        if(checkMaterial(request.getComputers()) & checkTime(request.getComputers())) {
            calculatedCost = calculateCostMats(getComputerTotalMaterial(request.getComputers())) + operatingCost;
            calculatedTime = calculateTime(request.getComputers());
        }
        System.out.printf("Factory of request#(%s/%s:%s)\ncost is: %d\ntime is: %d\n",
                request.getDay(), request.getHour(), request.getMinute(),
                calculatedCost, calculatedTime );
        return new int[] {calculatedCost, calculatedTime};
    }

    private int[] getWarehouseTotalMaterial() {
        int[] wareHouseAccessTotalMaterials = new int[9];
        for (Warehouse access : warehouseAccess) {
            int[] warehouseMaterial = access.getMaterialQuantity();
            for (int i = 0; i < wareHouseAccessTotalMaterials.length; i++) {
                wareHouseAccessTotalMaterials[i] += warehouseMaterial[i];
            }
        }
        return wareHouseAccessTotalMaterials;
    }

    public int[] getComputerTotalMaterial(ArrayList<Computer> computers) {
        int[] computerSumMaterials = new int[9];
        for (Computer comps : computers) {
            int[] compsMaterial = comps.getConstructMaterial();
            for (int i = 0; i < compsMaterial.length; i++) {
                computerSumMaterials[i] += compsMaterial[i];
            }
        }
        return computerSumMaterials;
    }

    public int calculateCostMats(int[] computerSumMaterials) {
        int matsCost = 0;
        for (Warehouse access : warehouseAccess) {
            double[] materialPrice = access.getMaterial().getMaterialPrice();
            for (int i = 0; i < materialPrice.length; i++) {
                matsCost += materialPrice[i] * computerSumMaterials[i];
            }
        }
        return matsCost;
    }

    private boolean checkMaterial(ArrayList<Computer> computers) {
        boolean materialSufficient = true;
        for (int i = 0; i < getWarehouseTotalMaterial().length; i++) {
            if (getComputerTotalMaterial(computers)[i] > getWarehouseTotalMaterial()[i]) {
                materialSufficient = false;
                break;
            }
        }
        System.out.println("material sufficient: " + materialSufficient);
        return materialSufficient;
    }

    private boolean checkTime(ArrayList<Computer> computers) {
        int[] computerSumEmployee = new int[3];
        for (Computer comps : computers) {
            computerSumEmployee[0] += comps.getNumberOfEmployees()[0];
            computerSumEmployee[1] += comps.getNumberOfEmployees()[1];
            computerSumEmployee[2] += comps.getNumberOfEmployees()[2];
        }

//        System.out.println(computerSumEmployee[0] + " and " + super.buildingCapacity[0]);
//        System.out.println(computerSumEmployee[1] + " and " + super.buildingCapacity[1]);
//        System.out.println(computerSumEmployee[2] + " and " + super.buildingCapacity[2]);
        boolean timeSufficient = !((computerSumEmployee[0] > super.buildingCapacity[0])
                                || (computerSumEmployee[1] > super.buildingCapacity[1])
                                || (computerSumEmployee[2] > super.buildingCapacity[2]));

        System.out.println("time sufficient: " + timeSufficient);
        return timeSufficient;
    }

    private int calculateTime(ArrayList<Computer> computers) {
        System.out.println("in calc time");
        int time = computers.size();
        int repeated = 0;
        int[] computerSumEmployee = new int[3];
        for (Computer comps : computers) {
            computerSumEmployee[0] += comps.getNumberOfEmployees()[0];
            computerSumEmployee[1] += comps.getNumberOfEmployees()[1];
            computerSumEmployee[2] += comps.getNumberOfEmployees()[2];
        }
//        System.out.println(computerSumEmployee[0]);
//        System.out.println(computerSumEmployee[1]);
//        System.out.println(computerSumEmployee[2]);
//        System.out.println(employeesList[0]);
//        System.out.println(employeesList[1]);
//        System.out.println(employeesList[2]);
        while ((((employeesList[0] - computerSumEmployee[0]) >= 0) &
                ((employeesList[1] - computerSumEmployee[1]) >= 0) &
                ((employeesList[2] - computerSumEmployee[2]) >= 0))) {

            repeated++;
            employeesList[0] -= computerSumEmployee[0];
//            System.out.println(employeesList[0]);
            employeesList[1] -= computerSumEmployee[1];
//            System.out.println(employeesList[1]);
            employeesList[2] -= computerSumEmployee[2];
//            System.out.println(employeesList[2]);
        }
        System.out.println("repeated:" + repeated);
        if(repeated != 0) {
            return time/repeated;
        } else {
            return time;
        }
    }
}

=======
    private int calculateTime(int[] computerSumEmployee) {
        int time = 0;
        for (Computer comps : computers) {
            comps.getNumberOfEmployees();
            time++;
        }
        return time;
    }

}
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3
