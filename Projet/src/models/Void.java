package models;

public class Void extends Piece{
    public Void(Board _board, Coordinate _coordinate){
        super(_board, _coordinate, PieceType.VOID, PieceColor.NONE);
    }

    public int[][] getMove() {
        return null;
    }
}
