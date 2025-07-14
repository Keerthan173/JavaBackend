package Java_Collections;

/*
 * ✅ HashMap in Java (java.util)
 * -----------------------------------
 * 🔹 Stores data in key-value pairs
 * 🔹 Keys are unique; values can be duplicate
 * 🔹 No ordering of keys (unordered)
 * 🔹 Allows one null key and multiple null values
 * 🔹 Backed by Hash table (O(1) average time for put/get)
 *
 * 🔸 Common Methods:
 * - put(key, value)
 * - get(key)
 * - containsKey(), containsValue()
 * - remove(key)
 * - keySet(), values(), entrySet()
 * - size(), isEmpty(), clear()
 */

import java.util.*;

public class File05_HashMap {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // 🔹 Add entries
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");
        map.put(1, "Grapes"); // Overwrites value at key 1

        // 🔹 Add null key and null values
        map.put(null, "Kiwi");
        map.put(4, null);
        map.put(5, null);

        System.out.println("HashMap: " + map); // {null=Kiwi, 1=Grapes, 2=Banana, 3=Mango, 4=null, 5=null}

        // 🔹 Get value by key
        System.out.println("Value at key 2: " + map.get(2)); // Banana

        // 🔹 Check for key and value
        System.out.println("Contains key 3? " + map.containsKey(3)); // true
        System.out.println("Contains value 'Banana'? " + map.containsValue("Banana")); // true

        // 🔹 Remove key
        map.remove(4);
        System.out.println("After removing key 4: " + map); // {null=Kiwi, 1=Grapes, 2=Banana, 3=Mango, 5=null}

        // 🔹 Iterate using entrySet
        System.out.println("Iterating (key-value pairs):");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 🔹 Iterate keys and values separately
        System.out.println("Keys: " + map.keySet()); // [null, 1, 2, 3, 5]
        System.out.println("Values: " + map.values()); // [Kiwi, Grapes, Banana, Mango, null]

        // 🔹 Size and clear
        System.out.println("Size: " + map.size()); // 5
        map.clear();
        System.out.println("After clear(): " + map); // {}
        System.out.println("Is empty? " + map.isEmpty()); // true
    }
}
