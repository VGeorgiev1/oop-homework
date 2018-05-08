package org.elsys.cardgame.operations;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Operation;

public class Size extends Operation{
	private Deck deck;
	public Size(Deck war){
		super("size");
		this.deck = war;
	}
	public void execute() {
		System.out.println(this.deck.size());
	}
}
