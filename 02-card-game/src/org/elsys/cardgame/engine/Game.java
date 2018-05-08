package org.elsys.cardgame.engine;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;

public class Game implements org.elsys.cardgame.api.Game{
	Deck deck;
	Hand hand;
	boolean deckInitialized;
	List<Operation> operations = new ArrayList<Operation>();
	public Game(Deck deck) {
		this.deck = deck;
		this.deckInitialized = false;
	}
	public Deck getDeck() {
		return this.deck;
	};
	public Hand getDealtHand() {
		return this.hand;
	};
	public boolean deckInitialized() {
		return this.deckInitialized;
	}
	public void setDealtHand(Hand hand) {
		this.hand = hand;
	};

	public Operation process(String command) {
		for(Operation op : operations) {
			if(op.getName().equals(command)) {
				return op;
			}
		}
		return null;
	};
	public List<Operation> getOperations(){
		return this.operations;
	}
	public void addOperation(Operation operation) {
		operations.add(operation);
	}
	
}
