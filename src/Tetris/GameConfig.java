package Tetris;

public record GameConfig(
        Map map,
        int startPosX,
        int startPosY,
        GameDimensions dimensions
) {}
