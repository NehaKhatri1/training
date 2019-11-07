package com.thb.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class inventory {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String name="food";
		String items="";
		File file = new File("src\\inventory1.txt");
		Scanner sc = new Scanner(file); 

			while (sc.hasNextLine()) {
					
				String line=sc.nextLine(); 
					//	String line="detergents @s1#_#jun#_#Surf Excel Quick Wash Detergent Powder 1 kg$_52_$null *&mumtaaj@$ Surf Excel Matic Top Load Detergent Powder 1 Kg$_52_$null *&mumtaaj@$ Ariel Brilliant detergent$_52_$null";
				System.out.println("line is "+line);
				String[] category=line.split(" @s1#_#jun#_#");
				//System.out.println("category is"+category);
				System.out.println("category[0] is "+category[0]+"##"); 
				//System.out.println("category[1] is "+category[1]); 
				//System.out.println("category[1] is "+category[1]); 
				
				
				if(name.equalsIgnoreCase(category[0])){
				   // if(category[0] LIKE name){	
						//address.phone LIKE
					System.out.println("matched ");
						System.out.println(category[1]);
						items=category[1];
						
				       
					}
					else{
						System.out.println("did not match ");
					}
			
				}
	}

}
