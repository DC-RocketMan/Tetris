package Tetris;

public class Collision {

    private GameOrganizer gameOrganizer;

    public Collision(GameOrganizer gameOrganizer) {
        this.gameOrganizer = gameOrganizer;
    }

    public boolean checkTetrominoCollision() {
        Tetromino tetromino = gameOrganizer.getTetromino();
        char[][] tetrominoForm = tetromino.getForm();
        char[][] map = gameOrganizer.getMap().getGameField();

        for (int i = 0; i < tetromino.getForm().length; i++) {
            //System.out.println(i);
            //System.out.println();
            for (int j = 0; j < tetromino.getForm()[0].length; j++) {
                //System.out.println(i+ tetromino.getY() + 1);
                if (map[i + tetromino.getY()][j + tetromino.getX()] != '.' &&  tetrominoForm[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkMapBounds() {
        Tetromino tetromino = gameOrganizer.getTetromino();
        char[][] tetrominoForm = tetromino.getForm();

        for (int i = 0; i < tetrominoForm.length; i++) {
            for (int j = 0; j < tetrominoForm[0].length; j++) {
                if ((tetrominoForm[i][j] != '.') && (tetromino.getY() + i >= 30)) {
                    return false;
                }
                if ((tetrominoForm[i][j] != '.') && (tetromino.getX() + j < 5)) {
                    return false;
                }
                if ((tetrominoForm[i][j] != '.') && (tetromino.getX() + j > 14)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkMove() {
        return checkTetrominoCollision() && checkMapBounds();
    }

    public boolean checkMoveDown() {
        gameOrganizer.getTetromino().moveTetrominoDown();
        boolean checkedMove = checkMove();
        if (checkedMove) {
            return checkedMove;
        }
        gameOrganizer.getTetromino().reverseMoveTetrominoDown();
        return checkedMove;
    }

    public boolean checkMoveLeft() {
        gameOrganizer.getTetromino().moveTetrominoLeft();
        boolean checkedMove = checkMove();
        if (checkedMove) {
            return checkedMove;
        }
        gameOrganizer.getTetromino().moveTetrominoRight();
        return checkedMove;
    }

    public boolean checkMoveRight() {
        gameOrganizer.getTetromino().moveTetrominoRight();
        boolean checkedMove = checkMove();
        if (checkedMove) {
            return checkedMove;
        }
        gameOrganizer.getTetromino().moveTetrominoLeft();
        return checkedMove;
    }

    public boolean checkRotateRight() {
        gameOrganizer.getTetromino().rotateTetrominoRight();
        boolean checkedMove = checkMove();
        if (checkedMove) {
            return checkedMove;
        }
        gameOrganizer.getTetromino().rotateTetrominoLeft();
        return checkedMove;
    }

}
