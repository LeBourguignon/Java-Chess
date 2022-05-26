package models;

public class Queen extends Piece{
    private int[] displacementVectors = {-11, -10, -9, -1, 1, 9, 10, 11};

    public Queen(Board _board, Coordinate _coordinate, PieceColor _color){
        super(_board, _coordinate, PieceType.QUEEN, _color);
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

        for (int i = 0; i < displacementVectors.length; ++i) {
            if (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVectors[i]] != -1)
            {
                int displacementVector = displacementVectors[i];
                Coordinate move = null;
                do
                {
                    move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) % 10,
                                          (Tab120[Tab64[coordinate.x][coordinate.y] + displacementVector]) / 10);
                    if (color != board.pieceBoard(move).getColor())
                    {
                        moveBoard[move.x][move.y] = 2;
                        displacementVector += displacementVectors[i];
                    }
                } while (board.pieceBoard(move).getType() == PieceType.VOID && Tab120[Tab64[move.x][move.y] + displacementVector] != -1);
            }
        }

        return moveBoard;
    }
}