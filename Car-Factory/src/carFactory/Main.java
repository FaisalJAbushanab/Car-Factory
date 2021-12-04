package carFactory;

// import the ArrayList class
import java.util.ArrayList;

import java.util.Random;
import java.util.Scanner;


class Main {

	 public static void main(String[] args) {

		 ArrayList<Factory> factories = new ArrayList<>();
		 ArrayList<Warehouse> wareHouses = new ArrayList<>();
		 ArrayList<Request> requests = new ArrayList<>();
		 int numberOfSuccess;

		 System.out.println("Welcome in the Computer Factory simulation program");

		 // get user input
		 Scanner input = new Scanner(System.in);
		 System.out.println("To begin the simulation please Enter the number of days you want this simulation to run through: ");
		 int days = input.nextInt();

		 // maximum number of requests per day
		 int maxRequestsPerDay = 10;

		 Random random = new Random();

		 String[] location = {"Riyadh", "Makkah", "Dammam", "Jeddah"};
		 int[] workingHours = {12, 10, 16, 24};

		 //1A- generate fixed number of warehouses
		 for (int i = 0; i < 1000; i++) {
			 int Location = random.nextInt(location.length);
			 int WorkingHours = random.nextInt(workingHours.length);
//			 int[] storage_Capacity = (int[]) Math.floor(Math.random() * (100000 - 10000 + 1) + 10000);
			 int[] storage_Capacity = new int[9];
			 storage_Capacity = fullUpSto();

			 Material M1 = new Material();

			 wareHouses.add(new Warehouse(storage_Capacity, location[Location], workingHours[WorkingHours], M1));
		 }
		 //1B- generate fixed number of factories
		 for (int i = 0; i < 100; i++) {
			 int Location = random.nextInt(location.length);
			 int WorkingHours = random.nextInt(workingHours.length);
//			 int[] workers_Capacity = (int) Math.floor(Math.random() * (2000 - 500 + 1) + 500);
			 int[] workers_Capacity = new int[3];
			 workers_Capacity = fullUpWork();

			 Factory factory = new Factory(workers_Capacity, location[Location], workingHours[WorkingHours]);
			 factory.setWarehouseAccess(wareHouses);
			 factories.add(factory);
		 }

		 /*------Loop-------*/

//		 while (true) {
//			 //3- generate requests
//			 Request request = new Request();
//			 requests.add(request);
//
//			 //4- fulfill requests
//			 request.findFactory(factories);
//
//			 //2-simulate current days counter
//		 }

		 ///5- output report

		 ///+toString(): String

		 for (int i = 1; i <= days; i++) {

			 int numOfRequests = 0;
			 // hours loop
			 for (int j = 0; j < 24; j++) {

				 // mintus loop
				 for (int k = 0; k < 60; k++) {
					 if (numOfRequests < maxRequestsPerDay) {
						 // probability of getting 1 is 1/500
					 	int createOrNot = (int) Math.floor(Math.random() * (500 - 1 + 1) + 1);
						 if (createOrNot == 1) {
							 Request request = new Request(i, j, k);
							 requests.add(request);

//							 //4- fulfill requests
							 request.findFactory(factories);
							 numOfRequests++;
						 }
					 }
				 }
			 }
			 numOfRequests = 0;
		 }
	 }
	private static int[] fullUpWork() {
	 	return null;
	}

	private static int[] fullUpSto() {
	 	return null;
	}
}