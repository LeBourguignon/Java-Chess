package models;

public class Void extends Piece{
    public Void(Coordinate coordinate){
        super(coordinate, PieceType.VOID, PieceColor.NONE);
    }

    public int[][] getMove(Board board) {
        return null;
    }
}
