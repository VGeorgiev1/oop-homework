package org.elsys.gates;

public abstract class GateFactory {

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate xorGate = new CompositeGate(name);

		xorGate.addInput(in1);
		xorGate.addInput(in2);
		xorGate.addOutput(out);

		Wire a = new Wire("xorA");
		Wire b = new Wire("xorB");
		Wire c = new Wire("xorC");

		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate1 = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate2 = new AndGate(a, c, out);

		xorGate.addGate(orGate);
		xorGate.addGate(andGate1);
		xorGate.addGate(notGate);
		xorGate.addGate(andGate2);

		return xorGate;
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "XorGate");
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c, String name) {
		CompositeGate cg = new CompositeGate(name);
		Gate xor = makeXorGate(a,b,s);
		Gate and = new AndGate(a,b,c);
		cg.addInput(a);
		cg.addInput(b);
		cg.addOutput(s);
		cg.addOutput(c);
		cg.addGate(xor);
		cg.addGate(and);
		return cg;
	}

	public static Gate makeHalfAdder(Wire a, Wire b, Wire s, Wire c) {
		return makeHalfAdder(a, b, s, c, "HalfAdder");
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut, String name) {
		CompositeGate cg = new CompositeGate(name);
		Wire common = new Wire("common");
		Wire hf1ToOr = new Wire("hfout2");
		Wire hf2ToOr = new Wire("hf1out1");
		cg.addGate(makeHalfAdder(a,b,common,hf1ToOr));
		cg.addGate(makeHalfAdder(cIn,common,sum,hf2ToOr));
		cg.addGate(new OrGate(hf2ToOr, hf1ToOr, cOut));
		cg.addInput(a);
		cg.addInput(b);
		cg.addInput(cIn);
		cg.addOutput(sum);
		cg.addOutput(cOut);
		return cg;
	}

	public static Gate makeFullAdder(Wire a, Wire b, Wire cIn, Wire sum, Wire cOut) {
		return makeFullAdder(a, b, cIn, sum, cOut, "FullAdder");
	}
	
	public static Gate makeRippleCarryAdder(Wire a[], Wire b[], Wire cIn, Wire sum[], Wire cOut) {
		assert a.length == b.length;
		assert a.length == sum.length;
		int count = a.length;
		CompositeGate cg = new CompositeGate("SUPERCOOLRIPPLEGATE");
		for(int i = 0; i < count; i++)
		{
			
		}
		return null;
	}
}
