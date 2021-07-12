package xenoteo.com.github.zigzag.medium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String packagePath = "src/xenoteo/com/github/zigzag/medium/";

        // in initialisation
        String inputFileName = "input.txt";
        Scanner in = new Scanner(new File(packagePath + inputFileName));

        int testCasesNumber = in.nextInt();
        int totalSum = 0;
        for (int t = 0; t < testCasesNumber; t++){
            // reading the grid
            in.nextLine();
            int[][] grid = new int[9][9];
            for (int i = 0; i < 9; i++) {
                String[] elements = in.nextLine().split(" ");
                for (int j = 0; j < 9; j++) {
                    if (elements[j].equals(".")) {
                        grid[i][j] = -1;
                    }
                    else {
                        grid[i][j] = Integer.parseInt(elements[j]);
                    }
                }
            }

            // counting the sum of the values of the top-left cells of all grids
            totalSum += solveAndFindUpperLeft(grid);
        }

        // out initialisation and writing output
        String outputFileName = "output.txt";
        FileWriter output = new FileWriter(packagePath + outputFileName);
        output.write(totalSum + "");
        output.close();
    }

    /**
     * Finds the value of the top-left cell of the provided grid.
     *
     * @param grid  the grid
     * @return the value of the top-left cell
     */
    private static int solveAndFindUpperLeft(int[][] grid) {
        Set<Integer> absentInZag = absentInZag(grid, 0);
        Set<Integer> absentInZig = absentInZig(grid, 0);
        Set<Integer> absentInSquare = absentInSquare(grid, 0, 0);

        // the top-left cell element is an element absent in all of the zig, the zag and the square
        for (int x : absentInZag) {
            if (absentInZig.contains(x) && absentInSquare.contains(x)) {
                grid[0][0] = x;
            }
        }

        return grid[0][0];
    }

    /**
     * Finds elements absent in the provided zag.
     *
     * @param grid  the grid
     * @param startJ  the zag identification
     * @return the elements absent in the provided zag
     */
    private static Set<Integer> absentInZag(int[][] grid, int startJ) {
        // iterating over a zag and finding present numbers
        Set<Integer> presentNumbers = new HashSet<>();
        int i = 0;
        int j = startJ;
        while (j >= 0) {
            if (grid[i][j] != -1) {
                presentNumbers.add(grid[i][j]);
            }
            i++;
            j--;
        }
        j = 8;
        while (i < 9) {
            if (grid[i][j] != -1) {
                presentNumbers.add(grid[i][j]);
            }
            i++;
            j--;
        }

        // based on the set of present numbers finding absent numbers
        Set<Integer> absentNumbers = new HashSet<>();
        for (int x  = 0; x < 9; x++) {
            if (!presentNumbers.contains(x)) {
                absentNumbers.add(x);
            }
        }
        return absentNumbers;
    }

    /**
     * Finds elements absent in the provided zig.
     *
     * @param grid  the grid
     * @param startJ  the zig identification
     * @return the elements absent in the provided zig
     */
    private static Set<Integer> absentInZig(int[][] grid, int startJ) {
        Set<Integer> presentNumbers = new HashSet<>();
        int i = 0;
        int j = startJ;
        while (j < 9) {
            if (grid[i][j] != -1) {
                presentNumbers.add(grid[i][j]);
            }
            i++;
            j++;
        }
        j = 0;
        while (i < 9) {
            if (grid[i][j] != -1) {
                presentNumbers.add(grid[i][j]);
            }
            i++;
            j++;
        }
        Set<Integer> absentNumbers = new HashSet<>();
        for (int x  = 0; x < 9; x++) {
            if (!presentNumbers.contains(x)) {
                absentNumbers.add(x);
            }
        }
        return absentNumbers;
    }

    /**
     * Finds elements absent in the provided square.
     *
     * @param grid  the grid
     * @param upperLeftI  the row number of the upper-left element of the square
     * @param upperLeftJ  the column number of the upper-left element of the square
     * @return the elements absent in the provided square
     */
    private static Set<Integer> absentInSquare(int[][] grid, int upperLeftI, int upperLeftJ) {
        Set<Integer> presentNumbers = new HashSet<>();
        for (int i = upperLeftI; i < upperLeftI + 3; i++) {
            for (int j = upperLeftJ; j < upperLeftJ + 3; j++) {
                if (grid[i][j] != -1) {
                    presentNumbers.add(grid[i][j]);
                }
            }
        }
        Set<Integer> absentNumbers = new HashSet<>();
        for (int x  = 0; x < 9; x++) {
            if (!presentNumbers.contains(x)) {
                absentNumbers.add(x);
            }
        }
        return absentNumbers;
    }
}
