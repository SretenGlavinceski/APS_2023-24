package Stack.Exercises;

import java.util.Stack;

// Problem is:
// https://www.geeksforgeeks.org/convert-infix-expression-to-postfix-expression/

public class InfixToPostfix {

    static int valued(char c) {
        if (c == '^')
            return 3;
        if (c == '*' || c == '/')
            return 2;
        if (c == '+' || c == '-')
            return 1;
        return -1;
    }

    static String result(String equation) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            char current = equation.charAt(i);

            if (current == ' ')
                continue;

            if ((current >= '0' && current <= '9') ||
                    (current >= 'a' && current <= 'z') ||
                    (current >= 'A' && current <= 'Z')) {
                sb.append(current);

            } else if (current == '(') {
                stack.push(current);

            } else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());

                if (!stack.isEmpty())
                    stack.pop();

            } else {
                while (!stack.isEmpty() && valued(current) <= valued(stack.peek()) && stack.peek() != '(')
                    sb.append(stack.pop());

                stack.push(current);
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());

        return sb.toString();
    }

    public static void main(String[] args) {
        String ex1 = "A + B * C + D";
        String ex2 = "((A + B) – C * (D / E)) + F";
        String ex3 = "a + b / c - d * e";

        System.out.println(result(ex1));
        System.out.println(result(ex2));
        System.out.println(result(ex3));
    }
}
