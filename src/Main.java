import Board.*;
import Engine.*;
import pieces.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner kb = new Scanner(System.in);
        do{
            menu();
            System.out.print("Enter a choice: ");
            choice = kb.nextInt();

        }while(choice < 1 || choice > 3);

        if (choice == 1) {
            clearConsole();
            //initialize game class here
            Game game = new Game();

            game.setState(GameState.ACTIVE);

            Board board = new Board();
            Scanner inp = new Scanner(System.in);

            while (game.getState().equals(GameState.ACTIVE)){
                board.printBoard();
                if(game.getPlayer() == true){
                    game.playerOneMove(inp,board,game);

                }else {
                    game.playerTwoMove(inp,board,game);
                }
            }

            //win states
            if (game.getState().equals(GameState.WHITE_WIN)){
                board.printBoard();
                System.out.println("   Check Mate!  ");
                System.out.println("PLAYER ONE WINS!");

            }

            if (game.getState().equals(GameState.BLACK_WIN)){
                board.printBoard();
                System.out.println("   Check Mate!  ");
                System.out.println("PLAYER TWO WINS!");
            }

        }
        else if (choice == 2){
            System.out.println("create a static method for rules");
        }
        else if (choice == 3){
            System.exit(0);

        }
    }

    public static void menu(){

        String menu = "┌-----------------------┐\n"+
                      "|_________CHESS_________|\n"+
                      "|  By Matt M & Tanner S |\n"+
                      "|-----------------------|\n"+
                      "| 1. Start a new game   |\n"+
                      "| 2. How to play        |\n"+
                      "| 3. Exit               |\n"+
                      "└-----------------------┘\n";
        System.out.print(menu);

    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }
}