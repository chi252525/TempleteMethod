package water.showdown;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    ShowdownGame showdown = new ShowdownGame(new Deck(), List.of(
        new HumanPlayer(), new HumanPlayer(), new HumanPlayer()));
    showdown.start();

  }
}