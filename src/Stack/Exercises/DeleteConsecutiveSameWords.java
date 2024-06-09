package Stack.Exercises;

import java.util.Scanner;
import java.util.Stack;

public class DeleteConsecutiveSameWords {

    static int removeSameWords(String[] words) {
        Stack<String> stack = new Stack<>();
        stack.push(words[words.length - 1]);

        for (int i = words.length - 2; i >= 0; i--) {
            if (words[i].equals(stack.peek())) {
                stack.pop();
            } else stack.push(words[i]);
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++)
            words[i] = scanner.next();

        System.out.println("After removing: " + removeSameWords(words));
    }

}
