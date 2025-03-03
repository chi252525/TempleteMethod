package water.uno;

import static java.lang.String.format;

import java.util.Random;
import water.showdown.Card;
import static java.util.stream.IntStream.range;
import static water.uno.TurnMove.pass;
import static water.uno.TurnMove.play;

public class AI extends Player {
  private static final Random random = new Random();
  @Override
  public void nameSelf(int order) {
    setName(format("AI-%d", order));
  }

  @Override
  public TurnMove takeTurn(Card topCard) {
    int[] legalCardIndices = topCard == null ?
        range(0, hand.size()).toArray() :
        filterLegalCardIndices(topCard);

    if (legalCardIndices.length == 0) {
      return pass(this);
    }
    int choice = legalCardIndices[random.nextInt(legalCardIndices.length)];
    return play(this, hand.play(choice));
  }

  private int[] filterLegalCardIndices(Card topCard) {
    return range(0, hand.size())
        .filter(i -> hand.get(i).getColor() == topCard.getColor() ||
            hand.get(i).getNumber() == topCard.getNumber()).toArray();
  }

}
