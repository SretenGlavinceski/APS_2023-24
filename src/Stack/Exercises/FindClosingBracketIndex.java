package Stack.Exercises;

import java.util.Scanner;
import java.util.Stack;

// Problem is:
// https://www.geeksforgeeks.org/find-index-closing-bracket-given-opening-bracket-expression/

public class FindClosingBracketIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String equation = scanner.nextLine();

        System.out.println(closingBracketForIndex(equation, scanner.nextInt()));
    }

    private static int closingBracketForIndex(String equation, int index) {
        Stack<Character> stack = new Stack<>();
        stack.push(equation.charAt(index));

        for (int i = index + 1; i < equation.length(); i++) {
            char current = equation.charAt(i);
            if (current == '[')
                stack.push(current);
            else if (current == ']') {
                stack.pop();
                if (stack.isEmpty())
                    return i;
            }
        }

        return -1;
    }
}
