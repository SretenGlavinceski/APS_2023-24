package HashTables.Exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfSubsets {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1, 2, 3, 4, 5};

        Map<Integer, Integer> freq = new HashMap<>();

        Arrays.stream(array).forEach(num -> {
            freq.putIfAbsent(num, 0);
            freq.computeIfPresent(num, (k, v) -> v + 1);
        });

        System.out.printf("Minimum number of subsets with distinct elements: %d",
                freq.values()
                        .stream()
                        .mapToInt(i -> i)
                        .max().orElse(0));
    }
}
