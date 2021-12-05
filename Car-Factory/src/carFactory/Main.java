package carFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Main {
	 public static void main(String[] args) {
		 ArrayList<Factory> factories = new ArrayList<>();
		 ArrayList<Warehouse> wareHouses = new ArrayList<>();
		 ArrayList<Request> requests = new ArrayList<>();
         String[] location = {"Riyadh", "Makkah", "Dammam", "Jeddah"};
         int[] workingHours = {12, 10, 16, 24};
         int numberOfSuccess = 0;

         System.out.println("Welcome in the Computer Factory simulation program");
		 // get user input
		 Scanner input = new Scanner(System.in);
		 System.out.println("To begin the simulation please Enter the number of days you want this simulation to run through: ");
		 //int days = input.nextInt();
		 int days = 10;
		 // maximum number of requests per day
		 int maxRequestsPerDay = 10;
		 Random random = new Random();
		 //1A- generate fixed number of warehouses
		 for (int i = 0; i < 300; i++) {
			 int Location = random.nextInt(location.length);
			 int WorkingHours = random.nextInt(workingHours.length);
	//			 int[] storage_Capacity = (int[]) Math.floor(Math.random() * (100000 - 10000 + 1) + 10000);
			 int[] storage_Capacity = new int[9];
			 //[alamnuim, plastic, glass, silicon, gold, copper, iron, chrome, silver]
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
			 wareHouses.add(new Warehouse(storage_Capacity, location[Location], workingHours[WorkingHours], material));
		 }
		 //1B- generate fixed number of factories
		 for (int i = 0; i < 30; i++) {
			 int Location = random.nextInt(location.length);
			 int WorkingHours = random.nextInt(workingHours.length);
	//			 int[] workers_Capacity = (int) Math.floor(Math.random() * (2000 - 500 + 1) + 500);

			 int[] workers_Capacity = new int[3];
			 workers_Capacity[0] = fullUp(1000, 2000);
			 workers_Capacity[1] = fullUp(900, 1700);
			 workers_Capacity[2] = fullUp(500, 1100);

			 Factory factory = new Factory(workers_Capacity, location[Location], workingHours[WorkingHours]);
			 factory.setWarehouseAccess(wareHouses);
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
							 Request request = new Request(i, j, k);
							 requests.add(request);
	//							 //4- fulfill requests
							 numberOfSuccess += request.findFactory(factories);
							 numOfRequests++;
						 }
					 }
				 }
			 }
			 numOfRequests = 0;
		 }
		 System.out.println("Number of successful: " + numberOfSuccess);
		 System.out.println("Number of unsuccessful: " + (requests.size() - numberOfSuccess));

		 Report report = new Report(requests);
		 report.generateReport();
	 }

	 private static int fullUp(int min ,int max) {
         return (int) Math.floor(Math.random() * (max - min + 1) + min);
	 }
}