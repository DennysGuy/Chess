package pieces;

import Board.*;

public class Knight extends Piece{
    public Knight(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        return false;
    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ N]";
        }else {
            return "[*N]";
        }
    }
}
