package DynamicProgramming;

import java.util.Scanner;

public class LongestCommonSubsequence {
    static int lcs(String string1, String string2, int i, int j, int[][] memo) {
        if (i == string1.length() || j == string2.length())
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (string1.charAt(i) == string2.charAt(j)) {
            memo[i][j] = 1 + lcs(string1, string2, i + 1, j + 1, memo);
            return memo[i][j];
        }

        memo[i][j] = Math.max(
                lcs(string1, string2, i + 1, j, memo),
                lcs(string1, string2, i, j + 1, memo)
        );

        return memo[i][j];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.next();
        String string2 = scanner.next();

        int[][] memo = new int[string1.length() + 1][string2.length() + 1];

        for (int i = 0; i < string1.length() + 1; i++)
            for (int j = 0; j < string2.length() + 1; j++)
                memo[i][j] = -1;

        System.out.println("LCS is: " + lcs(string1, string2, 0, 0, memo));
    }

}
