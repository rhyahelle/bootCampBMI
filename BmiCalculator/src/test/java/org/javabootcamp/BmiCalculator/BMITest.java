/**
 * BMITest
 * 
 * Author  : Istvan Ferencsik
 * Created : 2017.11.02
 * 
 * Description : A tryout of the Parameterized test.
 */

package org.javabootcamp.BmiCalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength.cm;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength.in;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass.kg;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass.lb;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength;
import org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BMITest {
	
	@Parameters public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{ 29.73, 174, cm,  90, kg, "Overweight" },
			{ 25.54, 177, cm,  80, kg, "Normal" },
			{ 22.96, 70, in,  160, lb, "Normal" },
		});
	}
	@Parameter(value = 0) public double bmi;
	@Parameter(value = 1) public double heigth;
	@Parameter(value = 2) public UnitsOfMeasurementsOfLength unitOfHeight;
	@Parameter(value = 3) public double mass;
	@Parameter(value = 4) public UnitsOfMeasurementsOfMass unitOfMass;	
	@Parameter(value = 5) public String verboseBmi;	
	
	@Test
	public void testIfConstructorAssignTheCorrectValueForMemberBmi() {
		BMI b = new BMI(bmi, heigth, unitOfHeight, mass, unitOfMass);
		double actual = b.getBmi();
		assertThat(actual, is(bmi));
    }
	
	@Test
	public void testIfReturnedValueOfFunctionBmiToStringIsCorrect() {
		BMI b = new BMI(bmi, heigth, unitOfHeight, mass, unitOfMass); 
		String actual = b.bmiToString(); 
		assertThat(actual, is(verboseBmi)); 
    }	
	
}
