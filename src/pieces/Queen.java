package pieces;

import Board.*;
import Engine.*;

public class Queen extends Piece{

    public Queen(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {
        return false;

    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ Q]";
        }else {
            return "[*Q]";
        }
    }
}
