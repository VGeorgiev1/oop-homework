package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.engine.Operation;

public class DrawBottomCard extends Operation{
	public DrawBottomCard() {
		super("draw_bottom_card");
	}
	public void execute() {
		Card c = getDeck().drawBottomCard();
		System.out.println(c.getRank().getSymbol()+ c.getSuit().getSymbol());
	}
}
