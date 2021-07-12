package xenoteo.com.github.pipelines.easy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        String packagePath = "src/xenoteo/com/github/pipelines/easy/";

        // in initialisation
        String inputFileName = "input.txt";
        Scanner in = new Scanner(new File(packagePath + inputFileName));

        // reading N server capacities
        int N = in.nextInt();
        in.nextLine();
        int[] servers = new int[N];
        for (int i = 0; i < N; i++){
            servers[i] = in.nextInt();
        }

        // reading servers' dependencies (server x reports to the server dependencies[x])
        int[] dependencies = new int[N];
        in.nextLine();
        for (int i = 0; i < N - 1; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            dependencies[a] = b;
        }

        // out initialisation and writing output
        String outputFileName = "output.txt";
        FileWriter output = new FileWriter(packagePath + outputFileName);
        output.write(findThroughput(servers) + "");
        output.close();
    }

    /**
     * Finds the servers bottle neck.
     *
     * @param servers  the array of servers' capacities
     * @return the servers bottle neck
     */
    private static int findThroughput(int[] servers) {
        int min = servers[0];
        for (int capacity : servers) {
            min = Math.min(min, capacity);
        }
        return min;
    }
}
