package game.uno;

import static java.lang.String.format;

/**
 * @author - johnny850807@gmail.com (Waterball)
 */
public class UnoCard {
    private final int number;
    private final Color color;

    public enum Color {
        BLUE, RED, YELLOW, GREEN
    }

    public UnoCard(int number, Color color) {
        this.number = validateNumber(number);
        this.color = color;
    }

    public int validateNumber(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException("The number must be within 0~9.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return format("%s-%d", color, number);
    }
}
