/**
 * BmiCalculator
 * 
 * Author  : Istvan Ferencsik
 * Created : 2017.11.01
 * 
 * Description : 
 */

package org.javabootcamp.BmiCalculator;

import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength.m;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass.kg;

import java.text.NumberFormat;
import java.util.Locale;

import org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength;
import org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass;

public class BmiCalculator {
	
	public BMI calcBMI(double height, UnitsOfMeasurementsOfLength unitOfHeight, 
					   double mass,   UnitsOfMeasurementsOfMass   unitOfMass) {
		double convertedHeight = 0;
		double convertedMass = 0;
		
		if (unitOfHeight != m)
			convertedHeight =  unitOfHeight.convertUnitToBaseUnit(height);	
		else
			convertedHeight = height;
			
		if (unitOfMass != kg)
			convertedMass =  unitOfMass.convertUnitToBaseUnit(mass);	
		else
			convertedMass = mass;
		
		if (convertedHeight <= 0) {
			throw new IllegalArgumentException("Height parameter must be greater then 0!");
		}
		else if (convertedMass <= 0) {
			throw new IllegalArgumentException("Mass parameter must be greater then 0!");
		}
		if (convertedHeight > 4) {
			throw new IllegalArgumentException(String.format("Height parameter must be under %.2f " + unitOfHeight.toString(), 
											   NumberFormat.getInstance(Locale.getDefault()).format(unitOfHeight.convertBaseUnitToUnit(4))));
		}
		else if (convertedMass > 1000) {
			throw new IllegalArgumentException(String.format("Mass parameter must be under %.2f "   + unitOfMass.toString(), 
											   NumberFormat.getInstance(Locale.getDefault()).format(unitOfMass.convertBaseUnitToUnit(1000))));
		}		
						
		return new BMI (calcBMIFromMetricData(convertedHeight, convertedMass), height, unitOfHeight, mass, unitOfMass);
		
	}
	
	private double calcBMIFromMetricData(double height, double mass) {		
		return (mass / Math.pow(height, 2));
	}
}
