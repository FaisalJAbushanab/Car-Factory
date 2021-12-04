package carFactory;

public enum Computers {

    //[aluminium grams, plastic grams, glass grams, silicon mg , gold mg , copper mg, iron g, chrome mg, silver mg]
    
	COMPUTER1("asus", "pc" ,"high quality", 800 , 3 , 1  , 500 ,  200 , 400 , 800 ,  600 , 300),
	COMPUTER2("asus" ,"pc" , "mid quality", 700 , 2 , 1  , 400 , 100 , 300 , 750 , 500 , 200),
	COMPUTER3("asus", "pc" , "low quality", 650 ,  2 , 900 ,  300,  100,  200,  700,  400,  200),
	COMPUTER4("asus", "laptop" , "high quality" , 500 , 1 , 1 , 200 , 6 , 8 , 460  , 100 , 5),
	COMPUTER5("asus", "laptop" , "mid quality" , 450 ,  1 , 750 , 100 , 5 , 7 , 450 , 6 , 5),
	COMPUTER6("asus", "laptop" , "low quality" , 400 , 800 , 700 , 100 ,  5 ,  7 , 400 ,  6 , 4),

	COMPUTER7("dell", "pc" ,"high quality", 800 , 3 , 1  , 500 ,  200 , 400 , 800 ,  600 , 300),
	COMPUTER8("dell" ,"pc" , "mid quality", 700 , 2 , 1  , 400 , 100 , 300 , 750 , 500 , 200),
	COMPUTER9("dell", "pc" , "low quality", 650 ,  2 , 900 ,  300,  100,  200,  700,  400,  200),
	COMPUTER10("dell", "laptop" , "high quality" , 500 , 1 , 1 , 200 , 6 , 8 , 460  , 100 , 5),
	COMPUTER11("dell", "laptop" , "mid quality" , 450 ,  1 , 750 , 100 , 5 , 7 , 450 , 6 , 5),
	COMPUTER12("dell", "laptop" , "low quality" , 400 , 800 , 700 , 100 ,  5 ,  7 , 400 ,  6 , 4),


	COMPUTER13("acer", "pc" ,"high quality", 800 , 3 , 1  , 500 ,  200 , 400 , 800 ,  600 , 300),
    COMPUTER14("acer" ,"pc" , "mid quality", 700 , 2 , 1  , 400 , 100 , 300 , 750 , 500 , 200),
    COMPUTER15("acer", "pc" , "low quality", 650 ,  2 , 900 ,  300,  100,  200,  700,  400,  200),
    COMPUTER16("acer", "laptop" , "high quality" , 500 , 1 , 1 , 200 , 6 , 8 , 460  , 100 , 5),
	COMPUTER17("acer", "laptop" , "mid quality" , 450 ,  1 , 750 , 100 , 5 , 7 , 450 , 6 , 5),
	COMPUTER18("acer", "laptop" , "low quality" , 400 , 800 , 700 , 100 ,  5 ,  7 , 400 ,  6 , 4),
	
	COMPUTER19("hp", "pc" ,"high quality", 800 , 3 , 1  , 500 ,  200 , 400 , 800 ,  600 , 300),
	COMPUTER20("hp" ,"pc" , "mid quality", 700 , 2 , 1  , 400 , 100 , 300 , 750 , 500 , 200),
	COMPUTER21("hp", "pc" , "low quality", 650 ,  2 , 900 ,  300,  100,  200,  700,  400,  200),
	COMPUTER22("hp", "laptop" , "high quality" , 500 , 1 , 1 , 200 , 6 , 8 , 460  , 100 , 5),
	COMPUTER23("hp", "laptop" , "mid quality" , 450 ,  1 , 750 , 100 , 5 , 7 , 450 , 6 , 5),
	COMPUTER24("hp", "laptop" , "low quality" , 400 , 800 , 700 , 100 ,  5 ,  7 , 400 ,  6 , 4);
	
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
	
	Computers(String company, String type, String quality, int mass1, int mass2, int mass3, int mass4, int mass5, int mass6, int mass7, int mass8, int mass9){
		this.company=company;
		this.type=type;
		this.quality=quality;
		this.mass1=mass1;
		this.mass2=mass2;
		this.mass3=mass3;
		this.mass4=mass4;
		this.mass5=mass5;
		this.mass6=mass6;
		this.mass7=mass7;
		this.mass8=mass8;
		this.mass9=mass9;
		

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
	
}
	
	
	
	
	
	
	
	

	
	
