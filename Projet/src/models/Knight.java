package models;

public class Knight extends Piece{
    private final int[] displacementVectors = {-21, -19, -12, -8, 8, 12, 19, 21};

    public Knight(Coordinate _coordinate, PieceColor _color){
        super(_coordinate, PieceType.KNIGHT, _color);
    }

    public int[][] getMove(Board board) {
        int[][] moveBoard = board.getMoveBoard();

        moveBoard[coordinate.x][coordinate.y] = 1;

        for (int displacementVector : displacementVectors) {
            if (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector] != -1) {
                Coordinate move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) / 10,
                        (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) % 10);
                if (color != board.pieceBoard(move).getColor()) {
                    moveBoard[move.x][move.y] = 2;
                }
            }
        }
        //Castling TODO
        return moveBoard;
    }
}
