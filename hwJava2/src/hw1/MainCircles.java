package hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainCircles extends JFrame {

    private static final int POS_X = Toolkit.getDefaultToolkit().getScreenSize().width / 4;
    private static final int POS_Y = Toolkit.getDefaultToolkit().getScreenSize().height / 4;
    private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
    private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height / 2;

    Sprite[] sprites = new Sprite[10];
    Background background;

    public static void main(String[] args) {
        new MainCircles();
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Sprite[] tmp;
                if (e.getButton() == MouseEvent.BUTTON1) { // Left mouse button - add circle
                    tmp = Arrays.copyOf(sprites, sprites.length + 1);
                    tmp[tmp.length - 1] = new Ball();
                    sprites = Arrays.copyOf(tmp, tmp.length);
                } else if (e.getButton() == MouseEvent.BUTTON3 && sprites.length > 0) { // RMB - delete
                    sprites = Arrays.copyOf(sprites, sprites.length - 1);
                }

            }
        });

        initApplication();
        add(canvas);
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        background = new Background();
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        background.update();

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        background.render(canvas, g);

        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}