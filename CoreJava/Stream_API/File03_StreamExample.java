package Stream_API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class File03_StreamExample {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 1, 2, 3, 4, 5, 6, 7);

        Stream<Integer> s1 = nums.stream();
        // Filtering even numbers
        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);
        
        // We can print even numbers by using forEach, but after this, s1 cannot be reused

        // Multiplying even numbers by 2
        Stream<Integer> s3 = s2.map(n -> n * 2);

        // Finding sum
        int sum = s3.reduce(0, (acc, value) -> acc + value);
        System.out.println("Sum of even numbers multiplied by 2: " + sum); // Output: 24

    }
}