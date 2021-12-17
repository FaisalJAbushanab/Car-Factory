package phase2;

import java.util.ArrayList;
import java.util.Arrays;

public class Factory extends Building implements Cloneable{

    private ArrayList<Warehouse> allWarehouses = new ArrayList<>();
    private ArrayList<Warehouse> warehouseAccess = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    private int[] employeesList = new int[3];
    private int[] warehouseAccessTotalMaterials = new int[9];
    private int operatingCost;
    private boolean isOccupied = false;
    private int numOfoccupies;

    public Factory(int[] workerCapacity, String location, int workingHours) {
        super(workerCapacity, location, workingHours);

        generateEmployees(); // Generate Employees
        setOperatingCost();  // calculate operation cost
    }

    public void fullUpEmployees() {
//        for(int i= 0; i < numOfEmployees; i++) {
//            int rand = (int)Math.floor(Math.random()*(6)+1);
//            if((3 >= rand) && (worker < super.getCapacity()[0])) {
//                Employee employee = new Worker();
//                employees.add(employee); // add new worker to the list
//                worker++;
//            }else if((5 >= rand) && (technician < super.getCapacity()[1])) {
//                Employee employee = new Technician();
//                employees.add(employee); // add new technician to the list
//                technician++;
//            }else if((5 < rand) && (engineer < super.getCapacity()[2])){
//                Employee employee = new Engineer();
//                employees.add(employee);  // add new engineer to the list
//                engineer++;
//            }
//            else {
//                continue;
//            }
//        }
//        setEmployeesList();
    }

    public boolean isOccupied() {
        return isOccupied; // return the status of the factory
    }

    public void setOccupied() {
        isOccupied = true; // occupy the factory
    }

    public void setUnOccupied() {
        isOccupied = false; // unoccupy the factory
    }

    private void setOperatingCost() {
        // TODO salary on location
        for (Employee employee : employees) {
//            System.out.println(employee.toString());
            operatingCost += employee.getSalary(); // add employees' salaries to the operation cost
        }
//        System.out.println(operatingCost); // print the operating cost
    }

    private void setEmployeesList() {
//        employeesList[0] =  0;
//        employeesList[1] =  0;
//        employeesList[2] =  0;
        for (Employee employee : employees) {
            if (employee instanceof Worker) {
                employeesList[0] += 1; // increase index 0 means increasing in worker numbers
            } else if (employee instanceof Technician) {
                employeesList[1] += 1; // increase index 1 means increasing in Technician numbers
            } else {
                employeesList[2] += 1; // increase index 2 means increasing in Engineers numbers
            }
        }
    }

     private void generateEmployees() {
        int max = super.getCapacity()[0] + super.getCapacity()[1] + super.getCapacity()[2]; // get employees capacity of the factory
        int min = max/2;
        int numOfEmployees = (int)Math.floor(Math.random()*((max)-min+1)+min); // generate random number of employees
        int worker = 0;
        int technician = 0;
        int engineer = 0;
        for(int i= 0; i < numOfEmployees; i++) {
            int rand = (int)Math.floor(Math.random()*(6)+1);
            if((3 >= rand) && (worker < super.getCapacity()[0])) {
                Employee employee = new Worker();
                employees.add(employee); // add new worker to the list
                worker++;
            }else if((5 >= rand) && (technician < super.getCapacity()[1])) {
                Employee employee = new Technician();
                employees.add(employee); // add new technician to the list
                technician++;
            }else if((5 < rand) && (engineer < super.getCapacity()[2])){
                Employee employee = new Engineer();
                employees.add(employee);  // add new engineer to the list
                engineer++;
            }
            else {
                continue;
            }
        }
        setEmployeesList(); // add all the employees to employeesList
    }

    public void setWarehouseAccess(ArrayList<Warehouse> warehouses) {
        allWarehouses = warehouses;
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getLocation().equals(super.getLocation())) {
                warehouseAccess.add(warehouse); // if the location of the warehouse is the same as the location of the factory make the warehouse accesable by factory
            }
        }
        setWarehouseTotalMaterial(); // set the total material of the factory
    }

    public int[] getRequirments(Request request, int index) {
        int calculatedCost = -1;
        int calculatedTime = -1;
        System.out.printf("Factory#" + index + " of request#(%s/%s:%s)\n",
                request.getDay(), request.getHour(), request.getMinute());
        if(checkMaterial(request.getComputers()) & checkTime(request.getComputers())) {
            calculatedCost = calculateCostMats(getComputersTotalMaterial(request.getComputers())) + operatingCost;
            calculatedTime = calculateTime(request.getComputers());
            System.out.printf("cost is: %d\ntime is: %d\n", calculatedCost, calculatedTime );
        }
        return new int[] {calculatedCost, calculatedTime};
    }

    private void setWarehouseTotalMaterial() {
        for (Warehouse access : warehouseAccess) {
            int[] warehouseMaterial = access.getMaterialQuantity();
            for (int i = 0; i < warehouseAccessTotalMaterials.length; i++) {
                warehouseAccessTotalMaterials[i] += warehouseMaterial[i];
            }
        }
    }

    public int[] getWarehouseTotalMaterials() {
        return warehouseAccessTotalMaterials;
    }

    public int[] getComputersTotalMaterial(ArrayList<Computer> computers) {
        int[] computerSumMaterials = new int[9];
        for (Computer comps : computers) {
            int[] compsMaterial = comps.getConstructMaterial();
            for (int i = 0; i < compsMaterial.length; i++) {
                computerSumMaterials[i] += compsMaterial[i];
            }
        }
        return computerSumMaterials;
    }

    public void deductMaterials(Request request) {
        int[] computerSumMaterials = new int[9];
        computerSumMaterials = getComputersTotalMaterial(request.getComputers());
        for (int i = 0; i < computerSumMaterials.length; i++) {
            warehouseAccessTotalMaterials[i] -= computerSumMaterials[i];
        }
    }

    public int calculateCostMats(int[] computerSumMaterials) {
        double matsCost = 1000000000;
        double tempCost = 0;
        for (Warehouse access : warehouseAccess) {
            double[] materialPrice = access.getMaterial().getMaterialPrice(); // get material price of the warehouse
            for (int i = 0; i < materialPrice.length; i++) {
                tempCost += materialPrice[i] * computerSumMaterials[i];
            }

            if (tempCost < matsCost) {
                matsCost = tempCost;
            }
            tempCost = 0;
        }
        return (int) matsCost;
    }

    public boolean checkMaterial(ArrayList<Computer> computers) {
        boolean materialSufficient = true;
        for (int i = 0; i < getWarehouseTotalMaterials().length; i++) {
            if (getComputersTotalMaterial(computers)[i] > getWarehouseTotalMaterials()[i]) { // compare the material required by the request and compare it to the material available by the factory
                materialSufficient = false; 
                break;
            }
        }
        System.out.println("material sufficient: " + materialSufficient);
        return materialSufficient;
    }

    public boolean checkTime(ArrayList<Computer> computers) {
        boolean timeSufficient = true;
        int[] computerSumEmployee = new int[3];
        for (Computer comps : computers) {
            for (int i = 0; i < computerSumEmployee.length; i++) {
                computerSumEmployee[i] += comps.getNumberOfEmployees()[i];
            }
        }
        for (int i = 0; i < computerSumEmployee.length; i++) {
            if ((computerSumEmployee[i] > super.getCapacity()[i])) {
                timeSufficient = false;
                break;
            }
        }
        System.out.println("time sufficient: " + timeSufficient);
        return timeSufficient;
    }
    
    private int calculateTime(ArrayList<Computer> computers) { // calculated required time by the factory
        int worker = 0;
        int technnician = 0;
        int engineer = 0;
//        System.out.println("in calc time");
        double time = 0;
        double repeated = 0;
        boolean breakedOut = false;
        while((worker < employeesList[0]) &&
                (technnician < employeesList[0]) &&
                (engineer < employeesList[0])) {
            for (Computer computer: computers) {
                worker += computer.getNumberOfEmployees()[0];
                technnician += computer.getNumberOfEmployees()[1];
                engineer += computer.getNumberOfEmployees()[2];
                if((worker < employeesList[0]) &&
                    (technnician < employeesList[0]) &&
                    (engineer < employeesList[0])) {
                    time += 1/(repeated+1);
                } else {
                    breakedOut = true;
                    break;
                }
            }
            repeated++;
            if (!breakedOut) {
                time -= computers.size()/(repeated+1);
            }
        }
        return (int) time;
    }

    public int getOperatingCost() {
        return operatingCost; // return the total operating cost
    }

    public String getFactoryInformation() { // get all factory's information
        String info = "Location: " + super.getLocation() +
                " | Working hours: " + super.getWorkingHours() +
                " | Operating cost: " + getOperatingCost() +"\n";
        info += "Employees capacity: " + + super.getCapacity()[0] + " workers "
                + super.getCapacity()[1] + " technicians "
                + super.getCapacity()[2] + " engineers \n";
        info += "Employees: " + employeesList[0] + " workers "
                + employeesList[1] + " technicians "
                + employeesList[2] + " engineers \n";
        info += "Access to warehouses: ";
        for (Warehouse access: warehouseAccess) { 
            info += "#" + (allWarehouses.indexOf(access)+1) + " "; // get all the warehouses that the factory has access to
        }
        info += "\nMaterials: [aluminium grams, plastic grams, glass grams, silicon mg " +
                ", gold mg, copper mg, iron grams, chrome mg, silver mg]\n" +
                "Amount: " + Arrays.toString(getWarehouseTotalMaterials()) + "\n";
        info += "number of times this factory has been occupied: " + getNumOfoccupies() + "\n";
        return info + "\n";
    }

	public int getNumOfoccupies() {
		return numOfoccupies;
	}

	public void setNumOfoccupies(int numOfoccupies) {
		this.numOfoccupies = numOfoccupies;
	}
}

