package xenoteo.com.github.dots_and_dashes.easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        String packagePath = "src/xenoteo/com/github/dots_and_dashes/easy/";

        Map<String, Character> dict = readDict();   // "dots and dashes" dictionary

        // in initialisation
        String inputFileName = "input.txt";
        Scanner in = new Scanner(new File(packagePath + inputFileName));

        // out initialisation
        String outputFileName = "output.txt";
        FileWriter output = new FileWriter(packagePath + outputFileName);

        int testCasesNumber = in.nextInt();
        in.nextLine();
        for (int t = 0; t < testCasesNumber; t++){
            // reading the words
            String line = in.nextLine();
            String[] words = line.split(" / ");
            List<String[]> wordsList = new LinkedList<>();
            for (String word : words) {
                wordsList.add(word.split(" "));
            }

            // decoding the message and writing in to the output file
            output.write(decode(wordsList, dict));
            if (t < testCasesNumber - 1) {
                output.write("\n");
            }
        }

        output.close();
    }

    /**
     * Reads the "dots and dashes" dictionary and saves it to the map.
     *
     * @return the "dots and dashes" dictionary mapping form dots and dashes to characters
     * @throws FileNotFoundException when the dictionary file is not founf
     */
    private static Map<String, Character> readDict() throws FileNotFoundException {
        String packagePath = "src/xenoteo/com/github/dots_and_dashes/";
        String fileName = "encoding";

        Map<String, Character> dict = new HashMap<>();
        Scanner scanner = new Scanner(new File(packagePath + fileName));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String code = line.substring(2);
            char letter = line.charAt(0);
            dict.put(code, letter);
        }
        return dict;
    }

    /**
     * Decodes the list of "dots and dashes" words to normal exprassions
     * using the dictionary map.
     *
     * @param words  the list of words
     * @param dict  the "dots and dashes" dictionary
     * @return the decoded string
     */
    private static String decode(List<String[]> words, Map<String, Character> dict) {
        StringBuilder expr = new StringBuilder();
        for (String[] letters : words) {
            for (String letter : letters) {
                expr.append(dict.get(letter));
            }
            expr.append(" ");
        }
        return expr.toString();
    }
}
