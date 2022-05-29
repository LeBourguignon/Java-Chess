import models.*;

public class Application {
    public static void main(String arg[]) throws CloneNotSupportedException {
        Board board = new Board();
        Coordinate c1 = new Coordinate(6, 1);
        Coordinate c2 = new Coordinate(4, 1);

        System.out.println(board.toString());
        board.clicOnBoard(c1);
        System.out.println(board.toString());
        board.clicOnBoard(c2);
        System.out.println(board.toString());
    }
}
