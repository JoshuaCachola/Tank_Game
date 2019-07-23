package tank;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;


public class TankGUI extends Application{
	
	private static Stage windowGUI;

	public static void main (String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return windowGUI;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		windowGUI = primaryStage;
        BorderPane gameLayout = new BorderPane();
        //Label label2 = new Label("Select a mode:");
        //gameModeLayout.getChildren().addAll(label2, singleModeButton, twoPlayerModeButton, returnMain);
        //gameModeLayout.setAlignment(Pos.CENTER);
        //scene2 = new Scene(gameModeLayout, 1500, 750);

		
		
	}
}
