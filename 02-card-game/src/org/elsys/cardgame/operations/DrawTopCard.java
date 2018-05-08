package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Card;
import org.elsys.cardgame.engine.Deck;
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
		System.out.println(c.getSuit().getSymbol()+ c.getRank().getSymbol());
	}

}
