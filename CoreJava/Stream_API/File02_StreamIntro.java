package Stream_API;

/*
 * ✅ Stream API in Java (Java 8+)
 * -------------------------------
 * 🔹 Stream = pipeline of operations to process collections
 * 🔹 Can filter, map, sort, reduce, etc.
 * 🔹 Streams are NOT data structures – they don’t store data
 * 🔹 Stream is consumed once – it cannot be reused
 */

import java.util.*;
import java.util.stream.*;

public class File02_StreamIntro {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Keerthan K", "Mahi", "Chikku", "Ravi", "Raina");

        // 🔹 Create a stream
        Stream<String> stream = names.stream();

        // 🔹 First use — filtering names starting with 'R'
        stream.filter(name -> name.startsWith("R"))
              .forEach(n -> System.out.print(n + " ")); // ✅ OK

        // 🔹 Try to use the same stream again
        try {
            stream.filter(name -> name.endsWith("a")); // ❌ IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("\nError: Stream already consumed!");
        }
    }
}

// Output:
// Ravi Raina 
// Error: Stream already consumed!