package pieces;

import Board.*;

public class Queen extends Piece{

    public Queen(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
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
