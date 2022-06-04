package view;

import models.Board;
import models.PieceColor;

import javax.swing.*;
import java.awt.*;

public class Game {
    private JPanel main;
    private JPanel chess;

    private Board board;

    private JLabel whiteKing = new JLabel(new ImageIcon("/resource/King_White.png"));

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
                JPanel box = new JPanel();
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
                            box.add(whiteKing);
                        else
                            ; //TODO: je suis ici
                }

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
