package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Operation;

public class Sort extends Operation{
	private Deck deck;
	public Sort(Deck deck){
		super("sort");
		this.deck = deck;
	}
	public void execute() {
		this.deck.sort();
	}
}
