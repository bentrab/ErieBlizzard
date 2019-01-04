import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.List;

/**
 * The same game
 * @author Ben Trabold
 */

public class SameGame extends Application {

    /**
     * Updates the board after a click
     * @param s board for game mechanics
     * @param gridPane buttons are housed in
     */
    public void updateBoard(SameGameBoard s, GridPane gridPane) {
        for (int i = 0; i < s.getBoard().length; i++) { //repopulates board
            for (int j = 0; j < s.getBoard()[i].length; j++) {
                CoolButton cb = new CoolButton("", new Circle(10, s.getColor(s.getBoard()[i][j])), i, j);
                gridPane.add(cb, i, s.getBoard()[i].length - j);
                cb.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        s.deleteCells(cb.getX(), cb.getY());
                        for (int k = 0; k < 20; k++) { //makes sure all necesarry shifts are done
                            s.shiftCells();
                        }
                        updateBoard(s, gridPane);  //updates the board after each click with new clickable buttons
                    }
                });
            }
        }
    }

    /**
     * Starts the game
     * @param primaryStage for user interface
     */
    @Override
    public void start(Stage primaryStage) {
        SameGameBoard s;
        List<String> arguments = this.getParameters().getRaw();

        if(!arguments.isEmpty()) {
            s = new SameGameBoard(Integer.parseInt(arguments.get(0)), Integer.parseInt(arguments.get(1)), Integer.parseInt(arguments.get(2)));
        }
        else {
            s = new SameGameBoard(12, 12, 3);
        }
        if (!arguments.isEmpty() && (Integer.parseInt(arguments.get(0)) > 15 || Integer.parseInt(arguments.get(1)) > 16 || Integer.parseInt(arguments.get(2)) > 8 )) {
            System.out.println("Please input board parameters below 16 and a number of colors less than 9");
        }
        else {
            GridPane gridPane = new GridPane();
            primaryStage.setTitle("Rad Same Game");
            Scene scene = new Scene(gridPane);
            primaryStage.setScene(scene);
            primaryStage.show();
            updateBoard(s, gridPane); //populates board with buttons and updates after click
        }
    }

    /**
     * Launches program
     * @param args for game parameters
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}