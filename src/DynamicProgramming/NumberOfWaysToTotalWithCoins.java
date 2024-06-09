package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

// Problem at:
//https://www.youtube.com/watch?v=L27_JpN6Z1Q&list=PLdo5W4Nhv31aBrJE1WS4MR9LRfbmZrAQu&index=2


public class NumberOfWaysToTotalWithCoins {

    static final int [] coins = {2, 3, 5, 10};

    static int countWays(int value) {
        int [] memo = new int[value + 1];
        Arrays.fill(memo, 0);
        memo[0] = 1;

        for (int coin : coins)
            for (int i = coin; i <= value; i++)
                memo[i] += memo[i - coin];

        return memo[value];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.printf("Value: %d Ways: %d", value, countWays(value));
    }
}
