package Tetris;

import java.awt.*;

public class Map {
    private int gameHeight;
    private int gameWidth;
    private GameDimensions dimensions;
    private char[][] gameField;

    public Map(int gameHeight, int gameWidth, GameDimensions dimensions) {
        this.dimensions = dimensions;
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        this.gameField = initGameField(gameHeight, gameWidth);
    }

    public void paintMap(Graphics2D graphics2D) {
        int printX;
        int printY;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (gameField[i+10][j+5] != '.') {
                    printX = dimensions.getPrintStartX() + j * dimensions.getTetrominoLength();
                    printY = dimensions.getPrintStartY() + i * dimensions.getTetrominoLength();
                    graphics2D.setColor(TetrominoForm.fromCharacter(gameField[i+10][j+5]));
                    graphics2D.fillRect(printX, printY, dimensions.getTetrominoLength(), dimensions.getTetrominoLength());
                }
            }
        }
    }



    public int getGameHeight() {
        return gameHeight;
    }
    public int getGameWidth() {
        return gameWidth;
    }
    public char[][] getGameField() {
        return gameField;
    }

    public void integrateTetromino(Tetromino tetromino) {
        char[][] tetrominoForm = tetromino.getForm();
        for (int i = tetromino.getY(); i < tetromino.getY() + tetrominoForm.length; i++) {
            for (int j = tetromino.getX(); j < tetromino.getX() + tetrominoForm[0].length; j++) {
                if (tetrominoForm[i - tetromino.getY()][j - tetromino.getX()] != '.') {
                    gameField[i][j] = tetrominoForm[i - tetromino.getY()][j - tetromino.getX()];
                }
            }
        }
    }

    public int removeFullRows() {
        int row;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            row = checkFilledRow();
            if (row != -1) {
                removeRow(row);
                count++;
            }
        }
        return count;
    }

    private void removeRow(int row) {
        for (int i = row; i > 9; i--) {
            for (int j = 5; j < 15; j++) {
                gameField[i][j] = gameField[i-1][j];
            }
        }
    }

    private int checkFilledRow() {
        int row = -1;
        for (int i = 10; i < gameField.length -10; i++) {
            for (int j = 5; j < gameField[0].length -5; j++) {
                if (gameField[i][j] == '.') {
                    break;
                }
                if (j == 14) {
                    row = i;
                }
            }
            if (row != -1) {
                break;
            }
        }
        return row;
    }

    private char[][] initGameField(int gameHeight, int gameWidth) {
        char[][] gameField = new char[gameHeight][gameWidth];
        for (int i = 0; i < gameHeight; i++) {
            for (int j = 0; j < gameWidth; j++) {
                gameField[i][j] = '.';
            }
        }
        return gameField;
    }
}
