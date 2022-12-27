package pieces;

import Board.*;

public class Bishop extends Piece{

    public Bishop(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
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
