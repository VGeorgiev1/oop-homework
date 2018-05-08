package org.elsys.cardgame.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.elsys.cardgame.api.CardException;

public class Deck implements org.elsys.cardgame.api.Deck{
	List<Card> cards = new ArrayList<Card>();
	List<Card> origin_cards = new ArrayList<Card>();
	private int size;
	private int handSize;
	public Deck(int size, int handSize, List<Card> cards) {
		this.size = size;
		this.handSize = handSize;
		for(int i=0;i<cards.size();i++) {
			this.cards.add(cards.get(i));
			this.origin_cards.add(cards.get(i));
		}
	}
	public Deck(String cardStrings) {
		List<Card> cards = new ArrayList<Card>();
		for(String card : cardStrings.split("\\s+")) {
			cards.add(new Card(card, 0));
			this.origin_cards.add(new Card(card, 0));
		}
		this.cards = cards;
		this.size = this.cards.size();
	}

	public List<Card> getCards(){
		return this.cards;
	}
	public List<Card> getOriginCards(){
		return this.origin_cards;
	}
	public boolean correctCards(List<Card> cards) {
		final List<Card> thisCardsCopy = new ArrayList<Card>(this.origin_cards).stream().distinct().filter(card -> cards.contains(card)).collect(Collectors.toList());
		if(thisCardsCopy.size() < cards.size()) {
			return false;
		}
		for(Card c : thisCardsCopy) {
			c.setScore(cards.get(cards.indexOf(c)).getScore());
		}
		this.cards = new ArrayList<Card>(thisCardsCopy);
		
		return true;
	}
	public int size() {
		return this.cards.size();
	}
	
	public int handSize() {
		return this.handSize;
	}
	public void setHandSize(int hsize) {
		this.handSize = hsize;
	}
	public Card drawTopCard() {
		assertDrawOrPeak();
		return this.cards.remove(0);
	}
	public Card topCard() {
		assertDrawOrPeak();
		Card c = this.cards.get(0);
		System.out.println(c.getSuit().getSymbol() + c.getRank().getSymbol());
		return c;
	}
	public Card drawBottomCard() {
		assertDrawOrPeak();
		return this.cards.remove(this.size() - 1);
	}
	public Card bottomCard() {
		assertDrawOrPeak();
		Card c = this.cards.get(this.size() - 1);
		System.out.println(c.getSuit().getSymbol() + c.getRank().getSymbol());
		return c;
	}
	public Hand deal() {
		assertDeal();
		List<Card> curHand = new ArrayList<Card>();
		for(int i=0;i<this.handSize();i++){
			Card c = drawTopCard();
			System.out.print(c.getSuit().getSymbol() + c.getRank().getSymbol() + " ");
			curHand.add(c);
		}
		System.out.println();
		return new Hand(curHand,this.handSize);
	}
	private void assertDrawOrPeak() throws CardException{
		if(this.cards.size() == 0) {
			throw new CardException("ERROR: Not enough cards in deck");
		}
	}
	private void assertDeal() {
		if(this.cards.size() < this.handSize) {
			throw new CardException("ERROR: Not enough cards in deck");
		}
	}
	public void sort() {
		setCards(getCards().stream().sorted((a,b) -> a.getScore() - b.getScore()).collect(Collectors.toList()));
		printCards();
	}
	private void setCards(List<Card> newCard) {
		this.cards = newCard;
	}
	private void printCards() {
		for(Card c : this.getCards()) {
			System.out.print(c.getSuit().getSymbol() + c.getRank().getSymbol() + " ");
		}
		System.out.println();
	}

	public void shuffle() {
		for(int i=0;i<size();i++) {
			int random = (int)(Math.random() * size);
			Card c = this.cards.get(i);
			this.cards.set(i, this.cards.get(random));
			this.cards.set(random, c);
		}
		printCards();
	}

	
}
