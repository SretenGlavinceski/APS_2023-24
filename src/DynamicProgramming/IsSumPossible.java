package DynamicProgramming;

import java.util.Scanner;

// Problem is:
//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

public class IsSumPossible {

    static boolean isSumPossible(int [] array, int value) {

        boolean [] possible = new boolean[value + 1];

        possible[0] = true;

        for (int number : array) {
            for (int i = value; i >= number; i--) {
                possible[i] = possible[i] || possible[i - number];
            }
        }

        return possible[value];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        int value = scanner.nextInt();

        System.out.println(isSumPossible(array, value));

    }

}
