package Board;
import pieces.*;

public class Square {
    private int x;
    private int y;
    private Piece piece;

    public Square(int x, int y, Piece piece){
        this.setX(x);
        this.setY(y);
        this.setPiece(piece);
    }

    //getters
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Piece getPiece(){
        return this.piece;
    }

    //setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setPiece(Piece piece){
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
