package org.elsys.cardgame.factory;


import java.util.List;


import org.elsys.cardgame.engine.Card;
import org.elsys.cardgame.engine.Game;
import org.elsys.cardgame.engine.Deck;

public class GameFactory {

	public static Game createWarGame(List<Card> cards) throws Exception{
		Deck war = DeckFactory.defaultWarDeck();
		if(war.correctCards( war.getCards()))
			return new Game(DeckFactory.defaultDeck(52, 26, cards));
		else
			throw new Exception();
	}

	public static Game createSantaseGame(List<Card> cards) throws Exception {
		Deck santase = DeckFactory.defaultSantaseDeck();
		if(santase.correctCards(santase.getCards()))
			return new Game(DeckFactory.defaultDeck(24, 6, cards));
		else
			throw new Exception();
	}

	public static Game createBeloteGame(List<Card> cards) throws Exception {
		Deck belote = DeckFactory.defaultBeloteDeck();
		if(belote.correctCards(belote.getCards()))
			return new Game(DeckFactory.defaultDeck(32, 8, cards));
		else
			throw new Exception();
	}
}