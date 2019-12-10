package com.SBS.Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.SBS.Model.Society;
import com.SBS.Model.TowerFloorFlatUnits;

public class Utility {

	static List<String> listOfLines= new ArrayList<String>();
	public static List<String> getListOfInputLinesFromInputFile(String Path) throws IOException{
		
		//open the file ,read & return the list of lines 
		
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
		
		TowerFloorFlatUnits towerFloorFlatUnits=new TowerFloorFlatUnits();
		
		towerFloorFlatUnits.setTowerNO(Towerno);
		towerFloorFlatUnits.setFloorNo(floorno);
		towerFloorFlatUnits.setFlatNo(flatno);
	    towerFloorFlatUnits.setUnits(units);
		society.setTowerFloorFlatUnits(towerFloorFlatUnits);
		//System.out.println("get tower.. "+society.getTowerFloorFlatUnits().getFlatNo());
		System.out.println("We have set data into models/pojos ");
		
	listOfSocietyObjects.add(society);
	}
		return listOfSocietyObjects;
	}
	
	
	
	
	
	
}
