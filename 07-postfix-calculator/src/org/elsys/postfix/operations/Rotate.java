package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Rotate extends AbstractOperation implements Operation{
	public Rotate(Calculator calculator) {
		super(calculator, "rot3");
	}

	@Override
	public void calculate() {
		double a = getCalculator().popValue();
		double b = getCalculator().popValue();
		double c = getCalculator().popValue();
		getCalculator().addValue(a);
		getCalculator().addValue(c);
		getCalculator().addValue(b);
	}
}
