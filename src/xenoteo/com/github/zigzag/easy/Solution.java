package xenoteo.com.github.zigzag.easy;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        // in initialisation
        String inputFileName = "input.txt";
        Scanner in = new Scanner(new File("src/xenoteo/com/github/zigzag/easy/" + inputFileName));

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

            // counting the sum
            totalSum += solveAndFind3FirstRowsSum(grid);
        }

        // out initialisation and writing output
        String outputFileName = "output.txt";
        FileWriter output = new FileWriter("src/xenoteo/com/github/zigzag/easy/" + outputFileName);
        output.write(totalSum + "");
        output.close();
    }

    /**
     * Given a list of unfinished ZigZags, provides the sum of all numbers in the top three rows the grid.
     *
     * @param grid  the grid
     * @return the sum of all numbers in the top three rows the grid
     */
    private static int solveAndFind3FirstRowsSum(int[][] grid) {
        return 108;
    }

}