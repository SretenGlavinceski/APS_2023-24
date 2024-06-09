package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciRecursive {

    static Map<Integer, Long> memo = new HashMap<>();
    static long fib(int n) {
        if (n <= 1) {
            memo.put(n, (long) n);
            return n;
        }

        if (memo.containsKey(n))
            return memo.get(n);

        long res = fib(n - 1) + fib(n - 2);

        memo.put(n, res);

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        System.out.printf("Fibonacci number for value %d is %d", n, fib(n));

    }

}
