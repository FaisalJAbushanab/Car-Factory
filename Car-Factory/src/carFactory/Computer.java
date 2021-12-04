
public class Computer {

	    public String[] name;
	    public int[] constructMaterial;
	    public int constructHours;
	    public int[] numberOfEmployees;
	    

	    public Computer(String[] name, int[] constructMaterial, int constructHours, int[] numberOfEmployees) {
	        this.name = name;
	        this.constructMaterial = constructMaterial;
	        this.constructHours = constructHours;
	        this.numberOfEmployees = numberOfEmployees;
	    }

	    public String[] getName() {
	        return name;
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

	    public int calculateCost() {
	        return 0;
	    }
	}

