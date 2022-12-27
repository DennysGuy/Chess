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
            Board board = new Board();
            board.printBoard();
        }
    }
}