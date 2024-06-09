package HashTables.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubArraySumZero {

    static int longestSubArrSumZero(int[] array) {
        Map<Integer, Integer> indexesBySum = new HashMap<>();

        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum == 0)
                maxLength = i + 1;
            else if (indexesBySum.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - indexesBySum.get(sum));
            } else
                indexesBySum.put(sum, i);

        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        System.out.println("Longest subarray with sum 0 is: " + longestSubArrSumZero(array));
    }

}
