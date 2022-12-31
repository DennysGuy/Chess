package pieces;

import java.util.Objects;
import Board.*;
import Engine.*;


public abstract class Piece {

    //this will determine if the piece is white or not
    private boolean white;
    //this will determine if the piece is on the board or not
    private boolean killed = false;
    //gives the piece a name


    public Piece(final boolean white){
        this.setWhiteStatus(white);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return white == piece.white && killed == piece.killed;

    }

    @Override
    public int hashCode() {
        return Objects.hash(white, killed);
    }

    //getters
    public boolean isWhite(){
        return this.white;
    }

    public boolean isKilled(){
        return this.killed;
    }

    //setters


    public void setWhiteStatus(boolean status){
        this.white = status;
    }

    public void setKilledStatus(boolean status){
        this.killed = status;
    }


    /*
        this will be the movement calculation
        @param board  - insert the board
        @param start  - insert starting coordinates
        @Param end    - insert end coordinates to move to

        movement will be calculated based on starting and ending coordinates given
     */

    public abstract boolean canMove(Board board, Square start, Square end, boolean player);
    /*
    generic movement check methods that handles horizontal and vertical movement for rook and queen
        ~ startRow and endRow & startCol and endCol MUST be variables that check min and max between starting row - ending row, and starting column - ending column - otherwise methods will not work
        ~ i.e.: int startRow = Math.min(start.getX(),end.getX()) & int endRow = Math.max(start.getX(),end.getX())
    */

    public boolean horizontalMovement( Square start, int startRow, int endRow, Board board){
        //horizontal movement
        for (int i = startRow + 1; i <= endRow; i++){
            if (board.getSquare(i,start.getY()).getPiece() != null)
                return false;
        }
        return true;
    }

    public boolean verticalMovement(Square start, int startCol, int endCol, Board board){
        //vertical movement
        for (int i = startCol + 1; i < endCol;i++){
            if (board.getSquare(start.getX(),i).getPiece() != null)
                return false;
        }
        return true;
    }



    //default toString which will allow us to display the piece to the user
    @Override
    public String toString(){
        return null;
    }

}
