package tank;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bullets extends Sprite {
	private double speed;
	private double damage;
	private double bulletMaxX;
	private double bulletMinX;
	private double bulletMinY;
	private double bulletMaxY;
	
	public Bullets(Pane layer, Image image, double x, double y, double dx, double dy, double speed, double damage) {
		super(layer, image, x, y, dx, dy, "");
		this.speed = speed;
		this.damage = damage;
		createBounds();
	}
	
	private void createBounds() {
		this.bulletMinX = 0 - this.getWidth();
		this.bulletMaxX = Settings.SCENE_WIDTH + this.getWidth();
		this.bulletMinY = 0 - this.getHeight();
		this.bulletMaxY = Settings.SCENE_HEIGHT + this.getHeight();
	}
	
	@Override
	public void move() {
        setX(speed + getX());
    }
	
	public double getDamage() {
		return damage;
	}
}
		

