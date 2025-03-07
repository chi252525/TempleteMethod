package game.showdown;


public abstract class Player extends game.base.Player<ShowdownCard> {
    protected int point;
    protected Showdown showdown;

    protected abstract ShowdownCard takeTurn();

    public void setShowdown(Showdown showdown) {
        this.showdown = showdown;
    }

    public void gainPoint() {
        point++;
    }

    public int getPoint() {
        return point;
    }
}