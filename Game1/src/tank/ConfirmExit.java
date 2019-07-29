package tank;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmExit {
	
    static boolean answer;

    public static boolean display(String title, String message) {
    	
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Text text = new Text();
        text.setFont(Font.font("Copperplate", FontWeight.NORMAL, 30));
        text.setStroke(Color.BLACK);
        text.setText(message);
        
        
        //Yes or No button choices
        Button yesbtn = new Button("Yes");
        yesbtn.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5; -fx-font-family: Copperplate;");
        Button nobtn= new Button("No");
        nobtn.setStyle("-fx-border-color: #8b0000; -fx-border-width: 5px; -fx-background-color: #f5f5f5; -fx-font-family: Copperplate;");

        //Clicking will set answer and close window
        yesbtn.setOnAction(e -> {
            answer = true;
            window.close();
        });
        nobtn.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox layout = new HBox(20);
        BorderPane borderPane = new BorderPane();
       
        //Displays buttons
        layout.getChildren().addAll(text, yesbtn, nobtn);
        layout.setStyle("-fx-background-color:#B6BF8E;");
        borderPane.setCenter(layout);
        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();


        return answer;
}
}
