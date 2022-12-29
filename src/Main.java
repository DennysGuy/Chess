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

        }while(choice < 0);


        if (choice == 1) {
            clearConsole();
            //initialize game class here
            GameState state = GameState.ACTIVE;
            Game newGame = new Game(state);
        }
        else if (choice == 2){
            System.out.println("create a static method for rules");
        }
        else if (choice == 3){
            System.exit(0);

        }
    }

    public static void menu(){
        System.out.println("               ~CHESS~");
        System.out.println("        By Tanner and Matt");
        System.out.println("====================================");
        System.out.println("        1. Start a new game");
        System.out.println("        2. How to Play");
        System.out.println("        3. Exit");
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