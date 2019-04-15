public class NQueenProblem{


    public static boolean solveNQueen(int[][] board, int column){
        //caso base;
        if(isSolution(column)){
            return true;
        }else{
            for(int i = 0; i < N; i++){
                if(isFeaseble(board, i, column)){
                    board[i][column] = 1;
                    if(solveNQueen(board, column++)){
                        return true;
                    }
                    board[i][column] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSolution(int col){
        return (col == N);
    }

    public static boolean isFeaseble(int board[][], int row, int col){
        int i, j;

        for(i = 0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        for(i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
    }
}