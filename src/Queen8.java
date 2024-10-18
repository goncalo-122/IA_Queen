public class Queen8 {
    private static final int SIZE = 8;
    private int[] board;


    public Queen8(){
        board = new int[SIZE];
    }

    private void position(int row) {
        for (int col = 0; col < SIZE; col++) {
            board[row] = col;
            if (isSafe(row, col)) {
                System.out.println("Entrou");
                if (row == SIZE - 1) {
                    return;
                } else {
                    position(row + 1);
                }
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
        printBoard();
//        if (position(0)) {
//            printBoard();
//        } else {
//            System.out.println("No solution found");
//        }
    }
}
