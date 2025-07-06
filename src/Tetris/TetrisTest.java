package Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TetrisTest extends JPanel {
    private GameDimensions dimensions;
    private GameOrganizer gameOrganizer;
    private int counter;
    private Timer timer;

    public TetrisTest(GameDimensions dimensions) {
        this.dimensions = dimensions;
        this.counter = 0;
        this.gameOrganizer = new GameOrganizer(new GameConfig(new Map(40, 20, dimensions), 4 + 5, 0 + 11, dimensions));


        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "Left Arrow");
        getActionMap().put("Left Arrow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOrganizer.moveLeft();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "Right Arrow");
        getActionMap().put("Right Arrow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOrganizer.moveRight();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "Down Arrow");
        getActionMap().put("Down Arrow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOrganizer.moveDown();
            }
        });

        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "Up Arrow");
        getActionMap().put("Up Arrow", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameOrganizer.rotateRight();
            }
        });


        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update();
                repaint();
            }
        });
        timer.start();
    }


    public void update() {
        if (counter % 6 == 0) {
            gameOrganizer.moveDown();
        }
        if (gameOrganizer.isGameStopped()) {
            timer.stop();
        }
        counter++;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setColor(new Color(14,30,43));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());

        graphics2D.setColor(Color.LIGHT_GRAY);
        graphics2D.fillRect(dimensions.getPrintStartX(), 100, 10 * dimensions.getTetrominoLength(), 20 * dimensions.getTetrominoLength());
        //graphics2D.setColor(Color.GREEN);
        //graphics2D.fillRect(810, 100, 30, 30);
        gameOrganizer.paintGame(graphics2D);

        for (int i = 0; i < 11; i++) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.fillRect(dimensions.getPrintStartX() + i * dimensions.getTetrominoLength() - 1, 100, 1, 20 * dimensions.getTetrominoLength());
        }
        for (int i = 0; i < 21; i++) {
            graphics2D.setColor(Color.GRAY);
            graphics2D.fillRect(dimensions.getPrintStartX(), 100 + i * dimensions.getTetrominoLength(), 10 * dimensions.getTetrominoLength(), 1);
        }

        if (gameOrganizer.isGameStopped()) {
            graphics2D.setColor(Color.RED);
            graphics2D.setFont(new Font("Arial", Font.BOLD, dimensions.getTetrominoLength()*2));
            graphics2D.drawString("GAME OVER", dimensions.getPrintStartX()-20, 100 + 10*dimensions.getTetrominoLength());
        }


        /*Map map = gameOrganizer.getMap();
        Tetromino tetromino = gameOrganizer.getTetromino();

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {

                if ((j >= tetromino.getX() && j < tetromino.getX()+tetromino.getForm()[0].length)
                        && (i >= tetromino.getY() && i < tetromino.getY()+tetromino.getForm().length)) {
                    System.out.println("i: " + i);
                    System.out.println("j: " + j);
                    System.out.println("itransform: " + (tetromino.getY()));
                    System.out.println("jtransform: " + (tetromino.getX()));
                    System.out.println("ialt: " + (i- tetromino.getY()));
                    System.out.println("jalt: " + (j- tetromino.getX()));
                    System.out.print(tetromino.getForm()[i- tetromino.getY()][j- tetromino.getX()] + " ");
                } else {
                    System.out.print(map.getGameField()[i][j] + " ");
                }

            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();*/
    }


}
