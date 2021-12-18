package phase1;
/**
 *
 * This class shows some computer specifications such as name, construct  materials and working hours.
 *
 */
public class Computer {

	public String[] name;
	public int[] constructMaterial;
	public int[] numberOfEmployees;
	/**
	 *
	 * @param name
	 * @param constructMaterial
	 * @param numberOfEmployees
	 */

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
}

