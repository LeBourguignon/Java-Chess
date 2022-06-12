package views;

import controllers.Controller;
import models.Board;
import models.Coordinate;
import models.PieceColor;
import patterns.BoxPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Promote {
    private JPanel main;
    private JPanel pieces;

    public Promote(Controller controller, Board board) throws IOException {
        pieces.setLayout(new GridLayout(1, 4, 30, 0));

        JFrame frame = new JFrame("Java Chess - Promote");

        BoxPanel knight = new BoxPanel();
        knight.setBackground(new Color(0x404040));
        BoxPanel bishop = new BoxPanel();
        bishop.setBackground(new Color(0x404040));
        BoxPanel rook = new BoxPanel();
        rook.setBackground(new Color(0x404040));
        BoxPanel queen = new BoxPanel();
        queen.setBackground(new Color(0x404040));

        if (board.getPieceSelect().getColor() == PieceColor.WHITE)
        {
            knight.setImage(ImageIO.read(new File("resources\\Knight_White.png")));
            bishop.setImage(ImageIO.read(new File("resources\\Bishop_White.png")));
            rook.setImage(ImageIO.read(new File("resources\\Rook_White.png")));
            queen.setImage(ImageIO.read(new File("resources\\Queen_White.png")));
        }
        else if (board.getPieceSelect().getColor() == PieceColor.BLACK) {
            knight.setImage(ImageIO.read(new File("resources\\Knight_Black.png")));
            bishop.setImage(ImageIO.read(new File("resources\\Bishop_Black.png")));
            rook.setImage(ImageIO.read(new File("resources\\Rook_Black.png")));
            queen.setImage(ImageIO.read(new File("resources\\Queen_Black.png")));
        }

        knight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    board.clicOnBoard(new Coordinate(-1,-1));
                } catch (CloneNotSupportedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    controller.toNotify();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });

        bishop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    board.clicOnBoard(new Coordinate(-2, -2));
                } catch (CloneNotSupportedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    controller.toNotify();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });

        rook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    board.clicOnBoard(new Coordinate(-3, -3));
                } catch (CloneNotSupportedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    controller.toNotify();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });

        queen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    board.clicOnBoard(new Coordinate(-4, -4));
                } catch (CloneNotSupportedException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    controller.toNotify();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });

        pieces.add(knight);
        pieces.add(bishop);
        pieces.add(rook);
        pieces.add(queen);

        frame.setResizable(false);
        frame.setContentPane(main);
        frame.pack();
        frame.setVisible(true);
    }
}