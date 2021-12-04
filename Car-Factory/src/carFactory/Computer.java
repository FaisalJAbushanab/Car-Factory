package carFactory;

public class Computer {

	    public String[] name;
	    public int[] constructMaterial;
	    public int[] numberOfEmployees;
	    

	    public Computer(String[] name, int[] constructMaterial, int[] numberOfEmployees) {
	        this.name = name;
	        this.constructMaterial = constructMaterial;
	        this.numberOfEmployees = numberOfEmployees;
	    }

	    public String[] getName() {
	        return name;
	    }

	    public int[] getConstructMaterial() {
	        return constructMaterial;
	    }


	    public int[] getNumberOfEmployees() {
	        return numberOfEmployees;
	    }

	    public int calculateCost() {
	        return 0;
	    }
	}

