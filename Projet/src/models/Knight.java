package models;

public class Knight extends Piece{
    private int[] displacementVectors = {-21, -19, -12, -8, 8, 12, 19, 21};

    public Knight(Board _board, Coordinate _coordinate, PieceColor _color){
        super(_board, _coordinate, PieceType.KNIGHT, _color);
    }

    public int[][] getMove() {
        int[][] moveBoard = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };

        moveBoard[coordinate.x][coordinate.y] = 1;

        for (int i = 0; i < displacementVectors.length; i++) {
            if (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVectors[i]] != -1)
            {
                Coordinate move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + displacementVectors[i]]) % 10,
                        (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVectors[i]]) / 10);
                if (color != board.pieceBoard(move).getColor())
                {
                    moveBoard[move.x][move.y] = 2;
                }
            }
        }

        return moveBoard;
    }
}
