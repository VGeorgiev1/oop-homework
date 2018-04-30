package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.engine.Operation;

public class DrawTopCard extends Operation {
	private Deck deck;
	public DrawTopCard(Deck deck) {
		super("draw_top_card");
		this.deck = deck;
	}
	@Override
	public void execute() {
		Card c = deck.drawTopCard();
		System.out.println(c.getRank().getSymbol()+ c.getSuit().getSymbol());
	}

}
