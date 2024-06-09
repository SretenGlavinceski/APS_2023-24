package SortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

// we suppose it is sorted

public class BinarySearch {
    static boolean binarySearch(int [] array, int value) {
        int middle = array.length / 2;

        if (array.length == 0)
            return false;

        if (array[middle] == value)
            return true;
        else if (value < array[middle])
            return binarySearch(Arrays.copyOfRange(array, 0, middle), value);
        else
            return binarySearch(Arrays.copyOfRange(array, middle + 1, array.length), value);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        System.out.println(binarySearch(array, scanner.nextInt()));
    }

}
