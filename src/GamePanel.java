import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    private final int WIDTH = 800, HEIGHT = 600;
    private final int FPS = 60;
    private Timer timer;
    private Player player;
    private ArrayList<Collectible> collectibles;
    private int score = 0;
    private final int totalCircles = 5;
    private boolean gameOver = false;


    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocusInWindow();

        player = new Player(100, 100);
        collectibles = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < totalCircles; i++) {
            int x = rand.nextInt(750); // keeping within bounds
            int y = rand.nextInt(550);
            collectibles.add(new Collectible(x, y, 10));
        }

        addKeyListener(new KeyInput());
    }

    public void startGame() {
        timer = new Timer(1000 / FPS, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        player.update();
        for (Collectible c : collectibles) {
            if (!c.collected && c.checkCollision(player.x, player.y, 32, 32)) {
                c.collected = true;
                score++;
                if (score == totalCircles) {
                    gameOver = true;
                    timer.stop();
                }
            }
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.render(g);

        for (Collectible c : collectibles) {
            c.render(g);
        }

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 10, 20);

        if (gameOver) {
            g.setColor(Color.GREEN);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("You Win!", 300, 300);
        }

    }
}
