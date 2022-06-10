package models;

public class King extends Piece{
    private final int[] displacementVectors = {-11, -10, -9, -1, 1, 9, 10, 11};

    public King(Coordinate _coordinate, PieceColor _color){
        super(_coordinate, PieceType.KING, _color);
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
        
        if (nbMove != 0);
        else {
            if (board.getPieceBoard()[coordinate.x][coordinate.y + 1].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y + 2].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y + 3].getType() == PieceType.ROOK && board.getPieceBoard()[coordinate.x][coordinate.y + 3].getNbMove() == 0)
                moveBoard[coordinate.x][coordinate.y + 2] = 3;
            if (board.getPieceBoard()[coordinate.x][coordinate.y - 1].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y - 2].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y - 3].getType() == PieceType.VOID && board.getPieceBoard()[coordinate.x][coordinate.y - 4].getType() == PieceType.ROOK && board.getPieceBoard()[coordinate.x][coordinate.y - 4].getNbMove() == 0)
                moveBoard[coordinate.x][coordinate.y - 2] = 4;
        }


        return moveBoard;
    }
}
