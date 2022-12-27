package Board;
import pieces.*;

public class Board {
    private Square[][] board = new Square[8][8];
 /*
 What the board will look like
      0    1   2   3   4   5   6   7
   ====================================
 0 | [*R][*N][*B][*Q][*K][*B][*N][*R] |
 1 | [*P][*P][*P][*P][*P][*P][*P][*P] |
 2 | [  ][  ][  ][  ][  ][  ][  ][  ] |
 3 | [  ][  ][  ][  ][  ][  ][  ][  ] |
 4 | [  ][  ][  ][  ][  ][  ][  ][  ] |
 5 | [  ][  ][  ][  ][  ][  ][  ][  ] |
 6 | [ P][ P][ P][ P][ P][ P][ P][ P] |
 7 | [ R][ N][ B][ Q][ K][ B][ N][ R] |
   ====================================
   white pawn at [6,0]
   - if first turn can advance 2 squares ahead otherwise move 1 square
   - starting position [6,0] [4,0] start.getX() - end.getX() <=2 then its a valid move

  */
    public Board(){

        //team black
        board[0][0] = new Square(0,0,new Rook(false));
        board[0][1] = new Square(0,1,new Knight(false));
        board[0][2] = new Square(0,2,new Bishop(false));
        board[0][3] = new Square(0,3,new Queen(false));
        board[0][4] = new Square(0,4,new King(false));
        board[0][5] = new Square(0,5,new Bishop(false));
        board[0][6] = new Square(0,6,new Knight(false));
        board[0][7] = new Square(0,7,new Rook(false));

        //create black pawns
        for(int i = 0; i < 8; i++){
            board[1][i] = new Square(1,i, new Pawn(false));
        }

        //inialize empty squares
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 7; j++){
                board[i][j] = Square(i,j,null);
            }
        }

        //team white
        board[7][0] = Square(7,0,Rook(true));
        board[7][1] = Square(7,1,Knight(true));
        board[7][2] = Square(7,2,Bishop(true));
        board[7][3] = Square(7,3,Queen(true));
        board[7][4] = Square(7,4,King(true));
        board[7][5] = Square(7,5,Bishop(true));
        board[7][6] = Square(7,6,Knight(true));
        board[7][7] = Square(7,7,Rook(true));

    }

    @Override
    public String toString(){


        return "test";

    }

}
