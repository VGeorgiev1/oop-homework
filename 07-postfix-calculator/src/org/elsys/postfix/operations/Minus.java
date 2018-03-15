package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Minus extends BinaryOperation implements Operation {

	public Minus(Calculator calculator) {
		super(calculator, "-");
	}
	
	@Override
	protected double doCalculate(double fvalue, double svalue) {
		return svalue - fvalue;
	}

}