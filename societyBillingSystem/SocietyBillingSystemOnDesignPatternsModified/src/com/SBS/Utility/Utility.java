package com.SBS.Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.SBS.Model.Society;


public class Utility {

	static List<String> listOfLines= new ArrayList<String>();
	public static List<String> getListOfInputLinesFromInputFile(String Path) throws IOException{
		
		//open the file ,read & return the list of lines 
		
		// This method reads the content of input file & load it into a list. 
	/*	input 
	 * Gurgaon,CHD,T3,F1,101,200
Gurgaon,CHD,T3,F1,102,500
Gurgaon,CHD,T3,F1,103,630
Gurgaon,CHD,T3,F3,301,800
Gurgaon,CHD,T3,F3,302,800                          ------------------->>>>>>>   into [Gurgaon,CHD,T3,F1,101,200, Gurgaon,CHD,T3,F1,102,500, Gurgaon,CHD,T3,F1,103,630, Gurgaon,CHD,T3,F3,301,800, Gurgaon,CHD,T3,F3,302,800, Gurgaon,CHD,T3,F3,303,100, Gurgaon,CHD,T4,F3,201,400, Gurgaon,CHD,T4,F3,202,820, Gurgaon,CHD,T4,F3,303,780]
Gurgaon,CHD,T3,F3,303,100
Gurgaon,CHD,T4,F3,201,400
Gurgaon,CHD,T4,F3,202,820
Gurgaon,CHD,T4,F3,303,780
		
		*/
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Path));

			String line;
			while((line=bufferedReader.readLine())!=null){
				listOfLines.add(line);
			//System.out.println(line);
//			
			}
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e.printStackTrace();
		}
		return listOfLines;
		
	}
	
	
	public static List<Society> setValueOfInstanceVariablesIntoObjectsReadFromInputFile(List<String> listOFLines) throws IOException{
		
		
		/*  List is an ordered collection of objects in which duplicate values can be stored. This method takes the list of lines(i.e. collection of objects) . 
		 * Every line of input file is considered as object & its splitter based values correspond to instance variables of that object so this method allows each element & its instance variable to be referenced via reference var of objects . 
		list ----> [Gurgaon,CHD,T3,F1,101,200, Gurgaon,CHD,T3,F1,102,500, Gurgaon,CHD,T3,F1,103,630, Gurgaon,CHD,T3,F3,301,800, Gurgaon,CHD,T3,F3,302,800, Gurgaon,CHD,T3,F3,303,100, Gurgaon,CHD,T4,F3,201,400, Gurgaon,CHD,T4,F3,202,820, Gurgaon,CHD,T4,F3,303,780]

          Gurgaon,CHD,T3,F1,101,200 can be accessed via obj1.getName(); obj1.getflatNo(); etc...
        mapping of instance variable  ---------->>> society.settName());
        											society.setTowerNO(Towerno);
													society.setFloorNo(floorno);
													society.setFlatNo(flatno);
		
		*/
	System.out.println("listOfLines in utility  "+listOfLines.size());
	 	List<Society> listOfSocietyObjects=new ArrayList();
	 	
	 	
	for (int i = 0; i < listOFLines.size(); i++) {
		Society society=new Society();
		String listOfStrings=listOFLines.get(i);
		String[] splitedListOfString=listOfStrings.split(",");
		String City= splitedListOfString[0];
		//System.out.println("City is "+City);
		String societyName=splitedListOfString[1];
		String Towerno=splitedListOfString[2];
		String floorno=splitedListOfString[3];
		String flatno=splitedListOfString[4];
		String units=splitedListOfString[5];
		
		society.setCity(City);
		society.setName(societyName);
		
		System.out.println("hh "+society.getCity());
		System.out.println(society.getName());
		
		//TowerFloorFlatUnits towerFloorFlatUnits=new TowerFloorFlatUnits();
		
		society.setTowerNO(Towerno);
		society.setFloorNo(floorno);
		society.setFlatNo(flatno);
		society.setUnits(units);
		//society.setTowerFloorFlatUnits(towerFloorFlatUnits);
		//System.out.println("get tower.. "+society.getTowerFloorFlatUnits().getFlatNo());
		System.out.println("We have set data into models/pojos ");
		
	listOfSocietyObjects.add(society);
	}
		return listOfSocietyObjects;
	}
	
	
	
	
	
	
}
