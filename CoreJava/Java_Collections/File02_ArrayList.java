package Java_Collections;

/*
 *  ArrayList in Java (java.util)
 * -----------------------------------
 * 🔹 Ordered collection (insertion order)
 * 🔹 Allows duplicate elements
 * 🔹 Resizable array (dynamic size)
 *
 *  Methods:
 * - add(element)
 * - add(index, element)
 * - get(index)
 * - set(index, element)
 * - remove(index)
 * - size(), contains(), isEmpty(), clear()
 */

import java.util.*;

public class File02_ArrayList {
    public static void main(String[] args) {
        // ✅ Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // 🔹 Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicate allowed

        System.out.println("Fruits: " + fruits); // Output: Fruits: [Apple, Banana, Orange, Apple]

        // 🔹 Accessing elements
        System.out.println("First fruit: " + fruits.get(0)); // Output: First fruit: Apple

        // 🔹 Modifying elements
        fruits.set(1, "Mango");
        System.out.println("After set(1, Mango): " + fruits); // After set(1, Mango): [Apple, Mango, Orange, Apple]

        // 🔹 Removing elements
        fruits.remove(2);
        System.out.println("After removing index 2: " + fruits); // [Apple, Mango, Apple]

        // 🔹 Size and check
        System.out.println("Size: " + fruits.size()); // 3
        System.out.println("Contains 'Apple'? " + fruits.contains("Apple")); // true
        System.out.println("Is empty? " + fruits.isEmpty()); // false

        // 🔹 Looping using for-each
        System.out.println("Iterating:");
        for (String fruit : fruits) {
            System.out.println("- " + fruit);
        }
        // - Apple
        // - Mango
        // - Apple

        // 🔹 Sorting the list
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits); // [Apple, Apple, Mango]

        // 🔹 Clearing all elements
        fruits.clear();
        System.out.println("After clear(): " + fruits);// []
    }
}
