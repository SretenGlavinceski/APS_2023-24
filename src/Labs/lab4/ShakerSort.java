package Labs.lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShakerSort {

    public static void main(String[] args) throws IOException {
        int i;
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String[] pom = s.split(" ");
        int[] a = new int[n];
        for (i = 0; i < n; i++)
            a[i] = Integer.parseInt(pom[i]);
        shakerSort(a, n);
    }

    static void displayArray(int[] array) {
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }

    static void shakerSort(int[] a, int n) {

        int start = 0, end = a.length - 1;

        for (int i = 0; i < a.length; i++) {

            boolean swapped = false;

            for (int j = end; j > start; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    swapped = true;
                }
            }

            start++;

            displayArray(a);

            for (int j = start; j < end; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }

            end--;

            displayArray(a);

            if (!swapped)
                break;
        }

    }

}
