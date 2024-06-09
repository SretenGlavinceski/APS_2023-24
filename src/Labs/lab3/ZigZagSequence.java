package Labs.lab3;

import java.util.Scanner;

public class ZigZagSequence {

    static int longestZigZag(int[] array) {

        int temp = array[0];
        int current = 1;
        int max = 1;

        for (int i = 1; i < array.length; i++) {
            if ((array[i] <= 0 && temp <= 0) || (array[i] >= 0 && temp >= 0))
                current = 1;
            else
                current++;

            temp = array[i];
            max = Math.max(current, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        System.out.println(longestZigZag(array));
    }
}
