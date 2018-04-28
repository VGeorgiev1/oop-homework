package org.elsys.cardgame.api;

import java.util.List;

public interface Hand {

	List<org.elsys.cardgame.engine.Card> getCards();

	int size();
}
