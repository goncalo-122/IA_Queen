public class Queen8 {
    private static final int SIZE = 8;
    private int[] board;
    private boolean solutionFound = false;

    public Queen8(){
        board = new int[SIZE];
    }

    private void position(int row) {
        if (row == SIZE) {
            printBoard();
            solutionFound = true;
            return;
        }

        for (int col = 0; col < SIZE; col++) {
            if (solutionFound) return;
            board[row] = col;
            if (isSafe(row, col)) {
                position(row + 1);
            }
        }
        board[row] = -1;
    }


    private boolean isSafe(int row, int col) {
        int i;
        for ( i = 0; i < row; i++) {

            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
        private void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row] == col) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public void solve() {
        position(0);
    }
}
