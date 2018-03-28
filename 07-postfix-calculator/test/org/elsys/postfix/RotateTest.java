package org.elsys.postfix;

import org.junit.Test;

public class RotateTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("11");
		input("12");
		input("rot3");
		input("rot3");
		inputCtrlC();
		runCalculator();
		inputCtrlC();
		assertCalculatorLastValue(10);
		assertCalculatorStackSize(3);
	}

}
