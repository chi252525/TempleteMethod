package game.uno;

import game.base.CardGame;

import java.util.List;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class Uno extends CardGame<Player, UnoCard> {
    private final Deck discards = new Deck();
    private UnoCard topUnoCard;

    public Uno(Deck deck, List<Player> players) {
        super(deck, players);
    }

    @Override
    protected int getInitialHandSize() {
        return 5;
    }

    @Override
    protected void onGameBegins() {
        topUnoCard = deck.draw();
    }

    @Override
    protected void takeTurn(Player player) {
        TurnMove turnMove = player.takeTurn(topUnoCard);
        if (turnMove.isPass()) {
            pass(player);
        } else {
            if (isValidMove(turnMove)) {
                playCard(player, turnMove);
            } else {
                turnMove.undo();
            }
        }
    }

    private boolean isValidMove(TurnMove turnMove) {
        UnoCard unoCard = turnMove.getCard();
        return topUnoCard.getColor() == unoCard.getColor() ||
                topUnoCard.getNumber() == unoCard.getNumber();
    }

    private void pass(Player player) {
        System.out.printf("Player %s pass so he has to draw a card from the deck.\n", player.getName());
        reshuffleDeckIfEmpty();
        player.addHandCard(deck.draw());
    }

    private void playCard(Player player, TurnMove turnMove) {
        if (topUnoCard != null) {
            discards.push(topUnoCard);
        }
        topUnoCard = turnMove.getCard();
        System.out.printf("Player %s plays a %s.\n", player.getName(), topUnoCard);
    }

    private void reshuffleDeckIfEmpty() {
        if (deck.isEmpty()) {
            System.out.println("The deck is empty, reshuffling the deck.");
            deck.push(discards);
            discards.clear();
            deck.shuffle();
        }
    }

    @Override
    protected boolean isGameOver(int currentRound) {
        return turnPlayer.getHand().isEmpty();
    }

    @Override
    protected Player getWinner() {
        return turnPlayer;
    }
}
