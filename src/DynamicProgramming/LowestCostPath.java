package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

// zadaca od auditoriski

public class LowestCostPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] costs = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                costs[i][j] = scanner.nextInt();
            }
        }


        int[] best = new int[n];

        for (int i = 1; i < n; i++){
            best[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++)
                best[i] = Math.min(best[i], best[j] + costs[j][i]);
        }


        System.out.println(best[n - 1]);

    }
}
