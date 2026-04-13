import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class NonDuplicateWords {

    public static NavigableSet<String> readUniqueWords(String fileName) throws IOException {
        NavigableSet<String> words = new TreeSet<>();

        try (Scanner input = new Scanner(Files.newBufferedReader(Path.of(fileName)))) {
            input.useDelimiter("[^A-Za-z]+");

            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }

        return words;
    }

    public static void displayWords(NavigableSet<String> words) {
        System.out.println("Words in ascending order:");
        for (String word : words) {
            System.out.println(word);
        }

        System.out.println();
        System.out.println("Words in descending order:");
        for (String word : words.descendingSet()) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        String fileName = "collection_of_words.txt";

        try {
            NavigableSet<String> words = readUniqueWords(fileName);
            displayWords(words);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}