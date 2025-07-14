package Java_Collections;

/*
 * ✅ TreeSet in Java (java.util)
 * -----------------------------------
 * 🔹 Implements Set interface
 * 🔹 Stores unique elements (like HashSet)
 * 🔹 Maintains elements in **sorted (natural) order**
 * 🔹 Does NOT allow null (throws exception if added)
 * 🔹 Uses Red-Black Tree internally (log(n) time for add/remove/search)
 *
 * 🔸 Common Methods:
 * - add(), remove(), contains()
 * - first(), last()
 * - higher(), lower(), ceiling(), floor()
 */

import java.util.*;

public class File04_TreeSet {
    public static void main(String[] args) {
        // Create a TreeSet of Integers
        TreeSet<Integer> numbers = new TreeSet<>();

        // 🔹 Adding elements
        numbers.add(50);
        numbers.add(20);
        numbers.add(40);
        numbers.add(10);
        numbers.add(20); // Duplicate ignored

        System.out.println("TreeSet (sorted): " + numbers); // [10, 20, 40, 50]

        // 🔹 Contains check
        System.out.println("Contains 40? " + numbers.contains(40)); // true

        // 🔹 First and last elements
        System.out.println("First: " + numbers.first()); // 10
        System.out.println("Last: " + numbers.last()); // 50

        // 🔹 Floor and ceiling
        System.out.println("Floor of 25: " + numbers.floor(25));   // 20
        System.out.println("Ceiling of 25: " + numbers.ceiling(25)); // 40

        // 🔹 Higher and lower
        System.out.println("Higher than 20: " + numbers.higher(20)); // 40
        System.out.println("Lower than 20: " + numbers.lower(20));   // 10

        // 🔹 Iterating
        System.out.println("Iterating:");
        for (int num : numbers) {
            System.out.println("- " + num);
        }

        // ❌ Uncommenting this will throw NullPointerException
        // numbers.add(null);

        // 🔹 Removing and size
        numbers.remove(40);
        System.out.println("After removing 40: " + numbers); // [10, 20, 50]
        System.out.println("Size: " + numbers.size()); // 3
    }
}