package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Operation;

public class Shuffle extends Operation {
	private Deck deck;
	public Shuffle(Deck deck) {
		super("shuffle");
		this.deck = deck;
	}
	@Override
	public void execute() {
		this.deck.shuffle();
	}

}
