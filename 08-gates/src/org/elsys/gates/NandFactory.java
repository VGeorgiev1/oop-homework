package org.elsys.gates;

public abstract class NandFactory {

	public static Gate makeNotGate(Wire in, Wire out, String name) {
		return new NandGate(in,in,out,name);
	}

	public static Gate makeNotGate(Wire in, Wire out) {
		return makeNotGate(in, out, "NandNot");
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate cg = new CompositeGate(name);
		Wire wire = new Wire("NandOut");
		NandGate ng = new NandGate(in1,in2,wire);
		Gate notGate = makeNotGate(wire, out);
		cg.addGate(ng);
		cg.addGate(notGate);
		return cg;
	}

	public static Gate makeAndGate(Wire in1, Wire in2, Wire out) {
		return makeAndGate(in1, in2, out, "NandAnd");
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate cg = new CompositeGate(name);
		cg.addInput(in1);
		cg.addInput(in2);
		cg.addOutput(out);
		Wire w1 = new Wire("NotOut1");
		Wire w2 = new Wire("NotOut2");
		Gate n1 = makeNotGate(in1,w1,"Not1");
		Gate n2 = makeNotGate(in2,w2, "Not2");
		NandGate ng = new NandGate(w1, w2, out);
		cg.addGate(n1);
		cg.addGate(n2);
		cg.addGate(ng);
		return cg;
	}

	public static Gate makeOrGate(Wire in1, Wire in2, Wire out) {
		return makeOrGate(in1, in2, out, "NandOr");
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out, String name) {
		CompositeGate cg = new CompositeGate(name);
		cg.addInput(in1);
		cg.addInput(in2);
		cg.addOutput(out);
		Wire w1 = new Wire("NandOrOut");
		Wire w2 = new Wire("NandOrOut");
		Wire w3 = new Wire("NandOrOut");
		cg.addGate(new NandGate(in1,in2,w1));
		cg.addGate(new NandGate(in1,w1,w2));
		cg.addGate(new NandGate(in2,w1,w3));
		cg.addGate(new NandGate(w2,w3,out));
		return cg;
		
	}

	public static Gate makeXorGate(Wire in1, Wire in2, Wire out) {
		return makeXorGate(in1, in2, out, "NandXor");
	}

}
