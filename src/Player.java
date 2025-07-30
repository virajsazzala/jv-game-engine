import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Player extends GameObject {
    public Player(int x, int y) {
        super(x, y);
    }

    public void update() {
        velX = 0;
        velY = 0;

        if (KeyInput.keysPressed.contains(KeyEvent.VK_W)) velY = -3;
        if (KeyInput.keysPressed.contains(KeyEvent.VK_S)) velY = 3;
        if (KeyInput.keysPressed.contains(KeyEvent.VK_A)) velX = -3;
        if (KeyInput.keysPressed.contains(KeyEvent.VK_D)) velX = 3;

        x += velX;
        y += velY;
    }

    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 32, 32);
    }
}
