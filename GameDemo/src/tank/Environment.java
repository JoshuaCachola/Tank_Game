package tank;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Joshua
 *
 */
public class Environment extends Sprite {

	public Environment(Pane layer, Image image, double x, double y, double dx, double dy, double r, double changeR) {
		super(layer, image, x, y, dx, dy, "", r, changeR);
	}

}
