import Board.*;
import Engine.*;
import pieces.*;

public class Main {
    public static void main(String[] args) {
        int choice = -1;
        Scanner kb = new Scanner(System.in);
        do{
            menu();
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
}