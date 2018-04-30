package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.engine.Operation;

public class Shuffle extends Operation {
	private Deck deck;
	public Shuffle(Deck deck) {
		super("shuffle");
	}
	@Override
	public void execute() {
		getDeck().shuffle();
	}

}
