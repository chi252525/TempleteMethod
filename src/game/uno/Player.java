package game.uno;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public abstract class Player extends game.base.Player<UnoCard> {

    public abstract TurnMove takeTurn(UnoCard topUnoCard);

}
