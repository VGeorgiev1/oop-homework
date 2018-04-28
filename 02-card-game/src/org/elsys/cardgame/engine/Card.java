package org.elsys.cardgame.engine;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;

public class Card implements org.elsys.cardgame.api.Card{
	private Suit suit;
	private Rank rank;
	private int score;
	public Card(String c, int score) {
		String suit = c.substring(c.length() - 1);
		String rank = c.substring(0, c.length() - 1);
		for (Suit a : Suit.values()) {
		    if(a.getSymbol().equals(suit)) {
		    	this.suit = a;
		    }
		}
	    for (Rank a : Rank.values()) {
	    	if(a.getSymbol().equals(rank)) {
	    		this.rank = a;
	    	}
	    }
	    this.score = score;
	}
	public int getScore() {
		return this.score;
	}
	public Suit getSuit() {
		return this.suit;
	}
	public Rank getRank() {
		return this.rank;
	}
	public boolean equals(Object other) {
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Card))return false;
	    Card otherCard = (Card)other;
	    if(otherCard.getRank().getSymbol().equals(this.getRank().getSymbol()) && otherCard.getSuit().getSymbol().equals(this.getSuit().getSymbol())) {
	    	return true;
	    }else {
	    	return false;
	    }
	}
}
