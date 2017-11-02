/**
 * UnitsOfMeasurementsOfLength
 * 
 * Author  : Istvan Ferencsik
 * Created : 2017.11.01
 * 
 * Description : Units of length and their relations. When adding a new unit, expand the createToBaseUnitMap and the createToStringMap functions. 
 * 				 Add to the ToBaseUnitMap the new unit's relation to the BaseUnit (m). 1 Unit = ? m. 
 * 				 Add to the ToStringMap the new unit's full name.
 */

package org.javabootcamp.UnitsOfMeasurment;

import java.util.HashMap;
import java.util.Map;

public enum UnitsOfMeasurementsOfLength implements UnitsOfMeasurement {
	//SI	
	km, m, cm, mm,
	
	//Imperial
	ml, yd, ft, in
	
	//Expand as needed
	;
	
	public static  UnitsOfMeasurementsOfLength getBaseUnit() {
		return UnitsOfMeasurementsOfLength.m;
	}

	private static final Map<UnitsOfMeasurementsOfLength, Double> ToBaseUnitMap = createToBaseUnitMap();
	
	private static final Map<UnitsOfMeasurementsOfLength, String> ToStringMap = createToStringMap();
	
	private static  Map<UnitsOfMeasurementsOfLength, Double>  createToBaseUnitMap() {
		Map<UnitsOfMeasurementsOfLength, Double> initToBaseUnitMap = new HashMap<UnitsOfMeasurementsOfLength, Double>();
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.km,  (double) (1000));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.m,   (double) (1));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.cm,  (double) (0.01));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.mm,  (double) (0.001));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.ml,  (double) (1609.344));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.yd,  (double) (0.9144));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.ft,  (double) (0.3048));
		initToBaseUnitMap.put(UnitsOfMeasurementsOfLength.in,  (double) (0.0254));		
		
		return initToBaseUnitMap;
	};	
	
	private static Map<UnitsOfMeasurementsOfLength, String>  createToStringMap() {
		Map<UnitsOfMeasurementsOfLength, String> initToString = new HashMap<UnitsOfMeasurementsOfLength, String>();
		initToString.put(UnitsOfMeasurementsOfLength.km,  "Kilometer");
		initToString.put(UnitsOfMeasurementsOfLength.m,   "Meter");
		initToString.put(UnitsOfMeasurementsOfLength.cm,  "Centimeter");
		initToString.put(UnitsOfMeasurementsOfLength.mm,  "Milimeter");
		initToString.put(UnitsOfMeasurementsOfLength.ml,  "Mile");
		initToString.put(UnitsOfMeasurementsOfLength.yd,  "Yard");
		initToString.put(UnitsOfMeasurementsOfLength.ft,  "Foot");
		initToString.put(UnitsOfMeasurementsOfLength.in,  "Inch");		
		
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
