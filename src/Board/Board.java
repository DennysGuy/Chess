package Board;
import pieces.*;

public class Board {
    private Square[][] board = new Square[8][8];
 /*
 What the board will look like
 _|X   0    1   2   3   4   5   6   7
 Y  ====================================
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

        //initialize empty squares
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Square(i,j,null);
            }
        }

        //team white
        board[7][0] = new Square(7,0,new Rook(true));
        board[7][1] = new Square(7,1,new Knight(true));
        board[7][2] = new Square(7,2,new Bishop(true));
        board[7][3] = new Square(7,3,new Queen(true));
        board[7][4] = new Square(7,4,new King(true));
        board[7][5] = new Square(7,5,new Bishop(true));
        board[7][6] = new Square(7,6,new Knight(true));
        board[7][7] = new Square(7,7,new Rook(true));
        for(int i = 0; i < 7; i++){
            board[6][i] = new Square(1,i, new Pawn(true));
        }

        //create white pawns
        for(int i = 0; i < 8; i++){
            board[6][i] = new Square(6,i, new Pawn(true));
        }

    }

    public Square getSquare(final int x, final int y){
        if (x < 0 || x > 7 || y < 0 || y > 7){
            throw new IllegalArgumentException("Out of Bounds");
        }

        return board[x][y];
    }

    public void printBoard(){
        System.out.println("     0    1   2   3   4   5   6   7");
        System.out.println("  ====================================");
        for(int i = 0; i < 8; i++){
            System.out.print(i + " | ");
            for(int j = 0; j < 8; j++){
                System.out.print(board[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("  ====================================");
    }

    @Override
    public String toString(){


        return "test";

    }

}
