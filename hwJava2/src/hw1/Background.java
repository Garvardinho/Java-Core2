package hw1;

import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {
    private Color color;
    private byte red;
    private byte redSign;
    private byte green;
    private byte greenSign;
    private byte blue;
    private byte blueSign;

    Background() {
        red = 127;
        green = 127;
        blue = 127;
        redSign = -1;
        greenSign = -1;
        blueSign = -1;
    }

    void update() {
        // This variables change color transform speed, so you can "play" with them and find your own gradient
        final byte RED_DELTA = 1;
        final byte GREEN_DELTA = 2;
        final byte BLUE_DELTA = 3;

        color = new Color(red + 128, green + 128, blue + 128);
        red += (RED_DELTA * redSign);
        green += (GREEN_DELTA * greenSign);
        blue += (BLUE_DELTA * blueSign);

        if (red > 120)
            redSign = -1;
        else if (red < -120)
            redSign = 1;

        if (green > 120)
            greenSign = -1;
        else if (green < -120)
            greenSign = 1;

        if (blue > 120)
            blueSign = -1;
        else if (blue < -120)
            blueSign = 1;
    }

    void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillRect(canvas.getX(), canvas.getY(), canvas.getWidth(), canvas.getHeight());
    }
}
