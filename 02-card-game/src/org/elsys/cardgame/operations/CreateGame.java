package org.elsys.cardgame.operations;

import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Game;
import org.elsys.cardgame.factory.DeckFactory;

public class CreateGame extends org.elsys.cardgame.engine.Operation{
	String cards;
	String[] suits;
	int handsize;
	int deckSize;
	Game g;
	Deck d;
	public CreateGame(Game g,String name, String cards, String[] suits, int handsize, int deckSize){
		super(name);
		this.cards = cards;
		this.handsize = handsize;
		this.deckSize = deckSize;
		this.g = g;
		this.d = DeckFactory.defaultDeck(deckSize, handsize,suits, cards);
	}
	public void execute() {
		if(this.g.getDeck().correctCards(this.d.getOriginCards())) {
			g.getDeck().setHandSize(this.handsize);
		}else {
			throw new CardException("ERROR: Not enough cards in deck");
		}
	}
}
