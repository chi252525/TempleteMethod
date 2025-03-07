package game.uno;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Deck extends game.base.Deck<UnoCard> {
    public static Deck standardUnoDeck() {
        Deck deck = new Deck();
        for (int num = 0; num <= 9; num++) {
            for (UnoCard.Color color : UnoCard.Color.values()) {
                deck.push(new UnoCard(num, color));
            }
        }
        return deck;
    }
}
