import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NonDuplicateWordsTest {

    public static void main(String[] args) throws IOException {
        String testFileName = "test_collection_of_words.txt";

        String testData = "Banana apple orange apple grape banana kiwi orange";
        Files.writeString(Path.of(testFileName), testData);

        NavigableSet<String> actual = NonDuplicateWords.readUniqueWords(testFileName);

        NavigableSet<String> expected = new TreeSet<>();
        expected.add("apple");
        expected.add("banana");
        expected.add("grape");
        expected.add("kiwi");
        expected.add("orange");

        if (actual.equals(expected)) {
            System.out.println("Test passed.");
            System.out.println("Ascending order: " + actual);
            System.out.println("Descending order: " + actual.descendingSet());
        } else {
            System.out.println("Test failed.");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }

        Files.deleteIfExists(Path.of(testFileName));
    }
}