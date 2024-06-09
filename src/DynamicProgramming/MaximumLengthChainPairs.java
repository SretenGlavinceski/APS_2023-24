package DynamicProgramming;


import java.util.*;

// Problem is:
// https://www.geeksforgeeks.org/maximum-length-chain-of-pairs-dp-20/

public class MaximumLengthChainPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> pairs = new TreeMap<>();
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++)
            pairs.put(scanner.nextInt(), scanner.nextInt());

        int[] memo = new int[n];
        Arrays.fill(memo, 1);

        List<Integer> keys = pairs.keySet().stream().toList();
        int max = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++)
                if (keys.get(i) > pairs.get(keys.get(j)))
                    memo[i] = Math.max(memo[j] + 1, memo[i]);

            max = Math.max(memo[i], max);
        }

        System.out.println(max);
    }
}

// test case

//  input 5
//  5 24
//  15 28
//  27 40
//  41 50
//  51 90
//  4

// output: 4