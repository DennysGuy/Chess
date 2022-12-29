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
        This is to handle the case where the pawn is in its starting postion.
        This only applies if the end square chosen by either player is +-2 on the y-axis
            -If it is player one(white), we let them move up the y-axis.
            -Else, the player is black, and they are allowed to move down the y-axis.
        */
        // *** NOTE: I split up the code to separate methods so that it will be easier to read and work with *** - one being for the first movement options and one for everything after

        /*
        This is to handle the case where the pawn can only move one square. Not implementing kill here yet.
        Going to check whether there is a free space in front of them(either black or white).
         */
        boolean newMove = moveOptions(board, start, end, player);
        return newMove;
    }

    public boolean moveOptions(Board board, Square start, Square end, boolean player) {
        // movement code for player one (DOES NOT INCLUDE CAPTURING LOGIC)
        if (player == true) {
            if (start.getPiece() != null && end.getPiece() != null) {
                return false;
            }
            //in order to make a valid move, we need to ensure that the player is moving a white piece
            //I removed checking if the start piece is null because of redundancy - it doesn't make sense to check if this square is empty as to get to this point in the code, the start square needs to be occupied with a pawn piece :-)
            if (end.getPiece() == null && start.getPiece().isWhite() == true) {
                //this code will handle if the pawn hasn't executed its first move yet - effectively giving it another option to advance 2 spots ahead as opposed to 1
                if (getFirstMove() == false) {
                    /*
                    code reads like this: if abs of start.x - end.x == 2 and start.y - end.y  == 0 && the square in front of piece is null OR if abs of start.x - end.x == 1 && abs of start.y and end.y == 0 --> return true
                    we need to consider the X change and Y change, as I was testing, you needed to consider both axis as when I only compare on X, I was only able to move the distance, but I was able to move to any square on the desired row
                     */
                    if (start.getX() - end.getX() == 2 && start.getY() - end.getY() == 0 && board.getSquare(start.getX() - 1, start.getY()).getPiece() == null || start.getX() - end.getX() == 1 && Math.abs(start.getY() - end.getY()) == 0 && board.getSquare(start.getX() - 1, start.getY()).getPiece() == null) {
                        this.setFirstMove(true); //need to change this boolean otherwise pawn can move 2 squares indefinitely
                        return true;
                    }
                    return false;
                } else {
                    if (Math.abs(start.getX() - end.getX()) == 1) {
                        return true;
                    }
                    return false;
                }
            } else {
                System.out.println("Please choose a valid square");
                return false;
            }
        }
        else {
            //Code that handles Player 2
            if (start.getPiece() != null && end.getPiece() != null) {
                return false;
            }
            //we can move this piece if the piece is not a white piece
            if (end.getPiece() == null && start.getPiece().isWhite() == false) {

                if (getFirstMove() == false) {
                    if ((Math.abs(end.getX() - start.getX()) == 2 && Math.abs(end.getY() - start.getY()) == 0 && board.getSquare(start.getX() + 1, start.getY()).getPiece() == null || end.getX() - start.getX() == 1) && start.getY() - end.getY() == 0 && board.getSquare(start.getX() + 1, start.getY()).getPiece() == null) {
                        this.setFirstMove(true); //need to change this boolean otherwise pawn can move 2 squares indefinitely
                        return true;
                    }
                    return false;
                } else {
                    if (Math.abs(start.getX() - end.getX()) == 1) {
                        return true;
                    }
                    return false;
                }
            } else {
                System.out.println("Please choose a valid square");
                return false;
            }
        }

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
