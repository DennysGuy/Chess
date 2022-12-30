package pieces;

import Board.*;
import Engine.*;

public class Queen extends Piece{

    public Queen(boolean white){
        super(white);
    }


    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {



        // get the current row and column of the start square
        int startRow = start.getX();
        int startCol = start.getY();

        // get the current row and column of the end square
        int endRow = end.getX();
        int endCol = end.getY();

        //Creation of new square for checking.


        //Moving up on the board
        if(start.getX() < end.getX()){
            //Moving up & left on the board
            if(start.getY() > end.getY()){

            }
            //Moving up & right on the board.
            else if(start.getY() < end.getY()){

            }
            //Only moving up on the board.
            else{
                //Trying to get piece and iterate through here.
                for(int i = startRow + 1; i != endRow; i++){
                    //getPiece
                }


            }
        }


        //Moving down on the board.
        if(start.getX() > end.getX()) {
            //Moving down & left on the board
            if (start.getY() > end.getY()) {

            }
            //Moving down & right on the board.
            else if (start.getY() < end.getY()) {

            }
            //Only moving down on the board.
            else {

            }
        }

        //Moving right on the board.
        if(start.getY() > end.getY()){
            //Moving up & right on the board
            if(start.getX() < end.getX()){

            }
            //Moving down & right on the board
            else if (start.getX() > end.getX()){

            }
            //Only moving right on the board.
            else{

            }

        }


        //Moving left on the board.
        if(start.getY() < end.getY()){
            //Moving up & left on the board
            if(start.getX() < end.getX()){

            }
            //Moving down & left on the board
            else if (start.getX() > end.getX()){

            }
            //Only moving left on the board.
            else{

            }

        }

        return false;

    }

    @Override
    public String toString(){
        if(isWhite()){
            return "[ Q]";
        }else {
            return "[*Q]";
        }
    }
}
