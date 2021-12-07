package carFactory;

public enum Computers {


	  //[aluminium grams, plastic grams, glass grams, silicon mg , gold mg , copper mg, iron g, chrome mg, silver mg, Workers, Technicians, Engineers]
	    
		COMPUTER1("asus", "pc" ,"high quality", 500 , 450 , 400  , 500 ,  200 , 400 , 500 ,  600, 300, 70, 30, 20),
		COMPUTER2("asus" ,"pc" , "mid quality", 400 , 350 , 350  , 400 , 100 , 300 , 450 , 500 , 200, 45, 25, 15),
		COMPUTER3("asus", "pc" , "low quality", 300 ,  360 , 350 ,  300,  100,  200,  400,  400,  200, 40, 25, 10),
		COMPUTER4("asus", "laptop" , "high quality" , 300 , 250 , 350 , 200 , 60 , 80 , 400  , 100 , 50, 50, 35, 15),
		COMPUTER5("asus", "laptop" , "mid quality" , 300 ,  300 , 300 , 100 , 50 , 70 , 400 , 60 , 50, 35, 25, 15),
		COMPUTER6("asus", "laptop" , "low quality" , 280 , 300 , 300 , 100 ,  50 ,  70 , 350 ,  60 , 40, 30, 20, 10),

		COMPUTER7("dell", "pc" ,"high quality", 450 , 400 , 400  , 500 ,  200 , 390 , 500 ,  600 , 300, 75, 30, 15),
		COMPUTER8("dell" ,"pc" , "mid quality", 400 , 400 , 350  , 400 , 100 , 300 , 450 , 500 , 200, 45, 25, 15),
		COMPUTER9("dell", "pc" , "low quality", 370 ,  400 , 300 ,  300,  100,  200,  400,  400,  200, 35, 25, 10),
		COMPUTER10("dell", "laptop" , "high quality" , 250 , 250 , 350 , 200 , 60 , 80 , 400  , 100 , 50, 50, 35, 20),
		COMPUTER11("dell", "laptop" , "mid quality" , 200 ,  200 , 300 , 100 , 50 , 70 , 350 , 60 , 50,  35, 20, 10),
		COMPUTER12("dell", "laptop" , "low quality" , 150 , 200 , 250 , 100 ,  50 ,  70 , 300 ,  60 , 40, 30, 20, 10),


		COMPUTER13("acer", "pc" ,"high quality", 450 , 400 , 410  , 500 ,  200 , 420 , 500 ,  600 , 300, 70, 30, 25),
	    COMPUTER14("acer" ,"pc" , "mid quality", 400 , 340 , 385  , 400 , 100 , 300 , 450 , 500 , 200, 45, 30, 15),
	    COMPUTER15("acer", "pc" , "low quality", 300 ,  350 , 350 ,  300,  100,  200,  450,  400,  200, 40, 25, 15),
	    COMPUTER16("acer", "laptop" , "high quality" , 300 , 200 , 350 , 200 , 60 , 80 , 400  , 100 , 50, 40, 25, 15),
		COMPUTER17("acer", "laptop" , "mid quality" , 290 ,  200 , 300 , 100 , 50 , 70 , 350 , 60 , 50, 35, 25, 15),
		COMPUTER18("acer", "laptop" , "low quality" , 270 , 280 , 250 , 100 ,  50 ,  70 , 300 ,  60 , 40, 30,20,15),
		
		COMPUTER19("hp", "pc" ,"high quality", 500 , 350 , 400  , 500 ,  200 , 430 , 500 ,  600 , 300, 60, 30, 25),
		COMPUTER20("hp" ,"pc" , "mid quality", 470 , 350 , 300  , 400 , 100 , 300 , 400 , 500 , 200, 45, 20, 10),
		COMPUTER21("hp", "pc" , "low quality", 350 ,  380 , 300 ,  300,  100,  200,  400,  400,  200, 35, 20, 10),
		COMPUTER22("hp", "laptop" , "high quality" , 300 , 200 , 300 , 200 , 60 , 80 , 400  , 100 , 50, 40, 25, 15),
		COMPUTER23("hp", "laptop" , "mid quality" , 250 ,  200 , 250 , 100 , 50 , 70 , 400 , 60 , 50, 35, 25, 15),
		COMPUTER24("hp", "laptop" , "low quality" , 200 , 250 , 250 , 100 ,  50 ,  70 , 400 ,  60 , 40, 30, 20, 10);
		
		private final String company;
		private final String type;
		private final String quality;
		private final int mass1;
		private final int mass2 ;
		private final int mass3;
		private final int mass4;
		private final int mass5;
		private final int mass6;
		private final int mass7;
		private final int mass8;
		private final int mass9;
		private final int Workers;
		private final int Technicians;
		private final int  Engineers;
		
		Computers(String company, String type, String quality,
				  int mass1, int mass2, int mass3, int mass4,
				  int mass5, int mass6, int mass7, int mass8, int mass9, int Workers, int Technicians, int  Engineers){
			this.company = company;
			this.type = type;
			this.quality = quality;
			this.mass1 = mass1;
			this.mass2 = mass2;
			this.mass3 = mass3;
			this.mass4 = mass4;
			this.mass5 = mass5;
			this.mass6 = mass6;
			this.mass7 = mass7;
			this.mass8 = mass8;
			this.mass9 = mass9;
			this.Workers=Workers;
			this.Technicians =Technicians;
			this.Engineers = Engineers;
		}
		public String  getCompany() {
			return company;
		}
		public String getType() {
			return type;
		}
		public String getQuality() {
			return quality;
		}
		public int getMass1() {
			return mass1;
		}
		public int getMass2() {
			return mass2;
		}
		public int getMass3() {
			return mass3;
		}
		public int getMass4() {
			return mass4;
		}
		public int getMass5() {
			return mass5;
		}
		public int getMass6() {
			return mass6;
		}
		public int getMass7() {
			return mass7;
		}
		public int getMass8() {
			return mass8;
		}
		public int getMass9() {
			return mass9;
		}
		public int getWorkers() {
			return Workers;
		}
		public int getTechnicians() {
			return Technicians;
		}
		public int getEngineers() {
			return Engineers;
		}
}

		
		
		
	
	
	
	
	
	

	
	
