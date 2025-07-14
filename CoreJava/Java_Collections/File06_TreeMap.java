package Java_Collections;

/*
 * ✅ TreeMap in Java (java.util)
 * -----------------------------------
 * 🔹 Implements Map interface
 * 🔹 Stores key-value pairs
 * 🔹 Keys are sorted in **natural ascending order**
 * 🔹 Keys must be non-null (throws NullPointerException if null key added)
 * 🔹 Values can be null
 * 🔹 Backed by Red-Black Tree (O(log n) for put/get)
 *
 * 🔸 Common Methods:
 * - put(), get(), remove()
 * - firstKey(), lastKey()
 * - higherKey(), lowerKey()
 * - keySet(), entrySet(), values()
 */

import java.util.*;

public class File06_TreeMap {
    public static void main(String[] args) {
        // ✅ Create a TreeMap
        TreeMap<Integer, String> map = new TreeMap<>();

        // 🔹 Add entries
        map.put(30, "Banana");
        map.put(10, "Apple");
        map.put(20, "Mango");
        map.put(40, null); // null value allowed

        // ❌ map.put(null, "Kiwi"); // Throws NullPointerException

        System.out.println("TreeMap (sorted by keys): " + map); // {10=Apple, 20=Mango, 30=Banana, 40=null}

        // 🔹 Get value by key
        System.out.println("Value at key 20: " + map.get(20)); // Mango

        // 🔹 First and last keys
        System.out.println("First key: " + map.firstKey()); // 10
        System.out.println("Last key: " + map.lastKey()); // 40

        // 🔹 Higher and lower keys
        System.out.println("Higher than 20: " + map.higherKey(20)); // 30
        System.out.println("Lower than 20: " + map.lowerKey(20));   // 10

        // 🔹 Iterate using entrySet
        System.out.println("Iterating entries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 🔹 Key set and values
        System.out.println("Keys: " + map.keySet()); // [10, 20, 30, 40]
        System.out.println("Values: " + map.values()); // [Apple, Mango, Banana, null]

        // 🔹 Remove and clear
        map.remove(10);
        System.out.println("After removing key 10: " + map); // {20=Mango, 30=Banana, 40=null}
        map.clear();
        System.out.println("After clear(): " + map); // {}
    }
}
