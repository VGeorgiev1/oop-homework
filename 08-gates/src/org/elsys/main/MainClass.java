package org.elsys.main;
import org.elsys.gates.GateFactory;
import org.elsys.gates.Wire;

import java.util.Scanner;

import org.elsys.gates.CompositeGate;
import org.elsys.gates.Gate;


public class MainClass {
	public static void main(String [] args){
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt();
		int b = s.nextInt();
		Wire[] aWires = new Wire[8];
		Wire[] bWires = new Wire[8];
		Wire[] sums = new Wire[8];
		Wire cin = new Wire("cin");
		Wire cout = new Wire("cin");
		

		for(int i=0;i<8;i++){
			aWires[i] = new Wire("WireA" + i);
			bWires[i] = new Wire("Wireb" + i);
			sums[i] = new Wire("Sum" + i);
		}
		Gate RippleAdder= GateFactory.makeRippleCarryAdder(aWires, bWires, cin, sums, cout);
		
		
		intToWires(a, aWires);
		intToWires(b, bWires);
		int res = wiresToInt(sums);
		System.out.println(res);
		
	}
	public static void intToWires(int val, Wire[] w) {
		for (int i = 0; i < w.length; ++i) {
			int bit = 1 << i;
			w[i].setSignal((bit & val) != 0);
		}
	}

	public static int wiresToInt(Wire[] w) {
		int result = 0;
		for (int i = 0; i < w.length; ++i) {
			if (w[i].getSignal()) {
				int bit = 1 << i;
				result = result | bit;
			}
		}
		return result;
	}
}
