package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestDescendingSubArray {

    static int longestDecSubArr(int[] array) {
        int [] memo = new int[array.length];
        Arrays.fill(memo, 1);
        int maxValue = 1;

        for (int i = 1; i < array.length; i++)
            for (int j = 0; j < i; j++)
                if (array[i] < array[j]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                    maxValue = Math.max(memo[i], maxValue);
                }


        return maxValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        System.out.println(longestDecSubArr(array));
    }

}
