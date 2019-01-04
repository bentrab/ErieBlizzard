import javafx.scene.paint.Color;

/**
 * The board the game mechanics run on
 * @author Ben Trabold
 */

public class SameGameBoard {
    /**
     * The two dimensional array that represents the game board
     */
    int[][] board;

    /**
     * Constructor that initializes the board
     * @param x length of board
     * @param y height of board
     * @param numColors in the game
     */
    public SameGameBoard(int x, int y, int numColors) {
        this.board = new int[x][y];
        this.fillBoard(numColors);
    }

    /**
     * Returns the array that is the board
     * @return board for the game
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Sets the game board
     * @param board for the game
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Fills the board with random int values
     * @param numberColors for the game
     */
    public void fillBoard(int numberColors) {
        for (int i = 0; i < board.length; i++) { //parses through whole board and populates it with random int values
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = (int )(Math. random() * numberColors + 1);
            }
        }
    }

    /**
     * Shifts the cells down and to the left if there are empty spaces
     */
    public void shiftCells() {
        for (int i = 0; i < board.length; i++) {  //moves cells down if the cell beneath is blank
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = board[i][j + 1]; //copies the above cell down
                    board[i][j + 1] = 0; //makes the cell above blank
                }
            }
        }
        for (int i = 0; i < board.length; i++) {  //moves an entire row over if a row is blank
            for (int j = 0; j < board[i].length && board[i][j] == 0; j++) {
                if (j == board[i].length - 1 && i != board.length - 1) {
                    int[] blankSave = board[i];
                    board[i] = board[i + 1];
                    board[i + 1] = blankSave;
                }
            }
        }
    }


    /**
     * Deletes the cells above the input cell
     * @param x value of cell
     * @param y value of cell
     * @param save contents of cell
     * @return ranUp if the deletion was done
     */
    public boolean deleteUp(int x, int y, int save) {
        boolean ranUp = false;
        if (y == board[x].length - 1) { //does not run if out of bound exception would occur
            return ranUp;
        }
        else {
            for (int i = y + 1; i < board[x].length && (board[x][i] == save); i++) { //deletes like cells above
                board[x][i] = 0;
                ranUp = true;
            }
        }
        return ranUp;
    }

    /**
     * Deletes the cells below the input cell
     * @param x value of cell
     * @param y value of cell
     * @param save contents of cell
     * @return ranDown if the deletion was done
     */
    public boolean deleteDown(int x, int y, int save) {
        boolean ranDown = false;
        if (y == 0) { //does not run if out of bound exception would occur
            return ranDown;
        }
        else {
            for (int i = y - 1; i > -1 && (board[x][i] == save); i--) { //deletes like cells below
                board[x][i] = 0;
                ranDown = true;
            }
        }
        return ranDown;
    }

    /**
     * Deletes the cells to the right of the input cell
     * @param x value of cell
     * @param y value of cell
     * @param save contents of cell
     * @return ranRight if the deletion was done
     */
    public boolean deleteRight(int x, int y, int save) {
        boolean ranRight = false;
        if (x == board.length) { //does not run if out of bound exception would occur
            return ranRight;
        }
        else {
            for (int i = x + 1; i < board.length && (board[i][y] == save); i++) { //deletes like cells to the right
                board[i][y] = 0;
                ranRight = true;
            }
        }
        return ranRight;
    }

    /**
     * Deletes the cells to the left of the input cell
     * @param x value of cell
     * @param y value of cell
     * @param save contents of cell
     * @return ranLeft if the deletion was done
     */
    public boolean deleteLeft(int x, int y, int save) {
        boolean ranLeft = false;
        if (x == 0) { //does not run if out of bound exception would occur
            return ranLeft;
        }
        else {
            for (int i = x - 1; i > -1 && (board[i][y] == save); i--) { //deletes like cells to the left
                board[i][y] = 0;
                ranLeft = true;
            }
        }
        return ranLeft;
    }

    /**
     * Runs the four delete methods for the desired cell
     * @param x value of cell
     * @param y value of cell
     * @param save contents of the cell
     */
    public void deleteCellsInner(int x, int y, int save) {
        boolean ranUp = this.deleteUp(x, y, save);
        board[x][y] = save;
        boolean ranDown = this.deleteDown(x, y, save);
        board[x][y] = save;
        boolean ranRight= this.deleteRight(x, y, save);
        board[x][y] = save;
        boolean ranLeft = this.deleteLeft(x, y, save);
        if (ranUp || ranDown || ranRight || ranLeft) { //if any of the delete methods are run, delete original input cell
            board[x][y] = 0;
        }
    }

    /**
     * Deletes desired cells around the input cell
     * @param x value of cell
     * @param y value of cell
     */
    public void deleteCells(int x, int y) {
        int save = board[x][y];
        this.deleteCellsInner(x, y, save);
    }

    /**
     * Converts the value of the cell to the desired color
     * @param value of cell
     * @return color of cell
     */
    public Color getColor(int value) {
        Color color = Color.LIGHTGREY;
        switch (value) {
            case 0: color = Color.LIGHTGREY;
                break;
            case 1: color = Color.CORNFLOWERBLUE;
                break;
            case 2: color = Color.RED;
                break;
            case 3: color = Color.DARKSEAGREEN;
                break;
            case 4: color = Color.LIMEGREEN;
                break;
            case 5: color = Color.ORANGE;
                break;
            case 6: color = Color.PLUM;
                break;
            case 7: color = Color.YELLOW;
                break;
            case 8: color = Color.BLUE;
                break;
        }
        return color;
    }
}
