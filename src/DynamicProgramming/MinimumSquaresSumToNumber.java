package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

// Problem is:
// https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/

public class MinimumSquaresSumToNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = (int) Math.sqrt(n);

        int [] memo = new int[n + 1];

        for (int i = 0; i <= n; i++)
            memo[i] = i;

        for (int i = 2; i <= m; i++)
            for (int j = i * i; j <= n; j++)
                memo[j] = Math.min(memo[j], 1 + memo[j - i * i]);

        System.out.println(memo[n]);
    }

}
