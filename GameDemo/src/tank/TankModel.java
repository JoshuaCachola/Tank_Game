package tank;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Joshua
 *
 */
public class TankModel extends Sprite {

    private double tankMinX;
    private double tankMaxX;

    private P1Controls c1;
    private P2Controls c2;

    private double speed;
    private double health;

    public TankModel(Pane playerlayer, Image image, double x, double y, double dx, double dy, double health, double speed, P1Controls c1, P2Controls c2, String player) {//, Pane bulletLayer, Image bulletImg, List<Bullets> bullets) {
        super(playerlayer, image, x, y, dx, dy, player);
        this.health = health;
        this.speed = speed;
        this.c1 = c1;
        this.c2 = c2;

        createBounds();
    }
    
    private void createBounds() {
        // calculate movement bounds of the player tank
        // allow half of the tank to be outside of the screen 
    	// player1 can travel from left to middle
    	if (getPlayer() == "player1") {
    		tankMinX = 0 - this.getImage().getWidth() / 2.00;
            tankMaxX = (Settings.SCENE_WIDTH / 2.0) - (this.getImage().getWidth() / 2.00);
    	}
    	// player2 can travel from right to middle
    	else {
    		tankMinX = (Settings.SCENE_WIDTH / 2.0) - (this.getImage().getWidth() / 2.00 - 50.00);
            tankMaxX = Settings.SCENE_WIDTH - (this.getImage().getWidth() / 2.00);
    	}
    }

    public void processInput() {
    	if (getPlayer().equals("player1")) {
        // horizontal direction for player 1
    		if (c1.isMoveLeft()) {
    			setDx(-speed);
        	} 
    		else if (c1.isMoveRight()) {
        		setDx(speed);
        	}     	
    		else {
        		setDx(0.0);
        	}
    	} 
    	else if (getPlayer().equals("player2")){
    	// horizontal direction for player 2
    		if (c2.isMoveLeft()) {
    			setDx(-speed);
    		}
    		else if (c2.isMoveRight()) {
    			setDx(speed);
    		}
    		else {
    			setDx(0.0);
    		}
    	}    	
		
    }
    
    @Override
    public void move() {
        super.move();
        // tank can't move outside of bounds set in init()
        checkBounds();
    }

    private void checkBounds() {
        // horizontal
        if(Double.compare(getX(), tankMinX) < 0.00) {
            setX(tankMinX);
        } 
        else if(Double.compare(getX(), tankMaxX) > 0.00) {
            setX(tankMaxX);
        }
    }
    
    public P1Controls getP1Controls() {
		return c1;
	}
	
	public P2Controls getP2Controls() {
		return c2;
	}
	
	public double getHealth() {
		return health;
	}
	
	public void setHealth(double health) {
		this.health = health;
	}
     
}