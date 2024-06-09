package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

//Input: arr[] = {50, 3, 10, 7, 40, 80}
//Output: 4

// Problem is:
// https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

public class LongestIncreasingSubsequence {

    static int longestIncSubs(int [] array) {
        int n = array.length;
        int [] memo = new int[n];

        IntStream.range(0, n).forEach(i -> memo[i] = 1);

        int maxSub = 1;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (array[i] > array[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    maxSub = Math.max(memo[i], maxSub);
                }


        return maxSub;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        System.out.println("Length of LIS is: " + longestIncSubs(array));
    }

}
