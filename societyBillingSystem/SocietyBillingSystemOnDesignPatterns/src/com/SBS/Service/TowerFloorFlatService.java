package com.SBS.Service;

import java.io.FileNotFoundException;

import com.SBS.Impl.TowerFloorFlatImpl;
import com.SBS.interfrace.TowerFloorFlatInterfrace;

public class TowerFloorFlatService {

	
	public static void main(String[] args){
		TowerFloorFlatInterfrace towerFloorFlatInterfrace =new TowerFloorFlatImpl();
		
		 
			try {
				towerFloorFlatInterfrace.getBillByTowerNo("T3");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}
	
	
	
}
