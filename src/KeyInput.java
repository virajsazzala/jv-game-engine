import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class KeyInput implements KeyListener {
    public static final Set<Integer> keysPressed = new HashSet<>();

    public void keyPressed(KeyEvent e) {
        keysPressed.add(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {
        keysPressed.remove(e.getKeyCode());
    }

    public void keyTyped(KeyEvent e) {}
}
