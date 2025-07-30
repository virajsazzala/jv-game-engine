import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Collectible {
    public int x, y, radius;
    public boolean collected = false;

    public Collectible(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void render(Graphics g) {
        if (!collected) {
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, radius * 2, radius * 2);
        }
    }

    public boolean checkCollision(int px, int py, int pw, int ph) {
        Rectangle playerRect = new Rectangle(px, py, pw, ph);
        Rectangle circleRect = new Rectangle(x, y, radius * 2, radius * 2);
        return playerRect.intersects(circleRect);
    }
}
