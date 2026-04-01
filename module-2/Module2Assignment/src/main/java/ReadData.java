import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadData {
    public static void main(String[] args) {
        String fileName = "jordan_datafile.dat";

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {

            int recordNumber = 1;

            while (true) {
                System.out.println("Record " + recordNumber + ":");

                System.out.println("Integers:");
                for (int i = 0; i < 5; i++) {
                    System.out.println(input.readInt());
                }

                System.out.println("Doubles:");
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%.2f%n", input.readDouble());
                }

                System.out.println();
                recordNumber++;
            }

        } catch (EOFException e) {
            System.out.println("Finished reading all data from the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}