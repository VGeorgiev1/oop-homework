package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Duplicate extends AbstractOperation implements Operation {

	public Duplicate(Calculator calculator) {
		super(calculator, "dup");
	}
	
	@Override
	public void calculate() {
		getCalculator().addValue(getCalculator().lastValue());
	}

}