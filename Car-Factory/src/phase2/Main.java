package phase2;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 *  class show runs the program according to the existing factors.
 *
 */
public class Main {
	private ArrayList<Factory> factories = new ArrayList<>();

	private ArrayList<Warehouse> warehouses = new ArrayList<>();
	private ArrayList<Request> requests = new ArrayList<>();
	private Report report;
	private String[] location = { "Riyadh", "Makkah", "Dammam", "Jeddah" };
	private int[] workingHours = { 12, 18, 24 };
	private int numberOfSuccess = 0;
	private LocalDateTime simulationDate = LocalDateTime.now();

	/**
	 * The constructier inserts into the program the
	 * max value of requests for each day and the number of days needed.
	 * @param days
	 * @param maxRequestsPerDay
	 * @throws CloneNotSupportedException
	 * @throws IOException
	 */


	public Main(int days, int maxRequestsPerDay) throws IOException, CloneNotSupportedException {
		// simulation begins here
		// 1- Generate random number of warehouses
		generateWarehouses(days, 50);
		// 2- Generate random number of factories
		generateFactories(days, 50);
		// 3- Generate random number of requests
		generateRequests(days, maxRequestsPerDay);
		// 4- Generate Report
		generateReport(simulationDate);
	}

	/**
	 *  simulation begins here
	 * @param simulationDate
	 * @throws IOException
	 * @throws CloneNotSupportedException
	 * @throws IOException
	 */

	private void generateReport(LocalDateTime simulationDate) throws IOException, CloneNotSupportedException {
		Report report = new Report(simulationDate, requests, factories, warehouses);
		this.report = report;
		report.generateReport();
	}

	/**
	 *  generate number of warehouses and  random material
	 * @param days
	 * @param numberOfWarehouses
	 */
	public void generateWarehouses(int days, int numberOfWarehouses) {

		Random random = new Random();
		for (int i = 0; i < numberOfWarehouses; i++) {

			int Location = random.nextInt(location.length);
			int WorkingHours = random.nextInt(workingHours.length);

			int[] storage_Capacity = new int[9];
			// [aluminium, plastic, glass, silicon, gold, copper, iron, chrome, silver]
			storage_Capacity[0] = fullUp(5000, 10000);
			storage_Capacity[1] = fullUp(5000, 10000);
			storage_Capacity[2] = fullUp(5000, 10000);
			storage_Capacity[3] = fullUp(5000, 10000);
			storage_Capacity[4] = fullUp(500, 1000);
			storage_Capacity[5] = fullUp(500, 3000);
			storage_Capacity[6] = fullUp(5000, 10000);
			storage_Capacity[7] = fullUp(500, 4000);
			storage_Capacity[8] = fullUp(500, 1000);
			// create material object
			Material material = new Material();
			Warehouse warehouse = new Warehouse(storage_Capacity, location[Location], workingHours[WorkingHours], material);
			warehouses.add(warehouse);
		}
	}

	public Report getReport() {
		return report;
	}

	/**
	 * method generates number of factories
	 * @param days
	 * @param numberOfFactories
	 */

	public void generateFactories(int days, int numberOfFactories) {
		Random random = new Random();
		// for establishing a relation between #workers and #computers in each request
		int potential = fullUp(days*0.9, days*1.1);
//		int numberFactory = fullUp(days*4, days*8);
		for (int i = 0; i < numberOfFactories; i++) {

			int Location = random.nextInt(location.length);
			int WorkingHours = random.nextInt(workingHours.length);

			int[] workers_Capacity = new int[3];
			// [workers, technician, engineer]
			workers_Capacity[0] = fullUp(potential*30, potential*60);
			workers_Capacity[1] = fullUp(potential*20, potential*40);
			workers_Capacity[2] = fullUp(potential*10, potential*20);

			Factory factory = new Factory(workers_Capacity, location[Location], workingHours[WorkingHours]);
			factory.setWarehouseAccess(warehouses);
			factories.add(factory);
		}
	}


	public ArrayList<Factory> getFactories() {
		return factories;
	}

	public ArrayList<Warehouse> getWarehouses() {
		return warehouses;
	}

	/**
	 * method generates random number of requests
	 * @param days
	 * @param maxRequestsPerDay
	 */

	public void generateRequests(int days, int maxRequestsPerDay) {
		int numOfRequests = 0;
		int potential = fullUp(days*0.9, days*1.1);

		// days loop
		for (int i = 0; i <= days; i++) {
			// hours loop
			for (int j = 0; j < 24; j++) {
				// minutes loop
				for (int k = 0; k < 60; k++) {
					if (numOfRequests < maxRequestsPerDay) {
						// probability of getting 1 is 1/500
						int createOrNot = (int) Math.floor(Math.random() * (500) + 1);
						if (createOrNot == 1) {
							Request request = new Request(simulationDate , factories,
									i, j, k, fullUp(potential*0.8,potential*1.2));
							requests.add(request);
							// 4.1- fulfill requests
							numberOfSuccess += request.findFactory(factories);
							numOfRequests++;
						}
					}
				}
			}
			numOfRequests = 0;
			for(Request request : requests) {
				if (request.getTakenFactory() != null
					|| !request.isComplete()) {
					unoccupyFinishedFactories(request, i);
				}
				else {
					if (!request.isComplete()) {
						splitRequest(request);
					}
				}
			}
		}
	}

	/**
	 * method splits a request in half
	 * @param OGrequest
	 */
	private void splitRequest(Request OGrequest) {
		numberOfSuccess += OGrequest.split(factories);
	}

	private static int fullUp(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

	public static int fullUp(double min, double max) {
		double random = new Random().nextDouble();
		return (int)(min + (random * (max - min)));
	}
	public ArrayList<Request> getRequests() {
		return requests;
	}

	public void unoccupyFinishedFactories(Request request, int currentDay) {
		Factory factory = request.getTakenFactory();
		int passedDays = currentDay - Integer.parseInt(request.getDay());
		String factoryTime = request.getTakenFactoryProvidedTime();
		if(passedDays >= Integer.parseInt(factoryTime)) {
			factory.deductMaterials(request);
			factory.setUnOccupied();
			request.setComplete();
		}
	}
}