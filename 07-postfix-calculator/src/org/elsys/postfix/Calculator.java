package org.elsys.postfix;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.elsys.postfix.operations.CompositeOperation;
import org.elsys.postfix.operations.Cosine;
import org.elsys.postfix.operations.Divide;
import org.elsys.postfix.operations.Duplicate;
import org.elsys.postfix.operations.Minus;
import org.elsys.postfix.operations.Multiplication;
import org.elsys.postfix.operations.Negate;
import org.elsys.postfix.operations.Operation;
import org.elsys.postfix.operations.Sinus;
import org.elsys.postfix.operations.Swap;
import org.elsys.postfix.operations.Ternary;
import org.elsys.postfix.operations.Rotate;



import org.elsys.postfix.operations.Plus;

public class Calculator {

	private Map<String, Operation> operations = new HashMap<>();

	private List<Double> stack = new LinkedList<>();

	private InputStream in;

	private PrintStream out;
	
	public Calculator(InputStream in, PrintStream out) {
		this.in = in;
		this.out = out;
		addOperation(new Negate(this));
		addOperation(new Duplicate(this));
		addOperation(new Cosine(this));
		addOperation(new Sinus(this));
		addOperation(new Plus(this));
		addOperation(new Minus(this));
		addOperation(new Divide(this));
		addOperation(new Multiplication(this));
		addOperation(new Swap(this));
		addOperation(new Rotate(this));
		addOperation(new Ternary(this));
	}

	public void run() {
		String input;
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNext()) {
				out.print(stack.size() + ": ");
				input = scanner.next();
				if (isDouble(input)) {
					stack.add(Double.valueOf(input));
				} else {
					if(input.startsWith("\\") && !input.equals("\\*-\\*")){
						CompositeOperation cop = new CompositeOperation(this, input.substring(1));
						
						while(true) {
							String nextLine = scanner.next();
							
							if(nextLine.equals("def")) {
								addOperation(cop);
								break;
							}
							String[] tokens = nextLine.split("\\s+");
							for(int i=0;i<tokens.length;i++) {
								Operation op = getOperation(tokens[i]);
								if(op!=null) {
									cop.addOperation(op);
								}else {
									cop.addOperation(tokens[i]);
								}
								
							}
						
						}
					}else {
						Operation operation = getOperation(input);
						if (operation != null) {
							operation.calculate();
						} else {
							throw new UnsupportedOperationException();
						}
					}
				}
			}
		}
	}

	private static boolean isDouble(String input) {
		try {
			Double.valueOf(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public void addOperation(Operation operation) {
		operations.put(operation.getToken(), operation);
	}

	public Operation getOperation(String token) {
		return operations.get(token);
	}

	public Double popValue() {
		int lastIndex = stack.size() - 1;
		Double value = stack.get(lastIndex);
		stack.remove(lastIndex);
		return value;
	}

	public Double lastValue() {
		return stack.get(stack.size() - 1);
	}

	public void addValue(double value) {
		out.println(value);
		stack.add(value);
	}

	public int stackSize() {
		return stack.size();
	}
}
