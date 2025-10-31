

public class Board {
    int cols = 3;
    int rows = 3;
    char[][] board = new char[rows][cols];

    public char[][] makeBoard() {
        //Make board blank
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

    //format board
    public void printBoard() {
        System.out.println("     1     2    3   ");
        for (int i = 0; i < cols; i++) {
            System.out.println("   -----------------");
            System.out.print((i + 1) + "  ||");
            for (int j = 0; j < rows; j++) {
                System.out.print(" " + board[i][j] + " ||");
            }
            System.out.println();
        }
        System.out.println("   ------------------");
    }

    //Update board X
    public boolean updateBoardP1(int row, int col) {
       if (row < 0 || row > 2 || col < 0 || col > 2) {
           System.out.println("Invalid row or column. Try Again.");
           return false;
       }
       else if (board[row][col] != '.'){
            System.out.println("That has already been marked! Try Again.");
            return false;
        } else {
            board[row][col] = 'X';
            return true;
        }
    }


    public boolean updateBoardP2(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("That is not a valid row or column. Try Again.");
            return false;
        }
        else if (board[row][col] != '.'){
            System.out.println("That has already been marked! Try Again.");
            return false;
        } else {
            board[row][col] = 'O';
            return true;
        }
    }

    public boolean checkWinP1() {
        boolean hasWon = true;
        //check horizontal
        for (int i = 0; i < rows; i++) {
            hasWon = true;
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != 'X') {
                    hasWon = false;
                    break;
                }
            }
            if (hasWon) {
                return true;
            }
        }
        //check vertical
        for (int i = 0; i < cols; i++) {
            hasWon = true;
            for (int j = 0; j < rows; j++) {
                if (board[j][i] != 'X') {
                    hasWon = false;
                    break;
                    }
                }
            if (hasWon) {
                return true;
            }

        }
//check diagonal
        for (int i = 0; i < rows; i++){
            hasWon = true;
            if (board[i][i] != 'X'){
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }
            //check counter diagonal
        for (int i = 0; i < rows; i++){
            hasWon = true;
            int j = 2 - i;
            if (board[i][j] != 'X'){
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }
//if nothing wins
                return false;
    }

//P2 Win checker
public boolean checkWinP2() {
    boolean hasWon = true;
    //check horizontal
    for (int i = 0; i < rows; i++) {
        hasWon = true;
        for (int j = 0; j < cols; j++) {
            if (board[i][j] != 'O') {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }
    }
    //check vertical
    for (int i = 0; i < cols; i++) {
        hasWon = true;
        for (int j = 0; j < rows; j++) {
            if (board[j][i] != 'O') {
                hasWon = false;
                break;
            }
        }
        if (hasWon) {
            return true;
        }

    }
//check diagonal
    for (int i = 0; i < rows; i++){
        hasWon = true;
        if (board[i][i] != 'O'){
            hasWon = false;
            break;
        }
    }
    if (hasWon) {
        return true;
    }
    //check counter diagonal
    for (int i = 0; i < rows; i++){
        hasWon = true;
        int j = 2 - i;
        if (board[i][j] != 'O'){
            hasWon = false;
            break;
        }
    }
    if (hasWon) {
        return true;
    }
//if nothing wins
    return false;
}
//checks for full board
public boolean checkTie(){
        boolean hasTied = true;
        for (int i = 0; i <rows; i++){
            for (int j = 0; j < cols; j++){
                if (board[i][j] == '.'){
                    hasTied = false;

                }
            }
        }
        if (hasTied) {return true;}
        return false;
}
        }



