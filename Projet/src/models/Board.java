package models;

public class Board {
    private Piece[][] pieceBoard = {};
    private int[][] moveBoard = {};

    private Piece pieceSelect = null;
    private PieceColor player = PieceColor.WHITE;

    public Board() {
        resetPieceBoard();
        resetMoveBoard();
    }

    public Board(Board board){
        pieceBoard = board.pieceBoard;
        moveBoard = board.moveBoard;
        pieceSelect = board.pieceSelect;
        player = board.player;
    }

    public Piece[][] getPieceBoard() { return pieceBoard; }
    public int[][] getMoveBoard() { return moveBoard; }

    public Piece pieceBoard(Coordinate coordinate) {
        return pieceBoard[coordinate.x][coordinate.y];
    }
    public int moveBoard(Coordinate coordinate) {
        return moveBoard[coordinate.x][coordinate.y];
    }

    private void resetPieceBoard() {
        pieceBoard = new Piece[][] {
                {new Rook(this, new Coordinate(0, 0), PieceColor.BLACK), new Knight(this, new Coordinate(1, 0), PieceColor.BLACK), new Bishop(this, new Coordinate(2, 0), PieceColor.BLACK), new Queen(this, new Coordinate(3, 0), PieceColor.BLACK), new King(this, new Coordinate(4, 0), PieceColor.BLACK), new Bishop(this, new Coordinate(5, 0), PieceColor.BLACK), new Knight(this, new Coordinate(6, 0), PieceColor.BLACK), new Rook(this, new Coordinate(7, 0), PieceColor.BLACK)},
                {new Pawn(this, new Coordinate(0, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(1, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(2, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(3, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(4, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(5, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(6, 1), PieceColor.BLACK), new Pawn(this, new Coordinate(7, 1), PieceColor.BLACK)},
                {new Void(this, new Coordinate(0, 2)), new Void(this, new Coordinate(1, 2)), new Void(this, new Coordinate(2, 2)), new Void(this, new Coordinate(3, 2)), new Void(this, new Coordinate(4, 2)), new Void(this, new Coordinate(5, 2)), new Void(this, new Coordinate(6, 2)), new Void(this, new Coordinate(7, 2))},
                {new Void(this, new Coordinate(0, 3)), new Void(this, new Coordinate(1, 3)), new Void(this, new Coordinate(2, 3)), new Void(this, new Coordinate(3, 3)), new Void(this, new Coordinate(4, 3)), new Void(this, new Coordinate(5, 3)), new Void(this, new Coordinate(6, 3)), new Void(this, new Coordinate(7, 3))},
                {new Void(this, new Coordinate(0, 4)), new Void(this, new Coordinate(1, 4)), new Void(this, new Coordinate(2, 4)), new Void(this, new Coordinate(3, 4)), new Void(this, new Coordinate(4, 4)), new Void(this, new Coordinate(5, 4)), new Void(this, new Coordinate(6, 4)), new Void(this, new Coordinate(7, 4))},
                {new Void(this, new Coordinate(0, 5)), new Void(this, new Coordinate(1, 5)), new Void(this, new Coordinate(2, 5)), new Void(this, new Coordinate(3, 5)), new Void(this, new Coordinate(4, 5)), new Void(this, new Coordinate(5, 5)), new Void(this, new Coordinate(6, 5)), new Void(this, new Coordinate(7, 5))},
                {new Pawn(this, new Coordinate(0, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(1, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(2, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(3, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(4, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(5, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(6, 6), PieceColor.WHITE), new Pawn(this, new Coordinate(7, 6), PieceColor.WHITE)},
                {new Rook(this, new Coordinate(0, 7), PieceColor.WHITE), new Knight(this, new Coordinate(1, 7), PieceColor.WHITE), new Bishop(this, new Coordinate(2, 7), PieceColor.WHITE), new Queen(this, new Coordinate(3, 7), PieceColor.WHITE), new King(this, new Coordinate(4, 7), PieceColor.WHITE), new Bishop(this, new Coordinate(5, 7), PieceColor.WHITE), new Knight(this, new Coordinate(6, 7), PieceColor.WHITE), new Rook(this, new Coordinate(7, 7), PieceColor.WHITE)}
        };
    }
    private void resetMoveBoard() {
        moveBoard = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    private boolean onBoard(Coordinate coordinate) {
        return coordinate.x >= 0 && coordinate.x < pieceBoard.length && coordinate.y >= 0 && coordinate.y < pieceBoard[coordinate.x].length;
    }

    private Coordinate findKing(PieceColor player) {
        for (Piece[] pieces : pieceBoard)
            for (Piece piece : pieces)
                if (piece.getType() == PieceType.KING && piece.getColor() == player)
                    return piece.getCoordinate();
        return null;
    }

    private int testCheck(PieceColor player) {
        Coordinate king = findKing(player);
        for (Piece[] pieces : pieceBoard)
            for (Piece piece : pieces)
                if (piece.getColor() != player && piece.getType() != PieceType.VOID) {
                    moveBoard = piece.getMove();
                }
        if (moveBoard(king) == 0)
            return 1;
        else
            return 0;
    }

    //checkMate

    private void movePiece(Coordinate coordinate) {
        pieceBoard[coordinate.x][coordinate.y] = pieceSelect;
        pieceBoard[pieceSelect.getCoordinate().x][pieceSelect.getCoordinate().y] = new Void(this, pieceSelect.getCoordinate());
        pieceBoard[coordinate.x][coordinate.y].moved(coordinate);

        resetMoveBoard();
        if (player == PieceColor.WHITE)
            player = PieceColor.BLACK;
        else
            player = PieceColor.WHITE;
    }

    public void clicOnBoard(Coordinate coordinate) {
        if(!onBoard(coordinate));

        else if(pieceBoard(coordinate) == pieceSelect)
            pieceSelect = null;

        else if (pieceSelect == null && pieceBoard(coordinate).getColor() == player) {
            pieceSelect = pieceBoard(coordinate);
            moveBoard = pieceSelect.getMove();

            for (int x = 0; x < moveBoard.length; ++x)
                for (int y = 0; y < moveBoard[x].length; ++y)
                    if (moveBoard[x][y] == 2) {
                        Board testBoard = new Board(this);
                        testBoard.movePiece(pieceBoard[x][y].getCoordinate());
                        moveBoard[x][y] *= testBoard.testCheck(pieceBoard[x][y].getColor());
                    }

        }
        else if (pieceSelect != null && moveBoard(coordinate) == 2) {

        }
    }
}
