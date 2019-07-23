package tank;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application{
	
	TankGUI tankGUI = new TankGUI();
	Stage window;
	Scene scene1, scene2;
	Text text1, text2;
	
	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        //Exit Game button
        Button exitButton = new Button("Exit Game");
        exitButton.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5; -fx-font-family: Copperplate;");
        exitButton.setOnAction(e -> exitGame());

        //Starting game button
        Button newGameButton = new Button("Start New Game");
        newGameButton.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5;-fx-font-size: 2em; -fx-font-family: Copperplate;");
        newGameButton.setOnAction(e -> window.setScene(scene2));

        //Main Menu Layout
        VBox mainLayout = new VBox(20);
        text1 = new Text("TANK");
        text1.setFill(Color.DARKRED);
        text1.setFont(Font.font("Copperplate", FontWeight.EXTRA_BOLD, 200));
        text1.setStroke(Color.WHITESMOKE);
        
        //mainLayout.setId("pane");
        mainLayout.getChildren().addAll(text1, newGameButton, exitButton);
        mainLayout.setAlignment(Pos.CENTER);
        scene1 = new Scene(mainLayout, 1500, 750);
        scene1.getStylesheets().addAll("stylesheet.css");
        
        //Return to main button
        Button returnMain = new Button("Return to the Main Menu");
        returnMain.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5; -fx-font-family: Copperplate;");
        returnMain.setOnAction(e -> window.setScene(scene1));
        
        //Single mode button
        Button singleModeButton = new Button("Single Mode");
        singleModeButton.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5;-fx-font-size: 2em; -fx-font-family: Copperplate;");
       /*singleModeButton.setOnAction(e -> window.setScene(scene3));*/
        
        //Two player mode button
        Button twoPlayerModeButton = new Button("Two Player Mode");
        twoPlayerModeButton.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5;-fx-font-size: 2em; -fx-font-family: Copperplate;");

        //Game mode layout
        VBox gameModeLayout = new VBox(20);
        Text text2 = new Text("Select a mode:");
        text2.setFill(Color.DARKRED);
        text2.setFont(Font.font("Copperplate", FontWeight.MEDIUM, 100));
        text2.setStroke(Color.WHITESMOKE);
        gameModeLayout.getChildren().addAll(text2, singleModeButton, twoPlayerModeButton, returnMain);
        gameModeLayout.setAlignment(Pos.CENTER);
        scene2 = new Scene(gameModeLayout, 1500, 750);
        scene2.getStylesheets().addAll("stylesheet.css");

        //Display main menu first
        window.setScene(scene1);
        window.setTitle("TANK");
        window.show();
        
        //Game layout
        /*scene3 = 
         tankGUI.getStage().setScene(scene3);
        */
        
        //Exiting
        window.setOnCloseRequest(e -> {
        	e.consume();
        	exitGame();   
		});
		
	}
	
	private void exitGame() {
		Boolean answer = ConfirmExit.display("WARNING", "Are you sure you want to exit?");
		if(answer)
			window.close();
}


}
