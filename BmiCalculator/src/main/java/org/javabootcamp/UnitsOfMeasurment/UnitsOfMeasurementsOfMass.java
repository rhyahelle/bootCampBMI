/**
 * UnitsOfMeasurementsOfMass
 * 
 * Author  : Istvan Ferencsik
 * Created : 2017.11.01
 * 
 * Description : Units of mass and their relations. When adding a new unit, expand the createToBaseUnitMap and the createToStringMap functions. 
 * 				 Add to the ToBaseUnitMap the new unit's relation to the BaseUnit (kg). 1 Unit = ? kg. 
 * 				 Add to the ToStringMap the new unit's full name.
 */

package org.javabootcamp.UnitsOfMeasurment;
import java.util.HashMap;
import java.util.Map;


public enum UnitsOfMeasurementsOfMass implements UnitsOfMeasurement {
	//SI	
	t, kg, dkg, g,
	
	//Imperial
	st, lb, oz
	
	//Expand as needed
	;

	public static UnitsOfMeasurementsOfMass getBaseUnit() {
		return  UnitsOfMeasurementsOfMass.kg;
	}

	private static final Map<UnitsOfMeasurementsOfMass, Double> ToBaseUnitMap = createToBaseUnitMap();			
	
	private static final Map<UnitsOfMeasurementsOfMass, String> ToStringMap = createToStringMap();
	
	private static  Map<UnitsOfMeasurementsOfMass, Double>  createToBaseUnitMap() {
		Map<UnitsOfMeasurementsOfMass, Double> initToBaseUnitMap = new HashMap<UnitsOfMeasurementsOfMass, Double>();
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.t,   (double) (1000));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.kg,  (double) (1));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.dkg, (double) (0.01));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.g,   (double) (0.001));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.st,  (double) (6.350));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.lb,  (double) (0.45359));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfMass.oz,  (double) (0.028349523125));
		
		return initToBaseUnitMap;
	};	
	
	private static  Map<UnitsOfMeasurementsOfMass, String>  createToStringMap() {
		Map<UnitsOfMeasurementsOfMass, String> initToString = new HashMap<UnitsOfMeasurementsOfMass, String>();
		initToString.put(UnitsOfMeasurementsOfMass.t,   "Metric ton");
		initToString.put(UnitsOfMeasurementsOfMass.kg,  "Kilogramm");
		initToString.put(UnitsOfMeasurementsOfMass.dkg, "Dekagramm");
		initToString.put(UnitsOfMeasurementsOfMass.g,   "Gramm");
		initToString.put(UnitsOfMeasurementsOfMass.st,  "Stone");
		initToString.put(UnitsOfMeasurementsOfMass.lb,  "Pound");
		initToString.put(UnitsOfMeasurementsOfMass.oz,  "Ounce");
		
		return initToString;
	};
	
	public String toString() {
		return ToStringMap.get(this);
		}
		
	public double convertUnitToBaseUnit (double mass) {
		return mass * ToBaseUnitMap.get(this);
	}
	
	public double convertBaseUnitToUnit (double mass) {
		return mass * (1/ToBaseUnitMap.get(this));
	}
}		
		
