/**
 * BmiCalculator
 * 
 * Author  : Istvan Ferencsik
 * Created : 2017.11.01
 * 
 * Description : Common interface for the handling of the different measurement systems
 */
package org.javabootcamp.UnitsOfMeasurment;

public interface UnitsOfMeasurement {

	String toString();

	double convertUnitToBaseUnit(double mass);

	double convertBaseUnitToUnit(double mass);

}