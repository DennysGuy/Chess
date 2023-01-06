package Engine;
import Board.*;
import pieces.*;
import java.util.*;

import java.util.Scanner;

public class Game {
    GameState state;
    boolean playerOne = true;

    int choice = -1;
    //set up game loop
    public Game(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return playerOne == game.playerOne && state == game.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, playerOne);
    }



    //Getter
    public boolean getPlayer(){
        return this.playerOne;
    }

    public GameState getState(){
        return this.state;
    }

    //Setters
    public void setPlayer(boolean player){
        this.playerOne = player;
    }

    public void setState(GameState state){
        this.state = state;

    }

    public void playerOneMove(Scanner inp, Board board, Game game){
        String coordinates;
        String[] startCoordinates;
        String[] endCoordinates;
                /*
                ~ get coordinates for player's starting square and players ending square
                ~ insert coordinates into new squares which will be placed into a new move object
                ~ end player turn
                */
        System.out.println("Player One's Turn!");

        System.out.println("Enter row and column for desired piece (separate with a ',' i.e.: row, column): ");
        coordinates = inp.nextLine();

        startCoordinates = coordinates.split(",");

        System.out.println("Enter row and column for square you want to move to (separate with a ',' i.e: row, column): ");
        coordinates = inp.nextLine();

        endCoordinates = coordinates.split(",");

        Move move = new Move();

        int startX = Integer.parseInt(startCoordinates[0]);
        int startY = Integer.parseInt(startCoordinates[1]);

        int endX = Integer.parseInt(endCoordinates[0]);
        int endY = Integer.parseInt(endCoordinates[1]);

        boolean newMove = move.newMove(board, board.getSquare(startX,startY), board.getSquare(endX,endY), this.getPlayer(),game);

        this.isKingInCheck(board);



        if (newMove == true) {
            this.setPlayer(false);
        }
    }

    public void playerTwoMove(Scanner inp, Board board, Game game){
        String coordinates;
        String[] startCoordinates;
        String[] endCoordinates;
                /*
                ~ get coordinates for player's starting square and players ending square
                ~ insert coordinates into new squares which will be placed into a new move object
                ~ end player turn
                */
        System.out.println("Player Two's Turn!");

        System.out.println("Enter row and column for desired piece (separate with a ',' i.e.: row,column): ");
        coordinates = inp.nextLine();

        startCoordinates = coordinates.split(",");

        System.out.println("Enter row and column for square you want to move to (separate with a ',' i.e.: row,column): ");
        coordinates = inp.nextLine();

        endCoordinates = coordinates.split(",");

        Move move = new Move();

        int startX = Integer.parseInt(startCoordinates[0]);
        int startY = Integer.parseInt(startCoordinates[1]);

        int endX = Integer.parseInt(endCoordinates[0]);
        int endY = Integer.parseInt(endCoordinates[1]);

        boolean newMove = move.newMove(board, board.getSquare(startX,startY), board.getSquare(endX,endY), this.getPlayer(),game);

        if (newMove == true) {
            this.setPlayer(true);
        }
    }

    public boolean isKingInCheck(Board board){

        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if(board.getSquare(i,j).getPiece().equals("King")){
                    Square king = board.getSquare(i,j);
                    if (horizontalPieceCheck(king,board) || verticalPieceCheck(king,board) || knightCheck(king,board) || diagonalPieceCheck(king,board))
                        return true;
                }
            }
        }

        return false;
    }



    public boolean horizontalPieceCheck(Square square, Board board){
        //horizontal check -- start at the end of the row and work your way up until we hit
        for(int i = 0; i < 7; i++){
            //need to check if spaces in between opposing piece and king are null
            if (board.getSquare(square.getX(),i).getPiece().getPieceName().equals("Rook") && board.getSquare(square.getX(),i).getPiece().isWhite() != square.getPiece().isWhite()
                    || board.getSquare(square.getX(),i).getPiece().getPieceName().equals("Queen") && board.getSquare(square.getX(),i).getPiece().isWhite() != square.getPiece().isWhite()){
                //once a piece is found, check squares for piece in between found piece and king - if a piece is found, return false as a Queen or Rook cannot jump over any other piece
                //we need to re-write using min or max so that we can check if the piece found X is greater or less than the king's orientation
                int minCol = Math.min(square.getY(),i);
                int maxCol = Math.max(square.getY(),i);
                for (int j = board.getSquare(square.getX(),minCol).getY(); j < maxCol;j++) {
                    if (board.getSquare(square.getX(), j).getPiece() != null)
                        return false;
                }
                return true;
            }
        }
        return false;
    }

    public boolean verticalPieceCheck(Square square, Board board){
        //vertical check
        for (int i = 0; i < 7; i++){
            if (board.getSquare(i,square.getY()).getPiece().getPieceName().equals("Rook") && board.getSquare(i,square.getY()).getPiece().isWhite() != square.getPiece().isWhite()
                    || board.getSquare(i,square.getY()).getPiece().getPieceName().equals("Queen") && board.getSquare(i,square.getY()).getPiece().isWhite() != square.getPiece().isWhite()){
                int minRow = Math.min(square.getX(),i);
                int maxRow = Math.max(square.getX(),i);
                for (int j = board.getSquare(minRow,square.getY()).getX(); j < maxRow;j++)
                    if (board.getSquare(j,square.getY()).getPiece() != null)
                        return false;
            }
            return true;
        }
        return false;
    }

    public boolean diagonalPieceCheck(Square piece,  Board board){

        int startRow = 0;
        int endRow   = 0;

        int startCol = 0;
        int endCol   = 0;

        for (int i = 0;i < 7; i++){
            for(int j = 0; j < 7; j++){
                if (Math.abs(board.getSquare(i,j).getX() - board.getSquare(i,j).getY()) == Math.abs(piece.getX()-piece.getY())){
                    if (board.getSquare(i,j).getPiece().equals("Rook") && board.getSquare(i,j).getPiece().isWhite() != piece.getPiece().isWhite()
                            || board.getSquare(i,j).getPiece().equals("Queen") && board.getSquare(i,j).getPiece().isWhite() != piece.getPiece().isWhite())
                        //check if squares between Rook/Queen and King are empty, if they are return true, if not, return false
                        startRow = Math.min(board.getSquare(i,j).getX(),piece.getX());
                        endRow   = Math.max(board.getSquare(i,j).getX(),piece.getY());

                        startCol = Math.min(board.getSquare(i,j).getY(),piece.getY());
                        endCol   = Math.max(board.getSquare(i,j).getY(),piece.getY());

                        for(int k = startRow+1; k < endRow; k++){
                            for(j = startCol+1; j < endCol; j++){
                                if (board.getSquare(j,k) != null)
                                    return false;
                            }
                        }

                        return true;
                }
            }
        }

        return false;
    }

    public boolean knightCheck(Square start, Board board){

        /*
           ****need to check if square coords are not out of boundary****
                 -- when check up 2 and to the left or right 1:
                        -- X needs to be at max 5/at min 2 as we need at least two squares going up or down
                        -- When check to the right, Y can be no less than 0, when checking the left - Y can be no greater than 7
                 -- when check to the left or right 2 and up or down 1:
                        -- Y needs to be at max 5/at min 2 as we need at least two squares going left or right
                        -- When checking up, X can be no greater than 7/ when checking down, X can be no less than 0

        */

        if (start.getY() > 0 && start.getX() < 1) {
            //check if knight is up 2 and over 1 to the left
            if (board.getSquare(start.getX() + 2, start.getY() - 1) != null && board.getSquare(start.getX() + 2, start.getY() - 1).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX() + 2, start.getY() - 1).getPiece().isWhite() != start.getPiece().isWhite()) {
                return true;
            }
        }

        if(start.getY() < 7 && start.getX() < 1) {
            //check if knight is up 2 and over 1 to the right
            if (board.getSquare(start.getX() + 2, start.getY() + 1).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX() + 2, start.getY() + 1).getPiece().isWhite() != start.getPiece().isWhite()) {
                return true;
            }
        }

        if (start.getY() > 0 && start.getX() < 6){
            //check if knight is down 2 over 1 to the left
            if (board.getSquare(start.getX()-2,start.getY()-1).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX()-2,start.getY()-1).getPiece().isWhite() != start.getPiece().isWhite()){
                return true;
            }
        }

        if (start.getY() < 7 && start.getX() < 6) {
            //check if knight is down 2 over 1 to the right
            if (board.getSquare(start.getX() - 2, start.getY() + 1).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX() - 2, start.getY() + 1).getPiece().isWhite() != start.getPiece().isWhite()) {
                return true;
            }
        }

        if (start.getY() < 1 && start.getX() < 7) {
            //check if knight is to the left 2 and down one
            if (board.getSquare(start.getX() + 1, start.getY() - 2).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX() + 1, start.getY() - 2).getPiece().isWhite() != start.getPiece().isWhite()) {
                return true;
            }
        }

        if (start.getY() < 1 && start.getX() > 0) {
            //check if knight is to the left 2 and up one
            if (board.getSquare(start.getX() - 1, start.getY() - 2).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX() - 1, start.getY() - 2).getPiece().isWhite() != start.getPiece().isWhite()) {
                return true;
            }
        }

        if (start.getY() < 6 && start.getX() < 0) {
            //check if knight is to the right 2 and down one
            if (board.getSquare(start.getX() + 1, start.getY() + 2).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX() + 1, start.getY() + 2).getPiece().isWhite() != start.getPiece().isWhite()) {
                return true;
            }
        }

        if (start.getY() < 6 && start.getX() > 7)
            //check if knight it to the right 2 and up one
            if (board.getSquare(start.getX()-1,start.getY()+2).getPiece().getPieceName().equals("Knight") && board.getSquare(start.getX()-1,start.getY()+2).getPiece().isWhite() != start.getPiece().isWhite()){
                return true;
            }

        return false;
    }



}
