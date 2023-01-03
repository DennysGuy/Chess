package pieces;

import Board.*;
import Engine.*;

import java.util.Objects;

public class King extends Piece{
    private boolean castling  = false;
    private boolean firstMove = true;

    public King(boolean white){
        super(white);
        this.setPieceName("King");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        King king = (King) o;
        return castling == king.castling && firstMove == king.firstMove;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), castling, firstMove);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {

        /*
            ~ Movement mechanics:
                - The king can advance 1 square in any direction
            ~ it should be notified if a King is put into check
            ~the king's capturing mechanic works the same as the movement mechanic
                - the king can move to a square that is either empty or has an opposing piece occupying it
         */
        int destX = Math.abs(start.getX()-end.getX());
        int destY = Math.abs(start.getY()-end.getY());

        boolean validMove = false;

        if (player == true && start.getPiece().isWhite() == true) {
            //player one code
            if (end.getPiece() == null || end.getPiece().isWhite() == false) {
                validMove = kingMovement(destX,destY);
            }

        }else{
            //player two code
            if (end.getPiece() == null || end.getPiece().isWhite() == true){
                validMove = kingMovement(destX,destY);
            }
        }

        return validMove;
    }

    //check if king can castle
    public boolean canCastle(Board board, Square start, Square end, boolean player){
        /*
        ~ On the King's first turn, the King has the ability to "castle"
                - castling is when the king moves 2 squares in either horizontal directions to which then a rook moves one square across the King to the opposite side (i.e.: if king moved two squares left, the rook on the left will automatically move one square to right of the king)
                - castling can only occur if a few conditions are (aren't) met:
                    - if both the king and the rook that are castling haven't made a move prior
                    - if the king is not already in check
                    - the king cannot castle to a position that will put it in check
                    - the king cannot castle through a check
         */

        int destX = Math.abs(start.getX()-end.getX());
        int destY = Math.abs(start.getY()-end.getY());

        //return false if the square is not 2 away horizontally from start and square is occupied
        if ((destX + destY) != 2 && end.getPiece() != null)
            return false;

        //return false if king is in check
        if (start.getPiece().getPieceName().equals("King") && start.getPiece().inCheck() == true)
            return false;

        //return false if in pawn, queen, king or rook check position (diagonals)




        //return false if in knight check position (over two, up one | over one up two)

        //return false if rook or king is in check position (horizontals and verticals)


        return true;
    }

    public boolean kingMovement(int destX, int destY){
        if ((Math.abs(destX - destY) == 1) || (destX * destY == 1)) {
            return true;
        }
        return false;
    }

    //getters
    public boolean verticalHorizontalPieceCheck(Square square, Board board){
        //horizontal check
        for(int i = 0; i < 7; i++){
            if (board.getSquare(square.getX(),i).getPiece().getPieceName().equals("Rook") || board.getSquare(square.getX(),i).getPiece().getPieceName().equals("Queen"));
            return true;
        }

        //vertical check
        for (int i = 0; i < 7; i++){
            if (board.getSquare(i,square.getY()).getPiece().getPieceName().equals("Rook") || board.getSquare(i,square.getY()).getPiece().getPieceName().equals("Queen"));
            return true;
        }

        return false;
    }

    public boolean diagonalRayCast(Square start, Square end, int startRow, int endRow, int starCol, int endCol, Board board){
        return false;
    }

    public boolean knightRayCast(Square start, Square end, Board board){
        return false;
    }


    //setters



    @Override
    public String toString(){
        if(isWhite()){
            return "[ K]";
        }else {
            return "[*K]";
        }
    }

}
