package pieces;

import Board.*;
import Engine.*;

public class Bishop extends Piece{

    public Bishop(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, Game game) {
        return false;
    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ B]";
        }else {
            return "[*B]";
        }
    }
}
