package GreedyAlgorithms;

import java.util.*;

// this greedy approach doesn't always work, look at:
// https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/
// correct approach is with dynamic programming

public class MinimumCoinProblem {
    static final int [] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();

        Map<Integer, Integer> coinsNeeded = new TreeMap<>(Comparator.reverseOrder());

        int index = coins.length - 1;
        while (V > 0) {
            if (V >= coins[index]) {
                V -= coins[index];
                coinsNeeded.putIfAbsent(coins[index], 0);
                coinsNeeded.computeIfPresent(coins[index], (k, v) -> v + 1);
            } else {
                index--;
            }
        }

        coinsNeeded.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
