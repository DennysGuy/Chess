package pieces;

import Board.*;
import Engine.Game;

import java.util.Objects;

public class Pawn extends Piece{

    private boolean hasMoved = false;
    public Pawn(boolean white){
        super(white);
    }


    public boolean getHasMoved(){
        return hasMoved;
    }

    public void setHasMoved(boolean moved){
        hasMoved = moved;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


    @Override
    public boolean canMove(Board board, Square start, Square end, Game game) {
        /*
            ~ need to consider both black and white sides
            ~ need to limit pawn from moving backwards
            ~ need to consider diagonal spots - if there is no enemy piece in a square diagonal/forward to a pawn, return false

         */
        //Just testing something
        boolean playerOne = game.isPlayerOne();
        if(playerOne){
            if(!getHasMoved()){
                if(board.getSquare(start.getX() + 1, start.getY()) != null && end.getPiece() != null){
                    return false;
                    //Hi matt!
                }
            }
        }else{

        }
        //

        if (getHasMoved() == false) {
            if (board.getSquare(start.getX()+1, start.getY()).getPiece() != null && end.getPiece() != null)
                return false;
        }
        else {
            if (end.getPiece() != null)
                return false;
        }

        return true;
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
