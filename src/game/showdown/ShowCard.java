package game.showdown;

public class ShowCard implements Comparable<ShowCard> {

  private final Player player;
  private final ShowdownCard showdownCard;

  public ShowCard(Player player, ShowdownCard showdownCard) {
    this.player = player;
    this.showdownCard = showdownCard;
  }

  @Override
  public int compareTo(ShowCard o) {
    return showdownCard.compareTo(o.getCard());
  }

  public Player getPlayer() {
    return player;
  }

  public ShowdownCard getCard() {
    return showdownCard;
  }
}
