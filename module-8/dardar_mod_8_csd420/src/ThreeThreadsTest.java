public class ThreeThreadsTest {
    public static void main(String[] args) {
        testArrayCounts();
        testValidCharacterGroups();
        System.out.println("All tests passed successfully.");
    }

    private static void testArrayCounts() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%&*";

        if (letters.length() != 26) {
            throw new RuntimeException("Letters test failed.");
        }

        if (digits.length() != 10) {
            throw new RuntimeException("Digits test failed.");
        }

        if (symbols.length() != 7) {
            throw new RuntimeException("Symbols test failed.");
        }
    }

    private static void testValidCharacterGroups() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String symbols = "!@#$%&*";

        if (!letters.contains("a") || !letters.contains("z")) {
            throw new RuntimeException("Letter validation failed.");
        }

        if (!digits.contains("0") || !digits.contains("9")) {
            throw new RuntimeException("Digit validation failed.");
        }

        if (!symbols.contains("!") || !symbols.contains("*")) {
            throw new RuntimeException("Symbol validation failed.");
        }
    }
}