package xenoteo.com.github.pipelines.medium;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        String packagePath = "src/xenoteo/com/github/pipelines/medium/";

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
        for (int i = 0; i < N; i++) {
            dependencies[i] = -1;
        }
        in.nextLine();
        while (in.hasNextLine()){
            int a = in.nextInt();
            int b = in.nextInt();
            dependencies[a] = b;
        }

        // out initialisation and writing output
        String outputFileName = "output.txt";
        FileWriter output = new FileWriter(packagePath + outputFileName);
        output.write(findThroughput(servers, dependencies) + "");
        output.close();
    }

    /**
     *
     * Finds the sum of servers bottle necks of all pipelines.
     *
     * @param servers  the array of servers' capacities
     * @param dependencies  the array of servers' dependencies
     * @return the servers bottle neck
     */
    private static int findThroughput(int[] servers, int[] dependencies) {
        int totalSum = 0;
        int pipelineStart = 0;
        for (int i = 0; i < dependencies.length; i++) {
            if (dependencies[i] == -1) {
                totalSum += findPipelineThroughput(servers, pipelineStart, i);
                pipelineStart = i + 1;
            }
        }
        return totalSum;
    }

    /**
     * Finds the bottle necks of one pipeline of provided start and end servers.
     *
     * @param servers  the array of servers' capacities
     * @param start  the first server of the pipeline
     * @param end  the last server of the pipeline
     * @return the servers bottle neck
     */
    private static int findPipelineThroughput(int[] servers, int start, int end) {
        int min = servers[start];
        for (int i = start; i <= end; i++) {
            min = Math.min(min, servers[i]);
        }
        return min;
    }
}
