package game.uno;

import java.util.Random;

import static java.lang.String.format;
import static java.util.stream.IntStream.range;
import static game.uno.TurnMove.pass;
import static game.uno.TurnMove.play;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class AI extends Player {
    private static final Random random = new Random();
    @Override
    public void nameSelf(int order) {
        setName(format("AI-%d", order));
    }

    @Override
    public TurnMove takeTurn(UnoCard topUnoCard) {
        int[] legalCardIndices = topUnoCard == null ?
                range(0, hand.size()).toArray() :
                filterLegalCardIndices(topUnoCard);

        if (legalCardIndices.length == 0) {
            return pass(this);
        }
        int choice = legalCardIndices[random.nextInt(legalCardIndices.length)];
        return play(this, hand.play(choice));
    }

    private int[] filterLegalCardIndices(UnoCard topUnoCard) {
        return range(0, hand.size())
                .filter(i -> hand.get(i).getColor() == topUnoCard.getColor() ||
                        hand.get(i).getNumber() == topUnoCard.getNumber()).toArray();
    }
}
