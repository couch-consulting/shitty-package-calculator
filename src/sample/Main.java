/**
 * @author Rick
 * @author Thore
 * @author Lennerd
 * @version otter
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class, starts frame and executes it
 */
public class Main extends Application {

    @Override
    /**
     * starts stage
     */
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("umfall.fxml"));
        primaryStage.setTitle("Shitty Packet Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        //nn
    }
}
