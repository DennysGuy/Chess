package pieces;

import Board.*;
import Engine.Game;

public class Knight extends Piece{
    public Knight(boolean white){
        super(white);
        this.setPieceName("Knight");
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {
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
