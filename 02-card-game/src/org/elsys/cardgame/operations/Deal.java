package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Game;
import org.elsys.cardgame.engine.Hand;
import org.elsys.cardgame.engine.Operation;

public class Deal extends Operation{
	private Game g;
	private Deck d;
	public Deal(Game g, Deck d) {
		super("deal");
		this.g = g;
		this.d = d;
	}
	public void execute(){
		Hand hand = this.d.deal();
		this.g.setDealtHand(hand);
	}
}
