package pieces;

import Board.*;
import Engine.*;

public class Bishop extends Piece{

    public Bishop(boolean white){
        super(white);
        this.setPieceName("Bishop");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {
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
