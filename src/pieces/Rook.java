package pieces;

import Board.*;
import Engine.*;

public class Rook extends Piece{
    public Rook(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, Game game) {
        return false;
    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ R]";
        }else {
            return "[*R]";
        }
    }

}
