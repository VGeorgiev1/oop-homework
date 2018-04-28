package org.elsys.cardgame.engine;

import java.util.ArrayList;
import java.util.List;

public class Hand implements org.elsys.cardgame.api.Hand{
	
	private List<Card> hand = new ArrayList<Card>();
	private int size;
	
	public Hand(List<Card> hand, int size) {
		this.hand = hand;
		this.size = size;
	}
	public int size() {
		return this.size;
	}
	public List<Card> getCards(){
		return hand;
	}
}
