package models;

public abstract class Piece {
    protected Board board;
    protected Coordinate coordinate;
    protected PieceType type;
    protected PieceColor color;
    protected int nbMove = 0;

    protected int[] Tab120 = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1,  0,  1,  2,  3,  4,  5,  6,  7, -1,
        -1, 10, 11, 12, 13, 14, 15, 16, 17, -1,
        -1, 20, 21, 22, 23, 24, 25, 26, 27, -1,
        -1, 30, 31, 32, 33, 34, 35, 36, 37, -1,
        -1, 40, 41, 42, 43, 44, 45, 46, 47, -1,
        -1, 50, 51, 52, 53, 54, 55, 56, 57, -1,
        -1, 60, 61, 62, 63, 64, 65, 66, 67, -1,
        -1, 70, 71, 72, 73, 74, 75, 76, 77, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    };

    protected int[][] Tab64 = {
        {21, 31, 41, 51, 61, 71, 81, 91},
        {22, 32, 42, 52, 62, 72, 82, 92},
        {23, 33, 43, 53, 63, 73, 83, 93},
        {24, 34, 44, 54, 64, 74, 84, 94},
        {25, 35, 45, 55, 65, 75, 85, 95},
        {26, 36, 46, 56, 66, 76, 86, 96},
        {27, 37, 47, 57, 67, 77, 87, 97},
        {28, 38, 48, 58, 68, 78, 88, 98}
    };

    public Piece(Board _board,Coordinate _coordinate, PieceType _type, PieceColor _color)
    {
        board = _board;
        coordinate = _coordinate;
        type = _type;
        color = _color;
    }

    public PieceType getType() { return type; }
    public PieceColor getColor() { return color; }
    public Coordinate getCoordinate() { return coordinate; }

    public String toString() {
        return type + "/" + color + "(" + coordinate.x + ", " + coordinate.y + ")";
    }

    public abstract int[][] getMove();
    public void moved(Coordinate _coordinate) {
        coordinate = _coordinate;
        ++nbMove;
    }
}
