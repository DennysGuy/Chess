package Engine;
import Board.*;
import pieces.*;

import java.util.Scanner;

public class Game {
    GameState state = GameState.OFF;
    String whiteTurn = "White's turn: ";
    String blackTurn = "Black's turn: ";
    String invalidTurn = "Invalid turn.";
    boolean playerOne = true;
    //set up the game loop
    /*
        turn 1 = white
        white goes
        change team
        turn 2 = black

        initialize game in active state



     */
    public Game(GameState state){
        this.state = state;
        Board board = new Board();
        Scanner inp = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();

        int i = 0;
        int j = 1;

        int choice = -1;

        while (state == GameState.ACTIVE){
            board.printBoard();

            if(playerOne == true){
                System.out.println(whiteTurn);
                choice = inp.nextInt();
                Square start = board.getSquare(i,j);
                Square end = board.getSquare(i,j);

                Move newMove = new Move(board, player1, start, end);

                newMove.getStart().getPiece();

                playerOne = false;

            }else if (!playerOne){
                System.out.println(blackTurn);
                choice = inp.nextInt();

                if (choice == 3) {
                    System.out.println("Black wins");
                    System.exit(0);

                }

                playerOne = true;
            }
        }
    }

    //Getter to check player
    public boolean isPlayerOne(){
        return this.playerOne;
    }



}
