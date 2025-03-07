package game.uno;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class TurnMove {
    private final Player player;
    private final boolean pass;
    private final UnoCard unoCard;

    private TurnMove(Player player, boolean pass, UnoCard unoCard) {
        this.player = player;
        this.pass = pass;
        this.unoCard = unoCard;
    }

    public static TurnMove pass(Player player) {
        return new TurnMove( player, true, null);
    }

    public static TurnMove play(Player player, UnoCard unoCard) {
        return new TurnMove(player, false, unoCard);
    }

    public UnoCard getCard() {
        return unoCard;
    }

    public boolean isPass() {
        return pass;
    }

    public Player getPlayer() {
        return player;
    }

    public void undo() {
        player.addHandCard(unoCard);
    }
}
