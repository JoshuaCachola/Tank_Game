package tank;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Joshua
 *
 */
public class Sprite {
    private Image image;
    private ImageView imageView;
    private Pane layer;
    private String player;

    private double x;
    private double y;

    private double dx;
    private double dy;


    private double w;
    private double h;

    private boolean canMove = true;

    public Sprite(Pane layer, Image image, double x, double y, double dx, double dy, String player) {
        this.layer = layer;
        this.image = image;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;

        this.setPlayer(player);

        this.imageView = new ImageView(image);
        this.imageView.relocate(x, y);

        this.w = image.getWidth();
        this.h = image.getHeight();

        addToLayer();
    }

    public void addToLayer() {
        this.layer.getChildren().add(this.imageView);
    }
    
    //used to remove sprite
    public void removeFromLayer() {
        this.layer.getChildren().remove(this.imageView);
    }

    public Pane getLayer() {
        return layer;
    }

    public void setLayer(Pane layer) {
        this.layer = layer;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void move() {
        if(!canMove)
            return;

        setX(getDx() + getX());
        setY(getDy() + getY());
    }
    
    public ImageView getView() {
        return imageView;
    }

    public void updateUI() {
        imageView.relocate(x, y);
    }

    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return h;
    }

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
    
}