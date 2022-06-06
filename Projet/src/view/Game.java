package view;

import models.Board;
import models.Coordinate;
import models.PieceColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game {
    private JPanel main;
    private JPanel chess;

    private Board board;

    private BufferedImage kingWhite = ImageIO.read(new File("src\\resource\\King_White.png"));
    private BufferedImage pawnWhite = ImageIO.read(new File("src\\resource\\Pawn_White.png"));
    private BufferedImage knightWhite = ImageIO.read(new File("src\\resource\\Knight_White.png"));
    private BufferedImage bishopWhite = ImageIO.read(new File("src\\resource\\Bishop_White.png"));
    private BufferedImage rookWhite = ImageIO.read(new File("src\\resource\\Rook_White.png"));
    private BufferedImage queenWhite = ImageIO.read(new File("src\\resource\\Queen_White.png"));

    private BufferedImage kingBlack = ImageIO.read(new File("src\\resource\\King_Black.png"));
    private BufferedImage pawnBlack = ImageIO.read(new File("src\\resource\\Pawn_Black.png"));
    private BufferedImage knightBlack = ImageIO.read(new File("src\\resource\\Knight_Black.png"));
    private BufferedImage bishopBlack = ImageIO.read(new File("src\\resource\\Bishop_Black.png"));
    private BufferedImage rookBlack = ImageIO.read(new File("src\\resource\\Rook_Black.png"));
    private BufferedImage queenBlack = ImageIO.read(new File("src\\resource\\Queen_Black.png"));

    public Game(Board _board) throws IOException {
        board = _board;
        chess.setLayout(new GridLayout(board.getPieceBoard().length, board.getPieceBoard()[0].length, 0, 0));
        updateChess();
    }

    private void updateChess() throws IOException {
        boolean state = false;
        chess.removeAll();
        for (int x = 0; x < board.getPieceBoard().length; ++x) {
            for (int y = 0; y < board.getPieceBoard()[x].length; ++y) {
                ImagePanel box = new ImagePanel();
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
                            box.setImage(kingWhite);
                        else
                            box.setImage(kingBlack);
                        break;

                    case PAWN:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.setImage(pawnWhite);
                        else
                            box.setImage(pawnBlack);
                        break;

                    case KNIGHT:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.setImage(knightWhite);
                        else
                            box.setImage(knightBlack);
                        break;

                    case BISHOP:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.setImage(bishopWhite);
                        else
                            box.setImage(bishopBlack);
                        break;

                    case ROOK:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.setImage(rookWhite);
                        else
                            box.setImage(rookBlack);
                        break;

                    case QUEEN:
                        if (board.getPieceBoard()[x][y].getColor() == PieceColor.WHITE)
                            box.setImage(queenWhite);
                        else
                            box.setImage(queenBlack);
                        break;
                }

                chess.add(box);
                state = !state;
            }
            state = !state;
        }
    }

    public void start() throws IOException {
        JFrame frame = new JFrame("Java Chess by ADS");
        frame.setContentPane(main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
