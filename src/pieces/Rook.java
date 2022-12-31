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
        int startRow = Math.min(start.getX(),end.getX());
        int startCol = Math.min(start.getY(),end.getY());

        int endRow   = Math.max(start.getX(),end.getX());
        int endCol   = Math.max(start.getY(),end.getY());

        boolean validMove = false;

        if (player == true && start.getPiece().isWhite() == true) { //player one movement

                if (end.getPiece() == null || end.getPiece().isWhite() == false) {
                    if (start.getX() == end.getX()) {
                        validMove = horizontalMovement(start, startRow, endRow, board);
                    }
                    if (start.getY() == end.getY()){
                        validMove = verticalMovement(start, startCol, endCol, board);
                    }
                }
                return validMove;

        } else { //player 2 movement
                if (end.getPiece() == null || end.getPiece().isWhite() == true) {
                    if (start.getX() == end.getX()) {
                        validMove = horizontalMovement(start, startRow, endRow, board);
                    }
                    if (start.getY() == end.getY()){
                        validMove = verticalMovement(start, startCol, endCol, board);
                    }
                return validMove;
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
