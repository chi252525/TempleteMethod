package water.uno;

import water.showdown.Card;

public abstract class Player extends water.base.Player<Card> {

  public abstract TurnMove takeTurn(Card topCard);

}
