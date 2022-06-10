package views;

import controllers.Controller;
import models.Board;
import models.Coordinate;
import models.PieceColor;
import patterns.BoxPanel;
import patterns.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Game extends View {
    public JPanel main;
    private JPanel chess;

    private Board board;

    private final BufferedImage kingWhite = ImageIO.read(new File("src\\resources\\King_White.png"));
    private final BufferedImage pawnWhite = ImageIO.read(new File("src\\resources\\Pawn_White.png"));
    private final BufferedImage knightWhite = ImageIO.read(new File("src\\resources\\Knight_White.png"));
    private final BufferedImage bishopWhite = ImageIO.read(new File("src\\resources\\Bishop_White.png"));
    private final BufferedImage rookWhite = ImageIO.read(new File("src\\resources\\Rook_White.png"));
    private final BufferedImage queenWhite = ImageIO.read(new File("src\\resources\\Queen_White.png"));

    private final BufferedImage kingBlack = ImageIO.read(new File("src\\resources\\King_Black.png"));
    private final BufferedImage pawnBlack = ImageIO.read(new File("src\\resources\\Pawn_Black.png"));
    private final BufferedImage knightBlack = ImageIO.read(new File("src\\resources\\Knight_Black.png"));
    private final BufferedImage bishopBlack = ImageIO.read(new File("src\\resources\\Bishop_Black.png"));
    private final BufferedImage rookBlack = ImageIO.read(new File("src\\resources\\Rook_Black.png"));
    private final BufferedImage queenBlack = ImageIO.read(new File("src\\resources\\Queen_Black.png"));

    public Game(Controller controller) throws IOException {
        super(controller);
        board = new Board();
        chess.setLayout(new GridLayout(board.getPieceBoard().length, board.getPieceBoard()[0].length, 0, 0));
        update();
    }

    protected void update() throws IOException {
        updateChess();

        controller.frame.setContentPane(main);
        controller.frame.pack();
        controller.frame.setVisible(true);
    }

    private void updateChess() throws IOException {
        boolean state = false;
        chess.removeAll();
        for (int x = 0; x < board.getPieceBoard().length; ++x) {
            for (int y = 0; y < board.getPieceBoard()[x].length; ++y) {
                BoxPanel box = new BoxPanel();
                box.setMinimumSize(new Dimension(70, 70));
                box.setMaximumSize(new Dimension(420, 420));
                box.setFocusPainted(false);
                box.setBorderPainted(false);

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

                Coordinate coordinate = new Coordinate(x, y);
                box.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            board.clicOnBoard(coordinate);
                        } catch (CloneNotSupportedException ex) {
                            throw new RuntimeException(ex);
                        }
                        try {
                            update();
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                chess.add(box);
                state = !state;
            }
            state = !state;
        }
    }
}