package GreedyAlgorithms;

import java.util.Scanner;


// Problem is:
// https://www.geeksforgeeks.org/flood-fill-algorithm/

public class FloodFillAlgorithm {

    static boolean [][] memo;
    static void checkAdjacentPixels(int[][] matrix, int i, int j, int C, int value) {
        if (memo[i][j])
            return;

        memo[i][j] = true;

        if (i - 1 >= 0 && matrix[i - 1][j] == value) {
            matrix[i - 1][j] = C;
            checkAdjacentPixels(matrix, i - 1, j, C, value);
        }
        if (j - 1 >= 0 && matrix[i][j - 1] == value) {
            matrix[i][j - 1] = C;
            checkAdjacentPixels(matrix, i, j - 1, C, value);
        }
        if (i + 1 < matrix.length && matrix[i + 1][j] == value) {
            matrix[i + 1][j] = C;
            checkAdjacentPixels(matrix, i + 1, j, C, value);
        }
        if (j + 1 < matrix[0].length && matrix[i][j + 1] == value) {
            matrix[i][j + 1] = C;
            checkAdjacentPixels(matrix, i, j + 1, C, value);
        }
    }

    static void transformMatrix(int[][] matrix, int x, int y, int C) {
        memo = new boolean[matrix.length][matrix[0].length];
        checkAdjacentPixels(matrix, x, y, C, matrix[x][y]);
        matrix[x][y] = C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        transformMatrix(matrix, scanner.nextInt(), scanner.nextInt(), scanner.nextInt());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
