import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) {
        String fileName = "jordan_datafile.dat";
        File file = new File(fileName);
        Random random = new Random();

        try {
            ObjectOutputStream output;

            if (file.exists() && file.length() > 0) {
                output = new AppendableObjectOutputStream(new FileOutputStream(file, true));
            } else {
                output = new ObjectOutputStream(new FileOutputStream(file));
            }

            for (int i = 0; i < 5; i++) {
                int randomInt = random.nextInt(100);
                output.writeInt(randomInt);
            }

            for (int i = 0; i < 5; i++) {
                double randomDouble = random.nextDouble() * 100;
                output.writeDouble(randomDouble);
            }

            output.close();
            System.out.println("Data was written successfully to " + fileName);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}