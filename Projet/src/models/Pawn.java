package models;

public class Pawn extends Piece {
    public Pawn(Board _board, Coordinate _coordinate, PieceColor _color){
        super(_board, _coordinate, PieceType.PAWN, _color);
    }

    public int[][] getMove() {
        int[][] moveBoard = board.getMoveBoard();

        moveBoard[coordinate.x][coordinate.y] = 1;

        Coordinate move = null;
        int sign = 0;

        if (color == PieceColor.WHITE)
            sign = -1;
        else
            sign = 1;

        if (nbMove == 0)
        {
            if (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 20] != -1)
            {
                move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + sign * 20]) % 10,
                                      (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 20]) / 10);
                if (board.pieceBoard(coordinate).getType() == PieceType.VOID && board.pieceBoard(new Coordinate(move.x, move.y - sign)).getType() == PieceType.VOID)
                {
                    moveBoard[move.x][move.y] = 2;
                }
            }
        }

        if (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 10] != -1)
        {
            move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + sign * 10]) % 10,
                                  (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 10]) / 10);
            if (board.pieceBoard(move).getType() == PieceType.VOID)
            {
                moveBoard[move.x][move.y] = 2;
            }
        }

        if (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 9] != -1)
        {
            move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + sign * 9]) % 10,
                                  (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 9]) / 10);
            if (color != board.pieceBoard(move).getColor() && board.pieceBoard(move).getType() != PieceType.VOID)
            {
                moveBoard[move.x][move.y] = 2;
            }
        }

        if (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 11] != -1)
        {
            move = new Coordinate((Tab120[Tab64[coordinate.x][coordinate.y] + sign * 11]) % 10,
                                  (Tab120[Tab64[coordinate.x][coordinate.y] + sign * 11]) / 10);
            if (color != board.pieceBoard(move).getColor() && board.pieceBoard(move).getType() != PieceType.VOID)
            {
                moveBoard[move.x][move.y] = 2;
            }
        }
        return moveBoard;
    }
}
