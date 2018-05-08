package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Operation;

public class DrawBottomCard extends Operation{
	private Deck deck;
	public DrawBottomCard(Deck deck) {
		super("draw_bottom_card");
		this.deck = deck;
	}
	public void execute() {
		Card c = this.deck.drawBottomCard();
		System.out.println(c.getSuit().getSymbol()+ c.getRank().getSymbol());
	}
}
