package Tetris;

import javax.swing.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        GameDimensions dimensions = GameDimensions.FULL_HD;
        JFrame frame = new JFrame("Tetris test");
        TetrisTest panel = new TetrisTest(dimensions);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(dimensions.getWindowWidth(), dimensions.getWindowHeight());
        frame.setVisible(true);
    }
}
