package carFactory;

// import the ArrayList class
import java.util.ArrayList;

import java.util.Random;


class Main {

	 public static void main(String[] args) {

		 ArrayList<Factory> factories = new ArrayList<>();
		 ArrayList<Warehouse> wareHouses = new ArrayList<>();
		 ArrayList<Request> requests = new ArrayList<>();
		 int numberOfSuccess;

		 Random random = new Random();

		 String[] location = {"Riyadh ", "Makkah", "Dammam ", "Jeddah"};
		 int[] workingHours = {12, 10, 16, 24};

		 //1A- generate fixed number of warehouses
		 for (int i = 0; i < 1000; i++) {
			 int Location = random.nextInt(location.length);
			 int WorkingHours = random.nextInt(workingHours.length);
			 int storage_Capacity = (int) Math.floor(Math.random() * (100000 - 10000 + 1) + 10000);
			 ;

			 Material M1 = new Material();

			 wareHouses.add(new Warehouse(storage_Capacity, location[Location], workingHours[WorkingHours], M1));
		 }
		 //1B- generate fixed number of factories
		 for (int i = 0; i < 100; i++) {
			 int Location = random.nextInt(location.length);
			 int WorkingHours = random.nextInt(workingHours.length);
			 int workers_Capacity = (int) Math.floor(Math.random() * (2000 - 500 + 1) + 500);


			 Factory factory = new Factory(workers_Capacity, location[Location], workingHours[WorkingHours]);
			 factory.setWarehouseAccess(wareHouses);
			 factories.add(factory);
		 }

		 /*------Loop-------*/

		 while (true) {
			 //3- generate requests
			 Request request = new Request();
			 requests.add(request);


			 //4- fulfill requests
			 request.findFactory(factories);

			 //2-simulate current days counter
		 }

		 ///5- output report

		 ///+toString(): String
	 }
}