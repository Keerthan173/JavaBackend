package Java_Collections;

/*
 * ✅ Collections Utility Class (java.util.Collections)
 * -----------------------------------------------------
 * 🔹 Contains static utility methods for working with collections like List, Set, etc.
 * 🔹 Most useful with Lists (especially ArrayList, LinkedList)
 *
 * 🔸 Common Methods:
 * - sort(list)
 * - reverse(list)
 * - shuffle(list)
 * - max(list), min(list)
 * - frequency(collection, element)
 * - swap(list, i, j)
 * - fill(list, value)
 * - binarySearch(list, key) → list must be sorted
 */

import java.util.*;

public class File07_CollectionsUtility {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(40, 10, 30, 20, 50));

        System.out.println("Original List: " + numbers); // [40, 10, 30, 20, 50]

        // 🔹 Sort ascending
        Collections.sort(numbers);
        System.out.println("Sorted List: " + numbers); // [10, 20, 30, 40, 50]

        // 🔹 Reverse
        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers); // [50, 40, 30, 20, 10]

        // 🔹 Shuffle (random order)
        Collections.shuffle(numbers);
        System.out.println("Shuffled List: " + numbers); // [40, 50, 30, 20, 10]

        // 🔹 Max and Min
        System.out.println("Max: " + Collections.max(numbers)); // 50
        System.out.println("Min: " + Collections.min(numbers)); // 10

        // 🔹 Frequency of an element
        numbers.add(10);
        System.out.println("Updated List: " + numbers); // [40, 50, 30, 20, 10, 10]
        System.out.println("Frequency of 10: " + Collections.frequency(numbers, 10)); // 2

        // 🔹 Swap elements
        Collections.swap(numbers, 0, 1);
        System.out.println("After swap(0, 1): " + numbers); // [50, 40, 30, 20, 10, 10]

        // 🔹 Fill entire list with a single value
        Collections.fill(numbers, 99);
        System.out.println("After fill(99): " + numbers); // [99, 99, 99, 99, 99, 99]

        // 🔹 Binary Search (on sorted list)
        List<String> names = new ArrayList<>(Arrays.asList("Ram", "Amit", "Zara", "John"));
        Collections.sort(names); // Must sort before binarySearch
        System.out.println("Sorted Names: " + names); // [Amit, John, Ram, Zara]
        int index = Collections.binarySearch(names, "John");
        System.out.println("Index of 'John': " + index); // 1
    }
}
