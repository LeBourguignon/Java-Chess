package models;

public class Rook extends Piece{
    private final int[] displacementVectors = {-10, -1, 1, 10};

    public Rook(Coordinate _coordinate, PieceColor _color){
        super(_coordinate, PieceType.ROOK, _color);
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
                } while (board.pieceBoard(move).getType() == PieceType.VOID && Tab120[Tab64[move.x][move.y] + displacementVector] != -1);
            }
        }

        if (nbMove != 0);
        else if (coordinate.y == 7)
            if (board.getPieceBoard()[coordinate.x][coordinate.y - 1].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y - 2].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y - 3].getType() == PieceType.KING && board.getPieceBoard()[coordinate.x][coordinate.y - 3].getNbMove() == 0)
                moveBoard[coordinate.x][coordinate.y - 2] = 3;
        else if (coordinate.y == 0)
            if (board.getPieceBoard()[coordinate.x][coordinate.y + 1].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y + 2].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y + 3].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y + 4].getType() == PieceType.KING && board.getPieceBoard()[coordinate.x][coordinate.y + 4].getNbMove() == 0)
                moveBoard[coordinate.x][coordinate.y + 3] = 4;

        return moveBoard;
    }
}
