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
    private double tankMinY;
    private double tankMaxY;

    private P1Controls c1;
    private P2Controls c2;

    private double speed;
    private double health;

    public TankModel(Pane playerlayer, Image image, double x, double y, double  changeX, double changeY, double health, double speed, P1Controls c1, P2Controls c2, String player) {
        super(playerlayer, image, x, y, changeX, changeY, player);
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
    	
    	tankMinY = 0 - (this.getImage().getHeight() / 2);
    	tankMaxY = Settings.SCENE_HEIGHT * .85;
    }

    public void processInput() {
    	if (getPlayer().equals("player1")) {
        // horizontal direction for player 1
    		if (c1.isMoveLeft()) {
    			setChangeX(-speed);
        	} 
    		else if (c1.isMoveRight()) {
        		setChangeX(speed);
        	}  
    		else if (c1.isMoveUp()) {
        		setChangeY(-(speed / 2));
        	}
    		else if (c1.isMoveDown()) {
        		setChangeY(speed / 2);
        	}
    		else {
        		setChangeX(0.0);
        		setChangeY(0.0);
        	}
    	} 
    	else if (getPlayer().equals("player2")){
    	// horizontal direction for player 2
    		if (c2.isMoveLeft()) {
    			setChangeX(-speed);
    		}
    		else if (c2.isMoveRight()) {
    			setChangeX(speed);
    		}
    		else if (c2.isMoveUp()) {
        		setChangeY(-(speed / 2));
        	}
    		else if (c2.isMoveDown()) {
        		setChangeY(speed / 2);
        	}
    		else {
    			setChangeX(0.0);
    			setChangeY(0.0);
    		}
    	}    			
    }
    
    @Override
    public void move() {
        super.move();
        // tank can't move outside of bounds set in init()
        checkBounds();
    }

    public void checkBounds() {  
        if (Double.compare(getX(), tankMinX) < 0.00) {
            setX(tankMinX);
        } 
        else if (Double.compare(getX(), tankMaxX) > 0.00) {
            setX(tankMaxX);
        }
        
        if (Double.compare(getY(), tankMinY) < 0.00) {
        	setY(tankMinY);
        }
        else if (Double.compare(getY(), tankMaxY) > 0.00) {
        	setY(tankMaxY);
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
	
	public double getTankMaxY() {
		return tankMaxY;
	}
	
	public double getTankMinY() {
		return tankMinY;
	}
     
}