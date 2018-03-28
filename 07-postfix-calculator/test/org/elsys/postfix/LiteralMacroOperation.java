package org.elsys.postfix;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiteralMacroOperation extends CalculatorAbstractTest{
	@Test
	public void test() {
		input("\\add1");
		input("1");
		input("+");
		input("def");
		input("2");
		input("add1");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(3.0);
	}
	
	
}
