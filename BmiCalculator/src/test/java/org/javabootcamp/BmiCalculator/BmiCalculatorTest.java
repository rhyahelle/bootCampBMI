package org.javabootcamp.BmiCalculator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength.in;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfLength.m;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass.kg;
import static org.javabootcamp.UnitsOfMeasurment.UnitsOfMeasurementsOfMass.lb;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

public class BmiCalculatorTest {

	private BmiCalculator calculator;
	@Before
	public void setUp() throws Exception {
	calculator = new BmiCalculator();
	}
	
	@Test
	//Happy path
	public void testIfBothArgumentsAreOneResultIsOne() {
		BMI result = calculator.calcBMI(1, m, 1, kg);
		assertThat((double)(1.0) ,  equalTo(result.getBmi()));
	}
	@Test
	public void testForPreCalculetedResult1() {
		BMI result = calculator.calcBMI(2, m, 100, kg);
		assertThat((double)(25.0) ,  equalTo(result.getBmi()));
	}	
	@Test
	public void testForPreCalculetedResult2() {
		BMI result = calculator.calcBMI(70, in, 160, lb);
		assertThat((double)(22.96) ,  equalTo(new BigDecimal(result.getBmi()).setScale(2, RoundingMode.HALF_UP).doubleValue()));
	}
	
	//Unhappy path
	@Test (expected = IllegalArgumentException.class)
	public void testIfZeroHeightThrowsIllegalArgumentException() {
		@SuppressWarnings("unused")
		BMI result = calculator.calcBMI(0, in, 160, lb);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfNegativeHeightThrowsIllegalArgumentException() {
		@SuppressWarnings("unused")
		BMI result = calculator.calcBMI(-70, in, 160, lb);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testIfZeroMassThrowsIllegalArgumentException() {
		@SuppressWarnings("unused")
		BMI result = calculator.calcBMI(70, in, 0, lb);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfNegativeMassThrowsIllegalArgumentException() {
		@SuppressWarnings("unused")
		BMI result = calculator.calcBMI(70, in, -160, lb);
	}		

	@Test (expected = IllegalArgumentException.class)
	public void testIfHeightOver4mThrowsIllegalArgumentException() {
		@SuppressWarnings("unused")
		BMI result = calculator.calcBMI(5, m, 160, lb);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testIfMassOver1000KgThrowsIllegalArgumentException() {
		@SuppressWarnings("unused")
		BMI result = calculator.calcBMI(70, in, 1200, kg);
	}
	
	
}
