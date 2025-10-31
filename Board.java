public class Board {
    int cols = 3;
    int rows = 3;
    char[][] board;

    //Create two - dimensional array which will hold data of board
    public Board() {
        this.board = new char[this.rows][this.cols];
    }

    //Initialize board to blank
    public char[][] makeBoard() {
        for(int i = 0; i < this.cols; ++i) {
            for(int j = 0; j < this.rows; ++j) {
                this.board[i][j] = '.';
            }
        }

        return this.board;
    }

    //Print board whenever needed
    public void printBoard() {
        System.out.println("     1     2    3   ");

        for(int i = 0; i < this.cols; ++i) {
            System.out.println("   -----------------");
            System.out.print(i + 1 + "  ||");

            for(int j = 0; j < this.rows; ++j) {
                System.out.print(" " + this.board[i][j] + " ||");
            }

            System.out.println();
        }

        System.out.println("   ------------------");
    }

    //When given row and col, check to see if already full, and that it is a valid column for X's
    public boolean updateBoardP1(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (this.board[row][col] != '.') {
                System.out.println("That has already been marked! Try Again.");
                return false;
            } else {
                this.board[row][col] = 'X';
                return true;
            }
        } else {
            System.out.println("Invalid row or column. Try Again.");
            return false;
        }
    }
    //Same as updateBoardP1 just with O's
    public boolean updateBoardP2(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (this.board[row][col] != '.') {
                System.out.println("That has already been marked! Try Again.");
                return false;
            } else {
                this.board[row][col] = 'O';
                return true;
            }
        } else {
            System.out.println("That is not a valid row or column. Try Again.");
            return false;
        }
    }

    //Logic to check for a win with 'x's
    public boolean checkWinP1() {
        boolean hasWon = true;

        for(int i = 0; i < this.rows; ++i) {
            hasWon = true;

            for(int j = 0; j < this.cols; ++j) {
                if (this.board[i][j] != 'X') {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true;
            }
        }

        for(int i = 0; i < this.cols; ++i) {
            hasWon = true;

            for(int j = 0; j < this.rows; ++j) {
                if (this.board[j][i] != 'X') {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true;
            }
        }

        for(int i = 0; i < this.rows; ++i) {
            hasWon = true;
            if (this.board[i][i] != 'X') {
                hasWon = false;
                break;
            }
        }

        if (hasWon) {
            return true;
        } else {
            for(int i = 0; i < this.rows; ++i) {
                hasWon = true;
                int j = 2 - i;
                if (this.board[i][j] != 'X') {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true;
            } else {
                return false;
            }
        }
    }

    //Logic to check for a win with 'O's
    public boolean checkWinP2() {
        boolean hasWon = true;

        for(int i = 0; i < this.rows; ++i) {
            hasWon = true;

            for(int j = 0; j < this.cols; ++j) {
                if (this.board[i][j] != 'O') {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true;
            }
        }

        for(int i = 0; i < this.cols; ++i) {
            hasWon = true;

            for(int j = 0; j < this.rows; ++j) {
                if (this.board[j][i] != 'O') {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true;
            }
        }

        for(int i = 0; i < this.rows; ++i) {
            hasWon = true;
            if (this.board[i][i] != 'O') {
                hasWon = false;
                break;
            }
        }

        if (hasWon) {
            return true;
        } else {
            for(int i = 0; i < this.rows; ++i) {
                hasWon = true;
                int j = 2 - i;
                if (this.board[i][j] != 'O') {
                    hasWon = false;
                    break;
                }
            }

            if (hasWon) {
                return true;
            } else {
                return false;
            }
        }
    }

    //Logic to check for a tie
    public boolean checkTie() {
        boolean hasTied = true;

        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.cols; ++j) {
                if (this.board[i][j] == '.') {
                    hasTied = false;
                }
            }
        }

        if (hasTied) {
            return true;
        } else {
            return false;
        }
    }
}

