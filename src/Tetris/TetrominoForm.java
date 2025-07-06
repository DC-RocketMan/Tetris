package Tetris;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Objects;

public enum TetrominoForm {
    I(0, new char[][]{{'.', '.', '.', '.'}, {'i', 'i', 'i', 'i'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}}, new Color(0, 240, 240), 'i'),
    O(1, new char[][]{{'o', 'o'}, {'o', 'o'}}, new Color(241, 239, 47), 'o'),
    L(2, new char[][]{{'.', '.', 'l'}, {'l', 'l', 'l'}, {'.', '.', '.'}}, new Color(221, 164, 34), 'l'),
    J(3, new char[][]{{'j', '.', '.'}, {'j', 'j', 'j'}, {'.', '.', '.'}}, new Color(0, 0, 240), 'j'),
    S(4, new char[][]{{'.', 's', 's'}, {'s', 's', '.'}, {'.', '.', '.'}}, new Color(138, 234, 40), 's'),
    Z(5, new char[][]{{'z', 'z', '.'}, {'.', 'z', 'z'}, {'.', '.', '.'}}, new Color(207, 54, 22), 'z'),
    T(6, new char[][]{{'.', 't', '.'}, {'t', 't', 't'}, {'.', '.', '.'}}, new Color(136, 33, 237), 't');

    private final int id;
    private final char[][] form;
    private final Color color;
    private final char character;

    TetrominoForm(int id, char[][] form, Color color, char character) {
        this.id = id;
        this.form = form;
        this.color = color;
        this.character = character;
    }

    public static TetrominoForm fromId(int id) {
        for (TetrominoForm type : TetrominoForm.values()) {
            if (Objects.equals(type.getId(), id)) {
                return type;
            }
        }
        throw new NoSuchElementException("Wrong id man");
    }

    public static Color fromCharacter(char character) {
        for (TetrominoForm type : TetrominoForm.values()) {
            if (Objects.equals(type.getCharacter(), character)) {
                return type.getColor();
            }
        }
        throw new NoSuchElementException("Wrong char man");
    }

    public int getId() {
        return id;
    }

    public char[][] getForm() {
        return form;
    }

    public Color getColor() {
        return color;
    }

    public char getCharacter() {
        return character;
    }
}
