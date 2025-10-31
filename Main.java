//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create scanner, and get player names
        Scanner input = new Scanner(System.in);
        System.out.println("Hello! Welcome to TikTacToe!");
        System.out.println("Who is playing? ");
        System.out.print("Player one: ");
        String playerOne = input.nextLine();
        System.out.print("Player two: ");
        String playerTwo = input.nextLine();
        //Inform players of their symbol
        System.out.println(playerOne + ", you are X.");
        System.out.println(playerTwo + ", you are O.");
        System.out.println(playerOne + ", you will go first");
        //Create instance of board and draw it
        Board board = new Board();
        board.makeBoard();
        board.printBoard();
        //These bools hold logic for game
        boolean win1 = false;
        boolean win2 = false;
        boolean check1 = false;
        boolean check2 = false;
        boolean tie = false;

        //While loop to go until winner
        while(!win1 || !win2) {
            int x;
            int y;
            for(boolean var12 = false; !var12; var12 = board.updateBoardP1(x, y)) {
                System.out.print(playerOne + ", which column would you like? ");
                x = input.nextInt() - 1;
                System.out.print("\n" + playerOne + ", which row would you like? ");
                y = input.nextInt() - 1;
            }

            board.printBoard();
            win1 = board.checkWinP1();
            tie = board.checkTie();
            if (win1) {
                System.out.println("Congrats " + playerOne + ", you won!");
                break;
            }

            if (tie) {
                System.out.println("CATS! You both tied.");
                break;
            }

            for(boolean var13 = false; !var13; var13 = board.updateBoardP2(x, y)) {
                System.out.print(playerTwo + ", which column would you like? ");
                x = input.nextInt() - 1;
                System.out.print("\n" + playerTwo + ", which row would you like? ");
                y = input.nextInt() - 1;
            }

            board.printBoard();
            win2 = board.checkWinP2();
            tie = board.checkTie();
            if (win2) {
                System.out.println("Congrats " + playerTwo + ", you won!");
            }

            if (tie) {
                System.out.println("CATS! You both tied.");
            }
        }

    }
}
