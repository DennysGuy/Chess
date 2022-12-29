package pieces;

import Board.*;
import Engine.*;

public class King extends Piece{

    public King(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {
        return false;
    }


    @Override
    public String toString(){
        if(isWhite()){
            return "[ K]";
        }else {
            return "[*K]";
        }
    }

}
