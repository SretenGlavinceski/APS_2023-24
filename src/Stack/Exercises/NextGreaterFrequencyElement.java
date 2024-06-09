package Stack.Exercises;

import java.util.*;


// Problem is:
// https://www.geeksforgeeks.org/next-greater-frequency-element/

public class NextGreaterFrequencyElement {

    static int[] NGFE(int[] array) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[array.length];

        Arrays.stream(array).forEach(i -> {
            freqMap.putIfAbsent(i, 0);
            freqMap.computeIfPresent(i, (k, v) -> v + 1);
        });

        for (int i = array.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && freqMap.get(stack.peek()) <= freqMap.get(array[i]))
                stack.pop();

            if (!stack.isEmpty())
                result[i] = stack.peek();
            else
                result[i] = -1;

            stack.push(array[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = scanner.nextInt();

        int [] result = NGFE(array);

        for (int i = 0; i < n; i++)
            System.out.print(result[i] + " ");
    }
}
