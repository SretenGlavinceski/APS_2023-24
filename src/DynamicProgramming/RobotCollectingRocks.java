package DynamicProgramming;

import java.util.Scanner;


// zadaca od auditoriski

public class RobotCollectingRocks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] path = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                path[i][j] = scanner.nextInt();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1)
                    continue;
                int right = j == m - 1 ? 0 : path[i][j + 1];
                int bottom = i == n - 1 ? 0 : path[i + 1][j];

                path[i][j] += Math.max(right, bottom);
            }
        }

        System.out.println(path[0][0]);
    }

}
