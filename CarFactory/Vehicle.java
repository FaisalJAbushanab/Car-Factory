package CarFactory;

public class Vehicle {
    public String[] info;
    public int[] constructMaterial;
    public int constructHours;
    public int[] numberOfEmployees;
    public int vehicleCapacity;

    public Vehicle(String[] info, int[] constructMaterial, int constructHours, int[] numberOfEmployees, int vehicleCapacity) {
        this.info = info;
        this.constructMaterial = constructMaterial;
        this.constructHours = constructHours;
        this.numberOfEmployees = numberOfEmployees;
        this.vehicleCapacity = vehicleCapacity;
    }

    public String[] getInfo() {
        return info;
    }

    public int[] getConstructMaterial() {
        return constructMaterial;
    }

    public int getConstructHours() {
        return constructHours;
    }

    public int[] getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public int calculateCost() {
        return 0;
    }
}
