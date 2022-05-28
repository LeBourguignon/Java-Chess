package models;

public abstract class Piece implements Cloneable {
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
        {21, 22, 23, 24, 25, 26, 27, 28},
        {31, 32, 33, 34, 35, 36, 37, 38},
        {41, 42, 43, 44, 45, 46, 47, 48},
        {51, 52, 53, 54, 55, 56, 57, 58},
        {61, 62, 63, 64, 65, 66, 67, 68},
        {71, 72, 73, 74, 75, 76, 77, 78},
        {81, 82, 83, 84, 85, 86, 87, 88},
        {91, 92, 93, 94, 95, 96, 97, 98}
    };

    public Piece(Coordinate _coordinate, PieceType _type, PieceColor _color)
    {
        coordinate = _coordinate;
        type = _type;
        color = _color;
    }

    public PieceType getType() { return type; }
    public PieceColor getColor() { return color; }
    public Coordinate getCoordinate() { return coordinate; }

    public int getNbMove() { return nbMove; }

    public String toString() {
        return type + "/" + color /* + "(" + coordinate.x + ", " + coordinate.y + ")"*/;
    }

    public abstract int[][] getMove(Board board);

    public void moved(Coordinate _coordinate) {
        coordinate = _coordinate;
        ++nbMove;
    }

    public Piece clone() throws CloneNotSupportedException {
        return (Piece) super.clone();
    }
}
