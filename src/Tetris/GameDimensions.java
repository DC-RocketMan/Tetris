package Tetris;

public enum GameDimensions {
    FULL_HD(1920, 1080, 30, 810, 100),
    HD(1280, 720, 20, 540, 100);

    private final int windowWidth;
    private final int windowHeight;
    private final int tetrominoLength;
    private final int printStartX;
    private final int printStartY;

    GameDimensions(int windowWidth, int windowHeight, int tetrominoLength, int printStartX, int printStartY) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.tetrominoLength = tetrominoLength;
        this.printStartX = printStartX;
        this.printStartY = printStartY;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getTetrominoLength() {
        return tetrominoLength;
    }

    public int getPrintStartX() {
        return printStartX;
    }

    public int getPrintStartY() {
        return printStartY;
    }
}
