package SortingAlgorithms;

import java.util.Arrays;

public class CountingSort {
    static int [] sort(int[] array) {
        int [] freq = new int[Arrays.stream(array).max().orElse(0) + 1];
        int [] result = new int[array.length];

        for (int num : array)
            freq[num]++;

        int index = 0;
        for (int i = 0; i <= freq.length; i++) {
            int temp = freq[i];
            while (temp > 0) {
                result[index] = i;
                temp--;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] array = {12, 2, 4, 5, 3, 9, 0, 8, 5, 1, 9, 10};

        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
        array = sort(array);
        System.out.println();
        Arrays.stream(array).forEach(i -> System.out.print(i + " "));
    }

}
