package carFactory;

public class Computer {

<<<<<<< HEAD
	public String[] name;
	public int[] constructMaterial;
	public int[] numberOfEmployees;
//	public int productionTime; // in hours


	public Computer(String[] name, int[] constructMaterial, int[] numberOfEmployees) {
		this.name = name;
		this.constructMaterial = constructMaterial;
		this.numberOfEmployees = numberOfEmployees;

//		switch (name[2]) {
//			case "high quality":
//				productionTime = (int) Math.floor(Math.random() * (6 - 5 + 1) + 5);
//				break;
//			case "mid quality":
//				productionTime = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
//				break;
//			case "low quality":
//				productionTime = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
//				break;
//		}
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

=======
      public String[] name;
      public int[] constructMaterial;
      public int[] numberOfEmployees;
      public int productionTime; // in hours
      

      public Computer(String[] name, int[] constructMaterial, int[] numberOfEmployees) {
          this.name = name;
          this.constructMaterial = constructMaterial;
          this.numberOfEmployees = numberOfEmployees;
          switch (name[2]) {
            case "high quality":
              productionTime = (int) Math.floor(Math.random() * (6 - 5 + 1) + 5);
              break;
            case "mid quality":
              productionTime = (int) Math.floor(Math.random() * (4 - 3 + 1) + 3);
              break;
            case "low quality":
              productionTime = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);
              break;    
          }
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
>>>>>>> aba23f4b612a5821993d8a74c70602481a663af3
