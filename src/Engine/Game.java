package Engine;
import Board.*;
import pieces.*;
import java.util.*;

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
        String coordinates;
        String[] startCoordinates;
        String[] endCoordinates;
                /*
                ~ get coordinates for player's starting square and players ending square
                ~ insert coordinates into new squares which will be placed into a new move object
                ~ end player turn
                */
        System.out.println("Player One's Turn!");

        System.out.println("Enter row and column for desired piece (separate with a ',' ex: 4,3): ");
        coordinates = inp.nextLine();

        startCoordinates = coordinates.split(",");

        System.out.println("Enter row and column for square you want to move to (separate with a ',' ex: 4,3): ");
        coordinates = inp.nextLine();

        endCoordinates = coordinates.split(",");

        Move move = new Move();

        boolean newMove = move.newMove(board, board.getSquare(Integer.parseInt(startCoordinates[0]),Integer.parseInt(startCoordinates[1])), board.getSquare(Integer.parseInt(endCoordinates[0]),Integer.parseInt(endCoordinates[1])), this.getPlayer());

        if (newMove == true) {
            this.setPlayer(false);
        }
    }

    public void playerTwoMove(Scanner inp, Board board){
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

        boolean newMove = move.newMove(board, board.getSquare(Integer.parseInt(startCoordinates[0]),Integer.parseInt(startCoordinates[1])), board.getSquare(Integer.parseInt(endCoordinates[0]),Integer.parseInt(endCoordinates[1])), this.getPlayer());


        if (newMove == true) {
            this.setPlayer(true);
        }
    }



}
