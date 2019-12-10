package com.SBS.Model;

import java.util.Map;
import java.util.Set;

public class Society {

	String Name;
	String City;
	// Map<TowerFloorFlat,String> mapOfTowerFloorFlatAsKeysAndUnitsAsValues;
	TowerFloorFlatUnits towerFloorFlatUnits;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	/*public Map<TowerFloorFlat, String> getMapOfTowerFloorFlatAsKeysAndUnitsAsValues() {
		return mapOfTowerFloorFlatAsKeysAndUnitsAsValues;
	}
	public void setMapOfTowerFloorFlatAsKeysAndUnitsAsValues(
			Map<TowerFloorFlat, String> mapOfTowerFloorFlatAsKeysAndUnitsAsValues) {
		this.mapOfTowerFloorFlatAsKeysAndUnitsAsValues = mapOfTowerFloorFlatAsKeysAndUnitsAsValues;
	}
	 */
	public TowerFloorFlatUnits getTowerFloorFlatUnits() {
		return towerFloorFlatUnits;
	}
	public void setTowerFloorFlatUnits(
			TowerFloorFlatUnits towerFloorFlatUnits) {
		this.towerFloorFlatUnits = towerFloorFlatUnits;
	}
}
