package carFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Factory> factories = new ArrayList<>();
		ArrayList<Warehouse> warehouses = new ArrayList<>();
		ArrayList<Request> requests = new ArrayList<>();
		String[] location = { "Riyadh", "Makkah", "Dammam", "Jeddah" };
		int[] workingHours = { 12, 18, 24 };
		int numberOfSuccess = 0;

		System.out.println("Welcome in the Computer Factory simulation program");
		LocalDateTime simulationDate = LocalDateTime.now();
		// get user input
//		 Scanner input = new Scanner(System.in);
		System.out.println(
				"To begin the simulation please Enter the number of days you want this simulation to run through: ");
		// int days = input.nextInt();
		int days = 10;
		// maximum number of requests per day
		int maxRequestsPerDay = 10;
		Random random = new Random();
		// 1A- generate fixed number of warehouses
		int x = fullUp(200, 500);
		for (int i = 0; i < x; i++) {
			int Location = random.nextInt(location.length);
			int WorkingHours = random.nextInt(workingHours.length);
			// int[] storage_Capacity = (int[]) Math.floor(Math.random() * (100000 - 10000 +
			// 1) + 10000);
			int[] storage_Capacity = new int[9];
			// [alamnuim, plastic, glass, silicon, gold, copper, iron, chrome, silver]
			storage_Capacity[0] = fullUp(5000, 10000);
			storage_Capacity[1] = fullUp(5000, 10000);
			storage_Capacity[2] = fullUp(5000, 10000);
			storage_Capacity[3] = fullUp(5000, 10000);
			storage_Capacity[4] = fullUp(500, 1000);
			storage_Capacity[5] = fullUp(500, 3000);
			storage_Capacity[6] = fullUp(5000, 10000);
			storage_Capacity[7] = fullUp(500, 4000);
			storage_Capacity[8] = fullUp(500, 1000);

			Material material = new Material();
			warehouses.add(new Warehouse(storage_Capacity, location[Location], workingHours[WorkingHours], material));
		}
		// 1B- generate fixed number of factories
		int y = fullUp(50, 125);
		for (int i = 0; i < y; i++) {
			int Location = random.nextInt(location.length);
			int WorkingHours = random.nextInt(workingHours.length);
			// int[] workers_Capacity = (int) Math.floor(Math.random() * (2000 - 500 + 1) +
			// 500);

			int[] workers_Capacity = new int[3];
			// TODO worker capacitys
			workers_Capacity[0] = fullUp(3500, 7000);
			workers_Capacity[1] = fullUp(2000, 4000);
			workers_Capacity[2] = fullUp(1000, 2000);

			Factory factory = new Factory(workers_Capacity, location[Location], workingHours[WorkingHours]);
			factory.setWarehouseAccess(warehouses);
			factories.add(factory);
		}

		int numOfRequests = 0;
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
							Request request = new Request(simulationDate, i, j, k);
							requests.add(request);
							// //4- fulfill requests
							numberOfSuccess += request.findFactory(factories);
							numOfRequests++;
						}
					}
				}
			}
			numOfRequests = 0;
		}
		String conclusion = "\nNumber of successful requests: " + numberOfSuccess + "\n"
				+ "Number of unsuccessful requests: " + (requests.size() - numberOfSuccess) + "\n";
		String percent = String.format("Percentage of Success: %.2f%s ",
				(numberOfSuccess / (double) requests.size()) * 100, "%");

		Report report = new Report(simulationDate, requests, factories, warehouses);
		report.writeRequestsReport();
		report.writeWarehousesReport();
		report.writeFactoriesReport();
		report.writeMainReport((conclusion + percent));

		System.out.println(conclusion);
		System.out.println(percent);
	}

	private static int fullUp(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}

}