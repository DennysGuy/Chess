package Engine;
import Board.*;
import pieces.*;

import java.util.Scanner;

public class Game {
    GameState state;
    boolean playerOne = true;
    //set up game loop
    public Game(GameState state){
        this.state = state;
        Board board = new Board();
        Scanner inp = new Scanner(System.in);



        while (state == GameState.ACTIVE){
            System.out.println("get player is currently: " + getPlayer());
            board.printBoard();

            if(getPlayer() == true){
                playerOneMove(inp,board);

            }else {
                playerTwoMove(inp,board);
            }
        }
    }

    //Getter to check player
    public void setPlayer(boolean player){
        this.playerOne = player;
    }

    public boolean getPlayer(){
        return this.playerOne;
    }

    public void playerOneMove(Scanner inp, Board board){
        int[] pOneCoordinates  = new int[4];
                /*
                ~ get coordinates for player's starting square and players ending square
                ~ insert coordinates into new squares which will be placed into a new move object
                ~ end player turn
                */
        System.out.println("Player One's Turn!");

        System.out.println("\nEnter X coordinate for the piece You want to move: ");
        pOneCoordinates[0] = inp.nextInt();

        System.out.println("\nEnter Y coordinate for the piece you want to move: ");
        pOneCoordinates[1] = inp.nextInt();

        System.out.println("\nEnter X coordinate for the square you want to move to: ");
        pOneCoordinates[2] = inp.nextInt();

        System.out.println("\nEnter Y coordinate for the square you want to move to: ");
        pOneCoordinates[3] = inp.nextInt();

        Move move = new Move();
        move.newMove(board, board.getSquare(pOneCoordinates[0],pOneCoordinates[1]), board.getSquare(pOneCoordinates[2],pOneCoordinates[3]), this.getPlayer());

        boolean newMove = move.newMove(board, board.getSquare(pOneCoordinates[0],pOneCoordinates[1]), board.getSquare(pOneCoordinates[2],pOneCoordinates[3]), this.getPlayer());
        if (newMove == true) {
            this.setPlayer(false);
        }
    }

    public void playerTwoMove(Scanner inp, Board board){
        int[] pTwoCoordinates  = new int[4];

        System.out.println("Player Two's Turn!");

        System.out.println("\nEnter X coordinate for the piece You want to move: ");
        pTwoCoordinates[0] = inp.nextInt();

        System.out.println("\nEnter Y coordinate for the piece you want to move: ");
        pTwoCoordinates[1] = inp.nextInt();

        System.out.println("\nEnter X coordinate for the square you want to move to: ");
        pTwoCoordinates[2] = inp.nextInt();

        System.out.println("\nEnter Y coordinate for the square you want to move to: ");
        pTwoCoordinates[3] = inp.nextInt();

        Move move = new Move();

        boolean newMove = move.newMove(board, board.getSquare(pTwoCoordinates[0],pTwoCoordinates[1]), board.getSquare(pTwoCoordinates[2],pTwoCoordinates[3]), this.getPlayer());
        if (newMove == true) {
            this.setPlayer(true);
        }
    }



}
