package pieces;

import Board.*;
import Engine.*;

public class King extends Piece{
    private boolean castling = false;

    public King(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {

        /*
            ~ Movement mechanics:
                - The king can advance 1 square in any direction

            ~ it should be notified if a King is put into check

            ~the king's capturing mechanic works the same as the movement mechanic
                - the king can move to a square that is either empty or has an opposing piece occupying it

            ~ On the King's first turn, the King has the ability to "castle"
                - castling is when the king moves 2 squares in either horizontal directions to which then a rook moves one square across the King to the opposite side (i.e.: if king moved two squares left, the rook on the left will automatically move one square to right of the king)
                - castling can only occur if a few conditions are (aren't) met:
                    - if both the king and the rook that are castling haven't made a move prior
                    - if the king is not already in check
                    - the king cannot castle to a position that will put it in check
                    - the king cannot castle through a check
         */


        return false;
    }



    public boolean isCastling(){
            return this.castling;
    }

    public void setCastling(boolean castle){
        this.castling = castle;
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
