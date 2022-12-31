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

        //White movement
        if (player == true) { //player one movement
            if (start.getPiece().isWhite() == true) {
                if (end.getPiece() == null || end.getPiece().isWhite() == false) {
                    if (start.getX() == end.getX()) {
                        validMove = horizontalMovement(start, startRow, endRow, board);
                    }

                    if (start.getY() == end.getY()){
                        validMove = verticalMovement(start, startCol, endCol, board);
                    }
                }
                return validMove;
            }
            return false;
        } else { //player 2 movement
            //vertical movement
            if (start.getPiece().isWhite() == false) {
                if (end.getPiece() == null || end.getPiece().isWhite() == true) {
                    if (start.getX() == end.getX()) {
                        validMove = horizontalMovement(start, startRow, endRow, board);
                    }
                    if (start.getY() == end.getY()){
                        validMove = verticalMovement(start, startCol, endCol, board);
                    }
                }
                return validMove;
            }
            return false;
        }
    }

    public boolean horizontalMovement( Square start, int startRow, int endRow, Board board){
        //horizontal movement
        for (int i = Math.min(startRow,endRow) + 1; i <= Math.max(startRow,endRow); i++){
            if (board.getSquare(i,start.getY()).getPiece() != null)
                return false;

        }
        return true;
    }

    public boolean verticalMovement(Square start, int startCol, int endCol, Board board){
        //vertical movement
        for (int i = Math.min(startCol,endCol) + 1; i < Math.max(startCol,endCol);i++){
            if (board.getSquare(start.getX(),i).getPiece() != null)
                return false;
        }
        return true;
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
