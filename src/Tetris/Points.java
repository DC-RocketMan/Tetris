package Tetris;

import java.awt.*;

public class Points {

    private int points;

    public Points() {
        this.points = 0;
    }


    public void paintPoints(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(new Font("Arial", Font.BOLD, 50));
        graphics2D.drawString("" + points, 75, 75);
    }


    public void addPoints(int count) {
        count *= count;
        count *= 100;

        points += count;
    }


    public int getPoints() {
        return points;
    }
}
