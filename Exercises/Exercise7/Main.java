import java.util.*;
import java.util.function.Predicate;

public class Main {

    // (a) Count elements with a specific property
    public static <T> int countMatching(Collection<T> collection, Predicate<T> predicate) {
        int count = 0;
        for (T item : collection) {
            if (predicate.test(item)) {
                count++;
            }
        }
        return count;
    }

    // (b) Swap two elements in an array
    public static <T> void swap(T[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        } else {
            System.out.println("Invalid indices for swapping.");
        }
    }

    // (c) Find the maximal element in a subrange
    public static <T extends Comparable<T>> T findMaxInRange(List<T> list, int begin, int end) {
        if (begin >= end || begin < 0 || end > list.size()) {
            throw new IllegalArgumentException("Invalid range: [" + begin + ", " + end + ")");
        }

        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    // Demo usage
    public static void main(String[] args) {
        // (a) Count odd numbers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        int oddCount = countMatching(numbers, n -> n % 2 != 0);
        System.out.println("Odd count: " + oddCount);

        // (b) Swap elements in an array
        String[] words = {"Java", "Python", "C++"};
        System.out.println("Before swap: " + Arrays.toString(words));
        swap(words, 0, 2);
        System.out.println("After swap: " + Arrays.toString(words));

        // (c) Find max in range
        List<Double> scores = List.of(89.5, 92.0, 87.0, 96.5, 90.2);
        double maxScore = findMaxInRange(scores, 1, 4);
        System.out.println("Max in range [1, 4): " + maxScore);
    }
}
