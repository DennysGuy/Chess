package pieces;

import Board.*;
import Engine.*;

public class Queen extends Piece{

    public Queen(boolean white){
        super(white);
        this.setPieceName("Queen");
    }


    @Override
    public boolean canMove(Board board, Square start, Square end, boolean player) {



        // get the current row and column of the start square
        int startRow = start.getX();
        int startCol = start.getY();

        // get the current row and column of the end square
        int endRow = end.getX();
        int endCol = end.getY();

        //Moving up on the board
        if(start.getX() > end.getX()){
            //Moving up & left on the board
            if(start.getY() > end.getY()){
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Moving up & right on the board.
            else if(start.getY() < end.getY()){
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Only moving up on the board.
            else{
                // check if the queen is moving vertically
                if (startCol == endCol) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
        }


        //Moving down on the board.
        if(start.getX() < end.getX()) {
            //Moving down & left on the board
            if (start.getY() > end.getY()) {
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Moving down & right on the board.
            else if (start.getY() < end.getY()) {
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Only moving down on the board.
            else {
                // check if the queen is moving vertically
                if (startCol == endCol) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
        }

        //Moving right on
        if(start.getY() > end.getY()){
            //Moving up & right on the board
            if(start.getX() < end.getX()){
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Moving down & right on the board
            else if (start.getX() > end.getX()){
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Only moving right on the board.
            else{
                // check if the queen is moving horizontally
                if (startRow == endRow) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }

        }


        //Moving left on the board.
        if(start.getY() < end.getY()) {
            //Moving up & left on the board
            if (start.getX() < end.getX()) {
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
            //Moving down & left on the board
            else if (start.getX() > end.getX()) {
                // check if the queen is moving diagonally
                if (Math.abs(startRow - endRow) == Math.abs(startCol - endCol)) {
                    // check if there are any pieces blocking the queen's path
                    if (isClearPath(board, start, end)) {
                        return true;
                    }
                }
            }
        }


        return false;

    }
    public boolean isClearPath(Board board,Square start, Square end) {
        // get the current row and column of the start square
        int startRow = start.getX();
        int startCol = start.getY();

        // get the current row and column of the end square
        int endRow = end.getX();
        int endCol = end.getY();


        if (startRow == endRow) {
            // check the squares between the start and end columns. Horizontal movements
            for (int col = Math.min(startCol, endCol); col < Math.max(startCol, endCol); col++) {
                //Check before it throws a null value and breaks the program.
                if (board.getSquare(startRow, col).getPiece() == null) continue;
                //This is for white
                if ((board.getSquare(startRow, col).getPiece().isWhite()) && start.getPiece().isWhite()) {
                    return false;
                }
                //This is for black.
                if (!(board.getSquare(startRow, col).getPiece().isWhite()) && !start.getPiece().isWhite()) {
                    return false;
                }
            }
            return true;
        }


        if (startCol == endCol) {
            // check the squares between the start and end rows. Vertical movements
            for (int row = Math.min(startRow, endRow); row < Math.max(startRow, endRow); row++) {
                //Check before it throws a null value and breaks the program.
                if (board.getSquare(row, startCol).getPiece() == null) continue;
                //This is for white.
                if ((board.getSquare(row, startCol).getPiece().isWhite()) && start.getPiece().isWhite()){
                    return false;
                }
                //This is for black.
                if (!(board.getSquare(row, startCol).getPiece().isWhite()) && !start.getPiece().isWhite()){
                    return false;
                }
            }
            return true;
        }

        if (Math.abs(endRow - startRow) == Math.abs(endCol - startCol)) {
            // diagonal movement calculation for direction of movement.
            int rowStep = (endRow - startRow) / Math.abs(endRow - startRow);
            int colStep = (endCol - startCol) / Math.abs(endCol - startCol);

            // Added a check for the case where the start and end positions are the same
            if (startRow == endRow && startCol == endCol) {
                return true;
            }

            // check the squares between the start and end squares
            for (int row = (startRow + rowStep), col = startCol + colStep; row != endRow + rowStep; row += rowStep, col += colStep) {
                //Check before it throws a null value and breaks the program.
                if (board.getSquare(row, col).getPiece() == null) continue;
                //This is for white.
                if ((board.getSquare(row, col).getPiece().isWhite()) && start.getPiece().isWhite()) {
                    return false;
                }
                //This is for black.
                if (!(board.getSquare(row, col).getPiece().isWhite()) && !start.getPiece().isWhite()) {
                    return false;
                }
            }
            return true;
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
