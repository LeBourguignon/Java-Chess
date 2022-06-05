package view;

import models.Board;
import models.PieceColor;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class Game {
    private JPanel main;
    private JPanel chess;

    private Board board;

    private ImageIcon kingWhite = new ImageIcon("src\\resource\\King_White.png");
    private ImageIcon pawnWhite = new ImageIcon("src\\resource\\Pawn_White.png");
    private ImageIcon knightWhite = new ImageIcon("src\\resource\\Knight_White.png");
    private ImageIcon bishopWhite = new ImageIcon("src\\resource\\Bishop_White.png");
    private ImageIcon rookWhite = new ImageIcon("src\\resource\\Rook_White.png");
    private ImageIcon queenWhite = new ImageIcon("src\\resource\\Queen_White.png");

    private ImageIcon kingBlack = new ImageIcon("src\\resource\\King_Black.png");
    private ImageIcon pawnBlack = new ImageIcon("src\\resource\\Pawn_Black.png");
    private ImageIcon knightBlack = new ImageIcon("src\\resource\\Knight_Black.png");
    private ImageIcon bishopBlack = new ImageIcon("src\\resource\\Bishop_Black.png");
    private ImageIcon rookBlack = new ImageIcon("src\\resource\\Rook_Black.png");
    private ImageIcon queenBlack = new ImageIcon("src\\resource\\Queen_Black.png");

    public Game(Board _board) {
        board = _board;
        chess.setLayout(new GridLayout(board.getPieceBoard().length, board.getPieceBoard()[0].length, 0, 0));



        updateChess();
    }

    private void updateChess() {
        boolean state = false;
        chess.removeAll();
        for (int x = 0; x < board.getPieceBoard().length; ++x) {
            for (int y = 0; y < board.getPieceBoard()[x].length; ++y) {
                JPanel box = new JPanel(new VerticalLayout(0, VerticalLayout.CENTER, VerticalLayout.BOTTOM));
                box.setMinimumSize(new Dimension(70, 70));
                box.setMaximumSize(new Dimension(420, 420));

                switch (board.getMoveBoard()[x][y]) {
                    default:
                        if(state)
                            box.setBackground(new Color(142, 91, 61));
                        else
                            box.setBackground(new Color(223, 185, 149));
                        break;

                    case 1:
                        box.setBackground(new Color(46, 49, 146));
                        break;

                    case 2:
                        if(state)
                            box.setBackground(new Color(0, 114, 188));
                        else
                            box.setBackground(new Color(0, 174, 239));
                        break;

                    case 3:
                    case 4:
                        box.setBackground(new Color(102, 45, 145));
                        break;

                    case 5:
                        box.setBackground(new Color(237, 28, 36));
                        break;
                }

                switch (board.getPieceBoard()[x][y].getType()) {
                    default:
                        break;

                    case KING:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.add(new JLabel(kingWhite));
                        else
                            box.add(new JLabel(kingBlack));
                        break;

                    case PAWN:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.add(new JLabel(pawnWhite));
                        else
                            box.add(new JLabel(pawnBlack));
                        break;

                    case KNIGHT:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.add(new JLabel(knightWhite));
                        else
                            box.add(new JLabel(knightBlack));
                        break;

                    case BISHOP:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.add(new JLabel(bishopWhite));
                        else
                            box.add(new JLabel(bishopBlack));
                        break;

                    case ROOK:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.add(new JLabel(rookWhite));
                        else
                            box.add(new JLabel(rookBlack));
                        break;

                    case QUEEN:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.add(new JLabel(queenWhite));
                        else
                            box.add(new JLabel(queenBlack));
                        break;
                }

                JPanel vSpace = new JPanel();
                vSpace.setPreferredSize(new Dimension(-1, 10));
                vSpace.setOpaque(false);
                box.add(vSpace); //TODO C'EST DEGUEU!!!

                chess.add(box);
                state = !state;
            }
            state = !state;
        }
    }

    public void start() {
        JFrame frame = new JFrame("Java Chess by ADS");



        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
