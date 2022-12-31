package Engine;

import Board.*;
import pieces.*;

import java.util.Objects;

   /*
    1. Player will input an x and y coordinate for the piece they want to move.
    2. Check the square for a piece.
        - if the square is not empty, check to see if the piece is the player's piece
            - player 1 gets white pieces
            - player 2 gets black pieces
    3. Save contents of starting square - contents of piece will be in start
    4. Check ending square.
        - check to see if it is a valid coordinate (limited to the specific piece and boundaries of the board -> cannot exceed 0 or 7 on x or y axis)
    5. If it is a valid coordinate, empty the starting square (making all contents null)
       and transfer the stored contents from the starting square into the ending square.

    6. Check to see if it is a winning move (checkmate king).

    7. If not a winning move, end turn for that specific player.

    */

public class Move {
    private Square start;
    private Square end;
    private Piece piece;

    public Move(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return Objects.equals(start, move.start) && Objects.equals(end, move.end) && Objects.equals(piece, move.piece);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, piece);
    }

    public boolean newMove(Board board, Square start, Square end, boolean player){
        this.start = start;
        this.end = end;

        //check to see if square is empty
        if (start.getPiece().canMove(board, start, end, player) == true){
            end.setPiece(start.getPiece());
            start.setPiece(null);


            System.out.println("\n***Move Successful!***");
            return true;


        }else{
            System.out.println("\n***Invalid Move, Try Again!***");
            return false;
        }



    }

    public Square getStart(){
        return this.start;
    }

    public Square getEnd(){
        return this.end;
    }


}
