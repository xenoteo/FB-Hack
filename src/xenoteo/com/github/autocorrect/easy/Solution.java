package xenoteo.com.github.autocorrect.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        String packagePath = "src/xenoteo/com/github/autocorrect/easy/";

        // in initialisation
        String inputFileName = "input.txt";
        Scanner in = new Scanner(new File(packagePath + inputFileName));

        // reading the dictionary
        Set<String> dict = readDict();

        // reading the words
        int N = in.nextInt();
        in.nextLine();
        String[] words = new String[N];
        for (int i = 0; i < N; i++){
            words[i] = in.nextLine();
        }

        // out initialisation
        String outputFileName = "output.txt";
        FileWriter output = new FileWriter(packagePath + outputFileName);

        // writing output
        String[] outputs = findOutputs(words, dict);
        for (int i = 0; i < N; i++) {
            output.write(outputs[i]);
            if (i < N - 1) {
                output.write("\n");
            }
        }

        output.close();
    }

    /**
     * Reads a dictionary from the file to the set.
     *
     * @return the set of words read from the dictionary
     * @throws FileNotFoundException when the dictionary file is not found
     */
    private static Set<String> readDict() throws FileNotFoundException {
        String packagePath = "src/xenoteo/com/github/autocorrect/easy/";
        String dictFileName = "dict.txt";

        Set<String> dict = new HashSet<>();
        Scanner scanner = new Scanner(new File(packagePath + dictFileName));
        while (scanner.hasNextLine()) {
            dict.add(scanner.nextLine());
        }
        return dict;
    }

    /**
     * Based on provided words provides the output array
     * (placing there "IN" if word is present in the dictionary and "OUT" otherwise).
     *
     * @param words  the array of input words
     * @param dictionary  the dictionary
     * @return  the output array
     */
    private static String[] findOutputs(String[] words, Set<String> dictionary) {
        int N = words.length;
        String[] outputs = new String[N];
        for (int i = 0; i < N; i++) {
            if (dictionary.contains(words[i])) {
                outputs[i] = "IN";
            }
            else {
                outputs[i] = "OUT";
            }
        }
        return outputs;
    }
}
