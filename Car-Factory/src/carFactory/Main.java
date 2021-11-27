package carFactory;



	// import the ArrayList class
	import java.util.ArrayList;

	import java.util.Random;


	 class Main {
		 
		 
		public   ArrayList<Factory> factories; 
		public   ArrayList<Warehouse> wareHouses ; 
		public ArrayList<Request> requests; 
	    public int numberOfSuccess;

	    
	   public static  void main (String [] args ) 
	   {


	       Random random = new Random();


		   String  [] location = { "Riyadh " ,"Makkah" ,"Dammam ","Jeddah"};
		   int  [] workingHours = {12 ,10 ,16,24};
	       int storageCapacity;
	      int  workersCapacity ;




	     //1A- generate fixed number of warehouses

		   ArrayList<Warehouse> wareHouses =  new ArrayList<>();

		   for (int i = 0; i<1000; i++)

		   {
			   int Location  = random.nextInt( location.length);
			   int WorkingHours  = random.nextInt(workingHours.length);
			   int storage_Capacity  =  (int)Math.floor(Math.random()*(100000-10000+1)+10000);       ;


			  materialQuantity M1 =  new materialQuantity ();

				wareHouses.add(i, new WareHouse( location[Location] , workingHours[WorkingHours] , M1 , storageCapacity =storage_Capacity ));

	 	 }


		   	//1B- generate fixed number of factories

		   ArrayList<Factory> factories=  new ArrayList<String>();

		   for (int i = 0; i<100; i++)

		   {

			   int Location  = random.nextInt( location.length);
			   int WorkingHours  = random.nextInt(workingHours.length);
			   int workers_Capacity  =  (int)Math.floor(Math.random()*(2000-500+1)+500);       ;



			  �factories.add(i, new factories( location[Location] , workingHours[WorkingHours] , wareHouses , workersCapacity=workers_Capacity  ));

	 	 }




	  	/*------Loop-------*/

			public ArrayList<Request> requests = new ArrayList<> ;

		   while (true)
		   {
			   //3- generate requests

			   ����requests.add(i, new requests(selectedComputers,selectedCost,selectedTime);


			   //4- fulfill requests
			   requests.findFactory(ArrayList<Factory>);

		    	//2-simulate current days counter

		   }


	    	///5- output report

	    	///+toString(): String
	   }
	   
	   
	}