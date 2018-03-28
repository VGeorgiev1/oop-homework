package org.elsys.postfix;

import java.util.EmptyStackException;

import org.junit.Test;

public class TernaryTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("5");
		input("1");
		input("\\*-\\*");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(-50);
	}
	@Test(expected = EmptyStackException.class)
	public void testWithNoEnoughValues() {
		input("10");
		input("5");
		input("\\*-\\*");
		inputCtrlC();
		runCalculator();
		
	}

}
