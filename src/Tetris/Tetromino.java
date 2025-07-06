package Tetris;

import java.awt.*;

public class Tetromino {

    private int x;
    private int y;
    private int paintX;
    private int paintY;
    private char[][] form;
    private Color color;
    private GameDimensions dimensions;

    public Tetromino(int x, int y, int id, GameDimensions dimensions) {
        this.x = x;
        this.y = y;
        this.paintX = x-5;
        this.paintY = y-10;
        this.form = initForm(TetrominoForm.fromId(id).getForm());
        this.color = TetrominoForm.fromId(id).getColor();
        this.dimensions = dimensions;
    }

    public void moveTetrominoDown() {
        this.y += 1;
        this.paintY += 1;
    }
    public void reverseMoveTetrominoDown() {
        this.y -= 1;
        this.paintY -= 1;
    }

    public void moveTetrominoLeft() {
        this.x -= 1;
        this.paintX -= 1;
    }
    public void moveTetrominoRight() {
        this.x += 1;
        this.paintX += 1;
    }

    public void rotateTetrominoRight() {
        char[][] tempForm = initForm(form);

        for (int i = 0, q = 0; i < form.length; i++, q++) {
            for (int j = 0, p = form.length -1; j < form[0].length; j++, p--) {
                form[i][j] = tempForm[p][q];
            }
        }
    }
    public void rotateTetrominoLeft() {
        char[][] tempForm = initForm(form);

        for (int i = 0, q = form[0].length -1; i < form.length; i++, q--) {
            for (int j = 0, p = 0; j < form[0].length; j++, p++) {
                form[i][j] = tempForm[p][q];
            }
        }
    }

    public void paintTetromino(Graphics2D graphics2D) {
        int printX;
        int printY;
        for (int i = 0; i < form.length; i++) {
            for (int j = 0; j < form[0].length; j++) {
                if (form[i][j] != '.') {
                    printX = dimensions.getPrintStartX() + (paintX+j) * dimensions.getTetrominoLength();
                    printY = dimensions.getPrintStartY() + (paintY+i) * dimensions.getTetrominoLength();
                    graphics2D.setColor(color);
                    graphics2D.fillRect(printX, printY, dimensions.getTetrominoLength(), dimensions.getTetrominoLength());
                }
            }
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public char[][] getForm() {
        return form;
    }

    private char[][] initForm(char[][] originalForm) {
        char[][] form = new char[originalForm.length][originalForm[0].length];
        for (int i = 0; i < form.length; i++) {
            for (int j = 0; j < form[0].length; j++) {
                form[i][j] = originalForm[i][j];
            }
        }
        return form;
    }




















    /*public static void main(String[] args) {
        Tetromino tetromino = new Tetromino(1, 1, 2);
        for (int i = 0; i < tetromino.getForm().length; i++) {
            for (int j = 0; j < tetromino.getForm()[0].length; j++) {
                System.out.print(tetromino.getForm()[i][j] + " ");
            }
            System.out.println();
        }
    }*/
}
