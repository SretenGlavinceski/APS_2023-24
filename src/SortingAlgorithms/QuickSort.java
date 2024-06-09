package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    public static <T extends Comparable<? super T>> void swap(T[] A, int x, int y) {
        T temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    public static <T extends Comparable<? super T>> int partition(T[] A, int left, int right) {

        int i = left, j = right;
        T pivot = A[(left + right) / 2];
        while (i <= j) {
            while (A[i].compareTo(pivot) < 0)
                i++;
            while (A[j].compareTo(pivot) > 0)
                j--;
            if (i <= j) {
                swap(A, i, j);
                i++;
                j--;
            }
        }
        return i;
    }


    public static <T extends Comparable<? super T>> void quickSort(T A[], int left, int right) {
        int pivot_indeks = partition(A,left,right);
        if(left < pivot_indeks-1)
            quickSort(A, left, pivot_indeks-1);
        if(pivot_indeks < right)
            quickSort(A, pivot_indeks, right);
    }

    static final Random random = new Random();
    public static void main(String[] args) {
        Integer [] array = new Integer[1000000];

        for (int i = 0; i < 1000000; i++)
            array[i] = random.nextInt(100);

        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        System.out.println();

        quickSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    }

}
