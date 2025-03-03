package water.uno;

import water.showdown.Deck;



public class UnoDeck extends water.base.Deck<Card> {
  public static UnoDeck standardUnoDeck() {
    UnoDeck deck = new UnoDeck();
    for (int num = 0; num <= 9; num++) {
      for (Card.Color color : Card.Color.values()) {
        deck.push(new Card(num, color));
      }
    }
    return deck;
  }
}