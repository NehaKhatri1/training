package com.thb.db;

import java.io.BufferedReader;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 
import java.util.Set;


public class inventoryList {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */

		
		// Java Program to illustrate reading from Text File 
		// using Scanner Class 
		 
		public static void main(String[] args) throws FileNotFoundException 
		{ 
			// pass the path to the file as a parameter 
		/*	File file = 
			new File("C:\\Users\\Neha\\Desktop\\inventory1.txt");
			Scanner sc = new Scanner(file); 

			while (sc.hasNextLine()) {
				
			String[] category=sc.nextLine().split("#");
			System.out.println(category[0]); 
		}  */
		//	try{
			
			String name="FOOD";
			  Map<String, String> map = new HashMap<String, String>();
		        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Neha\\Desktop\\inventory1.txt"));
		        String line = "";
		        try {
					while ((line = in.readLine()) != null) {
					    String parts[] = line.split("#");
					    map.put(parts[0], parts[1]);
					    
					  
				        
					}
					System.out.println(map.toString());
				
			        System.out.println(map.keySet());
			        
			        Set<String> keys=map.keySet();
			        int no=keys.size();
			      
			        for(int i=1;i<=no;i++){
			        	if(keys.contains(name)){
				    		System.out.println("you r in ");
				    		String val = (String)map.get(i);
				    		System.out.println(val);
				    	}
				    	else 
				    	{
				    		System.out.println("key not found");
				    	}
			        	
			        }
			    	if(keys.contains(name)){
			    		System.out.println("you r in ");
			    		
			    		System.out.println();
			    	}
			    	else 
			    	{
			    		System.out.println("key not found");
			    	}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		//    }
			
		//catch{}
			
		}

}


