package DynamicProgramming;

import java.util.Scanner;

public class NumberOfWaysToCoverDistance { // using 1, 2 or 3 steps
    static int waysDistance(int distance) {
        int [] memo = new int[distance + 1];
        memo[0] = 1;

        if (distance >= 1)
            memo[1] = 1;
        if (distance >= 2)
            memo[2] = 2;

        for (int i = 3; i <= distance; i++)
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];

        return memo[distance];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distance = scanner.nextInt();
        System.out.printf("Number of ways to cover %d distance is %d", distance, waysDistance(distance));
    }

}
