package org.elsys.cardgame.factory;
import java.util.ArrayList;
import java.util.List;
import org.elsys.cardgame.engine.Card;
import org.elsys.cardgame.engine.Deck;


public class DeckFactory {
	public static Deck defaultDeck(int size, int handSize, String[] suits, String cardString) {
		String[] cardRanked = cardString.split("\\s+");
		int score = 0;
		List<Card> cards = new ArrayList<Card>();
		for(int i=0;i<cardRanked.length;i++){
			for(int b=0;b<suits.length;b++){
				cards.add(new Card(suits[b] + cardRanked[i] , score));
				score++;
			}
		}
		return new Deck(size,handSize, cards);
	}
	public static Deck defaultDeck(int size, int handSize, List<Card> cards) {
		return new Deck(size,handSize, cards);
	}
	public static Deck defaultWarDeck() {
		String[] suits = {"C", "D", "H", "S"};
		return defaultDeck(52,26,suits, "2 3 4 5 6 7 8 9 10 J Q K A");
	}
	public static Deck defaultSantaseDeck() {
		String[] suits = {"C", "D", "H", "S"};
		return defaultDeck(24,6,suits, "9 J Q K 10 A");
	}

	public static Deck defaultBeloteDeck() {
		String[] suits = {"C", "D", "H", "S"};
		return defaultDeck(32,8,suits, "7 8 9 J Q K 10 A");
	}
}
