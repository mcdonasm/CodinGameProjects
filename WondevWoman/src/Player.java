import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int unitsPerPlayer = in.nextInt();

        // Init
        GameBoard gameBoard = new GameBoard(size);

        // game loop
        while (true) {
            // setup gameBoard
            for (int i = 0; i < size; i++) {
                String row = in.next();
                gameBoard.updateRow(i, row);
            }

            for (int i = 0; i < unitsPerPlayer; i++) {
                int unitX = in.nextInt();
                int unitY = in.nextInt();
            }
            for (int i = 0; i < unitsPerPlayer; i++) {
                int otherX = in.nextInt();
                int otherY = in.nextInt();
            }
            int legalActions = in.nextInt();
            for (int i = 0; i < legalActions; i++) {
                String atype = in.next();
                int index = in.nextInt();
                String dir1 = in.next();
                String dir2 = in.next();
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            Utils.log(gameBoard);

            System.out.println("MOVE&BUILD 0 N S");
        }
    }

    static class GameBoard {
        public int size;
        // Stored in row format, not columnar.
        // Think (y,x) when accessing/setting.
        public char[][] board;

        public GameBoard(int size) {
            if (size > 7 || size < 5) {
                throw new IllegalArgumentException("Board size is invalid: 5 <= size <= 7");
            }
            this.size = size;
            this.board = new char[size][size];
        }

        /**
         * Updates a row of the game board.
         * Remember that the board is a 2D array, stored in row format, not columnar.
         * <p>
         * If rowIndex = 2, then rowAsString is referring to the data as shown below.
         * That row is accessed by board[2]. Which means the position marked by 'X' is accessed via board[2][0]
         * _ _ _ _
         * 0 |
         * 1 |
         * 2 |X = = =
         * 3 |
         */
        public void updateRow(int rowIndex, String rowAsString) {
            board[rowIndex] = rowAsString.toCharArray();
        }

        /**
         * Returns a String representation of the GameBoard's data in the following format:
         * <p>
         * 0   1   2   3   4   5
         * --- --- --- --- --- ---
         * 0 | 0   0   0   0   0   0
         * 1 | 0   .   0   0   .   0
         * 2 | 0   0   1   0   0   0
         * 3 | 0   .   1   0   .   0
         * 4 | 0   0   0   1   0   0
         * 5 | 0   0   0   1   0   0
         */
        @Override
        public String toString() {
            String pretty = "   ";
            for (int i = 0; i < size; i++) {
                pretty += " " + i + "  ";
            }
            pretty += "\n   ";
            for (int i = 0; i < size; i++) {
                pretty += "--- ";
            }
            pretty += "\n";

            for (int i = 0; i < board.length; i++) {
                pretty += i + " | ";
                for (int j = 0; j < board[i].length; j++) {
                    pretty += board[i][j] + "   ";
                }
                pretty += "\n";
            }
            return pretty;
        }
    }

    static class Utils {
        public static void log(String message) {
            System.err.println(message);
        }

        public static void log(GameBoard gameBoard) {
            System.err.println(gameBoard.toString());
        }
    }

}