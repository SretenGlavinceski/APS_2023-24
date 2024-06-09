package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

//https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

public class MinimumCoinsProblemDP {

    static final int [] coins = {1, 3, 4, 5};

    static int minCoins(int value) {
        int [] memo = new int[value + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        memo[0] = 0;

        for (int i = 1; i <= value; i++) {
            for (int coin : coins) {
                if (coin <= i && memo[i - coin] != Integer.MAX_VALUE)
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }

        Arrays.stream(memo).forEach(i -> {
            System.out.print(i + " ");
        });

        System.out.println();
        return memo[value] == Integer.MAX_VALUE ? -1 : memo[value];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();

        System.out.printf("Min coins for the value %d is %d", value, minCoins(value));
    }
}
