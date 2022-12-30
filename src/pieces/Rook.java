package pieces;

import Board.*;
import Engine.*;

public class Rook extends Piece{

    private boolean castling;

    public Rook(boolean white){
        super(white);
    }

    public boolean isCastling(){
        return this.castling;
    }

    public void setCastling(boolean castle){
        this.castling = castle;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {
        /*
        ~The Rook has the capability to move through any unoccupied square on the board both vertically and horizontally
        ~The Rook does not have the capability to jump over pieces
        ~The
         */
        //White movement
        if (player == true) { //player one movement
            //vertical movement
            if (start.getY() == end.getY() && start.getPiece().isWhite() == true) {
                if (end.getPiece() == null || end.getPiece().isWhite() == false) {
                    //moving up on column
                    if (start.getX() > end.getX()) {
                        //check if any squares in between start and end point are occupied
                        for (int i = start.getX(); i <= end.getX(); i++) {
                            if (board.getSquare(i, start.getY()).getPiece() != null)
                                return false;
                        }
                    } else {
                        //moving down on column
                        for (int i = end.getX(); i <= start.getX(); i++) {
                            if (board.getSquare(i, start.getY()).getPiece() != null)
                                return false;
                        }
                    }
                    return true;
                }
            }
                //horizontal movement
            if (start.getX() == end.getX() && start.getPiece().isWhite() == true) {
                if (end.getPiece() == null || end.getPiece().isWhite() == false) {
                    //moving to the right on row
                    if (start.getY() < end.getY()) {
                        //if a piece is occupying a square in between starting square and destination, return false as a rook cannot jump over pieces
                        for (int i = start.getY() + 1; i <= end.getY(); i++) {
                            if (board.getSquare(start.getX(), i).getPiece() != null)
                                return false;
                        }
                    } else {
                        //moving to the left on row
                        for (int i = end.getY(); i < start.getY(); i++) {
                            if (board.getSquare(start.getX(), i).getPiece() != null)
                                return false;
                        }
                    }
                    return true;
                }
            }

        } else { //player 2 movement
            //vertical movement
            if (start.getY() == end.getY() && start.getPiece().isWhite() == false) {

                if (end.getPiece() == null || end.getPiece().isWhite() == true) {
                    //moving up on column
                    if (start.getX() > end.getX()) {
                        //check if any squares in between start and end point are occupied
                        for (int i = start.getX(); i <= end.getX(); i++) {
                            if (board.getSquare(i, start.getY()).getPiece() != null)
                                return false;
                        }
                    } else {
                        //moving down on column
                        for (int i = end.getX(); i <= start.getX(); i++) {
                            if (board.getSquare(i, start.getY()).getPiece() != null)
                                return false;
                        }
                    }
                    return true;
                }
            }
            //horizontal movement
            if (start.getX() == end.getX() && start.getPiece().isWhite() == false) {
                if (end.getPiece() == null || end.getPiece().isWhite() == true) {
                    //moving to the right on row
                    if (start.getY() < end.getY()) {
                        for (int i = start.getY() + 1; i <= end.getY(); i++) {
                            if (board.getSquare(start.getX(), i).getPiece() != null)
                                return false;
                        }
                    } else {
                        //moving to the left on row
                        for (int i = end.getY(); i < start.getY(); i++) {
                            if (board.getSquare(start.getX(), i).getPiece() != null)
                                return false;
                        }
                    }
                    return true;
                }
            }
        }
            return false;
    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ R]";
        }else {
            return "[*R]";
        }
    }

}
