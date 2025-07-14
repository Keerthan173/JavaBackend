package Java_Collections;
/*
 *  HashSet in Java (java.util)
 * -----------------------------------
 * 🔹 Implements Set interface
 * 🔹 Stores unique elements (no duplicates)
 * 🔹 Unordered (no index, no insertion order)
 * 🔹 Allows one null element
 *
 *  Common Methods:
 * - add(element)
 * - remove(element)
 * - contains(element)
 * - isEmpty(), size(), clear()
 */

import java.util.*;

public class File03_HashSet {
    public static void main(String[] args) {
        // Create a HashSet of Strings
        Set<String> colors = new HashSet<>();

        // Adding elements
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red"); // Duplicate (ignored)

        System.out.println("HashSet: " + colors); // [Red, Blue, Green] (Order not guaranteed)

        // 🔹 Contains check
        System.out.println("Contains 'Green'? " + colors.contains("Green")); // true

        // 🔹 Removing element
        colors.remove("Red");
        System.out.println("After removing 'Red': " + colors); // [Blue, Green]

        // 🔹 Adding null
        colors.add(null);
        System.out.println("After adding null: " + colors); // [null, Blue, Green]

        // 🔹 Size
        System.out.println("Size: " + colors.size()); // 3

        // 🔹 Iterating using for-each
        System.out.println("Iterating:");
        for (String color : colors) {
            System.out.println("- " + color);
        }

        // 🔹 Clearing the set
        colors.clear();
        System.out.println("After clear(): " + colors); // []
        System.out.println("Is empty? " + colors.isEmpty()); // true
    }
}