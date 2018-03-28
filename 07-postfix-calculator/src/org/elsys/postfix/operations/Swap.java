package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Swap extends AbstractOperation implements Operation{
	public Swap(Calculator calculator) {
		super(calculator, "swap");
	}

	@Override
	public void calculate() {
		double a = getCalculator().popValue();
		double b = getCalculator().popValue();
		
		getCalculator().addValue(a);
		getCalculator().addValue(b);
	}
}
