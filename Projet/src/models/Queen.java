package models;

import java.util.Arrays;

public class Queen extends Piece{
    private final int[] displacementVectors = {-11, -10, -9, -1, 1, 9, 10, 11};

    public Queen(Coordinate _coordinate, PieceColor _color){
        super(_coordinate, PieceType.QUEEN, _color);
    }

    public int[][] getMove(Board board) {
        int[][] moveBoard = board.getMoveBoard();

        moveBoard[coordinate.x][coordinate.y] = 1;

        for (int vector : displacementVectors) {
            if (Tab120[Tab64[coordinate.x][coordinate.y] + vector] != -1) {
                int displacementVector = vector;
                Coordinate move = null;
                do {
                    move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) / 10,
                            (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) % 10);
                    if (color != board.pieceBoard(move).getColor()) {
                        moveBoard[move.x][move.y] = 2;
                        displacementVector += vector;
                    }
                } while (board.pieceBoard(move).getType() == PieceType.VOID && Tab120[Tab64[move.x][move.y] + vector] != -1);
            }
        }

        return moveBoard;
    }
}