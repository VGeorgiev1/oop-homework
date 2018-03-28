package org.elsys.postfix;

import org.junit.Test;

public class SwapTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("11");
		input("swap");
		inputCtrlC();
		runCalculator();
		inputCtrlC();
		assertCalculatorLastValue(10);
		assertCalculatorStackSize(2);
	}

}
