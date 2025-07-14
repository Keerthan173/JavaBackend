package Stream_API;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class File04_StreamEx {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 1, 2, 3, 4, 5, 6, 7);

        Stream<Integer> s1 = nums.stream();
        int sum = s1.filter(n -> n % 2 == 0)
            .map(n -> n * 2)
            .reduce(0, (c, e) -> c + e);
        
        System.out.println(sum); // Output: 24
    }
}
