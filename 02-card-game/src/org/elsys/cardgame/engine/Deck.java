package org.elsys.cardgame.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Deck implements org.elsys.cardgame.api.Deck{
	List<Card> cards = new ArrayList<Card>();
	private int size;
	private int handSize;
	public Deck(int size, int handSize, List<Card> cards) {
		this.size = size;
		this.handSize = handSize;
		for(int i=0;i<cards.size();i++) {
			this.cards.add(cards.get(i));
		}
	}
	public List<Card> getCards(){
		return this.cards;
	}
	
	public int size() {
		return this.size;
	}
	
	public int handSize() {
		return handSize;
	}
	public Card drawTopCard() {
		size--;
		return this.cards.remove(0);
	}
	public Card topCard() {
		Card c = this.cards.get(0);
		System.out.println(c.getRank().getSymbol() + c.getSuit().getSymbol());
		return c;
	}
	public Card drawBottomCard() {
		size--;
		return this.cards.remove(this.size);
	}
	public Card bottomCard() {
		Card c = this.cards.get(this.size - 1);
		System.out.println(c.getRank().getSymbol() + c.getSuit().getSymbol());
		return c;
	}
	public Hand deal() {
		List<Card> curHand = new ArrayList<Card>();
		for(int i=0;i<this.handSize;i++){
			//System.out.println(this.cards.get(this.size - 1).getRank().getSymbol() + this.cards.get(this.size - 1).getSuit().getSymbol())
			curHand.add(drawTopCard());
		}
		return new Hand(curHand,this.handSize);
	}
	public void sort() {
		setCards(getCards().stream().sorted((a,b) -> a.getScore() - b.getScore()).collect(Collectors.toList()));
	}
	private void setCards(List<Card> newCard) {
		this.cards = newCard;
	}
	public void shuffle() {
		for(int i=0;i<size;i++) {
			int random = (int)(Math.random() * size);
			Card c = this.cards.get(i);
			this.cards.set(i, this.cards.get(random));
			this.cards.set(random, c);
		}
	}
	
}
