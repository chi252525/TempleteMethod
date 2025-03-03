package water.uno;

import static java.util.Arrays.asList;
import static water.uno.UnoDeck.standardUnoDeck;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Player> players = asList(new AI(), new AI(), new AI(), new AI());
    Uno uno = new Uno(standardUnoDeck(), players);
    uno.start();
  }
}