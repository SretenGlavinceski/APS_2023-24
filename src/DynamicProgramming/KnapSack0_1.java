package DynamicProgramming;

import java.util.Scanner;

// Problem is:
// https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/

public class KnapSack0_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] profits = new int[n + 1];
        int[] weights = new int[n + 1];

        for (int i = 0; i < n; i++) {
            profits[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        int target = scanner.nextInt();
        int[][] memo = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (weights[i - 1] <= j) {
                    memo[i][j] = Math.max(
                            memo[i - 1][j],
                            profits[i - 1] + memo[i - 1][j - weights[i - 1]]
                    );
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }

        System.out.println(memo[n][target]);
    }

}
