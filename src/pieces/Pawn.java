package pieces;

import Board.*;
import Engine.Game;

import java.util.Objects;

public class Pawn extends Piece{

    private boolean firstMove = false;
    public Pawn(boolean white){
        super(white);
    }


    public boolean getFirstMove(){
        return firstMove;
    }

    public void setFirstMove(boolean moved){
        firstMove = moved;
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
        /*
        This is to handle the case where the pawn is in its starting postion.
        This only applies if the end square chosen by either player is +-2 on the y-axis
            -If it is player one(white), we let them move up the y-axis.
            -Else, the player is black, and they are allowed to move down the y-axis.
        */

        if (playerOne && !getFirstMove() && (start.getY() - 2 == end.getY())) {
            if (!getFirstMove()) {
                if (board.getSquare(start.getX(), start.getY() - 1) != null && end.getPiece() != null) {
                    return false;
                } else {
                    this.setFirstMove(true); //need to change this boolean otherwise pawn can move 2 squares indefinitely
                    return true;
                }
            }
        } else if (!playerOne && !getFirstMove() && (start.getY() + 2 == end.getY())) {
            if (board.getSquare(start.getX(), start.getY() + 1) != null && end.getPiece() != null) {
                return false;
            }
            else {
                this.setFirstMove(true);
                return true;
            }
        }
        /*
        This is to handle the case where the pawn can only move one square. Not implementing kill here yet.
        Going to check whether there is a free space in front of them(either black or white).
         */
        if (playerOne && (start.getY() - 1 == end.getY())) {
            if (board.getSquare(start.getX(), start.getY() - 1) != null && end.getPiece() != null) {
                return false;
            } else {
                if (getFirstMove()==false)
                    setFirstMove(true);
                return true;
            }
        } else if (playerOne && (start.getY() + 1 == end.getY())) {
            if (board.getSquare(start.getX(), start.getY() + 1) != null && end.getPiece() != null) {
                return false;
            } else {
                if (getFirstMove() == false)
                    setFirstMove(true);
                return true;
            }
        }
        //If all else fails here, all other options were invalid, and we just return false.
        return false;

        /*
        Getting rid of this for the time being.

        if (getHasMoved() == false) {
            if (board.getSquare(start.getX()+1, start.getY()).getPiece() != null && end.getPiece() != null)
                return false;
        }
        else {
            if (end.getPiece() != null)
                return false;
        }

        return true;
         */

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
