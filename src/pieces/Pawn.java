package pieces;

import Board.*;

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
    public boolean canMove(Board board, Square start, Square end, boolean player) {
        /*
            ~ need to consider both black and white sides
            ~ need to limit pawn from moving backwards
            ~ need to consider diagonal spots - if there is no enemy piece in a square diagonal/forward to a pawn, return false

         */

        //Just testing something
        boolean playerOne = player;
        /*
        This is to handle the case where the pawn is in its starting postion.
        This only applies if the end square chosen by either player is +-2 on the y-axis
            -If it is player one(white), we let them move up the y-axis.
            -Else, the player is black, and they are allowed to move down the y-axis.
        */

        if (playerOne == true && getFirstMove() == false && (start.getY() - 2 == end.getY())) {
            if (getFirstMove() == false) {
                if (board.getSquare(start.getX(), start.getY() - 1).getPiece() != null && end.getPiece() != null) {
                    return false;
                }
                //in order to make a valid move, we need to ensure that the player is moving a white piece
                if (start.getPiece().isWhite() == true)
                {
                    this.setFirstMove(true); //need to change this boolean otherwise pawn can move 2 squares indefinitely
                    return true;
                }else{
                    System.out.println("Please choose a valid square");
                    return false;
                }
            }
        } else if (playerOne == false && getFirstMove() == false && (start.getY() + 2 == end.getY())) {

            if (board.getSquare(start.getX(), start.getY() + 1).getPiece() != null && end.getPiece() != null)
            {
                return false;
            }
            //in order to make a valid move, we need to ensure that the player is moving a black piece
            if (start.getPiece().isWhite() == false)
            {
                this.setFirstMove(true);
                return true;
            }else{
                System.out.println("Please choose a valid square");
                return false;
            }
        }
        /*
        This is to handle the case where the pawn can only move one square. Not implementing kill here yet.
        Going to check whether there is a free space in front of them(either black or white).
         */

        if (playerOne == true && (start.getY() - 1 == end.getY())) {
            if (board.getSquare(start.getX(), start.getY() - 1) != null && end.getPiece() != null) {
                return false;
            }

            if (start.getPiece().isWhite() == true)
            {
                if (getFirstMove()==false)
                    setFirstMove(true);
                return true;
            }else{
                System.out.println("Please choose a valid square");
                return false;
            }

        } else if (playerOne && (start.getY() + 1 == end.getY())) {
            if (board.getSquare(start.getX(), start.getY() + 1) != null && end.getPiece() != null) {
                return false;
            }

            if (start.getPiece().isWhite() == false)
            {
                if (getFirstMove() == false)
                    setFirstMove(true);
                return true;
            }else{
                System.out.println("Please choose a valid square");
                return false;
            }
        }
        //If all else fails here, all other options were invalid, and we just return false.
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
