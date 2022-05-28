package models;

public class Void extends Piece{
    public Void(Coordinate _coordinate){
        super(_coordinate, PieceType.VOID, PieceColor.NONE);
    }

    public int[][] getMove(Board board) {
        return null;
    }
}
