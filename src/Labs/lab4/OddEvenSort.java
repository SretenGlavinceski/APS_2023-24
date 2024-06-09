package Labs.lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OddEvenSort {

    static int [] countingSortAscending(int[] array) {
        int [] freq = new int[Arrays.stream(array).max().orElse(0) + 1];
        int [] result = new int[array.length];

        for (int num : array)
            freq[num]++;

        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            int temp = freq[i];
            while (temp > 0) {
                result[index] = i;
                temp--;
                index++;
            }
        }
        return result;
    }

    static int [] countingSortDescending(int[] array) {
        int [] freq = new int[Arrays.stream(array).max().orElse(0) + 1];
        int [] result = new int[array.length];

        for (int num : array)
            freq[num]++;

        int index = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            int temp = freq[i];
            while (temp > 0) {
                result[index] = i;
                temp--;
                index++;
            }
        }
        return result;
    }

    static void oddEvenSort(int[] a, int n) {
        int [] firstHalf = Arrays.stream(a).filter(i -> i % 2 != 0).toArray();
        int [] secondHalf = Arrays.stream(a).filter(i -> i % 2 == 0).toArray();

        firstHalf = countingSortAscending(firstHalf);
        secondHalf = countingSortDescending(secondHalf);

        int index = 0;

        for (int num : firstHalf) a[index++] = num;
        for (int num : secondHalf) a[index++] = num;
    }

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
        oddEvenSort(a, n);
        for (i = 0; i < n - 1; i++)
            System.out.print(a[i] + " ");
        System.out.print(a[i]);
    }
}