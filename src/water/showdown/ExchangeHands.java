package water.showdown;

import water.Utils;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class ExchangeHands {

  private int countdown = 3;
  private final Player exchanger;
  private final Player exchangee;

  public ExchangeHands(Player exchanger, Player exchangee) {
    this.exchanger = exchanger;
    this.exchangee = exchangee;
    exchange();
  }

  private void exchange() {
    Hand hand = exchanger.getHand();
    exchanger.setHand(exchangee.getHand());
    exchangee.setHand(hand);
    Utils.printf("You have exchanged your hand with the player %s.\n", exchangee.getName());
  }

  public void countdown() {
    countdown--;
    if (countdown == 0) {
      exchange(); // exchange back when it's dead
    }
  }
}
