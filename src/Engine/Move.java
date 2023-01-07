package Engine;

import Board.*;
import pieces.*;

import java.util.Objects;
import java.util.Scanner;

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
    private boolean promotion = false;

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

    public boolean newMove(Board board, Square start, Square end, boolean player, Game game){
        this.start = start;
        this.end = end;
        boolean promotion = this.promotion;

        //check to see if square is empty
        if (start.getPiece().canMove(board, start, end, player) == true){

            if (end.getPiece() != null && end.getPiece().getPieceName().equals("King")){
                if (game.getPlayer() == true) {
                    game.setState(GameState.WHITE_WIN);
                }else{
                    game.setState(GameState.BLACK_WIN);
                }
            }

            end.setPiece(start.getPiece());
            start.setPiece(null);

            System.out.println("\n***Move Successful!***");

            /*
            Will be refactored into its own method eventually.
            This is just for general testing of the logic.
             */

            promotion = promotionCheck(end, board);
            if(promotion){
                System.out.println("Pawn promoted! Please enter your desired new piece(Ex: Q, R, B, or N):");
                Scanner input = new Scanner(System.in);
                String newPiece = null;
                while(promotion){
                    newPiece = input.nextLine();
                    if(newPiece.equals("Q")){
                        if(end.getPiece().isWhite()) {
                            end.setPiece(new Queen(true));
                        }else{
                            end.setPiece(new Queen(false));
                        }
                        promotion = false;

                    }else if(newPiece.equals("R")){
                        if(end.getPiece().isWhite()) {
                            end.setPiece(new Rook(true));
                        }else{
                            end.setPiece(new Rook(false));
                        }
                        promotion = false;

                    }else if(newPiece.equals("B")){
                        if(end.getPiece().isWhite()) {
                            end.setPiece(new Bishop(true));
                        }else{
                            end.setPiece(new Bishop(false));
                        }
                        promotion = false;

                    }else if(newPiece.equals("N")){
                        if(end.getPiece().isWhite()) {
                            end.setPiece(new Knight(true));
                        }else{
                            end.setPiece(new Knight(false));
                        }
                        promotion = false;

                    }else{
                        System.out.println("Invalid input, please enter a single character.");
                    }
                }
            }
            return true;
        }else{
            System.out.println("\n***Invalid Move, Try Again!***");
            return false;
        }



    }

    public boolean newCastle(Board board, Square start, Square end, boolean player, Game game){
        if (start.getPiece().getPieceName().equals("King") && (start.getPiece().isCastling()) == true){
            end.setPiece(start.getPiece());
            start.setPiece(null);

            //handle rook movement for team black and white
            boolean rookMove = newMove(board,board.getSquare(1,2),board.getSquare(end.getY()-1,end.getX()),player,game);

        }
        return false;
    }

    public boolean promotionCheck(Square end, Board board){

        //checking if the piece is a pawn.
        if(end.getPiece().getPieceName().equals("Pawn")){
            if(end.getPiece().isWhite() && end.getX() == 0){
                return true;
            }
            else if(!(end.getPiece().isWhite()) && end.getX() == 7){
                return true;
            }
            return false;
        }
        return false;
    }

    public Square getStart(){
        return this.start;
    }

    public Square getEnd(){
        return this.end;
    }


}
