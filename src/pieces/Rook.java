package pieces;

import Board.*;
import Engine.*;

import java.util.Objects;

public class Rook extends Piece{

    private boolean castling;


    public Rook(boolean white){
        super(white);
        this.setPieceName("Rook");
    }

    public boolean isCastling(){
        return this.castling;
    }

    public void setCastling(boolean castle){
        this.castling = castle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rook rook = (Rook) o;
        return castling == rook.castling;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), castling);
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
                    validMove = rookMovement(start,end,startRow,endRow,startCol,endCol,board,validMove);
            }

        } else { //player 2 movement
            if (end.getPiece() == null || end.getPiece().isWhite() == true) {
                    validMove = rookMovement(start,end,startRow,endRow,startCol,endCol,board,validMove);
            }
        }
        return validMove;
    }

    public boolean rookMovement(Square start, Square end, int startRow, int endRow, int startCol, int endCol,Board board, boolean validMove){
        if (start.getX() == end.getX()) {
            validMove = horizontalMovement(start, startRow, endRow, board);
            if (validMove == true && this.getFirstMove() == false)
                this.setFirstMove(true);

        }
        if (start.getY() == end.getY()){
            validMove = verticalMovement(start, startCol, endCol, board);
            if (validMove == true && this.getFirstMove() == false)
                this.setFirstMove(true);
        }
        return validMove;
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
