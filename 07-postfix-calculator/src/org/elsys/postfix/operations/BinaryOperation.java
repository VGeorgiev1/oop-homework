package org.elsys.postfix.operations;

import java.util.EmptyStackException;

import org.elsys.postfix.Calculator;

public abstract class BinaryOperation extends AbstractOperation {

	public BinaryOperation(Calculator calculator, String token) {
		super(calculator, token);
	}

	@Override
	public void calculate() {
		if(getCalculator().stackSize() <= 1){
			throw new EmptyStackException();
		}
		double fvalue = getCalculator().popValue();
		double svalue = getCalculator().popValue();
		double result = doCalculate(fvalue, svalue);
		getCalculator().addValue(result);		
	}

	protected abstract double doCalculate(double fvalue, double svalue);
}

