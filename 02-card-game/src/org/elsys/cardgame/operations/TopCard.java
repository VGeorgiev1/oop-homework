package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Operation;

public class TopCard extends Operation {
	private Deck deck;
	public TopCard(Deck deck){
		super("top_card");
		this.deck = deck;
	}
	@Override
	public void execute() {
		this.deck.topCard();
	}

}
