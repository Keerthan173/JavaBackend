package Stream_API;

import java.util.*;

public class File01_ForEach {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);

        // 🔹 Method 1: Traditional for loop
        for (int i = 0; i < nums.size(); i++) {
            System.out.println("Index " + i + ": " + nums.get(i));
        }

        // 🔹 Method 2: Enhanced for-each loop
        for (int n : nums) {
            System.out.println("Value: " + n);
        }

        // 🔹 Method 3: forEach() with Lambda (Java 8+)
        nums.forEach(n -> System.out.println("Element: " + n));
    }
}

// Output:
// Index 0: 10
// Index 1: 20
// Index 2: 30

// Value: 10
// Value: 20
// Value: 30

// Element: 10
// Element: 20
// Element: 30
