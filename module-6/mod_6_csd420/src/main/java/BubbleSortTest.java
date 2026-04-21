package module6;

import java.util.Arrays;
import java.util.Comparator;

public class BubbleSortTest {

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 3};
        String[] words = {"pear", "apple", "orange", "banana"};
        Double[] decimals = {4.4, 2.2, 5.5, 1.1, 3.3};

        Person[] people = {
                new Person("Jordan", 28),
                new Person("Amy", 22),
                new Person("Chris", 35),
                new Person("Brian", 19)
        };

        System.out.println("Before sorting integers:");
        System.out.println(Arrays.toString(numbers));
        BubbleSort.bubbleSort(numbers);
        System.out.println("After sorting integers:");
        System.out.println(Arrays.toString(numbers));
        System.out.println();

        System.out.println("Before sorting strings:");
        System.out.println(Arrays.toString(words));
        BubbleSort.bubbleSort(words);
        System.out.println("After sorting strings:");
        System.out.println(Arrays.toString(words));
        System.out.println();

        System.out.println("Before sorting doubles:");
        System.out.println(Arrays.toString(decimals));
        BubbleSort.bubbleSort(decimals);
        System.out.println("After sorting doubles:");
        System.out.println(Arrays.toString(decimals));
        System.out.println();

        System.out.println("Before sorting people by age:");
        System.out.println(Arrays.toString(people));
        BubbleSort.bubbleSort(people, Comparator.comparingInt(Person::getAge));
        System.out.println("After sorting people by age:");
        System.out.println(Arrays.toString(people));
        System.out.println();

        System.out.println("Before sorting people by name:");
        System.out.println(Arrays.toString(people));
        BubbleSort.bubbleSort(people, Comparator.comparing(Person::getName));
        System.out.println("After sorting people by name:");
        System.out.println(Arrays.toString(people));
    }
}