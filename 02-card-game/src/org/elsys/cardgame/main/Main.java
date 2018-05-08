package org.elsys.cardgame.main;


import java.util.Scanner;

import org.elsys.cardgame.operations.CreateGame;
import org.elsys.cardgame.engine.Deck;
import org.elsys.cardgame.engine.Game;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Operation;
import org.elsys.cardgame.operations.BottomCard;

import org.elsys.cardgame.operations.Deal;
import org.elsys.cardgame.operations.DrawBottomCard;
import org.elsys.cardgame.operations.DrawTopCard;
import org.elsys.cardgame.operations.Shuffle;
import org.elsys.cardgame.operations.Size;
import org.elsys.cardgame.operations.Sort;
import org.elsys.cardgame.operations.TopCard;


public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		String cards = s.nextLine();
		Deck d = new Deck(cards);
		Game g = new Game(d);
		g.addOperation(new CreateGame(g,"War", "2 3 4 5 6 7 8 9 10 J Q K A",new String[]{"C", "D", "H", "S"},26,52));
		g.addOperation(new CreateGame(g,"Santase", "9 J Q K 10 A",new String[]{"C", "D", "H", "S"},6,24));
		g.addOperation(new CreateGame(g,"Belote", "7 8 9 J Q K 10 A" ,new String[]{"C", "D", "H", "S"},8,32));
		g.addOperation(new Size(d));
		g.addOperation(new Deal(g,d));
		g.addOperation(new DrawBottomCard(d));
		g.addOperation(new DrawTopCard(d));
		g.addOperation(new Shuffle(d));
		g.addOperation(new Sort(d));
		g.addOperation(new BottomCard(d));
		g.addOperation(new TopCard(d));
		while(s.hasNext()) {
			String statement = s.nextLine();
				if(statement.equals("quit")) break;
				Operation op = g.process(statement);
			
				if(op != null) {
					try {
						op.execute();
					}catch(CardException c) {
						System.out.println("ERROR: Not enough cards in deck");
					}
				}else { 
					System.out.println("ERROR: Unknown operation");	
				}
		}
		s.close();
	}
}
		


