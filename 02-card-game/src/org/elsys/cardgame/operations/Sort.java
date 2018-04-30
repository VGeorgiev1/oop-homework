package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Operation;

public class Sort extends Operation{
	public Sort(){
		super("sort");
	}
	public void execute() {
		getDeck().sort();
	}
}
