package DynamicProgramming;

import java.util.Scanner;

public class Fibonacci {

    static int fib(int n) {
        int [] store = new int[n + 1];

        store[0] = 0;
        store[1] = 1;

        for (int i = 2; i <= n; i++)
            store[i] = store[i - 1] + store[i - 2];

        return store[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.printf("Fibonacci number for value %d is %d", n, fib(n));
    }
}
