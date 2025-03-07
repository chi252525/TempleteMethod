package game.showdown;

import static java.lang.String.format;


public class ShowdownCard implements Comparable<ShowdownCard> {
    private final Suit suit;
    private final Rank rank;

    public enum Suit {
        SPADE('♠', 4), HEART('♥', 3), DIAMOND('♦', 2), CLUB('♣', 1);

        private final char representation;
        private final int order;

        Suit(char representation, int order) {
            this.representation = representation;
            this.order = order;
        }

        @Override
        public String toString() {
            return String.valueOf(representation);
        }

        public int getOrder() {
            return order;
        }
    }


    public enum Rank {
        A("A", 14), R2("2", 2),
        R3("3", 3), R4("4", 4), R5("5", 5),
        R6("6", 6), R7("7", 7), R8("8", 8),
        R9("9", 9), R10("10", 10),
        J("J", 11), Q("Q", 12), K("K", 13);

        private final String representation;
        private final int order;

        Rank(String representation, int order) {
            this.representation = representation;
            this.order = order;
        }

        public String getRepresentation() {
            return representation;
        }

        public int getOrder() {
            return order;
        }

        @Override
        public String toString() {
            return representation;
        }
    }

    public ShowdownCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int compareTo(ShowdownCard showdownCard) {
        // game.showdown
        if (this.getRank().getOrder() == showdownCard.getRank().getOrder()) {
            return this.getSuit().getOrder() - showdownCard.getSuit().getOrder();
        }
        return this.getRank().getOrder() - showdownCard.getRank().getOrder();
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return format("%s%s", suit, rank);
    }
}
