package Board;
import pieces.*;

public class Square {
    private int x;
    private int y;
    private
    Piece piece;

    public Square(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    @Override
    public String toString(){
        if (piece == null)
            return "[  ]";
        else{
            return piece.toString();
        }
    }

}
