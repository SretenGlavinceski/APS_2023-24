import java.util.Arrays;
import java.util.Scanner;

public class OddRepeats {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        int [] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
    }

}