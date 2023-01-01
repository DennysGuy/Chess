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

        boolean newMove = move.newMove(board, board.getSquare(Integer.parseInt(startCoordinates[0]),Integer.parseInt(startCoordinates[1])), board.getSquare(Integer.parseInt(endCoordinates[0]),Integer.parseInt(endCoordinates[1])), this.getPlayer(),game);

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

        boolean newMove = move.newMove(board, board.getSquare(Integer.parseInt(startCoordinates[0]),Integer.parseInt(startCoordinates[1])), board.getSquare(Integer.parseInt(endCoordinates[0]),Integer.parseInt(endCoordinates[1])), this.getPlayer(),game);


        if (newMove == true) {
            this.setPlayer(true);
        }
    }



}
