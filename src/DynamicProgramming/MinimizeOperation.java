package DynamicProgramming;


//https://www.geeksforgeeks.org/minimize-steps-to-reach-k-from-0-by-adding-1-or-doubling-at-each-step/

import java.util.Scanner;

public class MinimizeOperation {

    static int minOperations(int k) {

        int[] memo = new int[k + 1];
        memo[0] = 0;

        for (int i = 1; i <= k; i++) {
            if (i % 2 == 0)
                memo[i] = Math.min(memo[i / 2] + 1, memo[i - 1] + 1);
            else
                memo[i] = memo[i - 1] + 1;

        }

        return memo[k];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        System.out.printf("Minimum operations from 0 to %d is: %d", k, minOperations(k));
    }
}
