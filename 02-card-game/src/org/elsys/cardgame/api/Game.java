package org.elsys.cardgame.api;

public interface Game {

	Deck getDeck();
	
	Hand getDealtHand();
	
	void setDealtHand(Hand hand);

	Operation process(String command);

	void addOperation(Operation operation);
}