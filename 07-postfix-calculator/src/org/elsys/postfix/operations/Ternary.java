package org.elsys.postfix.operations;

import java.util.EmptyStackException;

import org.elsys.postfix.Calculator;

public class Ternary extends AbstractOperation implements Operation {

	public Ternary(Calculator calculator) {
		super(calculator, "\\*-\\*");
	}
	
	@Override
	public void calculate() {
		if(getCalculator().stackSize() <= 2){
			throw new EmptyStackException();
		}
		double val1 = getCalculator().popValue();
		double val2 = getCalculator().popValue();
		double val3 = getCalculator().popValue();
		getCalculator().addValue(-(val1*val2*val3));
	}

}