package tank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 * 
 * @author Joshua
 *
 */
public class Tank extends Application {
    Pane playerLayer;
    Pane bulletLayer;
    Pane envLayer;

    Image playerOneImage;
    Image playerTwoImage;
    Image bulletImage;
    Image ground;

    TankModel playerOne;
    TankModel playerTwo;
    Environment sceneEnv;

    List<Bullets> bullets = new ArrayList<>();
    
    Group group;
    Scene scene;
    Button resume;
    Button pause;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        group = new Group();

        // create layers
        playerLayer = new Pane();
        bulletLayer = new Pane();
        envLayer = new Pane();

        group.getChildren().add(envLayer);
        group.getChildren().add(playerLayer);
        group.getChildren().add(bulletLayer);

        scene = new Scene(group, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT, Color.web("0x87CEEB"));

        primaryStage.setScene(scene);
        primaryStage.show();

        loadGame();
        createTankModels();
        createEnvironment();
        
        pause = new Button();
        pause.setLayoutX((Settings.SCENE_WIDTH / 2) - 75);
        pause.setLayoutY(Settings.SCENE_HEIGHT - 50);
        pause.setText("Pause");
        pause.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		pauseGame(game);
        	}
        });
        
        resume = new Button();
        resume.setLayoutX((Settings.SCENE_WIDTH / 2) + 20);
        resume.setLayoutY(Settings.SCENE_HEIGHT - 50);
        resume.setText("Resume");
        resume.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e) {
        		resumeGame(game);
        	}
        });
             
        group.getChildren().add(resume);
        group.getChildren().add(pause);
        startGame(game);
        
    }
    
    private void startGame(AnimationTimer g) {
    	g.start();
    }
    
    //used go transition to game over sequence
    private void pauseGame(AnimationTimer g) {
    	g.stop();
    }
    
    private void resumeGame(AnimationTimer g) {
    	g.start();
    }
    
    private void loadGame() throws FileNotFoundException {
        playerOneImage = new Image(new FileInputStream("/Users/joshua/Documents/GitHub/Tank_Game/GameDemo/images/tank_right.png"));
        playerTwoImage = new Image(new FileInputStream("/Users/joshua/Documents/GitHub/Tank_Game/GameDemo/images/tank_left.png"));
        bulletImage = new Image(new FileInputStream("/Users/joshua/Documents/GitHub/Tank_Game/GameDemo/images/transparent-laser.png"));
        ground = new Image(new FileInputStream("/Users/joshua/Documents/GitHub/Tank_Game/GameDemo/images/sprite_floor.png"));
    }
    
    

    private void createTankModels() {
        // TankModel input
        P1Controls c1 = new P1Controls(scene);
        P2Controls c2 = new P2Controls(scene);
        
        // create input listeners
        c1.addEventListeners(); 
        c2.addEventListeners();
        
        double y = Settings.SCENE_HEIGHT * .82;

        // create TankModel
        playerOne = new TankModel(playerLayer, playerOneImage, 150, y, 0, 0, Settings.TANK_SHIP_HEALTH, Settings.TANK_SHIP_SPEED, c1, c2, "player1");
        playerTwo = new TankModel(playerLayer, playerTwoImage, 1000, y, 0, 0, Settings.TANK_SHIP_HEALTH, Settings.TANK_SHIP_SPEED, c1, c2, "player2");
    }
    
    private void createEnvironment() {
    	double y = Settings.SCENE_HEIGHT * .75;
    	sceneEnv = new Environment(envLayer, ground, 0, y, 0, 0);
    }
    
    private AnimationTimer game = new AnimationTimer() {
        @Override
        public void handle(long now) {
           
        	playerOne.processInput(); 
        	playerTwo.processInput(); 
            
        	playerOne.move();
        	playerTwo.move();
            
        	playerOne.updateUI();
        	playerTwo.updateUI();
        	
        	if (playerOne.getP1Controls().isFire()) {
        		double xPosP1 = playerOne.getView().getLayoutX() + playerOne.getImage().getWidth() - 20; 
            	double yPosP1 = playerOne.getView().getLayoutY() + 30;
            	
            	Bullets bullet = new Bullets(bulletLayer, bulletImage, xPosP1, yPosP1, 0.00, 0.00, Settings.BULLET_SPEED);
            	bullets.add(bullet);
        	}
        	
        	if (playerTwo.getP2Controls().isFire()) {
        		double xPosP2 = playerTwo.getView().getLayoutX() + 10; 
            	double yPosP2 = playerTwo.getView().getLayoutY() + 30;
            	
            	Bullets bullet = new Bullets(bulletLayer, bulletImage, xPosP2, yPosP2, 0.00, 0.00, -Settings.BULLET_SPEED);
            	bullets.add(bullet);
        	}
        	
        	bullets.forEach(bullet -> bullet.move());
        	bullets.forEach(bullet -> bullet.updateUI());
        }
    };   
   
    public static void main(String[] args) {
        launch(args);
    }

}