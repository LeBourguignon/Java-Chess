package models;

public class King extends Piece{
    private final int[] displacementVectors = {-11, -10, -9, -1, 1, 9, 10, 11};

    public King(Board _board, Coordinate _coordinate, PieceColor _color){
        super(_board, _coordinate, PieceType.KING, _color);
    }

    public int[][] getMove() {
        int[][] moveBoard = board.getMoveBoard();

        moveBoard[coordinate.x][coordinate.y] = 1;

        for (int displacementVector : displacementVectors) {
            if (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector] != -1) {
                Coordinate move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) % 10,
                        (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) / 10);
                if (color != board.pieceBoard(move).getColor()) {
                    moveBoard[move.x][move.y] = 2;
                }
            }
        }

        return moveBoard;
    }
}
