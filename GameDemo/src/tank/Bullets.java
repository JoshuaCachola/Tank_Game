package tank;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Bullets extends Sprite {
	private ImageView imageView;
	private double speed;
	
	public Bullets(Pane layer, Image image, double x, double y, double dx, double dy, double speed) {
		super(layer, image, x, y, dx, dy, "");
		this.imageView = new ImageView(image);
		this.imageView.setFitWidth(1.0);
		this.imageView.setFitHeight(1.0);
		this.speed = speed;
	}
	
	@Override
	public void move() {
        setX(speed + getX());
    }
	
	public boolean checkCollision(Sprite sprite) {
		return (sprite.getX() + sprite.getWidth() >= super.getX() && sprite.getY() + sprite.getHeight() >= super.getY() && sprite.getX() <= super.getX() + super.getWidth() && sprite.getY() <= super.getY() + super.getHeight());
	}
		
}
		

