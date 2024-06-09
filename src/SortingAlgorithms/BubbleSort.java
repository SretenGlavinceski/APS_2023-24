package SortingAlgorithms;

import java.util.Scanner;

public class BubbleSort {

    static void bubbleSort(int [] array) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");

        System.out.println();

        bubbleSort(array);

        for (int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }
}
