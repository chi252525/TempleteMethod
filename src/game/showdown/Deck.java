package game.showdown;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Deck extends game.base.Deck<ShowdownCard> {
    public static Deck standard52Cards() {
        Deck deck = new Deck();
        ShowdownCard.Suit[] suits = ShowdownCard.Suit.values();
        ShowdownCard.Rank[] ranks = ShowdownCard.Rank.values();
        for (ShowdownCard.Suit suit : suits) {
            for (ShowdownCard.Rank rank : ranks) {
                deck.push(new ShowdownCard(suit, rank));
            }
        }
        return deck;
    }
}
