package tank;

import java.util.BitSet;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
/**
 * 
 * @author Joshua
 *
 */
public class P2Controls {
    private BitSet keyboard = new BitSet();

    private KeyCode p2LeftKey = KeyCode.LEFT;
    private KeyCode p2RightKey = KeyCode.RIGHT;
    private KeyCode fire = KeyCode.SPACE;
    
    Scene scene;

    public P2Controls(Scene scene) {
        this.scene = scene;
    }

    public void addEventListeners() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }

    public void removeEventListeners() {
        scene.removeEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.removeEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
    }
    
    private EventHandler<KeyEvent> keyPressedEventHandler = new EventHandler<KeyEvent>() {
    	@Override
    	public void handle(KeyEvent e) {
    		keyboard.set(e.getCode().ordinal(), true);
    	}
    };
    	
    private EventHandler<KeyEvent> keyReleasedEventHandler = new EventHandler<KeyEvent>() {
    	@Override
    	public void handle(KeyEvent e) {
    		keyboard.set(e.getCode().ordinal(), false);
    	}
    };

    public boolean isMoveLeft() {
        return keyboard.get(p2LeftKey.ordinal()) && !keyboard.get(p2RightKey.ordinal());  
    }

    public boolean isMoveRight() {
        return keyboard.get(p2RightKey.ordinal()) && !keyboard.get(p2LeftKey.ordinal());
    }
    
    public boolean isFire() {
        return keyboard.get(fire.ordinal());
    }
     
}    