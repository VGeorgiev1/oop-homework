package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Operation;

public class BottomCard extends Operation {

	public BottomCard(){
		super("bottom_card");
	}
	@Override
	public void execute() {
		getDeck().bottomCard();
	}

}
