package BruteForceAlgorithm;

//https://www.hackerearth.com/problem/algorithm/dummy-26/

import java.util.Arrays;
import java.util.Scanner;


public class SummingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        int [] array = new int[N];
        for (int i = 0; i < Q; i++) {
            int rangeStart = scanner.nextInt();
            int rangeEnd = scanner.nextInt();
            int value = scanner.nextInt();

            for (int j = rangeStart; j <= rangeEnd; j++) {
                array[j] += value;
            }
        }

        Arrays.stream(array).forEach(i -> System.out.print(i + " "));

    }
}
