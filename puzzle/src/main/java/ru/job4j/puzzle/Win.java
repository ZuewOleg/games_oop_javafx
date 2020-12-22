package ru.job4j.puzzle;

public class Win {
    public static boolean monoHorizontal(int[][] board, int row) { /* монострока */
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(int[][] board, int column) { /* моностолбец */
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean check(int[][] board) {
        boolean rsl = false;
        int[] w = new int[board.length];
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i][i] == 1) {
                if (monoHorizontal(board, i) || monoVertical(board, i)) {
                    rsl = true;
                    break;
                }
            }
        }
        return rsl;
    }
}
