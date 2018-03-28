package org.elsys.postfix.operations;

import java.util.ArrayList;
import java.util.List;

import org.elsys.postfix.Calculator;

public class CompositeOperation extends AbstractOperation {

	private List<Object> operations = new ArrayList<Object>();
	
	public CompositeOperation(Calculator calculator, String token) {
		super(calculator, token);
		
	}

	@Override
	public void calculate() {
		for(int i=0;i<operations.size();i++) {
			if(operations.get(i) instanceof Operation) {
				Operation op = (Operation)operations.get(i);
				op.calculate();
			}
			else {
				String numb = (String)operations.get(i);
				
				getCalculator().addValue(Double.valueOf(numb));
			}
		}
		
	}
	
	public void addOperation(Object op) {
		operations.add(op);
	}

}
