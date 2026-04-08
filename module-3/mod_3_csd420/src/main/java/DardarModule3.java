import java.util.ArrayList;
import java.util.Random;

public class DardarModule3 {
    public static void main(String[] args) {
        ArrayList<Integer> originalList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        System.out.println("Original List:");
        System.out.println(originalList);
        System.out.println();
        System.out.println("List With Duplicates Removed:");
        System.out.println(uniqueList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();

        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }
}