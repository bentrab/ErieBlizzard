
import javafx.scene.control.Button;
import javafx.scene.Node;

/**
 * Buttons in the same game
 * @author Ben Trabold
 */

public class CoolButton extends Button {

    /**
     * Stores the x coordinate of the button
     */
    private int x;

    /**
     * Stores the y coordinate of the button
     */
    private int y;

    /**
     * Returns the x coordinate
     * @return x cordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of the x coordinate
     * @param x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the y coordinate
     * @return y cordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of the y coordinate
     * @param y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * A constructor that initializes a cool button
     * @param text for button
     * @param graphic button shows
     * @param x coordinate
     * @param y coordinate
     */
    public CoolButton(String text, Node graphic, int x, int y) {
        super(text, graphic);
        this.y = y;
        this.x = x;
    }
}