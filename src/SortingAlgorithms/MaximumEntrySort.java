package SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class MaximumEntrySort {

    static int findMinElementIndex(int [] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    static int [] maximumEntrySort(int [] array) {
        int [] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int min = findMinElementIndex(array);
            result[i] = array[min];
            array[min] = Integer.MAX_VALUE;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        for (int i : array)
            System.out.print(i + " ");
        System.out.println();

        array = maximumEntrySort(array);
        for (int i : array)
            System.out.print(i + " ");

    }
}
