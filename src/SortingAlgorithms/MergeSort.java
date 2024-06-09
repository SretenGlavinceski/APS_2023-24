package SortingAlgorithms;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static <T extends Comparable<? super T>> void merge(T[] a, int l, int mid, int r) {
        int numel = r - l + 1;
        // nova niza za privremeno cuvanje
        // na sortiranite elementi
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Comparable[a.length];

        int i = l, j = mid + 1, k = 0;

        while ((i <= mid) && (j <= r)) {
            if (a[i].compareTo(a[j]) < 0) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = a[j];
            j++;
            k++;
        }

        for (k = 0; k < numel; k++) {
            a[l + k] = temp[k];
        }
    }

    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    static final Random random = new Random();
    public static void main(String[] args) {
        Integer [] array = new Integer[100000];

        for (int i = 0; i < 100000; i++)
            array[i] = random.nextInt(1000);

        mergeSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(System.out::println);
    }

}
