package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Operation;

public class Deal extends Operation{
	public Deal() {
		super("deal");
	}
	public void execute(){
		getDeck().deal();
	}
}
