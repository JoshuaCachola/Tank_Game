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
public class P1Controls {
    private KeyCode p1LeftKey;
    private KeyCode p1RightKey;
    private KeyCode p1UpKey;
    private KeyCode p1DownKey;
    private KeyCode fire;
    private KeyCode p1RotateUp;
    private KeyCode p1RotateDown;

    private Scene scene;  
    private BitSet keyboard;
    
    public P1Controls(Scene scene) {
        this.scene = scene;
        this.keyboard = new BitSet();
        this.p1LeftKey = KeyCode.A;
        this.p1RightKey = KeyCode.D;
        this.p1UpKey = KeyCode.W;
        this.p1DownKey = KeyCode.S;
        this.fire = KeyCode.F;
        this.p1RotateUp = KeyCode.E;
        this.p1RotateDown = KeyCode.X;
    }

    public void addEventListeners() {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyPressedEventHandler);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyReleasedEventHandler);
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
        return keyboard.get(p1LeftKey.ordinal()) && !keyboard.get(p1RightKey.ordinal());  
    }

    public boolean isMoveRight() {
        return keyboard.get(p1RightKey.ordinal()) && !keyboard.get(p1LeftKey.ordinal());
    }

    public boolean isFire() {
        return keyboard.get(fire.ordinal());
    }
    
    public boolean isMoveUp() {
        return keyboard.get(p1UpKey.ordinal()) && !keyboard.get(p1DownKey.ordinal());
    }
    
    public boolean isMoveDown() {
        return keyboard.get(p1DownKey.ordinal()) && !keyboard.get(p1UpKey.ordinal());
    }
    
    public boolean isRotateUp() {
        return keyboard.get(p1RotateUp.ordinal()) && !keyboard.get(p1RotateDown.ordinal());
    }
    
    public boolean isRotateDown() {
        return keyboard.get(p1RotateDown.ordinal()) && !keyboard.get(p1RotateUp.ordinal());
    }
    
}