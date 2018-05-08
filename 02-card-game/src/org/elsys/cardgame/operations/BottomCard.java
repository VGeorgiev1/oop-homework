package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Operation;

public class BottomCard extends Operation {
	private Deck deck;
	public BottomCard(Deck deck){
		super("bottom_card");
		this.deck = deck;
	}
	@Override
	public void execute() {
		this.deck.bottomCard();
	}

}
