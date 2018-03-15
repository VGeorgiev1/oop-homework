package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Cosine extends UnaryOperation implements Operation {

	public Cosine(Calculator calculator) {
		super(calculator, "cos");
	}
	
	@Override
	protected double doCalculate(double value) {
		return Math.cos(value);
	}

}