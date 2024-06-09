package BruteForceAlgorithm;

import java.util.Scanner;

public class QueensProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int mainDiagonal = -1;
                int secondaryDiagonal = -1;

                int k = i;
                int m = j;
                while (k < n && m < n) {
                    mainDiagonal++;
                    k++;
                    m++;
                }

                k = i;
                m = j;
                while (k >= 0 && m >= 0) {
                    mainDiagonal++;
                    k--;
                    m--;
                }

                k = i;
                m = j;
                while (k >= 0 && m < n) {
                    secondaryDiagonal++;
                    k--;
                    m++;
                }

                k = i;
                m = j;
                while (k < n && m >= 0) {
                    secondaryDiagonal++;
                    k++;
                    m--;
                }

                counter += n * n - (2 * n) - (mainDiagonal + secondaryDiagonal) + 3;
            }
        }

        System.out.println(counter / 2);

    }
}
