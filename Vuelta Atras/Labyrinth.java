package tema5_bt;

public class Labyrinth {

    public static void printLabyrinth(int[][] board) {
        for (int j = 0; j < board.length; j++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    System.out.print("|  |");
                } else if (board[i][j] < 0) {
                    System.out.print("|XX|");
                } else {
                    System.out.format("|%2d|", board[i][j]);
                }
            }
            System.out.println();
            for (int j = 0; j < board[i].length; j++) {
                System.out.print("----");
            }
            System.out.println();
        }
    }

    public static boolean isFeasible(int[][] board, int r, int c) {
        if (r < board.length && r >= 0 && c < board.length && c >= 0) {
            return board[r][c] == 0;
        } else {
            return false;
        }
    }

    public static void labyrinth(int r, int c, int k, int[][] board) {
        board[r][c] = k;
        if (r == board.length-1 && c == board.length-1) {
            printLabyrinth(board);
        } else {
            if (isFeasible(board, r, c+1)) {
                labyrinth(r, c+1, k+1, board);
            }
            if (isFeasible(board, r+1, c)) {
                labyrinth(r+1, c, k+1, board);
            }
            if (isFeasible(board, r-1, c)) {
                labyrinth(r-1, c, k+1, board);
            }
            if (isFeasible(board, r, c-1)) {
                labyrinth(r, c-1, k+1, board);
            }
            board[r][c] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 0,  0, -1,  0,  0,  0,  0, -1,  0,  0},
                {-1,  0, -1,  0,  0, -1, -1,  0, -1,  0},
                { 0,  0,  0,  0,  0,  0, -1,  0, -1,  0},
                { 0, -1,  0,  0, -1, -1, -1,  0,  0,  0},
                { 0,  0, -1, -1,  0,  0,  0, -1,  0,  0},
                { 0,  0,  0,  0,  0, -1,  0, -1,  0,  0},
                {-1,  0,  0, -1, -1,  0,  0, -1,  0, -1},
                { 0, -1, -1,  0,  0,  0,  0,  0, -1, -1},
                {-1,  0,  0,  0,  0, -1,  0, -1, -1,  0},
                { 0,  0, -1,  0, -1, -1,  0,  0,  0,  0}
        };

        labyrinth(0, 0, 1, board);
    }
}
