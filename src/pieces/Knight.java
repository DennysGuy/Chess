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
        //get the current row and column of the start square
        int startRow = start.getX();
        int startCol = start.getY();

        //get the current row and column of the end square
        int endRow = end.getX();
        int endCol = end.getY();

        //check if the knight is moving in an L shape
        if ((Math.abs(startRow - endRow) == 2 && Math.abs(startCol - endCol) == 1) ||
                (Math.abs(startRow - endRow) == 1 && Math.abs(startCol - endCol) == 2)) {
            //check for white
            if (board.getSquare(endRow, endCol).getPiece() != null && end.getPiece().isWhite() == start.getPiece().isWhite()) {
                return false;
            }
            //check for black.
            if(board.getSquare(endRow, endCol).getPiece() != null && !(end.getPiece().isWhite()) == !(start.getPiece().isWhite())){
                return false;
            }
            return true;
        }
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
