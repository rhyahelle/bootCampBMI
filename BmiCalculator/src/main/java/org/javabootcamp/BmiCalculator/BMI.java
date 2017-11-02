/**
 * BMI
 * 
 * Author  : Istvan Ferencsik
 * Created : 2017.11.01
 * 
 * Description : Class representing the Body Mass Index 
 * 
 */


package org.javabootcamp.BmiCalculator;

import java.awt.IllegalComponentStateException;
import java.text.NumberFormat;
import java.util.Locale;

import org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength;
import org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass;


public class BMI {
	
	private double bmi;
	@SuppressWarnings("unused")
	private double height;
	@SuppressWarnings("unused")
	private UnitsOfMeasurementsOfLength unitOfHeight;
	@SuppressWarnings("unused")
	private double mass;
	private UnitsOfMeasurementsOfMass unitOfMass;	
	
	private double getNormalWeightRangeLower() {
		return 0; //TODO
	}
	
	private double getNormalWeightRangeUpper() {
		return 0; //TODO
	}	
	
    public BMI(double bmi, double height, UnitsOfMeasurementsOfLength unitOfHeight,
			               double mass,   UnitsOfMeasurementsOfMass unitOfMass      ) {
		this.bmi = bmi;
		this.height = height;
		this.unitOfHeight = unitOfHeight;
		this.mass = mass;
		this.unitOfMass = unitOfMass;
	}	
	
	public double getBmi() {
		return bmi;
	}
	
	public String bmiValueToString() {
		return String.format("%.2f kg/m2", NumberFormat.getInstance(Locale.getDefault()).format(bmi));
	}

	public String bmiToString() {
		String r = "";
		if (bmi < 16) 
			r = "Severe Thinness";
		else if ((bmi >= 16) && (bmi < 17))
			r = "Moderate Thinness";
		else if ((bmi >= 17) && (bmi < 18.5))
			r = "Mild Thinness";
		else if ((bmi >= 18.5) && (bmi < 25))
			r = "Normal";
		else if ((bmi >= 25) && (bmi < 30))
			r = "Overweight";
		else if ((bmi >= 30) && (bmi < 35))
			r = "Obese Class I";
		else if ((bmi >= 35) && (bmi < 40))
			r = "Obese Class II";
		else if (bmi >= 40)
			r = "Obese Class III";
		
		if (r == "")
			throw new IllegalComponentStateException("Result is an empty string!");
		
		return r;
	}
	
	public String normalRangeToString() {
		return ("Normal BMI range: 18.5kg/m2 - 25 kg/m2");
	}

	public String normalRangeForHeightToString() {  
		return (String.format("Normal BMI weight range for the height: %.1f " + unitOfMass.toString() + " - %.1f " + unitOfMass.toString()  + ".", 
							  unitOfMass.convertBaseUnitToUnit(getNormalWeightRangeLower()), 
							  unitOfMass.convertBaseUnitToUnit(getNormalWeightRangeUpper())
							  )
				);
	}
	
	public double howMuchWeightLossNeededForNormalBmi() {
		return 0; //TODO
	}

	public String howMuchWeightLossNeededForNormalBmiToString() {
		return ""; //TODO
	}

	
}
