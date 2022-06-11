package models;

import java.util.Arrays;

public class Board {
    private Piece[][] pieceBoard = {};
    private int[][] moveBoard = {};

    private Piece pieceSelect = null;
    private PieceColor player = PieceColor.WHITE;
    private BoardState state = BoardState.PLAYING;

    private int nbMove = 0;

    public Board() {
        resetPieceBoard();
        resetMoveBoard();
    }

    public Board(Board board) throws CloneNotSupportedException {
        pieceBoard = Arrays.stream(board.pieceBoard)
                .map(a ->  Arrays.copyOf(a, a.length))
                .toArray(Piece[][]::new);
        moveBoard = Arrays.stream(board.moveBoard)
                .map(a ->  Arrays.copyOf(a, a.length))
                .toArray(int[][]::new);
        if (board.pieceSelect != null)
            pieceSelect = board.pieceSelect.clone();
        player = board.player;
        state = board.state;
    }

    public Piece[][] getPieceBoard() { return pieceBoard; }
    public int[][] getMoveBoard() { return moveBoard; }

    public Piece pieceBoard(Coordinate coordinate) {
        return pieceBoard[coordinate.x][coordinate.y];
    }
    public int moveBoard(Coordinate coordinate) {
        return moveBoard[coordinate.x][coordinate.y];
    }

    public Piece getPieceSelect() { return pieceSelect; }
    public PieceColor getPlayer() { return player; }
    public BoardState getState() { return state; }

    public int getNbMove() { return nbMove; }

    private void resetPieceBoard() {
        pieceBoard = new Piece[][] {
                {new Rook(new Coordinate(0, 0), PieceColor.BLACK), new Knight(new Coordinate(0, 1), PieceColor.BLACK), new Bishop(new Coordinate(0, 2), PieceColor.BLACK), new Queen(new Coordinate(0, 3), PieceColor.BLACK), new King(new Coordinate(0, 4), PieceColor.BLACK), new Bishop(new Coordinate(0, 5), PieceColor.BLACK), new Knight(new Coordinate(0, 6), PieceColor.BLACK), new Rook(new Coordinate(0, 7), PieceColor.BLACK)},
                {new Pawn(new Coordinate(1, 0), PieceColor.BLACK), new Pawn(new Coordinate(1, 1), PieceColor.BLACK), new Pawn(new Coordinate(1, 2), PieceColor.BLACK), new Pawn(new Coordinate(1, 3), PieceColor.BLACK), new Pawn(new Coordinate(1, 4), PieceColor.BLACK), new Pawn(new Coordinate(1, 5), PieceColor.BLACK), new Pawn(new Coordinate(1, 6), PieceColor.BLACK), new Pawn(new Coordinate(1, 7), PieceColor.BLACK)},
                {new Void(new Coordinate(2, 0)), new Void(new Coordinate(2, 1)), new Void(new Coordinate(2, 2)), new Void(new Coordinate(2, 3)), new Void(new Coordinate(2, 4)), new Void(new Coordinate(2, 5)), new Void(new Coordinate(2, 6)), new Void(new Coordinate(2, 7))},
                {new Void(new Coordinate(3, 0)), new Void(new Coordinate(3, 1)), new Void(new Coordinate(3, 2)), new Void(new Coordinate(3, 3)), new Void(new Coordinate(3, 4)), new Void(new Coordinate(3, 5)), new Void(new Coordinate(3, 6)), new Void(new Coordinate(3, 7))},
                {new Void(new Coordinate(4, 0)), new Void(new Coordinate(4, 1)), new Void(new Coordinate(4, 2)), new Void(new Coordinate(4, 3)), new Void(new Coordinate(4, 4)), new Void(new Coordinate(4, 5)), new Void(new Coordinate(4, 6)), new Void(new Coordinate(4, 7))},
                {new Void(new Coordinate(5, 0)), new Void(new Coordinate(5, 1)), new Void(new Coordinate(5, 2)), new Void(new Coordinate(5, 3)), new Void(new Coordinate(5, 4)), new Void(new Coordinate(5, 5)), new Void(new Coordinate(5, 6)), new Void(new Coordinate(5, 7))},
                {new Pawn(new Coordinate(6, 0), PieceColor.WHITE), new Pawn(new Coordinate(6, 1), PieceColor.WHITE), new Pawn(new Coordinate(6, 2), PieceColor.WHITE), new Pawn(new Coordinate(6, 3), PieceColor.WHITE), new Pawn(new Coordinate(6, 4), PieceColor.WHITE), new Pawn(new Coordinate(6, 5), PieceColor.WHITE), new Pawn(new Coordinate(6, 6), PieceColor.WHITE), new Pawn(new Coordinate(6, 7), PieceColor.WHITE)},
                {new Rook(new Coordinate(7, 0), PieceColor.WHITE), new Knight(new Coordinate(7, 1), PieceColor.WHITE), new Bishop(new Coordinate(7, 2), PieceColor.WHITE), new Queen(new Coordinate(7, 3), PieceColor.WHITE), new King(new Coordinate(7, 4), PieceColor.WHITE), new Bishop(new Coordinate(7, 5), PieceColor.WHITE), new Knight(new Coordinate(7, 6), PieceColor.WHITE), new Rook(new Coordinate(7, 7), PieceColor.WHITE)}
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

    private Coordinate findKing(PieceColor _player) {
        for (Piece[] pieces : pieceBoard)
            for (Piece piece : pieces)
                if (piece.getType() == PieceType.KING && piece.getColor() == _player)
                    return piece.getCoordinate();
        return null;
    }

    private int testCheck(PieceColor _player) {
        Coordinate king = findKing(_player);
        for (Piece[] pieces : pieceBoard)
            for (Piece piece : pieces)
                if (piece.getColor() != _player && piece.getType() != PieceType.VOID) {
                    moveBoard = piece.getMove(this);
                }
        if (moveBoard(king) == 0)
            return 1;
        else
            return 0;
    }

    private void selectPiece(Coordinate coordinate) throws CloneNotSupportedException {
        pieceSelect = pieceBoard(coordinate);
        moveBoard = pieceSelect.getMove(this);

        for (int x = 0; x < moveBoard.length; ++x)
            for (int y = 0; y < moveBoard[x].length; ++y)
                if (moveBoard[x][y] == 2) { //TODO: (moveBoard[x][y] == 2 || moveBoard[x][y] == 3 || moveBoard[x][y] == 4)
                    Board testBoard = new Board(this);
                    testBoard.movePiece(pieceBoard[x][y].getCoordinate());
                    moveBoard[x][y] *= testBoard.testCheck(pieceSelect.getColor());
                }
    }

    private void updateState() throws CloneNotSupportedException {
        //TODO Promote

        //TODO Update state ne marche pas quand il y a echec...
        int check = testCheck(player);
        for (Piece[] pieces: pieceBoard)
            for (Piece piece: pieces)
                if (piece.getColor() == player) {
                    selectPiece(piece.getCoordinate());
                    for (int[] ints: moveBoard)
                        for (int anInt: ints)
                            if (anInt == 2) {
                                if (check == 1)
                                    state = BoardState.PLAYING;
                                else
                                    state = BoardState.CHECK;
                                pieceSelect = null;
                                resetMoveBoard();
                                return;
                            }
                    pieceSelect = null;
                    resetMoveBoard();
                }
        if (check == 1)
            state = BoardState.STALEMATE;
        else
            state = BoardState.CHECKMATE;
    }

    private boolean movePiece(Coordinate coordinate) {
        if (moveBoard(coordinate) == 2 || moveBoard(coordinate) == 3 || moveBoard(coordinate) == 4) {
            pieceBoard[coordinate.x][coordinate.y] = pieceSelect;
            pieceBoard[pieceSelect.getCoordinate().x][pieceSelect.getCoordinate().y] = new Void(pieceSelect.getCoordinate());
            pieceBoard[coordinate.x][coordinate.y].moved(coordinate);
        }
        else
            return false;

        if (moveBoard(coordinate) == 3) {
            if (pieceSelect.getType() == PieceType.KING) {
                pieceBoard[coordinate.x][coordinate.y - 1] = pieceBoard[coordinate.x][coordinate.y + 1];
                pieceBoard[coordinate.x][coordinate.y + 1] = new Void(new Coordinate(coordinate.x, coordinate.y + 1));
                pieceBoard[coordinate.x][coordinate.y - 1].moved(new Coordinate(coordinate.x, coordinate.y - 1));
            }
            else if (pieceSelect.getType() == PieceType.ROOK) {
                pieceBoard[coordinate.x][coordinate.y + 1] = pieceBoard[coordinate.x][coordinate.y - 1];
                pieceBoard[coordinate.x][coordinate.y - 1] = new Void(new Coordinate(coordinate.x, coordinate.y - 1));
                pieceBoard[coordinate.x][coordinate.y + 1].moved(new Coordinate(coordinate.x, coordinate.y + 1));
            }
        }
        else if (moveBoard(coordinate) == 4) {
            if (pieceSelect.getType() == PieceType.KING) {
                pieceBoard[coordinate.x][coordinate.y + 1] = pieceBoard[coordinate.x][coordinate.y - 2];
                pieceBoard[coordinate.x][coordinate.y - 2] = new Void(new Coordinate(coordinate.x, coordinate.y - 2));
                pieceBoard[coordinate.x][coordinate.y + 1].moved(new Coordinate(coordinate.x, coordinate.y + 1));
            }
            else if (pieceSelect.getType() == PieceType.ROOK) {
                pieceBoard[coordinate.x][coordinate.y - 1] = pieceBoard[coordinate.x][coordinate.y + 1];
                pieceBoard[coordinate.x][coordinate.y + 1] = new Void(new Coordinate(coordinate.x, coordinate.y + 1));
                pieceBoard[coordinate.x][coordinate.y - 1].moved(new Coordinate(coordinate.x, coordinate.y - 1));
            }
        }

        resetMoveBoard();
        pieceSelect = null;
        if (player == PieceColor.WHITE)
            player = PieceColor.BLACK;
        else
            player = PieceColor.WHITE;
        ++nbMove;
        return true;
    }

    public void clicOnBoard(Coordinate coordinate) throws CloneNotSupportedException {
        if (state != BoardState.PLAYING && state != BoardState.CHECK);
        else if(!onBoard(coordinate));
        else if(pieceBoard(coordinate) == pieceSelect) {
            pieceSelect = null;
            resetMoveBoard();
        }
        else if (pieceSelect == null && pieceBoard(coordinate).getColor() == player) {
            selectPiece(coordinate);
        }
        else if (pieceSelect != null && movePiece(coordinate))
            updateState();

        //TODO Promote
    }

    public String toString() {
        StringBuilder output = new StringBuilder("PieceBoard:\n");
        for (Piece[] pieces : pieceBoard) {
            for (Piece piece : pieces) {
                output.append(piece.toString()).append("\t");
            }
            output.append("\n");
        }

        output.append("\nMoveBoard:\n");
        for (int[] ints : moveBoard) {
            for (int anInt : ints) {
                output.append(anInt).append(" ");
            }
            output.append("\n");
        }
        return output.toString();
    }
}
