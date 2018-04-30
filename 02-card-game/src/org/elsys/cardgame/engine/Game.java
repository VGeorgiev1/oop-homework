package org.elsys.cardgame.engine;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Operation;
import org.elsys.cardgame.factory.DeckFactory;
import org.elsys.cardgame.operations.Size;
public class Game implements org.elsys.cardgame.api.Game{
	Deck deck;
	Hand hand;
	List<Operation> operations = new ArrayList<Operation>();
	public Game(Deck deck) {
		this.deck = deck;
	}
	public Game() {}
	public Deck getDeck() {
		return this.deck;
	};
	
	public Hand getDealtHand() {
		return this.hand;
	};
	
	public void setDealtHand(Hand hand) {
		this.hand = hand;
	};

	public void process(String command) {
		for(Operation op : operations) {
			if(op.getName().equals(command)) {
				op.execute();
			}
		}
	};

	public void addOperation(Operation operation) {
		operations.add(operation);
	}
	public static void main(String argv[]) {
		Deck war = DeckFactory.defaultWarDeck();
		Game g =new Game(war);
		g.addOperation(new Size(g.getDeck()));
		g.process("size");
	}
	
}
