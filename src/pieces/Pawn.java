package pieces;

import Board.*;

import java.util.Objects;

public class Pawn extends Piece{

    public Pawn(boolean white){
        super(white);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


    @Override
    public boolean canMove(Board board, Square start, Square end) {
        return false;
    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ P]";
        }else {
            return "[*P]";
        }
    }
}
