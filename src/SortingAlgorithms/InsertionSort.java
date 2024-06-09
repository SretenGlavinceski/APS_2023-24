package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    static final Random random = new Random();
    public static void main(String[] args) {
        int [] array = new int[100];

        for (int i = 0; i < 100; i++)
            array[i] = random.nextInt(100);

        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();

        insertionSort(array);
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }
}
