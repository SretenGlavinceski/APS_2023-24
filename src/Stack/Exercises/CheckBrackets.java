package Stack.Exercises;

import Stack.Stack;
import Stack.LinkedStack;

public class CheckBrackets {

    static boolean correctBrackets(char left, char right) {
        return (left == '{' && right == '}') ||
                (left == '(' && right == ')') ||
                (left == '[' && right == ']');
    }

    static boolean checkBrackets(String string) {
        Stack<Character> stack = new LinkedStack<Character>();

        for (int i = 0; i < string.length(); i++) {
            char curr = string.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                stack.push(curr);
            } else if (curr == ')' || curr == ']' || curr == '}') {
                if (stack.isEmpty())
                    return false;
                if (!correctBrackets(stack.pop(), curr))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String equation1 = "s * (s – a) * (s – b) * (s – c)"; // true
        String equation2 = "s * (s – a) * (s – b * (s – c)"; // false

        System.out.println(checkBrackets(equation1));
        System.out.println(checkBrackets(equation2));
    }
}
