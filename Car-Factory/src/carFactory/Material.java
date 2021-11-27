package carFactory;

// using java.util.Random;

import java.util.Random;

public class Material {
	
	
     //[alamnuim, plastic, glass, silicon, gold, copper, iron, chrome, silver]--9
	
	private int[] materialQuantity = new int [9]; 
	private int[] materialPrice =  new int [9]; 

	
	
	public Material()
	{
		
		
		 // create instance of Random class
           Random rand = new Random();
          
  /*
         
           for (int i = 0; i < materialQuantity.length; i++)
              {
        	   materialQuantity[i] = rand.nextInt(1000000 ); 
              }
           
           
           
           { */
           
           
           {
           //Generate random materialQuantity value for [alamnuim]
              int min = 500000;
              int max = 100000;
                
              materialQuantity[0] = (int)Math.floor(Math.random()*(max-min+1)+min);
             
   	       }
           
           {
               //Generate random materialQuantity value for [plastic]
                  int min = 500000;
                  int max = 100000;
                    
                  materialQuantity[1] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	    }
           
           {
               //Generate random materialQuantity value for [ glass]
                  int min = 500000;
                  int max = 100000;
                    
                  materialQuantity[2] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           
           {
               //Generate random materialQuantity value for [ silicon]
        	      int min = 500000;
                  int max = 100000;
                    
                  materialQuantity[3] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           
           {
               //Generate random materialQuantity value for [ gold]
                  int min = 100000;
                  int max = 500000;
                    
                  materialQuantity[4] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           {
               //Generate random materialQuantity value for [ copper-]
                  int min = 700000;
                  int max = 100000;
                    
                  materialQuantity[5] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           {
               //Generate random materialQuantity value for [ iron]
                  int min = 500000;
                  int max = 100000;
                    
                  materialQuantity[6] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           {
               //Generate random materialQuantity value for [ chrom ]
                  int min = 200000;
                  int max = 600000;
                    
                  materialQuantity[7] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           {
               //Generate random materialQuantity value for [ silver]
                  int min = 200000;
                  int max = 600000;
                    
                  materialQuantity[8] = (int)Math.floor(Math.random()*(max-min+1)+min);
       	       }
           
           
           
        	  ////////////////////////////////////////////////////  
        	   
	      {
        //Generate random materialPrice value for [alamnuim]

           int min = 250;
           int max = 300;
             
           materialPrice[0] = (int)Math.floor(Math.random()*(max-min+1)+min);
	       }
         
	     {
		//Generate random materialPrice value for [ plastic]
           int min =100;
           int max = 150;
             
           materialPrice[1] = (int)Math.floor(Math.random()*(max-min+1)+min);
	     }
	     
	     
	    {
	         //Generate random materialPrice value for [ glass]

           int min = 300;
           int max = 400;
             
           materialPrice[2] = (int)Math.floor(Math.random()*(max-min+1)+min);
	    }
	    
	    
	   {
	         //Generate random materialPrice value for [ silicon]

           int min = 200;
           int max = 250;
             
           materialPrice[3] = (int)Math.floor(Math.random()*(max-min+1)+min);
	  }
	   
	   
	  {
         //Generate random materialPrice value for  gold]

           int min = 800;
           int max = 1000;
             
           materialPrice[4] = (int)Math.floor(Math.random()*(max-min+1)+min);
      }
	
	
	 {
        //Generate random materialPrice value for [ copper]

          int min = 250;
          int max = 300;
            
          materialPrice[5] = (int)Math.floor(Math.random()*(max-min+1)+min);
     }
	 
	
	{
        //Generate random materialPrice value for [ iron]

          int min = 200;
          int max = 250;
            
          materialPrice[6] = (int)Math.floor(Math.random()*(max-min+1)+min);
          }
	
	    {
        //Generate random materialPrice value for [ chrome]

          int min = 200;
          int max = 250;
            
          materialPrice[7] = (int)Math.floor(Math.random()*(max-min+1)+min);
          
          }
	    
	
	    {
        //Generate random materialPrice value for[silver] 

          int min = 200;
          int max = 250;
            
          materialPrice[8] = (int)Math.floor(Math.random()*(max-min+1)+min);
          }
	
            
           
}

	
	public int[] getMaterialQuantity() 
	{
		return materialQuantity;
		
	} 
	
	public void setMaterialQuantity( int[] materialQuantity) 
	{
		this.materialQuantity=materialQuantity;
		
	} 
	
    public int[] getMaterialPrice() {
		
    	return materialPrice ;
	} 
    
  public void settMaterialPrice( int[] settMaterialPrice) 
	{
		this.materialQuantity=settMaterialPrice;
		
	} 
  
  

}		
