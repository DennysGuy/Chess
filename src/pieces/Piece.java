package pieces;

import java.util.Objects;
import Board.*;
import Engine.*;


public abstract class Piece {

    //this will determine if the piece is white or not
    private boolean white;
    //this will determine if the piece is on the board or not
    private boolean killed = false;
    //determine if piece has made first move
    private boolean firstMove = false;
    //name of piece
    private String pieceName;
    //castling
    private boolean castling = false;
    //king check
    private boolean check = false;


    public Piece(final boolean white){
        this.setWhiteStatus(white);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return white == piece.white && killed == piece.killed && firstMove == piece.firstMove && Objects.equals(pieceName, piece.pieceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(white, killed, firstMove, pieceName);
    }

    //getters
    public boolean isWhite(){
        return this.white;
    }

    public boolean isCastling(){
        return this.castling;
    }

    public boolean inCheck(){
        return this.check;
    }

    public boolean isKilled(){
        return this.killed;
    }

    public String getPieceName(){
        return this.pieceName;
    }

    public boolean getKilledStatus(){
        return this.killed;
    }

    //setters
    public void setPieceName(String pieceName){
        this.pieceName = pieceName;
    }

    public void setCastling(boolean castle){
        this.castling = castle;
    }

    public void setCheck(boolean check){
        this.check = check;
    }

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
        ~ it is recommeneded that parameters startRow and endRow & parameters startCol and endCol be variables that check min and max between starting row - ending row, and starting column - ending column - for maximum efficiency
        ~ i.e.: int startRow = Math.min(start.getX(),end.getX()) & int endRow = Math.max(start.getX(),end.getX())
    */

    public boolean horizontalMovement(Square start, int startRow, int endRow, Board board){
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

    //checkers
    /*
     -- these will check column, row, diagonal, and the special knight path for a piece -- this will be used to determine if the King is currently in check
     -- These checks should be executed after every turn to determine if a King piece is in check or not
     -- Circumstances these functions will be used for:
            - Check if a move puts a specific King piece in check
            - Displaying to the Players that a specific King piece is in check (Player one or Player two)
            - Determining if the King is allowed to castle or not

    */



    //getters
    public boolean getFirstMove(){
        return this.firstMove;
    }

    //setters
    public void setFirstMove(boolean firstMove){
        this.firstMove = firstMove;
    }


    //default toString which will allow us to display the piece to the user
    @Override
    public String toString(){
        return null;
    }

}
