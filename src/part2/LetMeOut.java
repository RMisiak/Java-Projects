/*
 * Name: LetMeOut
 * Date: March 21, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: This program runs through a maze and finds the correct path to the exit.
 */
package part2;

/**
 *
 * @author 1misiakrya
 */
public class LetMeOut {

    private static final char WALL = 'W';
    private static final char EXIT = 'X';
    private static final char OPEN = '.';
    private static final char TRIED = '-';
    private static final char GOOD_PATH = '+';

    private char[][] maze = {
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
        {'W', '.', '.', '.', 'W', '.', '.', '.', '.', '.', '.', '.', 'W'},
        {'W', '.', 'W', '.', 'W', '.', 'W', 'W', 'W', '.', 'W', 'W', 'W'},
        {'W', '.', 'W', '.', '.', '.', 'W', 'W', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', '.', 'W', '.', 'W', 'W', '.', 'W', 'W', 'W', 'W'},
        {'W', '.', 'W', 'W', 'W', 'W', 'W', '.', '.', '.', '.', '.', 'W'},
        {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'X', 'W', 'W', 'W'}
    };

    /**
     * Display the current maze.
     *
     * @param row
     * @param col
     * @return
     */
    public boolean findExitFrom(int row, int col) {
        boolean successful = false;

        displayMaze();

        if (maze[row][col] == EXIT) {
            successful = true;
        } else {
            maze[row][col] = TRIED;
            //RIGHT
            if (maze[row][col + 1] != TRIED && maze[row][col + 1] != WALL && !successful) {
                successful = findExitFrom(row, col + 1);
            }

            //DOWN
            if (maze[row + 1][col] != TRIED && maze[row + 1][col] != WALL && !successful) {
                successful = findExitFrom(row + 1, col);
            }

            //LEFT
            if (maze[row][col - 1] != TRIED && maze[row][col - 1] != WALL && !successful) {
                successful = findExitFrom(row, col - 1);
            }

            //UP
            if (maze[row - 1][col] != TRIED && maze[row - 1][col] != WALL && !successful) {
                successful = findExitFrom(row - 1, col);
            }
        }

        if (successful) {
            maze[row][col] = GOOD_PATH;
        }

        return successful;

    }

    /**
     * Display the current maze.
     */
    public void solve() {

        // FIND RANDOM START LOCATION
        int row;
        int col;
        do {
            row = (int) (Math.random() * maze.length);
            col = (int) (Math.random() * maze[0].length);
        } while (maze[row][col] != OPEN);

        // START!
        System.out.println("START LOCATION: (" + row + "," + col + ")");
        findExitFrom(row, col);

        // SHOW EXIT
        displayMaze();
    }

    /**
     * Display the current maze.
     */
    public void displayMaze() {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                System.out.print(maze[row][col]);
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LetMeOut lmo = new LetMeOut();
        lmo.displayMaze();
        lmo.solve();

    }
}
