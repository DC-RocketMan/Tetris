package Tetris;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameOrganizer {

    private Map map;
    private int startPosX;
    private int startPosY;
    private Tetromino tetromino;
    private List<Tetromino> deadTetrominos;
    private Collision collision;
    private GameDimensions dimensions;
    private int placingCounter;
    private boolean gameStopped;
    private Points points;

    public GameOrganizer(GameConfig gameConfig) {
        this.dimensions = gameConfig.dimensions();
        this.map = gameConfig.map();
        this.startPosX = gameConfig.startPosX();
        this.startPosY = gameConfig.startPosY();
        this.tetromino = getNewTetromino();
        this.deadTetrominos = new ArrayList<>();
        this.collision = new Collision(this);
        this.placingCounter = 0;
        this.gameStopped = false;
        this.points = new Points();
    }

    public void moveDown() {
        if (!collision.checkMoveDown()) {
            if (placingCounter != 0) {
                map.integrateTetromino(tetromino);
                int count = map.removeFullRows();
                points.addPoints(count);
                deadTetrominos.add(tetromino);
                tetromino = getNewTetromino();
                if (!collision.checkMove()) {
                    gameStopped = true;
                }
                placingCounter = 0;
                return;
            }
            placingCounter++;
        }
    }

    public void moveLeft() {
        collision.checkMoveLeft();
    }

    public void moveRight() {
        collision.checkMoveRight();
    }

    public void rotateRight() {
        collision.checkRotateRight();
    }


    public void paintGame(Graphics2D graphics2D) {
        map.paintMap(graphics2D);
        tetromino.paintTetromino(graphics2D);
        points.paintPoints(graphics2D);
    }


    public Map getMap() {
        return map;
    }
    public Tetromino getTetromino() {
        return tetromino;
    }
    public boolean isGameStopped() {
        return gameStopped;
    }

    private Tetromino getNewTetromino() {
        int randomVar = (int)(Math.random() * 6);
        return new Tetromino(startPosX, startPosY, randomVar, dimensions);
    }
}
