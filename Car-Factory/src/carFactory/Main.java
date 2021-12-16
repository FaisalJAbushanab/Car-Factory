package carFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	
	private ArrayList<Factory> factories = new ArrayList<>();
	private ArrayList<Warehouse> warehouses = new ArrayList<>();
	private ArrayList<Request> requests = new ArrayList<>();
	private String[] location = { "Riyadh", "Makkah", "Dammam", "Jeddah" };
	private int[] workingHours = { 12, 18, 24 };
	private int numberOfSuccess = 0;
	
	// simulation begins here
	public Main(int days, int maxRequestsPerDay) {
		
		generateWarehouses(days, 50);
		generateFactories(days, 30);
		generateRequests(days, maxRequestsPerDay);
		
	}
	// 1A- generate random number of warehouses
	public void generateWarehouses(int days, int numberOfWarehouses) {
		
		Random random = new Random();
//		int numberWarehouse = fullUp(days*10, days*20);
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
			warehouses.add(new Warehouse(storage_Capacity, location[Location], workingHours[WorkingHours], material));
		}
	}
	
	public void generateFactories(int days, int numberOfFactories) {
		Random random = new Random();
		// for establishing a relation between #workers and #computers in each request
		int potential = fullUp(days*0.9, days*1.1);
		// 1B- generate random number of factories
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

	// Generate random requests

	public ArrayList<Factory> getFactories() {
		return factories;
	}

	public ArrayList<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void generateRequests(int days, int maxRequestsPerDay) {
		int numOfRequests = 0;
		int potential = fullUp(days*0.9, days*1.1);
		LocalDateTime simulationDate = LocalDateTime.now();

		// days loop
		for (int i = 1; i <= days; i++) {
			// hours loop
			for (int j = 0; j < 24; j++) {
				// minutes loop
				for (int k = 0; k < 60; k++) {
					if (numOfRequests < maxRequestsPerDay) {
						// probability of getting 1 is 1/500
						int createOrNot = (int) Math.floor(Math.random() * (500) + 1);
						if (createOrNot == 1) {
							Request request = new Request(simulationDate ,i, j, k, fullUp(potential*0.8,potential*1.2));
							requests.add(request);
							// 4- fulfill requests
							numberOfSuccess += request.findFactory(factories);
							numOfRequests++;
						}
					}
				}
			}
			numOfRequests = 0;
		}
//		String conclusion = "\nNumber of successful requests: " + numberOfSuccess + "\n"
//				+ "Number of unsuccessful requests: " + (requests.size() - numberOfSuccess) + "\n";
//		String percent = String.format("Percentage of Success: %.2f%s ",
//				(numberOfSuccess / (double) requests.size()) * 100, "%");
//
//		//generate reports
//		Report report = new Report(simulationDate, requests, factories, warehouses);
//		report.writeRequestsReport();
//		report.writeWarehousesReport();
//		report.writeFactoriesReport();
//		report.writeMainReport((conclusion + percent));
//
//		System.out.println(conclusion);
//		System.out.println(percent);
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
}